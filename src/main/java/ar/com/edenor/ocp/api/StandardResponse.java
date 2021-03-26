package ar.com.edenor.ocp.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class StandardResponse<T> implements Serializable {

    private T data;

    public StandardResponse(T data) {
        this.data = data;
    }


    public static <T> StandardResponse<T> build(T data) {
        StandardResponse response = new StandardResponse<T>(data);
        response.setData(data);

        return response;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



}