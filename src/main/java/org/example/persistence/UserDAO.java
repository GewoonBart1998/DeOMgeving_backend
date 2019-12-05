package org.example.persistence;

import org.example.model.LoginCredentials;
import org.example.model.RegisterCredentials;
import org.example.model.User;
import org.example.persistence.mapper.UserTypeMapper;
import org.example.resource.RegisterResource;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserTypeMapper.class)
public interface UserDAO {

    @SqlQuery("SELECT * FROM user WHERE email = :email AND password = :password")
    @Mapper(UserTypeMapper.class)
    public User findUserByLoginCredentials(@BindBean LoginCredentials login);

    @SqlUpdate("INSERT INTO user (email, password, name) " +
            "VALUES (:email, :password, :name)")
    public void create(@BindBean RegisterCredentials newUser);

    @SqlUpdate("UPDATE user SET password_reset_token = :token WHERE email = :email")
    public void setToken(@Bind("email") String email, @Bind("token") String token);

}
