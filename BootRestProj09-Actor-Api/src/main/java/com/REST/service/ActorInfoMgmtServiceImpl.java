package com.REST.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.REST.binding.ActorData;
import com.REST.entity.ActorInfoEntity;
import com.REST.repository.IActorInfoRepository;

/**
 * Service implementation for managing actor information.
 * Provides business logic for handling CRUD operations and
 * works as a bridge between the controller and repository layers.
 */
@Service
public class ActorInfoMgmtServiceImpl implements IActorInfoMgmtService {

    @Autowired
    private IActorInfoRepository actorRepo;

    /**
     * Injected username (from application.properties) used to tag created/updated records.
     */
    @Value("${user.name}")
    private String ouser;

    /**
     * Saves a new actor record to the database.
     *
     * @param data The actor data from the client
     * @return A success message including the generated actor ID
     */
    @Override
    public String registerActorInfo(ActorData data) {
        ActorInfoEntity entity = new ActorInfoEntity();
        BeanUtils.copyProperties(data, entity);
        entity.setCreatedBy(ouser);
        entity.setUpdatedBy(ouser);
        int idVal = actorRepo.save(entity).getAid();
        return "Actor is saved with the id value::" + idVal;
    }

    /**
     * Retrieves and returns all actor records.
     *
     * @return A list of {@link ActorData} representing all actors
     */
    @Override
    public List<ActorData> showAllActors() {
        List<ActorInfoEntity> listEntities = actorRepo.findAll();

        // Using stream API to convert entities to DTOs
        return listEntities.stream().map(entity -> {
            ActorData data = new ActorData();
            BeanUtils.copyProperties(entity, data);
            return data;
        }).collect(Collectors.toList());
    }

    /**
     * Retrieves a specific actor by their ID.
     *
     * @param id The actor ID
     * @return The corresponding {@link ActorData}
     * @throws IllegalArgumentException if the actor is not found
     */
    @Override
    public ActorData showActorId(int id) {
        ActorInfoEntity entity = actorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        ActorData data = new ActorData();
        BeanUtils.copyProperties(entity, data);
        return data;
    }

    /**
     * Updates the full data for an existing actor.
     *
     * @param data The updated actor data
     * @return A success message with the actor ID
     * @throws IllegalArgumentException if the actor is not found
     */
    @Override
    public String updateActorData(ActorData data) {
        ActorInfoEntity entity = actorRepo.findById(data.getAid())
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        BeanUtils.copyProperties(data, entity);
        entity.setUpdatedBy(ouser);
        int idVal = actorRepo.save(entity).getAid();
        return idVal + " Actor Data is updated";
    }

    /**
     * Overridden but unused method — originally meant to update using a `double amount`.
     * 
     * @param aid The actor ID
     * @param amount Unused parameter
     * @return null (unimplemented)
     */
    @Override
    public String updateActorStatus(int aid, double amount) {
        return null; // Unused version
    }

    /**
     * Updates the active status of a specific actor.
     *
     * @param aid The actor ID
     * @param status The new status value ("Y", "N", etc.)
     * @return A success message including the actor ID
     * @throws IllegalArgumentException if the actor is not found
     */
    @Override
    public String updateActorStatus(int aid, String status) {
        ActorInfoEntity entity = actorRepo.findById(aid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        entity.setActive_SW(status);
        int idVal = actorRepo.save(entity).getAid();
        return idVal + " Actor Status is Updated";
    }

    /**
     * Deletes an actor record by its ID.
     *
     * @param aid The actor ID
     * @return A success message including the deleted actor ID
     * @throws IllegalArgumentException if the actor is not found
     */
    @Override
    public String deleteActorById(int aid) {
        ActorInfoEntity entity = actorRepo.findById(aid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        actorRepo.deleteById(aid);
        return aid + " Actor is Deleted";
    }
}
