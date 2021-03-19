package yarm.techstroy.fullstackshop.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class WatchItem {

    @Id
    @SequenceGenerator(
            name = "watch_sequence",
            sequenceName = "watch__sequence",
            allocationSize = 30
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "watch__sequence"
    )
    @Column(nullable = false)
    private Long id;
    private String title;
    private Integer price;
    private String imgPath;
    private String tag;

    public WatchItem() {

    }

    public WatchItem(String title, Integer price, String imgPath, String tag) {
        this.title = title;
        this.price = price;
        this.imgPath = imgPath;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
