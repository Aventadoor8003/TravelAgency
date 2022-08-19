package main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import main.externalapi.model.openweathermap.OpenWeatherMap;
import main.service.ExternalAPIsServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private ExternalAPIsServiceImpl externalApiService;

	@RequestMapping("/")
	public String getHome(HttpServletRequest request, Model model) {
		OpenWeatherMap openWeatherMap = externalApiService.getData(request);
		model.addAttribute("openweathermap", openWeatherMap);
		
		return "home";
	}
	
}
