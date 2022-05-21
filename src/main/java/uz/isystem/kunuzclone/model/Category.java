package uz.isystem.kunuzclone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("categores"))
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer id;

        private String name;

        @Column (name ="craeted_at")
        private LocalDateTime createdAt;
}
