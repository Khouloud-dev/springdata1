package com.sip.springdata1.controllers;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.springdata1.entities.Provider;
import com.sip.springdata1.repository.ProviderRepository;


@Controller
@RequestMapping("/provider/")
public class ProviderController {

   private final ProviderRepository providerRepository ;

   @Autowired
   public ProviderController(ProviderRepository providerRepository) {
	super();
	this.providerRepository = providerRepository;
}
   
	@GetMapping("list")
	public String listProviders(Model model) {
		model.addAttribute("providers",this.providerRepository.findAll());
		return "provider/listProviders";
	}
	
	@GetMapping("add")
	public String addproviderget(Model model) {
		Provider provider = new Provider();
		model.addAttribute("provider",provider);
		return"provider/addProvider";
	}
	
	@PostMapping("add")
	public String addproviderpost(Model model,@Valid Provider provider,BindingResult result) {
		if(result.hasErrors()) {
			return"provider/addProvider";
		}
		providerRepository.save(provider);
		return"redirect:/provider/list";
	}
	
	
	@GetMapping("update/{id}")
	public String updateproviderget(Model model,@PathVariable("id") long id) {
		Provider provider = providerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalidprovider Id:" + id));
		model.addAttribute("provider",provider);
		return"provider/updateProvider";
	}
	
	@PostMapping("update")
	public String updateproviderpost(Model model,@Valid Provider provider,BindingResult result) {
		
		providerRepository.save(provider);
		return"redirect:list";
	}
	
	@GetMapping("delete/{id}")
	public String deleteproviderget(Model model,@PathVariable("id") long id) {
		Provider provider = providerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalidprovider Id:" + id));
		providerRepository.delete(provider);
		return"redirect:../list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
