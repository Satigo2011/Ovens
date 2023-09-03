package co.edu.upb.Interfa;
public class AlarmSystem {
    private boolean deviceA;
    private boolean deviceB;
    private boolean deviceC;
    private boolean deviceD;

    public AlarmSystem(boolean deviceA, boolean deviceB, boolean deviceC, boolean deviceD) {
        this.deviceA = deviceA;
        this.deviceB = deviceB;
        this.deviceC = deviceC;
        this.deviceD = deviceD;
    }

    public void activateAllAlarms() {
        activateAlarmS1();
        activateAlarmS2();
        activateAlarmS3();
        activateAlarmS4();
    }

    private void activateAlarmS1() {
        if ((deviceC && deviceD) || (deviceB && deviceD) || (deviceB && deviceC) ||  (deviceA && deviceB)) {
            System.out.println("Alarma activada en localidad S1");
        }
    }

    private void activateAlarmS2() {
        if ((deviceA && deviceB && deviceC) || (deviceA && deviceC && deviceD) || (deviceA && deviceD) || (deviceB && deviceC && deviceD)) {
            System.out.println("Alarma activada en localidad S2");
        }
    }

    private void activateAlarmS3() {
        if ((deviceC && deviceD) || (deviceB && deviceC) || (deviceA && deviceC)) {
            System.out.println("Alarma activada en localidad S3");
        }
    }

    private void activateAlarmS4() {
        if ((deviceC && deviceD && deviceB) || (deviceD && deviceA) ||  (deviceA && deviceC) || (deviceA && deviceB && deviceC && deviceD)) {
            System.out.println("Alarma activada en localidad S4");
        }
    }
}
