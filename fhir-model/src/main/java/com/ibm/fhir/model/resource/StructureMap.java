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
import com.ibm.fhir.model.annotation.Required;
import com.ibm.fhir.model.annotation.Summary;
import com.ibm.fhir.model.type.Address;
import com.ibm.fhir.model.type.Age;
import com.ibm.fhir.model.type.Annotation;
import com.ibm.fhir.model.type.Attachment;
import com.ibm.fhir.model.type.BackboneElement;
import com.ibm.fhir.model.type.Base64Binary;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.Canonical;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.ContactDetail;
import com.ibm.fhir.model.type.ContactPoint;
import com.ibm.fhir.model.type.Contributor;
import com.ibm.fhir.model.type.Count;
import com.ibm.fhir.model.type.DataRequirement;
import com.ibm.fhir.model.type.Date;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Decimal;
import com.ibm.fhir.model.type.Distance;
import com.ibm.fhir.model.type.Dosage;
import com.ibm.fhir.model.type.Duration;
import com.ibm.fhir.model.type.Element;
import com.ibm.fhir.model.type.Expression;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.HumanName;
import com.ibm.fhir.model.type.Id;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Instant;
import com.ibm.fhir.model.type.Integer;
import com.ibm.fhir.model.type.Markdown;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Money;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Oid;
import com.ibm.fhir.model.type.ParameterDefinition;
import com.ibm.fhir.model.type.Period;
import com.ibm.fhir.model.type.PositiveInt;
import com.ibm.fhir.model.type.Quantity;
import com.ibm.fhir.model.type.Range;
import com.ibm.fhir.model.type.Ratio;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.RelatedArtifact;
import com.ibm.fhir.model.type.SampledData;
import com.ibm.fhir.model.type.Signature;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Time;
import com.ibm.fhir.model.type.Timing;
import com.ibm.fhir.model.type.TriggerDefinition;
import com.ibm.fhir.model.type.UnsignedInt;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.Url;
import com.ibm.fhir.model.type.UsageContext;
import com.ibm.fhir.model.type.Uuid;
import com.ibm.fhir.model.type.code.BindingStrength;
import com.ibm.fhir.model.type.code.PublicationStatus;
import com.ibm.fhir.model.type.code.StructureMapContextType;
import com.ibm.fhir.model.type.code.StructureMapGroupTypeMode;
import com.ibm.fhir.model.type.code.StructureMapInputMode;
import com.ibm.fhir.model.type.code.StructureMapModelMode;
import com.ibm.fhir.model.type.code.StructureMapSourceListMode;
import com.ibm.fhir.model.type.code.StructureMapTargetListMode;
import com.ibm.fhir.model.type.code.StructureMapTransform;
import com.ibm.fhir.model.util.ValidationSupport;
import com.ibm.fhir.model.visitor.Visitor;

/**
 * A Map of relationships between 2 structures that can be used to transform data.
 */
