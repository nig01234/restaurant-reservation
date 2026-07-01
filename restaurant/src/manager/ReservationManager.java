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

        int totalPeople = 0;

        // 같은 식당 + 같은 날짜 + 같은 시간 예약 인원 합산
        for (Reservation reservation : DataManager.reservations) {

            if (reservation.getRestaurant().getRestaurantNo() == restaurant.getRestaurantNo()
                    && reservation.getDate().equals(date)
                    && reservation.getTime().equals(time)) {

                totalPeople += reservation.getPeople();
            }
        }

        // 최대 인원 초과 여부 확인
        if (totalPeople + people > restaurant.getMaxPeople()) {

            System.out.println("\n예약이 불가능합니다.");
            System.out.println("현재 예약 인원 : " + totalPeople + "명");
            System.out.println("남은 좌석 : " + (restaurant.getMaxPeople() - totalPeople) + "명");
            return;
        }

        // 예약 등록
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

        for (Reservation reservation : DataManager.reservations) {

            if (reservation.getUserId().equals(userId)) {

                System.out.println("-----------------------");
                System.out.println(reservation);
                check = true;
            }
        }

        if (!check) {
            System.out.println("예약 내역이 없습니다.");
        }
    }

    // 예약 취소
    public boolean cancelReservation(int reservationNo, String userId) {

        for (int i = 0; i < DataManager.reservations.size(); i++) {

            Reservation reservation = DataManager.reservations.get(i);

            if (reservation.getReservationNo() == reservationNo
                    && reservation.getUserId().equals(userId)) {

                DataManager.reservations.remove(i);
                return true;
            }
        }

        return false;
    }
}
