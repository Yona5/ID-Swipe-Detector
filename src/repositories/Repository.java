package repositories;
import java.util.ArrayList;
import model.Swipe;
import java.util.function.Predicate;
import daos.DAOimpl;
//import java.util.function.Predicate;
//import model.Swipe;


public class Repository implements RepositoryInterface {
    private ArrayList<Swipe> items;    
    
    public Repository() {
        this.items = new ArrayList();       
    }
    
    public Repository(ArrayList<Swipe> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        // Create dao and execute load 
        DAOimpl dao = new DAOimpl();
        Repository repo = dao.load(filename);
        this.items = repo.getItems();   
        
    }
    /**
     * @return array list
     */
    @Override
    public ArrayList<Swipe> getItems(){        
        return this.items;
    }
    /**
     * @param items
     */
    @Override
    public void setItems(ArrayList<Swipe> items) {        
        this.items = items;
    }
    /**
     * @param item
     */
    @Override
    public void add(Swipe item) {
        this.items.add(item);
    }
    /**
     * @param id
     */
    @Override
    public void remove(int id) {
        Predicate<Swipe> predicate = e->e.getId() == id;       
        this.items.removeIf(predicate);
    }
    /**
     * @param id
     * @return  swipe
     */
    @Override
    public Swipe getItem(int id) {
        for (Swipe item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
    /**
     * @return string
     */
    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }    
    /**
     * @param filename 
     */
    @Override
    public void store(String filename) {       
        // create dao and execute store
        DAOimpl dao = new DAOimpl();
        Repository repository = new Repository();
        repository.setItems(this.items);
        dao.store(filename,repository);
        System.out.println("File exported");
    }        
}
