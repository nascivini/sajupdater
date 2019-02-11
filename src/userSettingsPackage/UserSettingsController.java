/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userSettingsPackage;

import java.util.ArrayList;
import sajupdater.MainController;

/**
 *
 * @author Vinicius Nascimento
 */
public class UserSettingsController {

    private MainController mainController;
    private UserSettingsDAO userSettingsDAO;
    private ArrayList<UserSettingsEntity> cacheUserSettings;

    public UserSettingsController(MainController mainController) {
        this.mainController = mainController;
        this.userSettingsDAO = new UserSettingsDAO();
        this.cacheUserSettings = userSettingsDAO.getList();
    }

    public MainController getMainController() {
        return mainController;
    }

    public boolean insertSettings(UserSettingsEntity userSettings) {
        try {
            this.userSettingsDAO.put(userSettings);
            this.refreshUserSettings();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public void refreshUserSettings(){
        this.cacheUserSettings = this.userSettingsDAO.getList();
    }
    
    public UserSettingsEntity getUserSettings(){
        this.refreshUserSettings();
        return this.cacheUserSettings.get(0);
    }
}
