package pl.projekt.mikroblog;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {

    public static void main(String[] args) {
        // do uzyskania zaszyfrowanego hasła na potrzeby bazy danych
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password1");
        System.out.println("Password after Encoder:" + password);
        String password2 = passwordEncoder.encode("admin1");
        System.out.println("Password after Encoder:" + password2);
        String password3 = passwordEncoder.encode("password3");
        System.out.println("Password after Encoder:" + password3);
        String mariola = passwordEncoder.encode("mariola");
        System.out.println("Password after Encoder:" + mariola);
    }
}
