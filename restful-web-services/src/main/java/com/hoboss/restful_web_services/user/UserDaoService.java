package com.hoboss.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {   
        // return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    // public void deleteById(int id) {
    //     users.removeIf(user -> user.getId() == id);
    // }

    // public User updateUserById(int id, User user) {
    //     User userToUpdate = findOne(id);
    //     if (userToUpdate == null) {
    //         return null;
    //     }
    //     userToUpdate.setName(user.getName());
    //     userToUpdate.setBirthDate(user.getBirthDate());
    //     return userToUpdate;
    // }

    // public User createUser(User user) {
    //     user.setId(users.size() + 1);
    //     users.add(user);
    //     return user;
    // }
}
