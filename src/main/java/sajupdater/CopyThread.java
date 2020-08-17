/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sajupdater;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class CopyThread extends Thread {

    private MainController mainController;
    private String label;
    private ArrayList<String> copyOperations;

    public CopyThread(MainController mainController, String label, ArrayList<String> copyOperations) {
        super();
        this.mainController = mainController;
        this.label = label;
        this.copyOperations = copyOperations;
        start();
    }

    @Override
    public void run() {
        this.solicitarCopia();
    }

    public void solicitarCopia() {
        try {
            mainController.getHomeScreen().getjButton1().setEnabled(false);
            mainController.updateVersionFiles(label, copyOperations);
            mainController.getHomeScreen().getjLabel45().setText("Aguardando ...");
            mainController.getHomeScreen().getjProgressBar1().setIndeterminate(false);
        } catch (Exception ex) {
            if(ex != null){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);   
            }
            mainController.getHomeScreen().getjLabel45().setText("Aguardando ...");
            mainController.getHomeScreen().getjProgressBar1().setIndeterminate(false);
        }
        mainController.getHomeScreen().getjButton1().setEnabled(true);
        interrupt();
    }

}
