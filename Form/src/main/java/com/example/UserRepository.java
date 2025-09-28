package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> 
    {
          UserModel findByFullName(String fullName);
          void deleteByFullName(String fullName);
	}


