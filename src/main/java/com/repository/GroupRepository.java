package com.repository;

import com.domain.Group;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Group entity.
 */

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
