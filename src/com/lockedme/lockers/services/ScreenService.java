package com.lockedme.lockers.services;

import com.lockedme.lockers.diaplaymenu.WelcomeScreenDisplay;
import com.lockedme.lockers.diaplaymenu.FileOptionsScreen;
import com.lockedme.lockers.diaplaymenu.Screen;

public class ScreenService {
	public static WelcomeScreenDisplay welcomeScreenDisplay = new WelcomeScreenDisplay();
    public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();    
    

    public static Screen CurrentScreen = welcomeScreenDisplay;

    
    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }

}
