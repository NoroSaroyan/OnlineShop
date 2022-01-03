package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.entity.User;
import ru.gb.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("\n_________try to find user : " + email);
        Optional<ru.gb.entity.User> mayBeUser = userRepository.findByEmail(email);
        if (mayBeUser.isEmpty()) {
            throw new UsernameNotFoundException("User with username:" + email + "not found");
        }
        ru.gb.entity.User user = mayBeUser.get();
        UserDetails u = org.springframework.security.core.userdetails.User.
                withUsername(user.getEmail()).
                password(user.getPassword()).
                authorities("USER").
                build();
        return u;
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(
                pageable
        );
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User findById(Long id) {
        Optional<User> mayBeUser = userRepository.findById(id);
        return mayBeUser.orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
