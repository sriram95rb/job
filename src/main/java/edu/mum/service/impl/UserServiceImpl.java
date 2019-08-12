package edu.mum.service.impl;

import edu.mum.domain.Message;
import edu.mum.domain.User;
import edu.mum.repository.UserRepository;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
        // change to hashed password
        user.setPassword(hashPassword);
        user.setConfirmPassword(hashPassword);
        user.setRegisterDate(LocalDate.now());
        // persisted user to db.
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Message> getLast5UnreadNotifyMessageByUserEmail(String email) {
        return userRepository.getLast5UnreadNotifyMessageByUserEmail(email);
    }
}