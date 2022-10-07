package com.ihsan.useralbum.utility;


import com.ihsan.useralbum.repository.IUserRepository;
import com.ihsan.useralbum.repository.entity.EUserType;
import com.ihsan.useralbum.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class DataImpl {

    private final IUserRepository userRepository;

    @PostConstruct
    private void create(){
        saveUsers();
    }

    private void saveUsers(){
        User user1 = User.builder()
                .email("ihsancanbozoklar@hotmail.com")
                .password("aa")
                .userType(EUserType.Erkek)
                .build();

        User user2 = User.builder()
                .email("asli@hotmail.com")
                .password("aa")
                .userType(EUserType.Kız)
                .build();

        userRepository.saveAll(Arrays.asList(user1, user2));
    }

}


