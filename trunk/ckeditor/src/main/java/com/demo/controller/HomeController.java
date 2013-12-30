package com.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/ckeditor")
	public String ckeditor(HttpServletRequest request,	HttpServletResponse response) {
		if (request.getMethod().equalsIgnoreCase("post")) {
			try {
				response.getWriter().write(request.getParameter("editor1"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "ckeditor";
	}

	@RequestMapping("/browser")
	public String ckeditorFileBrowseUrl() {
		return "ckeditorFileBrowseUrl";
	}

	@RequestMapping("/upload")
	public String upload(Model model) {
		model.addAttribute("imageUpload", "http://t2.gstatic.com/images?q=tbn:ANd9GcTiscMfxBPE7N9GsQwwIfE4EMc-TMObxph5aM2RtaXTr093fjHefg");
		return "upload";
	}

	@RequestMapping("/fk")
	public String fkeditor() {
		return "fkeditor";
	}
}
