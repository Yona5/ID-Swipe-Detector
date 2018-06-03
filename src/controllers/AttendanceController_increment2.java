package controllers;

import helpers.InputHelper;
import repositories.Repository;
import model.Swipe;
import model.VisitorSwipe;

/**
 *
 * @author mga
 */
public class AttendanceController_increment2{
    private final Repository repository;
    
    /**
     *
     */
        
    public AttendanceController_increment2() {
        InputHelper inputHelper = new InputHelper();
        char ans = inputHelper.readCharacter("Load swipes from file? Y/N ");
        if(Character.toUpperCase(ans)== 'Y'){
            String filename = inputHelper.readString("Type file name");
            this.repository = new Repository(filename);
            System.out.println("File successfully loaded");
        }
        else this.repository = new Repository();
    }
   
    /**
     *
     */
    public void run() {
        boolean finished = false;
        
        do {
            char choice = displayAttendanceMenu();
            switch (choice) {
                case 'A': 
                    addSwipe();
                    break;
                case 'B':  
                    listSwipes();
                    break;
                case 'C': 
                    listSwipesByCardIdOrderedByDateTime(); // 
                    break;                    
                case 'D': 
                    listSwipeStatistics(); //
                    break;
                case 'Q': 
                    finished = true;
            }
        } while (!finished);
    }
    
    private char displayAttendanceMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Swipe");
        System.out.print("\tB. List Swipes");        
        System.out.print("\tC. List Swipes In Date Time Order");
        System.out.print("\tD. List Swipes Which Match Card Id");       
        System.out.print("\tQ. Quit\n");         
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
    }    
    /**
     *add a swipe into the repository
     */
    private void addSwipe() {
        System.out.format("\033[31m%s\033[0m%n", "Add Swipe");
        System.out.format("\033[31m%s\033[0m%n", "=========");
        InputHelper inputHelper = new InputHelper();
        boolean finished = false;
        do{
            char ans = inputHelper.readCharacter("Are you a visitor? Y/N");
            switch(Character.toUpperCase(ans)){
                case 'Y':
                    String visitorName = inputHelper.readString("Type your name");
                    String visitorRoom = inputHelper.readString("Type room name");
                    String visitorCardId = inputHelper.readString("Type your card ID");
                    String visitorCompanyName = inputHelper.readString("Type your company name");
                    VisitorSwipe visitorSwipe = new VisitorSwipe();
                    visitorSwipe.setCardId(visitorCardId);
                    visitorSwipe.setRoom(visitorRoom);
                    visitorSwipe.setVisitorCompany(visitorCompanyName);
                    visitorSwipe.setVisitorName(visitorName);
                    repository.add(visitorSwipe);
                    finished = true;
                    break;
                case 'N':
                    String room = inputHelper.readString("Type room name");
                    String cardId = inputHelper.readString("Type your card ID");
                    repository.add(new Swipe(cardId,room));
                    finished = true;
                    break;
            }
        }while(!finished);
    }
    /**
     * list swipes found in the repository 
     */
    private void listSwipes() {        
        System.out.format("\033[31m%s\033[0m%n", "Swipes");
        System.out.format("\033[31m%s\033[0m%n", "======");
        repository.getItems().forEach(item ->{
            System.out.println(item);
        });
    }      
 
    /**
     * list swipes by date for a specific id
     */
    private void listSwipesByCardIdOrderedByDateTime() {        
        System.out.format("\033[31m%s\033[0m%n", "Swipes By Card Id");
        System.out.format("\033[31m%s\033[0m%n", "=================");
        
    }    
    /**
     * list swipe statistics for a particular room
     */
    private void listSwipeStatistics() {
        System.out.format("\033[31m%s\033[0m%n", "Swipe Statistics for room");
        System.out.format("\033[31m%s\033[0m%n", "========================="); 
        
    }
}
