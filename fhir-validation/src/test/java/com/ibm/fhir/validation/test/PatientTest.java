/*
 * (C) Copyright IBM Corp. 2019, 2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.ibm.fhir.validation.test;

import static com.ibm.fhir.model.type.String.string;
import static org.testng.Assert.fail;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.testng.annotations.Test;

import com.ibm.fhir.model.resource.OperationOutcome.Issue;
import com.ibm.fhir.model.resource.Patient;
import com.ibm.fhir.model.resource.Patient.Communication;
import com.ibm.fhir.model.resource.Patient.Contact;
import com.ibm.fhir.model.resource.Resource;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.Date;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.HumanName;
import com.ibm.fhir.model.type.Id;
import com.ibm.fhir.model.type.Instant;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.Xhtml;
import com.ibm.fhir.model.type.code.IssueSeverity;
import com.ibm.fhir.model.type.code.NarrativeStatus;
import com.ibm.fhir.validation.FHIRValidator;

/**
 * Demonstrates the Creation of a Patient and Subsequent validation against the specification.
 * 
 * Further, shows how to add ID/META inline.
 * 
 * @author pbastide
 *
 */
public class PatientTest {

    @Test
    public void testValidPatient() {
        Patient p = buildTestPatient();
        checkForIssuesWithValidation(p, false, false);
    }

    @Test
    public void testUnknownExtensions() {
        com.ibm.fhir.model.type.String given =
                com.ibm.fhir.model.type.String.builder().value("John").extension(Extension.builder().url("http://www.ibm.com/someExtension").value(string("value and extension")).build()).build();
        com.ibm.fhir.model.type.String otherGiven =
                com.ibm.fhir.model.type.String.builder().extension(Extension.builder().url("http://www.ibm.com/someExtension").value(string("extension only")).build()).build();
        HumanName name =
                HumanName.builder().id("someId").given(given).given(otherGiven).given(string("value no extension")).family(string("Doe")).build();

        Patient p = buildTestPatient().toBuilder().name(name).build();
        checkForIssuesWithValidation(p, false, true);
    }

    @Test
    public void testWarningFromExtensibleBindingOnBaseField() {
        CodeableConcept maritalStatus =
                CodeableConcept.builder().coding(Coding.builder().system(Uri.of("http://terminology.hl7.org/CodeSystem/v3-MaritalStatus")).code(Code.of("INVALID")).build()).build();
        Patient p = buildTestPatient().toBuilder().maritalStatus(maritalStatus).build();
        checkForIssuesWithValidation(p, false, true);
    }

    @Test
    public void testWarningFromExtensibleBindingOnSubField() {
        CodeableConcept relationship =
                CodeableConcept.builder().coding(Coding.builder().system(Uri.of("http://terminology.hl7.org/CodeSystem/INVALID")).code(Code.of("C")).build()).build();
        Contact contact =
                Contact.builder().name(HumanName.builder().text(com.ibm.fhir.model.type.String.of("Name")).build()).relationship(relationship).build();
        Patient p = buildTestPatient().toBuilder().contact(Collections.singleton(contact)).build();
        checkForIssuesWithValidation(p, false, true);
    }

    @Test
    public void testWarningFromPreferredBinding() {
        CodeableConcept language = CodeableConcept.builder().coding(Coding.builder().system(Uri.of("urn:ietf:bcp:47")).code(Code.of("tlh")).build()).build();
        Communication communication = Communication.builder().language(language).build();
        Patient p = buildTestPatient().toBuilder().communication(Collections.singleton(communication)).build();
        checkForIssuesWithValidation(p, false, true);
    }

    @Test
    public void testExceptionFromRequiredBinding() {
        try {
            CodeableConcept language =
                    CodeableConcept.builder().coding(Coding.builder().system(Uri.of("urn:ietf:bcp:47")).code(Code.of("completelyInvalid")).build()).build();
            Communication.builder().language(language).build();
            fail();
        } catch (IllegalStateException e) {
        }
    }

    /**
     * Builds a valid Patient.
     * 
     * @return a valid Patient
     */
    public static Patient buildTestPatient() {
        String id = UUID.randomUUID().toString();

        Meta meta =
                Meta.builder().versionId(Id.of("1")).lastUpdated(Instant.now(ZoneOffset.UTC)).build();

        java.lang.String uUID = UUID.randomUUID().toString();

        Reference providerRef =
                Reference.builder().reference(string("urn:uuid:" + uUID)).build();

        CodeableConcept maritalStatus =
                CodeableConcept.builder().coding(Coding.builder().system(Uri.of("http://terminology.hl7.org/CodeSystem/v3-MaritalStatus")).code(Code.of("M")).build()).build();

        CodeableConcept relationship =
                CodeableConcept.builder().coding(Coding.builder().system(Uri.of("http://terminology.hl7.org/CodeSystem/v2-0131")).code(Code.of("C")).build()).build();
        Contact contact =
                Contact.builder().name(HumanName.builder().text(com.ibm.fhir.model.type.String.of("Name")).build()).relationship(relationship).build();

        CodeableConcept language = CodeableConcept.builder().coding(Coding.builder().system(Uri.of("urn:ietf:bcp:47")).code(Code.of("en-US")).build()).build();
        Communication communication = Communication.builder().language(language).build();

        return Patient.builder().id(id).active(com.ibm.fhir.model.type.Boolean.TRUE).multipleBirth(com.ibm.fhir.model.type.Integer.of(2)).meta(meta).birthDate(Date.of(LocalDate.now())).maritalStatus(maritalStatus).contact(contact).communication(communication).generalPractitioner(providerRef).text(Narrative.builder().div(Xhtml.of("<div xmlns=\"http://www.w3.org/1999/xhtml\">loaded from the datastore</div>")).status(NarrativeStatus.GENERATED).build()).build();
    }

    /**
     * Checks for validation issues.
     * 
     * @param resource
     *            the resource
     * @param errorsExpected
     *            true or false
     * @param warningsExpected
     *            true or false
     */
    private static void checkForIssuesWithValidation(Resource resource, boolean errorsExpected, boolean warningsExpected) {

        List<Issue> issues = Collections.emptyList();
        try {
            issues = FHIRValidator.validator().validate(resource);
        } catch (Exception e) {
            fail("Unable to validate the resource");
        }

        if (!issues.isEmpty()) {
            System.out.println("Printing Issue with Validation");
            int nonWarning = 0;
            int allOtherIssues = 0;
            for (Issue issue : issues) {
                if (IssueSeverity.ERROR.getValue().compareTo(issue.getSeverity().getValue()) == 0
                        || IssueSeverity.FATAL.getValue().compareTo(issue.getSeverity().getValue()) == 0) {
                    nonWarning++;
                } else {
                    allOtherIssues++;
                }
                System.out.println("level: " + issue.getSeverity().getValue() + ", details: "
                        + issue.getDetails().getText().getValue() + ", expression: "
                        + issue.getExpression().get(0).getValue());
            }

            System.out.println("count = [" + issues.size() + "]");

            if (errorsExpected != (nonWarning > 0)) {
                fail("Fail on Errors " + nonWarning);
            }

            if (warningsExpected != (allOtherIssues > 0)) {
                fail("Fail on Warnings " + allOtherIssues);
            }
        } else {
            System.out.println("Passed with no issues in validation");
        }
    }
}
