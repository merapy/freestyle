package com.merapy.repository;

import com.merapy.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yoshi on 16/07/17.
 */
public interface UserRepository extends ElasticsearchRepository<User,Long> {

    User findByName(String text);
}
