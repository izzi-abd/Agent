package Agent;

/**
 *
* @author Abdurrahman Izzi
 */
public class Decryptor {
    private int[] encr_message;
    private char[] decr_message;
    
    void setMessage(int[] p_encr_message) {
        encr_message = p_encr_message;
        decr_message = new char[encr_message.length]; 
    }
    
    void decrypt(int key) {
        for(int i=0;i<encr_message.length;i++) {
            decr_message[i] = (char)(encr_message[i]-key);
        }
    }
    
    char[] getMessage() {
        return decr_message;
    }
    
}
