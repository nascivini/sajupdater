/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userSettingsPackage;

import java.io.Serializable;

/**
 *
 * @author Vinicius Nascimento
 */
public class UserSettingsEntity implements Serializable {
    private String user;
    private String password;
    private String pathServerSG5;
    private String pathApllicationSG5;
    private String pathServerPG5;
    private String pathApllicationPG5;
    private String pathServerPROSG5;
    private String pathApllicationPROSG5;
    private String pathApllicationADMSG5;
    private String pathServerINDSG5;

    public UserSettingsEntity(String user, String password, String pathServerSG5, String pathApllicationSG5, String pathServerPG5, String pathApllicationPG5, String pathServerPROSG5, String pathApllicationPROSG5, String pathApllicationADMSG5, String pathServerINDSG5) {
        this.user = user;
        this.password = password;
        this.pathServerSG5 = pathServerSG5;
        this.pathApllicationSG5 = pathApllicationSG5;
        this.pathServerPG5 = pathServerPG5;
        this.pathApllicationPG5 = pathApllicationPG5;
        this.pathServerPROSG5 = pathServerPROSG5;
        this.pathApllicationPROSG5 = pathApllicationPROSG5;
        this.pathApllicationADMSG5 = pathApllicationADMSG5;
        this.pathServerINDSG5 = pathServerINDSG5;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPathServerSG5() {
        return pathServerSG5;
    }

    public void setPathServerSG5(String pathServerSG5) {
        this.pathServerSG5 = pathServerSG5;
    }

    public String getPathApllicationSG5() {
        return pathApllicationSG5;
    }

    public void setPathApllicationSG5(String pathApllicationSG5) {
        this.pathApllicationSG5 = pathApllicationSG5;
    }

    public String getPathServerPG5() {
        return pathServerPG5;
    }

    public void setPathServerPG5(String pathServerPG5) {
        this.pathServerPG5 = pathServerPG5;
    }

    public String getPathApllicationPG5() {
        return pathApllicationPG5;
    }

    public void setPathApllicationPG5(String pathApllicationPG5) {
        this.pathApllicationPG5 = pathApllicationPG5;
    }

    public String getPathServerPROSG5() {
        return pathServerPROSG5;
    }

    public void setPathServerPROSG5(String pathServerPROSG5) {
        this.pathServerPROSG5 = pathServerPROSG5;
    }

    public String getPathApllicationPROSG5() {
        return pathApllicationPROSG5;
    }

    public void setPathApllicationPROSG5(String pathApllicationPROSG5) {
        this.pathApllicationPROSG5 = pathApllicationPROSG5;
    }

    public String getPathApllicationADMSG5() {
        return pathApllicationADMSG5;
    }

    public void setPathApllicationADMSG5(String pathApllicationADMSG5) {
        this.pathApllicationADMSG5 = pathApllicationADMSG5;
    }

    public String getPathServerINDSG5() {
        return pathServerINDSG5;
    }

    public void setPathServerINDSG5(String pathServerINDSG5) {
        this.pathServerINDSG5 = pathServerINDSG5;
    }
    
    
}
