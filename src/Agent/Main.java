/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import java.util.Scanner;

/**
 *
 * @author Abdurrahman Izzi
 * 
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private Decryptor dec;
    private Encryptor enc;
    private Message msg;
    private Receiver rec;
    private Sender sendr;
    
    //membaca integer sekaligus menghandle eror saat user mengetikkan karakter non-angka
    int readInt(String an) {
        START:
        while(true) {
        try {
            return Integer.parseInt(an);
        } catch(NumberFormatException e) {
            System.out.print("KESALAHAN! Hanya menerima input berupa angka! \nSilahkan masukkan kembali : ");
            try {
            return Integer.parseInt(in.nextLine());
            } catch (NumberFormatException x) {
                continue START;
            }
        }
    }
    }
    
    //inisialisasi objek
    void init() {
    dec = new Decryptor();
    enc = new Encryptor();
    msg = new Message();
    rec = new Receiver();
    sendr = new Sender();
    }
    
    //tampilan login
    void login(Main app) {
        System.out.println("=====================================");
        System.out.println("SILAHKAN LOGIN");
        System.out.println("=====================================");
        System.out.print("Nama : ");
        app.sendr.setNama(in.nextLine());
        System.out.print("ID : ");
        app.sendr.setID(app.readInt(in.nextLine()));
        System.out.print("Biro : ");
        app.sendr.setBiro(in.nextLine());
        System.out.println("=====================================");
    }
    
    //menampilkan pesan berasal dari array char (decrypted message)
    void print(char[] message) {
        for(int i=0;i<message.length;i++) {
            System.out.print(message[i]);
        }
    }
    
    //menampilkan pesan berasal dari array integer (encrypted message)
    void print(int[] message) {
        for(int i=0;i<message.length;i++) {
            System.out.print(message[i]);
        }
    }
    
    //method login untuk penerima pesan
    static void loginReceiver(Main app) {
        LOOP:
        while(true) {
        app.login(app);
        if((app.sendr.getID()==app.rec.getID())) {
            if(app.rec.hasMessage()) {
            START:
            while(true) {
            System.out.println("Selamat datang " +app.sendr.getNama()+ " Kamu memiliki 1 pesan");
            System.out.println("Silahkan pilih : ");
            System.out.println("1. Membaca pesan");
            System.out.println("2. Mendekripsi pesan");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan anda (1-3) : ");
            int temp = app.readInt(in.nextLine());
            if(temp==1) {
                app.print(app.enc.getMessage());
                System.out.println();
                System.out.print("Press any key to continue...");
                {
                String a = in.nextLine();
                }
                System.out.println("=====================================");
                continue START;
            }
            else if(temp==2) {
                app.dec.setMessage(app.enc.getMessage());
                System.out.print("Masukkan kunci dekripsi : ");
                int key = app.readInt(in.nextLine());
                System.out.println("Melakukan dekripsi...");
                app.dec.decrypt(key);
                System.out.println("PESAN ANDA : ");
                app.print(app.dec.getMessage());
                System.out.println();
                System.out.print("Press any key to continue...");
                {
                String a = in.nextLine();
                }
                
                continue START;
                
            } else {
                return;
            }
            }} else {
                System.out.println("Kamu tidak memiliki pesan di inbox.");
                System.out.print("Input 'x' to exit, or other key to continue...");
                {
                String a = in.nextLine();
                if(a=="x") return;
                }
            }
    } else {
            System.out.println("Bukan penerima pesan. Access ditolak!");
            System.out.print("Input 'x' to exit, or other key to continue...");
                {
                String a = in.nextLine();
                if(a.equalsIgnoreCase("x")) return;
                }
            continue LOOP;
        }}
    }
    
    public static void main(String[] args) {
        Main app = new Main();
        START:
        while(true) {
            System.out.println("MULAI PROGRAM?");
            System.out.println("1. YA");
            System.out.println("2. TIDAK, KELUAR");
            System.out.print("Silahkan input pilihan anda(1/2) : ");
            {   
                int temp;
                temp = app.readInt(in.nextLine());
                
        
            if(temp==1) break START;
            else if(temp==2) return;
            else {
                System.out.println("KESALAHAN! Hanya menerima input '1' atau '2'");
                continue START;
            }
                }
            }
        
        app.init();
        app.login(app);
        System.out.println("Anda telah login " +app.sendr.getNama());
        
        System.out.print("Masukkan ID penerima pesan : ");
        app.rec.setID(app.readInt(in.nextLine()));
        System.out.print("Masukkan pesan Anda : ");
        app.msg.setMessage(in.nextLine());
        app.msg.decomposition();
        app.enc.setMessage(app.msg.getMessageArray());
        System.out.print("Masukkan kunci enkripsi : ");
        int key = app.readInt(in.nextLine());
    {   
        System.out.println("=====================================");
        System.out.println("Mulai mengirim pesan?");
        System.out.println("YA (tekan 1)");
        System.out.println("TIDAK, KELUAR (tekan angka apapun selain 1)");
        System.out.print("Silahkan input pilihan anda : ");
        {
        int temp;
        temp = app.readInt(in.nextLine());
        System.out.println("=====================================");
        if(temp!=1) loginReceiver(app);
        }
        System.out.println("Mengenkripsi pesan...");
        app.enc.encrypt(key);
    }
        System.out.println("Pesan  terenkripsi");
        System.out.println("Pesan terkirim");
        app.rec.setHasMessage(true);
        System.out.print("Press any key to continue...");
                {
                String a = in.nextLine();
                }
        loginReceiver(app);
}}