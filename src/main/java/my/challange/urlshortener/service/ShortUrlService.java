package my.challange.urlshortener.service;

import my.challange.urlshortener.model.LongUrl;
import my.challange.urlshortener.model.ShortUrl;
import my.challange.urlshortener.repository.ShortUrlRepository;
import my.challange.urlshortener.util.ShortUrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author weverthonmedeiros
 */
@Service
public class ShortUrlService {
    @Autowired
    ShortUrlRepository shortUrlRepository;

    @Value("${shortUrl.domain}")
    private String domain;

    private static final String URL_FORMAT = "%s/%s";

    public ShortUrl create(LongUrl longUrl) {
        ShortUrl shortUrl = new ShortUrl(longUrl.getUrl());
        shortUrl = shortUrlRepository.save(shortUrl);
        shortUrl.setShortUrl(String.format(URL_FORMAT, domain, ShortUrlUtils.encode(shortUrl.getId())));
        return shortUrl;
    }

    public Optional<ShortUrl> getLongUrl(String shortCode) {
        return shortUrlRepository.findById(ShortUrlUtils.decode(shortCode));
    }
}
