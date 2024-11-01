package me.simplebank.dto;

import me.simplebank.domain.model.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstname, String lastname, String document, BigDecimal balance, UserType userType, String email, String password) {
}
