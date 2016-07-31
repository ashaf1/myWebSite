package com.aaronshafron.mysite.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aaronshafron.mysite.model.DataDAO;
import com.aaronshafron.mysite.model.JDBCDataDAO;
import com.aaronshafron.mysite.model.MarketData;

@Controller

public class WebsiteController {
	
	private JDBCDataDAO jdbcDataDAO;
	
	@Autowired
	public WebsiteController(JDBCDataDAO jdbcDataDAO){
		this.jdbcDataDAO = jdbcDataDAO;
	}

	@RequestMapping({"/", "/home"})
	public String showHomePage(){
		return "home";
	}
	@RequestMapping("/aboutMe")
	public String showAboutMePage(){
		return "aboutMe";
	}
	@RequestMapping("/favoriteThings")
	public String showFavoriteThingsPage(){
		return "favoriteThings";
	}
	
	@RequestMapping(path="/funWithStocks", method= RequestMethod.GET)
	public String showFunWithStocksPage(ModelMap model, @RequestParam (required=false) String databaseName1, @RequestParam (required= false) String databaseName2, 
										@RequestParam (required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate begin,
										@RequestParam (required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
		MarketData data = null;
		if(databaseName1 != null && databaseName2 == null){
		data = jdbcDataDAO.getDataByDateRangeAndDB(begin, end, databaseName1);
		} else if(databaseName1 !=null && databaseName2 != null) {
		data = jdbcDataDAO.getDataByDateRangeAndTwoDBNames(begin, end, databaseName1, databaseName2);
		}
		model.addAttribute("data", data);
		return "funWithStocks";
	}
	@RequestMapping(path="/funWithStocks", method= RequestMethod.POST)
	public String redirectFunWithStocksPage(@RequestParam ("databaseName1") String databaseName1, @RequestParam ("databaseName2") String databaseName2, 
											@RequestParam ("begin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate begin, 
											@RequestParam ("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end, 
											RedirectAttributes redirectAttributes){
		redirectAttributes.addAttribute("begin", begin);
		redirectAttributes.addAttribute("end", end);
		redirectAttributes.addAttribute("databaseName1", databaseName1);
		redirectAttributes.addAttribute("databaseName2", databaseName2);
		return "redirect:/funWithStocks";
	}
	@RequestMapping("contact")
	public String showContactPage(){
		return "contact";
	}
}
