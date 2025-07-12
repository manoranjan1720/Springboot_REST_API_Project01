package com.REST.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A data transfer object (DTO) representing actor details.
 * Used for transferring actor data between client and server in REST APIs.
 * 
 * Lombok annotations:
 * - {@code @Data}: Generates getters, setters, toString, equals, and hashCode methods.
 * - {@code @NoArgsConstructor}: Generates a no-args constructor.
 * - {@code @AllArgsConstructor}: Generates a constructor with all fields as arguments.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorData {

    /**
     * The unique identifier for the actor.
     */
    private Integer aid;

    /**
     * The full name of the actor.
     */
    private String aname;

    /**
     * The address or location of the actor.
     */
    private String addrs;

    /**
     * The remuneration (payment) given to the actor.
     */
    private Double remunartion;

    /**
     * The active status switch of the actor.
     * Typically "Y" (active) or "N" (inactive).
     */
    private String active_SW;
}
