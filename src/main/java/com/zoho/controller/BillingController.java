package com.zoho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Billing;
import com.zoho.entities.Contacts;
import com.zoho.services.BillingService;
import com.zoho.services.ContactService;

@Controller
public class BillingController {

	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/billing")
	public String viewBillingForm(@RequestParam("id") long id,Model model) {
		Contacts contacts = contactService.findContactById(id);
		model.addAttribute("contact", contacts);
		return "create_billing";
	}
	@RequestMapping("/generateBill")
	public String generateBill(@ModelAttribute("billing") Billing billing,Model model) {
		billingService.generateInvoice(billing);
		List<Billing> billings = billingService.getBillings();
		model.addAttribute("billing", billings);
		return "billing_list";
	}
	//http://localhost:8080/billingList
	@RequestMapping("/billingList")
	public String listAllBilling(Model model) {
		List<Billing> billings = billingService.getBillings();
		model.addAttribute("billing", billings);
		return "billing_list";
	}
}
