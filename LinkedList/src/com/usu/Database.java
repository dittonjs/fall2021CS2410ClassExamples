package com.usu;

public class Database {

    private void doQuery(String string) {
        // takes the string and does a query
    }

    public void getUser(String name) {
        // make sure the id doesnt contain and injection attack
        // make sure the user can actually access that user
        // make sure that permisssions
        doQuery("SELECT * from user where name = " + name);
    }
}
