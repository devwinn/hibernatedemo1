package org.example.models;

import java.util.Objects;

import jakarta.persistence.Entity;
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

    @Id
    int did;

    @NonNull
    String name;

    @NonNull
    String state;



}
