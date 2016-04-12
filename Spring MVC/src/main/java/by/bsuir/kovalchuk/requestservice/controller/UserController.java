package by.bsuir.kovalchuk.requestservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.kovalchuk.requestservice.dto.UserDTO;
import by.bsuir.kovalchuk.requestservice.model.Employee;
import by.bsuir.kovalchuk.requestservice.service.RequestService;
import static by.bsuir.kovalchuk.requestservice.util.Constants.*;

@RestController
public class UserController {

	@Autowired
	private RequestService requestService;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signIn(@RequestBody UserDTO employee,
			HttpServletRequest request) throws Exception {
		try {
			requestService.signIn(employee, request);
			return MAIN;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public ModelAndView redirect(@PathVariable String page,
			HttpServletRequest request) {
		if (request.getSession().getAttribute(USER) == null) {
			return new ModelAndView(INDEX);
		} else {
			return new ModelAndView(page);
		}
	}

	@RequestMapping(value = "/profilePhoto", method = RequestMethod.GET)
	public void getPhoto(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		if (request.getSession().getAttribute(USER) != null) {
			requestService.getPhoto(response, request);
		}
	}

	@RequestMapping(value = "/profilePhoto", method = RequestMethod.POST)
	public @ResponseBody String savePhoto(MultipartHttpServletRequest request) {
		return requestService.savePhoto(request);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUp(@RequestBody Employee employee,
			HttpServletRequest request) {
		requestService.signUp(employee, request);
		return new ModelAndView(MAIN);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().setAttribute(USER, null);
		return new ModelAndView(INDEX);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView updateProfile(Employee employee,
			HttpServletRequest request) {
		requestService.updateProfile(employee, request);
		return new ModelAndView(INDEX);
	}

	{

	}
}
