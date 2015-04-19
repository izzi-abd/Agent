/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

/**
 *
 * @author Abdurrahman Izzi
 */
public class Message {
    private String message;
    private char[] arr_message;
    
    void setMessage(String p_message) {
        message=p_message;
        arr_message=new char[p_message.length()];
    }
    
    void decomposition() {
        arr_message = message.toCharArray();
    }
    
    char[] getMessageArray() {
        return arr_message;
    }
}
