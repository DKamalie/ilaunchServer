package com.Ilaunch.Ilaunch.controller;

import com.Ilaunch.Ilaunch.domain.User;
import com.Ilaunch.Ilaunch.factory.UserFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    private static User user = UserFactory.buildUser("Basil", "Brooks", "basook", "basilbrooks@gmail.com", true, "Administrator");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8081/user";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        user = postResponse.getBody();
        System.out.println("Saved data: " + user);
        assertEquals(user.getUserId(), postResponse.getBody().getUserId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertEquals(user.getUserId(), response.getBody().getUserId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        User updated = new User.Builder().copy(user).setName("Controller Updated Name").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<User> response = restTemplate.postForEntity(url, updated, User.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_getall() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + user.getUserId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }



}
