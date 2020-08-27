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
import com.ibm.fhir.model.type.Annotation;
import com.ibm.fhir.model.type.BackboneElement;
import com.ibm.fhir.model.type.Canonical;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Element;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Ratio;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.SimpleQuantity;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Timing;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.code.BindingStrength;
import com.ibm.fhir.model.type.code.NutritionOrderIntent;
import com.ibm.fhir.model.type.code.NutritionOrderStatus;
import com.ibm.fhir.model.util.ValidationSupport;
import com.ibm.fhir.model.visitor.Visitor;

/**
 * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
 */
@Constraint(
    id = "nor-1",
    level = "Warning",
    location = "(base)",
    description = "Nutrition Order SHALL contain either Oral Diet , Supplement, or Enteral Formula class",
    expression = "oralDiet.exists() or supplement.exists() or enteralFormula.exists()"
)
@Constraint(
    id = "nutritionOrder-2",
    level = "Warning",
    location = "enteralFormula.routeofAdministration",
    description = "SHALL, if possible, at least contain a code from value set http://hl7.org/fhir/ValueSet/enteral-route",
    expression = "$this.memberOf('http://hl7.org/fhir/ValueSet/enteral-route', 'extensible')"
)
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class NutritionOrder extends DomainResource {
    private final List<Identifier> identifier;
    @Summary
    private final List<Canonical> instantiatesCanonical;
    @Summary
    private final List<Uri> instantiatesUri;
    private final List<Uri> instantiates;
    @Summary
    @Binding(
        bindingName = "NutritionOrderStatus",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "Codes identifying the lifecycle stage of the nutrition order.",
        valueSet = "http://hl7.org/fhir/ValueSet/request-status|4.0.1"
    )
    @Required
    private final NutritionOrderStatus status;
    @Summary
    @Binding(
        bindingName = "NutritiionOrderIntent",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "Codes indicating the degree of authority/intentionality associated with a nutrition order.",
        valueSet = "http://hl7.org/fhir/ValueSet/request-intent|4.0.1"
    )
    @Required
    private final NutritionOrderIntent intent;
    @Summary
    @ReferenceTarget({ "Patient" })
    @Required
    private final Reference patient;
    @ReferenceTarget({ "Encounter" })
    private final Reference encounter;
    @Summary
    @Required
    private final DateTime dateTime;
    @Summary
    @ReferenceTarget({ "Practitioner", "PractitionerRole" })
    private final Reference orderer;
    private final List<Reference> allergyIntolerance;
    @Binding(
        bindingName = "PatientDiet",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "Medical, cultural or ethical food preferences to help with catering requirements.",
        valueSet = "http://hl7.org/fhir/ValueSet/encounter-diet"
    )
    private final List<CodeableConcept> foodPreferenceModifier;
    @Binding(
        bindingName = "FoodType",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "Codes used to indicate the type of food that should NOT be given to the patient.",
        valueSet = "http://hl7.org/fhir/ValueSet/food-type"
    )
    private final List<CodeableConcept> excludeFoodModifier;
    private final OralDiet oralDiet;
    private final List<Supplement> supplement;
    private final EnteralFormula enteralFormula;
    private final List<Annotation> note;

    private volatile int hashCode;

    private NutritionOrder(Builder builder) {
        super(builder);
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        instantiatesCanonical = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.instantiatesCanonical, "instantiatesCanonical"));
        instantiatesUri = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.instantiatesUri, "instantiatesUri"));
        instantiates = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.instantiates, "instantiates"));
        status = ValidationSupport.requireNonNull(builder.status, "status");
        intent = ValidationSupport.requireNonNull(builder.intent, "intent");
        patient = ValidationSupport.requireNonNull(builder.patient, "patient");
        encounter = builder.encounter;
        dateTime = ValidationSupport.requireNonNull(builder.dateTime, "dateTime");
        orderer = builder.orderer;
        allergyIntolerance = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.allergyIntolerance, "allergyIntolerance"));
        foodPreferenceModifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.foodPreferenceModifier, "foodPreferenceModifier"));
        excludeFoodModifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.excludeFoodModifier, "excludeFoodModifier"));
        oralDiet = builder.oralDiet;
        supplement = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.supplement, "supplement"));
        enteralFormula = builder.enteralFormula;
        note = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.note, "note"));
        ValidationSupport.checkReferenceType(patient, "patient", "Patient");
        ValidationSupport.checkReferenceType(encounter, "encounter", "Encounter");
        ValidationSupport.checkReferenceType(orderer, "orderer", "Practitioner", "PractitionerRole");
        ValidationSupport.requireChildren(this);
    }

    /**
     * Identifiers assigned to this order by the order sender or by the order receiver.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier} that may be empty.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in 
     * part by this NutritionOrder.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Canonical} that may be empty.
     */
    public List<Canonical> getInstantiatesCanonical() {
        return instantiatesCanonical;
    }

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in 
     * whole or in part by this NutritionOrder.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Uri} that may be empty.
     */
    public List<Uri> getInstantiatesUri() {
        return instantiatesUri;
    }

    /**
     * The URL pointing to a protocol, guideline, orderset or other definition that is adhered to in whole or in part by this 
     * NutritionOrder.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Uri} that may be empty.
     */
    public List<Uri> getInstantiates() {
        return instantiates;
    }

    /**
     * The workflow status of the nutrition order/request.
     * 
     * @return
     *     An immutable object of type {@link NutritionOrderStatus} that is non-null.
     */
    public NutritionOrderStatus getStatus() {
        return status;
    }

    /**
     * Indicates the level of authority/intentionality associated with the NutrionOrder and where the request fits into the 
     * workflow chain.
     * 
     * @return
     *     An immutable object of type {@link NutritionOrderIntent} that is non-null.
     */
    public NutritionOrderIntent getIntent() {
        return intent;
    }

    /**
     * The person (patient) who needs the nutrition order for an oral diet, nutritional supplement and/or enteral or formula 
     * feeding.
     * 
     * @return
     *     An immutable object of type {@link Reference} that is non-null.
     */
    public Reference getPatient() {
        return patient;
    }

    /**
     * An encounter that provides additional information about the healthcare context in which this request is made.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getEncounter() {
        return encounter;
    }

    /**
     * The date and time that this nutrition order was requested.
     * 
     * @return
     *     An immutable object of type {@link DateTime} that is non-null.
     */
    public DateTime getDateTime() {
        return dateTime;
    }

    /**
     * The practitioner that holds legal responsibility for ordering the diet, nutritional supplement, or formula feedings.
     * 
     * @return
     *     An immutable object of type {@link Reference} that may be null.
     */
    public Reference getOrderer() {
        return orderer;
    }

    /**
     * A link to a record of allergies or intolerances which should be included in the nutrition order.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Reference} that may be empty.
     */
    public List<Reference> getAllergyIntolerance() {
        return allergyIntolerance;
    }

    /**
     * This modifier is used to convey order-specific modifiers about the type of food that should be given. These can be 
     * derived from patient allergies, intolerances, or preferences such as Halal, Vegan or Kosher. This modifier applies to 
     * the entire nutrition order inclusive of the oral diet, nutritional supplements and enteral formula feedings.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getFoodPreferenceModifier() {
        return foodPreferenceModifier;
    }

    /**
     * This modifier is used to convey Order-specific modifier about the type of oral food or oral fluids that should not be 
     * given. These can be derived from patient allergies, intolerances, or preferences such as No Red Meat, No Soy or No 
     * Wheat or Gluten-Free. While it should not be necessary to repeat allergy or intolerance information captured in the 
     * referenced AllergyIntolerance resource in the excludeFoodModifier, this element may be used to convey additional 
     * specificity related to foods that should be eliminated from the patient’s diet for any reason. This modifier applies 
     * to the entire nutrition order inclusive of the oral diet, nutritional supplements and enteral formula feedings.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getExcludeFoodModifier() {
        return excludeFoodModifier;
    }

    /**
     * Diet given orally in contrast to enteral (tube) feeding.
     * 
     * @return
     *     An immutable object of type {@link OralDiet} that may be null.
     */
    public OralDiet getOralDiet() {
        return oralDiet;
    }

    /**
     * Oral nutritional products given in order to add further nutritional value to the patient's diet.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Supplement} that may be empty.
     */
    public List<Supplement> getSupplement() {
        return supplement;
    }

    /**
     * Feeding provided through the gastrointestinal tract via a tube, catheter, or stoma that delivers nutrition distal to 
     * the oral cavity.
     * 
     * @return
     *     An immutable object of type {@link EnteralFormula} that may be null.
     */
    public EnteralFormula getEnteralFormula() {
        return enteralFormula;
    }

    /**
     * Comments made about the {{title}} by the requester, performer, subject or other participants.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Annotation} that may be empty.
     */
    public List<Annotation> getNote() {
        return note;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            !identifier.isEmpty() || 
            !instantiatesCanonical.isEmpty() || 
            !instantiatesUri.isEmpty() || 
            !instantiates.isEmpty() || 
            (status != null) || 
            (intent != null) || 
            (patient != null) || 
            (encounter != null) || 
            (dateTime != null) || 
            (orderer != null) || 
            !allergyIntolerance.isEmpty() || 
            !foodPreferenceModifier.isEmpty() || 
            !excludeFoodModifier.isEmpty() || 
            (oralDiet != null) || 
            !supplement.isEmpty() || 
            (enteralFormula != null) || 
            !note.isEmpty();
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
                accept(instantiatesCanonical, "instantiatesCanonical", visitor, Canonical.class);
                accept(instantiatesUri, "instantiatesUri", visitor, Uri.class);
                accept(instantiates, "instantiates", visitor, Uri.class);
                accept(status, "status", visitor);
                accept(intent, "intent", visitor);
                accept(patient, "patient", visitor);
                accept(encounter, "encounter", visitor);
                accept(dateTime, "dateTime", visitor);
                accept(orderer, "orderer", visitor);
                accept(allergyIntolerance, "allergyIntolerance", visitor, Reference.class);
                accept(foodPreferenceModifier, "foodPreferenceModifier", visitor, CodeableConcept.class);
                accept(excludeFoodModifier, "excludeFoodModifier", visitor, CodeableConcept.class);
                accept(oralDiet, "oralDiet", visitor);
                accept(supplement, "supplement", visitor, Supplement.class);
                accept(enteralFormula, "enteralFormula", visitor);
                accept(note, "note", visitor, Annotation.class);
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
        NutritionOrder other = (NutritionOrder) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(meta, other.meta) && 
            Objects.equals(implicitRules, other.implicitRules) && 
            Objects.equals(language, other.language) && 
            Objects.equals(text, other.text) && 
            Objects.equals(contained, other.contained) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(identifier, other.identifier) && 
            Objects.equals(instantiatesCanonical, other.instantiatesCanonical) && 
            Objects.equals(instantiatesUri, other.instantiatesUri) && 
            Objects.equals(instantiates, other.instantiates) && 
            Objects.equals(status, other.status) && 
            Objects.equals(intent, other.intent) && 
            Objects.equals(patient, other.patient) && 
            Objects.equals(encounter, other.encounter) && 
            Objects.equals(dateTime, other.dateTime) && 
            Objects.equals(orderer, other.orderer) && 
            Objects.equals(allergyIntolerance, other.allergyIntolerance) && 
            Objects.equals(foodPreferenceModifier, other.foodPreferenceModifier) && 
            Objects.equals(excludeFoodModifier, other.excludeFoodModifier) && 
            Objects.equals(oralDiet, other.oralDiet) && 
            Objects.equals(supplement, other.supplement) && 
            Objects.equals(enteralFormula, other.enteralFormula) && 
            Objects.equals(note, other.note);
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
                instantiatesCanonical, 
                instantiatesUri, 
                instantiates, 
                status, 
                intent, 
                patient, 
                encounter, 
                dateTime, 
                orderer, 
                allergyIntolerance, 
                foodPreferenceModifier, 
                excludeFoodModifier, 
                oralDiet, 
                supplement, 
                enteralFormula, 
                note);
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
        private List<Canonical> instantiatesCanonical = new ArrayList<>();
        private List<Uri> instantiatesUri = new ArrayList<>();
        private List<Uri> instantiates = new ArrayList<>();
        private NutritionOrderStatus status;
        private NutritionOrderIntent intent;
        private Reference patient;
        private Reference encounter;
        private DateTime dateTime;
        private Reference orderer;
        private List<Reference> allergyIntolerance = new ArrayList<>();
        private List<CodeableConcept> foodPreferenceModifier = new ArrayList<>();
        private List<CodeableConcept> excludeFoodModifier = new ArrayList<>();
        private OralDiet oralDiet;
        private List<Supplement> supplement = new ArrayList<>();
        private EnteralFormula enteralFormula;
        private List<Annotation> note = new ArrayList<>();

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
         * Identifiers assigned to this order by the order sender or by the order receiver.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     Identifiers assigned to this order
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
         * Identifiers assigned to this order by the order sender or by the order receiver.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     Identifiers assigned to this order
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in 
         * part by this NutritionOrder.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param instantiatesCanonical
         *     Instantiates FHIR protocol or definition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder instantiatesCanonical(Canonical... instantiatesCanonical) {
            for (Canonical value : instantiatesCanonical) {
                this.instantiatesCanonical.add(value);
            }
            return this;
        }

        /**
         * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in 
         * part by this NutritionOrder.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param instantiatesCanonical
         *     Instantiates FHIR protocol or definition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder instantiatesCanonical(Collection<Canonical> instantiatesCanonical) {
            this.instantiatesCanonical = new ArrayList<>(instantiatesCanonical);
            return this;
        }

        /**
         * The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in 
         * whole or in part by this NutritionOrder.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param instantiatesUri
         *     Instantiates external protocol or definition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder instantiatesUri(Uri... instantiatesUri) {
            for (Uri value : instantiatesUri) {
                this.instantiatesUri.add(value);
            }
            return this;
        }

        /**
         * The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in 
         * whole or in part by this NutritionOrder.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param instantiatesUri
         *     Instantiates external protocol or definition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder instantiatesUri(Collection<Uri> instantiatesUri) {
            this.instantiatesUri = new ArrayList<>(instantiatesUri);
            return this;
        }

        /**
         * The URL pointing to a protocol, guideline, orderset or other definition that is adhered to in whole or in part by this 
         * NutritionOrder.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param instantiates
         *     Instantiates protocol or definition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder instantiates(Uri... instantiates) {
            for (Uri value : instantiates) {
                this.instantiates.add(value);
            }
            return this;
        }

        /**
         * The URL pointing to a protocol, guideline, orderset or other definition that is adhered to in whole or in part by this 
         * NutritionOrder.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param instantiates
         *     Instantiates protocol or definition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder instantiates(Collection<Uri> instantiates) {
            this.instantiates = new ArrayList<>(instantiates);
            return this;
        }

        /**
         * The workflow status of the nutrition order/request.
         * 
         * <p>This element is required.
         * 
         * @param status
         *     draft | active | on-hold | revoked | completed | entered-in-error | unknown
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder status(NutritionOrderStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Indicates the level of authority/intentionality associated with the NutrionOrder and where the request fits into the 
         * workflow chain.
         * 
         * <p>This element is required.
         * 
         * @param intent
         *     proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order | option
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder intent(NutritionOrderIntent intent) {
            this.intent = intent;
            return this;
        }

        /**
         * The person (patient) who needs the nutrition order for an oral diet, nutritional supplement and/or enteral or formula 
         * feeding.
         * 
         * <p>This element is required.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Patient}</li>
         * </ul>
         * 
         * @param patient
         *     The person who requires the diet, formula or nutritional supplement
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder patient(Reference patient) {
            this.patient = patient;
            return this;
        }

        /**
         * An encounter that provides additional information about the healthcare context in which this request is made.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Encounter}</li>
         * </ul>
         * 
         * @param encounter
         *     The encounter associated with this nutrition order
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder encounter(Reference encounter) {
            this.encounter = encounter;
            return this;
        }

        /**
         * The date and time that this nutrition order was requested.
         * 
         * <p>This element is required.
         * 
         * @param dateTime
         *     Date and time the nutrition order was requested
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder dateTime(DateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        /**
         * The practitioner that holds legal responsibility for ordering the diet, nutritional supplement, or formula feedings.
         * 
         * <p>Allowed resource types for this reference:
         * <ul>
         * <li>{@link Practitioner}</li>
         * <li>{@link PractitionerRole}</li>
         * </ul>
         * 
         * @param orderer
         *     Who ordered the diet, formula or nutritional supplement
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder orderer(Reference orderer) {
            this.orderer = orderer;
            return this;
        }

        /**
         * A link to a record of allergies or intolerances which should be included in the nutrition order.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param allergyIntolerance
         *     List of the patient's food and nutrition-related allergies and intolerances
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder allergyIntolerance(Reference... allergyIntolerance) {
            for (Reference value : allergyIntolerance) {
                this.allergyIntolerance.add(value);
            }
            return this;
        }

        /**
         * A link to a record of allergies or intolerances which should be included in the nutrition order.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param allergyIntolerance
         *     List of the patient's food and nutrition-related allergies and intolerances
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder allergyIntolerance(Collection<Reference> allergyIntolerance) {
            this.allergyIntolerance = new ArrayList<>(allergyIntolerance);
            return this;
        }

        /**
         * This modifier is used to convey order-specific modifiers about the type of food that should be given. These can be 
         * derived from patient allergies, intolerances, or preferences such as Halal, Vegan or Kosher. This modifier applies to 
         * the entire nutrition order inclusive of the oral diet, nutritional supplements and enteral formula feedings.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param foodPreferenceModifier
         *     Order-specific modifier about the type of food that should be given
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder foodPreferenceModifier(CodeableConcept... foodPreferenceModifier) {
            for (CodeableConcept value : foodPreferenceModifier) {
                this.foodPreferenceModifier.add(value);
            }
            return this;
        }

        /**
         * This modifier is used to convey order-specific modifiers about the type of food that should be given. These can be 
         * derived from patient allergies, intolerances, or preferences such as Halal, Vegan or Kosher. This modifier applies to 
         * the entire nutrition order inclusive of the oral diet, nutritional supplements and enteral formula feedings.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param foodPreferenceModifier
         *     Order-specific modifier about the type of food that should be given
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder foodPreferenceModifier(Collection<CodeableConcept> foodPreferenceModifier) {
            this.foodPreferenceModifier = new ArrayList<>(foodPreferenceModifier);
            return this;
        }

        /**
         * This modifier is used to convey Order-specific modifier about the type of oral food or oral fluids that should not be 
         * given. These can be derived from patient allergies, intolerances, or preferences such as No Red Meat, No Soy or No 
         * Wheat or Gluten-Free. While it should not be necessary to repeat allergy or intolerance information captured in the 
         * referenced AllergyIntolerance resource in the excludeFoodModifier, this element may be used to convey additional 
         * specificity related to foods that should be eliminated from the patient’s diet for any reason. This modifier applies 
         * to the entire nutrition order inclusive of the oral diet, nutritional supplements and enteral formula feedings.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param excludeFoodModifier
         *     Order-specific modifier about the type of food that should not be given
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder excludeFoodModifier(CodeableConcept... excludeFoodModifier) {
            for (CodeableConcept value : excludeFoodModifier) {
                this.excludeFoodModifier.add(value);
            }
            return this;
        }

        /**
         * This modifier is used to convey Order-specific modifier about the type of oral food or oral fluids that should not be 
         * given. These can be derived from patient allergies, intolerances, or preferences such as No Red Meat, No Soy or No 
         * Wheat or Gluten-Free. While it should not be necessary to repeat allergy or intolerance information captured in the 
         * referenced AllergyIntolerance resource in the excludeFoodModifier, this element may be used to convey additional 
         * specificity related to foods that should be eliminated from the patient’s diet for any reason. This modifier applies 
         * to the entire nutrition order inclusive of the oral diet, nutritional supplements and enteral formula feedings.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param excludeFoodModifier
         *     Order-specific modifier about the type of food that should not be given
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder excludeFoodModifier(Collection<CodeableConcept> excludeFoodModifier) {
            this.excludeFoodModifier = new ArrayList<>(excludeFoodModifier);
            return this;
        }

        /**
         * Diet given orally in contrast to enteral (tube) feeding.
         * 
         * @param oralDiet
         *     Oral diet components
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder oralDiet(OralDiet oralDiet) {
            this.oralDiet = oralDiet;
            return this;
        }

        /**
         * Oral nutritional products given in order to add further nutritional value to the patient's diet.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param supplement
         *     Supplement components
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder supplement(Supplement... supplement) {
            for (Supplement value : supplement) {
                this.supplement.add(value);
            }
            return this;
        }

        /**
         * Oral nutritional products given in order to add further nutritional value to the patient's diet.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param supplement
         *     Supplement components
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder supplement(Collection<Supplement> supplement) {
            this.supplement = new ArrayList<>(supplement);
            return this;
        }

        /**
         * Feeding provided through the gastrointestinal tract via a tube, catheter, or stoma that delivers nutrition distal to 
         * the oral cavity.
         * 
         * @param enteralFormula
         *     Enteral formula components
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder enteralFormula(EnteralFormula enteralFormula) {
            this.enteralFormula = enteralFormula;
            return this;
        }

        /**
         * Comments made about the {{title}} by the requester, performer, subject or other participants.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param note
         *     Comments
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder note(Annotation... note) {
            for (Annotation value : note) {
                this.note.add(value);
            }
            return this;
        }

        /**
         * Comments made about the {{title}} by the requester, performer, subject or other participants.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param note
         *     Comments
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder note(Collection<Annotation> note) {
            this.note = new ArrayList<>(note);
            return this;
        }

        /**
         * Build the {@link NutritionOrder}
         * 
         * <p>Required elements:
         * <ul>
         * <li>status</li>
         * <li>intent</li>
         * <li>patient</li>
         * <li>dateTime</li>
         * </ul>
         * 
         * @return
         *     An immutable object of type {@link NutritionOrder}
         * @throws IllegalStateException
         *     if the current state cannot be built into a valid NutritionOrder per the base specification
         */
        @Override
        public NutritionOrder build() {
            return new NutritionOrder(this);
        }

        protected Builder from(NutritionOrder nutritionOrder) {
            super.from(nutritionOrder);
            identifier.addAll(nutritionOrder.identifier);
            instantiatesCanonical.addAll(nutritionOrder.instantiatesCanonical);
            instantiatesUri.addAll(nutritionOrder.instantiatesUri);
            instantiates.addAll(nutritionOrder.instantiates);
            status = nutritionOrder.status;
            intent = nutritionOrder.intent;
            patient = nutritionOrder.patient;
            encounter = nutritionOrder.encounter;
            dateTime = nutritionOrder.dateTime;
            orderer = nutritionOrder.orderer;
            allergyIntolerance.addAll(nutritionOrder.allergyIntolerance);
            foodPreferenceModifier.addAll(nutritionOrder.foodPreferenceModifier);
            excludeFoodModifier.addAll(nutritionOrder.excludeFoodModifier);
            oralDiet = nutritionOrder.oralDiet;
            supplement.addAll(nutritionOrder.supplement);
            enteralFormula = nutritionOrder.enteralFormula;
            note.addAll(nutritionOrder.note);
            return this;
        }
    }

    /**
     * Diet given orally in contrast to enteral (tube) feeding.
     */
    public static class OralDiet extends BackboneElement {
        @Summary
        @Binding(
            bindingName = "OralDiet",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Codes used to indicate the type of diet being ordered for a patient.",
            valueSet = "http://hl7.org/fhir/ValueSet/diet-type"
        )
        private final List<CodeableConcept> type;
        private final List<Timing> schedule;
        private final List<Nutrient> nutrient;
        private final List<Texture> texture;
        @Binding(
            bindingName = "FluidConsistencyType",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Codes used to represent the consistency of fluids and liquids provided to the patient.",
            valueSet = "http://hl7.org/fhir/ValueSet/consistency-type"
        )
        private final List<CodeableConcept> fluidConsistencyType;
        @Summary
        private final String instruction;

        private volatile int hashCode;

        private OralDiet(Builder builder) {
            super(builder);
            type = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.type, "type"));
            schedule = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.schedule, "schedule"));
            nutrient = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.nutrient, "nutrient"));
            texture = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.texture, "texture"));
            fluidConsistencyType = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.fluidConsistencyType, "fluidConsistencyType"));
            instruction = builder.instruction;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * The kind of diet or dietary restriction such as fiber restricted diet or diabetic diet.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
         */
        public List<CodeableConcept> getType() {
            return type;
        }

        /**
         * The time period and frequency at which the diet should be given. The diet should be given for the combination of all 
         * schedules if more than one schedule is present.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Timing} that may be empty.
         */
        public List<Timing> getSchedule() {
            return schedule;
        }

        /**
         * Class that defines the quantity and type of nutrient modifications (for example carbohydrate, fiber or sodium) 
         * required for the oral diet.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Nutrient} that may be empty.
         */
        public List<Nutrient> getNutrient() {
            return nutrient;
        }

        /**
         * Class that describes any texture modifications required for the patient to safely consume various types of solid foods.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Texture} that may be empty.
         */
        public List<Texture> getTexture() {
            return texture;
        }

        /**
         * The required consistency (e.g. honey-thick, nectar-thick, thin, thickened.) of liquids or fluids served to the patient.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
         */
        public List<CodeableConcept> getFluidConsistencyType() {
            return fluidConsistencyType;
        }

        /**
         * Free text or additional instructions or information pertaining to the oral diet.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getInstruction() {
            return instruction;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                !type.isEmpty() || 
                !schedule.isEmpty() || 
                !nutrient.isEmpty() || 
                !texture.isEmpty() || 
                !fluidConsistencyType.isEmpty() || 
                (instruction != null);
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
                    accept(type, "type", visitor, CodeableConcept.class);
                    accept(schedule, "schedule", visitor, Timing.class);
                    accept(nutrient, "nutrient", visitor, Nutrient.class);
                    accept(texture, "texture", visitor, Texture.class);
                    accept(fluidConsistencyType, "fluidConsistencyType", visitor, CodeableConcept.class);
                    accept(instruction, "instruction", visitor);
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
            OralDiet other = (OralDiet) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(type, other.type) && 
                Objects.equals(schedule, other.schedule) && 
                Objects.equals(nutrient, other.nutrient) && 
                Objects.equals(texture, other.texture) && 
                Objects.equals(fluidConsistencyType, other.fluidConsistencyType) && 
                Objects.equals(instruction, other.instruction);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    type, 
                    schedule, 
                    nutrient, 
                    texture, 
                    fluidConsistencyType, 
                    instruction);
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
            private List<CodeableConcept> type = new ArrayList<>();
            private List<Timing> schedule = new ArrayList<>();
            private List<Nutrient> nutrient = new ArrayList<>();
            private List<Texture> texture = new ArrayList<>();
            private List<CodeableConcept> fluidConsistencyType = new ArrayList<>();
            private String instruction;

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
             * The kind of diet or dietary restriction such as fiber restricted diet or diabetic diet.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param type
             *     Type of oral diet or diet restrictions that describe what can be consumed orally
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
             * The kind of diet or dietary restriction such as fiber restricted diet or diabetic diet.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param type
             *     Type of oral diet or diet restrictions that describe what can be consumed orally
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(Collection<CodeableConcept> type) {
                this.type = new ArrayList<>(type);
                return this;
            }

            /**
             * The time period and frequency at which the diet should be given. The diet should be given for the combination of all 
             * schedules if more than one schedule is present.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param schedule
             *     Scheduled frequency of diet
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder schedule(Timing... schedule) {
                for (Timing value : schedule) {
                    this.schedule.add(value);
                }
                return this;
            }

            /**
             * The time period and frequency at which the diet should be given. The diet should be given for the combination of all 
             * schedules if more than one schedule is present.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param schedule
             *     Scheduled frequency of diet
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder schedule(Collection<Timing> schedule) {
                this.schedule = new ArrayList<>(schedule);
                return this;
            }

            /**
             * Class that defines the quantity and type of nutrient modifications (for example carbohydrate, fiber or sodium) 
             * required for the oral diet.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param nutrient
             *     Required nutrient modifications
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder nutrient(Nutrient... nutrient) {
                for (Nutrient value : nutrient) {
                    this.nutrient.add(value);
                }
                return this;
            }

            /**
             * Class that defines the quantity and type of nutrient modifications (for example carbohydrate, fiber or sodium) 
             * required for the oral diet.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param nutrient
             *     Required nutrient modifications
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder nutrient(Collection<Nutrient> nutrient) {
                this.nutrient = new ArrayList<>(nutrient);
                return this;
            }

            /**
             * Class that describes any texture modifications required for the patient to safely consume various types of solid foods.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param texture
             *     Required texture modifications
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder texture(Texture... texture) {
                for (Texture value : texture) {
                    this.texture.add(value);
                }
                return this;
            }

            /**
             * Class that describes any texture modifications required for the patient to safely consume various types of solid foods.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param texture
             *     Required texture modifications
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder texture(Collection<Texture> texture) {
                this.texture = new ArrayList<>(texture);
                return this;
            }

            /**
             * The required consistency (e.g. honey-thick, nectar-thick, thin, thickened.) of liquids or fluids served to the patient.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param fluidConsistencyType
             *     The required consistency of fluids and liquids provided to the patient
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder fluidConsistencyType(CodeableConcept... fluidConsistencyType) {
                for (CodeableConcept value : fluidConsistencyType) {
                    this.fluidConsistencyType.add(value);
                }
                return this;
            }

            /**
             * The required consistency (e.g. honey-thick, nectar-thick, thin, thickened.) of liquids or fluids served to the patient.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param fluidConsistencyType
             *     The required consistency of fluids and liquids provided to the patient
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder fluidConsistencyType(Collection<CodeableConcept> fluidConsistencyType) {
                this.fluidConsistencyType = new ArrayList<>(fluidConsistencyType);
                return this;
            }

            /**
             * Free text or additional instructions or information pertaining to the oral diet.
             * 
             * @param instruction
             *     Instructions or additional information about the oral diet
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder instruction(String instruction) {
                this.instruction = instruction;
                return this;
            }

            /**
             * Build the {@link OralDiet}
             * 
             * @return
             *     An immutable object of type {@link OralDiet}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid OralDiet per the base specification
             */
            @Override
            public OralDiet build() {
                return new OralDiet(this);
            }

            protected Builder from(OralDiet oralDiet) {
                super.from(oralDiet);
                type.addAll(oralDiet.type);
                schedule.addAll(oralDiet.schedule);
                nutrient.addAll(oralDiet.nutrient);
                texture.addAll(oralDiet.texture);
                fluidConsistencyType.addAll(oralDiet.fluidConsistencyType);
                instruction = oralDiet.instruction;
                return this;
            }
        }

        /**
         * Class that defines the quantity and type of nutrient modifications (for example carbohydrate, fiber or sodium) 
         * required for the oral diet.
         */
        public static class Nutrient extends BackboneElement {
            @Binding(
                bindingName = "NutrientModifier",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Codes for types of nutrients that are being modified such as carbohydrate or sodium.",
                valueSet = "http://hl7.org/fhir/ValueSet/nutrient-code"
            )
            private final CodeableConcept modifier;
            private final SimpleQuantity amount;

            private volatile int hashCode;

            private Nutrient(Builder builder) {
                super(builder);
                modifier = builder.modifier;
                amount = builder.amount;
                ValidationSupport.requireValueOrChildren(this);
            }

            /**
             * The nutrient that is being modified such as carbohydrate or sodium.
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept} that may be null.
             */
            public CodeableConcept getModifier() {
                return modifier;
            }

            /**
             * The quantity of the specified nutrient to include in diet.
             * 
             * @return
             *     An immutable object of type {@link SimpleQuantity} that may be null.
             */
            public SimpleQuantity getAmount() {
                return amount;
            }

            @Override
            public boolean hasChildren() {
                return super.hasChildren() || 
                    (modifier != null) || 
                    (amount != null);
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
                        accept(modifier, "modifier", visitor);
                        accept(amount, "amount", visitor);
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
                Nutrient other = (Nutrient) obj;
                return Objects.equals(id, other.id) && 
                    Objects.equals(extension, other.extension) && 
                    Objects.equals(modifierExtension, other.modifierExtension) && 
                    Objects.equals(modifier, other.modifier) && 
                    Objects.equals(amount, other.amount);
            }

            @Override
            public int hashCode() {
                int result = hashCode;
                if (result == 0) {
                    result = Objects.hash(id, 
                        extension, 
                        modifierExtension, 
                        modifier, 
                        amount);
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
                private CodeableConcept modifier;
                private SimpleQuantity amount;

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
                 * The nutrient that is being modified such as carbohydrate or sodium.
                 * 
                 * @param modifier
                 *     Type of nutrient that is being modified
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder modifier(CodeableConcept modifier) {
                    this.modifier = modifier;
                    return this;
                }

                /**
                 * The quantity of the specified nutrient to include in diet.
                 * 
                 * @param amount
                 *     Quantity of the specified nutrient
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder amount(SimpleQuantity amount) {
                    this.amount = amount;
                    return this;
                }

                /**
                 * Build the {@link Nutrient}
                 * 
                 * @return
                 *     An immutable object of type {@link Nutrient}
                 * @throws IllegalStateException
                 *     if the current state cannot be built into a valid Nutrient per the base specification
                 */
                @Override
                public Nutrient build() {
                    return new Nutrient(this);
                }

                protected Builder from(Nutrient nutrient) {
                    super.from(nutrient);
                    modifier = nutrient.modifier;
                    amount = nutrient.amount;
                    return this;
                }
            }
        }

        /**
         * Class that describes any texture modifications required for the patient to safely consume various types of solid foods.
         */
        public static class Texture extends BackboneElement {
            @Binding(
                bindingName = "TextureModifier",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Codes for food consistency types or texture modifications to apply to foods.",
                valueSet = "http://hl7.org/fhir/ValueSet/texture-code"
            )
            private final CodeableConcept modifier;
            @Binding(
                bindingName = "TextureModifiedFoodType",
                strength = BindingStrength.ValueSet.EXAMPLE,
                description = "Codes for types of foods that are texture-modified.",
                valueSet = "http://hl7.org/fhir/ValueSet/modified-foodtype"
            )
            private final CodeableConcept foodType;

            private volatile int hashCode;

            private Texture(Builder builder) {
                super(builder);
                modifier = builder.modifier;
                foodType = builder.foodType;
                ValidationSupport.requireValueOrChildren(this);
            }

            /**
             * Any texture modifications (for solid foods) that should be made, e.g. easy to chew, chopped, ground, and pureed.
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept} that may be null.
             */
            public CodeableConcept getModifier() {
                return modifier;
            }

            /**
             * The food type(s) (e.g. meats, all foods) that the texture modification applies to. This could be all foods types.
             * 
             * @return
             *     An immutable object of type {@link CodeableConcept} that may be null.
             */
            public CodeableConcept getFoodType() {
                return foodType;
            }

            @Override
            public boolean hasChildren() {
                return super.hasChildren() || 
                    (modifier != null) || 
                    (foodType != null);
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
                        accept(modifier, "modifier", visitor);
                        accept(foodType, "foodType", visitor);
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
                Texture other = (Texture) obj;
                return Objects.equals(id, other.id) && 
                    Objects.equals(extension, other.extension) && 
                    Objects.equals(modifierExtension, other.modifierExtension) && 
                    Objects.equals(modifier, other.modifier) && 
                    Objects.equals(foodType, other.foodType);
            }

            @Override
            public int hashCode() {
                int result = hashCode;
                if (result == 0) {
                    result = Objects.hash(id, 
                        extension, 
                        modifierExtension, 
                        modifier, 
                        foodType);
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
                private CodeableConcept modifier;
                private CodeableConcept foodType;

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
                 * Any texture modifications (for solid foods) that should be made, e.g. easy to chew, chopped, ground, and pureed.
                 * 
                 * @param modifier
                 *     Code to indicate how to alter the texture of the foods, e.g. pureed
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder modifier(CodeableConcept modifier) {
                    this.modifier = modifier;
                    return this;
                }

                /**
                 * The food type(s) (e.g. meats, all foods) that the texture modification applies to. This could be all foods types.
                 * 
                 * @param foodType
                 *     Concepts that are used to identify an entity that is ingested for nutritional purposes
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder foodType(CodeableConcept foodType) {
                    this.foodType = foodType;
                    return this;
                }

                /**
                 * Build the {@link Texture}
                 * 
                 * @return
                 *     An immutable object of type {@link Texture}
                 * @throws IllegalStateException
                 *     if the current state cannot be built into a valid Texture per the base specification
                 */
                @Override
                public Texture build() {
                    return new Texture(this);
                }

                protected Builder from(Texture texture) {
                    super.from(texture);
                    modifier = texture.modifier;
                    foodType = texture.foodType;
                    return this;
                }
            }
        }
    }

    /**
     * Oral nutritional products given in order to add further nutritional value to the patient's diet.
     */
    public static class Supplement extends BackboneElement {
        @Summary
        @Binding(
            bindingName = "SupplementType",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Codes for nutritional supplements to be provided to the patient.",
            valueSet = "http://hl7.org/fhir/ValueSet/supplement-type"
        )
        private final CodeableConcept type;
        private final String productName;
        private final List<Timing> schedule;
        private final SimpleQuantity quantity;
        @Summary
        private final String instruction;

        private volatile int hashCode;

        private Supplement(Builder builder) {
            super(builder);
            type = builder.type;
            productName = builder.productName;
            schedule = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.schedule, "schedule"));
            quantity = builder.quantity;
            instruction = builder.instruction;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * The kind of nutritional supplement product required such as a high protein or pediatric clear liquid supplement.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getType() {
            return type;
        }

        /**
         * The product or brand name of the nutritional supplement such as "Acme Protein Shake".
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getProductName() {
            return productName;
        }

        /**
         * The time period and frequency at which the supplement(s) should be given. The supplement should be given for the 
         * combination of all schedules if more than one schedule is present.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Timing} that may be empty.
         */
        public List<Timing> getSchedule() {
            return schedule;
        }

        /**
         * The amount of the nutritional supplement to be given.
         * 
         * @return
         *     An immutable object of type {@link SimpleQuantity} that may be null.
         */
        public SimpleQuantity getQuantity() {
            return quantity;
        }

        /**
         * Free text or additional instructions or information pertaining to the oral supplement.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getInstruction() {
            return instruction;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (type != null) || 
                (productName != null) || 
                !schedule.isEmpty() || 
                (quantity != null) || 
                (instruction != null);
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
                    accept(productName, "productName", visitor);
                    accept(schedule, "schedule", visitor, Timing.class);
                    accept(quantity, "quantity", visitor);
                    accept(instruction, "instruction", visitor);
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
            Supplement other = (Supplement) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(type, other.type) && 
                Objects.equals(productName, other.productName) && 
                Objects.equals(schedule, other.schedule) && 
                Objects.equals(quantity, other.quantity) && 
                Objects.equals(instruction, other.instruction);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    type, 
                    productName, 
                    schedule, 
                    quantity, 
                    instruction);
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
            private String productName;
            private List<Timing> schedule = new ArrayList<>();
            private SimpleQuantity quantity;
            private String instruction;

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
             * The kind of nutritional supplement product required such as a high protein or pediatric clear liquid supplement.
             * 
             * @param type
             *     Type of supplement product requested
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder type(CodeableConcept type) {
                this.type = type;
                return this;
            }

            /**
             * The product or brand name of the nutritional supplement such as "Acme Protein Shake".
             * 
             * @param productName
             *     Product or brand name of the nutritional supplement
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder productName(String productName) {
                this.productName = productName;
                return this;
            }

            /**
             * The time period and frequency at which the supplement(s) should be given. The supplement should be given for the 
             * combination of all schedules if more than one schedule is present.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param schedule
             *     Scheduled frequency of supplement
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder schedule(Timing... schedule) {
                for (Timing value : schedule) {
                    this.schedule.add(value);
                }
                return this;
            }

            /**
             * The time period and frequency at which the supplement(s) should be given. The supplement should be given for the 
             * combination of all schedules if more than one schedule is present.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param schedule
             *     Scheduled frequency of supplement
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder schedule(Collection<Timing> schedule) {
                this.schedule = new ArrayList<>(schedule);
                return this;
            }

            /**
             * The amount of the nutritional supplement to be given.
             * 
             * @param quantity
             *     Amount of the nutritional supplement
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder quantity(SimpleQuantity quantity) {
                this.quantity = quantity;
                return this;
            }

            /**
             * Free text or additional instructions or information pertaining to the oral supplement.
             * 
             * @param instruction
             *     Instructions or additional information about the oral supplement
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder instruction(String instruction) {
                this.instruction = instruction;
                return this;
            }

            /**
             * Build the {@link Supplement}
             * 
             * @return
             *     An immutable object of type {@link Supplement}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Supplement per the base specification
             */
            @Override
            public Supplement build() {
                return new Supplement(this);
            }

            protected Builder from(Supplement supplement) {
                super.from(supplement);
                type = supplement.type;
                productName = supplement.productName;
                schedule.addAll(supplement.schedule);
                quantity = supplement.quantity;
                instruction = supplement.instruction;
                return this;
            }
        }
    }

    /**
     * Feeding provided through the gastrointestinal tract via a tube, catheter, or stoma that delivers nutrition distal to 
     * the oral cavity.
     */
    public static class EnteralFormula extends BackboneElement {
        @Summary
        @Binding(
            bindingName = "EnteralFormulaType",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Codes for type of enteral formula to be administered to patient.",
            valueSet = "http://hl7.org/fhir/ValueSet/entformula-type"
        )
        private final CodeableConcept baseFormulaType;
        private final String baseFormulaProductName;
        @Binding(
            bindingName = "EnteralFormulaAdditiveType",
            strength = BindingStrength.ValueSet.EXAMPLE,
            description = "Codes for the type of modular component such as protein, carbohydrate or fiber to be provided in addition to or mixed with the base formula.",
            valueSet = "http://hl7.org/fhir/ValueSet/entformula-additive"
        )
        private final CodeableConcept additiveType;
        private final String additiveProductName;
        private final SimpleQuantity caloricDensity;
        @Binding(
            bindingName = "EnteralRouteOfAdministration",
            strength = BindingStrength.ValueSet.EXTENSIBLE,
            description = "Codes specifying the route of administration of enteral formula.",
            valueSet = "http://hl7.org/fhir/ValueSet/enteral-route"
        )
        private final CodeableConcept routeofAdministration;
        private final List<Administration> administration;
        private final SimpleQuantity maxVolumeToDeliver;
        @Summary
        private final String administrationInstruction;

        private volatile int hashCode;

        private EnteralFormula(Builder builder) {
            super(builder);
            baseFormulaType = builder.baseFormulaType;
            baseFormulaProductName = builder.baseFormulaProductName;
            additiveType = builder.additiveType;
            additiveProductName = builder.additiveProductName;
            caloricDensity = builder.caloricDensity;
            routeofAdministration = builder.routeofAdministration;
            administration = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.administration, "administration"));
            maxVolumeToDeliver = builder.maxVolumeToDeliver;
            administrationInstruction = builder.administrationInstruction;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * The type of enteral or infant formula such as an adult standard formula with fiber or a soy-based infant formula.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getBaseFormulaType() {
            return baseFormulaType;
        }

        /**
         * The product or brand name of the enteral or infant formula product such as "ACME Adult Standard Formula".
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getBaseFormulaProductName() {
            return baseFormulaProductName;
        }

        /**
         * Indicates the type of modular component such as protein, carbohydrate, fat or fiber to be provided in addition to or 
         * mixed with the base formula.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getAdditiveType() {
            return additiveType;
        }

        /**
         * The product or brand name of the type of modular component to be added to the formula.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getAdditiveProductName() {
            return additiveProductName;
        }

        /**
         * The amount of energy (calories) that the formula should provide per specified volume, typically per mL or fluid oz. 
         * For example, an infant may require a formula that provides 24 calories per fluid ounce or an adult may require an 
         * enteral formula that provides 1.5 calorie/mL.
         * 
         * @return
         *     An immutable object of type {@link SimpleQuantity} that may be null.
         */
        public SimpleQuantity getCaloricDensity() {
            return caloricDensity;
        }

        /**
         * The route or physiological path of administration into the patient's gastrointestinal tract for purposes of providing 
         * the formula feeding, e.g. nasogastric tube.
         * 
         * @return
         *     An immutable object of type {@link CodeableConcept} that may be null.
         */
        public CodeableConcept getRouteofAdministration() {
            return routeofAdministration;
        }

        /**
         * Formula administration instructions as structured data. This repeating structure allows for changing the 
         * administration rate or volume over time for both bolus and continuous feeding. An example of this would be an 
         * instruction to increase the rate of continuous feeding every 2 hours.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Administration} that may be empty.
         */
        public List<Administration> getAdministration() {
            return administration;
        }

        /**
         * The maximum total quantity of formula that may be administered to a subject over the period of time, e.g. 1440 mL over 
         * 24 hours.
         * 
         * @return
         *     An immutable object of type {@link SimpleQuantity} that may be null.
         */
        public SimpleQuantity getMaxVolumeToDeliver() {
            return maxVolumeToDeliver;
        }

        /**
         * Free text formula administration, feeding instructions or additional instructions or information.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getAdministrationInstruction() {
            return administrationInstruction;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (baseFormulaType != null) || 
                (baseFormulaProductName != null) || 
                (additiveType != null) || 
                (additiveProductName != null) || 
                (caloricDensity != null) || 
                (routeofAdministration != null) || 
                !administration.isEmpty() || 
                (maxVolumeToDeliver != null) || 
                (administrationInstruction != null);
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
                    accept(baseFormulaType, "baseFormulaType", visitor);
                    accept(baseFormulaProductName, "baseFormulaProductName", visitor);
                    accept(additiveType, "additiveType", visitor);
                    accept(additiveProductName, "additiveProductName", visitor);
                    accept(caloricDensity, "caloricDensity", visitor);
                    accept(routeofAdministration, "routeofAdministration", visitor);
                    accept(administration, "administration", visitor, Administration.class);
                    accept(maxVolumeToDeliver, "maxVolumeToDeliver", visitor);
                    accept(administrationInstruction, "administrationInstruction", visitor);
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
            EnteralFormula other = (EnteralFormula) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(baseFormulaType, other.baseFormulaType) && 
                Objects.equals(baseFormulaProductName, other.baseFormulaProductName) && 
                Objects.equals(additiveType, other.additiveType) && 
                Objects.equals(additiveProductName, other.additiveProductName) && 
                Objects.equals(caloricDensity, other.caloricDensity) && 
                Objects.equals(routeofAdministration, other.routeofAdministration) && 
                Objects.equals(administration, other.administration) && 
                Objects.equals(maxVolumeToDeliver, other.maxVolumeToDeliver) && 
                Objects.equals(administrationInstruction, other.administrationInstruction);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    baseFormulaType, 
                    baseFormulaProductName, 
                    additiveType, 
                    additiveProductName, 
                    caloricDensity, 
                    routeofAdministration, 
                    administration, 
                    maxVolumeToDeliver, 
                    administrationInstruction);
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
            private CodeableConcept baseFormulaType;
            private String baseFormulaProductName;
            private CodeableConcept additiveType;
            private String additiveProductName;
            private SimpleQuantity caloricDensity;
            private CodeableConcept routeofAdministration;
            private List<Administration> administration = new ArrayList<>();
            private SimpleQuantity maxVolumeToDeliver;
            private String administrationInstruction;

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
             * The type of enteral or infant formula such as an adult standard formula with fiber or a soy-based infant formula.
             * 
             * @param baseFormulaType
             *     Type of enteral or infant formula
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder baseFormulaType(CodeableConcept baseFormulaType) {
                this.baseFormulaType = baseFormulaType;
                return this;
            }

            /**
             * The product or brand name of the enteral or infant formula product such as "ACME Adult Standard Formula".
             * 
             * @param baseFormulaProductName
             *     Product or brand name of the enteral or infant formula
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder baseFormulaProductName(String baseFormulaProductName) {
                this.baseFormulaProductName = baseFormulaProductName;
                return this;
            }

            /**
             * Indicates the type of modular component such as protein, carbohydrate, fat or fiber to be provided in addition to or 
             * mixed with the base formula.
             * 
             * @param additiveType
             *     Type of modular component to add to the feeding
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder additiveType(CodeableConcept additiveType) {
                this.additiveType = additiveType;
                return this;
            }

            /**
             * The product or brand name of the type of modular component to be added to the formula.
             * 
             * @param additiveProductName
             *     Product or brand name of the modular additive
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder additiveProductName(String additiveProductName) {
                this.additiveProductName = additiveProductName;
                return this;
            }

            /**
             * The amount of energy (calories) that the formula should provide per specified volume, typically per mL or fluid oz. 
             * For example, an infant may require a formula that provides 24 calories per fluid ounce or an adult may require an 
             * enteral formula that provides 1.5 calorie/mL.
             * 
             * @param caloricDensity
             *     Amount of energy per specified volume that is required
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder caloricDensity(SimpleQuantity caloricDensity) {
                this.caloricDensity = caloricDensity;
                return this;
            }

            /**
             * The route or physiological path of administration into the patient's gastrointestinal tract for purposes of providing 
             * the formula feeding, e.g. nasogastric tube.
             * 
             * @param routeofAdministration
             *     How the formula should enter the patient's gastrointestinal tract
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder routeofAdministration(CodeableConcept routeofAdministration) {
                this.routeofAdministration = routeofAdministration;
                return this;
            }

            /**
             * Formula administration instructions as structured data. This repeating structure allows for changing the 
             * administration rate or volume over time for both bolus and continuous feeding. An example of this would be an 
             * instruction to increase the rate of continuous feeding every 2 hours.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param administration
             *     Formula feeding instruction as structured data
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder administration(Administration... administration) {
                for (Administration value : administration) {
                    this.administration.add(value);
                }
                return this;
            }

            /**
             * Formula administration instructions as structured data. This repeating structure allows for changing the 
             * administration rate or volume over time for both bolus and continuous feeding. An example of this would be an 
             * instruction to increase the rate of continuous feeding every 2 hours.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param administration
             *     Formula feeding instruction as structured data
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder administration(Collection<Administration> administration) {
                this.administration = new ArrayList<>(administration);
                return this;
            }

            /**
             * The maximum total quantity of formula that may be administered to a subject over the period of time, e.g. 1440 mL over 
             * 24 hours.
             * 
             * @param maxVolumeToDeliver
             *     Upper limit on formula volume per unit of time
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder maxVolumeToDeliver(SimpleQuantity maxVolumeToDeliver) {
                this.maxVolumeToDeliver = maxVolumeToDeliver;
                return this;
            }

            /**
             * Free text formula administration, feeding instructions or additional instructions or information.
             * 
             * @param administrationInstruction
             *     Formula feeding instructions expressed as text
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder administrationInstruction(String administrationInstruction) {
                this.administrationInstruction = administrationInstruction;
                return this;
            }

            /**
             * Build the {@link EnteralFormula}
             * 
             * @return
             *     An immutable object of type {@link EnteralFormula}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid EnteralFormula per the base specification
             */
            @Override
            public EnteralFormula build() {
                return new EnteralFormula(this);
            }

            protected Builder from(EnteralFormula enteralFormula) {
                super.from(enteralFormula);
                baseFormulaType = enteralFormula.baseFormulaType;
                baseFormulaProductName = enteralFormula.baseFormulaProductName;
                additiveType = enteralFormula.additiveType;
                additiveProductName = enteralFormula.additiveProductName;
                caloricDensity = enteralFormula.caloricDensity;
                routeofAdministration = enteralFormula.routeofAdministration;
                administration.addAll(enteralFormula.administration);
                maxVolumeToDeliver = enteralFormula.maxVolumeToDeliver;
                administrationInstruction = enteralFormula.administrationInstruction;
                return this;
            }
        }

        /**
         * Formula administration instructions as structured data. This repeating structure allows for changing the 
         * administration rate or volume over time for both bolus and continuous feeding. An example of this would be an 
         * instruction to increase the rate of continuous feeding every 2 hours.
         */
        public static class Administration extends BackboneElement {
            private final Timing schedule;
            private final SimpleQuantity quantity;
            @Choice({ SimpleQuantity.class, Ratio.class })
            private final Element rate;

            private volatile int hashCode;

            private Administration(Builder builder) {
                super(builder);
                schedule = builder.schedule;
                quantity = builder.quantity;
                rate = ValidationSupport.choiceElement(builder.rate, "rate", SimpleQuantity.class, Ratio.class);
                ValidationSupport.requireValueOrChildren(this);
            }

            /**
             * The time period and frequency at which the enteral formula should be delivered to the patient.
             * 
             * @return
             *     An immutable object of type {@link Timing} that may be null.
             */
            public Timing getSchedule() {
                return schedule;
            }

            /**
             * The volume of formula to provide to the patient per the specified administration schedule.
             * 
             * @return
             *     An immutable object of type {@link SimpleQuantity} that may be null.
             */
            public SimpleQuantity getQuantity() {
                return quantity;
            }

            /**
             * The rate of administration of formula via a feeding pump, e.g. 60 mL per hour, according to the specified schedule.
             * 
             * @return
             *     An immutable object of type {@link Element} that may be null.
             */
            public Element getRate() {
                return rate;
            }

            @Override
            public boolean hasChildren() {
                return super.hasChildren() || 
                    (schedule != null) || 
                    (quantity != null) || 
                    (rate != null);
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
                        accept(schedule, "schedule", visitor);
                        accept(quantity, "quantity", visitor);
                        accept(rate, "rate", visitor);
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
                Administration other = (Administration) obj;
                return Objects.equals(id, other.id) && 
                    Objects.equals(extension, other.extension) && 
                    Objects.equals(modifierExtension, other.modifierExtension) && 
                    Objects.equals(schedule, other.schedule) && 
                    Objects.equals(quantity, other.quantity) && 
                    Objects.equals(rate, other.rate);
            }

            @Override
            public int hashCode() {
                int result = hashCode;
                if (result == 0) {
                    result = Objects.hash(id, 
                        extension, 
                        modifierExtension, 
                        schedule, 
                        quantity, 
                        rate);
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
                private Timing schedule;
                private SimpleQuantity quantity;
                private Element rate;

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
                 * The time period and frequency at which the enteral formula should be delivered to the patient.
                 * 
                 * @param schedule
                 *     Scheduled frequency of enteral feeding
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder schedule(Timing schedule) {
                    this.schedule = schedule;
                    return this;
                }

                /**
                 * The volume of formula to provide to the patient per the specified administration schedule.
                 * 
                 * @param quantity
                 *     The volume of formula to provide
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder quantity(SimpleQuantity quantity) {
                    this.quantity = quantity;
                    return this;
                }

                /**
                 * The rate of administration of formula via a feeding pump, e.g. 60 mL per hour, according to the specified schedule.
                 * 
                 * <p>This is a choice element with the following allowed types:
                 * <ul>
                 * <li>{@link SimpleQuantity}</li>
                 * <li>{@link Ratio}</li>
                 * </ul>
                 * 
                 * @param rate
                 *     Speed with which the formula is provided per period of time
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder rate(Element rate) {
                    this.rate = rate;
                    return this;
                }

                /**
                 * Build the {@link Administration}
                 * 
                 * @return
                 *     An immutable object of type {@link Administration}
                 * @throws IllegalStateException
                 *     if the current state cannot be built into a valid Administration per the base specification
                 */
                @Override
                public Administration build() {
                    return new Administration(this);
                }

                protected Builder from(Administration administration) {
                    super.from(administration);
                    schedule = administration.schedule;
                    quantity = administration.quantity;
                    rate = administration.rate;
                    return this;
                }
            }
        }
    }
}
