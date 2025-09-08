class ReportData {
    public String title;
    public java.util.List<String> lines = new java.util.ArrayList<>();
}

class ReportService {
    byte[] generate(String format, ReportData data) {
        switch (format) {
            case "PDF":
                // legacy: render PDF inline
                return new byte[0];
            case "CSV":
                // legacy: render CSV inline
                return String.join("\n", data.lines).getBytes();
            case "XLS":
                // legacy: render XLS inline (fake)
                return new byte[0];
            default:
                throw new IllegalArgumentException("Unknown format: " + format);
        }
    }
}
