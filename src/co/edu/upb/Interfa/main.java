package co.edu.upb.Interfa;
public class main {
    public static void main(String[] args) throws Exception {
        boolean deviceA = false;
        boolean deviceB = false;
        boolean deviceC = true;
        boolean deviceD = true;
        
        AlarmSystem alarmSystem = new AlarmSystem(deviceA, deviceB, deviceC, deviceD);
        alarmSystem.activateAllAlarms();
    }
}