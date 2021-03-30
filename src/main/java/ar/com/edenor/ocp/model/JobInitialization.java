package ar.com.edenor.ocp.model;
import lombok.Data;

import java.util.ArrayList;

@Data
public class JobInitialization {
    ArrayList<InputVariables> inputVariablesArray;
    String startDate;

}
