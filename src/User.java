public class User extends Entity {

    private String name;
    private String surname;
    private String password;
    private String email;

    public User(String name, String password, String email, String password2) {

        super();
        this.name = name;
        this.password = password;
        this.setEmail(email);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validate() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String string) {
    }
}
