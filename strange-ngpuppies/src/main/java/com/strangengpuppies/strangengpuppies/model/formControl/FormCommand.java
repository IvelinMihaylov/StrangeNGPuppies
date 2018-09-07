package com.strangengpuppies.strangengpuppies.model.formControl;


public class FormCommand {
    private String[] multiCheckboxSelectedValues;
    private String usernameField;
    private String passwordField;
    private String emailField;
    private String EIK;

    public FormCommand() {
    }

    public FormCommand(String[] multiCheckboxSelectedValues, String usernameField, String passwordField, String emailField, String eik) {
        this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.emailField = emailField;
        EIK = eik;
    }

    public String[] getMultiCheckboxSelectedValues() {
        return multiCheckboxSelectedValues;
    }

    public void setMultiCheckboxSelectedValues(String[] multiCheckboxSelectedValues) {
        this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
    }

    public String getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(String usernameField) {
        this.usernameField = usernameField;
    }

    public String getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    public String getEmailField() {
        return emailField;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    public String getEIK() {
        return EIK;
    }

    public void setEIK(String EIK) {
        this.EIK = EIK;
    }
}
