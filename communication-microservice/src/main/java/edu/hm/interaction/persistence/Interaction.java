package edu.hm.interaction.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Data model for interactions.
 *
 * @author Simon Hirner
 */
@Document(collection = "interactions")
public class Interaction {

    @Id
    private String id;

    private FormOfInteraction formOfInteraction;

    private String note;

    @NotBlank(message = "Contact ID should not be blank")
    private String contactId;

    private LocalDateTime dateAndTime;

    /**
     * Default constructor.
     */
    private Interaction() {
        // Is needed
    }

    /**
     * Constructor.
     *
     * @param formOfInteraction form of interaction
     * @param contactId contact ID
     * @param dateAndTime date and time of interaction
     */
    public Interaction(FormOfInteraction formOfInteraction, String contactId,
                       LocalDateTime dateAndTime) {
        this.formOfInteraction = formOfInteraction;
        this.contactId = contactId;
        this.dateAndTime = dateAndTime;
    }

    /**
     * Constructor.
     *
     * @param formOfInteraction form of interaction
     * @param note note
     * @param contactId contact ID
     * @param dateAndTime date and time of interaction
     */
    public Interaction(FormOfInteraction formOfInteraction, String note,
                       String contactId, LocalDateTime dateAndTime) {
        this.formOfInteraction = formOfInteraction;
        this.note = note;
        this.contactId = contactId;
        this.dateAndTime = dateAndTime;
    }

    public String getId() {
        return id;
    }

    public FormOfInteraction getFormOfInteraction() {
        return formOfInteraction;
    }

    public void setFormOfInteraction(FormOfInteraction formOfInteraction) {
        this.formOfInteraction = formOfInteraction;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public String toString() {
        return "Interaction{"
                + "id='" + id + '\''
                + ", formOfInteraction=" + formOfInteraction
                + ", dateAndTime=" + dateAndTime
                + '}';
    }
}
