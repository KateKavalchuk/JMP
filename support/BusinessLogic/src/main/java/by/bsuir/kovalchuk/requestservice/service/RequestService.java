package by.bsuir.kovalchuk.requestservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import by.bsuir.kovalchuk.requestservice.dao.impl.EmployeeDAO;
import by.bsuir.kovalchuk.requestservice.dao.impl.PriorityDAO;
import by.bsuir.kovalchuk.requestservice.dao.impl.RequestDAO;
import by.bsuir.kovalchuk.requestservice.dto.UserDTO;
import by.bsuir.kovalchuk.requestservice.model.Employee;
import by.bsuir.kovalchuk.requestservice.model.Priority;
import by.bsuir.kovalchuk.requestservice.model.Request;
import by.bsuir.kovalchuk.requestservice.util.EmailSender;
import by.bsuir.kovalchuk.requestservice.util.ImageService;
import static by.bsuir.kovalchuk.requestservice.util.Constants.*;

@Service("requestService")
public class RequestService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private ImageService imageService;
	@Autowired
	private RequestDAO requestDAO;
	@Autowired
	private PriorityDAO priorityDAO;

	public void signIn(UserDTO userDTO, HttpServletRequest request)
			throws Exception {
		if (userDTO == null) {
			throw new Exception();
		}
		Employee employee = employeeDAO.fetchByEmailAndPassword(
				userDTO.getEmail(), userDTO.getPassword());
		convertFromEmployeeToUserDTO(userDTO, employee);
		request.getSession().setAttribute(USER, userDTO);
	}

	public void signUp(Employee employee, HttpServletRequest request) {
		employeeDAO.saveOrUpdate(employee);
		UserDTO userDTO = new UserDTO();
		convertFromEmployeeToUserDTO(userDTO, employee);
		EmailSender sender = new EmailSender();
		sender.send(
				"Thank you for register on our site!",
				"You was registered in our support system! Thank You for using us!",
				"katsekavalchuk@gmail.com", userDTO.getEmail());
		request.getSession().setAttribute(USER, userDTO);
	}

	public void getPhoto(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute(USER);
		String name = userDTO.getPhoto();
		FileCopyUtils.copy(imageService.getImage(name),
				response.getOutputStream());
	}

	public List<Request> fetchRequestsByDepartment(int idDepartment) {
		List<?> requests = requestDAO.fetchByDepartment(idDepartment);
		List<Request> requestsFinal = new ArrayList<>();
		for (int i = 0; i < requests.size(); i++) {
			Request request = (Request) requests.get(i);
			requestsFinal.add(request);
		}
		return requestsFinal;
	}

	public String savePhoto(MultipartHttpServletRequest request) throws Exception {
		String name = DEFULT_PHOTO_NAME;
		name = imageService.saveImage(request.getFile("userPhoto"));
		return name;
	}

	public List<Priority> getAllPriorities() {
		return priorityDAO.getAll();
	}

	public void saveOrUpdateRequest(Request request) {
		requestDAO.saveOrUpdate(request);
		EmailSender sender = new EmailSender();
		sender.send(
				"Thank you for register on our site!",
				"You request was created in our system! We will resolve your issue as soon as possible!",
				"katsekavalchuk@gmail.com", "kovalchuk-ekater@mail.ru");
	}

	public List<Request> fetchRequestsByUserId(int userId) {
		List<?> requests = requestDAO.fetchByUserId(userId);
		List<Request> requestsFinal = new ArrayList<>();
		for (int i = 0; i < requests.size(); i++) {
			Request request = (Request) requests.get(i);
			requestsFinal.add(request);
		}
		return requestsFinal;
	}

	public void assignToUser(Request userRequest, int userId) {
		userRequest.getEmployee().setId(userId);
		requestDAO.saveOrUpdate(userRequest);
	}

	public void updateProfile(Employee employee, HttpServletRequest request) {
		employee.setId(((UserDTO) (request.getSession().getAttribute(USER)))
				.getId());
		employeeDAO.saveOrUpdate(employee);
	}

	private void convertFromEmployeeToUserDTO(UserDTO userDTO, Employee employee) {
		userDTO.setId(employee.getId());
		userDTO.setEmail(employee.getEmail());
		userDTO.setPassword(employee.getPassword());
		userDTO.setContanctNumber(employee.getContactNumber());
		userDTO.setFirstName(employee.getFirstName());
		userDTO.setLastName(employee.getLastName());
		userDTO.setPhoto(employee.getPhoto());
		userDTO.setIdDepartment(employee.getDepartment().getId());
	}

}
