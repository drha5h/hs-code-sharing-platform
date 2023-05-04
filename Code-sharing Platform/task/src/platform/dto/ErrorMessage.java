package platform.dto;

public class ErrorMessage {
    private int status;
    private String cause;

    public ErrorMessage() {
    }

    public ErrorMessage(int status, String cause) {
        this.status = status;
        this.cause = cause;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
