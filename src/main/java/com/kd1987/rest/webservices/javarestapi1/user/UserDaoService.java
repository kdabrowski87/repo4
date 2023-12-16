package com.kd1987.rest.webservices.javarestapi1.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {

    private UserRepository userRepository;

    public UserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //private static Integer usersCount=0;
    //private static List<User> users = new ArrayList<>();

    //static {
    //    users.add(new User(++usersCount,"user1", LocalDate.now().minusYears(25)));
    //    users.add(new User(++usersCount,"user2",LocalDate.now().minusYears(50)));
    //    users.add(new User(++usersCount,"user3",LocalDate.now().minusYears(18)));
    //}

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {

        return userRepository.findById(id);
    }

    public User save(User givenUser) {
    //    user.setId(++usersCount);
       User savedUser = userRepository.save(givenUser);
       return  savedUser;
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
