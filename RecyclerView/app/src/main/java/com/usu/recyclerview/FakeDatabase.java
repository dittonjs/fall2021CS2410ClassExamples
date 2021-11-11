package com.usu.recyclerview;

import java.util.ArrayList;

public class FakeDatabase {
    public static ArrayList<Contact> getData(int amount) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Contact contact = new Contact();
            contact.name = "Contact " + i;
            contact.phoneNumber = "" + i;
            contacts.add(contact);
        }
        return contacts;
    }
}
