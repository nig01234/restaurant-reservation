package manager;

import data.DataManager;
import model.Restaurant;

public class RestaurantManager {

    // 식당 목록 출력
    public void showRestaurantList() {

        System.out.println("\n===== 식당 목록 =====");

        for(Restaurant restaurant : DataManager.restaurants) {

            System.out.println(restaurant);

        }

    }

    // 번호로 식당 찾기
    public Restaurant findRestaurant(int restaurantNo) {

        for(Restaurant restaurant : DataManager.restaurants) {

            if(restaurant.getRestaurantNo() == restaurantNo) {

                return restaurant;

            }

        }

        return null;

    }

}