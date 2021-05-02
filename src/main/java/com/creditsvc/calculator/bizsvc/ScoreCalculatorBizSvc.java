package com.creditsvc.calculator.bizsvc;

import com.creditsvc.calculator.swagger.model.ApplicationException;
import com.creditsvc.calculator.swagger.model.CalculatorRequest;
import com.creditsvc.calculator.swagger.model.CalculatorResponse;

public interface ScoreCalculatorBizSvc {
	
	public CalculatorResponse retrieveScore(CalculatorRequest calculatorRequest)
			throws ApplicationException;
}
