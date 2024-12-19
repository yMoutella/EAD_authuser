package com.ead.authuser.dtos;

import java.util.UUID;

import com.ead.authuser.validation.UsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserView{
        public static interface RegistrationPost{}
        public static interface PutPassword{}
        public static interface PutUser{}
        public static interface PutImage{}
    }

    private UUID userId;

    @JsonView({UserView.RegistrationPost.class})
    @Size(min=4, max=6)
    @UsernameConstraint(groups = UserView.RegistrationPost.class)
    private String username;

    @NotBlank(message = "email must not be null!", groups = UserView.RegistrationPost.class)
    @Email
    @JsonView(UserView.RegistrationPost.class)
    private String email;

    @NotBlank(message = "password must not be null!", groups = {UserView.PutPassword.class, UserView.RegistrationPost.class})
    @Size(min = 6, max = 20, groups = {UserView.PutPassword.class, UserView.RegistrationPost.class})
    @JsonView({UserView.RegistrationPost.class, UserView.PutPassword.class})
    private String password;

    @JsonView({UserView.PutUser.class})
    private String oldPassword;

    @NotBlank
    @Size(min=4, max=6)
    @JsonView({UserView.RegistrationPost.class, UserView.PutUser.class})
    private String fullName;

    @NotBlank
    @JsonView({UserView.RegistrationPost.class, UserView.PutUser.class})
    private String phoneNumber;
    
    @NotBlank(groups = {UserView.RegistrationPost.class, UserView.PutUser.class})
    @JsonView({UserView.RegistrationPost.class, UserView.PutUser.class})
    private String cpf;

    @NotBlank(groups = {UserView.PutImage.class})
    @JsonView({UserView.RegistrationPost.class, UserView.PutImage.class})
    private String imageUrl;

}
