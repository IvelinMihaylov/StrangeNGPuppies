package com.strangengpuppies.strangengpuppies.model.formControl;


public class FormCommand {
    private String[] multiCheckboxSelectedValues;

    public FormCommand() {
    }

    public FormCommand(String[] multiCheckboxSelectedValues) {
        this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
    }

    public String[] getMultiCheckboxSelectedValues() {
        return multiCheckboxSelectedValues;
    }

    public void setMultiCheckboxSelectedValues(String[] multiCheckboxSelectedValues) {
        this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
    }
}
