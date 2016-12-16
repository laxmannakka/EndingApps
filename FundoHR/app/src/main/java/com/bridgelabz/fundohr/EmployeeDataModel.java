package com.bridgelabz.fundohr;

/**
 * Created by bridgeit007 on 10/12/16.
 */

public class EmployeeDataModel {
    String date;
    String intime;
    String outtime;
    String noofhours;
    String workingstatus;
    String reason;

    public EmployeeDataModel(String date, String intime, String outtime, String noofhours, String workingstatus, String reason) {
        this.date = date;
        this.intime = intime;
        this.outtime = outtime;
        this.noofhours = noofhours;
        this.workingstatus = workingstatus;
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getNoofhours() {
        return noofhours;
    }

    public void setNoofhours(String noofhours) {
        this.noofhours = noofhours;
    }

    public String getWorkingstatus() {
        return workingstatus;
    }

    public void setWorkingstatus(String workingstatus) {
        this.workingstatus = workingstatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
