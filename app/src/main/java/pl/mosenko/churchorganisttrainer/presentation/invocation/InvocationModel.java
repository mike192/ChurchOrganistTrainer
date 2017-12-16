package pl.mosenko.churchorganisttrainer.presentation.invocation;

/**
 * Created by syk on 16.12.17.
 */

public class InvocationModel {
    private int id;
    private String invocationName;
    private String successfulResponsesPercentage;

    public InvocationModel(int id, String invocationName, String successfulResponsesPercentage) {
        this.id = id;
        this.invocationName = invocationName;
        this.successfulResponsesPercentage = successfulResponsesPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvocationName() {
        return invocationName;
    }

    public void setInvocationName(String invocationName) {
        this.invocationName = invocationName;
    }

    public String getSuccessfulResponsesPercentage() {
        return successfulResponsesPercentage;
    }

    public void setSuccessfulResponsesPercentage(String successfulResponsesPercentage) {
        this.successfulResponsesPercentage = successfulResponsesPercentage;
    }
}
