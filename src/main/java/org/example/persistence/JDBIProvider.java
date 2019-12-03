package org.example.persistence;

import org.skife.jdbi.v2.DBI;

public class JDBIProvider {

    private static JDBIProvider instance;
    private DBI dbi;

    public <T> T provide(T dao) {
        System.out.println(dbi);
        return dao;
    }

    public static JDBIProvider getInstance() {
        System.out.println("constructed");
        if (instance == null)
            instance = new JDBIProvider();

        return instance;
    }


    public void setDBI(DBI dbi) {
        this.dbi = dbi;
    }

}
