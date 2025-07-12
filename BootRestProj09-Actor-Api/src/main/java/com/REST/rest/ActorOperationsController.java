package com.REST.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.REST.binding.ActorData;
import com.REST.service.IActorInfoMgmtService;

/**
 * REST controller to handle CRUD operations for actors.
 * 
 * Base URL: /actor-api
 * 
 * This controller provides endpoints to:
 * - Create a new actor
 * - Get all actors
 * - Get a specific actor by ID
 * - Update actor data
 * - Partially update actor status
 * - Delete actor by ID
 */
@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {

    @Autowired
    private IActorInfoMgmtService actorService;

    /**
     * Handles HTTP POST to create a new actor.
     *
     * @param data The actor data from request body
     * @return A response with a success message and HTTP status 201 (Created)
     */
    @PostMapping("/save")
    public ResponseEntity<String> saveActor(@RequestBody ActorData data) {
        String msg = actorService.registerActorInfo(data);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    /**
     * Handles HTTP GET to retrieve all actor records.
     *
     * @return A list of all actors and HTTP status 200 (OK)
     */
    @GetMapping("/all")
    public ResponseEntity<List<ActorData>> showAllActors() {
        List<ActorData> listData = actorService.showAllActors();
        return new ResponseEntity<>(listData, HttpStatus.OK);
    }

    /**
     * Handles HTTP GET to retrieve a single actor by ID.
     *
     * @param id The actor ID from the path
     * @return The actor data and HTTP status 200 (OK)
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<ActorData> fetchActorById(@PathVariable Integer id) {
        ActorData data = actorService.showActorId(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    /**
     * Handles HTTP PUT to update an actor's full record.
     *
     * @param data The actor data with updated values
     * @return A response with a success message and HTTP status 200 (OK)
     */
    @PutMapping("/update")
    public ResponseEntity<String> updateActorData(@RequestBody ActorData data) {
        String msg = actorService.updateActorData(data);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    /**
     * Handles HTTP PATCH to partially update the actor's status.
     *
     * @param id     The actor ID
     * @param status The new active status (e.g., "Y" or "N")
     * @return A response with a success message and HTTP status 200 (OK)
     */
    @PatchMapping("/rupdate/{id}/{status}")
    public ResponseEntity<String> updateActorStatus(@PathVariable Integer id, @PathVariable String status) {
        String msg = actorService.updateActorStatus(id, status);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    /**
     * Handles HTTP DELETE to remove an actor by ID.
     *
     * @param id The ID of the actor to delete
     * @return A response with a success message and HTTP status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeActorById(@PathVariable Integer id) {
        String msg = actorService.deleteActorById(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
