/*
 * (C) Copyright IBM Corp. 2019, 2020
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.model.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;

import com.ibm.fhir.model.annotation.Binding;
import com.ibm.fhir.model.annotation.Choice;
import com.ibm.fhir.model.annotation.Constraint;
import com.ibm.fhir.model.annotation.ReferenceTarget;
import com.ibm.fhir.model.annotation.Required;
import com.ibm.fhir.model.annotation.Summary;
import com.ibm.fhir.model.type.Address;
import com.ibm.fhir.model.type.Attachment;
import com.ibm.fhir.model.type.BackboneElement;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Date;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Decimal;
import com.ibm.fhir.model.type.Element;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Money;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Period;
import com.ibm.fhir.model.type.PositiveInt;
import com.ibm.fhir.model.type.Quantity;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.SimpleQuantity;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.code.BindingStrength;
import com.ibm.fhir.model.type.code.ClaimStatus;
import com.ibm.fhir.model.type.code.Use;
import com.ibm.fhir.model.util.ValidationSupport;
import com.ibm.fhir.model.visitor.Visitor;

/**
 * A provider issued list of professional services and products which have been provided, or are to be provided, to a 
 * patient which is sent to an insurer for reimbursement.
 */
@Constraint(
    id = "claim-0",
    level = "Warning",
    location = "(base)",
    description = "SHALL, if possible, at least contain a code from value set http://hl7.org/fhir/ValueSet/claim-type",
    expression = "type.exists() and type.memberOf('http://hl7.org/fhir/ValueSet/claim-type', 'extensible')"
)
@Constraint(
    id = "claim-1",
    level = "Warning",
    location = "accident.type",
    description = "SHALL, if possible, at least contain a code from value set http://terminology.hl7.org/ValueSet/v3-ActIncidentCode",
    expression = "$this.memberOf('http://terminology.hl7.org/ValueSet/v3-ActIncidentCode', 'extensible')"
)
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class Claim extends DomainResource {
    private final List<Identifier> identifier;
    @Summary
    @Binding(
        bindingName = "ClaimStatus",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "A code specifying the state of the resource instance.",
        valueSet = "http://hl7.org/fhir/ValueSet/fm-status|4.0.1"
    )
    @Required
    private final ClaimStatus status;
    @Summary
    @Binding(
        bindingName = "ClaimType",
        strength = BindingStrength.ValueSet.EXTENSIBLE,
        description = "The type or discipline-style of the claim.",
        valueSet = "http://hl7.org/fhir/ValueSet/claim-type"
    )
    @Required
    private final CodeableConcept type;
    @Binding(
        bindingName = "ClaimSubType",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "A more granular claim typecode.",
        valueSet = "http://hl7.org/fhir/ValueSet/claim-subtype"
    )
    private final CodeableConcept subType;
    @Summary
    @Binding(
        bindingName = "Use",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "The purpose of the Claim: predetermination, preauthorization, claim.",
        valueSet = "http://hl7.org/fhir/ValueSet/claim-use|4.0.1"
    )
    @Required
    private final Use use;
    @Summary
    @ReferenceTarget({ "Patient" })
    @Required
    private final Reference patient;
    @Summary
    private final Period billablePeriod;
    @Summary
    @Required
    private final DateTime created;
    @ReferenceTarget({ "Practitioner", "PractitionerRole" })
    private final Reference enterer;
    @Summary
    @ReferenceTarget({ "Organization" })
    private final Reference insurer;
    @Summary
    @ReferenceTarget({ "Practitioner", "PractitionerRole", "Organization" })
    @Required
    private final Reference provider;
    @Summary
    @Binding(
        bindingName = "ProcessPriority",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "The timeliness with which processing is required: stat, normal, deferred.",
        valueSet = "http://hl7.org/fhir/ValueSet/process-priority"
    )
    @Required
    private final CodeableConcept priority;
    @Binding(
        bindingName = "FundsReserve",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "For whom funds are to be reserved: (Patient, Provider, None).",
        valueSet = "http://hl7.org/fhir/ValueSet/fundsreserve"
    )
    private final CodeableConcept fundsReserve;
    private final List<Related> related;
    @ReferenceTarget({ "DeviceRequest", "MedicationRequest", "VisionPrescription" })
    private final Reference prescription;
    @ReferenceTarget({ "DeviceRequest", "MedicationRequest", "VisionPrescription" })
    private final Reference originalPrescription;
    private final Payee payee;
    @ReferenceTarget({ "ServiceRequest" })
    private final Reference referral;
    @ReferenceTarget({ "Location" })
    private final Reference facility;
    private final List<CareTeam> careTeam;
    private final List<SupportingInfo> supportingInfo;
    private final List<Diagnosis> diagnosis;
    private final List<Procedure> procedure;
    @Summary
    @Required
    private final List<Insurance> insurance;
    private final Accident accident;
    private final List<Item> item;
    private final Money total;

    private volatile int hashCode;

    private Claim(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        status = ValidationSupport.requireNonNull(builder.status, "status");
        type = ValidationSupport.requireNonNull(builder.type, "type");
        subType = builder.subType;
        use = ValidationSupport.requireNonNull(builder.use, "use");
        patient = ValidationSupport.requireNonNull(builder.patient, "patient");
        billablePeriod = builder.billablePeriod;
        created = ValidationSupport.requireNonNull(builder.created, "created");
        enterer = builder.enterer;
        insurer = builder.insurer;
        provider = ValidationSupport.requireNonNull(builder.provider, "provider");
        priority = ValidationSupport.requireNonNull(builder.priority, "priority");
        fundsReserve = builder.fundsReserve;
        related = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.related, "related"));
        prescription = builder.prescription;
        originalPrescription = builder.originalPrescription;
        payee = builder.payee;
        referral = builder.referral;
        facility = builder.facility;
        careTeam = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.careTeam, "careTeam"));
        supportingInfo = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.supportingInfo, "supportingInfo"));
        diagnosis = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.diagnosis, "diagnosis"));
        procedure = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.procedure, "procedure"));
        insurance = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.insurance, "insurance"));
        accident = builder.accident;
        item = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.item, "item"));
        total = builder.total;
        ValidationSupport.checkReferenceType(patient, "patient", "Patient");
        ValidationSupport.checkReferenceType(enterer, "enterer", "Practitioner", "PractitionerRole");
        ValidationSupport.checkReferenceType(insurer, "insurer", "Organization");
        ValidationSupport.checkReferenceType(provider, "provider", "Practitioner", "PractitionerRole", "Organization");
        ValidationSupport.checkReferenceType(prescription, "prescription", "DeviceRequest", "MedicationRequest", "VisionPrescription");
        ValidationSupport.checkReferenceType(originalPrescription, "originalPrescription", "DeviceRequest", "MedicationRequest", "VisionPrescription");
        ValidationSupport.checkReferenceType(referral, "referral", "ServiceRequest");
        ValidationSupport.checkReferenceType(facility, "facility", "Location");
        ValidationSupport.requireChildren(this);
    }

    /**
     * A unique identifier assigned to this claim.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier} that may be empty.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * The status of the resource instance.
     * 
     * @return
     *     An immutable object of type {@link ClaimStatus} that is non-null.
     */
    public ClaimStatus getStatus() {
        return status;
    }

    /**
     * The category of claim, e.g. oral, pharmacy, vision, institutional, professional.
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept} that is non-null.
     */
    public CodeableConcept getType() {
        return type;
    }

    /**
     * A finer grained suite of claim type codes which may convey additional information such as Inpatient vs Outpatient 
     * and/or a specialty service.
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept} that may be null.
     */
    public CodeableConcept getSubType() {
        return subType;
    }

    /**
     * A code to indicate whether the nature of the request is: to request adjudication of products and services previously 
     * rendered; or requesting authorization and adjudication for provision in the future; or requesting the non-binding 
     * adjudication of the listed products and services which could be provided in the future.
     * 
     * @return
     *     An immutable object of type {@link Use} that is non-null.
     */
    public Use getUse() {
        return use;
    }

    /**
     * The party to whom the professional services and/or products have been supplied or are being considered and for whom 
     * actual or forecast reimbursement is sought.
     * 
     * @return
     *     An immutable object of type {@link Reference} that is non-null.
     */
    public Reference getPatient() {
        return patient;
    }

    /**
     * The period for which charges are being submitted.
     * 
     * @return
     *     An immutable object of type {@link Period} that may be null.
     */
    public Period getBillablePeriod() {
        return billablePeriod;
    }

    /**
     * The date this resource was created.
     * 
     * @return
     *     An immutable object of type {@link DateTime} that is non-null.
     */
    public DateTime getCreated() {
        return created;
    }

    /**
     * Individual who created the claim, predetermination or preauthorization.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getEnterer() {
        return enterer;
    }

    /**
     * The Insurer who is target of the request.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getInsurer() {
        return insurer;
    }

    /**
     * The provider which is responsible for the claim, predetermination or preauthorization.
     * 
     * @return
     *     An immutable object of type {@link Reference} that is non-null.
     */
    public Reference getProvider() {
        return provider;
    }

    /**
     * The provider-required urgency of processing the request. Typical values include: stat, routine deferred.
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept} that is non-null.
     */
    public CodeableConcept getPriority() {
        return priority;
    }

    /**
     * A code to indicate whether and for whom funds are to be reserved for future claims.
     * 
     * @return
     *     An immutable object of type {@link CodeableConcept} that may be null.
     */
    public CodeableConcept getFundsReserve() {
        return fundsReserve;
    }

    /**
     * Other claims which are related to this claim such as prior submissions or claims for related services or for the same 
     * event.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Related} that may be empty.
     */
    public List<Related> getRelated() {
        return related;
    }

    /**
     * Prescription to support the dispensing of pharmacy, device or vision products.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getPrescription() {
        return prescription;
    }

    /**
     * Original prescription which has been superseded by this prescription to support the dispensing of pharmacy services, 
     * medications or products.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getOriginalPrescription() {
        return originalPrescription;
    }

    /**
     * The party to be reimbursed for cost of the products and services according to the terms of the policy.
     * 
     * @return
     *     An immutable object of type {@link Payee} that may be null.
     */
    public Payee getPayee() {
        return payee;
    }

    /**
     * A reference to a referral resource.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getReferral() {
        return referral;
    }

    /**
     * Facility where the services were provided.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getFacility() {
        return facility;
    }

    /**
     * The members of the team who provided the products and services.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CareTeam} that may be empty.
     */
    public List<CareTeam> getCareTeam() {
        return careTeam;
    }

    /**
     * Additional information codes regarding exceptions, special considerations, the condition, situation, prior or 
     * concurrent issues.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link SupportingInfo} that may be empty.
     */
    public List<SupportingInfo> getSupportingInfo() {
        return supportingInfo;
    }

    /**
     * Information about diagnoses relevant to the claim items.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Diagnosis} that may be empty.
     */
    public List<Diagnosis> getDiagnosis() {
        return diagnosis;
    }

    /**
     * Procedures performed on the patient relevant to the billing items with the claim.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Procedure} that may be empty.
     */
    public List<Procedure> getProcedure() {
        return procedure;
    }

    /**
     * Financial instruments for reimbursement for the health care products and services specified on the claim.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Insurance} that is non-empty.
     */
    public List<Insurance> getInsurance() {
        return insurance;
    }

    /**
     * Details of an accident which resulted in injuries which required the products and services listed in the claim.
     * 
     * @return
     *     An immutable object of type {@link Accident} that may be null.
     */
    public Accident getAccident() {
        return accident;
    }

    /**
     * A claim line. Either a simple product or service or a 'group' of details which can each be a simple items or groups of 
     * sub-details.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Item} that may be empty.
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     * The total value of the all the items in the claim.
     * 
     * @return
     *     An immutable object of type {@link Money} that may be null.
     */
    public Money getTotal() {
        return total;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            !identifier.isEmpty() || 
            (status != null) || 
            (type != null) || 
            (subType != null) || 
            (use != null) || 
            (patient != null) || 
            (billablePeriod != null) || 
            (created != null) || 
            (enterer != null) || 
            (insurer != null) || 
            (provider != null) || 
            (priority != null) || 
            (fundsReserve != null) || 
            !related.isEmpty() || 
            (prescription != null) || 
            (originalPrescription != null) || 
            (payee != null) || 
            (referral != null) || 
            (facility != null) || 
            !careTeam.isEmpty() || 
            !supportingInfo.isEmpty() || 
            !diagnosis.isEmpty() || 
            !procedure.isEmpty() || 
            !insurance.isEmpty() || 
            (accident != null) || 
            !item.isEmpty() || 
            (total != null);
    }

    @Override
    public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
        if (visitor.preVisit(this)) {
            visitor.visitStart(elementName, elementIndex, this);
            if (visitor.visit(elementName, elementIndex, this)) {
                // visit children
                accept(id, "id", visitor);
                accept(meta, "meta", visitor);
                accept(implicitRules, "implicitRules", visitor);
                accept(language, "language", visitor);
                accept(text, "text", visitor);
                accept(contained, "contained", visitor, Resource.class);
                accept(extension, "extension", visitor, Extension.class);
                accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                accept(identifier, "identifier", visitor, Identifier.class);
                accept(status, "status", visitor);
                accept(type, "type", visitor);
                accept(subType, "subType", visitor);
                accept(use, "use", visitor);
                accept(patient, "patient", visitor);
                accept(billablePeriod, "billablePeriod", visitor);
                accept(created, "created", visitor);
                accept(enterer, "enterer", visitor);
                accept(insurer, "insurer", visitor);
                accept(provider, "provider", visitor);
                accept(priority, "priority", visitor);
                accept(fundsReserve, "fundsReserve", visitor);
                accept(related, "related", visitor, Related.class);
                accept(prescription, "prescription", visitor);
                accept(originalPrescription, "originalPrescription", visitor);
                accept(payee, "payee", visitor);
                accept(referral, "referral", visitor);
                accept(facility, "facility", visitor);
                accept(careTeam, "careTeam", visitor, CareTeam.class);
                accept(supportingInfo, "supportingInfo", visitor, SupportingInfo.class);
                accept(diagnosis, "diagnosis", visitor, Diagnosis.class);
                accept(procedure, "procedure", visitor, Procedure.class);
                accept(insurance, "insurance", visitor, Insurance.class);
                accept(accident, "accident", visitor);
                accept(item, "item", visitor, Item.class);
                accept(total, "total", visitor);
            }
            visitor.visitEnd(elementName, elementIndex, this);
            visitor.postVisit(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Claim other = (Claim) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(meta, other.meta) && 
            Objects.equals(implicitRules, other.implicitRules) && 
            Objects.equals(language, other.language) && 
            Objects.equals(text, other.text) && 
            Objects.equals(contained, other.contained) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(identifier, other.identifier) && 
            Objects.equals(status, other.status) && 
            Objects.equals(type, other.type) && 
            Objects.equals(subType, other.subType) && 
            Objects.equals(use, other.use) && 
            Objects.equals(patient, other.patient) && 
            Objects.equals(billablePeriod, other.billablePeriod) && 
            Objects.equals(created, other.created) && 
            Objects.equals(enterer, other.enterer) && 
            Objects.equals(insurer, other.insurer) && 
            Objects.equals(provider, other.provider) && 
            Objects.equals(priority, other.priority) && 
            Objects.equals(fundsReserve, other.fundsReserve) && 
            Objects.equals(related, other.related) && 
            Objects.equals(prescription, other.prescription) && 
            Objects.equals(originalPrescription, other.originalPrescription) && 
            Objects.equals(payee, other.payee) && 
            Objects.equals(referral, other.referral) && 
            Objects.equals(facility, other.facility) && 
            Objects.equals(careTeam, other.careTeam) && 
            Objects.equals(supportingInfo, other.supportingInfo) && 
            Objects.equals(diagnosis, other.diagnosis) && 
            Objects.equals(procedure, other.procedure) && 
            Objects.equals(insurance, other.insurance) && 
            Objects.equals(accident, other.accident) && 
            Objects.equals(item, other.item) && 
            Objects.equals(total, other.total);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Objects.hash(id, 
                meta, 
                implicitRules, 
                language, 
                text, 
                contained, 
                extension, 
                modifierExtension, 
                identifier, 
                status, 
                type, 
                subType, 
                use, 
                patient, 
                billablePeriod, 
                created, 
                enterer, 
                insurer, 
                provider, 
                priority, 
                fundsReserve, 
                related, 
                prescription, 
                originalPrescription, 
                payee, 
                referral, 
                facility, 
                careTeam, 
                supportingInfo, 
                diagnosis, 
                procedure, 
                insurance, 
                accident, 
                item, 
                total);
            hashCode = result;
        }
        return result;
    }

    @Override
    public Builder toBuilder() {
        return new Builder().from(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends DomainResource.Builder {
        private List<Identifier> identifier = new ArrayList<>();
        private ClaimStatus status;
        private CodeableConcept type;
        private CodeableConcept subType;
        private Use use;
        private Reference patient;
        private Period billablePeriod;
        private DateTime created;
        private Reference enterer;
        private Reference insurer;
        private Reference provider;
        private CodeableConcept priority;
        private CodeableConcept fundsReserve;
        private List<Related> related = new ArrayList<>();
        private Reference prescription;
        private Reference originalPrescription;
        private Payee payee;
        private Reference referral;
        private Reference facility;
        private List<CareTeam> careTeam = new ArrayList<>();
        private List<SupportingInfo> supportingInfo = new ArrayList<>();
        private List<Diagnosis> diagnosis = new ArrayList<>();
        private List<Procedure> procedure = new ArrayList<>();
        private List<Insurance> insurance = new ArrayList<>();
        private Accident accident;
        private List<Item> item = new ArrayList<>();
        private Money total;

        private Builder() {
            super();
        }

        /**
         * The logical id of the resource, as used in the URL for the resource. Once assigned, this value never changes.
         * 
         * @param id
         *     Logical id of this artifact
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder id(java.lang.String id) {
            return (Builder) super.id(id);
        }

        /**
         * The metadata about the resource. This is content that is maintained by the infrastructure. Changes to the content 
         * might not always be associated with version changes to the resource.
         * 
         * @param meta
         *     Metadata about the resource
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder meta(Meta meta) {
            return (Builder) super.meta(meta);
        }

        /**
         * A reference to a set of rules that were followed when the resource was constructed, and which must be understood when 
         * processing the content. Often, this is a reference to an implementation guide that defines the special rules along 
         * with other profiles etc.
         * 
         * @param implicitRules
         *     A set of rules under which this content was created
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder implicitRules(Uri implicitRules) {
            return (Builder) super.implicitRules(implicitRules);
        }

        /**
         * The base language in which the resource is written.
         * 
         * @param language
         *     Language of the resource content
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder language(Code language) {
            return (Builder) super.language(language);
        }

        /**
         * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the 
         * resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient 
         * detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what 
         * content should be represented in the narrative to ensure clinical safety.
         * 
         * @param text
         *     Text summary of the resource, for human interpretation
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder text(Narrative text) {
            return (Builder) super.text(text);
        }

        /**
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder contained(Resource... contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * These resources do not have an independent existence apart from the resource that contains them - they cannot be 
         * identified independently, and nor can they have their own independent transaction scope.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param contained
         *     Contained, inline Resources
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder contained(Collection<Resource> contained) {
            return (Builder) super.contained(contained);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Extension... extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource. To make the 
         * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
         * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
         * of the definition of the extension.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param extension
         *     Additional content defined by implementations
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder extension(Collection<Extension> extension) {
            return (Builder) super.extension(extension);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * 
         * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Extension... modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * May be used to represent additional information that is not part of the basic definition of the resource and that 
         * modifies the understanding of the element that contains it and/or the understanding of the containing element's 
         * descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and 
         * manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
         * implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the 
         * definition of the extension. Applications processing a resource are required to check for modifier extensions.
         * 
         * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
         * change the meaning of modifierExtension itself).
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param modifierExtension
         *     Extensions that cannot be ignored
         * 
         * @return
         *     A reference to this Builder instance
         */
        @Override
        public Builder modifierExtension(Collection<Extension> modifierExtension) {
            return (Builder) super.modifierExtension(modifierExtension);
        }

        /**
         * A unique identifier assigned to this claim.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     Business Identifier for claim
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Identifier... identifier) {
            for (Identifier value : identifier) {
                this.identifier.add(value);
            }
            return this;
        }

        /**
         * A unique identifier assigned to this claim.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     Business Identifier for claim
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * The status of the resource instance.
         * 
         * <p>This element is required.
         * 
         * @param status
         *     active | cancelled | draft | entered-in-error
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder status(ClaimStatus status) {
            this.status = status;
            return this;
        }

        /**
         * The category of claim, e.g. oral, pharmacy, vision, institutional, professional.
         * 
         * <p>This element is required.
         * 
         * @param type
         *     Category or discipline
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder type(CodeableConcept type) {
            this.type = type;
            return this;
        }

        /**
         * A finer grained suite of claim type codes which may convey additional information such as Inpatient vs Outpatient 
         * and/or a specialty service.
         * 
         * @param subType
         *     More granular claim type
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder subType(CodeableConcept subType) {
            this.subType = subType;
            return this;
        }

        /**
         * A code to indicate whether the nature of the request is: to request adjudication of products and services previously 
         * rendered; or requesting authorization and adjudication for provision in the future; or requesting the non-binding 
         * adjudication of the listed products and services which could be provided in the future.
         * 
         * <p>This element is required.
         * 
         * @param use
         *     claim | preauthorization | predetermination
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder use(Use use) {
            this.use = use;
            return this;
        }

        /**
         * The party to whom the professional services and/or products have been supplied or are being considered and for whom 
         * actual or forecast reimbursement is sought.
         * 
         * <p>This element is required.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Patient}</li>
         * </ul>
         * 
         * @param patient
         *     The recipient of the products and services
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder patient(Reference patient) {
            this.patient = patient;
            return this;
        }

        /**
         * The period for which charges are being submitted.
         * 
         * @param billablePeriod
         *     Relevant time frame for the claim
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder billablePeriod(Period billablePeriod) {
            this.billablePeriod = billablePeriod;
            return this;
        }

        /**
         * The date this resource was created.
         * 
         * <p>This element is required.
         * 
         * @param created
         *     Resource creation date
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder created(DateTime created) {
            this.created = created;
            return this;
        }

        /**
         * Individual who created the claim, predetermination or preauthorization.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Practitioner}</li>
         * <li>{@link PractitionerRole}</li>
         * </ul>
         * 
         * @param enterer
         *     Author of the claim
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder enterer(Reference enterer) {
            this.enterer = enterer;
            return this;
        }

        /**
         * The Insurer who is target of the request.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Organization}</li>
         * </ul>
         * 
         * @param insurer
         *     Target
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder insurer(Reference insurer) {
            this.insurer = insurer;
            return this;
        }

        /**
         * The provider which is responsible for the claim, predetermination or preauthorization.
         * 
         * <p>This element is required.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Practitioner}</li>
         * <li>{@link PractitionerRole}</li>
         * <li>{@link Organization}</li>
         * </ul>
         * 
         * @param provider
         *     Party responsible for the claim
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder provider(Reference provider) {
            this.provider = provider;
            return this;
        }

        /**
         * The provider-required urgency of processing the request. Typical values include: stat, routine deferred.
         * 
         * <p>This element is required.
         * 
         * @param priority
         *     Desired processing ugency
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder priority(CodeableConcept priority) {
            this.priority = priority;
            return this;
        }

        /**
         * A code to indicate whether and for whom funds are to be reserved for future claims.
         * 
         * @param fundsReserve
         *     For whom to reserve funds
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder fundsReserve(CodeableConcept fundsReserve) {
            this.fundsReserve = fundsReserve;
            return this;
        }

        /**
         * Other claims which are related to this claim such as prior submissions or claims for related services or for the same 
         * event.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param related
         *     Prior or corollary claims
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder related(Related... related) {
            for (Related value : related) {
                this.related.add(value);
            }
            return this;
        }

        /**
         * Other claims which are related to this claim such as prior submissions or claims for related services or for the same 
         * event.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param related
         *     Prior or corollary claims
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder related(Collection<Related> related) {
            this.related = new ArrayList<>(related);
            return this;
        }

        /**
         * Prescription to support the dispensing of pharmacy, device or vision products.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link DeviceRequest}</li>
         * <li>{@link MedicationRequest}</li>
         * <li>{@link VisionPrescription}</li>
         * </ul>
         * 
         * @param prescription
         *     Prescription authorizing services and products
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder prescription(Reference prescription) {
            this.prescription = prescription;
            return this;
        }

        /**
         * Original prescription which has been superseded by this prescription to support the dispensing of pharmacy services, 
         * medications or products.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link DeviceRequest}</li>
         * <li>{@link MedicationRequest}</li>
         * <li>{@link VisionPrescription}</li>
         * </ul>
         * 
         * @param originalPrescription
         *     Original prescription if superseded by fulfiller
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder originalPrescription(Reference originalPrescription) {
            this.originalPrescription = originalPrescription;
            return this;
        }

        /**
         * The party to be reimbursed for cost of the products and services according to the terms of the policy.
         * 
         * @param payee
         *     Recipient of benefits payable
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder payee(Payee payee) {
            this.payee = payee;
            return this;
        }

        /**
         * A reference to a referral resource.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link ServiceRequest}</li>
         * </ul>
         * 
         * @param referral
         *     Treatment referral
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder referral(Reference referral) {
            this.referral = referral;
            return this;
        }

        /**
         * Facility where the services were provided.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Location}</li>
         * </ul>
         * 
         * @param facility
         *     Servicing facility
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder facility(Reference facility) {
            this.facility = facility;
            return this;
        }

        /**
         * The members of the team who provided the products and services.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param careTeam
         *     Members of the care team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder careTeam(CareTeam... careTeam) {
            for (CareTeam value : careTeam) {
                this.careTeam.add(value);
            }
            return this;
        }

        /**
         * The members of the team who provided the products and services.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param careTeam
         *     Members of the care team
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder careTeam(Collection<CareTeam> careTeam) {
            this.careTeam = new ArrayList<>(careTeam);
            return this;
        }

        /**
         * Additional information codes regarding exceptions, special considerations, the condition, situation, prior or 
         * concurrent issues.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param supportingInfo
         *     Supporting information
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder supportingInfo(SupportingInfo... supportingInfo) {
            for (SupportingInfo value : supportingInfo) {
                this.supportingInfo.add(value);
            }
            return this;
        }

        /**
         * Additional information codes regarding exceptions, special considerations, the condition, situation, prior or 
         * concurrent issues.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param supportingInfo
         *     Supporting information
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder supportingInfo(Collection<SupportingInfo> supportingInfo) {
            this.supportingInfo = new ArrayList<>(supportingInfo);
            return this;
        }

        /**
         * Information about diagnoses relevant to the claim items.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param diagnosis
         *     Pertinent diagnosis information
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder diagnosis(Diagnosis... diagnosis) {
            for (Diagnosis value : diagnosis) {
                this.diagnosis.add(value);
            }
            return this;
        }

        /**
         * Information about diagnoses relevant to the claim items.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param diagnosis
         *     Pertinent diagnosis information
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder diagnosis(Collection<Diagnosis> diagnosis) {
            this.diagnosis = new ArrayList<>(diagnosis);
            return this;
        }

        /**
         * Procedures performed on the patient relevant to the billing items with the claim.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param procedure
         *     Clinical procedures performed
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder procedure(Procedure... procedure) {
            for (Procedure value : procedure) {
                this.procedure.add(value);
            }
            return this;
        }

        /**
         * Procedures performed on the patient relevant to the billing items with the claim.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param procedure
         *     Clinical procedures performed
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder procedure(Collection<Procedure> procedure) {
            this.procedure = new ArrayList<>(procedure);
            return this;
        }

        /**
         * Financial instruments for reimbursement for the health care products and services specified on the claim.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * <p>This element is required.
         * 
         * @param insurance
         *     Patient insurance information
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder insurance(Insurance... insurance) {
            for (Insurance value : insurance) {
                this.insurance.add(value);
            }
            return this;
        }

        /**
         * Financial instruments for reimbursement for the health care products and services specified on the claim.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * <p>This element is required.
         * 
         * @param insurance
         *     Patient insurance information
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder insurance(Collection<Insurance> insurance) {
            this.insurance = new ArrayList<>(insurance);
            return this;
        }

        /**
         * Details of an accident which resulted in injuries which required the products and services listed in the claim.
         * 
         * @param accident
         *     Details of the event
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder accident(Accident accident) {
            this.accident = accident;
            return this;
        }

        /**
         * A claim line. Either a simple product or service or a 'group' of details which can each be a simple items or groups of 
         * sub-details.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param item
         *     Product or service provided
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder item(Item... item) {
            for (Item value : item) {
                this.item.add(value);
            }
            return this;
        }

        /**
         * A claim line. Either a simple product or service or a 'group' of details which can each be a simple items or groups of 
         * sub-details.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param item
         *     Product or service provided
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder item(Collection<Item> item) {
            this.item = new ArrayList<>(item);
            return this;
        }

        /**
         * The total value of the all the items in the claim.
         * 
         * @param total
         *     Total claim cost
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder total(Money total) {
            this.total = total;
            return this;
        }

        /**
         * Build the {@link Claim}
         * 
         * <p>Required elements:
         * <ul>
         * <li>status</li>
         * <li>type</li>
         * <li>use</li>
         * <li>patient</li>
         * <li>created</li>
         * <li>provider</li>
         * <li>priority</li>
         * <li>insurance</li>
         * </ul>
         * 
         * @return
         *     An immutable object of type {@link Claim}
         * @throws IllegalStateException
         *     if the current state cannot be built into a valid Claim per the base specification
         */
        @Override
        public Claim build() {
            return new Claim(this);
        }

        protected Builder from(Claim claim) {
            super.from(claim);
            identifier.addAll(claim.identifier);
            status = claim.status;
            type = claim.type;
            subType = claim.subType;
            use = claim.use;
            patient = claim.patient;
            billablePeriod = claim.billablePeriod;
            created = claim.created;
            enterer = claim.enterer;
            insurer = claim.insurer;
            provider = claim.provider;
            priority = claim.priority;
            fundsReserve = claim.fundsReserve;
            related.addAll(claim.related);
            prescription = claim.prescription;
            originalPrescription = claim.originalPrescription;
            payee = claim.payee;
            referral = claim.referral;
            facility = claim.facility;
            careTeam.addAll(claim.careTeam);
            supportingInfo.addAll(claim.supportingInfo);
            diagnosis.addAll(claim.diagnosis);
            procedure.addAll(claim.procedure);
            insurance.addAll(claim.insurance);
            accident = claim.accident;
            item.addAll(claim.item);
            total = claim.total;
            return this;
        }
    }

    /**
     * Other claims which are related to this claim such as prior submissions or claims for related services or for the same 
     * event.
     */
    public static class Related extends BackboneElement {
        @ReferenceTarget({ "Claim" })
        private final Reference claim;
        @Binding(
            bindingName = "RelatedClaimRelationship",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Relationship of this claim to a related Claim.",
            valueSet = "http://hl7.org/fhir/ValueSet/related-claim-relationship"
        )
        private final CodeableConcept relationship;
        private final Identifier reference;

        private volatile int hashCode;

        private Related(Builder builder) {
            super(builder);
            claim = builder.claim;
            relationship = builder.relationship;
            reference = builder.reference;
            ValidationSupport.checkReferenceType(claim, "claim", "Claim");
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * Reference to a related claim.
         * 
         * @return
         *     An immutable object of type {@link Reference} that may be null.
         */
        public Reference getClaim() {
            return claim;
        }

        /**
         * A code to convey how the claims are related.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getRelationship() {
            return relationship;
        }

        /**
         * An alternate organizational reference to the case or file to which this particular claim pertains.
         * 
         * @return
         *     An immutable object of type {@link Identifier} that may be null.
         */
        public Identifier getReference() {
            return reference;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (claim != null) || 
                (relationship != null) || 
                (reference != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(claim, "claim", visitor);
                    accept(relationship, "relationship", visitor);
                    accept(reference, "reference", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Related other = (Related) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(claim, other.claim) && 
                Objects.equals(relationship, other.relationship) && 
                Objects.equals(reference, other.reference);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    claim, 
                    relationship, 
                    reference);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private Reference claim;
            private CodeableConcept relationship;
            private Identifier reference;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * Reference to a related claim.
             * 
             * <p>Allowed resource types for this reference:
             * <ul>
             * <li>{@link Claim}</li>
             * </ul>
             * 
             * @param claim
             *     Reference to the related claim
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder claim(Reference claim) {
                this.claim = claim;
                return this;
            }

            /**
             * A code to convey how the claims are related.
             * 
             * @param relationship
             *     How the reference claim is related
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder relationship(CodeableConcept relationship) {
                this.relationship = relationship;
                return this;
            }

            /**
             * An alternate organizational reference to the case or file to which this particular claim pertains.
             * 
             * @param reference
             *     File or case reference
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder reference(Identifier reference) {
                this.reference = reference;
                return this;
            }

            /**
             * Build the {@link Related}
             * 
             * @return
             *     An immutable object of type {@link Related}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Related per the base specification
             */
            @Override
            public Related build() {
                return new Related(this);
            }

            protected Builder from(Related related) {
                super.from(related);
                claim = related.claim;
                relationship = related.relationship;
                reference = related.reference;
                return this;
            }
        }
    }

    /**
     * The party to be reimbursed for cost of the products and services according to the terms of the policy.
     */
    public static class Payee extends BackboneElement {
        @Binding(
            bindingName = "PayeeType",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "A code for the party to be reimbursed.",
            valueSet = "http://hl7.org/fhir/ValueSet/payeetype"
        )
        @Required
        private final CodeableConcept type;
        @ReferenceTarget({ "Practitioner", "PractitionerRole", "Organization", "Patient", "RelatedPerson" })
        private final Reference party;

        private volatile int hashCode;

        private Payee(Builder builder) {
            super(builder);
            type = ValidationSupport.requireNonNull(builder.type, "type");
            party = builder.party;
            ValidationSupport.checkReferenceType(party, "party", "Practitioner", "PractitionerRole", "Organization", "Patient", "RelatedPerson");
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * Type of Party to be reimbursed: subscriber, provider, other.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that is non-null.
         */
        public CodeableConcept getType() {
            return type;
        }

        /**
         * Reference to the individual or organization to whom any payment will be made.
         * 
         * @return
         *     An immutable object of type {@link Reference} that may be null.
         */
        public Reference getParty() {
            return party;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (type != null) || 
                (party != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(type, "type", visitor);
                    accept(party, "party", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Payee other = (Payee) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(type, other.type) && 
                Objects.equals(party, other.party);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    type, 
                    party);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private CodeableConcept type;
            private Reference party;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * Type of Party to be reimbursed: subscriber, provider, other.
             * 
             * <p>This element is required.
             * 
             * @param type
             *     Category of recipient
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(CodeableConcept type) {
                this.type = type;
                return this;
            }

            /**
             * Reference to the individual or organization to whom any payment will be made.
             * 
             * <p>Allowed resource types for this reference:
             * <ul>
             * <li>{@link Practitioner}</li>
             * <li>{@link PractitionerRole}</li>
             * <li>{@link Organization}</li>
             * <li>{@link Patient}</li>
             * <li>{@link RelatedPerson}</li>
             * </ul>
             * 
             * @param party
             *     Recipient reference
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder party(Reference party) {
                this.party = party;
                return this;
            }

            /**
             * Build the {@link Payee}
             * 
             * <p>Required elements:
             * <ul>
             * <li>type</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Payee}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Payee per the base specification
             */
            @Override
            public Payee build() {
                return new Payee(this);
            }

            protected Builder from(Payee payee) {
                super.from(payee);
                type = payee.type;
                party = payee.party;
                return this;
            }
        }
    }

    /**
     * The members of the team who provided the products and services.
     */
    public static class CareTeam extends BackboneElement {
        @Required
        private final PositiveInt sequence;
        @ReferenceTarget({ "Practitioner", "PractitionerRole", "Organization" })
        @Required
        private final Reference provider;
        private final Boolean responsible;
        @Binding(
            bindingName = "CareTeamRole",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "The role codes for the care team members.",
            valueSet = "http://hl7.org/fhir/ValueSet/claim-careteamrole"
        )
        private final CodeableConcept role;
        @Binding(
            bindingName = "ProviderQualification",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Provider professional qualifications.",
            valueSet = "http://hl7.org/fhir/ValueSet/provider-qualification"
        )
        private final CodeableConcept qualification;

        private volatile int hashCode;

        private CareTeam(Builder builder) {
            super(builder);
            sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
            provider = ValidationSupport.requireNonNull(builder.provider, "provider");
            responsible = builder.responsible;
            role = builder.role;
            qualification = builder.qualification;
            ValidationSupport.checkReferenceType(provider, "provider", "Practitioner", "PractitionerRole", "Organization");
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A number to uniquely identify care team entries.
         * 
         * @return
         *     An immutable object of type {@link PositiveInt} that is non-null.
         */
        public PositiveInt getSequence() {
            return sequence;
        }

        /**
         * Member of the team who provided the product or service.
         * 
         * @return
         *     An immutable object of type {@link Reference} that is non-null.
         */
        public Reference getProvider() {
            return provider;
        }

        /**
         * The party who is billing and/or responsible for the claimed products or services.
         * 
         * @return
         *     An immutable object of type {@link Boolean} that may be null.
         */
        public Boolean getResponsible() {
            return responsible;
        }

        /**
         * The lead, assisting or supervising practitioner and their discipline if a multidisciplinary team.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getRole() {
            return role;
        }

        /**
         * The qualification of the practitioner which is applicable for this service.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getQualification() {
            return qualification;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (sequence != null) || 
                (provider != null) || 
                (responsible != null) || 
                (role != null) || 
                (qualification != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(sequence, "sequence", visitor);
                    accept(provider, "provider", visitor);
                    accept(responsible, "responsible", visitor);
                    accept(role, "role", visitor);
                    accept(qualification, "qualification", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            CareTeam other = (CareTeam) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(sequence, other.sequence) && 
                Objects.equals(provider, other.provider) && 
                Objects.equals(responsible, other.responsible) && 
                Objects.equals(role, other.role) && 
                Objects.equals(qualification, other.qualification);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    sequence, 
                    provider, 
                    responsible, 
                    role, 
                    qualification);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private PositiveInt sequence;
            private Reference provider;
            private Boolean responsible;
            private CodeableConcept role;
            private CodeableConcept qualification;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * A number to uniquely identify care team entries.
             * 
             * <p>This element is required.
             * 
             * @param sequence
             *     Order of care team
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder sequence(PositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * Member of the team who provided the product or service.
             * 
             * <p>This element is required.
             * 
             * <p>Allowed resource types for this reference:
             * <ul>
             * <li>{@link Practitioner}</li>
             * <li>{@link PractitionerRole}</li>
             * <li>{@link Organization}</li>
             * </ul>
             * 
             * @param provider
             *     Practitioner or organization
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder provider(Reference provider) {
                this.provider = provider;
                return this;
            }

            /**
             * The party who is billing and/or responsible for the claimed products or services.
             * 
             * @param responsible
             *     Indicator of the lead practitioner
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder responsible(Boolean responsible) {
                this.responsible = responsible;
                return this;
            }

            /**
             * The lead, assisting or supervising practitioner and their discipline if a multidisciplinary team.
             * 
             * @param role
             *     Function within the team
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder role(CodeableConcept role) {
                this.role = role;
                return this;
            }

            /**
             * The qualification of the practitioner which is applicable for this service.
             * 
             * @param qualification
             *     Practitioner credential or specialization
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder qualification(CodeableConcept qualification) {
                this.qualification = qualification;
                return this;
            }

            /**
             * Build the {@link CareTeam}
             * 
             * <p>Required elements:
             * <ul>
             * <li>sequence</li>
             * <li>provider</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link CareTeam}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid CareTeam per the base specification
             */
            @Override
            public CareTeam build() {
                return new CareTeam(this);
            }

            protected Builder from(CareTeam careTeam) {
                super.from(careTeam);
                sequence = careTeam.sequence;
                provider = careTeam.provider;
                responsible = careTeam.responsible;
                role = careTeam.role;
                qualification = careTeam.qualification;
                return this;
            }
        }
    }

    /**
     * Additional information codes regarding exceptions, special considerations, the condition, situation, prior or 
     * concurrent issues.
     */
    public static class SupportingInfo extends BackboneElement {
        @Required
        private final PositiveInt sequence;
        @Binding(
            bindingName = "InformationCategory",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "The valuset used for additional information category codes.",
            valueSet = "http://hl7.org/fhir/ValueSet/claim-informationcategory"
        )
        @Required
        private final CodeableConcept category;
        @Binding(
            bindingName = "InformationCode",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "The valuset used for additional information codes.",
            valueSet = "http://hl7.org/fhir/ValueSet/claim-exception"
        )
        private final CodeableConcept code;
        @Choice({ Date.class, Period.class })
        private final Element timing;
        @Choice({ Boolean.class, String.class, Quantity.class, Attachment.class, Reference.class })
        private final Element value;
        @Binding(
            bindingName = "MissingReason",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Reason codes for the missing teeth.",
            valueSet = "http://hl7.org/fhir/ValueSet/missing-tooth-reason"
        )
        private final CodeableConcept reason;

        private volatile int hashCode;

        private SupportingInfo(Builder builder) {
            super(builder);
            sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
            category = ValidationSupport.requireNonNull(builder.category, "category");
            code = builder.code;
            timing = ValidationSupport.choiceElement(builder.timing, "timing", Date.class, Period.class);
            value = ValidationSupport.choiceElement(builder.value, "value", Boolean.class, String.class, Quantity.class, Attachment.class, Reference.class);
            reason = builder.reason;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A number to uniquely identify supporting information entries.
         * 
         * @return
         *     An immutable object of type {@link PositiveInt} that is non-null.
         */
        public PositiveInt getSequence() {
            return sequence;
        }

        /**
         * The general class of the information supplied: information; exception; accident, employment; onset, etc.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that is non-null.
         */
        public CodeableConcept getCategory() {
            return category;
        }

        /**
         * System and code pertaining to the specific information regarding special conditions relating to the setting, treatment 
         * or patient for which care is sought.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getCode() {
            return code;
        }

        /**
         * The date when or period to which this information refers.
         * 
         * @return
         *     An immutable object of type {@link Element} that may be null.
         */
        public Element getTiming() {
            return timing;
        }

        /**
         * Additional data or information such as resources, documents, images etc. including references to the data or the 
         * actual inclusion of the data.
         * 
         * @return
         *     An immutable object of type {@link Element} that may be null.
         */
        public Element getValue() {
            return value;
        }

        /**
         * Provides the reason in the situation where a reason code is required in addition to the content.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getReason() {
            return reason;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (sequence != null) || 
                (category != null) || 
                (code != null) || 
                (timing != null) || 
                (value != null) || 
                (reason != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(sequence, "sequence", visitor);
                    accept(category, "category", visitor);
                    accept(code, "code", visitor);
                    accept(timing, "timing", visitor);
                    accept(value, "value", visitor);
                    accept(reason, "reason", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            SupportingInfo other = (SupportingInfo) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(sequence, other.sequence) && 
                Objects.equals(category, other.category) && 
                Objects.equals(code, other.code) && 
                Objects.equals(timing, other.timing) && 
                Objects.equals(value, other.value) && 
                Objects.equals(reason, other.reason);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    sequence, 
                    category, 
                    code, 
                    timing, 
                    value, 
                    reason);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private PositiveInt sequence;
            private CodeableConcept category;
            private CodeableConcept code;
            private Element timing;
            private Element value;
            private CodeableConcept reason;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * A number to uniquely identify supporting information entries.
             * 
             * <p>This element is required.
             * 
             * @param sequence
             *     Information instance identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder sequence(PositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * The general class of the information supplied: information; exception; accident, employment; onset, etc.
             * 
             * <p>This element is required.
             * 
             * @param category
             *     Classification of the supplied information
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder category(CodeableConcept category) {
                this.category = category;
                return this;
            }

            /**
             * System and code pertaining to the specific information regarding special conditions relating to the setting, treatment 
             * or patient for which care is sought.
             * 
             * @param code
             *     Type of information
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder code(CodeableConcept code) {
                this.code = code;
                return this;
            }

            /**
             * The date when or period to which this information refers.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link Date}</li>
             * <li>{@link Period}</li>
             * </ul>
             * 
             * @param timing
             *     When it occurred
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder timing(Element timing) {
                this.timing = timing;
                return this;
            }

            /**
             * Additional data or information such as resources, documents, images etc. including references to the data or the 
             * actual inclusion of the data.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link Boolean}</li>
             * <li>{@link String}</li>
             * <li>{@link Quantity}</li>
             * <li>{@link Attachment}</li>
             * <li>{@link Reference}</li>
             * </ul>
             * 
             * @param value
             *     Data to be provided
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder value(Element value) {
                this.value = value;
                return this;
            }

            /**
             * Provides the reason in the situation where a reason code is required in addition to the content.
             * 
             * @param reason
             *     Explanation for the information
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder reason(CodeableConcept reason) {
                this.reason = reason;
                return this;
            }

            /**
             * Build the {@link SupportingInfo}
             * 
             * <p>Required elements:
             * <ul>
             * <li>sequence</li>
             * <li>category</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link SupportingInfo}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid SupportingInfo per the base specification
             */
            @Override
            public SupportingInfo build() {
                return new SupportingInfo(this);
            }

            protected Builder from(SupportingInfo supportingInfo) {
                super.from(supportingInfo);
                sequence = supportingInfo.sequence;
                category = supportingInfo.category;
                code = supportingInfo.code;
                timing = supportingInfo.timing;
                value = supportingInfo.value;
                reason = supportingInfo.reason;
                return this;
            }
        }
    }

    /**
     * Information about diagnoses relevant to the claim items.
     */
    public static class Diagnosis extends BackboneElement {
        @Required
        private final PositiveInt sequence;
        @Choice({ CodeableConcept.class, Reference.class })
        @Binding(
            bindingName = "ICD10",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Example ICD10 Diagnostic codes.",
            valueSet = "http://hl7.org/fhir/ValueSet/icd-10"
        )
        @Required
        private final Element diagnosis;
        @Binding(
            bindingName = "DiagnosisType",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "The type of the diagnosis: admitting, principal, discharge.",
            valueSet = "http://hl7.org/fhir/ValueSet/ex-diagnosistype"
        )
        private final List<CodeableConcept> type;
        @Binding(
            bindingName = "DiagnosisOnAdmission",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Present on admission.",
            valueSet = "http://hl7.org/fhir/ValueSet/ex-diagnosis-on-admission"
        )
        private final CodeableConcept onAdmission;
        @Binding(
            bindingName = "DiagnosisRelatedGroup",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "The DRG codes associated with the diagnosis.",
            valueSet = "http://hl7.org/fhir/ValueSet/ex-diagnosisrelatedgroup"
        )
        private final CodeableConcept packageCode;

        private volatile int hashCode;

        private Diagnosis(Builder builder) {
            super(builder);
            sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
            diagnosis = ValidationSupport.requireChoiceElement(builder.diagnosis, "diagnosis", CodeableConcept.class, Reference.class);
            type = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.type, "type"));
            onAdmission = builder.onAdmission;
            packageCode = builder.packageCode;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A number to uniquely identify diagnosis entries.
         * 
         * @return
         *     An immutable object of type {@link PositiveInt} that is non-null.
         */
        public PositiveInt getSequence() {
            return sequence;
        }

        /**
         * The nature of illness or problem in a coded form or as a reference to an external defined Condition.
         * 
         * @return
         *     An immutable object of type {@link Element} that is non-null.
         */
        public Element getDiagnosis() {
            return diagnosis;
        }

        /**
         * When the condition was observed or the relative ranking.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
         */
        public List<CodeableConcept> getType() {
            return type;
        }

        /**
         * Indication of whether the diagnosis was present on admission to a facility.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getOnAdmission() {
            return onAdmission;
        }

        /**
         * A package billing code or bundle code used to group products and services to a particular health condition (such as 
         * heart attack) which is based on a predetermined grouping code system.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getPackageCode() {
            return packageCode;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (sequence != null) || 
                (diagnosis != null) || 
                !type.isEmpty() || 
                (onAdmission != null) || 
                (packageCode != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(sequence, "sequence", visitor);
                    accept(diagnosis, "diagnosis", visitor);
                    accept(type, "type", visitor, CodeableConcept.class);
                    accept(onAdmission, "onAdmission", visitor);
                    accept(packageCode, "packageCode", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Diagnosis other = (Diagnosis) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(sequence, other.sequence) && 
                Objects.equals(diagnosis, other.diagnosis) && 
                Objects.equals(type, other.type) && 
                Objects.equals(onAdmission, other.onAdmission) && 
                Objects.equals(packageCode, other.packageCode);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    sequence, 
                    diagnosis, 
                    type, 
                    onAdmission, 
                    packageCode);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private PositiveInt sequence;
            private Element diagnosis;
            private List<CodeableConcept> type = new ArrayList<>();
            private CodeableConcept onAdmission;
            private CodeableConcept packageCode;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * A number to uniquely identify diagnosis entries.
             * 
             * <p>This element is required.
             * 
             * @param sequence
             *     Diagnosis instance identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder sequence(PositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * The nature of illness or problem in a coded form or as a reference to an external defined Condition.
             * 
             * <p>This element is required.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link CodeableConcept}</li>
             * <li>{@link Reference}</li>
             * </ul>
             * 
             * @param diagnosis
             *     Nature of illness or problem
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder diagnosis(Element diagnosis) {
                this.diagnosis = diagnosis;
                return this;
            }

            /**
             * When the condition was observed or the relative ranking.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param type
             *     Timing or nature of the diagnosis
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(CodeableConcept... type) {
                for (CodeableConcept value : type) {
                    this.type.add(value);
                }
                return this;
            }

            /**
             * When the condition was observed or the relative ranking.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param type
             *     Timing or nature of the diagnosis
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(Collection<CodeableConcept> type) {
                this.type = new ArrayList<>(type);
                return this;
            }

            /**
             * Indication of whether the diagnosis was present on admission to a facility.
             * 
             * @param onAdmission
             *     Present on admission
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder onAdmission(CodeableConcept onAdmission) {
                this.onAdmission = onAdmission;
                return this;
            }

            /**
             * A package billing code or bundle code used to group products and services to a particular health condition (such as 
             * heart attack) which is based on a predetermined grouping code system.
             * 
             * @param packageCode
             *     Package billing code
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder packageCode(CodeableConcept packageCode) {
                this.packageCode = packageCode;
                return this;
            }

            /**
             * Build the {@link Diagnosis}
             * 
             * <p>Required elements:
             * <ul>
             * <li>sequence</li>
             * <li>diagnosis</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Diagnosis}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Diagnosis per the base specification
             */
            @Override
            public Diagnosis build() {
                return new Diagnosis(this);
            }

            protected Builder from(Diagnosis diagnosis) {
                super.from(diagnosis);
                sequence = diagnosis.sequence;
                this.diagnosis = diagnosis.diagnosis;
                type.addAll(diagnosis.type);
                onAdmission = diagnosis.onAdmission;
                packageCode = diagnosis.packageCode;
                return this;
            }
        }
    }

    /**
     * Procedures performed on the patient relevant to the billing items with the claim.
     */
    public static class Procedure extends BackboneElement {
        @Required
        private final PositiveInt sequence;
        @Binding(
            bindingName = "ProcedureType",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Example procedure type codes.",
            valueSet = "http://hl7.org/fhir/ValueSet/ex-procedure-type"
        )
        private final List<CodeableConcept> type;
        private final DateTime date;
        @Choice({ CodeableConcept.class, Reference.class })
        @Binding(
            bindingName = "ICD10_Procedures",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Example ICD10 Procedure codes.",
            valueSet = "http://hl7.org/fhir/ValueSet/icd-10-procedures"
        )
        @Required
        private final Element procedure;
        private final List<Reference> udi;

        private volatile int hashCode;

        private Procedure(Builder builder) {
            super(builder);
            sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
            type = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.type, "type"));
            date = builder.date;
            procedure = ValidationSupport.requireChoiceElement(builder.procedure, "procedure", CodeableConcept.class, Reference.class);
            udi = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.udi, "udi"));
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A number to uniquely identify procedure entries.
         * 
         * @return
         *     An immutable object of type {@link PositiveInt} that is non-null.
         */
        public PositiveInt getSequence() {
            return sequence;
        }

        /**
         * When the condition was observed or the relative ranking.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
         */
        public List<CodeableConcept> getType() {
            return type;
        }

        /**
         * Date and optionally time the procedure was performed.
         * 
         * @return
         *     An immutable object of type {@link DateTime} that may be null.
         */
        public DateTime getDate() {
            return date;
        }

        /**
         * The code or reference to a Procedure resource which identifies the clinical intervention performed.
         * 
         * @return
         *     An immutable object of type {@link Element} that is non-null.
         */
        public Element getProcedure() {
            return procedure;
        }

        /**
         * Unique Device Identifiers associated with this line item.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
         */
        public List<Reference> getUdi() {
            return udi;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (sequence != null) || 
                !type.isEmpty() || 
                (date != null) || 
                (procedure != null) || 
                !udi.isEmpty();
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(sequence, "sequence", visitor);
                    accept(type, "type", visitor, CodeableConcept.class);
                    accept(date, "date", visitor);
                    accept(procedure, "procedure", visitor);
                    accept(udi, "udi", visitor, Reference.class);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Procedure other = (Procedure) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(sequence, other.sequence) && 
                Objects.equals(type, other.type) && 
                Objects.equals(date, other.date) && 
                Objects.equals(procedure, other.procedure) && 
                Objects.equals(udi, other.udi);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    sequence, 
                    type, 
                    date, 
                    procedure, 
                    udi);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private PositiveInt sequence;
            private List<CodeableConcept> type = new ArrayList<>();
            private DateTime date;
            private Element procedure;
            private List<Reference> udi = new ArrayList<>();

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * A number to uniquely identify procedure entries.
             * 
             * <p>This element is required.
             * 
             * @param sequence
             *     Procedure instance identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder sequence(PositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * When the condition was observed or the relative ranking.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param type
             *     Category of Procedure
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(CodeableConcept... type) {
                for (CodeableConcept value : type) {
                    this.type.add(value);
                }
                return this;
            }

            /**
             * When the condition was observed or the relative ranking.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param type
             *     Category of Procedure
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(Collection<CodeableConcept> type) {
                this.type = new ArrayList<>(type);
                return this;
            }

            /**
             * Date and optionally time the procedure was performed.
             * 
             * @param date
             *     When the procedure was performed
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder date(DateTime date) {
                this.date = date;
                return this;
            }

            /**
             * The code or reference to a Procedure resource which identifies the clinical intervention performed.
             * 
             * <p>This element is required.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link CodeableConcept}</li>
             * <li>{@link Reference}</li>
             * </ul>
             * 
             * @param procedure
             *     Specific clinical procedure
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder procedure(Element procedure) {
                this.procedure = procedure;
                return this;
            }

            /**
             * Unique Device Identifiers associated with this line item.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param udi
             *     Unique device identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder udi(Reference... udi) {
                for (Reference value : udi) {
                    this.udi.add(value);
                }
                return this;
            }

            /**
             * Unique Device Identifiers associated with this line item.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param udi
             *     Unique device identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder udi(Collection<Reference> udi) {
                this.udi = new ArrayList<>(udi);
                return this;
            }

            /**
             * Build the {@link Procedure}
             * 
             * <p>Required elements:
             * <ul>
             * <li>sequence</li>
             * <li>procedure</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Procedure}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Procedure per the base specification
             */
            @Override
            public Procedure build() {
                return new Procedure(this);
            }

            protected Builder from(Procedure procedure) {
                super.from(procedure);
                sequence = procedure.sequence;
                type.addAll(procedure.type);
                date = procedure.date;
                this.procedure = procedure.procedure;
                udi.addAll(procedure.udi);
                return this;
            }
        }
    }

    /**
     * Financial instruments for reimbursement for the health care products and services specified on the claim.
     */
    public static class Insurance extends BackboneElement {
        @Summary
        @Required
        private final PositiveInt sequence;
        @Summary
        @Required
        private final Boolean focal;
        private final Identifier identifier;
        @Summary
        @ReferenceTarget({ "Coverage" })
        @Required
        private final Reference coverage;
        private final String businessArrangement;
        private final List<String> preAuthRef;
        @ReferenceTarget({ "ClaimResponse" })
        private final Reference claimResponse;

        private volatile int hashCode;

        private Insurance(Builder builder) {
            super(builder);
            sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
            focal = ValidationSupport.requireNonNull(builder.focal, "focal");
            identifier = builder.identifier;
            coverage = ValidationSupport.requireNonNull(builder.coverage, "coverage");
            businessArrangement = builder.businessArrangement;
            preAuthRef = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.preAuthRef, "preAuthRef"));
            claimResponse = builder.claimResponse;
            ValidationSupport.checkReferenceType(coverage, "coverage", "Coverage");
            ValidationSupport.checkReferenceType(claimResponse, "claimResponse", "ClaimResponse");
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A number to uniquely identify insurance entries and provide a sequence of coverages to convey coordination of benefit 
         * order.
         * 
         * @return
         *     An immutable object of type {@link PositiveInt} that is non-null.
         */
        public PositiveInt getSequence() {
            return sequence;
        }

        /**
         * A flag to indicate that this Coverage is to be used for adjudication of this claim when set to true.
         * 
         * @return
         *     An immutable object of type {@link Boolean} that is non-null.
         */
        public Boolean getFocal() {
            return focal;
        }

        /**
         * The business identifier to be used when the claim is sent for adjudication against this insurance policy.
         * 
         * @return
         *     An immutable object of type {@link Identifier} that may be null.
         */
        public Identifier getIdentifier() {
            return identifier;
        }

        /**
         * Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer 
         * will use these details to locate the patient's actual coverage within the insurer's information system.
         * 
         * @return
         *     An immutable object of type {@link Reference} that is non-null.
         */
        public Reference getCoverage() {
            return coverage;
        }

        /**
         * A business agreement number established between the provider and the insurer for special business processing purposes.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getBusinessArrangement() {
            return businessArrangement;
        }

        /**
         * Reference numbers previously provided by the insurer to the provider to be quoted on subsequent claims containing 
         * services or products related to the prior authorization.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link String} that may be empty.
         */
        public List<String> getPreAuthRef() {
            return preAuthRef;
        }

        /**
         * The result of the adjudication of the line items for the Coverage specified in this insurance.
         * 
         * @return
         *     An immutable object of type {@link Reference} that may be null.
         */
        public Reference getClaimResponse() {
            return claimResponse;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (sequence != null) || 
                (focal != null) || 
                (identifier != null) || 
                (coverage != null) || 
                (businessArrangement != null) || 
                !preAuthRef.isEmpty() || 
                (claimResponse != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(sequence, "sequence", visitor);
                    accept(focal, "focal", visitor);
                    accept(identifier, "identifier", visitor);
                    accept(coverage, "coverage", visitor);
                    accept(businessArrangement, "businessArrangement", visitor);
                    accept(preAuthRef, "preAuthRef", visitor, String.class);
                    accept(claimResponse, "claimResponse", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Insurance other = (Insurance) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(sequence, other.sequence) && 
                Objects.equals(focal, other.focal) && 
                Objects.equals(identifier, other.identifier) && 
                Objects.equals(coverage, other.coverage) && 
                Objects.equals(businessArrangement, other.businessArrangement) && 
                Objects.equals(preAuthRef, other.preAuthRef) && 
                Objects.equals(claimResponse, other.claimResponse);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    sequence, 
                    focal, 
                    identifier, 
                    coverage, 
                    businessArrangement, 
                    preAuthRef, 
                    claimResponse);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private PositiveInt sequence;
            private Boolean focal;
            private Identifier identifier;
            private Reference coverage;
            private String businessArrangement;
            private List<String> preAuthRef = new ArrayList<>();
            private Reference claimResponse;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * A number to uniquely identify insurance entries and provide a sequence of coverages to convey coordination of benefit 
             * order.
             * 
             * <p>This element is required.
             * 
             * @param sequence
             *     Insurance instance identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder sequence(PositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * A flag to indicate that this Coverage is to be used for adjudication of this claim when set to true.
             * 
             * <p>This element is required.
             * 
             * @param focal
             *     Coverage to be used for adjudication
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder focal(Boolean focal) {
                this.focal = focal;
                return this;
            }

            /**
             * The business identifier to be used when the claim is sent for adjudication against this insurance policy.
             * 
             * @param identifier
             *     Pre-assigned Claim number
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder identifier(Identifier identifier) {
                this.identifier = identifier;
                return this;
            }

            /**
             * Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer 
             * will use these details to locate the patient's actual coverage within the insurer's information system.
             * 
             * <p>This element is required.
             * 
             * <p>Allowed resource types for this reference:
             * <ul>
             * <li>{@link Coverage}</li>
             * </ul>
             * 
             * @param coverage
             *     Insurance information
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder coverage(Reference coverage) {
                this.coverage = coverage;
                return this;
            }

            /**
             * A business agreement number established between the provider and the insurer for special business processing purposes.
             * 
             * @param businessArrangement
             *     Additional provider contract number
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder businessArrangement(String businessArrangement) {
                this.businessArrangement = businessArrangement;
                return this;
            }

            /**
             * Reference numbers previously provided by the insurer to the provider to be quoted on subsequent claims containing 
             * services or products related to the prior authorization.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param preAuthRef
             *     Prior authorization reference number
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder preAuthRef(String... preAuthRef) {
                for (String value : preAuthRef) {
                    this.preAuthRef.add(value);
                }
                return this;
            }

            /**
             * Reference numbers previously provided by the insurer to the provider to be quoted on subsequent claims containing 
             * services or products related to the prior authorization.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param preAuthRef
             *     Prior authorization reference number
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder preAuthRef(Collection<String> preAuthRef) {
                this.preAuthRef = new ArrayList<>(preAuthRef);
                return this;
            }

            /**
             * The result of the adjudication of the line items for the Coverage specified in this insurance.
             * 
             * <p>Allowed resource types for this reference:
             * <ul>
             * <li>{@link ClaimResponse}</li>
             * </ul>
             * 
             * @param claimResponse
             *     Adjudication results
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder claimResponse(Reference claimResponse) {
                this.claimResponse = claimResponse;
                return this;
            }

            /**
             * Build the {@link Insurance}
             * 
             * <p>Required elements:
             * <ul>
             * <li>sequence</li>
             * <li>focal</li>
             * <li>coverage</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Insurance}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Insurance per the base specification
             */
            @Override
            public Insurance build() {
                return new Insurance(this);
            }

            protected Builder from(Insurance insurance) {
                super.from(insurance);
                sequence = insurance.sequence;
                focal = insurance.focal;
                identifier = insurance.identifier;
                coverage = insurance.coverage;
                businessArrangement = insurance.businessArrangement;
                preAuthRef.addAll(insurance.preAuthRef);
                claimResponse = insurance.claimResponse;
                return this;
            }
        }
    }

    /**
     * Details of an accident which resulted in injuries which required the products and services listed in the claim.
     */
    public static class Accident extends BackboneElement {
        @Required
        private final Date date;
        @Binding(
            bindingName = "AccidentType",
            strength = BindingStrength.ValueSet.EXTENSIBLE,
            description = "Type of accident: work place, auto, etc.",
            valueSet = "http://terminology.hl7.org/ValueSet/v3-ActIncidentCode"
        )
        private final CodeableConcept type;
        @Choice({ Address.class, Reference.class })
        private final Element location;

        private volatile int hashCode;

        private Accident(Builder builder) {
            super(builder);
            date = ValidationSupport.requireNonNull(builder.date, "date");
            type = builder.type;
            location = ValidationSupport.choiceElement(builder.location, "location", Address.class, Reference.class);
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * Date of an accident event related to the products and services contained in the claim.
         * 
         * @return
         *     An immutable object of type {@link Date} that is non-null.
         */
        public Date getDate() {
            return date;
        }

        /**
         * The type or context of the accident event for the purposes of selection of potential insurance coverages and 
         * determination of coordination between insurers.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getType() {
            return type;
        }

        /**
         * The physical location of the accident event.
         * 
         * @return
         *     An immutable object of type {@link Element} that may be null.
         */
        public Element getLocation() {
            return location;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (date != null) || 
                (type != null) || 
                (location != null);
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(date, "date", visitor);
                    accept(type, "type", visitor);
                    accept(location, "location", visitor);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Accident other = (Accident) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(date, other.date) && 
                Objects.equals(type, other.type) && 
                Objects.equals(location, other.location);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    date, 
                    type, 
                    location);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private Date date;
            private CodeableConcept type;
            private Element location;

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * Date of an accident event related to the products and services contained in the claim.
             * 
             * <p>This element is required.
             * 
             * @param date
             *     When the incident occurred
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder date(Date date) {
                this.date = date;
                return this;
            }

            /**
             * The type or context of the accident event for the purposes of selection of potential insurance coverages and 
             * determination of coordination between insurers.
             * 
             * @param type
             *     The nature of the accident
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(CodeableConcept type) {
                this.type = type;
                return this;
            }

            /**
             * The physical location of the accident event.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link Address}</li>
             * <li>{@link Reference}</li>
             * </ul>
             * 
             * @param location
             *     Where the event occurred
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder location(Element location) {
                this.location = location;
                return this;
            }

            /**
             * Build the {@link Accident}
             * 
             * <p>Required elements:
             * <ul>
             * <li>date</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Accident}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Accident per the base specification
             */
            @Override
            public Accident build() {
                return new Accident(this);
            }

            protected Builder from(Accident accident) {
                super.from(accident);
                date = accident.date;
                type = accident.type;
                location = accident.location;
                return this;
            }
        }
    }

    /**
     * A claim line. Either a simple product or service or a 'group' of details which can each be a simple items or groups of 
     * sub-details.
     */
    public static class Item extends BackboneElement {
        @Required
        private final PositiveInt sequence;
        private final List<PositiveInt> careTeamSequence;
        private final List<PositiveInt> diagnosisSequence;
        private final List<PositiveInt> procedureSequence;
        private final List<PositiveInt> informationSequence;
        @Binding(
            bindingName = "RevenueCenter",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Codes for the revenue or cost centers supplying the service and/or products.",
            valueSet = "http://hl7.org/fhir/ValueSet/ex-revenue-center"
        )
        private final CodeableConcept revenue;
        @Binding(
            bindingName = "BenefitCategory",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Benefit categories such as: oral-basic, major, glasses.",
            valueSet = "http://hl7.org/fhir/ValueSet/ex-benefitcategory"
        )
        private final CodeableConcept category;
        @Binding(
            bindingName = "ServiceProduct",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Allowable service and product codes.",
            valueSet = "http://hl7.org/fhir/ValueSet/service-uscls"
        )
        @Required
        private final CodeableConcept productOrService;
        @Binding(
            bindingName = "Modifiers",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Item type or modifiers codes, eg for Oral whether the treatment is cosmetic or associated with TMJ, or an appliance was lost or stolen.",
            valueSet = "http://hl7.org/fhir/ValueSet/claim-modifiers"
        )
        private final List<CodeableConcept> modifier;
        @Binding(
            bindingName = "ProgramCode",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Program specific reason codes.",
            valueSet = "http://hl7.org/fhir/ValueSet/ex-program-code"
        )
        private final List<CodeableConcept> programCode;
        @Choice({ Date.class, Period.class })
        private final Element serviced;
        @Choice({ CodeableConcept.class, Address.class, Reference.class })
        @Binding(
            bindingName = "ServicePlace",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Place of service: pharmacy, school, prison, etc.",
            valueSet = "http://hl7.org/fhir/ValueSet/service-place"
        )
        private final Element location;
        private final SimpleQuantity quantity;
        private final Money unitPrice;
        private final Decimal factor;
        private final Money net;
        private final List<Reference> udi;
        @Binding(
            bindingName = "OralSites",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "The code for the teeth, quadrant, sextant and arch.",
            valueSet = "http://hl7.org/fhir/ValueSet/tooth"
        )
        private final CodeableConcept bodySite;
        @Binding(
            bindingName = "Surface",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "The code for the tooth surface and surface combinations.",
            valueSet = "http://hl7.org/fhir/ValueSet/surface"
        )
        private final List<CodeableConcept> subSite;
        private final List<Reference> encounter;
        private final List<Detail> detail;

        private volatile int hashCode;

        private Item(Builder builder) {
            super(builder);
            sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
            careTeamSequence = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.careTeamSequence, "careTeamSequence"));
            diagnosisSequence = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.diagnosisSequence, "diagnosisSequence"));
            procedureSequence = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.procedureSequence, "procedureSequence"));
            informationSequence = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.informationSequence, "informationSequence"));
            revenue = builder.revenue;
            category = builder.category;
            productOrService = ValidationSupport.requireNonNull(builder.productOrService, "productOrService");
            modifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.modifier, "modifier"));
            programCode = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.programCode, "programCode"));
            serviced = ValidationSupport.choiceElement(builder.serviced, "serviced", Date.class, Period.class);
            location = ValidationSupport.choiceElement(builder.location, "location", CodeableConcept.class, Address.class, Reference.class);
            quantity = builder.quantity;
            unitPrice = builder.unitPrice;
            factor = builder.factor;
            net = builder.net;
            udi = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.udi, "udi"));
            bodySite = builder.bodySite;
            subSite = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.subSite, "subSite"));
            encounter = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.encounter, "encounter"));
            detail = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.detail, "detail"));
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A number to uniquely identify item entries.
         * 
         * @return
         *     An immutable object of type {@link PositiveInt} that is non-null.
         */
        public PositiveInt getSequence() {
            return sequence;
        }

        /**
         * CareTeam members related to this service or product.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link PositiveInt} that may be empty.
         */
        public List<PositiveInt> getCareTeamSequence() {
            return careTeamSequence;
        }

        /**
         * Diagnosis applicable for this service or product.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link PositiveInt} that may be empty.
         */
        public List<PositiveInt> getDiagnosisSequence() {
            return diagnosisSequence;
        }

        /**
         * Procedures applicable for this service or product.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link PositiveInt} that may be empty.
         */
        public List<PositiveInt> getProcedureSequence() {
            return procedureSequence;
        }

        /**
         * Exceptions, special conditions and supporting information applicable for this service or product.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link PositiveInt} that may be empty.
         */
        public List<PositiveInt> getInformationSequence() {
            return informationSequence;
        }

        /**
         * The type of revenue or cost center providing the product and/or service.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getRevenue() {
            return revenue;
        }

        /**
         * Code to identify the general type of benefits under which products and services are provided.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getCategory() {
            return category;
        }

        /**
         * When the value is a group code then this item collects a set of related claim details, otherwise this contains the 
         * product, service, drug or other billing code for the item.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that is non-null.
         */
        public CodeableConcept getProductOrService() {
            return productOrService;
        }

        /**
         * Item typification or modifiers codes to convey additional context for the product or service.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
         */
        public List<CodeableConcept> getModifier() {
            return modifier;
        }

        /**
         * Identifies the program under which this may be recovered.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
         */
        public List<CodeableConcept> getProgramCode() {
            return programCode;
        }

        /**
         * The date or dates when the service or product was supplied, performed or completed.
         * 
         * @return
         *     An immutable object of type {@link Element} that may be null.
         */
        public Element getServiced() {
            return serviced;
        }

        /**
         * Where the product or service was provided.
         * 
         * @return
         *     An immutable object of type {@link Element} that may be null.
         */
        public Element getLocation() {
            return location;
        }

        /**
         * The number of repetitions of a service or product.
         * 
         * @return
         *     An immutable object of type {@link SimpleQuantity} that may be null.
         */
        public SimpleQuantity getQuantity() {
            return quantity;
        }

        /**
         * If the item is not a group then this is the fee for the product or service, otherwise this is the total of the fees 
         * for the details of the group.
         * 
         * @return
         *     An immutable object of type {@link Money} that may be null.
         */
        public Money getUnitPrice() {
            return unitPrice;
        }

        /**
         * A real number that represents a multiplier used in determining the overall value of services delivered and/or goods 
         * received. The concept of a Factor allows for a discount or surcharge multiplier to be applied to a monetary amount.
         * 
         * @return
         *     An immutable object of type {@link Decimal} that may be null.
         */
        public Decimal getFactor() {
            return factor;
        }

        /**
         * The quantity times the unit price for an additional service or product or charge.
         * 
         * @return
         *     An immutable object of type {@link Money} that may be null.
         */
        public Money getNet() {
            return net;
        }

        /**
         * Unique Device Identifiers associated with this line item.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
         */
        public List<Reference> getUdi() {
            return udi;
        }

        /**
         * Physical service site on the patient (limb, tooth, etc.).
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getBodySite() {
            return bodySite;
        }

        /**
         * A region or surface of the bodySite, e.g. limb region or tooth surface(s).
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
         */
        public List<CodeableConcept> getSubSite() {
            return subSite;
        }

        /**
         * The Encounters during which this Claim was created or to which the creation of this record is tightly associated.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
         */
        public List<Reference> getEncounter() {
            return encounter;
        }

        /**
         * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Detail} that may be empty.
         */
        public List<Detail> getDetail() {
            return detail;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (sequence != null) || 
                !careTeamSequence.isEmpty() || 
                !diagnosisSequence.isEmpty() || 
                !procedureSequence.isEmpty() || 
                !informationSequence.isEmpty() || 
                (revenue != null) || 
                (category != null) || 
                (productOrService != null) || 
                !modifier.isEmpty() || 
                !programCode.isEmpty() || 
                (serviced != null) || 
                (location != null) || 
                (quantity != null) || 
                (unitPrice != null) || 
                (factor != null) || 
                (net != null) || 
                !udi.isEmpty() || 
                (bodySite != null) || 
                !subSite.isEmpty() || 
                !encounter.isEmpty() || 
                !detail.isEmpty();
        }

        @Override
        public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
            if (visitor.preVisit(this)) {
                visitor.visitStart(elementName, elementIndex, this);
                if (visitor.visit(elementName, elementIndex, this)) {
                    // visit children
                    accept(id, "id", visitor);
                    accept(extension, "extension", visitor, Extension.class);
                    accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                    accept(sequence, "sequence", visitor);
                    accept(careTeamSequence, "careTeamSequence", visitor, PositiveInt.class);
                    accept(diagnosisSequence, "diagnosisSequence", visitor, PositiveInt.class);
                    accept(procedureSequence, "procedureSequence", visitor, PositiveInt.class);
                    accept(informationSequence, "informationSequence", visitor, PositiveInt.class);
                    accept(revenue, "revenue", visitor);
                    accept(category, "category", visitor);
                    accept(productOrService, "productOrService", visitor);
                    accept(modifier, "modifier", visitor, CodeableConcept.class);
                    accept(programCode, "programCode", visitor, CodeableConcept.class);
                    accept(serviced, "serviced", visitor);
                    accept(location, "location", visitor);
                    accept(quantity, "quantity", visitor);
                    accept(unitPrice, "unitPrice", visitor);
                    accept(factor, "factor", visitor);
                    accept(net, "net", visitor);
                    accept(udi, "udi", visitor, Reference.class);
                    accept(bodySite, "bodySite", visitor);
                    accept(subSite, "subSite", visitor, CodeableConcept.class);
                    accept(encounter, "encounter", visitor, Reference.class);
                    accept(detail, "detail", visitor, Detail.class);
                }
                visitor.visitEnd(elementName, elementIndex, this);
                visitor.postVisit(this);
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Item other = (Item) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(sequence, other.sequence) && 
                Objects.equals(careTeamSequence, other.careTeamSequence) && 
                Objects.equals(diagnosisSequence, other.diagnosisSequence) && 
                Objects.equals(procedureSequence, other.procedureSequence) && 
                Objects.equals(informationSequence, other.informationSequence) && 
                Objects.equals(revenue, other.revenue) && 
                Objects.equals(category, other.category) && 
                Objects.equals(productOrService, other.productOrService) && 
                Objects.equals(modifier, other.modifier) && 
                Objects.equals(programCode, other.programCode) && 
                Objects.equals(serviced, other.serviced) && 
                Objects.equals(location, other.location) && 
                Objects.equals(quantity, other.quantity) && 
                Objects.equals(unitPrice, other.unitPrice) && 
                Objects.equals(factor, other.factor) && 
                Objects.equals(net, other.net) && 
                Objects.equals(udi, other.udi) && 
                Objects.equals(bodySite, other.bodySite) && 
                Objects.equals(subSite, other.subSite) && 
                Objects.equals(encounter, other.encounter) && 
                Objects.equals(detail, other.detail);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    sequence, 
                    careTeamSequence, 
                    diagnosisSequence, 
                    procedureSequence, 
                    informationSequence, 
                    revenue, 
                    category, 
                    productOrService, 
                    modifier, 
                    programCode, 
                    serviced, 
                    location, 
                    quantity, 
                    unitPrice, 
                    factor, 
                    net, 
                    udi, 
                    bodySite, 
                    subSite, 
                    encounter, 
                    detail);
                hashCode = result;
            }
            return result;
        }

        @Override
        public Builder toBuilder() {
            return new Builder().from(this);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BackboneElement.Builder {
            private PositiveInt sequence;
            private List<PositiveInt> careTeamSequence = new ArrayList<>();
            private List<PositiveInt> diagnosisSequence = new ArrayList<>();
            private List<PositiveInt> procedureSequence = new ArrayList<>();
            private List<PositiveInt> informationSequence = new ArrayList<>();
            private CodeableConcept revenue;
            private CodeableConcept category;
            private CodeableConcept productOrService;
            private List<CodeableConcept> modifier = new ArrayList<>();
            private List<CodeableConcept> programCode = new ArrayList<>();
            private Element serviced;
            private Element location;
            private SimpleQuantity quantity;
            private Money unitPrice;
            private Decimal factor;
            private Money net;
            private List<Reference> udi = new ArrayList<>();
            private CodeableConcept bodySite;
            private List<CodeableConcept> subSite = new ArrayList<>();
            private List<Reference> encounter = new ArrayList<>();
            private List<Detail> detail = new ArrayList<>();

            private Builder() {
                super();
            }

            /**
             * Unique id for the element within a resource (for internal references). This may be any string value that does not 
             * contain spaces.
             * 
             * @param id
             *     Unique id for inter-element referencing
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder id(java.lang.String id) {
                return (Builder) super.id(id);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Extension... extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element. To make the 
             * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
             * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
             * of the definition of the extension.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param extension
             *     Additional content defined by implementations
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder extension(Collection<Extension> extension) {
                return (Builder) super.extension(extension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Extension... modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * May be used to represent additional information that is not part of the basic definition of the element and that 
             * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
             * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
             * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
             * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
             * extension. Applications processing a resource are required to check for modifier extensions.
             * 
             * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
             * change the meaning of modifierExtension itself).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifierExtension
             *     Extensions that cannot be ignored even if unrecognized
             * 
             * @return
             *     A reference to this Builder instance
             */
            @Override
            public Builder modifierExtension(Collection<Extension> modifierExtension) {
                return (Builder) super.modifierExtension(modifierExtension);
            }

            /**
             * A number to uniquely identify item entries.
             * 
             * <p>This element is required.
             * 
             * @param sequence
             *     Item instance identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder sequence(PositiveInt sequence) {
                this.sequence = sequence;
                return this;
            }

            /**
             * CareTeam members related to this service or product.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param careTeamSequence
             *     Applicable careTeam members
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder careTeamSequence(PositiveInt... careTeamSequence) {
                for (PositiveInt value : careTeamSequence) {
                    this.careTeamSequence.add(value);
                }
                return this;
            }

            /**
             * CareTeam members related to this service or product.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param careTeamSequence
             *     Applicable careTeam members
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder careTeamSequence(Collection<PositiveInt> careTeamSequence) {
                this.careTeamSequence = new ArrayList<>(careTeamSequence);
                return this;
            }

            /**
             * Diagnosis applicable for this service or product.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param diagnosisSequence
             *     Applicable diagnoses
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder diagnosisSequence(PositiveInt... diagnosisSequence) {
                for (PositiveInt value : diagnosisSequence) {
                    this.diagnosisSequence.add(value);
                }
                return this;
            }

            /**
             * Diagnosis applicable for this service or product.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param diagnosisSequence
             *     Applicable diagnoses
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder diagnosisSequence(Collection<PositiveInt> diagnosisSequence) {
                this.diagnosisSequence = new ArrayList<>(diagnosisSequence);
                return this;
            }

            /**
             * Procedures applicable for this service or product.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param procedureSequence
             *     Applicable procedures
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder procedureSequence(PositiveInt... procedureSequence) {
                for (PositiveInt value : procedureSequence) {
                    this.procedureSequence.add(value);
                }
                return this;
            }

            /**
             * Procedures applicable for this service or product.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param procedureSequence
             *     Applicable procedures
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder procedureSequence(Collection<PositiveInt> procedureSequence) {
                this.procedureSequence = new ArrayList<>(procedureSequence);
                return this;
            }

            /**
             * Exceptions, special conditions and supporting information applicable for this service or product.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param informationSequence
             *     Applicable exception and supporting information
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder informationSequence(PositiveInt... informationSequence) {
                for (PositiveInt value : informationSequence) {
                    this.informationSequence.add(value);
                }
                return this;
            }

            /**
             * Exceptions, special conditions and supporting information applicable for this service or product.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param informationSequence
             *     Applicable exception and supporting information
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder informationSequence(Collection<PositiveInt> informationSequence) {
                this.informationSequence = new ArrayList<>(informationSequence);
                return this;
            }

            /**
             * The type of revenue or cost center providing the product and/or service.
             * 
             * @param revenue
             *     Revenue or cost center code
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder revenue(CodeableConcept revenue) {
                this.revenue = revenue;
                return this;
            }

            /**
             * Code to identify the general type of benefits under which products and services are provided.
             * 
             * @param category
             *     Benefit classification
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder category(CodeableConcept category) {
                this.category = category;
                return this;
            }

            /**
             * When the value is a group code then this item collects a set of related claim details, otherwise this contains the 
             * product, service, drug or other billing code for the item.
             * 
             * <p>This element is required.
             * 
             * @param productOrService
             *     Billing, service, product, or drug code
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder productOrService(CodeableConcept productOrService) {
                this.productOrService = productOrService;
                return this;
            }

            /**
             * Item typification or modifiers codes to convey additional context for the product or service.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param modifier
             *     Product or service billing modifiers
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder modifier(CodeableConcept... modifier) {
                for (CodeableConcept value : modifier) {
                    this.modifier.add(value);
                }
                return this;
            }

            /**
             * Item typification or modifiers codes to convey additional context for the product or service.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param modifier
             *     Product or service billing modifiers
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder modifier(Collection<CodeableConcept> modifier) {
                this.modifier = new ArrayList<>(modifier);
                return this;
            }

            /**
             * Identifies the program under which this may be recovered.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param programCode
             *     Program the product or service is provided under
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder programCode(CodeableConcept... programCode) {
                for (CodeableConcept value : programCode) {
                    this.programCode.add(value);
                }
                return this;
            }

            /**
             * Identifies the program under which this may be recovered.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param programCode
             *     Program the product or service is provided under
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder programCode(Collection<CodeableConcept> programCode) {
                this.programCode = new ArrayList<>(programCode);
                return this;
            }

            /**
             * The date or dates when the service or product was supplied, performed or completed.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link Date}</li>
             * <li>{@link Period}</li>
             * </ul>
             * 
             * @param serviced
             *     Date or dates of service or product delivery
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder serviced(Element serviced) {
                this.serviced = serviced;
                return this;
            }

            /**
             * Where the product or service was provided.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link CodeableConcept}</li>
             * <li>{@link Address}</li>
             * <li>{@link Reference}</li>
             * </ul>
             * 
             * @param location
             *     Place of service or where product was supplied
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder location(Element location) {
                this.location = location;
                return this;
            }

            /**
             * The number of repetitions of a service or product.
             * 
             * @param quantity
             *     Count of products or services
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder quantity(SimpleQuantity quantity) {
                this.quantity = quantity;
                return this;
            }

            /**
             * If the item is not a group then this is the fee for the product or service, otherwise this is the total of the fees 
             * for the details of the group.
             * 
             * @param unitPrice
             *     Fee, charge or cost per item
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder unitPrice(Money unitPrice) {
                this.unitPrice = unitPrice;
                return this;
            }

            /**
             * A real number that represents a multiplier used in determining the overall value of services delivered and/or goods 
             * received. The concept of a Factor allows for a discount or surcharge multiplier to be applied to a monetary amount.
             * 
             * @param factor
             *     Price scaling factor
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder factor(Decimal factor) {
                this.factor = factor;
                return this;
            }

            /**
             * The quantity times the unit price for an additional service or product or charge.
             * 
             * @param net
             *     Total item cost
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder net(Money net) {
                this.net = net;
                return this;
            }

            /**
             * Unique Device Identifiers associated with this line item.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param udi
             *     Unique device identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder udi(Reference... udi) {
                for (Reference value : udi) {
                    this.udi.add(value);
                }
                return this;
            }

            /**
             * Unique Device Identifiers associated with this line item.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param udi
             *     Unique device identifier
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder udi(Collection<Reference> udi) {
                this.udi = new ArrayList<>(udi);
                return this;
            }

            /**
             * Physical service site on the patient (limb, tooth, etc.).
             * 
             * @param bodySite
             *     Anatomical location
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder bodySite(CodeableConcept bodySite) {
                this.bodySite = bodySite;
                return this;
            }

            /**
             * A region or surface of the bodySite, e.g. limb region or tooth surface(s).
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param subSite
             *     Anatomical sub-location
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder subSite(CodeableConcept... subSite) {
                for (CodeableConcept value : subSite) {
                    this.subSite.add(value);
                }
                return this;
            }

            /**
             * A region or surface of the bodySite, e.g. limb region or tooth surface(s).
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param subSite
             *     Anatomical sub-location
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder subSite(Collection<CodeableConcept> subSite) {
                this.subSite = new ArrayList<>(subSite);
                return this;
            }

            /**
             * The Encounters during which this Claim was created or to which the creation of this record is tightly associated.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param encounter
             *     Encounters related to this billed item
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder encounter(Reference... encounter) {
                for (Reference value : encounter) {
                    this.encounter.add(value);
                }
                return this;
            }

            /**
             * The Encounters during which this Claim was created or to which the creation of this record is tightly associated.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param encounter
             *     Encounters related to this billed item
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder encounter(Collection<Reference> encounter) {
                this.encounter = new ArrayList<>(encounter);
                return this;
            }

            /**
             * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param detail
             *     Product or service provided
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder detail(Detail... detail) {
                for (Detail value : detail) {
                    this.detail.add(value);
                }
                return this;
            }

            /**
             * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param detail
             *     Product or service provided
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder detail(Collection<Detail> detail) {
                this.detail = new ArrayList<>(detail);
                return this;
            }

            /**
             * Build the {@link Item}
             * 
             * <p>Required elements:
             * <ul>
             * <li>sequence</li>
             * <li>productOrService</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Item}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Item per the base specification
             */
            @Override
            public Item build() {
                return new Item(this);
            }

            protected Builder from(Item item) {
                super.from(item);
                sequence = item.sequence;
                careTeamSequence.addAll(item.careTeamSequence);
                diagnosisSequence.addAll(item.diagnosisSequence);
                procedureSequence.addAll(item.procedureSequence);
                informationSequence.addAll(item.informationSequence);
                revenue = item.revenue;
                category = item.category;
                productOrService = item.productOrService;
                modifier.addAll(item.modifier);
                programCode.addAll(item.programCode);
                serviced = item.serviced;
                location = item.location;
                quantity = item.quantity;
                unitPrice = item.unitPrice;
                factor = item.factor;
                net = item.net;
                udi.addAll(item.udi);
                bodySite = item.bodySite;
                subSite.addAll(item.subSite);
                encounter.addAll(item.encounter);
                detail.addAll(item.detail);
                return this;
            }
        }

        /**
         * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
         */
        public static class Detail extends BackboneElement {
            @Required
            private final PositiveInt sequence;
            @Binding(
                bindingName = "RevenueCenter",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Codes for the revenue or cost centers supplying the service and/or products.",
                valueSet = "http://hl7.org/fhir/ValueSet/ex-revenue-center"
            )
            private final CodeableConcept revenue;
            @Binding(
                bindingName = "BenefitCategory",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Benefit categories such as: oral-basic, major, glasses.",
                valueSet = "http://hl7.org/fhir/ValueSet/ex-benefitcategory"
            )
            private final CodeableConcept category;
            @Binding(
                bindingName = "ServiceProduct",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Allowable service and product codes.",
                valueSet = "http://hl7.org/fhir/ValueSet/service-uscls"
            )
            @Required
            private final CodeableConcept productOrService;
            @Binding(
                bindingName = "Modifiers",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Item type or modifiers codes, eg for Oral whether the treatment is cosmetic or associated with TMJ, or an appliance was lost or stolen.",
                valueSet = "http://hl7.org/fhir/ValueSet/claim-modifiers"
            )
            private final List<CodeableConcept> modifier;
            @Binding(
                bindingName = "ProgramCode",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Program specific reason codes.",
                valueSet = "http://hl7.org/fhir/ValueSet/ex-program-code"
            )
            private final List<CodeableConcept> programCode;
            private final SimpleQuantity quantity;
            private final Money unitPrice;
            private final Decimal factor;
            private final Money net;
            private final List<Reference> udi;
            private final List<SubDetail> subDetail;

            private volatile int hashCode;

            private Detail(Builder builder) {
                super(builder);
                sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
                revenue = builder.revenue;
                category = builder.category;
                productOrService = ValidationSupport.requireNonNull(builder.productOrService, "productOrService");
                modifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.modifier, "modifier"));
                programCode = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.programCode, "programCode"));
                quantity = builder.quantity;
                unitPrice = builder.unitPrice;
                factor = builder.factor;
                net = builder.net;
                udi = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.udi, "udi"));
                subDetail = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.subDetail, "subDetail"));
                ValidationSupport.requireValueOrChildren(this);
            }

            /**
             * A number to uniquely identify item entries.
             * 
             * @return
             *     An immutable object of type {@link PositiveInt} that is non-null.
             */
            public PositiveInt getSequence() {
                return sequence;
            }

            /**
             * The type of revenue or cost center providing the product and/or service.
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept} that may be null.
             */
            public CodeableConcept getRevenue() {
                return revenue;
            }

            /**
             * Code to identify the general type of benefits under which products and services are provided.
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept} that may be null.
             */
            public CodeableConcept getCategory() {
                return category;
            }

            /**
             * When the value is a group code then this item collects a set of related claim details, otherwise this contains the 
             * product, service, drug or other billing code for the item.
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept} that is non-null.
             */
            public CodeableConcept getProductOrService() {
                return productOrService;
            }

            /**
             * Item typification or modifiers codes to convey additional context for the product or service.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
             */
            public List<CodeableConcept> getModifier() {
                return modifier;
            }

            /**
             * Identifies the program under which this may be recovered.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
             */
            public List<CodeableConcept> getProgramCode() {
                return programCode;
            }

            /**
             * The number of repetitions of a service or product.
             * 
             * @return
             *     An immutable object of type {@link SimpleQuantity} that may be null.
             */
            public SimpleQuantity getQuantity() {
                return quantity;
            }

            /**
             * If the item is not a group then this is the fee for the product or service, otherwise this is the total of the fees 
             * for the details of the group.
             * 
             * @return
             *     An immutable object of type {@link Money} that may be null.
             */
            public Money getUnitPrice() {
                return unitPrice;
            }

            /**
             * A real number that represents a multiplier used in determining the overall value of services delivered and/or goods 
             * received. The concept of a Factor allows for a discount or surcharge multiplier to be applied to a monetary amount.
             * 
             * @return
             *     An immutable object of type {@link Decimal} that may be null.
             */
            public Decimal getFactor() {
                return factor;
            }

            /**
             * The quantity times the unit price for an additional service or product or charge.
             * 
             * @return
             *     An immutable object of type {@link Money} that may be null.
             */
            public Money getNet() {
                return net;
            }

            /**
             * Unique Device Identifiers associated with this line item.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
             */
            public List<Reference> getUdi() {
                return udi;
            }

            /**
             * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link SubDetail} that may be empty.
             */
            public List<SubDetail> getSubDetail() {
                return subDetail;
            }

            @Override
            public boolean hasChildren() {
                return super.hasChildren() || 
                    (sequence != null) || 
                    (revenue != null) || 
                    (category != null) || 
                    (productOrService != null) || 
                    !modifier.isEmpty() || 
                    !programCode.isEmpty() || 
                    (quantity != null) || 
                    (unitPrice != null) || 
                    (factor != null) || 
                    (net != null) || 
                    !udi.isEmpty() || 
                    !subDetail.isEmpty();
            }

            @Override
            public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
                if (visitor.preVisit(this)) {
                    visitor.visitStart(elementName, elementIndex, this);
                    if (visitor.visit(elementName, elementIndex, this)) {
                        // visit children
                        accept(id, "id", visitor);
                        accept(extension, "extension", visitor, Extension.class);
                        accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                        accept(sequence, "sequence", visitor);
                        accept(revenue, "revenue", visitor);
                        accept(category, "category", visitor);
                        accept(productOrService, "productOrService", visitor);
                        accept(modifier, "modifier", visitor, CodeableConcept.class);
                        accept(programCode, "programCode", visitor, CodeableConcept.class);
                        accept(quantity, "quantity", visitor);
                        accept(unitPrice, "unitPrice", visitor);
                        accept(factor, "factor", visitor);
                        accept(net, "net", visitor);
                        accept(udi, "udi", visitor, Reference.class);
                        accept(subDetail, "subDetail", visitor, SubDetail.class);
                    }
                    visitor.visitEnd(elementName, elementIndex, this);
                    visitor.postVisit(this);
                }
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                Detail other = (Detail) obj;
                return Objects.equals(id, other.id) && 
                    Objects.equals(extension, other.extension) && 
                    Objects.equals(modifierExtension, other.modifierExtension) && 
                    Objects.equals(sequence, other.sequence) && 
                    Objects.equals(revenue, other.revenue) && 
                    Objects.equals(category, other.category) && 
                    Objects.equals(productOrService, other.productOrService) && 
                    Objects.equals(modifier, other.modifier) && 
                    Objects.equals(programCode, other.programCode) && 
                    Objects.equals(quantity, other.quantity) && 
                    Objects.equals(unitPrice, other.unitPrice) && 
                    Objects.equals(factor, other.factor) && 
                    Objects.equals(net, other.net) && 
                    Objects.equals(udi, other.udi) && 
                    Objects.equals(subDetail, other.subDetail);
            }

            @Override
            public int hashCode() {
                int result = hashCode;
                if (result == 0) {
                    result = Objects.hash(id, 
                        extension, 
                        modifierExtension, 
                        sequence, 
                        revenue, 
                        category, 
                        productOrService, 
                        modifier, 
                        programCode, 
                        quantity, 
                        unitPrice, 
                        factor, 
                        net, 
                        udi, 
                        subDetail);
                    hashCode = result;
                }
                return result;
            }

            @Override
            public Builder toBuilder() {
                return new Builder().from(this);
            }

            public static Builder builder() {
                return new Builder();
            }

            public static class Builder extends BackboneElement.Builder {
                private PositiveInt sequence;
                private CodeableConcept revenue;
                private CodeableConcept category;
                private CodeableConcept productOrService;
                private List<CodeableConcept> modifier = new ArrayList<>();
                private List<CodeableConcept> programCode = new ArrayList<>();
                private SimpleQuantity quantity;
                private Money unitPrice;
                private Decimal factor;
                private Money net;
                private List<Reference> udi = new ArrayList<>();
                private List<SubDetail> subDetail = new ArrayList<>();

                private Builder() {
                    super();
                }

                /**
                 * Unique id for the element within a resource (for internal references). This may be any string value that does not 
                 * contain spaces.
                 * 
                 * @param id
                 *     Unique id for inter-element referencing
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                @Override
                public Builder id(java.lang.String id) {
                    return (Builder) super.id(id);
                }

                /**
                 * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                 * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                 * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                 * of the definition of the extension.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param extension
                 *     Additional content defined by implementations
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                @Override
                public Builder extension(Extension... extension) {
                    return (Builder) super.extension(extension);
                }

                /**
                 * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                 * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                 * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                 * of the definition of the extension.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param extension
                 *     Additional content defined by implementations
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                @Override
                public Builder extension(Collection<Extension> extension) {
                    return (Builder) super.extension(extension);
                }

                /**
                 * May be used to represent additional information that is not part of the basic definition of the element and that 
                 * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                 * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                 * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                 * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                 * extension. Applications processing a resource are required to check for modifier extensions.
                 * 
                 * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                 * change the meaning of modifierExtension itself).
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param modifierExtension
                 *     Extensions that cannot be ignored even if unrecognized
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                @Override
                public Builder modifierExtension(Extension... modifierExtension) {
                    return (Builder) super.modifierExtension(modifierExtension);
                }

                /**
                 * May be used to represent additional information that is not part of the basic definition of the element and that 
                 * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                 * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                 * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                 * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                 * extension. Applications processing a resource are required to check for modifier extensions.
                 * 
                 * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                 * change the meaning of modifierExtension itself).
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param modifierExtension
                 *     Extensions that cannot be ignored even if unrecognized
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                @Override
                public Builder modifierExtension(Collection<Extension> modifierExtension) {
                    return (Builder) super.modifierExtension(modifierExtension);
                }

                /**
                 * A number to uniquely identify item entries.
                 * 
                 * <p>This element is required.
                 * 
                 * @param sequence
                 *     Item instance identifier
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder sequence(PositiveInt sequence) {
                    this.sequence = sequence;
                    return this;
                }

                /**
                 * The type of revenue or cost center providing the product and/or service.
                 * 
                 * @param revenue
                 *     Revenue or cost center code
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder revenue(CodeableConcept revenue) {
                    this.revenue = revenue;
                    return this;
                }

                /**
                 * Code to identify the general type of benefits under which products and services are provided.
                 * 
                 * @param category
                 *     Benefit classification
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder category(CodeableConcept category) {
                    this.category = category;
                    return this;
                }

                /**
                 * When the value is a group code then this item collects a set of related claim details, otherwise this contains the 
                 * product, service, drug or other billing code for the item.
                 * 
                 * <p>This element is required.
                 * 
                 * @param productOrService
                 *     Billing, service, product, or drug code
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder productOrService(CodeableConcept productOrService) {
                    this.productOrService = productOrService;
                    return this;
                }

                /**
                 * Item typification or modifiers codes to convey additional context for the product or service.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param modifier
                 *     Service/Product billing modifiers
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder modifier(CodeableConcept... modifier) {
                    for (CodeableConcept value : modifier) {
                        this.modifier.add(value);
                    }
                    return this;
                }

                /**
                 * Item typification or modifiers codes to convey additional context for the product or service.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param modifier
                 *     Service/Product billing modifiers
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder modifier(Collection<CodeableConcept> modifier) {
                    this.modifier = new ArrayList<>(modifier);
                    return this;
                }

                /**
                 * Identifies the program under which this may be recovered.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param programCode
                 *     Program the product or service is provided under
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder programCode(CodeableConcept... programCode) {
                    for (CodeableConcept value : programCode) {
                        this.programCode.add(value);
                    }
                    return this;
                }

                /**
                 * Identifies the program under which this may be recovered.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param programCode
                 *     Program the product or service is provided under
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder programCode(Collection<CodeableConcept> programCode) {
                    this.programCode = new ArrayList<>(programCode);
                    return this;
                }

                /**
                 * The number of repetitions of a service or product.
                 * 
                 * @param quantity
                 *     Count of products or services
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder quantity(SimpleQuantity quantity) {
                    this.quantity = quantity;
                    return this;
                }

                /**
                 * If the item is not a group then this is the fee for the product or service, otherwise this is the total of the fees 
                 * for the details of the group.
                 * 
                 * @param unitPrice
                 *     Fee, charge or cost per item
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder unitPrice(Money unitPrice) {
                    this.unitPrice = unitPrice;
                    return this;
                }

                /**
                 * A real number that represents a multiplier used in determining the overall value of services delivered and/or goods 
                 * received. The concept of a Factor allows for a discount or surcharge multiplier to be applied to a monetary amount.
                 * 
                 * @param factor
                 *     Price scaling factor
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder factor(Decimal factor) {
                    this.factor = factor;
                    return this;
                }

                /**
                 * The quantity times the unit price for an additional service or product or charge.
                 * 
                 * @param net
                 *     Total item cost
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder net(Money net) {
                    this.net = net;
                    return this;
                }

                /**
                 * Unique Device Identifiers associated with this line item.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param udi
                 *     Unique device identifier
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder udi(Reference... udi) {
                    for (Reference value : udi) {
                        this.udi.add(value);
                    }
                    return this;
                }

                /**
                 * Unique Device Identifiers associated with this line item.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param udi
                 *     Unique device identifier
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder udi(Collection<Reference> udi) {
                    this.udi = new ArrayList<>(udi);
                    return this;
                }

                /**
                 * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param subDetail
                 *     Product or service provided
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder subDetail(SubDetail... subDetail) {
                    for (SubDetail value : subDetail) {
                        this.subDetail.add(value);
                    }
                    return this;
                }

                /**
                 * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param subDetail
                 *     Product or service provided
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder subDetail(Collection<SubDetail> subDetail) {
                    this.subDetail = new ArrayList<>(subDetail);
                    return this;
                }

                /**
                 * Build the {@link Detail}
                 * 
                 * <p>Required elements:
                 * <ul>
                 * <li>sequence</li>
                 * <li>productOrService</li>
                 * </ul>
                 * 
                 * @return
                 *     An immutable object of type {@link Detail}
                 * @throws IllegalStateException
                 *     if the current state cannot be built into a valid Detail per the base specification
                 */
                @Override
                public Detail build() {
                    return new Detail(this);
                }

                protected Builder from(Detail detail) {
                    super.from(detail);
                    sequence = detail.sequence;
                    revenue = detail.revenue;
                    category = detail.category;
                    productOrService = detail.productOrService;
                    modifier.addAll(detail.modifier);
                    programCode.addAll(detail.programCode);
                    quantity = detail.quantity;
                    unitPrice = detail.unitPrice;
                    factor = detail.factor;
                    net = detail.net;
                    udi.addAll(detail.udi);
                    subDetail.addAll(detail.subDetail);
                    return this;
                }
            }

            /**
             * A claim detail line. Either a simple (a product or service) or a 'group' of sub-details which are simple items.
             */
            public static class SubDetail extends BackboneElement {
                @Required
                private final PositiveInt sequence;
                @Binding(
                    bindingName = "RevenueCenter",
                    strength = BindingStrength.ValueSet.EXAMPLE,
                    description = "Codes for the revenue or cost centers supplying the service and/or products.",
                    valueSet = "http://hl7.org/fhir/ValueSet/ex-revenue-center"
                )
                private final CodeableConcept revenue;
                @Binding(
                    bindingName = "BenefitCategory",
                    strength = BindingStrength.ValueSet.EXAMPLE,
                    description = "Benefit categories such as: oral-basic, major, glasses.",
                    valueSet = "http://hl7.org/fhir/ValueSet/ex-benefitcategory"
                )
                private final CodeableConcept category;
                @Binding(
                    bindingName = "ServiceProduct",
                    strength = BindingStrength.ValueSet.EXAMPLE,
                    description = "Allowable service and product codes.",
                    valueSet = "http://hl7.org/fhir/ValueSet/service-uscls"
                )
                @Required
                private final CodeableConcept productOrService;
                @Binding(
                    bindingName = "Modifiers",
                    strength = BindingStrength.ValueSet.EXAMPLE,
                    description = "Item type or modifiers codes, eg for Oral whether the treatment is cosmetic or associated with TMJ, or an appliance was lost or stolen.",
                    valueSet = "http://hl7.org/fhir/ValueSet/claim-modifiers"
                )
                private final List<CodeableConcept> modifier;
                @Binding(
                    bindingName = "ProgramCode",
                    strength = BindingStrength.ValueSet.EXAMPLE,
                    description = "Program specific reason codes.",
                    valueSet = "http://hl7.org/fhir/ValueSet/ex-program-code"
                )
                private final List<CodeableConcept> programCode;
                private final SimpleQuantity quantity;
                private final Money unitPrice;
                private final Decimal factor;
                private final Money net;
                private final List<Reference> udi;

                private volatile int hashCode;

                private SubDetail(Builder builder) {
                    super(builder);
                    sequence = ValidationSupport.requireNonNull(builder.sequence, "sequence");
                    revenue = builder.revenue;
                    category = builder.category;
                    productOrService = ValidationSupport.requireNonNull(builder.productOrService, "productOrService");
                    modifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.modifier, "modifier"));
                    programCode = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.programCode, "programCode"));
                    quantity = builder.quantity;
                    unitPrice = builder.unitPrice;
                    factor = builder.factor;
                    net = builder.net;
                    udi = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.udi, "udi"));
                    ValidationSupport.requireValueOrChildren(this);
                }

                /**
                 * A number to uniquely identify item entries.
                 * 
                 * @return
                 *     An immutable object of type {@link PositiveInt} that is non-null.
                 */
                public PositiveInt getSequence() {
                    return sequence;
                }

                /**
                 * The type of revenue or cost center providing the product and/or service.
                 * 
                 * @return
                 *     An immutable object of type {@link CodeableConcept} that may be null.
                 */
                public CodeableConcept getRevenue() {
                    return revenue;
                }

                /**
                 * Code to identify the general type of benefits under which products and services are provided.
                 * 
                 * @return
                 *     An immutable object of type {@link CodeableConcept} that may be null.
                 */
                public CodeableConcept getCategory() {
                    return category;
                }

                /**
                 * When the value is a group code then this item collects a set of related claim details, otherwise this contains the 
                 * product, service, drug or other billing code for the item.
                 * 
                 * @return
                 *     An immutable object of type {@link CodeableConcept} that is non-null.
                 */
                public CodeableConcept getProductOrService() {
                    return productOrService;
                }

                /**
                 * Item typification or modifiers codes to convey additional context for the product or service.
                 * 
                 * @return
                 *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
                 */
                public List<CodeableConcept> getModifier() {
                    return modifier;
                }

                /**
                 * Identifies the program under which this may be recovered.
                 * 
                 * @return
                 *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
                 */
                public List<CodeableConcept> getProgramCode() {
                    return programCode;
                }

                /**
                 * The number of repetitions of a service or product.
                 * 
                 * @return
                 *     An immutable object of type {@link SimpleQuantity} that may be null.
                 */
                public SimpleQuantity getQuantity() {
                    return quantity;
                }

                /**
                 * If the item is not a group then this is the fee for the product or service, otherwise this is the total of the fees 
                 * for the details of the group.
                 * 
                 * @return
                 *     An immutable object of type {@link Money} that may be null.
                 */
                public Money getUnitPrice() {
                    return unitPrice;
                }

                /**
                 * A real number that represents a multiplier used in determining the overall value of services delivered and/or goods 
                 * received. The concept of a Factor allows for a discount or surcharge multiplier to be applied to a monetary amount.
                 * 
                 * @return
                 *     An immutable object of type {@link Decimal} that may be null.
                 */
                public Decimal getFactor() {
                    return factor;
                }

                /**
                 * The quantity times the unit price for an additional service or product or charge.
                 * 
                 * @return
                 *     An immutable object of type {@link Money} that may be null.
                 */
                public Money getNet() {
                    return net;
                }

                /**
                 * Unique Device Identifiers associated with this line item.
                 * 
                 * @return
                 *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
                 */
                public List<Reference> getUdi() {
                    return udi;
                }

                @Override
                public boolean hasChildren() {
                    return super.hasChildren() || 
                        (sequence != null) || 
                        (revenue != null) || 
                        (category != null) || 
                        (productOrService != null) || 
                        !modifier.isEmpty() || 
                        !programCode.isEmpty() || 
                        (quantity != null) || 
                        (unitPrice != null) || 
                        (factor != null) || 
                        (net != null) || 
                        !udi.isEmpty();
                }

                @Override
                public void accept(java.lang.String elementName, int elementIndex, Visitor visitor) {
                    if (visitor.preVisit(this)) {
                        visitor.visitStart(elementName, elementIndex, this);
                        if (visitor.visit(elementName, elementIndex, this)) {
                            // visit children
                            accept(id, "id", visitor);
                            accept(extension, "extension", visitor, Extension.class);
                            accept(modifierExtension, "modifierExtension", visitor, Extension.class);
                            accept(sequence, "sequence", visitor);
                            accept(revenue, "revenue", visitor);
                            accept(category, "category", visitor);
                            accept(productOrService, "productOrService", visitor);
                            accept(modifier, "modifier", visitor, CodeableConcept.class);
                            accept(programCode, "programCode", visitor, CodeableConcept.class);
                            accept(quantity, "quantity", visitor);
                            accept(unitPrice, "unitPrice", visitor);
                            accept(factor, "factor", visitor);
                            accept(net, "net", visitor);
                            accept(udi, "udi", visitor, Reference.class);
                        }
                        visitor.visitEnd(elementName, elementIndex, this);
                        visitor.postVisit(this);
                    }
                }

                @Override
                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null) {
                        return false;
                    }
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    SubDetail other = (SubDetail) obj;
                    return Objects.equals(id, other.id) && 
                        Objects.equals(extension, other.extension) && 
                        Objects.equals(modifierExtension, other.modifierExtension) && 
                        Objects.equals(sequence, other.sequence) && 
                        Objects.equals(revenue, other.revenue) && 
                        Objects.equals(category, other.category) && 
                        Objects.equals(productOrService, other.productOrService) && 
                        Objects.equals(modifier, other.modifier) && 
                        Objects.equals(programCode, other.programCode) && 
                        Objects.equals(quantity, other.quantity) && 
                        Objects.equals(unitPrice, other.unitPrice) && 
                        Objects.equals(factor, other.factor) && 
                        Objects.equals(net, other.net) && 
                        Objects.equals(udi, other.udi);
                }

                @Override
                public int hashCode() {
                    int result = hashCode;
                    if (result == 0) {
                        result = Objects.hash(id, 
                            extension, 
                            modifierExtension, 
                            sequence, 
                            revenue, 
                            category, 
                            productOrService, 
                            modifier, 
                            programCode, 
                            quantity, 
                            unitPrice, 
                            factor, 
                            net, 
                            udi);
                        hashCode = result;
                    }
                    return result;
                }

                @Override
                public Builder toBuilder() {
                    return new Builder().from(this);
                }

                public static Builder builder() {
                    return new Builder();
                }

                public static class Builder extends BackboneElement.Builder {
                    private PositiveInt sequence;
                    private CodeableConcept revenue;
                    private CodeableConcept category;
                    private CodeableConcept productOrService;
                    private List<CodeableConcept> modifier = new ArrayList<>();
                    private List<CodeableConcept> programCode = new ArrayList<>();
                    private SimpleQuantity quantity;
                    private Money unitPrice;
                    private Decimal factor;
                    private Money net;
                    private List<Reference> udi = new ArrayList<>();

                    private Builder() {
                        super();
                    }

                    /**
                     * Unique id for the element within a resource (for internal references). This may be any string value that does not 
                     * contain spaces.
                     * 
                     * @param id
                     *     Unique id for inter-element referencing
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    @Override
                    public Builder id(java.lang.String id) {
                        return (Builder) super.id(id);
                    }

                    /**
                     * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                     * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                     * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                     * of the definition of the extension.
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * @param extension
                     *     Additional content defined by implementations
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    @Override
                    public Builder extension(Extension... extension) {
                        return (Builder) super.extension(extension);
                    }

                    /**
                     * May be used to represent additional information that is not part of the basic definition of the element. To make the 
                     * use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of 
                     * extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part 
                     * of the definition of the extension.
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * @param extension
                     *     Additional content defined by implementations
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    @Override
                    public Builder extension(Collection<Extension> extension) {
                        return (Builder) super.extension(extension);
                    }

                    /**
                     * May be used to represent additional information that is not part of the basic definition of the element and that 
                     * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                     * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                     * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                     * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                     * extension. Applications processing a resource are required to check for modifier extensions.
                     * 
                     * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                     * change the meaning of modifierExtension itself).
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * @param modifierExtension
                     *     Extensions that cannot be ignored even if unrecognized
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    @Override
                    public Builder modifierExtension(Extension... modifierExtension) {
                        return (Builder) super.modifierExtension(modifierExtension);
                    }

                    /**
                     * May be used to represent additional information that is not part of the basic definition of the element and that 
                     * modifies the understanding of the element in which it is contained and/or the understanding of the containing 
                     * element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe 
                     * and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any 
                     * implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the 
                     * extension. Applications processing a resource are required to check for modifier extensions.
                     * 
                     * <p>Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot 
                     * change the meaning of modifierExtension itself).
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * @param modifierExtension
                     *     Extensions that cannot be ignored even if unrecognized
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    @Override
                    public Builder modifierExtension(Collection<Extension> modifierExtension) {
                        return (Builder) super.modifierExtension(modifierExtension);
                    }

                    /**
                     * A number to uniquely identify item entries.
                     * 
                     * <p>This element is required.
                     * 
                     * @param sequence
                     *     Item instance identifier
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder sequence(PositiveInt sequence) {
                        this.sequence = sequence;
                        return this;
                    }

                    /**
                     * The type of revenue or cost center providing the product and/or service.
                     * 
                     * @param revenue
                     *     Revenue or cost center code
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder revenue(CodeableConcept revenue) {
                        this.revenue = revenue;
                        return this;
                    }

                    /**
                     * Code to identify the general type of benefits under which products and services are provided.
                     * 
                     * @param category
                     *     Benefit classification
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder category(CodeableConcept category) {
                        this.category = category;
                        return this;
                    }

                    /**
                     * When the value is a group code then this item collects a set of related claim details, otherwise this contains the 
                     * product, service, drug or other billing code for the item.
                     * 
                     * <p>This element is required.
                     * 
                     * @param productOrService
                     *     Billing, service, product, or drug code
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder productOrService(CodeableConcept productOrService) {
                        this.productOrService = productOrService;
                        return this;
                    }

                    /**
                     * Item typification or modifiers codes to convey additional context for the product or service.
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * @param modifier
                     *     Service/Product billing modifiers
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder modifier(CodeableConcept... modifier) {
                        for (CodeableConcept value : modifier) {
                            this.modifier.add(value);
                        }
                        return this;
                    }

                    /**
                     * Item typification or modifiers codes to convey additional context for the product or service.
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * @param modifier
                     *     Service/Product billing modifiers
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder modifier(Collection<CodeableConcept> modifier) {
                        this.modifier = new ArrayList<>(modifier);
                        return this;
                    }

                    /**
                     * Identifies the program under which this may be recovered.
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * @param programCode
                     *     Program the product or service is provided under
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder programCode(CodeableConcept... programCode) {
                        for (CodeableConcept value : programCode) {
                            this.programCode.add(value);
                        }
                        return this;
                    }

                    /**
                     * Identifies the program under which this may be recovered.
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * @param programCode
                     *     Program the product or service is provided under
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder programCode(Collection<CodeableConcept> programCode) {
                        this.programCode = new ArrayList<>(programCode);
                        return this;
                    }

                    /**
                     * The number of repetitions of a service or product.
                     * 
                     * @param quantity
                     *     Count of products or services
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder quantity(SimpleQuantity quantity) {
                        this.quantity = quantity;
                        return this;
                    }

                    /**
                     * If the item is not a group then this is the fee for the product or service, otherwise this is the total of the fees 
                     * for the details of the group.
                     * 
                     * @param unitPrice
                     *     Fee, charge or cost per item
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder unitPrice(Money unitPrice) {
                        this.unitPrice = unitPrice;
                        return this;
                    }

                    /**
                     * A real number that represents a multiplier used in determining the overall value of services delivered and/or goods 
                     * received. The concept of a Factor allows for a discount or surcharge multiplier to be applied to a monetary amount.
                     * 
                     * @param factor
                     *     Price scaling factor
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder factor(Decimal factor) {
                        this.factor = factor;
                        return this;
                    }

                    /**
                     * The quantity times the unit price for an additional service or product or charge.
                     * 
                     * @param net
                     *     Total item cost
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder net(Money net) {
                        this.net = net;
                        return this;
                    }

                    /**
                     * Unique Device Identifiers associated with this line item.
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * @param udi
                     *     Unique device identifier
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder udi(Reference... udi) {
                        for (Reference value : udi) {
                            this.udi.add(value);
                        }
                        return this;
                    }

                    /**
                     * Unique Device Identifiers associated with this line item.
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * @param udi
                     *     Unique device identifier
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder udi(Collection<Reference> udi) {
                        this.udi = new ArrayList<>(udi);
                        return this;
                    }

                    /**
                     * Build the {@link SubDetail}
                     * 
                     * <p>Required elements:
                     * <ul>
                     * <li>sequence</li>
                     * <li>productOrService</li>
                     * </ul>
                     * 
                     * @return
                     *     An immutable object of type {@link SubDetail}
                     * @throws IllegalStateException
                     *     if the current state cannot be built into a valid SubDetail per the base specification
                     */
                    @Override
                    public SubDetail build() {
                        return new SubDetail(this);
                    }

                    protected Builder from(SubDetail subDetail) {
                        super.from(subDetail);
                        sequence = subDetail.sequence;
                        revenue = subDetail.revenue;
                        category = subDetail.category;
                        productOrService = subDetail.productOrService;
                        modifier.addAll(subDetail.modifier);
                        programCode.addAll(subDetail.programCode);
                        quantity = subDetail.quantity;
                        unitPrice = subDetail.unitPrice;
                        factor = subDetail.factor;
                        net = subDetail.net;
                        udi.addAll(subDetail.udi);
                        return this;
                    }
                }
            }
        }
    }
}
