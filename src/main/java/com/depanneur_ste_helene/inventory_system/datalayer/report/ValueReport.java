package com.depanneur_ste_helene.inventory_system.datalayer.report;

import java.time.LocalDate;

public class ValueReport {

    LocalDate date;

    double value;

    public ValueReport() {};

    public ValueReport(LocalDate date, double value) {
        this.date = date;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
