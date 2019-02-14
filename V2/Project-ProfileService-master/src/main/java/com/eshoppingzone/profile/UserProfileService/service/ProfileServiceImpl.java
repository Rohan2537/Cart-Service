package com.eshoppingzone.profile.UserProfileService.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshoppingzone.profile.UserProfileService.pojo.Role;
import com.eshoppingzone.profile.UserProfileService.pojo.UserProfile;
import com.eshoppingzone.profile.UserProfileService.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository repository;
	
	@Override
	public UserProfile addNewCustomerProfile(UserProfile profile) {
		profile.setRole(Role.Customer);
		return repository.save(profile);
	}

	@Override
	public void addNewMerchantProfile(UserProfile profile) {
		profile.setRole(Role.Merchant);
		profile.setAddresses(null);
		repository.save(profile);
		
	}

	@Override
	public void addNewdeliveryProfile(UserProfile profile) {
		profile.setRole(Role.DeliveryAgent);
		profile.setAddresses(null);
		repository.save(profile);	
	}
	
	@Override
	public List<UserProfile> getAllProfiles() {
		
		return repository.findAll();
	}

	@Override
	public UserProfile getByProfileId(int profileId) {
		return repository.findById(profileId).get();
	}

	@Override
	public void updateProfile(UserProfile userProfile) {
		 repository.save(userProfile);
	}

	@Override
	public void deleteProfile(int profileId) {
		 repository.deleteById(profileId);;
	}

	
}
