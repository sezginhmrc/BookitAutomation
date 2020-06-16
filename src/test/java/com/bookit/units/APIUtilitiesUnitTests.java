package com.bookit.units;

import com.bookit.utilities.APIUtilities;
import com.bookit.utilities.DBUtility;
import com.bookit.utilities.Environment;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class with unit tests for APIUtilities class
 * Here we ensure that utilities work fine before using hem in action
 * * This is our unit testing for our framework not DEVS..
 * * to make sure our code works well
 *  */

public class APIUtilitiesUnitTests {


    @Test
    public void getTokenTest(){
        String token = APIUtilities.getToken();
        String tokenForStudent = APIUtilities.getToken("student");
        String tokenForTeacher = APIUtilities.getToken("teacher");

        Assert.assertNotNull(token);
        Assert.assertNotNull(tokenForStudent);
        Assert.assertNotNull(tokenForTeacher);
    }

    @Test
    public void testIfUserExists(){

        // NEGARIVE TEST if user exits or not
        int actual = APIUtilities.getUserID("johnFrom11@email.com", "1111");
        Assert.assertEquals(-1, actual);//negative test

        // POSITIVE TEST.
        int actual2 = APIUtilities.getUserID(Environment.MEMBER_USERNAME, Environment.MEMBER_PASSWORD);
        //positive test
        Assert.assertTrue(actual2 > 0);//if ID is positive - user exists indeed, otherwise it return -1
        int id1 = APIUtilities.getUserID("ImTheMan@email.com","1111");
        System.out.println(id1);
    }


}
