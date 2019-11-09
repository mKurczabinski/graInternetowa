package pl.wlochynski.controller;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdiGameController {
	
	@GET
	@RequestMapping(value = "/AdiGame")
	public String adiGame()
	{
		return "AdiGame";
	}
	
}
