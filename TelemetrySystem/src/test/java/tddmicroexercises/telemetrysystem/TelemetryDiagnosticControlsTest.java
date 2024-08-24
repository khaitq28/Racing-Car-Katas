package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class TelemetryDiagnosticControlsTest {
    
	@Test
    void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {

        TelemetryClient telemetryClient = Mockito.mock(TelemetryClient.class);
        when(telemetryClient.getOnlineStatus()).thenReturn(false, false, false, false, true);
        when(telemetryClient.receive()).thenReturn("status message");
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);

        telemetryDiagnosticControls.checkTransmission();

        assertEquals("status message", telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test
    void CheckTransmission_should_get_exception_message_response() {

        TelemetryClient telemetryClient = Mockito.mock(TelemetryClient.class);
        when(telemetryClient.getOnlineStatus()).thenReturn(false);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);

        Exception e = assertThrows(ConnectionFailedException.class, telemetryDiagnosticControls::checkTransmission);
        assertEquals("Unable to connect.", e.getMessage());
    }

    @Test
    void CheckTransmission_should_get_exception_message_response_after_3_failed_connection() {
        TelemetryClient telemetryClient = Mockito.mock(TelemetryClient.class);
        when(telemetryClient.getOnlineStatus()).thenReturn(false, false, false, false, false, true);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);

        Exception e = assertThrows(ConnectionFailedException.class, telemetryDiagnosticControls::checkTransmission);
        assertEquals("Unable to connect.", e.getMessage());
    }

}
