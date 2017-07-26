package com.merapy.rest;

import com.merapy.model.User;
import com.merapy.repository.UserRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yoshi on 16/07/17.
 */

@RestController
@RequestMapping(value = "/es/user")
public class UserProvider {

        @Autowired
        UserRepository userRepository;

        @Autowired
        ElasticsearchTemplate elasticsearchTemplate;


    @PostMapping(value = "/save")
    ResponseEntity saveUser(@RequestBody User user) {
       // userRepository.save(user);

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{text}")
    User searchUserByName(@PathVariable final String text) {

        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();

        NativeSearchQuery query = builder.withQuery(QueryBuilders.matchQuery("name", text)).build();

       // elasticsearchTemplate.queryForList(query,User.class);
  return  null;
        /*userRepository.findAll();
        return userRepository.findByName(text);*/
    }

    @PostMapping("/search")
    List<User>  searchJsonUser(@RequestBody String queryString) {

        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();

        NativeSearchQuery query = builder.withQuery(QueryBuilders.wrapperQuery(queryString)).build();
        //elasticsearchTemplate.queryForList(query,User.class);
        return null;

    }
}
