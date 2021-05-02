package com.creditsvc.calculator.bizsvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.creditsvc.calculator.swagger.model.ApplicationException;
import com.creditsvc.calculator.swagger.model.CalculatorRequest;
import com.creditsvc.calculator.swagger.model.CalculatorRequest.CompanyTypeEnum;
import com.creditsvc.calculator.swagger.model.CalculatorResponse;

/**
 * This class is for business logic for deposits API. It includes get deposit
 * product list and get deposit product by product id
 *
 */

@Service
public class ScoreCalculatorBizSvcImpl implements ScoreCalculatorBizSvc {

	private static final Logger logger = LoggerFactory.getLogger(ScoreCalculatorBizSvcImpl.class);
	

	/**
	 * This method returns a list of deposit product information, retrieved records
	 * from database based on bank , language and productType, optional search
	 * criteria by customer type and currency code, and paging information based on
	 * the page request
	 * 
	 * @throws ApplicationException 
	 */

	@Override
	public CalculatorResponse retrieveScore(CalculatorRequest calculatorRequest)
			throws ApplicationException {
		logger.info("Enter retrieveScore");
		CalculatorResponse response = new CalculatorResponse();
		int employeeNum = calculatorRequest.getNumberOfEmployees();
		@NotNull CompanyTypeEnum companyType = calculatorRequest.getCompanyType();
		int opYrNum = calculatorRequest.getNumberOfYearsOperated();
		
		
		response.setCreditScore(10);
		
		return response;
		
	}



}
