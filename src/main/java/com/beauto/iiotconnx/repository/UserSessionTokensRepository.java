package com.beauto.iiotconnx.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.beauto.iiotconnx.model.UserSessionToken;

public interface UserSessionTokensRepository extends CrudRepository<UserSessionToken, UUID> {

}
