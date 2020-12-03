package pl.cukiernia.kremowka.model;

public class UserModel {
    private String login;
    private String userSecret;

    public UserModel(String login, String userSecret) {
        this.login = login;
        this.userSecret = userSecret;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }
}
