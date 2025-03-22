package patient_management;

import java.util.ArrayList;

public class MedicalHistory {
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

    public ArrayList<String> getConditions() {
        return CONDITIONS;
    }

    public ArrayList<String> getVisitsInfo() {
        return VISITS_INFO;
    }

    public int getNumVisits() {
        return numVisits;
    }

    public String getLastVisit() {
        return VISITS_INFO.getLast();
    }

    public void setNumVisits(int numVisits) {
        this.numVisits = numVisits;
    }

    public void addCondition(String condition) {
        this.CONDITIONS.add(condition);
    }

    public void addVisitInfo(String visitEntry){
        ;
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

        for (String s:getLastVisit().split(" ")) {
            if (s.contains("-")) {
                lastVisitDate = s;
            }
        }

        retString.append("\nLast Visit: ").append(lastVisitDate);

        return retString.toString();
    }

    public static void main(String[] args) {
    }
}
