package com.lasilveira.passwordvalidationapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lasilveira.passwordvalidationapi.controller.PasswordValidationRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class PasswordValidationApiIntegrationTests {

    @Autowired
    protected WebApplicationContext context;
	
	private ObjectMapper mapper;
    private MockMvc mockMvc;
    private PasswordValidationRequest request;
    
    private static final String password_url = "/v1/password";
    
    @Before
    public void setup() {
    	mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mockMvc = webAppContextSetup(context).build();
        request = new PasswordValidationRequest();
    }
    
    @Test
    public void contextLoad() {
		assertNotNull(mockMvc);
		assertNotNull(context);
		assertNotNull(mapper);
	}
    
    @Test
    public void shouldReturnInvalidWhenPasswordHasBlankSpace() throws Exception {
        request.setPassword("abc ");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
    
    @Test
    public void shouldReturnInvalidWhenPasswordEmpty() throws Exception {
        request.setPassword("");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
    
    @Test
    public void shouldReturnInvalidWhenPasswordHasLessThanNineChars() throws Exception {
        request.setPassword("12345678");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
    
    @Test
    public void shouldReturnInvalidWhenPasswordHasNoDigit() throws Exception {
        request.setPassword("abcdefghi");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
    
    @Test
    public void shouldReturnInvalidWhenPasswordHasNoUppercase() throws Exception {
        request.setPassword("abcdefg123");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
    
    @Test
    public void shouldReturnInvalidWhenPasswordHasNoLowercase() throws Exception {
        request.setPassword("ABCDEFGHI123");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
    
    @Test
    public void shouldReturnInvalidWhenPasswordHasNoSpecialChar() throws Exception {
        request.setPassword("ABCdefGHI123");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }
    
    @Test
    public void shouldReturnInvalidWhenPasswordHasRepeatedChars() throws Exception {
        request.setPassword("ABCdeffGHI123@");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }

    @Test
    public void shouldReturnValidWhenPasswordMeetsRules() throws Exception {
        request.setPassword("ABCdefGHI123@");
        
        final MockHttpServletRequestBuilder postBuilder = MockMvcRequestBuilders.post(password_url);

        mockMvc.perform(postBuilder.contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true));
    }
    
}
