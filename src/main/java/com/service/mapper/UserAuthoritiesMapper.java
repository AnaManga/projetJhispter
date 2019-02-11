package com.service.mapper;

import com.domain.Authority;
import com.domain.Group;
import com.domain.User;
import com.service.dto.GroupDTO;
import com.service.dto.UserAuthoritiesDTO;
import com.service.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Mapper for the entity Group and DTO UserAuthoritiesDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserAuthoritiesMapper {

    default List<UserAuthoritiesDTO> usersToUserAuthoritiesDTOs(List<User> users) {
        return users.stream()
            .filter(Objects::nonNull)
            .map(this::userToUserAuthoritiesDTO)
            .collect(Collectors.toList());
    }

    default UserAuthoritiesDTO userToUserAuthoritiesDTO(User user) {
        return new UserAuthoritiesDTO(user);
    }


    default List<User> userAuthoritiesDTOsToUsers(List<UserAuthoritiesDTO> UserAuthoritiesDTO) {
        return UserAuthoritiesDTO.stream()
            .filter(Objects::nonNull)
            .map(this::userAuthoritiesDTOToUser)
            .collect(Collectors.toList());
    }

    default User userAuthoritiesDTOToUser(UserAuthoritiesDTO UserAuthoritiesDTO) {
        if (UserAuthoritiesDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(UserAuthoritiesDTO.getId());
            user.setLogin(UserAuthoritiesDTO.getLogin());
            user.setFirstName(UserAuthoritiesDTO.getFirstName());
            user.setLastName(UserAuthoritiesDTO.getLastName());
            user.setEmail(UserAuthoritiesDTO.getEmail());
            user.setImageUrl(UserAuthoritiesDTO.getImageUrl());
            user.setActivated(UserAuthoritiesDTO.isActivated());
            user.setLangKey(UserAuthoritiesDTO.getLangKey());
            Set<Authority> authorities = this.authorityToString(UserAuthoritiesDTO.getAuthorities());
            user.setAuthorities(authorities);
            return user;
        }
    }


    default Set<Authority> authorityToString (Set<String> authString) {
        Set<Authority> authorities = new HashSet<>();

        if(authString != null){
            authorities = authString.stream().map(string -> {
                Authority auth = new Authority();
                auth.setName(string);
                return auth;
            }).collect(Collectors.toSet());
        }

        return authorities;

    }

    default Set<String> stringToAuthority (Set<Authority> auth) {
        Set<String> authorities = new HashSet<>();
        if(auth != null) {
            authorities = auth
                .stream()
                .map(Authority::getName)
                .collect(Collectors.toSet());
        }

        return authorities;

    }


}
