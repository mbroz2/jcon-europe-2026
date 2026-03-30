package com.carmanagement.repository;

import com.carmanagement.model.ApprovalProposal;
import com.carmanagement.model.ApprovalProposal.ApprovalStatus;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * In-memory repository for ApprovalProposal entities.
 */
@ApplicationScoped
public class ApprovalProposalRepository {
    private final Map<Long, ApprovalProposal> proposals = new ConcurrentHashMap<>();

    /**
     * Add a new proposal to the repository
     */
    public ApprovalProposal add(ApprovalProposal proposal) {
        proposals.put(proposal.id, proposal);
        return proposal;
    }

    /**
     * Find a proposal by ID
     */
    public ApprovalProposal findById(Long id) {
        return proposals.get(id);
    }

    /**
     * Find all proposals
     */
    public List<ApprovalProposal> listAll() {
        return proposals.values().stream().collect(Collectors.toList());
    }

    /**
     * Find pending proposal for a specific car
     */
    public ApprovalProposal findPendingByCarNumber(Integer carNumber) {
        return proposals.values().stream()
                .filter(p -> p.carNumber.equals(carNumber) && p.status == ApprovalStatus.PENDING)
                .findFirst()
                .orElse(null);
    }

    /**
     * Find all pending proposals
     */
    public List<ApprovalProposal> findAllPending() {
        return proposals.values().stream()
                .filter(p -> p.status == ApprovalStatus.PENDING)
                .collect(Collectors.toList());
    }

    /**
     * Persist (save or update) a proposal
     */
    public void persist(ApprovalProposal proposal) {
        proposals.put(proposal.id, proposal);
    }

    /**
     * Get count of all proposals
     */
    public long count() {
        return proposals.size();
    }

    /**
     * Delete a proposal
     */
    public void delete(ApprovalProposal proposal) {
        proposals.remove(proposal.id);
    }

    /**
     * Clear all proposals (useful for testing)
     */
    public void clear() {
        proposals.clear();
    }
}

// Made with Bob
