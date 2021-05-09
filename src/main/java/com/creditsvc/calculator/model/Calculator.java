package com.creditsvc.calculator.model;

import java.util.HashMap;
import java.util.Map;

public class Calculator<T> {

	private Map<String, Integer> scoreMap = new HashMap<String, Integer>();
	

	public void setScoreMap(String[] rangeAry, String[] scoreAry) {

		Map<String, Integer> scoreMap = new HashMap<String, Integer>();
		;
		for (int n = 0; n < rangeAry.length; n++) {
			scoreMap.put(rangeAry[n], Integer.parseInt(scoreAry[n]));
		}
		this.scoreMap = scoreMap;
	}


	public int calculateNumericScore(int param) {
		int score = 0;
		int num = param;
		for (String key : this.scoreMap.keySet()) {
			int min = Integer.parseInt(key.split("-")[0]);
			int max = Integer.parseInt(key.split("-")[1]);
			if (num >= min && num <= max) {
				score = this.scoreMap.get(key);
			}

		}
		return score;
	}
	
	public int calculateTypeScore(String param) {
		int score = 0;
		String type = param;
		for (String key : this.scoreMap.keySet()) {
			if (key.equalsIgnoreCase(type)) {
				score = this.scoreMap.get(key);
			}
		}
		return score;
	}
}
