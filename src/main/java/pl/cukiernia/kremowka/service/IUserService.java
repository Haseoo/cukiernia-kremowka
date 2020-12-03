package pl.cukiernia.kremowka.service;

public interface IUserService {
    boolean checkUser(String login);
    boolean verifyUser(String login, String secret);
}
