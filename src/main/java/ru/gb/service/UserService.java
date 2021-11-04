package ru.gb.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.entity.User;
import ru.gb.repository.RoleRepository;
import ru.gb.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public UserService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> mayBeUser = userRepository.findByEmail(email);
        if (mayBeUser.isEmpty()) {
            throw new UsernameNotFoundException("User with username:" + email + "not found");
        }
        User user = mayBeUser.get();
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .toList()
        );

    }
}
