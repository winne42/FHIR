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
import com.ibm.fhir.model.type.Annotation;
import com.ibm.fhir.model.type.BackboneElement;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.Canonical;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.ContactDetail;
import com.ibm.fhir.model.type.DataRequirement;
import com.ibm.fhir.model.type.Date;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Duration;
import com.ibm.fhir.model.type.Element;
import com.ibm.fhir.model.type.Expression;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Markdown;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.Period;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.RelatedArtifact;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Timing;
import com.ibm.fhir.model.type.TriggerDefinition;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.UsageContext;
import com.ibm.fhir.model.type.code.BindingStrength;
import com.ibm.fhir.model.type.code.EvidenceVariableType;
import com.ibm.fhir.model.type.code.GroupMeasure;
import com.ibm.fhir.model.type.code.PublicationStatus;
import com.ibm.fhir.model.util.ValidationSupport;
import com.ibm.fhir.model.visitor.Visitor;

/**
 * The EvidenceVariable resource describes a "PICO" element that knowledge (evidence, assertion, recommendation) is about.
 */
@Constraint(
    id = "evv-0",
    level = "Warning",
    location = "(base)",
    description = "Name should be usable as an identifier for the module by machine processing applications such as code generation",
    expression = "name.matches('[A-Z]([A-Za-z0-9_]){0,254}')"
)
@Constraint(
    id = "evidenceVariable-1",
    level = "Warning",
    location = "(base)",
    description = "SHALL, if possible, at least contain a code from value set http://hl7.org/fhir/ValueSet/jurisdiction",
    expression = "jurisdiction.exists() implies (jurisdiction.all(memberOf('http://hl7.org/fhir/ValueSet/jurisdiction', 'extensible')))"
)
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class EvidenceVariable extends DomainResource {
    @Summary
    private final Uri url;
    @Summary
    private final List<Identifier> identifier;
    @Summary
    private final String version;
    @Summary
    private final String name;
    @Summary
    private final String title;
    @Summary
    private final String shortTitle;
    private final String subtitle;
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
    private final DateTime date;
    @Summary
    private final String publisher;
    @Summary
    private final List<ContactDetail> contact;
    @Summary
    private final Markdown description;
    private final List<Annotation> note;
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
    private final Markdown copyright;
    private final Date approvalDate;
    private final Date lastReviewDate;
    @Summary
    private final Period effectivePeriod;
    @Binding(
        bindingName = "DefinitionTopic",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "High-level categorization of the definition, used for searching, sorting, and filtering.",
        valueSet = "http://hl7.org/fhir/ValueSet/definition-topic"
    )
    private final List<CodeableConcept> topic;
    private final List<ContactDetail> author;
    private final List<ContactDetail> editor;
    private final List<ContactDetail> reviewer;
    private final List<ContactDetail> endorser;
    private final List<RelatedArtifact> relatedArtifact;
    @Summary
    @Binding(
        bindingName = "EvidenceVariableType",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "The possible types of variables for exposures or outcomes (E.g. Dichotomous, Continuous, Descriptive).",
        valueSet = "http://hl7.org/fhir/ValueSet/variable-type|4.0.1"
    )
    private final EvidenceVariableType type;
    @Summary
    @Required
    private final List<Characteristic> characteristic;

    private volatile int hashCode;

    private EvidenceVariable(Builder builder) {
        super(builder);
        url = builder.url;
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        version = builder.version;
        name = builder.name;
        title = builder.title;
        shortTitle = builder.shortTitle;
        subtitle = builder.subtitle;
        status = ValidationSupport.requireNonNull(builder.status, "status");
        date = builder.date;
        publisher = builder.publisher;
        contact = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.contact, "contact"));
        description = builder.description;
        note = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.note, "note"));
        useContext = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.useContext, "useContext"));
        jurisdiction = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.jurisdiction, "jurisdiction"));
        copyright = builder.copyright;
        approvalDate = builder.approvalDate;
        lastReviewDate = builder.lastReviewDate;
        effectivePeriod = builder.effectivePeriod;
        topic = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.topic, "topic"));
        author = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.author, "author"));
        editor = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.editor, "editor"));
        reviewer = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.reviewer, "reviewer"));
        endorser = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.endorser, "endorser"));
        relatedArtifact = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.relatedArtifact, "relatedArtifact"));
        type = builder.type;
        characteristic = Collections.unmodifiableList(ValidationSupport.requireNonEmpty(builder.characteristic, "characteristic"));
        ValidationSupport.requireChildren(this);
    }

    /**
     * An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, 
     * design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal 
     * address at which at which an authoritative instance of this evidence variable is (or will be) published. This URL can 
     * be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different 
     * servers.
     * 
     * @return
     *     An immutable object of type {@link Uri} that may be null.
     */
    public Uri getUrl() {
        return url;
    }

    /**
     * A formal identifier that is used to identify this evidence variable when it is represented in other formats, or 
     * referenced in a specification, model, design or an instance.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier} that may be empty.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * The identifier that is used to identify this version of the evidence variable when it is referenced in a 
     * specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is 
     * not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not 
     * available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a 
     * version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). 
     * For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a 
     * version is required for non-experimental active artifacts.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getVersion() {
        return version;
    }

    /**
     * A natural language name identifying the evidence variable. This name should be usable as an identifier for the module 
     * by machine processing applications such as code generation.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getName() {
        return name;
    }

    /**
     * A short, descriptive, user-friendly title for the evidence variable.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getTitle() {
        return title;
    }

    /**
     * The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is 
     * not necessary.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getShortTitle() {
        return shortTitle;
    }

    /**
     * An explanatory or alternate title for the EvidenceVariable giving additional information about its content.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * The status of this evidence variable. Enables tracking the life-cycle of the content.
     * 
     * @return
     *     An immutable object of type {@link PublicationStatus} that is non-null.
     */
    public PublicationStatus getStatus() {
        return status;
    }

    /**
     * The date (and optionally time) when the evidence variable was published. The date must change when the business 
     * version changes and it must change if the status code changes. In addition, it should change when the substantive 
     * content of the evidence variable changes.
     * 
     * @return
     *     An immutable object of type {@link DateTime} that may be null.
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * The name of the organization or individual that published the evidence variable.
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
     * A free text natural language description of the evidence variable from a consumer's perspective.
     * 
     * @return
     *     An immutable object of type {@link Markdown} that may be null.
     */
    public Markdown getDescription() {
        return description;
    }

    /**
     * A human-readable string to clarify or explain concepts about the resource.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Annotation} that may be empty.
     */
    public List<Annotation> getNote() {
        return note;
    }

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
     * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
     * may be used to assist with indexing and searching for appropriate evidence variable instances.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link UsageContext} that may be empty.
     */
    public List<UsageContext> getUseContext() {
        return useContext;
    }

    /**
     * A legal or geographic region in which the evidence variable is intended to be used.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getJurisdiction() {
        return jurisdiction;
    }

    /**
     * A copyright statement relating to the evidence variable and/or its contents. Copyright statements are generally legal 
     * restrictions on the use and publishing of the evidence variable.
     * 
     * @return
     *     An immutable object of type {@link Markdown} that may be null.
     */
    public Markdown getCopyright() {
        return copyright;
    }

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is 
     * officially approved for usage.
     * 
     * @return
     *     An immutable object of type {@link Date} that may be null.
     */
    public Date getApprovalDate() {
        return approvalDate;
    }

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not 
     * change the original approval date.
     * 
     * @return
     *     An immutable object of type {@link Date} that may be null.
     */
    public Date getLastReviewDate() {
        return lastReviewDate;
    }

    /**
     * The period during which the evidence variable content was or is planned to be in active use.
     * 
     * @return
     *     An immutable object of type {@link Period} that may be null.
     */
    public Period getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * Descriptive topics related to the content of the EvidenceVariable. Topics provide a high-level categorization grouping 
     * types of EvidenceVariables that can be useful for filtering and searching.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getTopic() {
        return topic;
    }

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the content.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactDetail} that may be empty.
     */
    public List<ContactDetail> getAuthor() {
        return author;
    }

    /**
     * An individual or organization primarily responsible for internal coherence of the content.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactDetail} that may be empty.
     */
    public List<ContactDetail> getEditor() {
        return editor;
    }

    /**
     * An individual or organization primarily responsible for review of some aspect of the content.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactDetail} that may be empty.
     */
    public List<ContactDetail> getReviewer() {
        return reviewer;
    }

    /**
     * An individual or organization responsible for officially endorsing the content for use in some setting.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link ContactDetail} that may be empty.
     */
    public List<ContactDetail> getEndorser() {
        return endorser;
    }

    /**
     * Related artifacts such as additional documentation, justification, or bibliographic references.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link RelatedArtifact} that may be empty.
     */
    public List<RelatedArtifact> getRelatedArtifact() {
        return relatedArtifact;
    }

    /**
     * The type of evidence element, a population, an exposure, or an outcome.
     * 
     * @return
     *     An immutable object of type {@link EvidenceVariableType} that may be null.
     */
    public EvidenceVariableType getType() {
        return type;
    }

    /**
     * A characteristic that defines the members of the evidence element. Multiple characteristics are applied with "and" 
     * semantics.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Characteristic} that is non-empty.
     */
    public List<Characteristic> getCharacteristic() {
        return characteristic;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            (url != null) || 
            !identifier.isEmpty() || 
            (version != null) || 
            (name != null) || 
            (title != null) || 
            (shortTitle != null) || 
            (subtitle != null) || 
            (status != null) || 
            (date != null) || 
            (publisher != null) || 
            !contact.isEmpty() || 
            (description != null) || 
            !note.isEmpty() || 
            !useContext.isEmpty() || 
            !jurisdiction.isEmpty() || 
            (copyright != null) || 
            (approvalDate != null) || 
            (lastReviewDate != null) || 
            (effectivePeriod != null) || 
            !topic.isEmpty() || 
            !author.isEmpty() || 
            !editor.isEmpty() || 
            !reviewer.isEmpty() || 
            !endorser.isEmpty() || 
            !relatedArtifact.isEmpty() || 
            (type != null) || 
            !characteristic.isEmpty();
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
                accept(shortTitle, "shortTitle", visitor);
                accept(subtitle, "subtitle", visitor);
                accept(status, "status", visitor);
                accept(date, "date", visitor);
                accept(publisher, "publisher", visitor);
                accept(contact, "contact", visitor, ContactDetail.class);
                accept(description, "description", visitor);
                accept(note, "note", visitor, Annotation.class);
                accept(useContext, "useContext", visitor, UsageContext.class);
                accept(jurisdiction, "jurisdiction", visitor, CodeableConcept.class);
                accept(copyright, "copyright", visitor);
                accept(approvalDate, "approvalDate", visitor);
                accept(lastReviewDate, "lastReviewDate", visitor);
                accept(effectivePeriod, "effectivePeriod", visitor);
                accept(topic, "topic", visitor, CodeableConcept.class);
                accept(author, "author", visitor, ContactDetail.class);
                accept(editor, "editor", visitor, ContactDetail.class);
                accept(reviewer, "reviewer", visitor, ContactDetail.class);
                accept(endorser, "endorser", visitor, ContactDetail.class);
                accept(relatedArtifact, "relatedArtifact", visitor, RelatedArtifact.class);
                accept(type, "type", visitor);
                accept(characteristic, "characteristic", visitor, Characteristic.class);
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
        EvidenceVariable other = (EvidenceVariable) obj;
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
            Objects.equals(shortTitle, other.shortTitle) && 
            Objects.equals(subtitle, other.subtitle) && 
            Objects.equals(status, other.status) && 
            Objects.equals(date, other.date) && 
            Objects.equals(publisher, other.publisher) && 
            Objects.equals(contact, other.contact) && 
            Objects.equals(description, other.description) && 
            Objects.equals(note, other.note) && 
            Objects.equals(useContext, other.useContext) && 
            Objects.equals(jurisdiction, other.jurisdiction) && 
            Objects.equals(copyright, other.copyright) && 
            Objects.equals(approvalDate, other.approvalDate) && 
            Objects.equals(lastReviewDate, other.lastReviewDate) && 
            Objects.equals(effectivePeriod, other.effectivePeriod) && 
            Objects.equals(topic, other.topic) && 
            Objects.equals(author, other.author) && 
            Objects.equals(editor, other.editor) && 
            Objects.equals(reviewer, other.reviewer) && 
            Objects.equals(endorser, other.endorser) && 
            Objects.equals(relatedArtifact, other.relatedArtifact) && 
            Objects.equals(type, other.type) && 
            Objects.equals(characteristic, other.characteristic);
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
                shortTitle, 
                subtitle, 
                status, 
                date, 
                publisher, 
                contact, 
                description, 
                note, 
                useContext, 
                jurisdiction, 
                copyright, 
                approvalDate, 
                lastReviewDate, 
                effectivePeriod, 
                topic, 
                author, 
                editor, 
                reviewer, 
                endorser, 
                relatedArtifact, 
                type, 
                characteristic);
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
        private String shortTitle;
        private String subtitle;
        private PublicationStatus status;
        private DateTime date;
        private String publisher;
        private List<ContactDetail> contact = new ArrayList<>();
        private Markdown description;
        private List<Annotation> note = new ArrayList<>();
        private List<UsageContext> useContext = new ArrayList<>();
        private List<CodeableConcept> jurisdiction = new ArrayList<>();
        private Markdown copyright;
        private Date approvalDate;
        private Date lastReviewDate;
        private Period effectivePeriod;
        private List<CodeableConcept> topic = new ArrayList<>();
        private List<ContactDetail> author = new ArrayList<>();
        private List<ContactDetail> editor = new ArrayList<>();
        private List<ContactDetail> reviewer = new ArrayList<>();
        private List<ContactDetail> endorser = new ArrayList<>();
        private List<RelatedArtifact> relatedArtifact = new ArrayList<>();
        private EvidenceVariableType type;
        private List<Characteristic> characteristic = new ArrayList<>();

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
         * An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, 
         * design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal 
         * address at which at which an authoritative instance of this evidence variable is (or will be) published. This URL can 
         * be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different 
         * servers.
         * 
         * @param url
         *     Canonical identifier for this evidence variable, represented as a URI (globally unique)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder url(Uri url) {
            this.url = url;
            return this;
        }

        /**
         * A formal identifier that is used to identify this evidence variable when it is represented in other formats, or 
         * referenced in a specification, model, design or an instance.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     Additional identifier for the evidence variable
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
         * A formal identifier that is used to identify this evidence variable when it is represented in other formats, or 
         * referenced in a specification, model, design or an instance.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     Additional identifier for the evidence variable
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * The identifier that is used to identify this version of the evidence variable when it is referenced in a 
         * specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is 
         * not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not 
         * available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a 
         * version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). 
         * For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a 
         * version is required for non-experimental active artifacts.
         * 
         * @param version
         *     Business version of the evidence variable
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * A natural language name identifying the evidence variable. This name should be usable as an identifier for the module 
         * by machine processing applications such as code generation.
         * 
         * @param name
         *     Name for this evidence variable (computer friendly)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * A short, descriptive, user-friendly title for the evidence variable.
         * 
         * @param title
         *     Name for this evidence variable (human friendly)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is 
         * not necessary.
         * 
         * @param shortTitle
         *     Title for use in informal contexts
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder shortTitle(String shortTitle) {
            this.shortTitle = shortTitle;
            return this;
        }

        /**
         * An explanatory or alternate title for the EvidenceVariable giving additional information about its content.
         * 
         * @param subtitle
         *     Subordinate title of the EvidenceVariable
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        /**
         * The status of this evidence variable. Enables tracking the life-cycle of the content.
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
         * The date (and optionally time) when the evidence variable was published. The date must change when the business 
         * version changes and it must change if the status code changes. In addition, it should change when the substantive 
         * content of the evidence variable changes.
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
         * The name of the organization or individual that published the evidence variable.
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
         * A free text natural language description of the evidence variable from a consumer's perspective.
         * 
         * @param description
         *     Natural language description of the evidence variable
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder description(Markdown description) {
            this.description = description;
            return this;
        }

        /**
         * A human-readable string to clarify or explain concepts about the resource.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param note
         *     Used for footnotes or explanatory notes
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
         * A human-readable string to clarify or explain concepts about the resource.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param note
         *     Used for footnotes or explanatory notes
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder note(Collection<Annotation> note) {
            this.note = new ArrayList<>(note);
            return this;
        }

        /**
         * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be 
         * general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and 
         * may be used to assist with indexing and searching for appropriate evidence variable instances.
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
         * may be used to assist with indexing and searching for appropriate evidence variable instances.
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
         * A legal or geographic region in which the evidence variable is intended to be used.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param jurisdiction
         *     Intended jurisdiction for evidence variable (if applicable)
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
         * A legal or geographic region in which the evidence variable is intended to be used.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param jurisdiction
         *     Intended jurisdiction for evidence variable (if applicable)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder jurisdiction(Collection<CodeableConcept> jurisdiction) {
            this.jurisdiction = new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * A copyright statement relating to the evidence variable and/or its contents. Copyright statements are generally legal 
         * restrictions on the use and publishing of the evidence variable.
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
         * The date on which the resource content was approved by the publisher. Approval happens once when the content is 
         * officially approved for usage.
         * 
         * @param approvalDate
         *     When the evidence variable was approved by publisher
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder approvalDate(Date approvalDate) {
            this.approvalDate = approvalDate;
            return this;
        }

        /**
         * The date on which the resource content was last reviewed. Review happens periodically after approval but does not 
         * change the original approval date.
         * 
         * @param lastReviewDate
         *     When the evidence variable was last reviewed
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder lastReviewDate(Date lastReviewDate) {
            this.lastReviewDate = lastReviewDate;
            return this;
        }

        /**
         * The period during which the evidence variable content was or is planned to be in active use.
         * 
         * @param effectivePeriod
         *     When the evidence variable is expected to be used
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder effectivePeriod(Period effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        /**
         * Descriptive topics related to the content of the EvidenceVariable. Topics provide a high-level categorization grouping 
         * types of EvidenceVariables that can be useful for filtering and searching.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param topic
         *     The category of the EvidenceVariable, such as Education, Treatment, Assessment, etc.
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder topic(CodeableConcept... topic) {
            for (CodeableConcept value : topic) {
                this.topic.add(value);
            }
            return this;
        }

        /**
         * Descriptive topics related to the content of the EvidenceVariable. Topics provide a high-level categorization grouping 
         * types of EvidenceVariables that can be useful for filtering and searching.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param topic
         *     The category of the EvidenceVariable, such as Education, Treatment, Assessment, etc.
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder topic(Collection<CodeableConcept> topic) {
            this.topic = new ArrayList<>(topic);
            return this;
        }

        /**
         * An individiual or organization primarily involved in the creation and maintenance of the content.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param author
         *     Who authored the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder author(ContactDetail... author) {
            for (ContactDetail value : author) {
                this.author.add(value);
            }
            return this;
        }

        /**
         * An individiual or organization primarily involved in the creation and maintenance of the content.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param author
         *     Who authored the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder author(Collection<ContactDetail> author) {
            this.author = new ArrayList<>(author);
            return this;
        }

        /**
         * An individual or organization primarily responsible for internal coherence of the content.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param editor
         *     Who edited the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder editor(ContactDetail... editor) {
            for (ContactDetail value : editor) {
                this.editor.add(value);
            }
            return this;
        }

        /**
         * An individual or organization primarily responsible for internal coherence of the content.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param editor
         *     Who edited the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder editor(Collection<ContactDetail> editor) {
            this.editor = new ArrayList<>(editor);
            return this;
        }

        /**
         * An individual or organization primarily responsible for review of some aspect of the content.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param reviewer
         *     Who reviewed the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder reviewer(ContactDetail... reviewer) {
            for (ContactDetail value : reviewer) {
                this.reviewer.add(value);
            }
            return this;
        }

        /**
         * An individual or organization primarily responsible for review of some aspect of the content.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param reviewer
         *     Who reviewed the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder reviewer(Collection<ContactDetail> reviewer) {
            this.reviewer = new ArrayList<>(reviewer);
            return this;
        }

        /**
         * An individual or organization responsible for officially endorsing the content for use in some setting.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param endorser
         *     Who endorsed the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder endorser(ContactDetail... endorser) {
            for (ContactDetail value : endorser) {
                this.endorser.add(value);
            }
            return this;
        }

        /**
         * An individual or organization responsible for officially endorsing the content for use in some setting.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param endorser
         *     Who endorsed the content
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder endorser(Collection<ContactDetail> endorser) {
            this.endorser = new ArrayList<>(endorser);
            return this;
        }

        /**
         * Related artifacts such as additional documentation, justification, or bibliographic references.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param relatedArtifact
         *     Additional documentation, citations, etc.
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder relatedArtifact(RelatedArtifact... relatedArtifact) {
            for (RelatedArtifact value : relatedArtifact) {
                this.relatedArtifact.add(value);
            }
            return this;
        }

        /**
         * Related artifacts such as additional documentation, justification, or bibliographic references.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param relatedArtifact
         *     Additional documentation, citations, etc.
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder relatedArtifact(Collection<RelatedArtifact> relatedArtifact) {
            this.relatedArtifact = new ArrayList<>(relatedArtifact);
            return this;
        }

        /**
         * The type of evidence element, a population, an exposure, or an outcome.
         * 
         * @param type
         *     dichotomous | continuous | descriptive
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder type(EvidenceVariableType type) {
            this.type = type;
            return this;
        }

        /**
         * A characteristic that defines the members of the evidence element. Multiple characteristics are applied with "and" 
         * semantics.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * <p>This element is required.
         * 
         * @param characteristic
         *     What defines the members of the evidence element
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder characteristic(Characteristic... characteristic) {
            for (Characteristic value : characteristic) {
                this.characteristic.add(value);
            }
            return this;
        }

        /**
         * A characteristic that defines the members of the evidence element. Multiple characteristics are applied with "and" 
         * semantics.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * <p>This element is required.
         * 
         * @param characteristic
         *     What defines the members of the evidence element
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder characteristic(Collection<Characteristic> characteristic) {
            this.characteristic = new ArrayList<>(characteristic);
            return this;
        }

        /**
         * Build the {@link EvidenceVariable}
         * 
         * <p>Required elements:
         * <ul>
         * <li>status</li>
         * <li>characteristic</li>
         * </ul>
         * 
         * @return
         *     An immutable object of type {@link EvidenceVariable}
         * @throws IllegalStateException
         *     if the current state cannot be built into a valid EvidenceVariable per the base specification
         */
        @Override
        public EvidenceVariable build() {
            return new EvidenceVariable(this);
        }

        protected Builder from(EvidenceVariable evidenceVariable) {
            super.from(evidenceVariable);
            url = evidenceVariable.url;
            identifier.addAll(evidenceVariable.identifier);
            version = evidenceVariable.version;
            name = evidenceVariable.name;
            title = evidenceVariable.title;
            shortTitle = evidenceVariable.shortTitle;
            subtitle = evidenceVariable.subtitle;
            status = evidenceVariable.status;
            date = evidenceVariable.date;
            publisher = evidenceVariable.publisher;
            contact.addAll(evidenceVariable.contact);
            description = evidenceVariable.description;
            note.addAll(evidenceVariable.note);
            useContext.addAll(evidenceVariable.useContext);
            jurisdiction.addAll(evidenceVariable.jurisdiction);
            copyright = evidenceVariable.copyright;
            approvalDate = evidenceVariable.approvalDate;
            lastReviewDate = evidenceVariable.lastReviewDate;
            effectivePeriod = evidenceVariable.effectivePeriod;
            topic.addAll(evidenceVariable.topic);
            author.addAll(evidenceVariable.author);
            editor.addAll(evidenceVariable.editor);
            reviewer.addAll(evidenceVariable.reviewer);
            endorser.addAll(evidenceVariable.endorser);
            relatedArtifact.addAll(evidenceVariable.relatedArtifact);
            type = evidenceVariable.type;
            characteristic.addAll(evidenceVariable.characteristic);
            return this;
        }
    }

    /**
     * A characteristic that defines the members of the evidence element. Multiple characteristics are applied with "and" 
     * semantics.
     */
    public static class Characteristic extends BackboneElement {
        private final String description;
        @Summary
        @Choice({ Reference.class, Canonical.class, CodeableConcept.class, Expression.class, DataRequirement.class, TriggerDefinition.class })
        @Required
        private final Element definition;
        private final List<UsageContext> usageContext;
        private final Boolean exclude;
        @Choice({ DateTime.class, Period.class, Duration.class, Timing.class })
        private final Element participantEffective;
        private final Duration timeFromStart;
        @Binding(
            bindingName = "GroupMeasure",
            strength = BindingStrength.ValueSet.REQUIRED,
            description = "Possible group measure aggregates (E.g. Mean, Median).",
            valueSet = "http://hl7.org/fhir/ValueSet/group-measure|4.0.1"
        )
        private final GroupMeasure groupMeasure;

        private volatile int hashCode;

        private Characteristic(Builder builder) {
            super(builder);
            description = builder.description;
            definition = ValidationSupport.requireChoiceElement(builder.definition, "definition", Reference.class, Canonical.class, CodeableConcept.class, Expression.class, DataRequirement.class, TriggerDefinition.class);
            usageContext = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.usageContext, "usageContext"));
            exclude = builder.exclude;
            participantEffective = ValidationSupport.choiceElement(builder.participantEffective, "participantEffective", DateTime.class, Period.class, Duration.class, Timing.class);
            timeFromStart = builder.timeFromStart;
            groupMeasure = builder.groupMeasure;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A short, natural language description of the characteristic that could be used to communicate the criteria to an end-
         * user.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Define members of the evidence element using Codes (such as condition, medication, or observation), Expressions ( 
         * using an expression language such as FHIRPath or CQL) or DataRequirements (such as Diabetes diagnosis onset in the 
         * last year).
         * 
         * @return
         *     An immutable object of type {@link Element} that is non-null.
         */
        public Element getDefinition() {
            return definition;
        }

        /**
         * Use UsageContext to define the members of the population, such as Age Ranges, Genders, Settings.
         * 
         * @return
         *     An unmodifiable list containing immutable objects of type {@link UsageContext} that may be empty.
         */
        public List<UsageContext> getUsageContext() {
            return usageContext;
        }

        /**
         * When true, members with this characteristic are excluded from the element.
         * 
         * @return
         *     An immutable object of type {@link Boolean} that may be null.
         */
        public Boolean getExclude() {
            return exclude;
        }

        /**
         * Indicates what effective period the study covers.
         * 
         * @return
         *     An immutable object of type {@link Element} that may be null.
         */
        public Element getParticipantEffective() {
            return participantEffective;
        }

        /**
         * Indicates duration from the participant's study entry.
         * 
         * @return
         *     An immutable object of type {@link Duration} that may be null.
         */
        public Duration getTimeFromStart() {
            return timeFromStart;
        }

        /**
         * Indicates how elements are aggregated within the study effective period.
         * 
         * @return
         *     An immutable object of type {@link GroupMeasure} that may be null.
         */
        public GroupMeasure getGroupMeasure() {
            return groupMeasure;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (description != null) || 
                (definition != null) || 
                !usageContext.isEmpty() || 
                (exclude != null) || 
                (participantEffective != null) || 
                (timeFromStart != null) || 
                (groupMeasure != null);
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
                    accept(definition, "definition", visitor);
                    accept(usageContext, "usageContext", visitor, UsageContext.class);
                    accept(exclude, "exclude", visitor);
                    accept(participantEffective, "participantEffective", visitor);
                    accept(timeFromStart, "timeFromStart", visitor);
                    accept(groupMeasure, "groupMeasure", visitor);
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
            Characteristic other = (Characteristic) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(description, other.description) && 
                Objects.equals(definition, other.definition) && 
                Objects.equals(usageContext, other.usageContext) && 
                Objects.equals(exclude, other.exclude) && 
                Objects.equals(participantEffective, other.participantEffective) && 
                Objects.equals(timeFromStart, other.timeFromStart) && 
                Objects.equals(groupMeasure, other.groupMeasure);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    description, 
                    definition, 
                    usageContext, 
                    exclude, 
                    participantEffective, 
                    timeFromStart, 
                    groupMeasure);
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
            private Element definition;
            private List<UsageContext> usageContext = new ArrayList<>();
            private Boolean exclude;
            private Element participantEffective;
            private Duration timeFromStart;
            private GroupMeasure groupMeasure;

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
             * A short, natural language description of the characteristic that could be used to communicate the criteria to an end-
             * user.
             * 
             * @param description
             *     Natural language description of the characteristic
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder description(String description) {
                this.description = description;
                return this;
            }

            /**
             * Define members of the evidence element using Codes (such as condition, medication, or observation), Expressions ( 
             * using an expression language such as FHIRPath or CQL) or DataRequirements (such as Diabetes diagnosis onset in the 
             * last year).
             * 
             * <p>This element is required.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link Reference}</li>
             * <li>{@link Canonical}</li>
             * <li>{@link CodeableConcept}</li>
             * <li>{@link Expression}</li>
             * <li>{@link DataRequirement}</li>
             * <li>{@link TriggerDefinition}</li>
             * </ul>
             * 
             * @param definition
             *     What code or expression defines members?
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder definition(Element definition) {
                this.definition = definition;
                return this;
            }

            /**
             * Use UsageContext to define the members of the population, such as Age Ranges, Genders, Settings.
             * 
             * <p>Adds new element(s) to the existing list
             * 
             * @param usageContext
             *     What code/value pairs define members?
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder usageContext(UsageContext... usageContext) {
                for (UsageContext value : usageContext) {
                    this.usageContext.add(value);
                }
                return this;
            }

            /**
             * Use UsageContext to define the members of the population, such as Age Ranges, Genders, Settings.
             * 
             * <p>Replaces the existing list with a new one containing elements from the Collection
             * 
             * @param usageContext
             *     What code/value pairs define members?
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder usageContext(Collection<UsageContext> usageContext) {
                this.usageContext = new ArrayList<>(usageContext);
                return this;
            }

            /**
             * When true, members with this characteristic are excluded from the element.
             * 
             * @param exclude
             *     Whether the characteristic includes or excludes members
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder exclude(Boolean exclude) {
                this.exclude = exclude;
                return this;
            }

            /**
             * Indicates what effective period the study covers.
             * 
             * <p>This is a choice element with the following allowed types:
             * <ul>
             * <li>{@link DateTime}</li>
             * <li>{@link Period}</li>
             * <li>{@link Duration}</li>
             * <li>{@link Timing}</li>
             * </ul>
             * 
             * @param participantEffective
             *     What time period do participants cover
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder participantEffective(Element participantEffective) {
                this.participantEffective = participantEffective;
                return this;
            }

            /**
             * Indicates duration from the participant's study entry.
             * 
             * @param timeFromStart
             *     Observation time from study start
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder timeFromStart(Duration timeFromStart) {
                this.timeFromStart = timeFromStart;
                return this;
            }

            /**
             * Indicates how elements are aggregated within the study effective period.
             * 
             * @param groupMeasure
             *     mean | median | mean-of-mean | mean-of-median | median-of-mean | median-of-median
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder groupMeasure(GroupMeasure groupMeasure) {
                this.groupMeasure = groupMeasure;
                return this;
            }

            /**
             * Build the {@link Characteristic}
             * 
             * <p>Required elements:
             * <ul>
             * <li>definition</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Characteristic}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Characteristic per the base specification
             */
            @Override
            public Characteristic build() {
                return new Characteristic(this);
            }

            protected Builder from(Characteristic characteristic) {
                super.from(characteristic);
                description = characteristic.description;
                definition = characteristic.definition;
                usageContext.addAll(characteristic.usageContext);
                exclude = characteristic.exclude;
                participantEffective = characteristic.participantEffective;
                timeFromStart = characteristic.timeFromStart;
                groupMeasure = characteristic.groupMeasure;
                return this;
            }
        }
    }
}
