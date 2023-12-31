package com.bsebastian.tracker.app.entities.models;

import com.bsebastian.tracker.security.user.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trackers")
public class Tracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 5, max = 255, message = "Name must be between 5 and 255 characters")
    private String name;

    @OneToMany(mappedBy = "tracker",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    List<Activity> activities;

    @OneToOne(mappedBy = "tracker")
    private UserEntity user;
}
