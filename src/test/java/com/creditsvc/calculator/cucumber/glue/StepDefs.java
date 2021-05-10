package com.creditsvc.calculator.cucumber.glue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.creditsvc.calculator.swagger.model.CalculatorRequest;
import com.creditsvc.calculator.swagger.model.CalculatorRequest.CompanyTypeEnum;
import com.creditsvc.calculator.swagger.model.CalculatorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, tags = "", features = "src/test/resources/Feature")
public class StepDefs {
	
	private static final Logger logger = LoggerFactory.getLogger(StepDefs.class);
	@Autowired
	private TestRestTemplate testRestTemplate;
	@Autowired
	private ObjectMapper objectMapper;
	CalculatorRequest request = new CalculatorRequest();
	Integer creditScore;
	
	@Test
	@When("The calculateCreditAssessmentScore API is called with {int}, {string}, {int} parameters")
	public void the_calculate_credit_assessment_score_api_is_called_with_parameters(Integer int1, String string, Integer int2) {
		try {
			logger.info("ENTER STEP 1 : "+ int1+","+string+","+int2);
			request.setNumberOfEmployees(int1);
			request.setCompanyType(CompanyTypeEnum.fromValue(string));
			request.setNumberOfYearsOperated(int2);			
			logger.info("RESQUEST: "+request.toString());
			ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/creditservice/v1/calculator", request, String.class);
			CalculatorResponse response = objectMapper.readValue(responseEntity.getBody(), CalculatorResponse.class);
			 creditScore = response.getCreditScore();
			logger.info("STEP 1 - Done " + response.toString());
		} catch ( Exception e) {
			logger.error("Exception : "+e);
		}
	}
	
	@Test
	@Then("The credit assessment score should match {int}")
	public void the_credit_assessment_score_should_match(Integer int1) {
			logger.info("ENTER STEP 2 : "+ int1);
			Assert.assertEquals(creditScore, int1);
			logger.info("STEP 2 - DONE ");
	}


}
