package yarm.techstroy.fullstackshop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class WatchReviews {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(nullable = false)
    private Long id;

    @Column (nullable = false)
    private String userName;

    @Column(columnDefinition = "integer default '1'", nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String reviewText;

    private LocalDateTime created;

//    @Column(nullable = false)
//    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private WatchItem item;

    public WatchReviews () {

    }

    public WatchReviews(String userName, Integer rating, String reviewText, WatchItem item) {
        this.userName = userName;
        this.rating = rating;
        this.reviewText = reviewText;
        this.item = item;
        this.created = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public WatchItem getItem() {
        return item;
    }

    public void setItem(WatchItem item) {
        this.item = item;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
