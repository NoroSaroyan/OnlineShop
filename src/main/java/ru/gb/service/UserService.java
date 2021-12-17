package ru.gb.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.encoder.SHA256_impl;
import ru.gb.entity.User;
import ru.gb.repository.RoleRepository;
import ru.gb.repository.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private SHA256_impl encoding;

    public UserService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.encoding = new SHA256_impl();
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

    public void registration(User user) throws NoSuchAlgorithmException {
        //if username isn't taken , then
        String encodedPassword = SHA256_impl.toHexString(SHA256_impl.getSHA(user.getPassword()));
        //user data to be sent to db ;
    }
}
