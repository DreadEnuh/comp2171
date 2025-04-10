package patient_management;

import java.util.ArrayList;

public class MedicalHistory {
    private String patientID;
    private final ArrayList<String> CONDITIONS;
    private final ArrayList<String> VISITS_INFO;
    private String lastVisitDate;
    private int numVisits;

    public MedicalHistory() {
        this.CONDITIONS = new ArrayList<>();
        this.VISITS_INFO = new ArrayList<>();
        this.numVisits = 0;
        this.lastVisitDate = " ";
    }

    // Getters

    public ArrayList<String> getConditions() {
        return CONDITIONS;
    }

    public ArrayList<String> getVisitsInfo() {
        return VISITS_INFO;
    }

    public int getNumVisits() {
        return numVisits;
    }

    public String getLastVisitInfo() {
        return VISITS_INFO.getLast();
    }

    public String getLastVisitDate() {
        if (VISITS_INFO.isEmpty()) {
            return lastVisitDate;
        }

        String lastVisitEntry = VISITS_INFO.getLast();

        String[] parts = lastVisitEntry.split(" ");
        for (String s : parts) {
            if (s.contains("-")) {
                lastVisitDate = s;
            }
        }
        return lastVisitDate;
    }


    // Modifiers

    public void setNumVisits(int numVisits) {
        this.numVisits = numVisits;
    }

    public void addCondition(String condition) {
        this.CONDITIONS.add(condition);
    }

    public void addVisitInfo(String visitEntry){
        VISITS_INFO.add(visitEntry);
        numVisits++;
    }

    public String toString() {
        StringBuilder retString = new StringBuilder(" ");

        retString.append("\n----------      Medical Conditions      ----------\n");
        for (String c:CONDITIONS) {
            retString.append(c).append("\n");
        }

        retString.append("\n-------------      Visit History      ------------\n");
        for (String v:VISITS_INFO) {
            retString.append(v).append("\n");
            retString.append("--------------------------------------------------\n");
        }

        retString.append("\nLast Visit: ").append(getLastVisitDate());

        return retString.toString();
    }

    public static void main(String[] args) {
        System.out.println("Medical History Class");
    }
}
