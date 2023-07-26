package com.TechBlog.blogappapis.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
 //  @NotEmpty
    private String EmployeeName;
 //  @Email(message = "email should not be empty")
    private String Email;

  // @NotEmpty
    private String ReportsTo;
   private String ProfileImage;
   private String PhoneNumber;
}
