/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import static com.sun.javafx.util.Utils.stripQuotes;
import repositories.Repository;
import model.Swipe;
import model.VisitorSwipe;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.io.BufferedWriter;
import java.io.FileWriter;


/**
 *
 * @author thisPC
 */

public class DAOimpl implements DAOInterface {

    Repository repository = new Repository();
    
    @Override
    public Repository load(String filename){
        String [] tempSwipe = null;
        int id;
        String cardId, room, visitorName, visitorCompany;
      
        FileReader fileReader = null;
        BufferedReader reader = null;
        try{
            fileReader = new FileReader(filename);
            reader = new BufferedReader(fileReader);
            String line = "";
            while((line = reader.readLine()) != null){
                Calendar calendar = Calendar.getInstance();
                tempSwipe = line.split(",");
                if(tempSwipe.length == 4){ 
                    id = Integer.parseInt(stripQuotes(tempSwipe[0]));
                    cardId = stripQuotes(tempSwipe[1]);
                    room = stripQuotes(tempSwipe[2]);
                    try{
                        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(stripQuotes(tempSwipe[3]));
                        calendar.setTime(date);
                    }catch(ParseException ex){
                        System.out.print(ex);
                    }
                    repository.add(new Swipe(id, cardId, room, calendar));                    
                }
                if(tempSwipe.length == 6){

                    id = Integer.parseInt(stripQuotes(tempSwipe[0]));
                    cardId = stripQuotes(tempSwipe[1]);
                    room = stripQuotes(tempSwipe[2]);
                    try{
                        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(stripQuotes(tempSwipe[3]));
                        calendar.setTime(date);
                    }catch(ParseException ex){
                        System.out.print(ex);
                    }
                    visitorName = stripQuotes(tempSwipe[4]);
                    visitorCompany = stripQuotes(tempSwipe[5]);
                    repository.add(new VisitorSwipe(id, cardId, room, calendar,visitorName, visitorCompany));
                } 
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }finally{
            try{
                if(reader != null) reader.close();
                if(fileReader != null) fileReader.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return repository;
    }

    @Override 
    public void store(String filename, Repository repository){
          BufferedWriter  bufferedWriter = null;
          FileWriter fileWriter = null;
          try{
              fileWriter = new FileWriter(filename);
              bufferedWriter = new BufferedWriter(fileWriter);                      
              for(Swipe item:repository.getItems()){
                  bufferedWriter.write(item.toString(','));
                  bufferedWriter.newLine();
              }
          }
          catch(IOException ex){
              ex.printStackTrace();
          }finally {
              try{
                  if(bufferedWriter != null) bufferedWriter.close();
                  if(fileWriter != null) fileWriter.close();
              }catch(IOException ex){
                  ex.printStackTrace();
              }
          }   
    } 
}
