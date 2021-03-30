package ar.com.edenor.ocp.api;

import ar.com.edenor.ocp.model.JobInitialization;
import ar.com.edenor.ocp.model.ProcessIdentity;
import lombok.Data;

@Data
public class MockKTARequestParamDTO {

    String sessionId;
    ProcessIdentity processIdentity;
    JobInitialization jobInitialization;
}
