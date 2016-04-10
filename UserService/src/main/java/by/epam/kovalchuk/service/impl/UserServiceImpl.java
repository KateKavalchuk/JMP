package by.epam.kovalchuk.service.impl;

import java.io.File;
import java.util.List;

import by.epam.kovalchuk.entity.User;
import by.epam.kovalchuk.entity.UserList;
import by.epam.kovalchuk.service.UserService;
import by.epam.kovalchuk.util.JaxbUtil;

public class UserServiceImpl implements UserService {

	private String fileName;
	private String imageDirectory;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getImageDirectory() {
		return imageDirectory;
	}

	public void setImageDirectory(String imageDirectory) {
		this.imageDirectory = imageDirectory;
	}

	@Override
	public User getUser(String login) throws Exception {
		UserList userList = (UserList) JaxbUtil.readObject(fileName,
				UserList.class);
		for (User user : userList.getUsers()) {
			if (login.equals(user.getLogin())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void saveUser(User user) throws Exception {
		UserList userList = (UserList) JaxbUtil.readObject(fileName,
				UserList.class);
		userList.getUsers().add(user);
		JaxbUtil.writeObject(fileName, userList);
	}

	@Override
	public void updateUser(String login, User newUser) throws Exception {
		UserList userList = (UserList) JaxbUtil.readObject(fileName,
				UserList.class);
		List<User> users = userList.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(login)) {
				users.set(i, newUser);
				break;
			}
		}
		userList.setUsers(users);
		JaxbUtil.writeObject(fileName, userList);
	}

	@Override
	public List<User> deleteUser(String login) throws Exception {
		UserList userList = (UserList) JaxbUtil.readObject(fileName,
				UserList.class);
		List<User> users = userList.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(login)) {
				users.remove(i);
				break;
			}
		}
		userList.setUsers(users);
		JaxbUtil.writeObject(fileName, userList);
		return ((UserList) JaxbUtil.readObject(fileName, UserList.class))
				.getUsers();
	}

	@Override
	public List<User> getAllUsers() throws Exception {
		UserList userList = (UserList) JaxbUtil.readObject(fileName,
				UserList.class);
		return userList.getUsers();
	}

	@Override
	public String saveImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getImage(String login) throws Exception {
		return new File(imageDirectory + login);
	}

}
