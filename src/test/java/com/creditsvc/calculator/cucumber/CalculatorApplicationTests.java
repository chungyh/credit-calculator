package com.creditsvc.calculator.cucumber;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.creditsvc.calculator.Swagger2SpringBoot;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {Swagger2SpringBoot.class , CalculatorApplicationTests.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@CucumberOptions(plugin = {"pretty"}, tags = "", features = "src/test/resources/Feature")
class CalculatorApplicationTests {


}
