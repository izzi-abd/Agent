package Agent;

/**
 *
* @author Abdurrahman Izzi
 */
public class Receiver {
    private int id;
    private boolean hasMessage;
    
    void setID(int p_id) {
        id = p_id;
    }
    
    int getID() {
        return id;
    }
    
    void setHasMessage(boolean p_hasMessage) {
        hasMessage = p_hasMessage;
    }
    
    boolean hasMessage() {
        return hasMessage;
    }
    
}
