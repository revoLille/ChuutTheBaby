package com.example.Pierre.myapplication.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Pierre on 04/06/2016.
 */
public class AccessDB {

    private final static String dbDriver = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost/chat";
    private final static String login = "root";
    private final static String pwd = "pierre";

    private final static Logger LOG = LogManager.getLogger();

    private Connection connection = null ;

    public boolean connect(){

        try {
            Class.forName(dbDriver).newInstance();
            connection = DriverManager.getConnection(url, login, pwd);
            LOG.trace("--- La connection a été demandée ---");
        } catch (InstantiationException e) {
            LOG.warn("--- La connection s'est mal passée ---", e);
            return false;
        } catch (IllegalAccessException e) {
            LOG.warn("--- La connection s'est mal passée ---", e);
            return false;
        } catch (ClassNotFoundException e) {
            LOG.warn("--- La connection s'est mal passée ---", e);
            return false;
        } catch (SQLException e) {
            LOG.warn("--- La connection s'est mal passée ---", e);
            return false;
        }
        LOG.trace("--- La connection a été établie ---");
        return true;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                LOG.trace("--- La connection a été fermée ---");
            } catch (SQLException e) {
                LOG.error("--- La connection n'a pas été refermée ---", e);
            }
        }
    }

}
