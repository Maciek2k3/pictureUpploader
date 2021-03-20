package com.pirtureuploader.pictureuploader.repo;

import com.pirtureuploader.pictureuploader.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<ApiUser,Long> {
  //ApiUser findByUsername(String username);

  @Override
  <S extends ApiUser> S save(S s);

  ApiUser findApiUserByUserName(String  username);


}
