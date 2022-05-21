package uz.isystem.kunuzclone.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.webresources.StandardRoot;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = ("users"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private  String surname;
    private String password;
    private String contact;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("user_type_id"), insertable = false, updatable = false)
    private Usertype usertype;

    @Column(name = ("user_type_id"))
    private Integer userTypeId;
}
