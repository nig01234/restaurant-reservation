package data;

import java.util.ArrayList;

import model.Restaurant;
import model.Reservation;
import model.User;

public class DataManager {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Restaurant> restaurants = new ArrayList<>();
    public static ArrayList<Reservation> reservations = new ArrayList<>();

    static {

        // 관리자 계정
        users.add(new User("admin", "1234", "관리자", true));

        // 식당 목록
        restaurants.add(new Restaurant(1, "가천식당", "성남", 30));
        restaurants.add(new Restaurant(2, "맘스터치", "성남", 20));
        restaurants.add(new Restaurant(3, "한솥", "성남", 25));

    }

}