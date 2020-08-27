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
import com.ibm.fhir.model.type.BackboneElement;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.Canonical;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.ContactDetail;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Element;
import com.ibm.fhir.model.type.Extension;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Markdown;
import com.ibm.fhir.model.type.Meta;
import com.ibm.fhir.model.type.Narrative;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.UnsignedInt;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.UsageContext;
import com.ibm.fhir.model.type.code.BindingStrength;
import com.ibm.fhir.model.type.code.MessageHeaderResponseRequest;
import com.ibm.fhir.model.type.code.MessageSignificanceCategory;
import com.ibm.fhir.model.type.code.PublicationStatus;
import com.ibm.fhir.model.type.code.ResourceType;
import com.ibm.fhir.model.util.ValidationSupport;
import com.ibm.fhir.model.visitor.Visitor;

/**
 * Defines the characteristics of a message that can be shared between systems, including the type of event that 
 * initiates the message, the content to be transmitted and what response(s), if any, are permitted.
 */
@Constraint(
    id = "msd-0",
    level = "Warning",
    location = "(base)",
    description = "Name should be usable as an identifier for the module by machine processing applications such as code generation",
    expression = "name.matches('[A-Z]([A-Za-z0-9_]){0,254}')"
)
@Constraint(
    id = "md-1",
    level = "Rule",
    location = "MessageDefinition.focus",
    description = "Max must be postive int or *",
    expression = "max='*' or (max.toInteger() > 0)"
)
@Constraint(
    id = "messageDefinition-2",
    level = "Warning",
    location = "(base)",
    description = "SHALL, if possible, at least contain a code from value set http://hl7.org/fhir/ValueSet/jurisdiction",
    expression = "jurisdiction.exists() implies (jurisdiction.all(memberOf('http://hl7.org/fhir/ValueSet/jurisdiction', 'extensible')))"
)
@Generated("com.ibm.fhir.tools.CodeGenerator")
public class MessageDefinition extends DomainResource {
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
    private final List<Canonical> replaces;
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
    @Required
    private final DateTime date;
    @Summary
    private final String publisher;
    @Summary
    private final List<ContactDetail> contact;
    @Summary
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
    @Summary
    private final Markdown purpose;
    private final Markdown copyright;
    @Summary
    private final Canonical base;
    @Summary
    private final List<Canonical> parent;
    @Summary
    @Choice({ Coding.class, Uri.class })
    @Binding(
        bindingName = "MessageEvent",
        strength = BindingStrength.ValueSet.EXAMPLE,
        description = "One of the message events defined as part of this version of FHIR.",
        valueSet = "http://hl7.org/fhir/ValueSet/message-events"
    )
    @Required
    private final Element event;
    @Summary
    @Binding(
        bindingName = "MessageSignificanceCategory",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "The impact of the content of a message.",
        valueSet = "http://hl7.org/fhir/ValueSet/message-significance-category|4.0.1"
    )
    private final MessageSignificanceCategory category;
    @Summary
    private final List<Focus> focus;
    @Binding(
        bindingName = "messageheader-response-request",
        strength = BindingStrength.ValueSet.REQUIRED,
        description = "HL7-defined table of codes which identify conditions under which acknowledgments are required to be returned in response to a message.",
        valueSet = "http://hl7.org/fhir/ValueSet/messageheader-response-request|4.0.1"
    )
    private final MessageHeaderResponseRequest responseRequired;
    private final List<AllowedResponse> allowedResponse;
    private final List<Canonical> graph;

    private volatile int hashCode;

