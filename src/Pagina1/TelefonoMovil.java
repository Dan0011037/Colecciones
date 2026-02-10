package Pagina1;

import java.util.ArrayList;

public class TelefonoMovil {
    ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    public TelefonoMovil(ArrayList<Contacto> myContacts) {
        this.myContacts = myContacts;
    }

    //busca el contacto y te devuelve su numero
    private int findContact(Contacto contacto) {
        return myContacts.indexOf(contacto);
    }

    //busca el contacto del nombre introducido y te devuelve su numero (encontrado en el findContact de arriba)
    private int findContact(String name) {
        for (Contacto contacto : myContacts) {
            if (contacto.getName().equals(name)) {
                return findContact(contacto);
            }
        }
        return -1;
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto.getName()) >= 0) {
            return false;
        }
        myContacts.add(contacto);
        return true;
    }

    public boolean updateContact(Contacto contacto, Contacto nuevoContacto){
        if (findContact(contacto.getName()) >= 0){
            int indice = myContacts.indexOf(contacto);
            myContacts.set(indice, nuevoContacto);
            return true;
        }else return false;
    }

    public boolean removeContact(Contacto contacto){
        if (contacto == null)
            return false;
        return myContacts.remove(contacto);
    }

    public Contacto queryContacto(String name){
        for (Contacto contacto : myContacts) {
            if (contacto.getName().equals(name)) {
                return contacto;
            }
        }
        return null;
    }

    public void printContacto(){
        for (int i =0; i<myContacts.size();i++){
            Contacto contacto = myContacts.get(i);
            System.out.println(contacto.getName() + ", " + contacto.getPhoneNumber());
        }
    }

}

