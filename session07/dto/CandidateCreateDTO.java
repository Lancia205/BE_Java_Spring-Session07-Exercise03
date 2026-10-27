
package com.example.session07.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateCreateDTO {

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 5, max = 50, message = "Họ tên phải từ 5 đến 50 ký tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private Integer age;

    @NotNull(message = "Kinh nghiệm không được để trống")
    @Min(value = 0, message = "Số năm kinh nghiệm không được âm")
    private Integer yearsOfExperience;
}
