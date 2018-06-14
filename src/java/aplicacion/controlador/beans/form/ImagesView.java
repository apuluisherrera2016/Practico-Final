/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Luis
 */
@ManagedBean
@ViewScoped
public class ImagesView {

    /**
     * Creates a new instance of ImagesView
     */
    public ImagesView() {
    }
     private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add( i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}

