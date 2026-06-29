package model;

public class Reservation {

    private int reservationNo;
    private String userId;
    private Restaurant restaurant;
    private String date;
    private String time;
    private int people;

    public Reservation(int reservationNo,
                       String userId,
                       Restaurant restaurant,
                       String date,
                       String time,
                       int people) {

        this.reservationNo = reservationNo;
        this.userId = userId;
        this.restaurant = restaurant;
        this.date = date;
        this.time = time;
        this.people = people;

    }

    public int getReservationNo() {
        return reservationNo;
    }

    public String getUserId() {
        return userId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getPeople() {
        return people;
    }

    @Override
    public String toString() {

        return "예약번호 : " + reservationNo +
                "\n식당 : " + restaurant.getName() +
                "\n날짜 : " + date +
                "\n시간 : " + time +
                "\n인원 : " + people + "명";

    }

}