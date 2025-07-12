package com.REST.service;

import java.util.List;

import com.REST.binding.ActorData;

/**
 * Service interface for managing actor information.
 * Provides method contracts for CRUD operations and custom updates
 * to be implemented by service layer classes.
 */
public interface IActorInfoMgmtService {

    /**
     * Registers (inserts) a new actor into the system.
     *
     * @param data The actor data to be saved
     * @return A success message with the generated actor ID
     */
    String registerActorInfo(ActorData data);

    /**
     * Retrieves a list of all actors.
     *
     * @return A list of {@link ActorData} representing all actors
     */
    List<ActorData> showAllActors();

    /**
     * Retrieves an actor by their ID.
     *
     * @param id The ID of the actor
     * @return The corresponding {@link ActorData}
     * @throws IllegalArgumentException if the actor is not found
     */
    ActorData showActorId(int id);

    /**
     * Updates an existing actor's full details.
     *
     * @param data The actor data with updated values
     * @return A success message with the actor ID
     * @throws IllegalArgumentException if the actor is not found
     */
    String updateActorData(ActorData data);

    /**
     * (Unused) Updates actor status using a double parameter (placeholder method).
     *
     * @param aid    The actor ID
     * @param amount The amount (currently unused)
     * @return A result message (currently returns null in implementation)
     */
    String updateActorStatus(int aid, double amount);

    /**
     * Updates the status of an actor (e.g., active/inactive).
     *
     * @param aid    The actor ID
     * @param status The new status (e.g., "Y", "N")
     * @return A success message with the actor ID
     * @throws IllegalArgumentException if the actor is not found
     */
    String updateActorStatus(int aid, String status);

    /**
     * Deletes an actor by their ID.
     *
     * @param aid The actor ID
     * @return A success message indicating deletion
     * @throws IllegalArgumentException if the actor is not found
     */
    String deleteActorById(int aid);
}
