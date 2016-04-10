package by.epam.kovalchuk.service;

import java.io.File;
import java.util.List;

import by.epam.kovalchuk.entity.User;

public interface UserService {

	User getUser(String login) throws Exception;

	void saveUser(User user) throws Exception;

	void updateUser(String login, User newUser) throws Exception;

	List<User> deleteUser(String login) throws Exception;

	List<User> getAllUsers() throws Exception;

	String saveImage() throws Exception;

	File getImage(String login) throws Exception;

}
