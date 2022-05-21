package uz.isystem.kunuzclone.model;

import lombok.Getter;
import lombok.Setter;
import uz.isystem.kunuzclone.Enum.PostStatus;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("posts"))
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String title;
    private String content;

    private PostStatus postStatus;

    private String token;
    private Integer viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime publishedAt;
    private Boolean status;


    @ManyToOne
    @JoinColumn(name = ("user_id"), insertable = false, updatable = false)
    private User user;

   @Column(name = ("user_id"))
   private Integer userId;

   @ManyToOne
    @JoinColumn(name = ("category_id"), insertable = false, updatable = false)
    private Category category;

   @Column(name = ("category_id"))
    private Integer categoryId;

    @ManyToOne
    @JoinColumn(name = ("region_id"), insertable = false,updatable = false)
    private Region region;

    @Column(name = ("region_id"))
    private Integer regionId;


}
