package com.eshoppingzone.profile.UserProfileService.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testpojo {

	@Test
	public void test() {
		UserProfile userprofile = new UserProfile();
		userprofile.setFullName("ramesh"); 
		assertEquals("ramesh", userprofile.getFullName());
	}
	
}
