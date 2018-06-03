package model;

import java.util.Calendar;

/**
 *
 * @author mga
 */
public class VisitorSwipe extends Swipe {
    
    static final char EOLN='\n';       
    static final String QUOTE="\"";
    
    /**
     *Visitor name
     */
    protected String visitorName;

    /**
     *visitor company
     */
    protected String visitorCompany;

    /**
     *constructor
     */
    public VisitorSwipe() {
        super();
        this.visitorName = "Unknown";
        this.visitorCompany = "Unknown";        
    }

    /**
     *
     * @param cardId
     * @param room
     * @param visitorName
     * @param visitorCompany
     */
    public VisitorSwipe(String cardId, String room, String visitorName, String visitorCompany) {
        super(cardId, room);
        this.visitorName = visitorName;
        this.visitorCompany = visitorCompany;
    }

    /**
     *
     * @param swipeId
     * @param cardId
     * @param room
     * @param swipeDateTime
     * @param visitorName
     * @param visitorCompany
     */
    public VisitorSwipe(int swipeId, String cardId, String room, Calendar swipeDateTime, String visitorName, String visitorCompany) {
        super(swipeId, cardId, room, swipeDateTime);
        this.visitorName = visitorName;
        this.visitorCompany = visitorCompany;
    }
    
    // Methods required: getters, setters 
    /**
     * @return visitor name
     */
    public String getVisitorName(){
        return this.visitorName;
    }
    /**
     * @param visitorName
     */
    public void setVisitorName(String visitorName){
        this.visitorName = visitorName;
    }
    /**
     * @return visitor company
     */
    public String getVisitorCompany(){
        return this.visitorCompany;
    }
    /**
     * @param visitorCompany
     */
    public void setVisitorCompany(String visitorCompany){
        this.visitorCompany = visitorCompany;
    }
    /**
     * @return string 
     * @param delimiter
     */
    @Override 
    public String toString(char delimiter) {
        return super.toString(',') + delimiter + "\n" + this.visitorName + delimiter + this.visitorCompany;
    } 
    /**
     * @return string
     */
    @Override
    public String toString() {
        return super.toString() + "\nName: " + this.visitorName +  " - Company: " + this.visitorCompany;
    }
}
