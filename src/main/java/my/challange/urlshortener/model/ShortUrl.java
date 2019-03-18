package my.challange.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @author weverthonmedeiros
 */
@Entity
@Table(name = "short_url")
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Integer id;

    @Column(name = "original_url", nullable = false)
    private String originalUrl;

    @Transient
    private String shortUrl;

    /**
     * Default constructor no implementation is needed.
     */
    public ShortUrl() {
    }

    public ShortUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "ShortUrl{id="+ id + '\''
                + ", originalUrl='" + originalUrl + '\''
                + ", token='"+ shortUrl + '\''
                + '}';
    }
}
