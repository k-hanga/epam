package com.gyorik.junctionx.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String summary;

    private String description;

    private Long employer;

    @ElementCollection
    private List<Long> applicants;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String location;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Skill> requiredSkills;

    private int requiredXp;

    public List<Skill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<Skill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    private Status status;

    private double payment;

    private LocalDateTime deadline;

    public Job() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEmployer() {
        return employer;
    }

    public void setEmployer(Long employer) {
        this.employer = employer;
    }

    public List<Long> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Long> applicants) {
        this.applicants = applicants;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRequiredXp() {
        return requiredXp;
    }

    public void setRequiredXp(int requiredXp) {
        this.requiredXp = requiredXp;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void CopyJob(Job _job) {
        this.summary = _job.getSummary();
        this.description = _job.getDescription();
        this.employer = _job.getEmployer();
        this.applicants = _job.getApplicants();
        this.startDate = _job.getStartDate();
        this.endDate = _job.getEndDate();
        this.location = _job.getLocation();
        this.requiredSkills = _job.getRequiredSkills();
        this.requiredXp = _job.getRequiredXp();
        this.status = _job.getStatus();
        this.payment = _job.getPayment();
        this.deadline = _job.getDeadline();
    }


    public Job(String summary, String description, Long employer, List<Long> applicants, LocalDateTime startDate, LocalDateTime endDate, String location, List<Skill> requiredSkills, int requiredXp, Status status, double payment, LocalDateTime deadline) {
        this.summary = summary;
        this.description = description;
        this.employer = employer;
        this.applicants = applicants;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.requiredSkills = requiredSkills;
        this.requiredXp = requiredXp;
        this.status = status;
        this.payment = payment;
        this.deadline = deadline;
    }
}
