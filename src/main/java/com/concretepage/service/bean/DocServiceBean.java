package com.concretepage.service.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.concretepage.model.Doc;
import com.concretepage.service.DocService;

public class DocServiceBean implements DocService {

    @Autowired
    DataSource dataSource;

    @Override
    public void updateDocument(Doc doca) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteDocument(Doc doca) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Doc> searchDoc(Doc doca) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT * from DBUSER";

        try {
            dbConnection = dataSource.getConnection();
            statement = dbConnection.createStatement();

            System.out.println(selectTableSQL);

            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {

                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
        return null;
    }

}
