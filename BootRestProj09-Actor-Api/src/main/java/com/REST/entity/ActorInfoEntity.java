package com.REST.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Data;

/**
 * Entity class representing actor information stored in the database.
 * Maps to the REST_ACTORINFO table and includes actor details along with metadata.
 * 
 * Uses JPA and Hibernate annotations for ORM mapping, and Lombok's @Data for boilerplate code.
 */
@Entity
@Table(name = "REST_ACTORINFO")
@Data
public class ActorInfoEntity {

    /**
     * Primary key - Auto-generated actor ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer aid;

    /**
     * Actor's name (max 30 characters).
     */
    @Column(length = 30)
    private String aname;

    /**
     * Actor's address (max 30 characters).
     */
    @Column(length = 30)
    private String addrs;

    /**
     * Remuneration (payment) given to the actor.
     */
    private Double remuneration;

    /**
     * Active status flag, e.g., "Y" for active or "N" for inactive (max 10 characters).
     */
    @Column(length = 10)
    private String active_SW;

    // ---------- Metadata fields ----------

    /**
     * Username who created the record (max 30 characters).
     */
    @Column(length = 30)
    private String createdBy;

    /**
     * Username who last updated the record (max 30 characters).
     */
    @Column(length = 30)
    private String updatedBy;

    /**
     * Timestamp for when the record was created.
     * Automatically populated during insert; not updatable.
     */
    @CreationTimestamp
    @Column(updatable = false, insertable = true)
    private LocalDate creationDate;

    /**
     * Timestamp for when the record was last updated.
     * Automatically updated on every update; not insertable.
     */
    @UpdateTimestamp
    @Column(updatable = false, insertable = true)
    private LocalDate updationDate;

    /**
     * Optimistic locking field.
     * Increments with each update to help manage concurrent transactions.
     */
    @Version
    private Integer updationCount;
}
