package com.hibernate.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int did;

    @NonNull
    String name;

    @NonNull
    String state;



}
