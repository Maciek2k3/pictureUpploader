package com.pirtureuploader.pictureuploader.Gui;

import com.pirtureuploader.pictureuploader.ImageUploader;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("uppload")
public class UpploadGui extends VerticalLayout {
    private ImageUploader imageUploader;

    public UpploadGui(ImageUploader imageUploader) {
        this.imageUploader = imageUploader;

        Label label=new Label();
        TextField textField=new TextField();
        Button button=new Button();
        button.setText("upload");
        button.addClickListener(buttonClickEvent ->
        {
            String uploadedImage = imageUploader.uploadFileAndSaveToDb(textField.getValue());
            Image image = new Image(uploadedImage, "no picture");
            label.setText("succesfull upload picture");
            add(label);
            add(image);

        });

        add(textField);
        add(button);

    }
}
