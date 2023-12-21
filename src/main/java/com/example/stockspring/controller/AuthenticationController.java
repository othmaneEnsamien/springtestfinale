//package com.example.stockspring.controller;
//
//import com.example.stockspring.controller.api.AuthenticationApi;
//import com.example.stockspring.dto.auth.AuthenticationRequest;
//import com.example.stockspring.dto.auth.AuthenticationResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import static com.example.stockspring.utils.Constants.AUTHENTICATION_ENDPOINT;
//
//@RestController
//@RequestMapping(AUTHENTICATION_ENDPOINT)
//public class AuthenticationController  {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//    @Autowired
//    private UserDetailsService userDetailsService; // Using the default UserDetailsService
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
////        authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(
////                        request.getLogin(),
////                        request.getPassword()
////                )
////        );
////
////        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
//
//        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken("dummy").build());
//    }
//
//    // Other authentication-related endpoints can be added here
//}
