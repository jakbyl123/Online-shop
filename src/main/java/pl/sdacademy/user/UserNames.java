package pl.sdacademy.user;

import javax.persistence.Embeddable;

@Embeddable
public class UserNames {
    private String firstName;
    private String middleName;
    private String lastName;

    public UserNames(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public UserNames() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
