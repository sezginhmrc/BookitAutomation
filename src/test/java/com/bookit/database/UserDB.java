package com.bookit.database;

// in this package We store claases with a methods that are needed to interact with a database.
// for database interaction we will have classes based on components
// for database interaction
// create classes based on components

import com.bookit.utilities.DBUtility;

import java.sql.ResultSet;

public class UserDB {

    /**
     * If count equals to 1 - users exist
     *
     * @param email of user to look up
     * @return true, if user exist
     */
    public boolean checkIfUserExistInDB(String email) {
        // it checks if user exits, if results greater 0 user is exits
        // based on their email we verify user existing.
        String query = "SELECT COUNT(*) FROM users WHERE email = '" + email + "'";
        System.out.println("QUERY :: " + query);
        DBUtility.getQueryResultList(query);
        long countOfUsers = (Long) DBUtility.getCellValue(query);
        return countOfUsers == 1;
        // if count equals to 1 user exits.
        /*This Valudation can be checked in UI as well.*/

    }



}



