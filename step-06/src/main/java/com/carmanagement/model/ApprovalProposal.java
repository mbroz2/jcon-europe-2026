package com.carmanagement.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Model representing a disposition proposal awaiting human approval.
 * This is the core of the Human-in-the-Loop pattern - proposals are stored
 * and the workflow pauses until a human makes an approval decision.
 */
public class ApprovalProposal {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);
    
    public Long id;

    /**
     * The car number this proposal is for
     */
    public Integer carNumber;

    /**
     * Car make
     */
    public String carMake;

    /**
     * Car model
     */
    public String carModel;

    /**
     * Car year
     */
    public Integer carYear;

    /**
     * Estimated car value
     */
    public String carValue;

    /**
     * Proposed disposition action (SCRAP, SELL, DONATE, KEEP)
     */
    public String proposedDisposition;

    /**
     * Reasoning for the proposed disposition
     */
    public String dispositionReason;

    /**
     * Current car condition
     */
    public String carCondition;

    /**
     * Rental feedback that triggered this proposal
     */
    public String rentalFeedback;

    /**
     * Current status of the approval
     */
    public ApprovalStatus status = ApprovalStatus.PENDING;

    /**
     * Human's decision (APPROVED or REJECTED)
     */
    public String decision;

    /**
     * Human's reasoning for their decision
     */
    public String approvalReason;

    /**
     * Who approved/rejected (for audit trail)
     */
    public String approvedBy;

    /**
     * When the proposal was created
     */
    public LocalDateTime createdAt = LocalDateTime.now();

    /**
     * When the decision was made
     */
    public LocalDateTime decidedAt;

    public ApprovalProposal() {
        this.id = ID_GENERATOR.getAndIncrement();
    }

    /**
     * Approval status enum
     */
    public enum ApprovalStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}

// Made with Bob
