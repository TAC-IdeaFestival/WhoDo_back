package com.example.whodo_back.domain.user.repository;

import com.example.whodo_back.domain.user.entity.BlackList;
import org.springframework.data.repository.CrudRepository;

public interface BlackListRepository extends CrudRepository<BlackList, String> {
}
