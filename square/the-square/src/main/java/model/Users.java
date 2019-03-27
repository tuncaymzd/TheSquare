package model;

public class Users extends BaseModel {
    private String firstname;
    private String lastname;
    private String birthday;
    private String city;
    private String mail;
    private String phone;
    private String description;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String surname) {
        this.firstname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        String firstname;
        String lastname;
        String birthday;
        String city;
        String mail;
        String phone;
        String description;

        public Builder withSurname(String surname){
            this.firstname = surname;
            return this;
        }

        public Builder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }

        public Builder withBirthday(String birthday){
            this.birthday = birthday;
            return this;
        }

        public Builder withCity(String city){
            this.city = city;
            return this;
        }

        public Builder withMail(String mail){
            this.mail = mail;
            return this;
        }

        public Builder withPhone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Users Build() {
            Users users = new Users();
            users.setFirstname(firstname);
            users.setLastname(lastname);
            users.setBirthday(birthday);
            users.setCity(city);
            users.setMail(mail);
            users.setPhone(phone);
            users.setDescription(description);
            return users;
        }

    }
}
