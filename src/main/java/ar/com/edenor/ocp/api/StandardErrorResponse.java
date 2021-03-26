package ar.com.edenor.ocp.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class StandardErrorResponse<T> implements Serializable {

    public enum Status {OK, ERROR }

    private Status status;
    private String operation;
    private T data;
    private List<Error> errors;

    public static <T> StandardErrorResponse<T> ok(String operation, T data) {
        StandardErrorResponse response = new StandardErrorResponse<T>(Status.OK, operation);
        response.setData(data);

        return response;
    }

    public static <T> StandardErrorResponse<T> ok(String operation) {
        return ok(operation, null);
    }

    public static <T> StandardErrorResponse<T> error(String operation, List<Error> errors) {
        StandardErrorResponse response = new StandardErrorResponse<T>(Status.ERROR, operation);
        response.setErrors(errors);

        return response;
    }

    public static <T> StandardErrorResponse<T> error(String operation) {
        return error(operation, new ArrayList<Error>());
    }

    /**
     * Api Response Constructor
     *
     * @param status    Flag to indicate if got error or not.
     * @param operation Requested operation name.
     */
    public StandardErrorResponse(Status status, String operation) {
        this.status = status;
        this.operation = operation;
    }

    // Getters & Setters

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public void registerError(String code, String msg) {
        this.errors.add(new Error(code,msg));
    }

    // ErrorMessage Inner class

    public static class Error {
        String code;
        String message;

        public Error(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}
