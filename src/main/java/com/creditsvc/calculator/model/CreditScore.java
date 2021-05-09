package com.creditsvc.calculator.model;

import java.io.Serializable;

public class CreditScore implements Serializable{

	private static final long serialVersionUID = 1L;

	private int numOfEmplScore;
	private int compTypeScore;
	private int numOfYrOpScore;
	private int score;
	
	
	public int getNumOfEmplScore() {
		return numOfEmplScore;
	}

	public void setNumOfEmplScore(int numOfEmplScore) {
		this.numOfEmplScore = numOfEmplScore;
	}

	public int getCompTypeScore() {
		return compTypeScore;
	}

	public void setCompTypeScore(int compTypeScore) {
		this.compTypeScore = compTypeScore;
	}

	public int getNumOfYrOpScore() {
		return numOfYrOpScore;
	}

	public void setNumOfYrOpScore(int numOfYrOpScore) {
		this.numOfYrOpScore = numOfYrOpScore;
	}
	
	public int getCreditScore() {
		return this.score;
	}
	
	public void calculateCreditScore() {
		this.score = numOfEmplScore+compTypeScore+numOfYrOpScore;
	}	
	
}
