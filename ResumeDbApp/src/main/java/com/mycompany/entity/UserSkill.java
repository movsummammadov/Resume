package com.mycompany.entity;

import java.util.Objects;

/**
 *
 * @author Movsum Mammadov
 * 
 **/

public class UserSkill {
    private Integer id;
    private User user;
    private Skill skill;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
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
        final UserSkill other = (UserSkill) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    private int power;

    public UserSkill() {
    }

    public UserSkill(Integer id, User user, Skill skill, int power) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", user=" + user + ", skill=" + skill + ", power=" + power + '}';
    }
    
}
