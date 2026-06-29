package manager;

import data.DataManager;
import model.User;

public class UserManager {

    // 회원가입
    public boolean join(String id, String password, String name) {

        for(User user : DataManager.users) {

            if(user.getId().equals(id)) {
                return false;
            }

        }

        DataManager.users.add(
                new User(id, password, name, false)
        );

        return true;

    }

    // 로그인
    public User login(String id, String password) {

        for(User user : DataManager.users) {

            if(user.getId().equals(id)
                    && user.getPassword().equals(password)) {

                return user;

            }

        }

        return null;

    }

}