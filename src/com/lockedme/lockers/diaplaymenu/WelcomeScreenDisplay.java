package com.lockedme.lockers.diaplaymenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.lockedme.lockers.services.DirectoryService;
import com.lockedme.lockers.services.ScreenService;


public class WelcomeScreenDisplay implements Screen{

		private String welcomeMessage = "Welcome to com.lockedme.lockers Co. Ltd!";
		private String developerName = "Developer: Pratima";

		private ArrayList<String> options = new ArrayList<>();
		 
		public WelcomeScreenDisplay() {
			        options.add("[1]. Press 1 to List All Files in Directory");
			        options.add("[2]. Press 2 to Show File Operations(Add, Delete, Search) SubMenu");
			        options.add("[3]. Press 3 to Close Program \n");
				}
		
		//Welcome Message 
		public void displayMessage() {
	    	System.out.println(welcomeMessage);
	        System.out.println(developerName);
	        show();
	    }
		
		//Display Main Menu
		@Override
	    public void show() {
	    	System.out.println("\nSelect Main Menu");
	        for (String s : options)  {
	            System.out.println(s);
	        }
	    }
	    
		@Override
	    public void getUserInput() {
	        int providedinputOption  = 0;
	        
	        while ((providedinputOption = this.getOption()) != 3) {
	            this.navigateOption(providedinputOption);
	        }
	        
	        
	        terminateProg();
	    }
	    
	    
	    private void terminateProg() {
			// TODO Auto-generated method stub
	    	System.out.println("\nYou Pressed 3. The Program is terminated. \nThank you for using our Services.");

			
		}

		private int getOption() {
	    	int returnOption = 0;
	    	//Scanner Object
	    	try {
	    		Scanner sc = new Scanner(System.in);	         
	             returnOption = sc.nextInt();
	         } catch (InputMismatchException ex) {
	        	 System.out.println("Please enter valid input");
	         }
	         return returnOption;
	    }
	    
	    @Override
	    public void navigateOption(int providedinputOption) {
	        switch(providedinputOption) {

	        	// Show Files in Directory
	            case 1: 
	                this.ListFiles();	
	                this.show();	                
	                break;
	             
	            // Show File Options menu
	            case 2: 
	            	 ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
	                 ScreenService.getCurrentScreen().show();
	                 ScreenService.getCurrentScreen().getUserInput();
	            	
	                this.show();	                
	                break;
	                
	            default:
	                System.out.println("Invalid Option");
	                break;
	        }
	        
	    }
	    
	    public void ListFiles() {

	        //Get the files from the Directory and Display List of Files
	        System.out.println("\nList of Files: ");
	        System.out.println("=============== ");
	    	DirectoryService.PrintFiles();

	    }

}