    private MessageDefinition(Builder builder) {
        super(builder);
        url = builder.url;
        identifier = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.identifier, "identifier"));
        version = builder.version;
        name = builder.name;
        title = builder.title;
        replaces = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.replaces, "replaces"));
        status = ValidationSupport.requireNonNull(builder.status, "status");
        experimental = builder.experimental;
        date = ValidationSupport.requireNonNull(builder.date, "date");
        publisher = builder.publisher;
        contact = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.contact, "contact"));
        description = builder.description;
        useContext = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.useContext, "useContext"));
        jurisdiction = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.jurisdiction, "jurisdiction"));
        purpose = builder.purpose;
        copyright = builder.copyright;
        base = builder.base;
        parent = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.parent, "parent"));
        event = ValidationSupport.requireChoiceElement(builder.event, "event", Coding.class, Uri.class);
        category = builder.category;
        focus = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.focus, "focus"));
        responseRequired = builder.responseRequired;
        allowedResponse = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.allowedResponse, "allowedResponse"));
        graph = Collections.unmodifiableList(ValidationSupport.requireNonNull(builder.graph, "graph"));
        ValidationSupport.requireChildren(this);
    }

    /**
     * The business identifier that is used to reference the MessageDefinition and *is* expected to be consistent from server 
     * to server.
     * 
     * @return
     *     An immutable object of type {@link Uri} that may be null.
     */
    public Uri getUrl() {
        return url;
    }

    /**
     * A formal identifier that is used to identify this message definition when it is represented in other formats, or 
     * referenced in a specification, model, design or an instance.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Identifier} that may be empty.
     */
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * The identifier that is used to identify this version of the message definition when it is referenced in a 
     * specification, model, design or instance. This is an arbitrary value managed by the message definition author and is 
     * not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not 
     * available. There is also no expectation that versions can be placed in a lexicographical sequence.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getVersion() {
        return version;
    }

    /**
     * A natural language name identifying the message definition. This name should be usable as an identifier for the module 
     * by machine processing applications such as code generation.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getName() {
        return name;
    }

    /**
     * A short, descriptive, user-friendly title for the message definition.
     * 
     * @return
     *     An immutable object of type {@link String} that may be null.
     */
    public String getTitle() {
        return title;
    }

    /**
     * A MessageDefinition that is superseded by this definition.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Canonical} that may be empty.
     */
    public List<Canonical> getReplaces() {
        return replaces;
    }

    /**
     * The status of this message definition. Enables tracking the life-cycle of the content.
     * 
     * @return
     *     An immutable object of type {@link PublicationStatus} that is non-null.
     */
    public PublicationStatus getStatus() {
        return status;
    }

    /**
     * A Boolean value to indicate that this message definition is authored for testing purposes (or 
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     * 
     * @return
     *     An immutable object of type {@link Boolean} that may be null.
     */
    public Boolean getExperimental() {
        return experimental;
    }

    /**
     * The date (and optionally time) when the message definition was published. The date must change when the business 
     * version changes and it must change if the status code changes. In addition, it should change when the substantive 
     * content of the message definition changes.
     * 
     * @return
     *     An immutable object of type {@link DateTime} that is non-null.
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * The name of the organization or individual that published the message definition.
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
     * A free text natural language description of the message definition from a consumer's perspective.
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
     * may be used to assist with indexing and searching for appropriate message definition instances.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link UsageContext} that may be empty.
     */
    public List<UsageContext> getUseContext() {
        return useContext;
    }

    /**
     * A legal or geographic region in which the message definition is intended to be used.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link CodeableConcept} that may be empty.
     */
    public List<CodeableConcept> getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Explanation of why this message definition is needed and why it has been designed as it has.
     * 
     * @return
     *     An immutable object of type {@link Markdown} that may be null.
     */
    public Markdown getPurpose() {
        return purpose;
    }

    /**
     * A copyright statement relating to the message definition and/or its contents. Copyright statements are generally legal 
     * restrictions on the use and publishing of the message definition.
     * 
     * @return
     *     An immutable object of type {@link Markdown} that may be null.
     */
    public Markdown getCopyright() {
        return copyright;
    }

    /**
     * The MessageDefinition that is the basis for the contents of this resource.
     * 
     * @return
     *     An immutable object of type {@link Canonical} that may be null.
     */
    public Canonical getBase() {
        return base;
    }

    /**
     * Identifies a protocol or workflow that this MessageDefinition represents a step in.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Canonical} that may be empty.
     */
    public List<Canonical> getParent() {
        return parent;
    }

    /**
     * Event code or link to the EventDefinition.
     * 
     * @return
     *     An immutable object of type {@link Element} that is non-null.
     */
    public Element getEvent() {
        return event;
    }

    /**
     * The impact of the content of the message.
     * 
     * @return
     *     An immutable object of type {@link MessageSignificanceCategory} that may be null.
     */
    public MessageSignificanceCategory getCategory() {
        return category;
    }

    /**
     * Identifies the resource (or resources) that are being addressed by the event. For example, the Encounter for an admit 
     * message or two Account records for a merge.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Focus} that may be empty.
     */
    public List<Focus> getFocus() {
        return focus;
    }

    /**
     * Declare at a message definition level whether a response is required or only upon error or success, or never.
     * 
     * @return
     *     An immutable object of type {@link MessageHeaderResponseRequest} that may be null.
     */
    public MessageHeaderResponseRequest getResponseRequired() {
        return responseRequired;
    }

    /**
     * Indicates what types of messages may be sent as an application-level response to this message.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link AllowedResponse} that may be empty.
     */
    public List<AllowedResponse> getAllowedResponse() {
        return allowedResponse;
    }

    /**
     * Canonical reference to a GraphDefinition. If a URL is provided, it is the canonical reference to a [GraphDefinition]
     * (graphdefinition.html) that it controls what resources are to be added to the bundle when building the document. The 
     * GraphDefinition can also specify profiles that apply to the various resources.
     * 
     * @return
     *     An unmodifiable list containing immutable objects of type {@link Canonical} that may be empty.
     */
    public List<Canonical> getGraph() {
        return graph;
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren() || 
            (url != null) || 
            !identifier.isEmpty() || 
            (version != null) || 
            (name != null) || 
            (title != null) || 
            !replaces.isEmpty() || 
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
            (base != null) || 
            !parent.isEmpty() || 
            (event != null) || 
            (category != null) || 
            !focus.isEmpty() || 
            (responseRequired != null) || 
            !allowedResponse.isEmpty() || 
            !graph.isEmpty();
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
                accept(replaces, "replaces", visitor, Canonical.class);
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
                accept(base, "base", visitor);
                accept(parent, "parent", visitor, Canonical.class);
                accept(event, "event", visitor);
                accept(category, "category", visitor);
                accept(focus, "focus", visitor, Focus.class);
                accept(responseRequired, "responseRequired", visitor);
                accept(allowedResponse, "allowedResponse", visitor, AllowedResponse.class);
                accept(graph, "graph", visitor, Canonical.class);
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
        MessageDefinition other = (MessageDefinition) obj;
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
            Objects.equals(replaces, other.replaces) && 
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
            Objects.equals(base, other.base) && 
            Objects.equals(parent, other.parent) && 
            Objects.equals(event, other.event) && 
            Objects.equals(category, other.category) && 
            Objects.equals(focus, other.focus) && 
            Objects.equals(responseRequired, other.responseRequired) && 
            Objects.equals(allowedResponse, other.allowedResponse) && 
            Objects.equals(graph, other.graph);
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
                replaces, 
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
                base, 
                parent, 
                event, 
                category, 
                focus, 
                responseRequired, 
                allowedResponse, 
                graph);
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
        private List<Canonical> replaces = new ArrayList<>();
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
        private Canonical base;
        private List<Canonical> parent = new ArrayList<>();
        private Element event;
        private MessageSignificanceCategory category;
        private List<Focus> focus = new ArrayList<>();
        private MessageHeaderResponseRequest responseRequired;
        private List<AllowedResponse> allowedResponse = new ArrayList<>();
        private List<Canonical> graph = new ArrayList<>();

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
         * The business identifier that is used to reference the MessageDefinition and *is* expected to be consistent from server 
         * to server.
         * 
         * @param url
         *     Business Identifier for a given MessageDefinition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder url(Uri url) {
            this.url = url;
            return this;
        }

        /**
         * A formal identifier that is used to identify this message definition when it is represented in other formats, or 
         * referenced in a specification, model, design or an instance.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param identifier
         *     Primary key for the message definition on a given server
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
         * A formal identifier that is used to identify this message definition when it is represented in other formats, or 
         * referenced in a specification, model, design or an instance.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param identifier
         *     Primary key for the message definition on a given server
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder identifier(Collection<Identifier> identifier) {
            this.identifier = new ArrayList<>(identifier);
            return this;
        }

        /**
         * The identifier that is used to identify this version of the message definition when it is referenced in a 
         * specification, model, design or instance. This is an arbitrary value managed by the message definition author and is 
         * not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not 
         * available. There is also no expectation that versions can be placed in a lexicographical sequence.
         * 
         * @param version
         *     Business version of the message definition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * A natural language name identifying the message definition. This name should be usable as an identifier for the module 
         * by machine processing applications such as code generation.
         * 
         * @param name
         *     Name for this message definition (computer friendly)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * A short, descriptive, user-friendly title for the message definition.
         * 
         * @param title
         *     Name for this message definition (human friendly)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * A MessageDefinition that is superseded by this definition.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param replaces
         *     Takes the place of
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder replaces(Canonical... replaces) {
            for (Canonical value : replaces) {
                this.replaces.add(value);
            }
            return this;
        }

        /**
         * A MessageDefinition that is superseded by this definition.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param replaces
         *     Takes the place of
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder replaces(Collection<Canonical> replaces) {
            this.replaces = new ArrayList<>(replaces);
            return this;
        }

        /**
         * The status of this message definition. Enables tracking the life-cycle of the content.
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
         * A Boolean value to indicate that this message definition is authored for testing purposes (or 
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
         * The date (and optionally time) when the message definition was published. The date must change when the business 
         * version changes and it must change if the status code changes. In addition, it should change when the substantive 
         * content of the message definition changes.
         * 
         * <p>This element is required.
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
         * The name of the organization or individual that published the message definition.
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
         * A free text natural language description of the message definition from a consumer's perspective.
         * 
         * @param description
         *     Natural language description of the message definition
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
         * may be used to assist with indexing and searching for appropriate message definition instances.
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
         * may be used to assist with indexing and searching for appropriate message definition instances.
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
         * A legal or geographic region in which the message definition is intended to be used.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param jurisdiction
         *     Intended jurisdiction for message definition (if applicable)
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
         * A legal or geographic region in which the message definition is intended to be used.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param jurisdiction
         *     Intended jurisdiction for message definition (if applicable)
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder jurisdiction(Collection<CodeableConcept> jurisdiction) {
            this.jurisdiction = new ArrayList<>(jurisdiction);
            return this;
        }

        /**
         * Explanation of why this message definition is needed and why it has been designed as it has.
         * 
         * @param purpose
         *     Why this message definition is defined
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder purpose(Markdown purpose) {
            this.purpose = purpose;
            return this;
        }

        /**
         * A copyright statement relating to the message definition and/or its contents. Copyright statements are generally legal 
         * restrictions on the use and publishing of the message definition.
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
         * The MessageDefinition that is the basis for the contents of this resource.
         * 
         * @param base
         *     Definition this one is based on
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder base(Canonical base) {
            this.base = base;
            return this;
        }

        /**
         * Identifies a protocol or workflow that this MessageDefinition represents a step in.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param parent
         *     Protocol/workflow this is part of
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder parent(Canonical... parent) {
            for (Canonical value : parent) {
                this.parent.add(value);
            }
            return this;
        }

        /**
         * Identifies a protocol or workflow that this MessageDefinition represents a step in.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param parent
         *     Protocol/workflow this is part of
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder parent(Collection<Canonical> parent) {
            this.parent = new ArrayList<>(parent);
            return this;
        }

        /**
         * Event code or link to the EventDefinition.
         * 
         * <p>This element is required.
         * 
         * <p>This is a choice element with the following allowed types:
         * <ul>
         * <li>{@link Coding}</li>
         * <li>{@link Uri}</li>
         * </ul>
         * 
         * @param event
         *     Event code or link to the EventDefinition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder event(Element event) {
            this.event = event;
            return this;
        }

        /**
         * The impact of the content of the message.
         * 
         * @param category
         *     consequence | currency | notification
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder category(MessageSignificanceCategory category) {
            this.category = category;
            return this;
        }

        /**
         * Identifies the resource (or resources) that are being addressed by the event. For example, the Encounter for an admit 
         * message or two Account records for a merge.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param focus
         *     Resource(s) that are the subject of the event
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder focus(Focus... focus) {
            for (Focus value : focus) {
                this.focus.add(value);
            }
            return this;
        }

        /**
         * Identifies the resource (or resources) that are being addressed by the event. For example, the Encounter for an admit 
         * message or two Account records for a merge.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param focus
         *     Resource(s) that are the subject of the event
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder focus(Collection<Focus> focus) {
            this.focus = new ArrayList<>(focus);
            return this;
        }

        /**
         * Declare at a message definition level whether a response is required or only upon error or success, or never.
         * 
         * @param responseRequired
         *     always | on-error | never | on-success
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder responseRequired(MessageHeaderResponseRequest responseRequired) {
            this.responseRequired = responseRequired;
            return this;
        }

        /**
         * Indicates what types of messages may be sent as an application-level response to this message.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param allowedResponse
         *     Responses to this message
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder allowedResponse(AllowedResponse... allowedResponse) {
            for (AllowedResponse value : allowedResponse) {
                this.allowedResponse.add(value);
            }
            return this;
        }

        /**
         * Indicates what types of messages may be sent as an application-level response to this message.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param allowedResponse
         *     Responses to this message
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder allowedResponse(Collection<AllowedResponse> allowedResponse) {
            this.allowedResponse = new ArrayList<>(allowedResponse);
            return this;
        }

        /**
         * Canonical reference to a GraphDefinition. If a URL is provided, it is the canonical reference to a [GraphDefinition]
         * (graphdefinition.html) that it controls what resources are to be added to the bundle when building the document. The 
         * GraphDefinition can also specify profiles that apply to the various resources.
         * 
         * <p>Adds new element(s) to the existing list
         * 
         * @param graph
         *     Canonical reference to a GraphDefinition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder graph(Canonical... graph) {
            for (Canonical value : graph) {
                this.graph.add(value);
            }
            return this;
        }

        /**
         * Canonical reference to a GraphDefinition. If a URL is provided, it is the canonical reference to a [GraphDefinition]
         * (graphdefinition.html) that it controls what resources are to be added to the bundle when building the document. The 
         * GraphDefinition can also specify profiles that apply to the various resources.
         * 
         * <p>Replaces the existing list with a new one containing elements from the Collection
         * 
         * @param graph
         *     Canonical reference to a GraphDefinition
         * 
         * @return
         *     A reference to this Builder instance
         */
        public Builder graph(Collection<Canonical> graph) {
            this.graph = new ArrayList<>(graph);
            return this;
        }

        /**
         * Build the {@link MessageDefinition}
         * 
         * <p>Required elements:
         * <ul>
         * <li>status</li>
         * <li>date</li>
         * <li>event</li>
         * </ul>
         * 
         * @return
         *     An immutable object of type {@link MessageDefinition}
         * @throws IllegalStateException
         *     if the current state cannot be built into a valid MessageDefinition per the base specification
         */
        @Override
        public MessageDefinition build() {
            return new MessageDefinition(this);
        }

        protected Builder from(MessageDefinition messageDefinition) {
            super.from(messageDefinition);
            url = messageDefinition.url;
            identifier.addAll(messageDefinition.identifier);
            version = messageDefinition.version;
            name = messageDefinition.name;
            title = messageDefinition.title;
            replaces.addAll(messageDefinition.replaces);
            status = messageDefinition.status;
            experimental = messageDefinition.experimental;
            date = messageDefinition.date;
            publisher = messageDefinition.publisher;
            contact.addAll(messageDefinition.contact);
            description = messageDefinition.description;
            useContext.addAll(messageDefinition.useContext);
            jurisdiction.addAll(messageDefinition.jurisdiction);
            purpose = messageDefinition.purpose;
            copyright = messageDefinition.copyright;
            base = messageDefinition.base;
            parent.addAll(messageDefinition.parent);
            event = messageDefinition.event;
            category = messageDefinition.category;
            focus.addAll(messageDefinition.focus);
            responseRequired = messageDefinition.responseRequired;
            allowedResponse.addAll(messageDefinition.allowedResponse);
            graph.addAll(messageDefinition.graph);
            return this;
        }
    }

    /**
     * Identifies the resource (or resources) that are being addressed by the event. For example, the Encounter for an admit 
     * message or two Account records for a merge.
     */
    public static class Focus extends BackboneElement {
        @Summary
        @Binding(
            bindingName = "ResourceType",
            strength = BindingStrength.ValueSet.REQUIRED,
            description = "One of the resource types defined as part of this version of FHIR.",
            valueSet = "http://hl7.org/fhir/ValueSet/resource-types|4.0.1"
        )
        @Required
        private final ResourceType code;
        private final Canonical profile;
        @Summary
        @Required
        private final UnsignedInt min;
        private final String max;

        private volatile int hashCode;

        private Focus(Builder builder) {
            super(builder);
            code = ValidationSupport.requireNonNull(builder.code, "code");
            profile = builder.profile;
            min = ValidationSupport.requireNonNull(builder.min, "min");
            max = builder.max;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * The kind of resource that must be the focus for this message.
         * 
         * @return
         *     An immutable object of type {@link ResourceType} that is non-null.
         */
        public ResourceType getCode() {
            return code;
        }

        /**
         * A profile that reflects constraints for the focal resource (and potentially for related resources).
         * 
         * @return
         *     An immutable object of type {@link Canonical} that may be null.
         */
        public Canonical getProfile() {
            return profile;
        }

        /**
         * Identifies the minimum number of resources of this type that must be pointed to by a message in order for it to be 
         * valid against this MessageDefinition.
         * 
         * @return
         *     An immutable object of type {@link UnsignedInt} that is non-null.
         */
        public UnsignedInt getMin() {
            return min;
        }

        /**
         * Identifies the maximum number of resources of this type that must be pointed to by a message in order for it to be 
         * valid against this MessageDefinition.
         * 
         * @return
         *     An immutable object of type {@link String} that may be null.
         */
        public String getMax() {
            return max;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (code != null) || 
                (profile != null) || 
                (min != null) || 
                (max != null);
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
                    accept(code, "code", visitor);
                    accept(profile, "profile", visitor);
                    accept(min, "min", visitor);
                    accept(max, "max", visitor);
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
            Focus other = (Focus) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(code, other.code) && 
                Objects.equals(profile, other.profile) && 
                Objects.equals(min, other.min) && 
                Objects.equals(max, other.max);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    code, 
                    profile, 
                    min, 
                    max);
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
            private ResourceType code;
            private Canonical profile;
            private UnsignedInt min;
            private String max;

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
             * The kind of resource that must be the focus for this message.
             * 
             * <p>This element is required.
             * 
             * @param code
             *     Type of resource
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder code(ResourceType code) {
                this.code = code;
                return this;
            }

            /**
             * A profile that reflects constraints for the focal resource (and potentially for related resources).
             * 
             * @param profile
             *     Profile that must be adhered to by focus
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder profile(Canonical profile) {
                this.profile = profile;
                return this;
            }

            /**
             * Identifies the minimum number of resources of this type that must be pointed to by a message in order for it to be 
             * valid against this MessageDefinition.
             * 
             * <p>This element is required.
             * 
             * @param min
             *     Minimum number of focuses of this type
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder min(UnsignedInt min) {
                this.min = min;
                return this;
            }

            /**
             * Identifies the maximum number of resources of this type that must be pointed to by a message in order for it to be 
             * valid against this MessageDefinition.
             * 
             * @param max
             *     Maximum number of focuses of this type
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder max(String max) {
                this.max = max;
                return this;
            }

            /**
             * Build the {@link Focus}
             * 
             * <p>Required elements:
             * <ul>
             * <li>code</li>
             * <li>min</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link Focus}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid Focus per the base specification
             */
            @Override
            public Focus build() {
                return new Focus(this);
            }

            protected Builder from(Focus focus) {
                super.from(focus);
                code = focus.code;
                profile = focus.profile;
                min = focus.min;
                max = focus.max;
                return this;
            }
        }
    }

    /**
     * Indicates what types of messages may be sent as an application-level response to this message.
     */
    public static class AllowedResponse extends BackboneElement {
        @Required
        private final Canonical message;
        private final Markdown situation;

        private volatile int hashCode;

        private AllowedResponse(Builder builder) {
            super(builder);
            message = ValidationSupport.requireNonNull(builder.message, "message");
            situation = builder.situation;
            ValidationSupport.requireValueOrChildren(this);
        }

        /**
         * A reference to the message definition that must be adhered to by this supported response.
         * 
         * @return
         *     An immutable object of type {@link Canonical} that is non-null.
         */
        public Canonical getMessage() {
            return message;
        }

        /**
         * Provides a description of the circumstances in which this response should be used (as opposed to one of the 
         * alternative responses).
         * 
         * @return
         *     An immutable object of type {@link Markdown} that may be null.
         */
        public Markdown getSituation() {
            return situation;
        }

        @Override
        public boolean hasChildren() {
            return super.hasChildren() || 
                (message != null) || 
                (situation != null);
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
                    accept(message, "message", visitor);
                    accept(situation, "situation", visitor);
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
            AllowedResponse other = (AllowedResponse) obj;
            return Objects.equals(id, other.id) && 
                Objects.equals(extension, other.extension) && 
                Objects.equals(modifierExtension, other.modifierExtension) && 
                Objects.equals(message, other.message) && 
                Objects.equals(situation, other.situation);
        }

        @Override
        public int hashCode() {
            int result = hashCode;
            if (result == 0) {
                result = Objects.hash(id, 
                    extension, 
                    modifierExtension, 
                    message, 
                    situation);
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
            private Canonical message;
            private Markdown situation;

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
             * A reference to the message definition that must be adhered to by this supported response.
             * 
             * <p>This element is required.
             * 
             * @param message
             *     Reference to allowed message definition response
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder message(Canonical message) {
                this.message = message;
                return this;
            }

            /**
             * Provides a description of the circumstances in which this response should be used (as opposed to one of the 
             * alternative responses).
             * 
             * @param situation
             *     When should this response be used
             * 
             * @return
             *     A reference to this Builder instance
             */
            public Builder situation(Markdown situation) {
                this.situation = situation;
                return this;
            }

            /**
             * Build the {@link AllowedResponse}
             * 
             * <p>Required elements:
             * <ul>
             * <li>message</li>
             * </ul>
             * 
             * @return
             *     An immutable object of type {@link AllowedResponse}
             * @throws IllegalStateException
             *     if the current state cannot be built into a valid AllowedResponse per the base specification
             */
            @Override
            public AllowedResponse build() {
                return new AllowedResponse(this);
            }

            protected Builder from(AllowedResponse allowedResponse) {
                super.from(allowedResponse);
                message = allowedResponse.message;
                situation = allowedResponse.situation;
                return this;
            }
        }
    }
}
