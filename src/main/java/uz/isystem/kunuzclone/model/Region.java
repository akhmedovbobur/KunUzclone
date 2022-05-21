package uz.isystem.kunuzclone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("region"))
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private Integer id;

    private String name;

    @Column (name ="created_at" )
    private LocalDateTime createdAt;

}
