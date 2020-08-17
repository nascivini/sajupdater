/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasePackage;

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
public class DataBaseDAO implements Serializable {

    private ArrayList<DataBaseEntity> cache;
    private String fileName;

    public DataBaseDAO() {
        this.fileName = "databases.dat";
        this.cache = new ArrayList<DataBaseEntity>();
    }

    public void put(DataBaseEntity base) {
        cache.add(base);
        this.persist();
    }

    public ArrayList<DataBaseEntity> getList() {
        this.load();
        return cache;
    }

    public void remove() {
        this.cache.clear();
        this.persist();
    }
    
    public void delete(int index){
        this.cache.remove(index);
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
            Logger.getLogger(DataBaseEntity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataBaseEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void load() {

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream oo = new ObjectInputStream(fis);

            cache = (ArrayList<DataBaseEntity>) oo.readObject();

            oo.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Ainda não há bases cadastradas.");
        } catch (IOException ex) {
            Logger.getLogger(DataBaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseEntity.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
