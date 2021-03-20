package com.pirtureuploader.pictureuploader.repo;


import com.pirtureuploader.pictureuploader.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
}
