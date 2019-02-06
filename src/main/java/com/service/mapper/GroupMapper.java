package com.service.mapper;

import com.domain.*;
import com.service.dto.GroupDTO;

import org.mapstruct.*;


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
}
