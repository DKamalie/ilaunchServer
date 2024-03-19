package com.Ilaunch.Ilaunch.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class User {
    @Id
    protected String userId;
    protected String name;
    protected String surname;
    protected String username;
    protected String email;
    protected boolean active;
    protected String role;

    public User() {}
    protected User(Builder builder) {
        this.userId = builder.userID;
        this.name = builder.name;
        this.username = builder.username;
        this.surname = builder.surname;
        this.email = builder.email;
        this.active = builder.active;
        this.role = builder.role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //    Builder pattern for testing
    public static  class Builder {
        private String userID;
        private String name;
        private String surname;
        private String username;
        private String email;
        private boolean active;
        private String role;

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }
        public Builder setRole(String role) {
            this.role = role;
            return this;
        }
        public Builder copy(User user) {
            this.userID = user.userId;
            this.name = user.name;
            this.username = user.username;
            this.surname = user.surname;
            this.email = user.email;
            this.active = user.active;
            this.role = user.role;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(username, user.username) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(active, user.active) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode(){return Objects.hash(userId, name, surname, username, email, active, role);}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", active='" + active + '\'' +
                ", role=" + role +
                '}';
    }
}
