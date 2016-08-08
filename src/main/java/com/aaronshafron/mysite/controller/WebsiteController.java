package com.aaronshafron.mysite.controller;

import java.time.LocalDate;
import java.sql.Date;

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

	@RequestMapping("/favoriteThings")
	public String showFavoriteThingsPage(){
		return "favoriteThings";
	}
	
	@RequestMapping(path="/funWithStocks", method= RequestMethod.GET)
	public String showFunWithStocksPage(ModelMap model, @RequestParam (value ="stockName1",required=false) String stockName1, 
										@RequestParam (value="stockName2",required= false) String stockName2, 
										@RequestParam (value="begin",required=false) Date begin,
										@RequestParam (value="end",required=false) Date end){
		MarketData data = null;
		if(stockName1 != null && stockName2 == null){
		data = jdbcDataDAO.getDataByDateRangeAndDB(begin, end, stockName1);
		} else if(stockName1 == null && stockName2 != null){
			data = jdbcDataDAO.getDataByDateRangeAndDB(begin, end, stockName2);
		}
		else if(stockName1 !=null && stockName2 != null) {
		data = jdbcDataDAO.getDataByDateRangeAndTwoDBNames(begin, end, stockName1, stockName2);
		} 
		model.addAttribute("data", data);
		return "funWithStocks";
	}
	@RequestMapping(path="/funWithStocks", method= RequestMethod.POST)
	public String redirectFunWithStocksPage(@RequestParam (value = "stockName1", required = false) String stockName1, @RequestParam (value = "stockName2", required = false) String stockName2, 
											@RequestParam ("begin") Date begin, 
											@RequestParam ("end") Date end, 
											RedirectAttributes redirectAttributes){
		redirectAttributes.addAttribute("begin", begin);
		redirectAttributes.addAttribute("end", end);
		redirectAttributes.addAttribute("stockName1", stockName1);
		redirectAttributes.addAttribute("stockName2", stockName2);
		return "redirect:/funWithStocks";
	}
	@RequestMapping("contact")
	public String showContactPage(){
		return "contact";
	}
}
