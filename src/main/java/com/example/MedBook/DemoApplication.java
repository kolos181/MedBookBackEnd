package com.example.MedBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Controller
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        try {
            //   jdbc:postgresql://host:port/database

//            String url = "jdbc:postgresql://ec2-174-129-206-173.compute-1.amazonaws.com:5432/d32n9851o7g2up";
//            String user = "usdjfuefcnakre";
//            String pass = "50fc3935436965c7df94d3b83e4567a5691b699862fb8408b31cd553b6fe59db";

            Class.forName("org.postgresql.Driver");
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String url = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();

            String user = dbUri.getUserInfo().split(":")[0];
            String pass = dbUri.getUserInfo().split(":")[1];

            System.out.println(dbUri.getHost());
            System.out.println(dbUri.getPath());
            System.out.println(dbUri.getUserInfo().split(":")[0]);
            System.out.println(dbUri.getUserInfo().split(":")[1]);


            Connection con = DriverManager.getConnection(
                    url, user, pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("CREATE TABLE IF NOT EXISTS patients (ID SERIAL PRIMARY KEY, " +
                    "first_name text NOT NULL, " +
                    "last_name text NOT NULL," +
                    "sex text," +
                    "birth_date DATE," +
                    "state text," +
                    "address text)");

        } catch (Exception e) {
            System.out.println(e);
        }
        return "Hello World!";
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
}
