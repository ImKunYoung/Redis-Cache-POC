package com.poc.redis.application.dto;

import com.poc.redis.domain.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO representing a user, with only the public attributes.
 */
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String login;

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
    }
}
