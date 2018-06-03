package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.lang.NullPointerException;


/**
 *
 * 
 */
public class Swipe1 implements Comparable<Swipe1>{

    /**
     * swipe id
     */
    protected final int id;

    /**
     *swipe  card id
     */
    protected String cardId;

    /**
     *swipe room
     */
    protected String room;

    /**
     *swipe date 
     */
    protected final Calendar swipeDateTime;
    
    private static int lastSwipeIdUsed = 0;
    static final char EOLN='\n';       
    static final String QUOTE="\"";    
    
    /**
     *swipe constructor
     */
    public Swipe1() {
        this.id = ++lastSwipeIdUsed;
        this.cardId = "Unknown";
        this.room = "Unknown";
        this.swipeDateTime = getNow();
    }
    
    /**
     *
     * @param cardId
     * @param room
     */
    public Swipe1(String cardId, String room) {
        this.id = ++lastSwipeIdUsed;
        this.cardId = cardId;
        this.room = room;        
        this.swipeDateTime = getNow();
    }    
    
    /**
     *
     * @param swipeId
     * @param cardId
     * @param room
     * @param swipeDateTime
     */
    public Swipe1(int swipeId, String cardId, String room, Calendar swipeDateTime) {
        this.id = swipeId;
        this.cardId = cardId;
        this.room = room;
        this.swipeDateTime = swipeDateTime;
        if (swipeId > Swipe1.lastSwipeIdUsed)
            Swipe1.lastSwipeIdUsed = swipeId;          
    }     
    
    private Calendar getNow() {
        Calendar now = Calendar.getInstance();  
        return now;
    }    

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }
    /**
     * @return the card id
     */
    public String getCardId(){
        return this.cardId;
    }
    /**
     * @param cardId 
     */
    public void setCardId(String cardId){
        this.cardId = cardId;
    }
    /**
     * @return swipe room
     */
    public String getRoom(){
        return this.room;
    }
    /**
     * @param room
     */
    public void setRoom(String room){
        this.room = room;
    }
    /**
     * @return the calendar date 
     */
    public Calendar getSwipeDateTime(){
        return this.swipeDateTime;
    }
    /**
     * @return string
     * @param delimiter
     */
    public String toString(char delimiter){
        return "\n" + this.id + delimiter + this.cardId + delimiter +          
                this.room + delimiter + formatSwipeDateTime(this.swipeDateTime);
    }

    @Override
    /**
     * @return hash 
     */
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.cardId);
        hash = 89 * hash + Objects.hashCode(this.room);
        hash = 89 * hash + Objects.hashCode(this.swipeDateTime);
        return hash;
    }
    /**
     * @return boolean
     * @param o 
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Swipe1 other = (Swipe1) o;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cardId, other.cardId)) {
            return false;
        }
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        if (!Objects.equals(this.swipeDateTime, other.swipeDateTime)) {
            return false;
        }
        return true;
    }
    /**
     * @return integer 
     * @param compareSwipe
     */
    @Override
    public int compareTo(Swipe1 compareSwipe){
        int value = 0;
        try{
            if(getId() < compareSwipe.getId()){
                value = -1;
            }
            else if (getId() > compareSwipe.getId()){
                value = 1;
            }
            else{
                value = 0;
            }
        }
        catch(NullPointerException ex){
            System.out.println(ex);
        }
        return value;
    }
    
    // Methods required: getters, setters, hashCode, equals, compareTo, comparator
    
    /**
     *
     * @param calendar
     * @return string 
     */
        
    public static String formatSwipeDateTime(Calendar calendar) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar now = Calendar.getInstance();  
        return dateFormat.format(calendar.getTime());
    }    

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nSwipe Id: " + this.id + " - Card Id: " + this.cardId +            
                " - Room: " + this.room + " - Swiped: " + formatSwipeDateTime(this.swipeDateTime);
    }
    
}
