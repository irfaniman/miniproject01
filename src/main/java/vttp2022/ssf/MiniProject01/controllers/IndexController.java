// package vttp2022.ssf.MiniProject01.controllers;

// import javax.servlet.http.HttpSession;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.util.MultiValueMap;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
// @RequestMapping({"/", "", "index.html"})
// public class IndexController {

// 	@PostMapping
// 	public String postCart(@RequestBody MultiValueMap<String, String> form
// 				, Model model, HttpSession sess) {

		
// 		String name = form.getFirst("name");
// 		if (!isNull(name)) {
// 			// new session
// 			System.out.println("name not in session");
// 			sess.setAttribute("name", name);
// 		} 

// 		name = (String)sess.getAttribute("name");

// 		model.addAttribute("name", name.toUpperCase());

// 		return "search";
// 	}

// 	private boolean isNull(String s) {
// 		return ((null == s) || (s.trim().length() <= 0));
// 	}
// }