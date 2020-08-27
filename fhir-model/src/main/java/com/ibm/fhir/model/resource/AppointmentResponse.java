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
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Instant;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.code.BindingStrength;
import com.ibm.fhir.model.type.code.ParticipantStatus;
import com.ibm.fhir.model.util.ValidationSupport;
import com.ibm.fhir.model.visitor.Visitor;

/**
 * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
 */
@Constraint(
    id = "apr-1",
    level = "Rule",
    location = "(base)",
    description = "Either the participantType or actor must be specified",
    expression = "participantType.exists() or actor.exists()"
)
@Constraint(
    id = "appointmentResponse-2",
    level = "Warning",
    location = "(base)",
    description = "SHALL, if possible, at least contain a code from value set http://hl7.org/fhir/ValueSet/encounter-participant-type",
    expression = "participantType.exists() implies (participantType.all(memberOf('http://hl7.org/fhir/ValueSet/encounter-participant-type', 'extensible')))"
)
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class AppointmentResponse extends DomainResource {
    @Summary
    private final List<Identifier> identifier;
    @Summary
    @ReferenceTarget({ "Appointment" })
    @Required
    private final Reference appointment;
    private final Instant start;
    private final Instant end;
    @Summary
    @Binding(
        bindingName = "ParticipantType",
        strength = BindingStrength.ValueSet.EXTENSIBLE,
        description = "Role of participant in encounter.",
        valueSet = "http://hl7.org/fhir/ValueSet/encounter-participant-type"
    )
    private final List<CodeableConcept> participantType;
    @Summary
    @ReferenceTarget({ "Patient", "Practitioner", "PractitionerRole", "RelatedPerson", "Device", "HealthcareService", "Location" })
    private final Reference actor;
    @Summary
    @Binding(
        bindingName = "ParticipantStatus",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "The Participation status of an appointment.",
        valueSet = "http://hl7.org/fhir/ValueSet/participationstatus|4.0.1"
    )
    @Required
    private final ParticipantStatus participantStatus;
    private final String comment;

    private volatile int hashCode;

    private AppointmentResponse(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        appointment = ValidationSupport.requireNonNull(builder.appointment, "appointment");
        start = builder.start;
        end = builder.end;
        participantType = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.participantType, "participantType"));
        actor = builder.actor;
        participantStatus = ValidationSupport.requireNonNull(builder.participantStatus, "participantStatus");
        comment = builder.comment;
        ValidationSupport.checkReferenceType(appointment, "appointment", "Appointment");
        ValidationSupport.checkReferenceType(actor, "actor", "Patient", "Practitioner", "PractitionerRole", "RelatedPerson", "Device", "HealthcareService", "Location");
        ValidationSupport.requireChildren(this);
    }

    /**
     * This records identifiers associated with this appointment response concern that are defined by business processes and/ 
     * or used to refer to it when a direct URL reference to the resource itself is not appropriate.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier} that may be empty.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * Appointment that this response is replying to.
     * 
     * @return
     *     An immutable object of type {@link Reference} that is non-null.
     */
    public Reference getAppointment() {
        return appointment;
    }

    /**
     * Date/Time that the appointment is to take place, or requested new start time.
     * 
     * @return
     *     An immutable object of type {@link Instant} that may be null.
     */
    public Instant getStart() {
        return start;
    }

    /**
     * This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new 
     * time to request a re-negotiation of the end time.
     * 
     * @return
     *     An immutable object of type {@link Instant} that may be null.
     */
    public Instant getEnd() {
        return end;
    }

    /**
     * Role of participant in the appointment.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getParticipantType() {
        return participantType;
    }

    /**
     * A Person, Location, HealthcareService, or Device that is participating in the appointment.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getActor() {
        return actor;
    }

    /**
     * Participation status of the participant. When the status is declined or tentative if the start/end times are different 
     * to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, 
     * the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
     * 
     * @return
     *     An immutable object of type {@link ParticipantStatus} that is non-null.
     */
    public ParticipantStatus getParticipantStatus() {
        return participantStatus;
    }

    /**
     * Additional comments about the appointment.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getComment() {
        return comment;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            !identifier.isEmpty() || 
            (appointment != null) || 
            (start != null) || 
            (end != null) || 
            !participantType.isEmpty() || 
            (actor != null) || 
            (participantStatus != null) || 
            (comment != null);
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
                accept(appointment, "appointment", visitor);
                accept(start, "start", visitor);
                accept(end, "end", visitor);
                accept(participantType, "participantType", visitor, CodeableConcept.class);
                accept(actor, "actor", visitor);
                accept(participantStatus, "participantStatus", visitor);
                accept(comment, "comment", visitor);
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
        AppointmentResponse other = (AppointmentResponse) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(meta, other.meta) && 
            Objects.equals(implicitRules, other.implicitRules) && 
            Objects.equals(language, other.language) && 
            Objects.equals(text, other.text) && 
            Objects.equals(contained, other.contained) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(identifier, other.identifier) && 
            Objects.equals(appointment, other.appointment) && 
            Objects.equals(start, other.start) && 
            Objects.equals(end, other.end) && 
            Objects.equals(participantType, other.participantType) && 
            Objects.equals(actor, other.actor) && 
            Objects.equals(participantStatus, other.participantStatus) && 
            Objects.equals(comment, other.comment);
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
                appointment, 
                start, 
                end, 
                participantType, 
                actor, 
                participantStatus, 
                comment);
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
        private Reference appointment;
        private Instant start;
        private Instant end;
        private List<CodeableConcept> participantType = new ArrayList<>();
        private Reference actor;
        private ParticipantStatus participantStatus;
        private String comment;

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
         * This records identifiers associated with this appointment response concern that are defined by business processes and/ 
         * or used to refer to it when a direct URL reference to the resource itself is not appropriate.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     External Ids for this item
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
         * This records identifiers associated with this appointment response concern that are defined by business processes and/ 
         * or used to refer to it when a direct URL reference to the resource itself is not appropriate.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     External Ids for this item
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * Appointment that this response is replying to.
         * 
         * <p>This element is required.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Appointment}</li>
         * </ul>
         * 
         * @param appointment
         *     Appointment this response relates to
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder appointment(Reference appointment) {
            this.appointment = appointment;
            return this;
        }

        /**
         * Date/Time that the appointment is to take place, or requested new start time.
         * 
         * @param start
         *     Time from appointment, or requested new start time
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder start(Instant start) {
            this.start = start;
            return this;
        }

        /**
         * This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new 
         * time to request a re-negotiation of the end time.
         * 
         * @param end
         *     Time from appointment, or requested new end time
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder end(Instant end) {
            this.end = end;
            return this;
        }

        /**
         * Role of participant in the appointment.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param participantType
         *     Role of participant in the appointment
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder participantType(CodeableConcept... participantType) {
            for (CodeableConcept value : participantType) {
                this.participantType.add(value);
            }
            return this;
        }

        /**
         * Role of participant in the appointment.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param participantType
         *     Role of participant in the appointment
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder participantType(Collection<CodeableConcept> participantType) {
            this.participantType = new ArrayList<>(participantType);
            return this;
        }

        /**
         * A Person, Location, HealthcareService, or Device that is participating in the appointment.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Patient}</li>
         * <li>{@link Practitioner}</li>
         * <li>{@link PractitionerRole}</li>
         * <li>{@link RelatedPerson}</li>
         * <li>{@link Device}</li>
         * <li>{@link HealthcareService}</li>
         * <li>{@link Location}</li>
         * </ul>
         * 
         * @param actor
         *     Person, Location, HealthcareService, or Device
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder actor(Reference actor) {
            this.actor = actor;
            return this;
        }

        /**
         * Participation status of the participant. When the status is declined or tentative if the start/end times are different 
         * to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, 
         * the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
         * 
         * <p>This element is required.
         * 
         * @param participantStatus
         *     accepted | declined | tentative | needs-action
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder participantStatus(ParticipantStatus participantStatus) {
            this.participantStatus = participantStatus;
            return this;
        }

        /**
         * Additional comments about the appointment.
         * 
         * @param comment
         *     Additional comments
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        /**
         * Build the {@link AppointmentResponse}
         * 
         * <p>Required elements:
         * <ul>
         * <li>appointment</li>
         * <li>participantStatus</li>
         * </ul>
         * 
         * @return
         *     An immutable object of type {@link AppointmentResponse}
         * @throws IllegalStateException
         *     if the current state cannot be built into a valid AppointmentResponse per the base specification
         */
        @Override
        public AppointmentResponse build() {
            return new AppointmentResponse(this);
        }

        protected Builder from(AppointmentResponse appointmentResponse) {
            super.from(appointmentResponse);
            identifier.addAll(appointmentResponse.identifier);
            appointment = appointmentResponse.appointment;
            start = appointmentResponse.start;
            end = appointmentResponse.end;
            participantType.addAll(appointmentResponse.participantType);
            actor = appointmentResponse.actor;
            participantStatus = appointmentResponse.participantStatus;
            comment = appointmentResponse.comment;
            return this;
        }
    }
}
