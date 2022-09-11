package vttp2022.ssf.MiniProject01.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.ssf.MiniProject01.models.RealTimeInfo;
import vttp2022.ssf.MiniProject01.services.RealTimeService;

@Controller
public class RealTimeController {

	@Autowired
	private RealTimeService realTimeSvc;

	// @RequestMapping(path = { "/", "/index.html", "" })
	// public String test() {
	// 	return "index";
	// } 

	@GetMapping(path = { "/flights" })
	public String getFlightResults(Model model, HttpSession sess) {

		String name = (String)sess.getAttribute("name");
		List<RealTimeInfo> flights = realTimeSvc.getRealTimeFlights();

		if (isNull(name))
			return "redirect:index.html";

		model.addAttribute("name", name.toUpperCase());
		model.addAttribute("flights", flights);

		return "flights";
	}

	@PostMapping
	public String postCart(@RequestBody MultiValueMap<String, String> form
				, Model model, HttpSession sess) {

		List<RealTimeInfo> flights = null;

		String name = form.getFirst("name");
		if (!isNull(name)) {
			// new session
			System.out.println("name not in session");
			sess.setAttribute("name", name);
			flights = new LinkedList<>();
			sess.setAttribute("flights", flights);

		} 

		name = (String)sess.getAttribute("name");
		flights = (List<RealTimeInfo>)sess.getAttribute("flights");

		model.addAttribute("name", name.toUpperCase());
		model.addAttribute("flights", flights);

		return "flights";
	}
	
	private boolean isNull(String s) {
		return ((null == s) || (s.trim().length() <= 0));
	}
}



