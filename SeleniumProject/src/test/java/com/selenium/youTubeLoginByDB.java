package com.selenium;

import org.testng.annotations.Test;

import com.dbconnection.getDBValues;

public class youTubeLoginByDB extends getDBValues{
	
	@Test(dataProvider="DP")
	public void validateLogin(String uName, String pWord) {
		
		System.out.println("DB Values:" + uName);
		System.out.println("DB Values:" + pWord);
		
	}

}
