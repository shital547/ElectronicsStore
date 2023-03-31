package com.bikkadit.electronicsstore.dtos;

import com.bikkadit.electronicsstore.validate.ImageNameValid;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {

      private String userId;

      @Size(min = 3,max = 20,message = "InvalidName! !")
      private String name;


      @Email(message = "Invalid User Email ! !")

     // @Pattern(regexp =  "^([a-z0-9][-a-z0-9._]+@([-a-z0-9]+)\\.)([a-z]{2,5})$ ",message = "Invalid User email")
      @NotBlank(message = "Email is required")
      private String email;

      @NotBlank(message = "Password is Required")
      private String password;

      @Size(min = 4,max = 6,message ="Invalid gender" )
      private String gender;

      @NotBlank(message = "Write something about yourself")
      private String about;

      @ImageNameValid
      private String imageName;

}


