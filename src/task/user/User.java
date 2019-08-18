package task.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private String email;

    private ArrayList<String> roles;

    private ArrayList<String> phoneNumbers;

    public User() {
    }

    public User(String firstName, String lastName, String email, ArrayList<String> roles, ArrayList<String> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.phoneNumbers = phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(phoneNumbers, user.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, roles, phoneNumbers);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
