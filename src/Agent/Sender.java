package Agent;

/**
 *
* @author Abdurrahman Izzi
 */
public class Sender {
    private String nama;
    private int id;
    private String biro;
    
    void setNama(String p_nama) {
        nama = p_nama;
    }
    
    void setID(int p_id) {
        id = p_id;
    }
    
    void setBiro(String p_biro) {
        biro = p_biro;
    }
    
    String getNama() {
        return nama;
    }
    
    String getBiro() {
        return biro;
    }
    
    int getID() {
        return id;
    }
}
