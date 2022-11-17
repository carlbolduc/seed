package seed.api;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Post {
    private long blogPostId;
    private String slug;
    private String titleEn;
    private String titleFr;
    private String descriptionEn;
    private String descriptionFr;
    private String contentEn;
    private String contentFr;
    private Integer publishedOn;

    public long getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(long blogPostId) {
        this.blogPostId = blogPostId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleFr() {
        return titleFr;
    }

    public void setTitleFr(String titleFr) {
        this.titleFr = titleFr;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionFr() {
        return descriptionFr;
    }

    public void setDescriptionFr(String descriptionFr) {
        this.descriptionFr = descriptionFr;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public String getContentFr() {
        return contentFr;
    }

    public void setContentFr(String contentFr) {
        this.contentFr = contentFr;
    }

    public Integer getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Integer publishedOn) {
        this.publishedOn = publishedOn;
    }

    @JsonIgnore
    public String getListPublishedOn() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(publishedOn, 0, ZoneOffset.UTC);
        return DATE_TIME_FORMATTER.format(dateTime);
    }

}
