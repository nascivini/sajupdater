/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import sajupdater.MainController;

/**
 *
 * @author Vinicius Nascimento
 */
public class DataBaseController {

    private MainController mainController;
    private DataBaseDAO databaseDAO;
    private ArrayList<DataBaseEntity> cacheDatabases;

    public DataBaseController(MainController mainController) {
        this.mainController = mainController;
        this.databaseDAO = new DataBaseDAO();
        this.refreshDatabases();
    }

    public MainController getMainController() {
        return mainController;
    }

    public boolean insertDatabase(DataBaseEntity database) {
        try {
            this.databaseDAO.put(database);
            this.refreshDatabases();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void refreshDatabases() {
        this.cacheDatabases = databaseDAO.getList();
    }

    public DefaultTableModel getDatabases() {
        DefaultTableModel table = new DefaultTableModel();
        this.refreshDatabases();
        ArrayList<DataBaseEntity> bases = cacheDatabases;

        String colunas[] = {"Nome", "Família", "Servidor / Endereço"};
        table.setColumnIdentifiers(colunas);
        for (int i = 0; i < bases.size(); i++) {
            String dados[] = {bases.get(i).getName(), bases.get(i).getFamily(), bases.get(i).getServerOrAdress()};
            table.addRow(dados);
        }
        return table;
    }

    public DefaultTableModel getDatabasesPG() {
        DefaultTableModel table = new DefaultTableModel();
        this.refreshDatabases();
        ArrayList<DataBaseEntity> bases = cacheDatabases;

        String colunas[] = {"Nome", "Servidor / Endereço", "Alias Principal"};
        table.setColumnIdentifiers(colunas);
        for (int i = 0; i < bases.size(); i++) {
            if (bases.get(i).getFamily().equals("PG5") && bases.size() > 0) {
                String dados[] = {bases.get(i).getName(), bases.get(i).getServerOrAdress(), bases.get(i).getMainAlias()};
                table.addRow(dados);
            }
        }
        return table;
    }

    public DefaultTableModel getDatabasesSG() {
        DefaultTableModel table = new DefaultTableModel();
        this.refreshDatabases();
        ArrayList<DataBaseEntity> bases = cacheDatabases;

        String colunas[] = {"Nome", "Servidor / Endereço", "Alias Principal"};
        table.setColumnIdentifiers(colunas);
        for (int i = 0; i < bases.size(); i++) {
            if (bases.get(i).getFamily().equals("SG5") && bases.size() > 0) {
                String dados[] = {bases.get(i).getName(), bases.get(i).getServerOrAdress(), bases.get(i).getMainAlias()};
                table.addRow(dados);
            }
        }
        return table;
    }

    public DataBaseEntity getDatabase(int index) {
        this.refreshDatabases();
        return this.cacheDatabases.get(index);
    }
    
    public DataBaseEntity findDatabase(String mainAlias, String server){
        DataBaseEntity back = null;
        for (DataBaseEntity database : cacheDatabases){
            if(database.getMainAlias().equals(mainAlias) && database.getServerOrAdress().equals(server)){
                back = database;
                break;
            }
        }
        return back;
    }
    
    public int getIndexOfDatabase(DataBaseEntity base){
        return cacheDatabases.indexOf(base);
    }

    public String remove(int index) {
        try {
            this.databaseDAO.delete(index);
            this.refreshDatabases();
            return "Base removida com sucesso.";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

}
