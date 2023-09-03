package co.edu.upb.QuizLab;

public class PMUAlarmSystem {

    public static boolean isDangerousLevel(int deviceReading) {
      
        int dangerousLevel = 7; 
        
        return deviceReading >= dangerousLevel;
    }

    public static boolean activateS1Alarm(boolean isDeviceA, boolean isDeviceB, boolean isDeviceC, boolean isDeviceD) {
         return (isDeviceC) ||
           (isDeviceB && isDeviceC) ||
           (isDeviceB && isDeviceC && isDeviceD);
    }

    public static boolean activateS2Alarm(boolean isDeviceA, boolean isDeviceB, boolean isDeviceC, boolean isDeviceD) {
        return (isDeviceA && isDeviceB) ||
               (isDeviceA && isDeviceD) ||
               (isDeviceC && isDeviceD) ||
               (isDeviceB && isDeviceC && isDeviceD);
    }

    public static boolean activateS3Alarm(boolean isDeviceA, boolean isDeviceB, boolean isDeviceC, boolean isDeviceD) {
        return (isDeviceB && isDeviceC) ||
               (isDeviceA && isDeviceC);
    }

    public static boolean activateS4Alarm(boolean isDeviceA, boolean isDeviceB, boolean isDeviceC, boolean isDeviceD) {
        return (isDeviceC && isDeviceD && isDeviceA) ||
               (isDeviceD && isDeviceA) ||
               (isDeviceA && isDeviceC) ||
               (isDeviceA && isDeviceB && isDeviceC && isDeviceD);
    }

    public static void main(String[] args) {
        // Simular lecturas de dispositivos (0: normal, 1: peligroso)
        boolean isDeviceA = true;
        boolean isDeviceB = false;
        boolean isDeviceC = false;
        boolean isDeviceD = true;

        boolean activateS1 = activateS1Alarm(isDeviceA, isDeviceB, isDeviceC, isDeviceD);
        boolean activateS2 = activateS2Alarm(isDeviceA, isDeviceB, isDeviceC, isDeviceD);
        boolean activateS3 = activateS3Alarm(isDeviceA, isDeviceB, isDeviceC, isDeviceD);
        boolean activateS4 = activateS4Alarm(isDeviceA, isDeviceB, isDeviceC, isDeviceD);

        System.out.println("Activar alarma S1: " + activateS1);
        System.out.println("Activar alarma S2: " + activateS2);
        System.out.println("Activar alarma S3: " + activateS3);
        System.out.println("Activar alarma S4: " + activateS4);
    }

}