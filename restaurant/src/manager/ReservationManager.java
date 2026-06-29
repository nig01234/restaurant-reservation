package manager;

import data.DataManager;
import model.Reservation;
import model.Restaurant;

public class ReservationManager {

    private static int reservationNo = 1;

    // 예약
    public void reserve(String userId,
                        Restaurant restaurant,
                        String date,
                        String time,
                        int people) {

        DataManager.reservations.add(

                new Reservation(
                        reservationNo++,
                        userId,
                        restaurant,
                        date,
                        time,
                        people
                )

        );

        System.out.println("\n예약이 완료되었습니다.");

    }

    // 내 예약 조회
    public void showMyReservation(String userId) {

        boolean check = false;

        for(Reservation reservation : DataManager.reservations) {

            if(reservation.getUserId().equals(userId)) {

                System.out.println("-----------------------");
                System.out.println(reservation);
                check = true;

            }

        }

        if(!check) {

            System.out.println("예약 내역이 없습니다.");

        }

    }

    // 예약 취소
    public boolean cancelReservation(int reservationNo, String userId) {

        for(int i = 0; i < DataManager.reservations.size(); i++) {

            Reservation reservation = DataManager.reservations.get(i);

            if(reservation.getReservationNo() == reservationNo
                    && reservation.getUserId().equals(userId)) {

                DataManager.reservations.remove(i);

                return true;

            }

        }

        return false;

    }

}