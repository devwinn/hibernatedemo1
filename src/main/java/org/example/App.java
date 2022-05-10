package org.example;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class App
{
    private static SessionFactory factory;
    public static void main( String[] args ) {

        try {
            factory = new Configuration()
                    .configure(new File("src/main/resources/hibernate.cfg.xml"))
                    .buildSessionFactory();
        }catch (Throwable ex) {
            ex.printStackTrace();
        }

    }
}
