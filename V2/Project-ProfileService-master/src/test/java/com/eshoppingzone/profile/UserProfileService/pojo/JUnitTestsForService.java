package com.eshoppingzone.profile.UserProfileService.pojo;

import org.springframework.test.context.junit4.SpringRunner;

import com.eshoppingzone.profile.UserProfileService.repository.ProfileRepository;
import com.eshoppingzone.profile.UserProfileService.service.ProfileService;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JUnitTestsForService {


	    @Autowired
	    private ProfileService profileService;
	 
	    @MockBean
	    private ProfileRepository profileRepository;
    
	    
	    @Before
	    public void setUp() {
	    	Address address=new Address(404,
	    			"jp road",
	    			"airoli",
	    			"mumbai",
	    			"maharashtra",
	    			4000);
	    	
	    	List<Address> address1 = new ArrayList<Address>();
	    	address1.add(address);
	    	
	    	List<UserProfile> profilelist = new ArrayList<UserProfile>();
	    			
	    	UserProfile profile = new UserProfile(	112,
	    			"ramesh",
	    			"url",
	    			"ramesh@gmail.com",
	    			"987",
	    			address1,
	    			"xyz",
	    			LocalDate.now(),
	    		"m",
	    			"customer");
	     
	    	profilelist.add(profile);
	    	
	        Mockito.when(profileRepository.findAll())
	          .thenReturn(profilelist);
	   
	    }
	    
	    @Test
	    public void testForData() {
	      
	        List<UserProfile> found = profileService.getAllProfiles();
	      
	         assertThat(found.isEmpty())
	          .isEqualTo(false);
	     }
   
	    @Test
	    public void testNumberOfRecords() {
	      
	        List<UserProfile> found = profileService.getAllProfiles();
	      
	         assertThat(found.size())
	          .isEqualTo(1);
	     }
  
	@Test
	public void testValue()
	{
		List<UserProfile> found = profileService.getAllProfiles();
		assertThat(found.get(0).getFullName().equals("Ramesh"));
		assertThat(found.get(0).getProfileId()).isEqualTo(112);
	}
	
}
    
