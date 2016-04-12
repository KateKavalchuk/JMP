package by.bsuir.kovalchuk.requestservice.controller;

import static by.bsuir.kovalchuk.requestservice.util.Constants.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsuir.kovalchuk.requestservice.dto.UserDTO;
import by.bsuir.kovalchuk.requestservice.model.Request;
import by.bsuir.kovalchuk.requestservice.service.RequestService;

@Controller
public class RequestController {

	@Autowired
	private RequestService requestService;

	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String showCreateRequestView(HttpServletRequest request,
			Map<String, Object> model) {
		if (request.getSession().getAttribute(USER) == null) {
			return INDEX;
		} else {
			Request requestForm = new Request();
			model.put("priorities", requestService.getAllPriorities());
			model.put("requestForm", requestForm);
			return CREATE_REQUEST;
		}
	}

	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public String createRequest(HttpServletRequest request,
			@ModelAttribute("requestForm") Request requestForm,
			Map<String, Object> model) {
		if (request.getSession().getAttribute(USER) == null) {
			return INDEX;
		} else {
			requestService.saveOrUpdateRequest(requestForm);
			return SHOW_REQUEST;
		}
	}

	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public String showCreatedRequest(HttpServletRequest request,
			Map<String, Object> model) {
		if (request.getSession().getAttribute(USER) == null) {
			return INDEX;
		} else {
			model.put("requests", requestService
					.fetchRequestsByDepartment(((UserDTO) request.getSession()
							.getAttribute(USER)).getIdDepartment()));
			return DEPARTMENT_REQUESTS;
		}
	}

	@RequestMapping(value = "/userrequests", method = RequestMethod.GET)
	public String showCreatedRequestsAssignToUser(HttpServletRequest request,
			Map<String, Object> model) {
		if (request.getSession().getAttribute(USER) == null) {
			return INDEX;
		} else {
			model.put("requests", requestService
					.fetchRequestsByUserId(((UserDTO) request.getSession()
							.getAttribute(USER)).getId()));
			return DEPARTMENT_REQUESTS;
		}
	}

	@RequestMapping(value = "/assignToMe")
	public void assignToMe(Request userRequest, HttpServletRequest request) {
		requestService.assignToUser(userRequest, ((UserDTO) request.getSession().getAttribute(USER)).getId());
	}

}
