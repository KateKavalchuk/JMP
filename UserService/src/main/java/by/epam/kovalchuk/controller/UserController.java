package by.epam.kovalchuk.controller;

import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import by.epam.kovalchuk.entity.User;
import by.epam.kovalchuk.entity.UserList;
import by.epam.kovalchuk.service.UserService;

@WebService(name = "UserService")
@Path("/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getUser(@QueryParam(value = "login") String login) {
		try {
			User user = userService.getUser(login);
			return Response.ok(user).build();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response saveUser(User user) {
		try {
			userService.saveUser(user);
			return Response.ok(user).build();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateUser(User user,
			@QueryParam(value = "login") String login) {
		try {
			userService.updateUser(login, user);
			return Response.ok(user).build();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/all")
	public Response getAllUsers() {
		try {
			UserList userList = new UserList();
			userList.setUsers(userService.getAllUsers());
			return Response.ok(userList).build();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteUser(@QueryParam(value = "login") String login) {
		try {
			UserList userList = new UserList();
			userList.setUsers(userService.deleteUser(login));
			return Response.ok(userList).build();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/image")
	@Produces("image/png")
	public Response getUserLogo(@QueryParam(value = "login") String login) {
		try {
			ResponseBuilder response = Response.ok(userService.getImage(login));
			response.header("Content-Disposition",
					"attachment; filename=image_from_server.png");
			return response.build();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@POST
	@Path("/image")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response saveImage(List<Attachment> attachments,
			@Context HttpServletRequest request,
			@QueryParam(value = "login") String login) {
		try {
			String path = userService.saveImage();
			return Response.ok(path).build();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
