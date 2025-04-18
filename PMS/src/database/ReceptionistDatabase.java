package database;

import user_management.Receptionist;

import java.util.ArrayList;

public class ReceptionistDatabase {
    private ArrayList<Receptionist> receptionists = new ArrayList<>();

    public ReceptionistDatabase() {
        receptionists = DBConnection.loadReceptionists();
    }

    public ArrayList<Receptionist> getReceptionists() {
        return receptionists;
    }

    public Receptionist getReceptionistByID(String id) {
        Receptionist retRec = null;
        for (Receptionist r:receptionists) {
            if (r.getID().equals(id)) {
                retRec = r;
            }
        }
        return retRec;
    }

    public Receptionist getReceptionistByName(String name) {
        Receptionist retRec = null;
        for (Receptionist r:receptionists) {
            if (name.equals(r.getFName() + " " + r.getMName() + " " + r.getLName())) {
                retRec = r;
            }
        }
        return retRec;
    }

    public void addReceptionist(Receptionist r) {
        this.receptionists.add(r);
    }

    public void deleteReceptionist(Receptionist r) {
        this.receptionists.remove(r);
    }
}
