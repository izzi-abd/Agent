package Agent;

/**
 *
* @author Abdurrahman Izzi
 */
public class Encryptor {
    private char[] arr_message;
    private int[] encr_message;
    
    void setMessage(char[] p_arr_message) {
        arr_message = p_arr_message;
        encr_message=new int[arr_message.length];
    }
    
    void encrypt(int key) {
        for(int i=0;i<arr_message.length;i++) {
            encr_message[i] = ((int)arr_message[i])+key;
        }
    }
    
    int[] getMessage() {
        return encr_message;
    }
}
