/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linbrox.uploadfile.controller;

import com.linbrox.uploadfile.service.XMLFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author zepolar
 */
@ManagedBean
@RequestScoped
public class LoadFileController {
    
    private static final Logger LOGGER = Logger.getLogger(LoadFileController.class.getName());
    
    @EJB
    private XMLFile xmlFile;
    
    public void loadFile(FileUploadEvent fileEvent){
        try{
            String fileName = fileEvent.getFile().getFileName();
            byte[] fileContent = fileEvent.getFile().getContents();
            xmlFile.loadFile(fileName, fileContent);
        }
        catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
    
    
}
