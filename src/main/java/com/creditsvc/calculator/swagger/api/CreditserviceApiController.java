package com.creditsvc.calculator.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditsvc.calculator.bizsvc.ScoreCalculatorBizSvcImpl;
import com.creditsvc.calculator.swagger.model.ApplicationException;
import com.creditsvc.calculator.swagger.model.CalculatorRequest;
import com.creditsvc.calculator.swagger.model.CalculatorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-02T18:59:50.045Z[GMT]")
@RestController
@RequestMapping(value = "/creditservice/v1")
public class CreditserviceApiController implements CreditserviceApi {

    private static final Logger log = LoggerFactory.getLogger(CreditserviceApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ScoreCalculatorBizSvcImpl scoreCalculatorBizSvcImpl; 
    
    @org.springframework.beans.factory.annotation.Autowired
    public CreditserviceApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CalculatorResponse> retrieveScore(@Parameter(in = ParameterIn.DEFAULT, description = "Retrieve a credit assessment score", required=true, schema=@Schema()) @Valid @RequestBody CalculatorRequest body) {
        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
            try {
            	scoreCalculatorBizSvcImpl.retrieveScore(body);
                //return new ResponseEntity<List<CalculatorResponse>>(objectMapper.readValue("[ {\n  \"creditScore\" : 0\n}, {\n  \"creditScore\" : 0\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                return new ResponseEntity<CalculatorResponse>(scoreCalculatorBizSvcImpl.retrieveScore(body), HttpStatus.OK);
            } catch (ApplicationException e) {
            	log.error("ApplicationException", e);
            	return new ResponseEntity<CalculatorResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
 //       }

        //return new ResponseEntity<CalculatorResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
