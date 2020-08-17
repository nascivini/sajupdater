/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

import java.io.Serializable;

/**
 *
 * @author Vinicius Nascimento
 */
public class DataBaseEntity implements Serializable{
    
    private String name;
    private String family;
    private String mainAlias;
    private String aliasNET;
    private String aliasIND;
    private String type;
    private String serverOrAdress;

    public DataBaseEntity(String name, String family, String mainAlias, String aliasNET, String aliasIND, String type, String serverOrAdress) {
        this.name = name;
        this.family = family;
        this.mainAlias = mainAlias;
        this.aliasNET = aliasNET;
        this.aliasIND = aliasIND;
        this.type = type;
        this.serverOrAdress = serverOrAdress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getMainAlias() {
        return mainAlias;
    }

    public void setMainAlias(String mainAlias) {
        this.mainAlias = mainAlias;
    }

    public String getAliasNET() {
        return aliasNET;
    }

    public void setAliasNET(String aliasNET) {
        this.aliasNET = aliasNET;
    }

    public String getAliasIND() {
        return aliasIND;
    }

    public void setAliasIND(String aliasIND) {
        this.aliasIND = aliasIND;
    }

    public String getServerOrAdress() {
        return serverOrAdress;
    }

    public void setServerOrAdress(String serverOrAdress) {
        this.serverOrAdress = serverOrAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    

}
