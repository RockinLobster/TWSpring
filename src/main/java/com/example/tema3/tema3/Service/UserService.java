package com.example.tema3.tema3.Service;

import com.example.tema3.tema3.Util.UserRegistrationDto;
import com.example.tema3.tema3.models.Roles;
import com.example.tema3.tema3.models.Users;
import com.example.tema3.tema3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users findByUsername(String username){
        return usersRepository.findByUsername(username);
    }

    public Users save(UserRegistrationDto registration){
        Users user = new Users();
        user.setUsername(registration.getUsername());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        Roles role = new Roles();
        role.setName("user");
        Set<Roles> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Invalid user or password");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Roles role: user.getRoles()) {
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}
