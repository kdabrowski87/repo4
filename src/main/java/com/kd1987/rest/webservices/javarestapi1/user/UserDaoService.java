package com.kd1987.rest.webservices.javarestapi1.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static Integer usersCount=0;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++usersCount,"user1", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount,"user2",LocalDate.now().minusYears(50)));
        users.add(new User(++usersCount,"user3",LocalDate.now().minusYears(18)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);

        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
       users.add(user);
       return  user;
    }
}
