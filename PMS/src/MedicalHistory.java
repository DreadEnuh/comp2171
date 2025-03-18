import java.util.ArrayList;

public class MedicalHistory {
    private final ArrayList<String> conditions;
    private final ArrayList<String> visitsInfo;
    private String lastVisitDate;
    private int numVisits;

    public MedicalHistory() {
        this.conditions = new ArrayList<>();
        this.visitsInfo = new ArrayList<>();
        this.numVisits = 0;
        this.lastVisitDate = " ";
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public int getNumVisits() {
        return numVisits;
    }

    public ArrayList<String> getVisitsInfo() {
        return visitsInfo;
    }

    public String getLastVisit() {
        return visitsInfo.getLast();
    }

    public void addCondition(String condition) {
        this.conditions.add(condition);
    }

    public void addVisitInfo(String dd, String mm, String yyyy, String severity, String problemDescription, String diagnosis, String treatment) {
        dd = (dd.length() == 1)? ("0" + dd):(dd);
        mm = (mm.length() == 1)? ("0" + mm):(mm);
        String visitDate = yyyy + "-" + mm + "-" + dd;

        String visitEntry = "Visit number: " + numVisits + " on " + visitDate + " for " + problemDescription
                + "\nSeverity: " + severity.toUpperCase()
                + "\nDiagnosis: " + diagnosis
                + "\nTreatment: " + treatment;
        visitsInfo.add(visitEntry);
        numVisits++;
    }

    public String toString() {
        StringBuilder retString = new StringBuilder(" ");

        retString.append("\n-----      Medical Conditions      -----\n");
        for (String c:conditions) {
            retString.append(c).append("\n");
        }

        retString.append("\n-----      Visit History      -----\n");
        for (String v:visitsInfo) {
            retString.append(v).append("\n");
            retString.append("---------------------------------------\n");
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
        MedicalHistory history = new MedicalHistory();

        // Add medical conditions
        history.addCondition("Diabetes");
        history.addCondition("Hypertension");
        history.addCondition("Asthma");

        // Add visit information using addVisitInfo method
        history.addVisitInfo("15", "1", "2024", "Mild", "Routine Checkup", "Stable", "Continue medication");
        history.addVisitInfo("20", "2", "2024", "Moderate", "Follow-up on blood pressure", "Hypertension Stage 1", "Adjust medication");
        history.addVisitInfo("10", "3", "2024", "Severe", "Emergency due to asthma attack", "Asthma exacerbation", "Nebulizer treatment");

        System.out.println(history);
    }
}
