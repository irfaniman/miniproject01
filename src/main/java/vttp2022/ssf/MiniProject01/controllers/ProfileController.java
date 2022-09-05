package vttp2022.ssf.MiniProject01.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.ssf.MiniProject01.models.RealTimeInfo;
import vttp2022.ssf.MiniProject01.services.RealTimeService;

@Controller
public class ProfileController {

	@Autowired
	private RealTimeService realTimeSvc;

	// @RequestMapping(path = { "/", "/index.html", "" })
	// public String test() {
	// 	return "index";
	// } 

	@GetMapping(path = { "/realTime" })
	public String getFlightResults(Model model, HttpSession sess) {
		
		List<RealTimeInfo> flights = realTimeSvc.getRealTimeFlights();
		//sess.setAttribute("sess", flights);
		model.addAttribute("flights", flights);
		return "realTime";
	}
} 



