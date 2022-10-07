package com.ihsan.useralbum.service;


import com.ihsan.useralbum.dto.request.UserSaveRequestDto;
import com.ihsan.useralbum.dto.response.UserSaveResponseDto;
import com.ihsan.useralbum.mapper.UserMapper;
import com.ihsan.useralbum.repository.IUserRepository;
import com.ihsan.useralbum.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public UserSaveResponseDto saveWithRequestDto(UserSaveRequestDto dto) {


        User user = UserMapper.INSTANCE.toUser(dto);
        userRepository.save(user);
        return UserMapper.INSTANCE.toUserSaveResponseDto(user);


    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }


    public Optional<User> login (String email,String password){
        Optional<User> user=userRepository.findOptionalByEmailAndPassword(email,password);

        if (user.isEmpty()){

            System.out.println("Kullanıcı Bulunamadı");
            return Optional.ofNullable(null);
        }

        return user;

    }
}