@Constraint(
    id = "smp-0",
    level = "Warning",
    location = "(base)",
    description = "Name should be usable as an identifier for the module by machine processing applications such as code generation",
    expression = "name.matches('[A-Z]([A-Za-z0-9_]){0,254}')"
)
@Constraint(
    id = "smp-1",
    level = "Rule",
    location = "StructureMap.group.rule.target",
    description = "Can only have an element if you have a context",
    expression = "element.exists() implies context.exists()"
)
@Constraint(
    id = "smp-2",
    level = "Rule",
    location = "StructureMap.group.rule.target",
    description = "Must have a contextType if you have a context",
    expression = "context.exists() implies contextType.exists()"
)
@Constraint(
    id = "structureMap-3",
    level = "Warning",
    location = "(base)",
    description = "SHALL, if possible, at least contain a code from value set http://hl7.org/fhir/ValueSet/jurisdiction",
    expression = "jurisdiction.exists() implies (jurisdiction.all(memberOf('http://hl7.org/fhir/ValueSet/jurisdiction', 'extensible')))"
)
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class StructureMap extends DomainResource {
    @Summary
    @Required
    private final Uri url;
    @Summary
    private final List<Identifier> identifier;
    @Summary
    private final String version;
    @Summary
    @Required
    private final String name;
    @Summary
    private final String title;
    @Summary
    @Binding(
        bindingName = "PublicationStatus",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "The lifecycle status of an artifact.",
        valueSet = "http://hl7.org/fhir/ValueSet/publication-status|4.0.1"
    )
    @Required
    private final PublicationStatus status;
    @Summary
    private final Boolean experimental;
    @Summary
    private final DateTime date;
    @Summary
    private final String publisher;
    @Summary
    private final List<ContactDetail> contact;
    private final Markdown description;
    @Summary
    private final List<UsageContext> useContext;
    @Summary
    @Binding(
        bindingName = "Jurisdiction",
        strength = BindingStrength.ValueSet.EXTENSIBLE,
        description = "Countries and regions within which this artifact is targeted for use.",
        valueSet = "http://hl7.org/fhir/ValueSet/jurisdiction"
    )
    private final List<CodeableConcept> jurisdiction;
    private final Markdown purpose;
    private final Markdown copyright;
    @Summary
    private final List<Structure> structure;
    @Summary
    private final List<Canonical> _import;
    @Summary
    @Required
    private final List<Group> group;

    private volatile int hashCode;

    private StructureMap(Builder builder) {
        super(builder);
        url = ValidationSupport.requireNonNull(builder.url, "url");
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        version = builder.version;
        name = ValidationSupport.requireNonNull(builder.name, "name");
        title = builder.title;
        status = ValidationSupport.requireNonNull(builder.status, "status");
        experimental = builder.experimental;
        date = builder.date;
        publisher = builder.publisher;
        contact = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.contact, "contact"));
        description = builder.description;
        useContext = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.useContext, "useContext"));
        jurisdiction = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.jurisdiction, "jurisdiction"));
        purpose = builder.purpose;
        copyright = builder.copyright;
        structure = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.structure, "structure"));
        _import = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder._import, "import"));
        group = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.group, "group"));
        ValidationSupport.requireChildren(this);
    }

    /**
     * An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or 
     * an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at 
     * which at which an authoritative instance of this structure map is (or will be) published. This URL can be the target 
     * of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.
     * 
     * @return
     *     An immutable object of type {@link Uri} that is non-null.
     */
    public Uri getUrl() {
        return url;
    }

    /**
     * A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced 
     * in a specification, model, design or an instance.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier} that may be empty.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * The identifier that is used to identify this version of the structure map when it is referenced in a specification, 
     * model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be 
     * globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is 
     * also no expectation that versions can be placed in a lexicographical sequence.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getVersion() {
        return version;
    }

    /**
     * A natural language name identifying the structure map. This name should be usable as an identifier for the module by 
     * machine processing applications such as code generation.
     * 
     * @return
     *     An immutable object of type {@link String} that is non-null.
     */
    public String getName() {
        return name;
    }

    /**
     * A short, descriptive, user-friendly title for the structure map.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getTitle() {
        return title;
    }

    /**
     * The status of this structure map. Enables tracking the life-cycle of the content.
     * 
     * @return
     *     An immutable object of type {@link PublicationStatus} that is non-null.
     */
    public PublicationStatus getStatus() {
        return status;
    }

    /**
     * A Boolean value to indicate that this structure map is authored for testing purposes (or 
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     * 
     * @return
     *     An immutable object of type {@link Boolean} that may be null.
     */
    public Boolean getExperimental() {
        return experimental;
    }

    /**
     * The date (and optionally time) when the structure map was published. The date must change when the business version 
     * changes and it must change if the status code changes. In addition, it should change when the substantive content of 
     * the structure map changes.
     * 
     * @return
     *     An immutable object of type {@link DateTime} that may be null.
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * The name of the organization or individual that published the structure map.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactDetail} that may be empty.
     */
    public List<ContactDetail> getContact() {
        return contact;
    }

    /**
     * A free text natural language description of the structure map from a consumer's perspective.
     * 
     * @return
     *     An immutable object of type {@link Markdown} that may be null.
     */
    public Markdown getDescription() {
        return description;
    }

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
     * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
     * may be used to assist with indexing and searching for appropriate structure map instances.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link UsageContext} that may be empty.
     */
    public List<UsageContext> getUseContext() {
        return useContext;
    }

    /**
     * A legal or geographic region in which the structure map is intended to be used.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Explanation of why this structure map is needed and why it has been designed as it has.
     * 
     * @return
     *     An immutable object of type {@link Markdown} that may be null.
     */
    public Markdown getPurpose() {
        return purpose;
    }

    /**
     * A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal 
     * restrictions on the use and publishing of the structure map.
     * 
     * @return
     *     An immutable object of type {@link Markdown} that may be null.
     */
    public Markdown getCopyright() {
        return copyright;
    }

    /**
     * A structure definition used by this map. The structure definition may describe instances that are converted, or the 
     * instances that are produced.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Structure} that may be empty.
     */
    public List<Structure> getStructure() {
        return structure;
    }

    /**
     * Other maps used by this map (canonical URLs).
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Canonical} that may be empty.
     */
    public List<Canonical> getImport() {
        return _import;
    }

    /**
     * Organizes the mapping into manageable chunks for human review/ease of maintenance.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Group} that is non-empty.
     */
    public List<Group> getGroup() {
        return group;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            (url != null) || 
            !identifier.isEmpty() || 
            (version != null) || 
            (name != null) || 
            (title != null) || 
            (status != null) || 
            (experimental != null) || 
            (date != null) || 
            (publisher != null) || 
            !contact.isEmpty() || 
            (description != null) || 
            !useContext.isEmpty() || 
            !jurisdiction.isEmpty() || 
            (purpose != null) || 
            (copyright != null) || 
            !structure.isEmpty() || 
            !_import.isEmpty() || 
            !group.isEmpty();
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
                accept(url, "url", visitor);
                accept(identifier, "identifier", visitor, Identifier.class);
                accept(version, "version", visitor);
                accept(name, "name", visitor);
                accept(title, "title", visitor);
                accept(status, "status", visitor);
                accept(experimental, "experimental", visitor);
                accept(date, "date", visitor);
                accept(publisher, "publisher", visitor);
                accept(contact, "contact", visitor, ContactDetail.class);
                accept(description, "description", visitor);
                accept(useContext, "useContext", visitor, UsageContext.class);
                accept(jurisdiction, "jurisdiction", visitor, CodeableConcept.class);
                accept(purpose, "purpose", visitor);
                accept(copyright, "copyright", visitor);
                accept(structure, "structure", visitor, Structure.class);
                accept(_import, "import", visitor, Canonical.class);
                accept(group, "group", visitor, Group.class);
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
        StructureMap other = (StructureMap) obj;
        return Objects.equals(id, other.id) && 
            Objects.equals(meta, other.meta) && 
            Objects.equals(implicitRules, other.implicitRules) && 
            Objects.equals(language, other.language) && 
            Objects.equals(text, other.text) && 
            Objects.equals(contained, other.contained) && 
            Objects.equals(extension, other.extension) && 
            Objects.equals(modifierExtension, other.modifierExtension) && 
            Objects.equals(url, other.url) && 
            Objects.equals(identifier, other.identifier) && 
            Objects.equals(version, other.version) && 
            Objects.equals(name, other.name) && 
            Objects.equals(title, other.title) && 
            Objects.equals(status, other.status) && 
            Objects.equals(experimental, other.experimental) && 
            Objects.equals(date, other.date) && 
            Objects.equals(publisher, other.publisher) && 
            Objects.equals(contact, other.contact) && 
            Objects.equals(description, other.description) && 
            Objects.equals(useContext, other.useContext) && 
            Objects.equals(jurisdiction, other.jurisdiction) && 
            Objects.equals(purpose, other.purpose) && 
            Objects.equals(copyright, other.copyright) && 
            Objects.equals(structure, other.structure) && 
            Objects.equals(_import, other._import) && 
            Objects.equals(group, other.group);
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
                url, 
                identifier, 
                version, 
                name, 
                title, 
                status, 
                experimental, 
                date, 
                publisher, 
                contact, 
                description, 
                useContext, 
                jurisdiction, 
                purpose, 
                copyright, 
                structure, 
                _import, 
                group);
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
        private Uri url;
        private List<Identifier> identifier = new ArrayList<>();
        private String version;
        private String name;
        private String title;
        private PublicationStatus status;
        private Boolean experimental;
        private DateTime date;
        private String publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private Markdown description;
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private Markdown purpose;
        private Markdown copyright;
        private List<Structure> structure = new ArrayList<>();
        private List<Canonical> _import = new ArrayList<>();
        private List<Group> group = new ArrayList<>();

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
         * An absolute URI that is used to identify this structure map when it is referenced in a specification, model, design or 
         * an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at 
         * which at which an authoritative instance of this structure map is (or will be) published. This URL can be the target 
         * of a canonical reference. It SHALL remain the same when the structure map is stored on different servers.
         * 
         * <p>This element is required.
         * 
         * @param url
         *     Canonical identifier for this structure map, represented as a URI (globally unique)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder url(Uri url) {
            this.url = url;
            return this;
        }

        /**
         * A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced 
         * in a specification, model, design or an instance.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     Additional identifier for the structure map
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
         * A formal identifier that is used to identify this structure map when it is represented in other formats, or referenced 
         * in a specification, model, design or an instance.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     Additional identifier for the structure map
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * The identifier that is used to identify this version of the structure map when it is referenced in a specification, 
         * model, design or instance. This is an arbitrary value managed by the structure map author and is not expected to be 
         * globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is 
         * also no expectation that versions can be placed in a lexicographical sequence.
         * 
         * @param version
         *     Business version of the structure map
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * A natural language name identifying the structure map. This name should be usable as an identifier for the module by 
         * machine processing applications such as code generation.
         * 
         * <p>This element is required.
         * 
         * @param name
         *     Name for this structure map (computer friendly)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * A short, descriptive, user-friendly title for the structure map.
         * 
         * @param title
         *     Name for this structure map (human friendly)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * The status of this structure map. Enables tracking the life-cycle of the content.
         * 
         * <p>This element is required.
         * 
         * @param status
         *     draft | active | retired | unknown
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder status(PublicationStatus status) {
            this.status = status;
            return this;
        }

        /**
         * A Boolean value to indicate that this structure map is authored for testing purposes (or 
         * education/evaluation/marketing) and is not intended to be used for genuine usage.
         * 
         * @param experimental
         *     For testing purposes, not real usage
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder experimental(Boolean experimental) {
            this.experimental = experimental;
            return this;
        }

        /**
         * The date (and optionally time) when the structure map was published. The date must change when the business version 
         * changes and it must change if the status code changes. In addition, it should change when the substantive content of 
         * the structure map changes.
         * 
         * @param date
         *     Date last changed
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder date(DateTime date) {
            this.date = date;
            return this;
        }

        /**
         * The name of the organization or individual that published the structure map.
         * 
         * @param publisher
         *     Name of the publisher (organization or individual)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Contact details to assist a user in finding and communicating with the publisher.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param contact
         *     Contact details for the publisher
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder contact(ContactDetail... contact) {
            for (ContactDetail value : contact) {
                this.contact.add(value);
            }
            return this;
        }

        /**
         * Contact details to assist a user in finding and communicating with the publisher.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param contact
         *     Contact details for the publisher
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder contact(Collection<ContactDetail> contact) {
            this.contact = new ArrayList<>(contact);
            return this;
        }

        /**
         * A free text natural language description of the structure map from a consumer's perspective.
         * 
         * @param description
         *     Natural language description of the structure map
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder description(Markdown description) {
            this.description = description;
            return this;
        }

        /**
         * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
         * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
         * may be used to assist with indexing and searching for appropriate structure map instances.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param useContext
         *     The context that the content is intended to support
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder useContext(UsageContext... useContext) {
            for (UsageContext value : useContext) {
                this.useContext.add(value);
            }
            return this;
        }

        /**
         * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
         * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
         * may be used to assist with indexing and searching for appropriate structure map instances.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param useContext
         *     The context that the content is intended to support
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder useContext(Collection<UsageContext> useContext) {
            this.useContext = new ArrayList<>(useContext);
            return this;
        }

        /**
         * A legal or geographic region in which the structure map is intended to be used.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param jurisdiction
         *     Intended jurisdiction for structure map (if applicable)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder jurisdiction(CodeableConcept... jurisdiction) {
            for (CodeableConcept value : jurisdiction) {
                this.jurisdiction.add(value);
            }
            return this;
        }

        /**
         * A legal or geographic region in which the structure map is intended to be used.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param jurisdiction
         *     Intended jurisdiction for structure map (if applicable)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder jurisdiction(Collection<CodeableConcept> jurisdiction) {
            this.jurisdiction = new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Explanation of why this structure map is needed and why it has been designed as it has.
         * 
         * @param purpose
         *     Why this structure map is defined
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder purpose(Markdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * A copyright statement relating to the structure map and/or its contents. Copyright statements are generally legal 
         * restrictions on the use and publishing of the structure map.
         * 
         * @param copyright
         *     Use and/or publishing restrictions
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder copyright(Markdown copyright) {
            this.copyright = copyright;
            return this;
        }

        /**
         * A structure definition used by this map. The structure definition may describe instances that are converted, or the 
         * instances that are produced.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param structure
         *     Structure Definition used by this map
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder structure(Structure... structure) {
            for (Structure value : structure) {
                this.structure.add(value);
            }
            return this;
        }

        /**
         * A structure definition used by this map. The structure definition may describe instances that are converted, or the 
         * instances that are produced.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param structure
         *     Structure Definition used by this map
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder structure(Collection<Structure> structure) {
            this.structure = new ArrayList<>(structure);
            return this;
        }

        /**
         * Other maps used by this map (canonical URLs).
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param _import
         *     Other maps used by this map (canonical URLs)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder _import(Canonical... _import) {
            for (Canonical value : _import) {
                this._import.add(value);
            }
            return this;
        }

        /**
         * Other maps used by this map (canonical URLs).
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param _import
         *     Other maps used by this map (canonical URLs)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder _import(Collection<Canonical> _import) {
            this._import = new ArrayList<>(_import);
            return this;
        }

        /**
         * Organizes the mapping into manageable chunks for human review/ease of maintenance.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * <p>This element is required.
         * 
         * @param group
         *     Named sections for reader convenience
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder group(Group... group) {
            for (Group value : group) {
                this.group.add(value);
            }
            return this;
        }

        /**
         * Organizes the mapping into manageable chunks for human review/ease of maintenance.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * <p>This element is required.
         * 
         * @param group
         *     Named sections for reader convenience
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder group(Collection<Group> group) {
            this.group = new ArrayList<>(group);
            return this;
        }

        /**
         * Build the {@link StructureMap}
         * 
         * <p>Required elements:
         * <ul>
         * <li>url</li>
         * <li>name</li>
         * <li>status</li>
         * <li>group</li>
         * </ul>
         * 
         * @return
         *     An immutable object of type {@link StructureMap}
         * @throws IllegalStateException
         *     if the current state cannot be built into a valid StructureMap per the base specification
         */
        @Override
        public StructureMap build() {
            return new StructureMap(this);
        }

        protected Builder from(StructureMap structureMap) {
            super.from(structureMap);
            url = structureMap.url;
            identifier.addAll(structureMap.identifier);
            version = structureMap.version;
            name = structureMap.name;
            title = structureMap.title;
            status = structureMap.status;
            experimental = structureMap.experimental;
            date = structureMap.date;
            publisher = structureMap.publisher;
            contact.addAll(structureMap.contact);
            description = structureMap.description;
            useContext.addAll(structureMap.useContext);
            jurisdiction.addAll(structureMap.jurisdiction);
            purpose = structureMap.purpose;
            copyright = structureMap.copyright;
            structure.addAll(structureMap.structure);
            _import.addAll(structureMap._import);
            group.addAll(structureMap.group);
            return this;
        }
    }

    /**
     * A structure definition used by this map. The structure definition may describe instances that are converted, or the 
     * instances that are produced.
     */
    public static class Structure extends BackboneElement {
        @Summary
        @Required
        private final Canonical url;
        @Summary
        @Binding(
            bindingName = "StructureMapModelMode",
            strength = BindingStrength.ValueSet.REQUIRED,
            description = "How the referenced structure is used in this mapping.",
            valueSet = "http://hl7.org/fhir/ValueSet/map-model-mode|4.0.1"
        )
        @Required
        private final StructureMapModelMode mode;
        @Summary
        private final String alias;
        private final String documentation;

        private volatile int hashCode;

        private Structure(Builder builder) {
            super(builder);
            url = ValidationSupport.requireNonNull(builder.url, "url");
            mode = ValidationSupport.requireNonNull(builder.mode, "mode");
            alias = builder.alias;
            documentation = builder.documentation;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * The canonical reference to the structure.
         * 
         * @return
         *     An immutable object of type {@link Canonical} that is non-null.
         */
        public Canonical getUrl() {
            return url;
        }

        /**
         * How the referenced structure is used in this mapping.
         * 
         * @return
         *     An immutable object of type {@link StructureMapModelMode} that is non-null.
         */
        public StructureMapModelMode getMode() {
            return mode;
        }

        /**
         * The name used for this type in the map.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getAlias() {
            return alias;
        }

        /**
         * Documentation that describes how the structure is used in the mapping.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getDocumentation() {
            return documentation;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (url != null) || 
                (mode != null) || 
                (alias != null) || 
                (documentation != null);
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
                    accept(url, "url", visitor);
                    accept(mode, "mode", visitor);
                    accept(alias, "alias", visitor);
                    accept(documentation, "documentation", visitor);
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
            Structure other = (Structure) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(url, other.url) && 
                Objects.equals(mode, other.mode) && 
                Objects.equals(alias, other.alias) && 
                Objects.equals(documentation, other.documentation);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    url, 
                    mode, 
                    alias, 
                    documentation);
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
            private Canonical url;
            private StructureMapModelMode mode;
            private String alias;
            private String documentation;

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
             * The canonical reference to the structure.
             * 
             * <p>This element is required.
             * 
             * @param url
             *     Canonical reference to structure definition
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder url(Canonical url) {
                this.url = url;
                return this;
            }

            /**
             * How the referenced structure is used in this mapping.
             * 
             * <p>This element is required.
             * 
             * @param mode
             *     source | queried | target | produced
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder mode(StructureMapModelMode mode) {
                this.mode = mode;
                return this;
            }

            /**
             * The name used for this type in the map.
             * 
             * @param alias
             *     Name for type in this map
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder alias(String alias) {
                this.alias = alias;
                return this;
            }

            /**
             * Documentation that describes how the structure is used in the mapping.
             * 
             * @param documentation
             *     Documentation on use of structure
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder documentation(String documentation) {
                this.documentation = documentation;
                return this;
            }

            /**
             * Build the {@link Structure}
             * 
             * <p>Required elements:
             * <ul>
             * <li>url</li>
             * <li>mode</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Structure}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Structure per the base specification
             */
            @Override
            public Structure build() {
                return new Structure(this);
            }

            protected Builder from(Structure structure) {
                super.from(structure);
                url = structure.url;
                mode = structure.mode;
                alias = structure.alias;
                documentation = structure.documentation;
                return this;
            }
        }
    }

    /**
     * Organizes the mapping into manageable chunks for human review/ease of maintenance.
     */
    public static class Group extends BackboneElement {
        @Summary
        @Required
        private final Id name;
        @Summary
        private final Id _extends;
        @Summary
        @Binding(
            bindingName = "StructureMapGroupTypeMode",
            strength = BindingStrength.ValueSet.REQUIRED,
            description = "If this is the default rule set to apply for the source type, or this combination of types.",
            valueSet = "http://hl7.org/fhir/ValueSet/map-group-type-mode|4.0.1"
        )
        @Required
        private final StructureMapGroupTypeMode typeMode;
        @Summary
        private final String documentation;
        @Summary
        @Required
        private final List<Input> input;
        @Summary
        @Required
        private final List<Rule> rule;

        private volatile int hashCode;

        private Group(Builder builder) {
            super(builder);
            name = ValidationSupport.requireNonNull(builder.name, "name");
            _extends = builder._extends;
            typeMode = ValidationSupport.requireNonNull(builder.typeMode, "typeMode");
            documentation = builder.documentation;
            input = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.input, "input"));
            rule = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.rule, "rule"));
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A unique name for the group for the convenience of human readers.
         * 
         * @return
         *     An immutable object of type {@link Id} that is non-null.
         */
        public Id getName() {
            return name;
        }

        /**
         * Another group that this group adds rules to.
         * 
         * @return
         *     An immutable object of type {@link Id} that may be null.
         */
        public Id getExtends() {
            return _extends;
        }

        /**
         * If this is the default rule set to apply for the source type or this combination of types.
         * 
         * @return
         *     An immutable object of type {@link StructureMapGroupTypeMode} that is non-null.
         */
        public StructureMapGroupTypeMode getTypeMode() {
            return typeMode;
        }

        /**
         * Additional supporting documentation that explains the purpose of the group and the types of mappings within it.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getDocumentation() {
            return documentation;
        }

        /**
         * A name assigned to an instance of data. The instance must be provided when the mapping is invoked.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Input} that is non-empty.
         */
        public List<Input> getInput() {
            return input;
        }

        /**
         * Transform Rule from source to target.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link Rule} that is non-empty.
         */
        public List<Rule> getRule() {
            return rule;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (name != null) || 
                (_extends != null) || 
                (typeMode != null) || 
                (documentation != null) || 
                !input.isEmpty() || 
                !rule.isEmpty();
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
                    accept(name, "name", visitor);
                    accept(_extends, "extends", visitor);
                    accept(typeMode, "typeMode", visitor);
                    accept(documentation, "documentation", visitor);
                    accept(input, "input", visitor, Input.class);
                    accept(rule, "rule", visitor, Rule.class);
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
            Group other = (Group) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(name, other.name) && 
                Objects.equals(_extends, other._extends) && 
                Objects.equals(typeMode, other.typeMode) && 
                Objects.equals(documentation, other.documentation) && 
                Objects.equals(input, other.input) && 
                Objects.equals(rule, other.rule);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    name, 
                    _extends, 
                    typeMode, 
                    documentation, 
                    input, 
                    rule);
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
            private Id name;
            private Id _extends;
            private StructureMapGroupTypeMode typeMode;
            private String documentation;
            private List<Input> input = new ArrayList<>();
            private List<Rule> rule = new ArrayList<>();

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
             * A unique name for the group for the convenience of human readers.
             * 
             * <p>This element is required.
             * 
             * @param name
             *     Human-readable label
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder name(Id name) {
                this.name = name;
                return this;
            }

            /**
             * Another group that this group adds rules to.
             * 
             * @param _extends
             *     Another group that this group adds rules to
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder _extends(Id _extends) {
                this._extends = _extends;
                return this;
            }

            /**
             * If this is the default rule set to apply for the source type or this combination of types.
             * 
             * <p>This element is required.
             * 
             * @param typeMode
             *     none | types | type-and-types
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder typeMode(StructureMapGroupTypeMode typeMode) {
                this.typeMode = typeMode;
                return this;
            }

            /**
             * Additional supporting documentation that explains the purpose of the group and the types of mappings within it.
             * 
             * @param documentation
             *     Additional description/explanation for group
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder documentation(String documentation) {
                this.documentation = documentation;
                return this;
            }

            /**
             * A name assigned to an instance of data. The instance must be provided when the mapping is invoked.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * <p>This element is required.
             * 
             * @param input
             *     Named instance provided when invoking the map
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder input(Input... input) {
                for (Input value : input) {
                    this.input.add(value);
                }
                return this;
            }

            /**
             * A name assigned to an instance of data. The instance must be provided when the mapping is invoked.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * <p>This element is required.
             * 
             * @param input
             *     Named instance provided when invoking the map
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder input(Collection<Input> input) {
                this.input = new ArrayList<>(input);
                return this;
            }

            /**
             * Transform Rule from source to target.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * <p>This element is required.
             * 
             * @param rule
             *     Transform Rule from source to target
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder rule(Rule... rule) {
                for (Rule value : rule) {
                    this.rule.add(value);
                }
                return this;
            }

            /**
             * Transform Rule from source to target.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * <p>This element is required.
             * 
             * @param rule
             *     Transform Rule from source to target
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder rule(Collection<Rule> rule) {
                this.rule = new ArrayList<>(rule);
                return this;
            }

            /**
             * Build the {@link Group}
             * 
             * <p>Required elements:
             * <ul>
             * <li>name</li>
             * <li>typeMode</li>
             * <li>input</li>
             * <li>rule</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Group}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Group per the base specification
             */
            @Override
            public Group build() {
                return new Group(this);
            }

            protected Builder from(Group group) {
                super.from(group);
                name = group.name;
                _extends = group._extends;
                typeMode = group.typeMode;
                documentation = group.documentation;
                input.addAll(group.input);
                rule.addAll(group.rule);
                return this;
            }
        }

        /**
         * A name assigned to an instance of data. The instance must be provided when the mapping is invoked.
         */
        public static class Input extends BackboneElement {
            @Summary
            @Required
            private final Id name;
            @Summary
            private final String type;
            @Summary
            @Binding(
                bindingName = "StructureMapInputMode",
                strength = BindingStrength.ValueSet.REQUIRED,
                description = "Mode for this instance of data.",
                valueSet = "http://hl7.org/fhir/ValueSet/map-input-mode|4.0.1"
            )
            @Required
            private final StructureMapInputMode mode;
            private final String documentation;

            private volatile int hashCode;

            private Input(Builder builder) {
                super(builder);
                name = ValidationSupport.requireNonNull(builder.name, "name");
                type = builder.type;
                mode = ValidationSupport.requireNonNull(builder.mode, "mode");
                documentation = builder.documentation;
                ValidationSupport.requireValueOrChildren(this);
            }

            /**
             * Name for this instance of data.
             * 
             * @return
             *     An immutable object of type {@link Id} that is non-null.
             */
            public Id getName() {
                return name;
            }

            /**
             * Type for this instance of data.
             * 
             * @return
             *     An immutable object of type {@link String} that may be null.
             */
            public String getType() {
                return type;
            }

            /**
             * Mode for this instance of data.
             * 
             * @return
             *     An immutable object of type {@link StructureMapInputMode} that is non-null.
             */
            public StructureMapInputMode getMode() {
                return mode;
            }

            /**
             * Documentation for this instance of data.
             * 
             * @return
             *     An immutable object of type {@link String} that may be null.
             */
            public String getDocumentation() {
                return documentation;
            }

            @Override
            public boolean hasChildren() {
                return super.hasChildren() || 
                    (name != null) || 
                    (type != null) || 
                    (mode != null) || 
                    (documentation != null);
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
                        accept(name, "name", visitor);
                        accept(type, "type", visitor);
                        accept(mode, "mode", visitor);
                        accept(documentation, "documentation", visitor);
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
                Input other = (Input) obj;
                return Objects.equals(id, other.id) && 
                    Objects.equals(extension, other.extension) && 
                    Objects.equals(modifierExtension, other.modifierExtension) && 
                    Objects.equals(name, other.name) && 
                    Objects.equals(type, other.type) && 
                    Objects.equals(mode, other.mode) && 
                    Objects.equals(documentation, other.documentation);
            }

            @Override
            public int hashCode() {
                int result = hashCode;
                if (result == 0) {
                    result = Objects.hash(id, 
                        extension, 
                        modifierExtension, 
                        name, 
                        type, 
                        mode, 
                        documentation);
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
                private Id name;
                private String type;
                private StructureMapInputMode mode;
                private String documentation;

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
                 * Name for this instance of data.
                 * 
                 * <p>This element is required.
                 * 
                 * @param name
                 *     Name for this instance of data
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder name(Id name) {
                    this.name = name;
                    return this;
                }

                /**
                 * Type for this instance of data.
                 * 
                 * @param type
                 *     Type for this instance of data
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder type(String type) {
                    this.type = type;
                    return this;
                }

                /**
                 * Mode for this instance of data.
                 * 
                 * <p>This element is required.
                 * 
                 * @param mode
                 *     source | target
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder mode(StructureMapInputMode mode) {
                    this.mode = mode;
                    return this;
                }

                /**
                 * Documentation for this instance of data.
                 * 
                 * @param documentation
                 *     Documentation for this instance of data
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder documentation(String documentation) {
                    this.documentation = documentation;
                    return this;
                }

                /**
                 * Build the {@link Input}
                 * 
                 * <p>Required elements:
                 * <ul>
                 * <li>name</li>
                 * <li>mode</li>
                 * </ul>
                 * 
                 * @return
                 *     An immutable object of type {@link Input}
                 * @throws IllegalStateException
                 *     if the current state cannot be built into a valid Input per the base specification
                 */
                @Override
                public Input build() {
                    return new Input(this);
                }

                protected Builder from(Input input) {
                    super.from(input);
                    name = input.name;
                    type = input.type;
                    mode = input.mode;
                    documentation = input.documentation;
                    return this;
                }
            }
        }

        /**
         * Transform Rule from source to target.
         */
        public static class Rule extends BackboneElement {
            @Summary
            @Required
            private final Id name;
            @Summary
            @Required
            private final List<Source> source;
            @Summary
            private final List<Target> target;
            @Summary
            private final List<StructureMap.Group.Rule> rule;
            @Summary
            private final List<Dependent> dependent;
            private final String documentation;

            private volatile int hashCode;

            private Rule(Builder builder) {
                super(builder);
                name = ValidationSupport.requireNonNull(builder.name, "name");
                source = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.source, "source"));
                target = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.target, "target"));
                rule = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.rule, "rule"));
                dependent = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.dependent, "dependent"));
                documentation = builder.documentation;
                ValidationSupport.requireValueOrChildren(this);
            }

            /**
             * Name of the rule for internal references.
             * 
             * @return
             *     An immutable object of type {@link Id} that is non-null.
             */
            public Id getName() {
                return name;
            }

            /**
             * Source inputs to the mapping.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link Source} that is non-empty.
             */
            public List<Source> getSource() {
                return source;
            }

            /**
             * Content to create because of this mapping rule.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link Target} that may be empty.
             */
            public List<Target> getTarget() {
                return target;
            }

            /**
             * Rules contained in this rule.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link Rule} that may be empty.
             */
            public List<StructureMap.Group.Rule> getRule() {
                return rule;
            }

            /**
             * Which other rules to apply in the context of this rule.
             * 
             * @return
             *     An unmodifiable list containing immutable objects of type {@link Dependent} that may be empty.
             */
            public List<Dependent> getDependent() {
                return dependent;
            }

            /**
             * Documentation for this instance of data.
             * 
             * @return
             *     An immutable object of type {@link String} that may be null.
             */
            public String getDocumentation() {
                return documentation;
            }

            @Override
            public boolean hasChildren() {
                return super.hasChildren() || 
                    (name != null) || 
                    !source.isEmpty() || 
                    !target.isEmpty() || 
                    !rule.isEmpty() || 
                    !dependent.isEmpty() || 
                    (documentation != null);
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
                        accept(name, "name", visitor);
                        accept(source, "source", visitor, Source.class);
                        accept(target, "target", visitor, Target.class);
                        accept(rule, "rule", visitor, StructureMap.Group.Rule.class);
                        accept(dependent, "dependent", visitor, Dependent.class);
                        accept(documentation, "documentation", visitor);
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
                Rule other = (Rule) obj;
                return Objects.equals(id, other.id) && 
                    Objects.equals(extension, other.extension) && 
                    Objects.equals(modifierExtension, other.modifierExtension) && 
                    Objects.equals(name, other.name) && 
                    Objects.equals(source, other.source) && 
                    Objects.equals(target, other.target) && 
                    Objects.equals(rule, other.rule) && 
                    Objects.equals(dependent, other.dependent) && 
                    Objects.equals(documentation, other.documentation);
            }

            @Override
            public int hashCode() {
                int result = hashCode;
                if (result == 0) {
                    result = Objects.hash(id, 
                        extension, 
                        modifierExtension, 
                        name, 
                        source, 
                        target, 
                        rule, 
                        dependent, 
                        documentation);
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
                private Id name;
                private List<Source> source = new ArrayList<>();
                private List<Target> target = new ArrayList<>();
                private List<StructureMap.Group.Rule> rule = new ArrayList<>();
                private List<Dependent> dependent = new ArrayList<>();
                private String documentation;

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
                 * Name of the rule for internal references.
                 * 
                 * <p>This element is required.
                 * 
                 * @param name
                 *     Name of the rule for internal references
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder name(Id name) {
                    this.name = name;
                    return this;
                }

                /**
                 * Source inputs to the mapping.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * <p>This element is required.
                 * 
                 * @param source
                 *     Source inputs to the mapping
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder source(Source... source) {
                    for (Source value : source) {
                        this.source.add(value);
                    }
                    return this;
                }

                /**
                 * Source inputs to the mapping.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * <p>This element is required.
                 * 
                 * @param source
                 *     Source inputs to the mapping
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder source(Collection<Source> source) {
                    this.source = new ArrayList<>(source);
                    return this;
                }

                /**
                 * Content to create because of this mapping rule.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param target
                 *     Content to create because of this mapping rule
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder target(Target... target) {
                    for (Target value : target) {
                        this.target.add(value);
                    }
                    return this;
                }

                /**
                 * Content to create because of this mapping rule.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param target
                 *     Content to create because of this mapping rule
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder target(Collection<Target> target) {
                    this.target = new ArrayList<>(target);
                    return this;
                }

                /**
                 * Rules contained in this rule.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param rule
                 *     Rules contained in this rule
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder rule(StructureMap.Group.Rule... rule) {
                    for (StructureMap.Group.Rule value : rule) {
                        this.rule.add(value);
                    }
                    return this;
                }

                /**
                 * Rules contained in this rule.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param rule
                 *     Rules contained in this rule
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder rule(Collection<StructureMap.Group.Rule> rule) {
                    this.rule = new ArrayList<>(rule);
                    return this;
                }

                /**
                 * Which other rules to apply in the context of this rule.
                 * 
                 * <p>Adds new element(s) to the existing list
                 * 
                 * @param dependent
                 *     Which other rules to apply in the context of this rule
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder dependent(Dependent... dependent) {
                    for (Dependent value : dependent) {
                        this.dependent.add(value);
                    }
                    return this;
                }

                /**
                 * Which other rules to apply in the context of this rule.
                 * 
                 * <p>Replaces the existing list with a new one containing elements from the Collection
                 * 
                 * @param dependent
                 *     Which other rules to apply in the context of this rule
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder dependent(Collection<Dependent> dependent) {
                    this.dependent = new ArrayList<>(dependent);
                    return this;
                }

                /**
                 * Documentation for this instance of data.
                 * 
                 * @param documentation
                 *     Documentation for this instance of data
                 * 
                 * @return
                 *     A reference to this Builder instance
                 */
                public Builder documentation(String documentation) {
                    this.documentation = documentation;
                    return this;
                }

                /**
                 * Build the {@link Rule}
                 * 
                 * <p>Required elements:
                 * <ul>
                 * <li>name</li>
                 * <li>source</li>
                 * </ul>
                 * 
                 * @return
                 *     An immutable object of type {@link Rule}
                 * @throws IllegalStateException
                 *     if the current state cannot be built into a valid Rule per the base specification
                 */
                @Override
                public Rule build() {
                    return new Rule(this);
                }

                protected Builder from(Rule rule) {
                    super.from(rule);
                    name = rule.name;
                    source.addAll(rule.source);
                    target.addAll(rule.target);
                    this.rule.addAll(rule.rule);
                    dependent.addAll(rule.dependent);
                    documentation = rule.documentation;
                    return this;
                }
            }

            /**
             * Source inputs to the mapping.
             */
            public static class Source extends BackboneElement {
                @Summary
                @Required
                private final Id context;
                @Summary
                private final Integer min;
                @Summary
                private final String max;
                @Summary
                private final String type;
                @Summary
                @Choice({ Base64Binary.class, Boolean.class, Canonical.class, Code.class, Date.class, DateTime.class, Decimal.class, Id.class, Instant.class, Integer.class, Markdown.class, Oid.class, PositiveInt.class, String.class, Time.class, UnsignedInt.class, Uri.class, Url.class, Uuid.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class })
                private final Element defaultValue;
                @Summary
                private final String element;
                @Summary
                @Binding(
                    bindingName = "StructureMapSourceListMode",
                    strength = BindingStrength.ValueSet.REQUIRED,
                    description = "If field is a list, how to manage the source.",
                    valueSet = "http://hl7.org/fhir/ValueSet/map-source-list-mode|4.0.1"
                )
                private final StructureMapSourceListMode listMode;
                @Summary
                private final Id variable;
                @Summary
                private final String condition;
                @Summary
                private final String check;
                @Summary
                private final String logMessage;

                private volatile int hashCode;

                private Source(Builder builder) {
                    super(builder);
                    context = ValidationSupport.requireNonNull(builder.context, "context");
                    min = builder.min;
                    max = builder.max;
                    type = builder.type;
                    defaultValue = ValidationSupport.choiceElement(builder.defaultValue, "defaultValue", Base64Binary.class, Boolean.class, Canonical.class, Code.class, Date.class, DateTime.class, Decimal.class, Id.class, Instant.class, Integer.class, Markdown.class, Oid.class, PositiveInt.class, String.class, Time.class, UnsignedInt.class, Uri.class, Url.class, Uuid.class, Address.class, Age.class, Annotation.class, Attachment.class, CodeableConcept.class, Coding.class, ContactPoint.class, Count.class, Distance.class, Duration.class, HumanName.class, Identifier.class, Money.class, Period.class, Quantity.class, Range.class, Ratio.class, Reference.class, SampledData.class, Signature.class, Timing.class, ContactDetail.class, Contributor.class, DataRequirement.class, Expression.class, ParameterDefinition.class, RelatedArtifact.class, TriggerDefinition.class, UsageContext.class, Dosage.class, Meta.class);
                    element = builder.element;
                    listMode = builder.listMode;
                    variable = builder.variable;
                    condition = builder.condition;
                    check = builder.check;
                    logMessage = builder.logMessage;
                    ValidationSupport.requireValueOrChildren(this);
                }

                /**
                 * Type or variable this rule applies to.
                 * 
                 * @return
                 *     An immutable object of type {@link Id} that is non-null.
                 */
                public Id getContext() {
                    return context;
                }

                /**
                 * Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input 
                 * content.
                 * 
                 * @return
                 *     An immutable object of type {@link Integer} that may be null.
                 */
                public Integer getMin() {
                    return min;
                }

                /**
                 * Specified maximum cardinality for the element - a number or a "*". This is optional; if present, it acts an implicit 
                 * check on the input content (* just serves as documentation; it's the default value).
                 * 
                 * @return
                 *     An immutable object of type {@link String} that may be null.
                 */
                public String getMax() {
                    return max;
                }

                /**
                 * Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.
                 * 
                 * @return
                 *     An immutable object of type {@link String} that may be null.
                 */
                public String getType() {
                    return type;
                }

                /**
                 * A value to use if there is no existing value in the source object.
                 * 
                 * @return
                 *     An immutable object of type {@link Element} that may be null.
                 */
                public Element getDefaultValue() {
                    return defaultValue;
                }

                /**
                 * Optional field for this source.
                 * 
                 * @return
                 *     An immutable object of type {@link String} that may be null.
                 */
                public String getElement() {
                    return element;
                }

                /**
                 * How to handle the list mode for this element.
                 * 
                 * @return
                 *     An immutable object of type {@link StructureMapSourceListMode} that may be null.
                 */
                public StructureMapSourceListMode getListMode() {
                    return listMode;
                }

                /**
                 * Named context for field, if a field is specified.
                 * 
                 * @return
                 *     An immutable object of type {@link Id} that may be null.
                 */
                public Id getVariable() {
                    return variable;
                }

                /**
                 * FHIRPath expression - must be true or the rule does not apply.
                 * 
                 * @return
                 *     An immutable object of type {@link String} that may be null.
                 */
                public String getCondition() {
                    return condition;
                }

                /**
                 * FHIRPath expression - must be true or the mapping engine throws an error instead of completing.
                 * 
                 * @return
                 *     An immutable object of type {@link String} that may be null.
                 */
                public String getCheck() {
                    return check;
                }

                /**
                 * A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is 
                 * found.
                 * 
                 * @return
                 *     An immutable object of type {@link String} that may be null.
                 */
                public String getLogMessage() {
                    return logMessage;
                }

                @Override
                public boolean hasChildren() {
                    return super.hasChildren() || 
                        (context != null) || 
                        (min != null) || 
                        (max != null) || 
                        (type != null) || 
                        (defaultValue != null) || 
                        (element != null) || 
                        (listMode != null) || 
                        (variable != null) || 
                        (condition != null) || 
                        (check != null) || 
                        (logMessage != null);
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
                            accept(context, "context", visitor);
                            accept(min, "min", visitor);
                            accept(max, "max", visitor);
                            accept(type, "type", visitor);
                            accept(defaultValue, "defaultValue", visitor);
                            accept(element, "element", visitor);
                            accept(listMode, "listMode", visitor);
                            accept(variable, "variable", visitor);
                            accept(condition, "condition", visitor);
                            accept(check, "check", visitor);
                            accept(logMessage, "logMessage", visitor);
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
                    Source other = (Source) obj;
                    return Objects.equals(id, other.id) && 
                        Objects.equals(extension, other.extension) && 
                        Objects.equals(modifierExtension, other.modifierExtension) && 
                        Objects.equals(context, other.context) && 
                        Objects.equals(min, other.min) && 
                        Objects.equals(max, other.max) && 
                        Objects.equals(type, other.type) && 
                        Objects.equals(defaultValue, other.defaultValue) && 
                        Objects.equals(element, other.element) && 
                        Objects.equals(listMode, other.listMode) && 
                        Objects.equals(variable, other.variable) && 
                        Objects.equals(condition, other.condition) && 
                        Objects.equals(check, other.check) && 
                        Objects.equals(logMessage, other.logMessage);
                }

                @Override
                public int hashCode() {
                    int result = hashCode;
                    if (result == 0) {
                        result = Objects.hash(id, 
                            extension, 
                            modifierExtension, 
                            context, 
                            min, 
                            max, 
                            type, 
                            defaultValue, 
                            element, 
                            listMode, 
                            variable, 
                            condition, 
                            check, 
                            logMessage);
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
                    private Id context;
                    private Integer min;
                    private String max;
                    private String type;
                    private Element defaultValue;
                    private String element;
                    private StructureMapSourceListMode listMode;
                    private Id variable;
                    private String condition;
                    private String check;
                    private String logMessage;

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
                     * Type or variable this rule applies to.
                     * 
                     * <p>This element is required.
                     * 
                     * @param context
                     *     Type or variable this rule applies to
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder context(Id context) {
                        this.context = context;
                        return this;
                    }

                    /**
                     * Specified minimum cardinality for the element. This is optional; if present, it acts an implicit check on the input 
                     * content.
                     * 
                     * @param min
                     *     Specified minimum cardinality
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder min(Integer min) {
                        this.min = min;
                        return this;
                    }

                    /**
                     * Specified maximum cardinality for the element - a number or a "*". This is optional; if present, it acts an implicit 
                     * check on the input content (* just serves as documentation; it's the default value).
                     * 
                     * @param max
                     *     Specified maximum cardinality (number or *)
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder max(String max) {
                        this.max = max;
                        return this;
                    }

                    /**
                     * Specified type for the element. This works as a condition on the mapping - use for polymorphic elements.
                     * 
                     * @param type
                     *     Rule only applies if source has this type
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder type(String type) {
                        this.type = type;
                        return this;
                    }

                    /**
                     * A value to use if there is no existing value in the source object.
                     * 
                     * <p>This is a choice element with the following allowed types:
                     * <ul>
                     * <li>{@link Base64Binary}</li>
                     * <li>{@link Boolean}</li>
                     * <li>{@link Canonical}</li>
                     * <li>{@link Code}</li>
                     * <li>{@link Date}</li>
                     * <li>{@link DateTime}</li>
                     * <li>{@link Decimal}</li>
                     * <li>{@link Id}</li>
                     * <li>{@link Instant}</li>
                     * <li>{@link Integer}</li>
                     * <li>{@link Markdown}</li>
                     * <li>{@link Oid}</li>
                     * <li>{@link PositiveInt}</li>
                     * <li>{@link String}</li>
                     * <li>{@link Time}</li>
                     * <li>{@link UnsignedInt}</li>
                     * <li>{@link Uri}</li>
                     * <li>{@link Url}</li>
                     * <li>{@link Uuid}</li>
                     * <li>{@link Address}</li>
                     * <li>{@link Age}</li>
                     * <li>{@link Annotation}</li>
                     * <li>{@link Attachment}</li>
                     * <li>{@link CodeableConcept}</li>
                     * <li>{@link Coding}</li>
                     * <li>{@link ContactPoint}</li>
                     * <li>{@link Count}</li>
                     * <li>{@link Distance}</li>
                     * <li>{@link Duration}</li>
                     * <li>{@link HumanName}</li>
                     * <li>{@link Identifier}</li>
                     * <li>{@link Money}</li>
                     * <li>{@link Period}</li>
                     * <li>{@link Quantity}</li>
                     * <li>{@link Range}</li>
                     * <li>{@link Ratio}</li>
                     * <li>{@link Reference}</li>
                     * <li>{@link SampledData}</li>
                     * <li>{@link Signature}</li>
                     * <li>{@link Timing}</li>
                     * <li>{@link ContactDetail}</li>
                     * <li>{@link Contributor}</li>
                     * <li>{@link DataRequirement}</li>
                     * <li>{@link Expression}</li>
                     * <li>{@link ParameterDefinition}</li>
                     * <li>{@link RelatedArtifact}</li>
                     * <li>{@link TriggerDefinition}</li>
                     * <li>{@link UsageContext}</li>
                     * <li>{@link Dosage}</li>
                     * <li>{@link Meta}</li>
                     * </ul>
                     * 
                     * @param defaultValue
                     *     Default value if no value exists
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder defaultValue(Element defaultValue) {
                        this.defaultValue = defaultValue;
                        return this;
                    }

                    /**
                     * Optional field for this source.
                     * 
                     * @param element
                     *     Optional field for this source
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder element(String element) {
                        this.element = element;
                        return this;
                    }

                    /**
                     * How to handle the list mode for this element.
                     * 
                     * @param listMode
                     *     first | not_first | last | not_last | only_one
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder listMode(StructureMapSourceListMode listMode) {
                        this.listMode = listMode;
                        return this;
                    }

                    /**
                     * Named context for field, if a field is specified.
                     * 
                     * @param variable
                     *     Named context for field, if a field is specified
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder variable(Id variable) {
                        this.variable = variable;
                        return this;
                    }

                    /**
                     * FHIRPath expression - must be true or the rule does not apply.
                     * 
                     * @param condition
                     *     FHIRPath expression - must be true or the rule does not apply
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder condition(String condition) {
                        this.condition = condition;
                        return this;
                    }

                    /**
                     * FHIRPath expression - must be true or the mapping engine throws an error instead of completing.
                     * 
                     * @param check
                     *     FHIRPath expression - must be true or the mapping engine throws an error instead of completing
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder check(String check) {
                        this.check = check;
                        return this;
                    }

                    /**
                     * A FHIRPath expression which specifies a message to put in the transform log when content matching the source rule is 
                     * found.
                     * 
                     * @param logMessage
                     *     Message to put in log if source exists (FHIRPath)
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder logMessage(String logMessage) {
                        this.logMessage = logMessage;
                        return this;
                    }

                    /**
                     * Build the {@link Source}
                     * 
                     * <p>Required elements:
                     * <ul>
                     * <li>context</li>
                     * </ul>
                     * 
                     * @return
                     *     An immutable object of type {@link Source}
                     * @throws IllegalStateException
                     *     if the current state cannot be built into a valid Source per the base specification
                     */
                    @Override
                    public Source build() {
                        return new Source(this);
                    }

                    protected Builder from(Source source) {
                        super.from(source);
                        context = source.context;
                        min = source.min;
                        max = source.max;
                        type = source.type;
                        defaultValue = source.defaultValue;
                        element = source.element;
                        listMode = source.listMode;
                        variable = source.variable;
                        condition = source.condition;
                        check = source.check;
                        logMessage = source.logMessage;
                        return this;
                    }
                }
            }

            /**
             * Content to create because of this mapping rule.
             */
            public static class Target extends BackboneElement {
                @Summary
                private final Id context;
                @Summary
                @Binding(
                    bindingName = "StructureMapContextType",
                    strength = BindingStrength.ValueSet.REQUIRED,
                    description = "How to interpret the context.",
                    valueSet = "http://hl7.org/fhir/ValueSet/map-context-type|4.0.1"
                )
                private final StructureMapContextType contextType;
                @Summary
                private final String element;
                @Summary
                private final Id variable;
                @Summary
                @Binding(
                    bindingName = "StructureMapTargetListMode",
                    strength = BindingStrength.ValueSet.REQUIRED,
                    description = "If field is a list, how to manage the production.",
                    valueSet = "http://hl7.org/fhir/ValueSet/map-target-list-mode|4.0.1"
                )
                private final List<StructureMapTargetListMode> listMode;
                @Summary
                private final Id listRuleId;
                @Summary
                @Binding(
                    bindingName = "StructureMapTransform",
                    strength = BindingStrength.ValueSet.REQUIRED,
                    description = "How data is copied/created.",
                    valueSet = "http://hl7.org/fhir/ValueSet/map-transform|4.0.1"
                )
                private final StructureMapTransform transform;
                @Summary
                private final List<Parameter> parameter;

                private volatile int hashCode;

                private Target(Builder builder) {
                    super(builder);
                    context = builder.context;
                    contextType = builder.contextType;
                    element = builder.element;
                    variable = builder.variable;
                    listMode = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.listMode, "listMode"));
                    listRuleId = builder.listRuleId;
                    transform = builder.transform;
                    parameter = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.parameter, "parameter"));
                    ValidationSupport.requireValueOrChildren(this);
                }

                /**
                 * Type or variable this rule applies to.
                 * 
                 * @return
                 *     An immutable object of type {@link Id} that may be null.
                 */
                public Id getContext() {
                    return context;
                }

                /**
                 * How to interpret the context.
                 * 
                 * @return
                 *     An immutable object of type {@link StructureMapContextType} that may be null.
                 */
                public StructureMapContextType getContextType() {
                    return contextType;
                }

                /**
                 * Field to create in the context.
                 * 
                 * @return
                 *     An immutable object of type {@link String} that may be null.
                 */
                public String getElement() {
                    return element;
                }

                /**
                 * Named context for field, if desired, and a field is specified.
                 * 
                 * @return
                 *     An immutable object of type {@link Id} that may be null.
                 */
                public Id getVariable() {
                    return variable;
                }

                /**
                 * If field is a list, how to manage the list.
                 * 
                 * @return
                 *     An unmodifiable list containing immutable objects of type {@link StructureMapTargetListMode} that may be empty.
                 */
                public List<StructureMapTargetListMode> getListMode() {
                    return listMode;
                }

                /**
                 * Internal rule reference for shared list items.
                 * 
                 * @return
                 *     An immutable object of type {@link Id} that may be null.
                 */
                public Id getListRuleId() {
                    return listRuleId;
                }

                /**
                 * How the data is copied / created.
                 * 
                 * @return
                 *     An immutable object of type {@link StructureMapTransform} that may be null.
                 */
                public StructureMapTransform getTransform() {
                    return transform;
                }

                /**
                 * Parameters to the transform.
                 * 
                 * @return
                 *     An unmodifiable list containing immutable objects of type {@link Parameter} that may be empty.
                 */
                public List<Parameter> getParameter() {
                    return parameter;
                }

                @Override
                public boolean hasChildren() {
                    return super.hasChildren() || 
                        (context != null) || 
                        (contextType != null) || 
                        (element != null) || 
                        (variable != null) || 
                        !listMode.isEmpty() || 
                        (listRuleId != null) || 
                        (transform != null) || 
                        !parameter.isEmpty();
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
                            accept(context, "context", visitor);
                            accept(contextType, "contextType", visitor);
                            accept(element, "element", visitor);
                            accept(variable, "variable", visitor);
                            accept(listMode, "listMode", visitor, StructureMapTargetListMode.class);
                            accept(listRuleId, "listRuleId", visitor);
                            accept(transform, "transform", visitor);
                            accept(parameter, "parameter", visitor, Parameter.class);
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
                    Target other = (Target) obj;
                    return Objects.equals(id, other.id) && 
                        Objects.equals(extension, other.extension) && 
                        Objects.equals(modifierExtension, other.modifierExtension) && 
                        Objects.equals(context, other.context) && 
                        Objects.equals(contextType, other.contextType) && 
                        Objects.equals(element, other.element) && 
                        Objects.equals(variable, other.variable) && 
                        Objects.equals(listMode, other.listMode) && 
                        Objects.equals(listRuleId, other.listRuleId) && 
                        Objects.equals(transform, other.transform) && 
                        Objects.equals(parameter, other.parameter);
                }

                @Override
                public int hashCode() {
                    int result = hashCode;
                    if (result == 0) {
                        result = Objects.hash(id, 
                            extension, 
                            modifierExtension, 
                            context, 
                            contextType, 
                            element, 
                            variable, 
                            listMode, 
                            listRuleId, 
                            transform, 
                            parameter);
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
                    private Id context;
                    private StructureMapContextType contextType;
                    private String element;
                    private Id variable;
                    private List<StructureMapTargetListMode> listMode = new ArrayList<>();
                    private Id listRuleId;
                    private StructureMapTransform transform;
                    private List<Parameter> parameter = new ArrayList<>();

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
                     * Type or variable this rule applies to.
                     * 
                     * @param context
                     *     Type or variable this rule applies to
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder context(Id context) {
                        this.context = context;
                        return this;
                    }

                    /**
                     * How to interpret the context.
                     * 
                     * @param contextType
                     *     type | variable
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder contextType(StructureMapContextType contextType) {
                        this.contextType = contextType;
                        return this;
                    }

                    /**
                     * Field to create in the context.
                     * 
                     * @param element
                     *     Field to create in the context
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder element(String element) {
                        this.element = element;
                        return this;
                    }

                    /**
                     * Named context for field, if desired, and a field is specified.
                     * 
                     * @param variable
                     *     Named context for field, if desired, and a field is specified
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder variable(Id variable) {
                        this.variable = variable;
                        return this;
                    }

                    /**
                     * If field is a list, how to manage the list.
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * @param listMode
                     *     first | share | last | collate
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder listMode(StructureMapTargetListMode... listMode) {
                        for (StructureMapTargetListMode value : listMode) {
                            this.listMode.add(value);
                        }
                        return this;
                    }

                    /**
                     * If field is a list, how to manage the list.
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * @param listMode
                     *     first | share | last | collate
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder listMode(Collection<StructureMapTargetListMode> listMode) {
                        this.listMode = new ArrayList<>(listMode);
                        return this;
                    }

                    /**
                     * Internal rule reference for shared list items.
                     * 
                     * @param listRuleId
                     *     Internal rule reference for shared list items
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder listRuleId(Id listRuleId) {
                        this.listRuleId = listRuleId;
                        return this;
                    }

                    /**
                     * How the data is copied / created.
                     * 
                     * @param transform
                     *     create | copy +
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder transform(StructureMapTransform transform) {
                        this.transform = transform;
                        return this;
                    }

                    /**
                     * Parameters to the transform.
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * @param parameter
                     *     Parameters to the transform
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder parameter(Parameter... parameter) {
                        for (Parameter value : parameter) {
                            this.parameter.add(value);
                        }
                        return this;
                    }

                    /**
                     * Parameters to the transform.
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * @param parameter
                     *     Parameters to the transform
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder parameter(Collection<Parameter> parameter) {
                        this.parameter = new ArrayList<>(parameter);
                        return this;
                    }

                    /**
                     * Build the {@link Target}
                     * 
                     * @return
                     *     An immutable object of type {@link Target}
                     * @throws IllegalStateException
                     *     if the current state cannot be built into a valid Target per the base specification
                     */
                    @Override
                    public Target build() {
                        return new Target(this);
                    }

                    protected Builder from(Target target) {
                        super.from(target);
                        context = target.context;
                        contextType = target.contextType;
                        element = target.element;
                        variable = target.variable;
                        listMode.addAll(target.listMode);
                        listRuleId = target.listRuleId;
                        transform = target.transform;
                        parameter.addAll(target.parameter);
                        return this;
                    }
                }

                /**
                 * Parameters to the transform.
                 */
                public static class Parameter extends BackboneElement {
                    @Summary
                    @Choice({ Id.class, String.class, Boolean.class, Integer.class, Decimal.class })
                    @Required
                    private final Element value;

                    private volatile int hashCode;

                    private Parameter(Builder builder) {
                        super(builder);
                        value = ValidationSupport.requireChoiceElement(builder.value, "value", Id.class, String.class, Boolean.class, Integer.class, Decimal.class);
                        ValidationSupport.requireValueOrChildren(this);
                    }

                    /**
                     * Parameter value - variable or literal.
                     * 
                     * @return
                     *     An immutable object of type {@link Element} that is non-null.
                     */
                    public Element getValue() {
                        return value;
                    }

                    @Override
                    public boolean hasChildren() {
                        return super.hasChildren() || 
                            (value != null);
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
                                accept(value, "value", visitor);
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
                        Parameter other = (Parameter) obj;
                        return Objects.equals(id, other.id) && 
                            Objects.equals(extension, other.extension) && 
                            Objects.equals(modifierExtension, other.modifierExtension) && 
                            Objects.equals(value, other.value);
                    }

                    @Override
                    public int hashCode() {
                        int result = hashCode;
                        if (result == 0) {
                            result = Objects.hash(id, 
                                extension, 
                                modifierExtension, 
                                value);
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
                        private Element value;

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
                         * Parameter value - variable or literal.
                         * 
                         * <p>This element is required.
                         * 
                         * <p>This is a choice element with the following allowed types:
                         * <ul>
                         * <li>{@link Id}</li>
                         * <li>{@link String}</li>
                         * <li>{@link Boolean}</li>
                         * <li>{@link Integer}</li>
                         * <li>{@link Decimal}</li>
                         * </ul>
                         * 
                         * @param value
                         *     Parameter value - variable or literal
                         * 
                         * @return
                         *     A reference to this Builder instance
                         */
                        public Builder value(Element value) {
                            this.value = value;
                            return this;
                        }

                        /**
                         * Build the {@link Parameter}
                         * 
                         * <p>Required elements:
                         * <ul>
                         * <li>value</li>
                         * </ul>
                         * 
                         * @return
                         *     An immutable object of type {@link Parameter}
                         * @throws IllegalStateException
                         *     if the current state cannot be built into a valid Parameter per the base specification
                         */
                        @Override
                        public Parameter build() {
                            return new Parameter(this);
                        }

                        protected Builder from(Parameter parameter) {
                            super.from(parameter);
                            value = parameter.value;
                            return this;
                        }
                    }
                }
            }

            /**
             * Which other rules to apply in the context of this rule.
             */
            public static class Dependent extends BackboneElement {
                @Summary
                @Required
                private final Id name;
                @Summary
                @Required
                private final List<String> variable;

                private volatile int hashCode;

                private Dependent(Builder builder) {
                    super(builder);
                    name = ValidationSupport.requireNonNull(builder.name, "name");
                    variable = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.variable, "variable"));
                    ValidationSupport.requireValueOrChildren(this);
                }

                /**
                 * Name of a rule or group to apply.
                 * 
                 * @return
                 *     An immutable object of type {@link Id} that is non-null.
                 */
                public Id getName() {
                    return name;
                }

                /**
                 * Variable to pass to the rule or group.
                 * 
                 * @return
                 *     An unmodifiable list containing immutable objects of type {@link String} that is non-empty.
                 */
                public List<String> getVariable() {
                    return variable;
                }

                @Override
                public boolean hasChildren() {
                    return super.hasChildren() || 
                        (name != null) || 
                        !variable.isEmpty();
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
                            accept(name, "name", visitor);
                            accept(variable, "variable", visitor, String.class);
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
                    Dependent other = (Dependent) obj;
                    return Objects.equals(id, other.id) && 
                        Objects.equals(extension, other.extension) && 
                        Objects.equals(modifierExtension, other.modifierExtension) && 
                        Objects.equals(name, other.name) && 
                        Objects.equals(variable, other.variable);
                }

                @Override
                public int hashCode() {
                    int result = hashCode;
                    if (result == 0) {
                        result = Objects.hash(id, 
                            extension, 
                            modifierExtension, 
                            name, 
                            variable);
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
                    private Id name;
                    private List<String> variable = new ArrayList<>();

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
                     * Name of a rule or group to apply.
                     * 
                     * <p>This element is required.
                     * 
                     * @param name
                     *     Name of a rule or group to apply
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder name(Id name) {
                        this.name = name;
                        return this;
                    }

                    /**
                     * Variable to pass to the rule or group.
                     * 
                     * <p>Adds new element(s) to the existing list
                     * 
                     * <p>This element is required.
                     * 
                     * @param variable
                     *     Variable to pass to the rule or group
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder variable(String... variable) {
                        for (String value : variable) {
                            this.variable.add(value);
                        }
                        return this;
                    }

                    /**
                     * Variable to pass to the rule or group.
                     * 
                     * <p>Replaces the existing list with a new one containing elements from the Collection
                     * 
                     * <p>This element is required.
                     * 
                     * @param variable
                     *     Variable to pass to the rule or group
                     * 
                     * @return
                     *     A reference to this Builder instance
                     */
                    public Builder variable(Collection<String> variable) {
                        this.variable = new ArrayList<>(variable);
                        return this;
                    }

                    /**
                     * Build the {@link Dependent}
                     * 
                     * <p>Required elements:
                     * <ul>
                     * <li>name</li>
                     * <li>variable</li>
                     * </ul>
                     * 
                     * @return
                     *     An immutable object of type {@link Dependent}
                     * @throws IllegalStateException
                     *     if the current state cannot be built into a valid Dependent per the base specification
                     */
                    @Override
                    public Dependent build() {
                        return new Dependent(this);
                    }

                    protected Builder from(Dependent dependent) {
                        super.from(dependent);
                        name = dependent.name;
                        variable.addAll(dependent.variable);
                        return this;
                    }
                }
            }
        }
    }
}
