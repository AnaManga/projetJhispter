package com.service.mapper;

import com.domain.*;
import com.service.dto.GroupDTO;

import org.mapstruct.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Mapper for the entity Group and its DTO GroupDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface GroupMapper extends EntityMapper<GroupDTO, Group> {

    default Group fromId(Long id) {
        if (id == null) {
            return null;
        }
        Group group = new Group();
        group.setId(id);
        return group;
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
