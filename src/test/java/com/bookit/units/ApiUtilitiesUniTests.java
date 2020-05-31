package com.bookit.units;
 /*
 This unit package stands for some unit testing
  */

import com.bookit.utilities.APIUtilities;
import org.apiguardian.api.API;
import org.junit.Assert;
import org.junit.Test;



/*Class with unit tests for APIutilites class
* Here we ensure that utilities work fine before using them in action
* This is our unit testing for our framework not DEVS..
* to make sure our code works well
 */
public class ApiUtilitiesUniTests {


/*
* Uni Testing for token method */
    @Test
    public void getTokenTest(){
        String token = APIUtilities.getToken();
        String tokenForStundet = APIUtilities.getToken("student");
        String tokenForTeacher = APIUtilities.getToken("teacher");


        Assert.assertNotNull(token);
        Assert.assertNotNull(tokenForStundet);
        Assert.assertNotNull(tokenForTeacher);
    }
}
