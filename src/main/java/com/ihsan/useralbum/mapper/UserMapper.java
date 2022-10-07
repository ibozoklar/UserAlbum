package com.ihsan.useralbum.mapper;

import com.ihsan.useralbum.dto.request.UserSaveRequestDto;
import com.ihsan.useralbum.dto.response.UserSaveResponseDto;
import com.ihsan.useralbum.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserSaveResponseDto toUserSaveResponseDto(final User user);

    User toUser(final  UserSaveResponseDto userSaveResponseDto);


    User toUser(final UserSaveRequestDto requestDto);

}
