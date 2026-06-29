package model;

public class Restaurant {

    private int restaurantNo;
    private String name;
    private String location;
    private int maxPeople;

    public Restaurant(int restaurantNo, String name, String location, int maxPeople) {
        this.restaurantNo = restaurantNo;
        this.name = name;
        this.location = location;
        this.maxPeople = maxPeople;
    }

    public int getRestaurantNo() {
        return restaurantNo;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    @Override
    public String toString() {
        return "[" + restaurantNo + "] "
                + name
                + " | 위치 : "
                + location
                + " | 최대 "
                + maxPeople
                + "명";
    }

}