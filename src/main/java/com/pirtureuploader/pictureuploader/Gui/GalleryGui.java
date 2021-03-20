package com.pirtureuploader.pictureuploader.Gui;

import com.pirtureuploader.pictureuploader.ImageUploader;
import com.pirtureuploader.pictureuploader.model.Image;
import com.pirtureuploader.pictureuploader.repo.ImageRepo;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route("gallery")
public class GalleryGui extends VerticalLayout {

    private ImageRepo imageRepo;


    public GalleryGui(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
        List<Image> all=imageRepo.findAll();
        all.stream().forEach(element-> {
            com.vaadin.flow.component.html.Image image =
                    new com.vaadin.flow.component.html.Image(element.getImageAdress(), "empty");
            add(image);
        });
    }
}

