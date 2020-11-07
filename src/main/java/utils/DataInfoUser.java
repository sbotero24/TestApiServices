package utils;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class DataInfoUser {
    JsonObject user;

    private static final String MX = "es-MX";
    private static Faker fakerMx = new Faker(new Locale(MX));
    private static Logger logger = LoggerFactory.getLogger(DataInfoUser.class);

    public static User createUser(String email, String pass) {

        return User.builder()
                .email(email)
                .password(pass)
                .first_name(fakerMx.name().firstName())
                .last_name(fakerMx.country().name())
                .build();

    }
    public void setProperty(String key, Object value) {
        Gson gson = new Gson();
        this.user.add(key, gson.toJsonTree(value));
    }

}
