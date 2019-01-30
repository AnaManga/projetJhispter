package com.service;

import com.domain.Group;
import com.repository.GroupRepository;
import com.repository.search.GroupSearchRepository;
import com.service.dto.GroupDTO;
import com.service.mapper.GroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Group.
 */
@Service
@Transactional
public class GroupService {

    private final Logger log = LoggerFactory.getLogger(GroupService.class);

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    private final GroupSearchRepository groupSearchRepository;

    public GroupService(GroupRepository groupRepository, GroupMapper groupMapper, GroupSearchRepository groupSearchRepository) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
        this.groupSearchRepository = groupSearchRepository;
    }

    /**
     * Save a group.
     *
     * @param groupDTO the entity to save
     * @return the persisted entity
     */
    public GroupDTO save(GroupDTO groupDTO) {
        log.debug("Request to save Group : {}", groupDTO);

        Group group = groupMapper.toEntity(groupDTO);
        group = groupRepository.save(group);
        GroupDTO result = groupMapper.toDto(group);
        groupSearchRepository.save(group);
        return result;
    }

    /**
     * Get all the groups.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<GroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Groups");
        return groupRepository.findAll(pageable)
            .map(groupMapper::toDto);
    }


    /**
     * Get one group by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<GroupDTO> findOne(Long id) {
        log.debug("Request to get Group : {}", id);
        return groupRepository.findById(id)
            .map(groupMapper::toDto);
    }

    /**
     * Delete the group by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Group : {}", id);
        groupRepository.deleteById(id);
        groupSearchRepository.deleteById(id);
    }

    /**
     * Search for the group corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<GroupDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Groups for query {}", query);
        return groupSearchRepository.search(queryStringQuery(query), pageable)
            .map(groupMapper::toDto);
    }
    /*
    @Transactional(readOnly = true)
    public List<Group> findByUsers() {
        log.debug("Request to get Group : {}");
        return groupRepository.findByUsers_groupIsCurrentUser();
    }
    */


}
