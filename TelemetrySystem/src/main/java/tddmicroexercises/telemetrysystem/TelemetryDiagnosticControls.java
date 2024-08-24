package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls {
    private static final String DiagnosticChannelConnectionString = "*111#";
    private final TelemetryClient telemetryClient;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryClient client) {
        telemetryClient = client;
    }

    public String getDiagnosticInfo(){
        return diagnosticInfo;
    }

    public void checkTransmission() throws ConnectionFailedException {
        telemetryClient.disconnect();
        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft --;
        }

        if(!telemetryClient.getOnlineStatus()) {
            throw new ConnectionFailedException("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }
}
