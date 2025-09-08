import java.io.*;
import java.time.*;

class AuditLogger {
    public static void log(String msg) {
        try (var fw = new FileWriter("audit.log", true)) {
            fw.write(Instant.now() + " - " + msg + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(msg); // also writes to console
    }
}
