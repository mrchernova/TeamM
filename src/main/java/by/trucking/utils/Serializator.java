package by.trucking.utils;

import by.trucking.model.Contact;

import java.io.*;

public class Serializator {

    public boolean serialization(Contact contact) {
        boolean flag = false;
        File file = new File("src/main/resources/contact.data");
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (fos != null) {

                oos = new ObjectOutputStream(fos);
                oos.writeObject(contact);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }


    //deserializator
    public Contact deserialization() {
        File file = new File("src/main/resources/contact.data");
        ObjectInputStream ois = null;
        Contact contact = null;

        try {
            FileInputStream fis = new FileInputStream(file);

            if (fis != null) {

                ois = new ObjectInputStream(fis);
                contact = (Contact) ois.readObject();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contact;

    }
}
