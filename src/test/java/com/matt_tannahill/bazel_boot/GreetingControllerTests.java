package com.matt_tannahill.bazel_boot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTests {

	@Autowired
	MockMvc mvc;

	@Test
	void getGreeting() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greeting"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello, 世界!")));
	}
}