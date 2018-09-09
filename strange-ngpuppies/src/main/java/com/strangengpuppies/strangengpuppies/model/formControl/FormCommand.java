package com.strangengpuppies.strangengpuppies.model.formControl;


public class FormCommand {
    private String[] multiCheckboxSelectedValues;
    private String usernameField;
    private String passwordField;
    private String emailField;
    private String EIK;
    private String firstName;
    private String lastName;
    private String egn;
    private String phonenumber;
    private String dropdownSelectedValue;
    private String billAmount;
    private String startDate;
    private String endDate;
    private String currency;

    public FormCommand() {
    }

    public FormCommand(String[] multiCheckboxSelectedValues, String usernameField, String passwordField, String emailField, String eik, String firstName, String lastName, String egn, String phonenumber, String dropdownSelectedValue, String billAmount, String startDate, String endDate, String currency) {
        this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.emailField = emailField;
        EIK = eik;
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.phonenumber = phonenumber;
        this.dropdownSelectedValue = dropdownSelectedValue;
        this.billAmount = billAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDropdownSelectedValue() {
        return dropdownSelectedValue;
    }

    public void setDropdownSelectedValue(String dropdownSelectedValue) {
        this.dropdownSelectedValue = dropdownSelectedValue;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
