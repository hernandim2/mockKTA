package ar.com.edenor.ocp.model;
import lombok.Data;

@Data
public class ModelRequestKta {
    String sessionId;
    ProcessIdentity processIdentity;
    JobInitialization jobInitialization;
}
