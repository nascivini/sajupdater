/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

/**
 *
 * @author Vinicius Nascimento
 */
public class DataBaseEntity {
    private String family;
    private String mainAlias;
    private String aliasNET;
    private String aliasIND;

    public DataBaseEntity(String family, String mainAlias, String aliasNET, String aliasIND) {
        this.family = family;
        this.mainAlias = mainAlias;
        this.aliasNET = aliasNET;
        this.aliasIND = aliasIND;
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
    
    
}
