package com.lifeisquest.controller;

import com.lifeisquest.SpringBootPracticeApplicationTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.EnvironmentTestUtils;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Jason Park
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootPracticeApplicationTest.class)
@WebAppConfiguration
//@IntegrationTest("spring.profiles.active=prod")
public class AppControllerTest {

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  private final StandardEnvironment environment = new StandardEnvironment();

  RestTemplate template = new TestRestTemplate();

  @Rule
  public OutputCapture capture = new OutputCapture();

  @Rule
  public ExpectedException expected = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
    EnvironmentTestUtils.addEnvironment(this.environment, "spring.profiles.active=prod");
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void getTestEnv() throws Exception {
    System.out.println(environment.getActiveProfiles()[0]);
  }

  @Test
  public void testName() throws Exception {
    System.out.println("Hello World!");
    assertThat(capture.toString(), containsString("World"));
  }

  @Test
  public void getAppName() throws Exception {
    this.mockMvc.perform(get("/api/app/name").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print());
  }

  @Test
  public void getAppUrl() throws Exception {
    this.mockMvc.perform(get("/api/app/url").accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(jsonPath("$.data").value(notNullValue()));
  }

  @Test
  public void testRequest() throws Exception {
    HttpHeaders headers = template.getForEntity("http://www.naver.com", String.class).getHeaders();
    System.out.println(headers);
//    assertThat(headers.getLocation().toString(), containsString("myotherhost"));
  }
}