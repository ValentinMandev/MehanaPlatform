package org.mehana.user.model.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class UserRegisterDto {

    @Size(min = 3, max = 20, message = "Username length should be between 3 and 20 characters")
    private String username;

    @Size(min = 3, max = 20, message = "Password length should be between 3 and 20 characters")
    private String password;

    @Size(min = 3, max = 20, message = "Password length should be between 3 and 20 characters")
    private String confirmPassword;

    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotEmpty(message = "First name should not be empty")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    @NotEmpty(message = "Phone number should not be empty")
    private String phoneNumber;

    @NotEmpty(message = "Address should not be empty")
    private String address;

    boolean passwordMatching;

    public static UserRegisterDto empty() {
        return new UserRegisterDto();
    }
}
