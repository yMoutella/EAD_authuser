package com.ead.authuser.dtos;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

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
    private String username;

    @JsonView(UserView.RegistrationPost.class)
    private String email;

    @JsonView({UserView.RegistrationPost.class, UserView.PutPassword.class})
    private String password;

    @JsonView({UserView.PutUser.class})
    private String oldPassword;

    @JsonView({UserView.RegistrationPost.class, UserView.PutUser.class})
    private String fullName;

    @JsonView({UserView.RegistrationPost.class, UserView.PutUser.class})
    private String phoneNumber;

    @JsonView({UserView.RegistrationPost.class, UserView.PutUser.class})
    private String cpf;

    @JsonView({UserView.RegistrationPost.class, UserView.PutImage.class})
    private String imageUrl;

}
