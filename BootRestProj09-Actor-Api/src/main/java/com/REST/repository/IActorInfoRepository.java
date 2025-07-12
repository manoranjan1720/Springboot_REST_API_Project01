package com.REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.REST.entity.ActorInfoEntity;

/**
 * Repository interface for performing CRUD operations on {@link ActorInfoEntity}.
 * 
 * Extends {@link JpaRepository} to provide standard methods such as:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 * 
 * Spring Data JPA automatically implements this interface at runtime.
 */
public interface IActorInfoRepository extends JpaRepository<ActorInfoEntity, Integer> {
    // Additional custom query methods (if needed) can be declared here
}
