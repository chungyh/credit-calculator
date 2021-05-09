package com.creditsvc.calculator.model;

import java.awt.Rectangle;
import java.io.Serializable;

public class CalculatorFactory  {


	public Calculator getCalculator(String type) {
		
		 if(type == null){
	         return null;
	      }        
	      if(type.equalsIgnoreCase("NoOfEmployee")){
	         return new EmployeeNoCalculator();
	      } else if(type.equalsIgnoreCase("CompanyType")){
	         return new CompanyTypeCalculator();
	      } else if(type.equalsIgnoreCase("NoOfYrOperated")){
	         return new OpYrCalculator();
	      }
	      return null;
	}

}
