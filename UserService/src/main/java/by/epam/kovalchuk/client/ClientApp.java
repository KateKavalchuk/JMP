package by.epam.kovalchuk.client;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import by.epam.kovalchuk.entity.User;
import by.epam.kovalchuk.entity.UserList;
import by.epam.kovalchuk.util.JaxbUtil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientApp {

	private static final String URL = "http://localhost:8080/UserService/userservice/user";
	private static final String FAILED_MESSAGE = "Failed : HTTP error code : ";
	private static final Logger LOGGER = Logger.getLogger(ClientApp.class);

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			Client client = Client.create();
			while (true) {
				System.out
						.println("Choose menu point:\n 1) Get user by login.\n 2) Add user.\n 3) Update user.\n 4) Delete user. ");
				int menuPoint = scanner.nextInt();
				switch (menuPoint) {
				case 1: {
					scanner.nextLine();
					System.out.println("Enter login:");
					String login = scanner.nextLine();

					// get user
					WebResource webResource = client.resource(URL + "?login="
							+ login);
					ClientResponse response = webResource.type(
							MediaType.APPLICATION_XML)
							.get(ClientResponse.class);
					if (response.getStatus() > 399) {
						throw new RuntimeException(FAILED_MESSAGE
								+ response.getStatus());
					}
					User user = response.getEntity(User.class);
					System.out.println(user.toString());
				}
					break;
				case 2: {
					// save user
					WebResource webResource = client.resource(URL);
					ClientResponse response = webResource
							.type(MediaType.APPLICATION_XML)
							.accept(MediaType.APPLICATION_XML)
							.post(ClientResponse.class, enterUser());
					if (response.getStatus() > 399) {
						throw new RuntimeException(FAILED_MESSAGE
								+ response.getStatus());
					}
					User user = response.getEntity(User.class);
					System.out.println("User was successfully created : "
							+ user.toString());
				}
					break;
				case 3: {
					// update user
					WebResource webResource = client.resource(URL + "/all");
					ClientResponse response = webResource.type(
							MediaType.APPLICATION_XML)
							.get(ClientResponse.class);
					if (response.getStatus() > 399) {
						throw new RuntimeException(FAILED_MESSAGE
								+ response.getStatus());
					}

					UserList userList = response.getEntity(UserList.class);
					System.out
							.println("Enter number of user, which you wanna update: ");
					List<User> users = userList.getUsers();
					for (int i = 1; i <= users.size(); i++) {
						System.out.println(i + ") " + users.get(i - 1));
					}
					int result = scanner.nextInt();
					System.out.println("Enter new user parameters.");

					webResource = client.resource(URL + "?login="
							+ users.get(result - 1).getLogin());
					response = webResource.type(MediaType.APPLICATION_XML)
							.accept(MediaType.APPLICATION_XML)
							.put(ClientResponse.class, enterUser());
					if (response.getStatus() > 399) {
						throw new RuntimeException(FAILED_MESSAGE
								+ response.getStatus());
					}
					User user = response.getEntity(User.class);
					System.out.println("User was successfully updated : "
							+ user.toString());
				}
					break;
				case 4: {
					// delete user
					scanner.nextLine();
					System.out.println("Enter login:");
					String login = scanner.nextLine();

					WebResource webResource = client.resource(URL + "?login="
							+ login);
					ClientResponse response = webResource.type(
							MediaType.APPLICATION_XML).delete(
							ClientResponse.class);
					if (response.getStatus() > 399) {
						throw new RuntimeException(FAILED_MESSAGE
								+ response.getStatus());
					}
					System.out.println("User was successfully deleted");
					UserList userList = response.getEntity(UserList.class);
					List<User> users = userList.getUsers();
					for (int i = 1; i <= users.size(); i++) {
						System.out.println(i + ") " + users.get(i - 1));
					}
				}
					break;
				default: {
					client.destroy();
					System.exit(0);
				}
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private static final String enterUser() throws Exception {
		Scanner scanner = new Scanner(System.in);
		User user = new User();

		System.out.println("Enter login: ");
		user.setLogin(scanner.nextLine());
		System.out.println("Enter first name: ");
		user.setFirstName(scanner.nextLine());
		System.out.println("Enter last name: ");
		user.setLastName(scanner.nextLine());
		System.out.println("Enter email:");
		user.setEmail(scanner.nextLine());
		return JaxbUtil.marshal(user);
	}

}
