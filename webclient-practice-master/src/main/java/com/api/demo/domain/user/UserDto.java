package com.api.demo.domain.user;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/***
 * https://jsonplaceholder.typicode.com/users
 * sample data를 활용하기 위한 dto
 */
@Getter
@ToString
@NoArgsConstructor
public class UserDto implements Serializable{

    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    @Builder
    public UserDto(Long id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
