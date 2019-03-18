package my.challange.urlshortener.model;

import org.hibernate.validator.constraints.URL;

/**
 * @author weverthonmedeiros
 */
public class LongUrl {

    @URL
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
