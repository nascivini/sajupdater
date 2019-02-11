/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sajupdater;

import databasePackage.DataBaseController;
import framePackage.Home;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import userSettingsPackage.UserSettingsController;

/**
 *
 * @author Vinícius Nascimento
 */
public class MainController {

    private Home homeScreen;
    private DataBaseController dataBaseController;
    private UserSettingsController userSettingsController;
    private int lengthOfActualTransfer;
    private String actualTransferingFileName;
    private File actualTransferingFile;

    public MainController() {
        this.homeScreen = new Home(this);
        this.dataBaseController = new DataBaseController(this);
        this.userSettingsController = new UserSettingsController(this);
        homeScreen.setVisible(true);
    }

    public Home getHomeScreen() {
        return homeScreen;
    }

    public DataBaseController getDataBaseController() {
        return dataBaseController;
    }

    public UserSettingsController getUserSettingsController() {
        return userSettingsController;
    }

    public void updateVersionFiles(String version, ArrayList<String> copyOperations) throws Exception {
        if (copyOperations.size() == 1) {
            if(!this.checkVersion(version, "fPG5")){
                JOptionPane.showMessageDialog(null, "Versão " + version + " não encontrada no O:", "Erro!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        } else if (copyOperations.size() > 1) {
            if(!this.checkVersion(version, "fSG5")){
                JOptionPane.showMessageDialog(null, "Versão " + version + " não encontrada no O:", "Erro!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        for (String actualFile : copyOperations) {
            File source;
            File dest;
            switch (actualFile) {
                case ("PG5"):
                    source = new File("O:\\saj\\versoes\\Interna\\fPG5\\PG5\\" + version + "\\Servidor\\pg5Servidor.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathServerPG5() + "\\pg5Servidor.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "pg5Servidor.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;

                    source = new File("O:\\saj\\versoes\\Interna\\fPG5\\PG5\\" + version + "\\sajpg5app.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathApllicationPG5() + "\\sajpg5app.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "sajpg5app.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;

                    break;

                case ("SG5"):
                    source = new File("O:\\saj\\versoes\\Interna\\fSG5\\SG5\\" + version + "\\Servidor\\sg5Servidor.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathServerSG5() + "\\sg5Servidor.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "sg5Servidor.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;

                    source = new File("O:\\saj\\versoes\\Interna\\fSG5\\SG5\\" + version + "\\sajsg5app.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathApllicationSG5() + "\\sajsg5app.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "sajsg5app.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;

                    break;

                case ("PROSG5"):
                    source = new File("O:\\saj\\versoes\\Interna\\fSG5\\PROSG5\\"+ version + "\\Servidor\\proservidor.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathServerPROSG5() + "\\proservidor.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "proservidor.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;

                    source = new File("O:\\saj\\versoes\\Interna\\fSG5\\PROSG5\\" + version + "\\sajprosg5app.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathApllicationPROSG5() + "\\sajprosg5app.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "sajprosg5app.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;

                    break;

                case ("ADMSG5"):
                    source = new File("O:\\saj\\versoes\\Interna\\fSG5\\ADMSG5\\" + version + "\\sg5admapp.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathApllicationADMSG5() + "\\sg5admapp.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "sg5admapp.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;

                    break;

                case ("INDSG5"):
                    source = new File("O:\\saj\\versoes\\Interna\\fSG5\\SG5\\" + version + "\\Servidor\\sg5indservidor.exe");
                    dest = new File(this.userSettingsController.getUserSettings().getPathServerINDSG5()+ "\\sg5indservidor.exe");
                    actualTransferingFile = source;
                    actualTransferingFileName = "sg5indservidor.exe";

                    homeScreen.getjProgressBar1().setIndeterminate(true);
                    homeScreen.getjLabel45().setText(actualTransferingFileName);

                    this.copyFileUsingStream(source, dest);
                    actualTransferingFile = null;

                    homeScreen.getjProgressBar1().setIndeterminate(false);
                    homeScreen.getjLabel45().setText(actualTransferingFileName + " copiado.");
                    actualTransferingFileName = null;
                    
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "Cópia dos arquivos da versão " + version + " finalizada.", "Sucesso", JOptionPane.PLAIN_MESSAGE);
        homeScreen.getjLabel45().setText("Aguardando ...");

    }

    public boolean checkVersion(String label, String familia) {
        File search = null;
        if(familia.equals("fPG5")){
            File file = new File("O:\\saj\\versoes\\interna\\" + familia + "\\PG5\\" + label + "\\sajpg5app.exe");
            search = file;
        }
        else if (familia.equals("fSG5")){
            File file = new File("O:\\saj\\versoes\\interna\\" + familia + "\\SG5\\" + label + "\\sajsg5app.exe");
            search = file;
        }
        if(search.exists()){
            return true;
        }
        return false;
    }

    private void copyFileUsingStream(File source, File dest) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest);
        FileChannel fcIn = fis.getChannel();
        FileChannel fcOut = fos.getChannel();
        //  Para arquivos muito grandes há problemas se usarmos transferFrom com o parâmetro &quot;count&quot; &gt; 2GB.
        // Portanto, iremos fazer a transferência &quot;em pedaços&quot;.
        long totalLength = source.length();
        int chunkSize = 8 * 1024 * 1024; // 8 MB de cada vez deve ser suficiente...
        long position = 0;
        long remainder = totalLength % chunkSize;
        long bytesLeft = totalLength;
        long totalWritten = 0;
        // Observe o caso do último bloco a ser escrito...
        final double mbytes_second = 1 / 1024.0 / 1024.0 * 1000.0;
        for (position = 0; position < totalLength; position += chunkSize) {
            long bytesToWrite = Math.min(bytesLeft, chunkSize);
            fcOut.transferFrom(fcIn, position, bytesToWrite);
            totalWritten = position + bytesToWrite;
            bytesLeft -= chunkSize;
            lengthOfActualTransfer = (int) bytesLeft;
        }
        fos.close();
        fis.close();
    }

    public int getLengthOfActualTransfer() {
        return lengthOfActualTransfer;
    }

    public String getActualTransferingFileName() {
        return actualTransferingFileName;
    }

    public File getActualTransferingFile() {
        return actualTransferingFile;
    }    

}