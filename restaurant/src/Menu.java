import manager.ReservationManager;
import manager.RestaurantManager;
import manager.UserManager;
import model.Restaurant;
import model.User;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

    private UserManager userManager = new UserManager();
    private RestaurantManager restaurantManager = new RestaurantManager();
    private ReservationManager reservationManager = new ReservationManager();

    private User loginUser = null;

    public void start() {

        while (true) {

            if (loginUser == null) {
                mainMenu();
            } else {

                if (loginUser.isAdmin()) {
                    adminMenu();
                } else {
                    userMenu();
                }

            }

        }

    }

    // ===============================
    // 메인 메뉴
    // ===============================
    private void mainMenu() {

        System.out.println("\n==============================");
        System.out.println("     식당 예약 프로그램");
        System.out.println("==============================");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
        System.out.print("선택 : ");

        int menu = sc.nextInt();

        switch (menu) {

            case 1:
                join();
                break;

            case 2:
                login();
                break;

            case 0:
                System.out.println("프로그램 종료");
                System.exit(0);

            default:
                System.out.println("잘못 입력했습니다.");

        }

    }

    // ===============================
    // 회원가입
    // ===============================
    private void join() {

        System.out.print("아이디 : ");
        String id = sc.next();

        System.out.print("비밀번호 : ");
        String pw = sc.next();

        System.out.print("이름 : ");
        String name = sc.next();

        if (userManager.join(id, pw, name)) {

            System.out.println("회원가입 성공!");

        } else {

            System.out.println("이미 존재하는 아이디입니다.");

        }

    }

    // ===============================
    // 로그인
    // ===============================
    private void login() {

        System.out.print("아이디 : ");
        String id = sc.next();

        System.out.print("비밀번호 : ");
        String pw = sc.next();

        loginUser = userManager.login(id, pw);

        if (loginUser == null) {

            System.out.println("로그인 실패");

        } else {

            System.out.println(loginUser.getName() + "님 환영합니다.");

        }

    }

    // ===============================
    // 사용자 메뉴
    // ===============================
    private void userMenu() {

        System.out.println("\n==============================");
        System.out.println("1. 식당 목록");
        System.out.println("2. 예약하기");
        System.out.println("3. 내 예약 조회");
        System.out.println("4. 예약 취소");
        System.out.println("5. 로그아웃");
        System.out.print("선택 : ");

        int menu = sc.nextInt();

        switch (menu) {

            case 1:
                restaurantManager.showRestaurantList();
                break;

            case 2:
                reserve();
                break;

            case 3:
                reservationManager.showMyReservation(loginUser.getId());
                break;

            case 4:
                cancelReservation();
                break;

            case 5:
                loginUser = null;
                System.out.println("로그아웃 되었습니다.");
                break;

            default:
                System.out.println("잘못 입력했습니다.");

        }

    }

    // ===============================
    // 예약하기
    // ===============================
    private void reserve() {

        restaurantManager.showRestaurantList();

        System.out.print("식당 번호 : ");
        int no = sc.nextInt();

        Restaurant restaurant =
                restaurantManager.findRestaurant(no);

        if (restaurant == null) {

            System.out.println("존재하지 않는 식당입니다.");
            return;

        }

        System.out.print("예약 날짜(YYYY-MM-DD) : ");
        String date = sc.next();

        System.out.print("예약 시간(HH:MM) : ");
        String time = sc.next();

        System.out.print("인원수 : ");
        int people = sc.nextInt();

        reservationManager.reserve(
                loginUser.getId(),
                restaurant,
                date,
                time,
                people
        );

    }

    // ===============================
    // 예약 취소
    // ===============================
    private void cancelReservation() {

        reservationManager.showMyReservation(loginUser.getId());

        System.out.print("예약번호 : ");
        int no = sc.nextInt();

        if (reservationManager.cancelReservation(no, loginUser.getId())) {

            System.out.println("예약이 취소되었습니다.");

        } else {

            System.out.println("예약번호가 존재하지 않습니다.");

        }

    }

    // ===============================
    // 관리자 메뉴
    // ===============================
    private void adminMenu() {

        System.out.println("\n==============================");
        System.out.println("관리자 메뉴");
        System.out.println("==============================");
        System.out.println("1. 전체 예약 조회");
        System.out.println("2. 로그아웃");
        System.out.print("선택 : ");

        int menu = sc.nextInt();

        switch (menu) {

            case 1:

                System.out.println("\n===== 전체 예약 =====");

                data.DataManager.reservations.forEach(System.out::println);

                break;

            case 2:

                loginUser = null;

                break;

            default:

                System.out.println("잘못 입력했습니다.");

        }

    }

}