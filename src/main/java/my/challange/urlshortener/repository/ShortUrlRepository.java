package my.challange.urlshortener.repository;

import my.challange.urlshortener.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author weverthonmedeiros
 */
@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer> {
}
