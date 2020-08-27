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
import com.ibm.fhir.model.annotation.Constraint;
import com.ibm.fhir.model.annotation.ReferenceTarget;
import com.ibm.fhir.model.annotation.Required;
import com.ibm.fhir.model.annotation.Summary;
import com.ibm.fhir.model.type.BackboneElement;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.ContactPoint;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Period;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Time;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.code.BindingStrength;
import com.ibm.fhir.model.type.code.DaysOfWeek;
import com.ibm.fhir.model.util.ValidationSupport;
import com.ibm.fhir.model.visitor.Visitor;

/**
 * A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period 
 * of time.
 */
@Constraint(
    id = "practitionerRole-0",
    level = "Warning",
    location = "(base)",
    description = "SHOULD at least contain a code from value set http://hl7.org/fhir/ValueSet/c80-practice-codes",
    expression = "specialty.exists() implies (specialty.all(memberOf('http://hl7.org/fhir/ValueSet/c80-practice-codes', 'preferred')))"
)
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class PractitionerRole extends DomainResource {
    @Summary
    private final List<Identifier> identifier;
    @Summary
    private final Boolean active;
    @Summary
    private final Period period;
    @Summary
    @ReferenceTarget({ "Practitioner" })
    private final Reference practitioner;
    @Summary
    @ReferenceTarget({ "Organization" })
    private final Reference organization;
    @Summary
    @Binding(
        bindingName = "PractitionerRole",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "The role a person plays representing an organization.",
        valueSet = "http://hl7.org/fhir/ValueSet/practitioner-role"
    )
    private final List<CodeableConcept> code;
    @Summary
    @Binding(
        bindingName = "PractitionerSpecialty",
        strength = BindingStrength.ValueSet.PREFERRED,
        description = "Specific specialty associated with the agency.",
        valueSet = "http://hl7.org/fhir/ValueSet/c80-practice-codes"
    )
    private final List<CodeableConcept> specialty;
    @Summary
    private final List<Reference> location;
    private final List<Reference> healthcareService;
    @Summary
    private final List<ContactPoint> telecom;
    private final List<AvailableTime> availableTime;
    private final List<NotAvailable> notAvailable;
    private final String availabilityExceptions;
    private final List<Reference> endpoint;

    private volatile int hashCode;

    private PractitionerRole(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        active = builder.active;
        period = builder.period;
        practitioner = builder.practitioner;
        organization = builder.organization;
        code = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.code, "code"));
        specialty = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.specialty, "specialty"));
        location = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.location, "location"));
        healthcareService = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.healthcareService, "healthcareService"));
        telecom = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.telecom, "telecom"));
        availableTime = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.availableTime, "availableTime"));
        notAvailable = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.notAvailable, "notAvailable"));
        availabilityExceptions = builder.availabilityExceptions;
        endpoint = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.endpoint, "endpoint"));
        ValidationSupport.checkReferenceType(practitioner, "practitioner", "Practitioner");
        ValidationSupport.checkReferenceType(organization, "organization", "Organization");
        ValidationSupport.requireChildren(this);
    }

    /**
     * Business Identifiers that are specific to a role/location.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier} that may be empty.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * Whether this practitioner role record is in active use.
     * 
     * @return
     *     An immutable object of type {@link Boolean} that may be null.
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * The period during which the person is authorized to act as a practitioner in these role(s) for the organization.
     * 
     * @return
     *     An immutable object of type {@link Period} that may be null.
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Practitioner that is able to provide the defined services for the organization.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getPractitioner() {
        return practitioner;
    }

    /**
     * The organization where the Practitioner performs the roles associated.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getOrganization() {
        return organization;
    }

    /**
     * Roles which this practitioner is authorized to perform for the organization.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getCode() {
        return code;
    }

    /**
     * Specific specialty of the practitioner.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getSpecialty() {
        return specialty;
    }

    /**
     * The location(s) at which this practitioner provides care.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
     */
    public List<Reference> getLocation() {
        return location;
    }

    /**
     * The list of healthcare services that this worker provides for this role's Organization/Location(s).
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
     */
    public List<Reference> getHealthcareService() {
        return healthcareService;
    }

    /**
     * Contact details that are specific to the role/location/service.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactPoint} that may be empty.
     */
    public List<ContactPoint> getTelecom() {
        return telecom;
    }

    /**
     * A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link AvailableTime} that may be empty.
     */
    public List<AvailableTime> getAvailableTime() {
        return availableTime;
    }

    /**
     * The practitioner is not available or performing this role during this period of time due to the provided reason.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link NotAvailable} that may be empty.
     */
    public List<NotAvailable> getNotAvailable() {
        return notAvailable;
    }

    /**
     * A description of site availability exceptions, e.g. public holiday availability. Succinctly describing all possible 
     * exceptions to normal site availability as details in the available Times and not available Times.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getAvailabilityExceptions() {
        return availabilityExceptions;
    }

    /**
     * Technical endpoints providing access to services operated for the practitioner with this role.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
     */
    public List<Reference> getEndpoint() {
        return endpoint;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            !identifier.isEmpty() || 
            (active != null) || 
            (period != null) || 
            (practitioner != null) || 
            (organization != null) || 
            !code.isEmpty() || 
            !specialty.isEmpty() || 
            !location.isEmpty() || 
            !healthcareService.isEmpty() || 
            !telecom.isEmpty() || 
            !availableTime.isEmpty() || 
            !notAvailable.isEmpty() || 
            (availabilityExceptions != null) || 
            !endpoint.isEmpty();
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
                accept(active, "active", visitor);
                accept(period, "period", visitor);
                accept(practitioner, "practitioner", visitor);
                accept(organization, "organization", visitor);
                accept(code, "code", visitor, CodeableConcept.class);
                accept(specialty, "specialty", visitor, CodeableConcept.class);
                accept(location, "location", visitor, Reference.class);
                accept(healthcareService, "healthcareService", visitor, Reference.class);
                accept(telecom, "telecom", visitor, ContactPoint.class);
                accept(availableTime, "availableTime", visitor, AvailableTime.class);
                accept(notAvailable, "notAvailable", visitor, NotAvailable.class);
                accept(availabilityExceptions, "availabilityExceptions", visitor);
                accept(endpoint, "endpoint", visitor, Reference.class);
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
        PractitionerRole other = (PractitionerRole) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(meta, other.meta) && 
            Objects.equals(implicitRules, other.implicitRules) && 
            Objects.equals(language, other.language) && 
            Objects.equals(text, other.text) && 
            Objects.equals(contained, other.contained) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(identifier, other.identifier) && 
            Objects.equals(active, other.active) && 
            Objects.equals(period, other.period) && 
            Objects.equals(practitioner, other.practitioner) && 
            Objects.equals(organization, other.organization) && 
            Objects.equals(code, other.code) && 
            Objects.equals(specialty, other.specialty) && 
            Objects.equals(location, other.location) && 
            Objects.equals(healthcareService, other.healthcareService) && 
            Objects.equals(telecom, other.telecom) && 
            Objects.equals(availableTime, other.availableTime) && 
            Objects.equals(notAvailable, other.notAvailable) && 
            Objects.equals(availabilityExceptions, other.availabilityExceptions) && 
            Objects.equals(endpoint, other.endpoint);
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
                active, 
                period, 
                practitioner, 
                organization, 
                code, 
                specialty, 
                location, 
                healthcareService, 
                telecom, 
                availableTime, 
                notAvailable, 
                availabilityExceptions, 
                endpoint);
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
        private Boolean active;
        private Period period;
        private Reference practitioner;
        private Reference organization;
        private List<CodeableConcept> code = new ArrayList<>();
        private List<CodeableConcept> specialty = new ArrayList<>();
        private List<Reference> location = new ArrayList<>();
        private List<Reference> healthcareService = new ArrayList<>();
        private List<ContactPoint> telecom = new ArrayList<>();
        private List<AvailableTime> availableTime = new ArrayList<>();
        private List<NotAvailable> notAvailable = new ArrayList<>();
        private String availabilityExceptions;
        private List<Reference> endpoint = new ArrayList<>();

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
         * Business Identifiers that are specific to a role/location.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     Business Identifiers that are specific to a role/location
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
         * Business Identifiers that are specific to a role/location.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     Business Identifiers that are specific to a role/location
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * Whether this practitioner role record is in active use.
         * 
         * @param active
         *     Whether this practitioner role record is in active use
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        /**
         * The period during which the person is authorized to act as a practitioner in these role(s) for the organization.
         * 
         * @param period
         *     The period during which the practitioner is authorized to perform in these role(s)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder period(Period period) {
            this.period = period;
            return this;
        }

        /**
         * Practitioner that is able to provide the defined services for the organization.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Practitioner}</li>
         * </ul>
         * 
         * @param practitioner
         *     Practitioner that is able to provide the defined services for the organization
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder practitioner(Reference practitioner) {
            this.practitioner = practitioner;
            return this;
        }

        /**
         * The organization where the Practitioner performs the roles associated.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Organization}</li>
         * </ul>
         * 
         * @param organization
         *     Organization where the roles are available
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder organization(Reference organization) {
            this.organization = organization;
            return this;
        }

        /**
         * Roles which this practitioner is authorized to perform for the organization.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param code
         *     Roles which this practitioner may perform
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder code(CodeableConcept... code) {
            for (CodeableConcept value : code) {
                this.code.add(value);
            }
            return this;
        }

        /**
         * Roles which this practitioner is authorized to perform for the organization.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param code
         *     Roles which this practitioner may perform
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder code(Collection<CodeableConcept> code) {
            this.code = new ArrayList<>(code);
            return this;
        }

        /**
         * Specific specialty of the practitioner.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param specialty
         *     Specific specialty of the practitioner
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder specialty(CodeableConcept... specialty) {
            for (CodeableConcept value : specialty) {
                this.specialty.add(value);
            }
            return this;
        }

        /**
         * Specific specialty of the practitioner.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param specialty
         *     Specific specialty of the practitioner
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder specialty(Collection<CodeableConcept> specialty) {
            this.specialty = new ArrayList<>(specialty);
            return this;
        }

        /**
         * The location(s) at which this practitioner provides care.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param location
         *     The location(s) at which this practitioner provides care
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder location(Reference... location) {
            for (Reference value : location) {
                this.location.add(value);
            }
            return this;
        }

        /**
         * The location(s) at which this practitioner provides care.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param location
         *     The location(s) at which this practitioner provides care
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder location(Collection<Reference> location) {
            this.location = new ArrayList<>(location);
            return this;
        }

        /**
         * The list of healthcare services that this worker provides for this role's Organization/Location(s).
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param healthcareService
         *     The list of healthcare services that this worker provides for this role's Organization/Location(s)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder healthcareService(Reference... healthcareService) {
            for (Reference value : healthcareService) {
                this.healthcareService.add(value);
            }
            return this;
        }

        /**
         * The list of healthcare services that this worker provides for this role's Organization/Location(s).
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param healthcareService
         *     The list of healthcare services that this worker provides for this role's Organization/Location(s)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder healthcareService(Collection<Reference> healthcareService) {
            this.healthcareService = new ArrayList<>(healthcareService);
            return this;
        }

        /**
         * Contact details that are specific to the role/location/service.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param telecom
         *     Contact details that are specific to the role/location/service
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder telecom(ContactPoint... telecom) {
            for (ContactPoint value : telecom) {
                this.telecom.add(value);
            }
            return this;
        }

        /**
         * Contact details that are specific to the role/location/service.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param telecom
         *     Contact details that are specific to the role/location/service
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder telecom(Collection<ContactPoint> telecom) {
            this.telecom = new ArrayList<>(telecom);
            return this;
        }

        /**
         * A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param availableTime
         *     Times the Service Site is available
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder availableTime(AvailableTime... availableTime) {
            for (AvailableTime value : availableTime) {
                this.availableTime.add(value);
            }
            return this;
        }

        /**
         * A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param availableTime
         *     Times the Service Site is available
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder availableTime(Collection<AvailableTime> availableTime) {
            this.availableTime = new ArrayList<>(availableTime);
            return this;
        }

        /**
         * The practitioner is not available or performing this role during this period of time due to the provided reason.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param notAvailable
         *     Not available during this time due to provided reason
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder notAvailable(NotAvailable... notAvailable) {
            for (NotAvailable value : notAvailable) {
                this.notAvailable.add(value);
            }
            return this;
        }

        /**
         * The practitioner is not available or performing this role during this period of time due to the provided reason.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param notAvailable
         *     Not available during this time due to provided reason
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder notAvailable(Collection<NotAvailable> notAvailable) {
            this.notAvailable = new ArrayList<>(notAvailable);
            return this;
        }

        /**
         * A description of site availability exceptions, e.g. public holiday availability. Succinctly describing all possible 
         * exceptions to normal site availability as details in the available Times and not available Times.
         * 
         * @param availabilityExceptions
         *     Description of availability exceptions
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder availabilityExceptions(String availabilityExceptions) {
            this.availabilityExceptions = availabilityExceptions;
            return this;
        }

        /**
         * Technical endpoints providing access to services operated for the practitioner with this role.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param endpoint
         *     Technical endpoints providing access to services operated for the practitioner with this role
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder endpoint(Reference... endpoint) {
            for (Reference value : endpoint) {
                this.endpoint.add(value);
            }
            return this;
        }

        /**
         * Technical endpoints providing access to services operated for the practitioner with this role.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param endpoint
         *     Technical endpoints providing access to services operated for the practitioner with this role
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder endpoint(Collection<Reference> endpoint) {
            this.endpoint = new ArrayList<>(endpoint);
            return this;
        }

        /**
         * Build the {@link PractitionerRole}
         * 
         * @return
         *     An immutable object of type {@link PractitionerRole}
         * @throws IllegalStateException
         *     if the current state cannot be built into a valid PractitionerRole per the base specification
         */
        @Override
        public PractitionerRole build() {
            return new PractitionerRole(this);
        }

        protected Builder from(PractitionerRole practitionerRole) {
            super.from(practitionerRole);
            identifier.addAll(practitionerRole.identifier);
            active = practitionerRole.active;
            period = practitionerRole.period;
            practitioner = practitionerRole.practitioner;
            organization = practitionerRole.organization;
            code.addAll(practitionerRole.code);
            specialty.addAll(practitionerRole.specialty);
            location.addAll(practitionerRole.location);
            healthcareService.addAll(practitionerRole.healthcareService);
            telecom.addAll(practitionerRole.telecom);
            availableTime.addAll(practitionerRole.availableTime);
            notAvailable.addAll(practitionerRole.notAvailable);
            availabilityExceptions = practitionerRole.availabilityExceptions;
            endpoint.addAll(practitionerRole.endpoint);
            return this;
        }
    }

    /**
     * A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.
     */
    public static class AvailableTime extends BackboneElement {
        @Binding(
            bindingName = "DaysOfWeek",
            strength = BindingStrength.ValueSet.REQUIRED,
            description = "The days of the week.",
            valueSet = "http://hl7.org/fhir/ValueSet/days-of-week|4.0.1"
        )
        private final List<DaysOfWeek> daysOfWeek;
        private final Boolean allDay;
        private final Time availableStartTime;
        private final Time availableEndTime;

        private volatile int hashCode;

        private AvailableTime(Builder builder) {
            super(builder);
            daysOfWeek = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.daysOfWeek, "daysOfWeek"));
            allDay = builder.allDay;
            availableStartTime = builder.availableStartTime;
            availableEndTime = builder.availableEndTime;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * Indicates which days of the week are available between the start and end Times.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link DaysOfWeek} that may be empty.
         */
        public List<DaysOfWeek> getDaysOfWeek() {
            return daysOfWeek;
        }

        /**
         * Is this always available? (hence times are irrelevant) e.g. 24 hour service.
         * 
         * @return
         *     An immutable object of type {@link Boolean} that may be null.
         */
        public Boolean getAllDay() {
            return allDay;
        }

        /**
         * The opening time of day. Note: If the AllDay flag is set, then this time is ignored.
         * 
         * @return
         *     An immutable object of type {@link Time} that may be null.
         */
        public Time getAvailableStartTime() {
            return availableStartTime;
        }

        /**
         * The closing time of day. Note: If the AllDay flag is set, then this time is ignored.
         * 
         * @return
         *     An immutable object of type {@link Time} that may be null.
         */
        public Time getAvailableEndTime() {
            return availableEndTime;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                !daysOfWeek.isEmpty() || 
                (allDay != null) || 
                (availableStartTime != null) || 
                (availableEndTime != null);
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
                    accept(daysOfWeek, "daysOfWeek", visitor, DaysOfWeek.class);
                    accept(allDay, "allDay", visitor);
                    accept(availableStartTime, "availableStartTime", visitor);
                    accept(availableEndTime, "availableEndTime", visitor);
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
            AvailableTime other = (AvailableTime) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(daysOfWeek, other.daysOfWeek) && 
                Objects.equals(allDay, other.allDay) && 
                Objects.equals(availableStartTime, other.availableStartTime) && 
                Objects.equals(availableEndTime, other.availableEndTime);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    daysOfWeek, 
                    allDay, 
                    availableStartTime, 
                    availableEndTime);
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
            private List<DaysOfWeek> daysOfWeek = new ArrayList<>();
            private Boolean allDay;
            private Time availableStartTime;
            private Time availableEndTime;

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
             * Indicates which days of the week are available between the start and end Times.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param daysOfWeek
             *     mon | tue | wed | thu | fri | sat | sun
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder daysOfWeek(DaysOfWeek... daysOfWeek) {
                for (DaysOfWeek value : daysOfWeek) {
                    this.daysOfWeek.add(value);
                }
                return this;
            }

            /**
             * Indicates which days of the week are available between the start and end Times.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param daysOfWeek
             *     mon | tue | wed | thu | fri | sat | sun
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder daysOfWeek(Collection<DaysOfWeek> daysOfWeek) {
                this.daysOfWeek = new ArrayList<>(daysOfWeek);
                return this;
            }

            /**
             * Is this always available? (hence times are irrelevant) e.g. 24 hour service.
             * 
             * @param allDay
             *     Always available? e.g. 24 hour service
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder allDay(Boolean allDay) {
                this.allDay = allDay;
                return this;
            }

            /**
             * The opening time of day. Note: If the AllDay flag is set, then this time is ignored.
             * 
             * @param availableStartTime
             *     Opening time of day (ignored if allDay = true)
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder availableStartTime(Time availableStartTime) {
                this.availableStartTime = availableStartTime;
                return this;
            }

            /**
             * The closing time of day. Note: If the AllDay flag is set, then this time is ignored.
             * 
             * @param availableEndTime
             *     Closing time of day (ignored if allDay = true)
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder availableEndTime(Time availableEndTime) {
                this.availableEndTime = availableEndTime;
                return this;
            }

            /**
             * Build the {@link AvailableTime}
             * 
             * @return
             *     An immutable object of type {@link AvailableTime}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid AvailableTime per the base specification
             */
            @Override
            public AvailableTime build() {
                return new AvailableTime(this);
            }

            protected Builder from(AvailableTime availableTime) {
                super.from(availableTime);
                daysOfWeek.addAll(availableTime.daysOfWeek);
                allDay = availableTime.allDay;
                availableStartTime = availableTime.availableStartTime;
                availableEndTime = availableTime.availableEndTime;
                return this;
            }
        }
    }

    /**
     * The practitioner is not available or performing this role during this period of time due to the provided reason.
     */
    public static class NotAvailable extends BackboneElement {
        @Required
        private final String description;
        private final Period during;

        private volatile int hashCode;

        private NotAvailable(Builder builder) {
            super(builder);
            description = ValidationSupport.requireNonNull(builder.description, "description");
            during = builder.during;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * The reason that can be presented to the user as to why this time is not available.
         * 
         * @return
         *     An immutable object of type {@link String} that is non-null.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Service is not available (seasonally or for a public holiday) from this date.
         * 
         * @return
         *     An immutable object of type {@link Period} that may be null.
         */
        public Period getDuring() {
            return during;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (description != null) || 
                (during != null);
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
                    accept(description, "description", visitor);
                    accept(during, "during", visitor);
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
            NotAvailable other = (NotAvailable) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(description, other.description) && 
                Objects.equals(during, other.during);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    description, 
                    during);
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
            private String description;
            private Period during;

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
             * The reason that can be presented to the user as to why this time is not available.
             * 
             * <p>This element is required.
             * 
             * @param description
             *     Reason presented to the user explaining why time not available
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder description(String description) {
                this.description = description;
                return this;
            }

            /**
             * Service is not available (seasonally or for a public holiday) from this date.
             * 
             * @param during
             *     Service not available from this date
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder during(Period during) {
                this.during = during;
                return this;
            }

            /**
             * Build the {@link NotAvailable}
             * 
             * <p>Required elements:
             * <ul>
             * <li>description</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link NotAvailable}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid NotAvailable per the base specification
             */
            @Override
            public NotAvailable build() {
                return new NotAvailable(this);
            }

            protected Builder from(NotAvailable notAvailable) {
                super.from(notAvailable);
                description = notAvailable.description;
                during = notAvailable.during;
                return this;
            }
        }
    }
}
