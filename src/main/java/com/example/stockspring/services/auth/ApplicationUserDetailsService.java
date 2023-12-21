//package com.example.stockspring.services.auth;
//
//import com.example.stockspring.dto.UtilisateurDto;
//import com.example.stockspring.services.UtilisateurService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class ApplicationUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UtilisateurService service;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UtilisateurDto utilisateur = service.findByEmail(email);
//
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
//
//        return new User(utilisateur.getEmail(), utilisateur.getMoteDePasse(), Collections.emptyList());
//    }
//}
