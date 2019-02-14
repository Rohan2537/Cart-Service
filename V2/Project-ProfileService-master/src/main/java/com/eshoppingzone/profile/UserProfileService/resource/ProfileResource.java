package com.eshoppingzone.profile.UserProfileService.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.profile.UserProfileService.pojo.UserProfile;
import com.eshoppingzone.profile.UserProfileService.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileResource {
	@Autowired
	private ProfileService service;
	
	@PostMapping("/customers")
	public void addNewCustomerProfile(@RequestBody UserProfile profile)
	{
		UserProfile profile1 = service.addNewCustomerProfile(profile);
		profile1.getProfileId();
	}
	
	@PostMapping("/merchants")
	public void addNewMerchantProfile(@RequestBody UserProfile profile)
	{
		 service.addNewMerchantProfile(profile);
	}
	
	@PostMapping("/deliveryagents")
	public void addNewdeliveryProfile(@RequestBody UserProfile profile)
	{
		 service.addNewdeliveryProfile(profile);
	}
	
	@GetMapping
	public List<UserProfile> getAllProfiles()
	{
		return service.getAllProfiles();
	}
	
	@GetMapping("/{profileId}")
	public UserProfile getByProfileId(@PathVariable int profileId)
	{
		return service.getByProfileId(profileId);
	}
	
	@PutMapping
	public void updateProfile(@RequestBody UserProfile userProfile)
	{
		 service.updateProfile(userProfile);
	}
	
	@DeleteMapping("/{profileId}")
	public void deleteProfile(@PathVariable int profileId)
	{
		 service.deleteProfile(profileId);
	}
}
