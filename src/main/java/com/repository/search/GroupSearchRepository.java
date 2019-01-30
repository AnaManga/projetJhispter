package com.repository.search;

import com.domain.Group;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Group entity.
 */
public interface GroupSearchRepository extends ElasticsearchRepository<Group, Long> {
}
