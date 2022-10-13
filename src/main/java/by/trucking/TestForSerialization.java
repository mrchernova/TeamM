package by.trucking;

import by.trucking.model.Contact;
import by.trucking.utils.Serializator;

public class TestForSerialization {
    public static void main(String[] args) {
// for serialization
//        Contact contact = new Contact(1234567, "+8(900)2000-3000");
//        Serializator serializator = new Serializator();
//        System.out.println(serializator.serialization(contact));

       // for deserialization
        Serializator serializator = new Serializator();
        Contact contact = serializator.deserialization();
        System.out.println(contact);


    }
}
