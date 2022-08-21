package com.lockedme.lockers;

import com.lockedme.lockers.diaplaymenu.WelcomeScreenDisplay;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WelcomeScreenDisplay welcomeScreenDisplay = new WelcomeScreenDisplay();
		welcomeScreenDisplay.displayMessage();
		welcomeScreenDisplay.getUserInput();

	}

}
