package com.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of GroupSearchRepository to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class GroupSearchRepositoryMockConfiguration {

    @MockBean
    private GroupSearchRepository mockGroupSearchRepository;

}
