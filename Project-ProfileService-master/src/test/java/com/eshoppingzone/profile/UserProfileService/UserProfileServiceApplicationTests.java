package com.eshoppingzone.profile.UserProfileService;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.eshoppingzone.profile.UserProfileService.pojo.Address;
import com.eshoppingzone.profile.UserProfileService.pojo.UserProfile;
import com.eshoppingzone.profile.UserProfileService.resource.ProfileResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserProfileServiceApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(get("/profiles")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	
	@Test
	public void testPut()
    {
    	Address address=new Address(404,
    			"sector 11",
    			"airoli",
    			"mumbai",
    			"maharashtra",
    			4000);
    	
    	List<Address> address1 = new ArrayList<Address>();
    	address1.add(address);
    	
    			
    	UserProfile profile1 = new UserProfile(	112,
    			"ramesh",
    			"url",
    			"ramesh@gmail.com",
    			"987",
    			address1,
    			"xyz",
    			LocalDate.now(),
    		"m",
    			"customer");
    	
    	ProfileResource resource = new ProfileResource();
    	resource.updateProfile(profile1);
    }	
	
	
}

