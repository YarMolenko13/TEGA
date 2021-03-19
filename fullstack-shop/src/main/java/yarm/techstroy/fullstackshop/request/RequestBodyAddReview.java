package yarm.techstroy.fullstackshop.request;

public class RequestBodyAddReview {

    private String userName;
    private Integer rating;
    private String reviewText;
    private Long itemId;

    public RequestBodyAddReview(String userName, Integer rating, String reviewText, Long itemId) {
        this.userName = userName;
        this.rating = rating;
        this.reviewText = reviewText;
        this.itemId = itemId;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
