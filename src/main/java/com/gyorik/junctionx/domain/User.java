package com.gyorik.junctionx.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private boolean isEmployee;

    private boolean isContracted;

    private double balance;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Skill> skills;

    private int Xp;

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public boolean isContracted() {
        return isContracted;
    }

    public void setContracted(boolean contracted) {
        isContracted = contracted;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getXp() {
        return Xp;
    }

    public void setXp(int xp) {
        Xp = xp;
    }

    public User(String username, boolean isEmployee, boolean isContracted, double balance, List<Skill> skills, int xp) {
        this.username = username;
        this.isEmployee = isEmployee;
        this.isContracted = isContracted;
        this.balance = balance;
        this.skills = skills;
        Xp = xp;
    }

    public void CopyUser(User _user) {
        this.username = _user.getUsername();
        this.isEmployee = _user.isEmployee();
        this.isContracted = _user.isContracted();
        this.balance = _user.getBalance();
        this.skills = _user.getSkills();
        Xp = _user.Xp;
    }
}