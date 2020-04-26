package com.user.userinfo.repository;

import com.user.userinfo.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {



    Optional<UserData> findByEmail(String email);

    Optional<UserData> findById(long id);

    @Query("SELECT user FROM UserData user  WHERE user.email=(:email) AND user.password= (:password)")
    UserData findByEmailAndPassword(@Param("email") String email, @Param("password") String password);


}
