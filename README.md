#URL Shortener
An API to short URLs. You can send a long URL and get a short link to it.

It was implemented using _SpringBoot_ and uses, by default, _Tomcat_.

##API
The API has two endpoints:

### 1. `/shorten` 
Create the short URL: 
```
curl -X POST http://localhost:8080/shorten -H 'Content-type:application/json' -d '{"url": "http://www.google.com"}'
```
The response:
```json
{
    "originalUrl": "http://www.google.com",
    "shortUrl": "http://localhost:8080/L"
}
```

### 2. `/{shortCode}`
Redirect to the original URL used to create this link
```
curl -i http://localhost:8080/L
```
Will redirect to the original URL:
```
HTTP/1.1 301 
Location: http://www.google.com
Content-Length: 0
Date: Mon, 18 Mar 2019 15:56:55 GMT
```

If the short url informed does not exist it will return a *404 Not Found*.


##Settings
The domain can be set in `resources/application.properties`:
```properties
# Domain property
shortUrl.domain=http://localhost:8080
```

## Run the application

### Build the application:

```
mvn clean install
```

### Start the server

```
mvn spring-boot:run
```

The server will be started on port `8080`.

### Docker
This project uses `docker-maven-plugin` by _Spotify_.

To generate the image:

```
mvn clean package docker:build
```


