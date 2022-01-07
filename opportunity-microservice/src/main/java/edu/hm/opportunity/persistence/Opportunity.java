package edu.hm.opportunity.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * Data model for opportunities.
 *
 * @author Simon Hirner
 */
@Document(collection = "opportunities")
public class Opportunity {

    @Id
    private String id;

    private LocalDate estimatedCloseDate;

    private double value;

    private double budget;

    private double discount;

    private Status status;

    private String note;

    @Min(value = 1, message = "Priority should be at least 1")
    @Max(value = 3, message = "Priority should be at most 3")
    private int priority;

    private String relatedContactID;

    /**
     * Default constructor.
     */
    private Opportunity() {
        // Is needed
    }

    /**
     * Constructor
     *
     * @param estimatedCloseDate estimated close date
     * @param status status
     * @param priority priority
     */
    public Opportunity(LocalDate estimatedCloseDate, Status status, int priority) {
        this.estimatedCloseDate = estimatedCloseDate;
        this.status = status;
        this.priority = priority;
    }

    /**
     * Constructor.
     *
     * @param estimatedCloseDate estimated close date
     * @param value value amount
     * @param budget budget amount
     * @param discount discount amount
     * @param status status
     * @param note note
     * @param priority priority
     * @param relatedContactID related contact ID
     */
    public Opportunity(LocalDate estimatedCloseDate, double value, double budget, double discount,
                       Status status, String note, int priority, String relatedContactID) {
        this.estimatedCloseDate = estimatedCloseDate;
        this.value = value;
        this.budget = budget;
        this.discount = discount;
        this.status = status;
        this.note = note;
        this.priority = priority;
        this.relatedContactID = relatedContactID;
    }

    public String getId() {
        return id;
    }

    public LocalDate getEstimatedCloseDate() {
        return estimatedCloseDate;
    }

    public void setEstimatedCloseDate(LocalDate estimatedCloseDate) {
        this.estimatedCloseDate = estimatedCloseDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getRelatedContactID() {
        return relatedContactID;
    }

    public void setRelatedContactID(String relatedContactID) {
        this.relatedContactID = relatedContactID;
    }

    @Override
    public String toString() {
        return "Opportunity{"
                + "id='" + id + '\''
                + ", status='" + status + '\''
                + ", priority='" + priority + '\''
                + '}';
    }

}
