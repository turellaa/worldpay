package com.wkp.offer;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class AbstractRestApiTest {


	/**
	 * java comment for field or 
	 * getter 
	 * setter  
	 */
	@Autowired
	private WebApplicationContext ctx;

	
	
	/**
	 * java comment for field or 
	 * getter 
	 * setter  
	 */
	protected MockMvc mockMvc;

	/**
	 * setUp
	 */
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	
	
	/**
	 * @param url
	 * @return result
	 * @throws <em>java.lang.Exception</em>
	 */
	protected ResultActions getResults(MockHttpServletRequestBuilder url) throws Exception {
    	ResultActions result = mockMvc.perform(url
				.accept(MediaType.APPLICATION_JSON));
        result.andDo(print());
        return result;
    }
	
}
