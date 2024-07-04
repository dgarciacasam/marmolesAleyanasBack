package com.marmolesAleyanas.marmolesAleyanasBack.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marmolesAleyanas.marmolesAleyanasBack.models.RoleModel;
import com.marmolesAleyanas.marmolesAleyanasBack.models.UserModel;
import com.marmolesAleyanas.marmolesAleyanasBack.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No se ha encontrado al usuario"));
        return new User(user.getUsername(), user.getPassword(), mapRoles(user.getRoles()));
    }

    private Collection<GrantedAuthority> mapRoles(List<RoleModel> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
