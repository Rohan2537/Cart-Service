package com.eshoppingzone.profile.UserProfileService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.junit4.SpringRunner;

import com.eshoppingzone.profile.UserProfileService.pojo.Address;
import com.eshoppingzone.profile.UserProfileService.pojo.UserProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUsingRest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Test
    public void testGetAPI() throws Exception {
        //arrange
 
        //act
        ResponseEntity<String> responseEntity= testRestTemplate.getForEntity("/profiles", String.class);
 
        //assert
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
    @Test
    public void testGetAPIThatDoesNotExist() throws Exception {
        //arrange
 
        //act
        ResponseEntity<String> responseEntity= testRestTemplate.getForEntity("/profile", String.class);
        
        //assert
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
    
    
    @Test
    public void testPostAPI()
    {
    	Address address=new Address(404,
    			"jp road",
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
    	
    	ResponseEntity<String> responseEntity= testRestTemplate.postForEntity("/profiles/customers", profile1,String.class);
    	assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
    @Test
    public void toCheckGetByProfileId() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/profiles/1", String.class);
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
    }

 
 
}
