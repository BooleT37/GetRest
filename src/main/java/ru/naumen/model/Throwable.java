package ru.naumen.model;

public class Throwable<T> {
    private boolean error;
    private String errorMessage;
    private T data;

    public Throwable(boolean error, T data) {
        this.error = error;
        this.data = data;
    }

    public Throwable(boolean error, String errorMessage) {
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public boolean getError() { return error; }
    public void setError(boolean error) { this.error = error; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String message) { this.errorMessage = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
