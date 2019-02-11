/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

import sajupdater.MainController;

/**
 *
 * @author Vinicius Nascimento
 */
public class DataBaseController {
    private MainController mainController;

    public DataBaseController(MainController mainController) {
        this.mainController = mainController;
    }

    public MainController getMainController() {
        return mainController;
    }
    
}
