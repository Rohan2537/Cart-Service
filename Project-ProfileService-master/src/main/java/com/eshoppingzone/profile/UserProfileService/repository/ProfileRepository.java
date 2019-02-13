package com.eshoppingzone.profile.UserProfileService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshoppingzone.profile.UserProfileService.pojo.UserProfile;

public interface ProfileRepository extends JpaRepository<UserProfile, Integer>{



	
}
