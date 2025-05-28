package io.goflights.messenger.dto;

public record CustomerDetailsDTO(Long accountNumber, String firstName, String lastName, String email, String mobileNumber) {
}
