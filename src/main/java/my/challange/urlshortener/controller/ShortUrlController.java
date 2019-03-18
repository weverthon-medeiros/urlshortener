package my.challange.urlshortener.controller;

import my.challange.urlshortener.exception.ResourceNotFoundException;
import my.challange.urlshortener.model.LongUrl;
import my.challange.urlshortener.model.ShortUrl;
import my.challange.urlshortener.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

/**
 * @author weverthonmedeiros
 */
@RestController
@Validated
public class ShortUrlController {

    @Autowired
    ShortUrlService shortUrlService;

    Logger logger = LoggerFactory.getLogger(ShortUrlController.class);

    @PostMapping(name = "/shorten")
    public ShortUrl create(@Valid @RequestBody LongUrl longUrl) {
        return shortUrlService.create(longUrl);
    }

    @GetMapping(value = "/{shortCode}")
    public ResponseEntity<Object> redirect(@PathVariable String shortCode) throws ResourceNotFoundException {
        ShortUrl shortUrl = shortUrlService.getLongUrl(shortCode)
                .orElseThrow(() -> new ResourceNotFoundException("Url not found on ::" + shortCode));
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(shortUrl.getOriginalUrl()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
