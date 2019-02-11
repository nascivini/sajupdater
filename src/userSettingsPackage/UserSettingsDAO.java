/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userSettingsPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinicius Nascimento
 */
public class UserSettingsDAO implements Serializable {

    private ArrayList<UserSettingsEntity> cache;
    private String fileName;

    public UserSettingsDAO() {
        this.fileName = "userSettings.dat";
        this.cache = new ArrayList<UserSettingsEntity>();
    }

    public void put(UserSettingsEntity base) {
        this.remove();
        cache.add(base);
        this.persist();
    }

    public ArrayList<UserSettingsEntity> getList() {
        this.load();
        return cache;
    }

    public void remove() {
        this.cache.clear();
        this.persist();
    }

    public void persist() {

        try {
            FileOutputStream fout = new FileOutputStream(this.fileName);
            ObjectOutputStream oo = new ObjectOutputStream(fout);

            oo.writeObject(cache);

            oo.flush();
            fout.flush();

            oo.close();
            fout.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserSettingsEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserSettingsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void load() {

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream oo = new ObjectInputStream(fis);

            cache = (ArrayList<UserSettingsEntity>) oo.readObject();

            oo.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Ainda não há bases cadastradas.");
        } catch (IOException ex) {
            Logger.getLogger(UserSettingsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserSettingsEntity.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
