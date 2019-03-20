package Domain;

import java.util.Objects;

public class ClientCard2 extends Entity {
    private String name, firstname, cnp, birthDate, registrationDate;

    public ClientCard2(int id, String name, String firstname, String cnp, String birthDate, String registrationDate) {
        super(id);
        this.name = name;
        this.firstname = firstname;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", cnp='" + cnp + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
