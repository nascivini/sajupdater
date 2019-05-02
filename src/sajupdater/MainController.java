/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sajupdater;

import databasePackage.DataBaseController;
import databasePackage.DataBaseEntity;
import framePackage.Home;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.ini4j.Wini;
import userSettingsPackage.UserSettingsController;
import userSettingsPackage.UserSettingsEntity;

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
            if (!this.checkVersion(version, "fPG5")) {
                JOptionPane.showMessageDialog(null, "Versão " + version + " não encontrada no O:", "Erro!", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } else if (copyOperations.size() > 1) {
            if (!this.checkVersion(version, "fSG5")) {
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
                    source = new File("O:\\saj\\versoes\\Interna\\fSG5\\PROSG5\\" + version + "\\Servidor\\proservidor.exe");
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
                    dest = new File(this.userSettingsController.getUserSettings().getPathServerINDSG5() + "\\sg5indservidor.exe");
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
        if (familia.equals("fPG5")) {
            File file = new File("O:\\saj\\versoes\\interna\\" + familia + "\\PG5\\" + label + "\\sajpg5app.exe");
            search = file;
        } else if (familia.equals("fSG5")) {
            File file = new File("O:\\saj\\versoes\\interna\\" + familia + "\\SG5\\" + label + "\\sajsg5app.exe");
            search = file;
        }
        if (search.exists()) {
            return true;
        }
        return false;
    }

    private void copyFileUsingStream(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
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

    public String updateIni(int index) {
        try {
            DataBaseEntity database = this.getDataBaseController().getDatabase(index);
            String familia = database.getFamily();
            UserSettingsEntity userSettings = this.getUserSettingsController().getUserSettings();

            if (familia.equals("PG5")) {
                File filePG = new File(userSettings.getPathServerPG5() + "\\spcfg.ini");
                Wini ini = new Wini(filePG);

                ini.put("Database", "Alias", database.getMainAlias());
                ini.put("Database", "Server", database.getServerOrAdress());
                ini.put("Database", "TipoBanco", database.getType());
                ini.store();
            } else {
                File fileSG = new File(userSettings.getPathServerSG5() + "\\spcfg.ini");
                File fileNET = new File(userSettings.getPathServerPROSG5() + "\\spcfg.ini");
                File fileIND = new File(userSettings.getPathServerINDSG5() + "\\spcfg.ini");
                Wini ini = new Wini(fileSG);

                ini.put("Database", "Alias", database.getMainAlias());
                ini.put("Database", "Server", database.getServerOrAdress());
                ini.put("Database", "TipoBanco", database.getType());
                ini.store();

                ini = new Wini(fileNET);
                ini.put("Database", "Alias", database.getAliasNET());
                ini.put("Database", "Server", database.getServerOrAdress());
                ini.put("Database", "TipoBanco", database.getType());
                ini.store();

                ini = new Wini(fileIND);
                ini.put("Database", "Alias", database.getAliasIND());
                ini.put("Database", "Server", database.getServerOrAdress());
                ini.put("Database", "TipoBanco", database.getType());
                ini.store();
            }
            return "Dados Atualizados!";
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }

    public String updateIntegrationIni(String aliasPG, String aliasSG) {
        DataBaseEntity PG = this.getDataBaseController().findDatabase(aliasPG);
        DataBaseEntity SG = this.getDataBaseController().findDatabase(aliasSG);
        int indexPG = this.getDataBaseController().getIndexOfDatabase(PG);
        int indexSG = this.getDataBaseController().getIndexOfDatabase(SG);
        String result = "Os dados relativos aos inis dos servidores (Database) foram atualizados com sucesso.";
        try {
            this.updateIni(indexPG);
            this.updateIni(indexSG);
        } catch (Exception e) {
            result = "Não foi possível atualizar os ambientes de integração. Motivo: " + e.getMessage();
        }
        return result;
    }

    public boolean updateBalancer(String key, String aliasPG5, String aliasSG5) throws IOException {
        File appPG5 = new File(this.getUserSettingsController().getUserSettings().getPathApllicationPG5() + "\\spcfg.ini");
        File appSG5 = new File(this.getUserSettingsController().getUserSettings().getPathApllicationSG5() + "\\spcfg.ini");
        File srvPG5 = new File(this.getUserSettingsController().getUserSettings().getPathServerPG5() + "\\spcfg.ini");
        File srvSG5 = new File(this.getUserSettingsController().getUserSettings().getPathServerSG5() + "\\spcfg.ini");
        Wini ini = null;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case (0):
                    ini = new Wini(appPG5);
                    break;
                case (1):
                    ini = new Wini(appSG5);
                    break;
                case (2):
                    ini = new Wini(srvPG5);
                    break;
                case (3):
                    ini = new Wini(srvSG5);
                    break;
            }

            ini.remove("BalanceadorAlternativo");
            ini.put("BalanceadorAlternativo", "Chave", key);
            ini.put("BalanceadorAlternativo", aliasPG5, "fpgServidor.fpgServidorDM;PG5SERVIDOR.EXE;{42A9E80A-670D-459D-B20E-E41F9B3AD880};127.0.0.1;");
            ini.put("BalanceadorAlternativo", aliasSG5, "sg5Servidor.fsgServidorDM;SG5SERVIDOR.EXE;{F67F7610-BDB7-4258-9B13-003C19084FDC};127.0.0.1;");
            ini.store();
        }
        return true;
    }

    public String getAliasDatabase(int index) {
        String alias = null;
        try {
            alias = this.getDataBaseController().getDatabase(index).getMainAlias();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        return alias;
    }

    public String manageWindowsService(String serviceName, String operationType) throws IOException {
        String userName = this.getUserSettingsController().getUserSettings().getUser();
        String password = this.getUserSettingsController().getUserSettings().getPassword();
        String retorno = null;

        switch (operationType) {
            case ("reboot"):
                String resposta = null;
                String commands = "cmd.exe net stop " + serviceName;
                Runtime.getRuntime().exec(commands);
                commands = "cmd.exe net start " + serviceName;
                Runtime.getRuntime().exec(commands);
                JOptionPane.showMessageDialog(null, "O serviço está sendo reiniciado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                retorno = resposta;
                break;
            case ("stop"):
                resposta = null;
                commands = "cmd.exe net stop " + serviceName;
                Runtime.getRuntime().exec(commands);
                JOptionPane.showMessageDialog(null, "O serviço está sendo reiniciado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                retorno = resposta;
                break;

            case ("start"):
                resposta = null;
                commands = "cmd.exe net start " + serviceName;
                Runtime.getRuntime().exec(commands);
                JOptionPane.showMessageDialog(null, "O serviço está sendo reiniciado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                retorno = resposta;
                break;
        }
        return retorno;
    }
}
