/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linbrox.uploadfile.service;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.linbrox.uploadfile.util.Result;
import com.linbrox.uploadfile.util.SUserInfo;
import java.io.ByteArrayInputStream;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author zepolar
 */
@Stateless
public class XMLFile {
    
    private static final Logger LOGGER = Logger.getLogger(XMLFile.class.getName());
    
    @Asynchronous
    public Future<Result> loadFile(String nameFile, byte[] contentFile){
        Result resultadoObj;
        try {            
            JSch jsch = new JSch();
            String password = "ralopez";
            Session session = jsch.getSession("ralopez", "localhost", 22);
            
            UserInfo ui = new SUserInfo(password, null);
            session.setUserInfo(ui);
            session.setPassword(password);
            session.connect();
           
            ByteArrayInputStream srcFile;
            ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");

            sftp.connect();
            
            //Array de bytes
            srcFile = new ByteArrayInputStream(contentFile);
            sftp.put(srcFile, nameFile, ChannelSftp.APPEND);
            
            sftp.exit();
            sftp.disconnect();
            session.disconnect();
            
            resultadoObj = new Result();
            resultadoObj.setState(Boolean.TRUE);
            resultadoObj.setMessage("OK");
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            resultadoObj  = new Result();
            resultadoObj.setState(Boolean.FALSE);
            resultadoObj.setMessage("ERROR");
        }
        
        return new AsyncResult<Result>(resultadoObj);
    }
    
    
}
