package com.creditsvc.calculator.bizsvc;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.creditsvc.calculator.model.Calculator;
import com.creditsvc.calculator.model.CalculatorFactory;
import com.creditsvc.calculator.model.CreditScore;
import com.creditsvc.calculator.swagger.model.ApplicationException;
import com.creditsvc.calculator.swagger.model.CalculatorRequest;
import com.creditsvc.calculator.swagger.model.CalculatorRequest.CompanyTypeEnum;
import com.creditsvc.calculator.swagger.model.CalculatorResponse;

/**
 * 
 *
 */

@Service
public class ScoreCalculatorBizSvcImpl implements ScoreCalculatorBizSvc {

	private static final Logger logger = LoggerFactory.getLogger(ScoreCalculatorBizSvcImpl.class);

	@Autowired
	private Environment env;

	/**
	 * 
	 * 
	 * @throws ApplicationException
	 */

	@Override
	public CalculatorResponse retrieveScore(CalculatorRequest calculatorRequest) throws ApplicationException {
		logger.info("Enter retrieveScore");
		CalculatorResponse response = new CalculatorResponse();
		CalculatorFactory calFactory = new CalculatorFactory();
		CreditScore creditScore = new CreditScore();
		int employeeNum = calculatorRequest.getNumberOfEmployees();
		CompanyTypeEnum companyType = calculatorRequest.getCompanyType();
		int opYrNum = calculatorRequest.getNumberOfYearsOperated();
		
		if(employeeNum<=0 || opYrNum<0 || null == companyType) {
			throw new ApplicationException().addHttpStatusCode("400").errDesc("Invalid input");
		}

		// Getting score data from application.properties
		String numOfEmplRange = env.getProperty("creditsvc.calculator.numOfEmployee.range");
		String numOfEmplScore = env.getProperty("creditsvc.calculator.numOfEmployee.score");
		String opYrRange = env.getProperty("creditsvc.calculator.opYr.range");
		String opYrScore = env.getProperty("creditsvc.calculator.opYr.score");
		String comType = env.getProperty("creditsvc.calculator.companyType");
		String comTypeScore = env.getProperty("creditsvc.calculator.companyType.score");

		// Number of employee score calculation
		String numOfEmplRangeSplit[] = numOfEmplRange.split(",");
		String numOfEmplScoreSplit[] = numOfEmplScore.split(",");
		Calculator emplNoCalculator = calFactory.getCalculator("NoOfEmployee");
		emplNoCalculator.setScoreMap(numOfEmplRangeSplit, numOfEmplScoreSplit);
		creditScore.setNumOfEmplScore(emplNoCalculator.calculateNumericScore(employeeNum));
		logger.info("empl score: "+creditScore.getNumOfEmplScore());
		// Operation Year score calculation
		String opYrRangeSplit[] = opYrRange.split(",");
		String opYrcoreSplit[] = opYrScore.split(",");
		Calculator opYrCalculator = calFactory.getCalculator("NoOfYrOperated");
		opYrCalculator.setScoreMap(opYrRangeSplit, opYrcoreSplit);
		creditScore.setNumOfYrOpScore(opYrCalculator.calculateNumericScore(opYrNum));
		logger.info("num of yr score: "+creditScore.getNumOfYrOpScore());

		// Operation Year score calculation
		String comTypeSplit[] = comType.split(",");
		String comTypeScoreSplit[] = comTypeScore.split(",");
		logger.info("comType:"+companyType);
		Calculator comTypeCalculator = calFactory.getCalculator("CompanyType");
		comTypeCalculator.setScoreMap(comTypeSplit, comTypeScoreSplit);
		creditScore.setCompTypeScore(comTypeCalculator.calculateTypeScore(companyType.toString()));
		logger.info("com type score: "+creditScore.getCompTypeScore());

		creditScore.calculateCreditScore();
		creditScore.getCreditScore();

		response.setCreditScore(creditScore.getCreditScore());

		return response;

	}

}
