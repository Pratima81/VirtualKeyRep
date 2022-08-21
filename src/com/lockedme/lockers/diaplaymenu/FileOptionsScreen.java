package com.lockedme.lockers.diaplaymenu;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.lockedme.lockers.entities.Directory;


public class FileOptionsScreen implements Screen{
	
	private Directory dir = new Directory();
	
	private ArrayList<String> options = new ArrayList<>();

    public FileOptionsScreen() {
    	
    	options.add("[1]. Press 1 to Add a File");
        options.add("[2]. Press 2 to Delete a File");
        options.add("[3]. Press 3 to Search a File");
        options.add("[4]. Press 4 to Return to Main Menu");
        
    }
    
    @Override
    public void show() {
    	System.out.println("\nFile Operations/SubMenu Options");
        for (String s : options) {
            System.out.println(s);
        }
        System.out.println();
    }

    @Override
    public void getUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.navigateOption(selectedOption);
        }
    }

    @Override
    public void navigateOption(int option) {
        
    	switch(option) {
    		
    		// Add File
            case 1: 
                this.AddFile();
                
                this.show();
                break;
            
            // Delete File
            case 2: 
                this.DeleteFile();
                
                this.show();
                break;
                
            // Search File  
            case 3: 
                this.SearchFile();
                
                this.show();
                break;
            
            default:
                System.out.println("Invalid Option");
                break;                
                
        }

    }
    
    //Add File Utility

    public void AddFile() {
        System.out.println("\nPlease Enter the Filename:");

        String fileName = this.getInputString();
  
		try {
		
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("["+file.getName()+"] File created Successfully ");
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("This File Already Exits, Duplicate Not allowed");
		      }
		      
		      
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    //Delete File Utility
    
    public void DeleteFile() {
    	
    	System.out.println("Please Enter the Filename that you want to Delete:");

        String fileName = this.getInputString();
        
		Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
		
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("["+file.getName()+"]"+" File Deleted Successfully" );
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("Failed to delete file." + " ["+fileName +"] "+ "file was not found.");
	      }
    }
    
    //Search File Utility
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("Please Enter the Filename You want to Search:");

        String fileName = this.getInputString();
        
        //ArrayList obtains files
        
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equalsIgnoreCase(fileName)) {
				
				System.out.println("["+fileName+ "] File Found in Directory");
				found = true;
				
			}
        }
        if (found == false) {
        	System.out.println("File not found in Directory");
        }
    }
    
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("Invalid input");
        }
        return returnOption;

    }

	
}
