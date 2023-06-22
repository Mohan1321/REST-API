package com.todoApp.todolistApp.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private boolean done;

}
