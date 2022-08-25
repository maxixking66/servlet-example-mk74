package com.maktabsharif74.servlet.domain;

import com.maktabsharif74.servlet.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "user_tbl";
    public static final String FIRSTNAME = "first_name";
    public static final String LASTNAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Column(name = FIRSTNAME)
    private String firstName;

    @Column(name = LASTNAME)
    private String lastName;

    @Column(name = USERNAME, unique = true, nullable = false)
    private String username;

    @Column(name = PASSWORD, nullable = false)
    private String password;
}
