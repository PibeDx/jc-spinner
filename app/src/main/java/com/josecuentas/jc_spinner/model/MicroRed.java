package com.josecuentas.jc_spinner.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by MiRey on 1/02/16.
 */

@DatabaseTable(tableName = "MICRO_RED")
public class MicroRed {

    public static final String CO_MICRO_RED = "coMicroRed";
    public static final String DE_MICRO_RED = "deMicroRed";

    public MicroRed(){

    }

    public MicroRed(int coMicroRed) {
        this.coMicroRed = coMicroRed;
    }

    @DatabaseField(id=true ,/*generatedId = true,*/columnName = CO_MICRO_RED)
    private int coMicroRed;
    @DatabaseField(columnName = DE_MICRO_RED)
    private String deMicroRed;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Red red;

    public MicroRed(int coMicroRed, String deMicroRed, Red red) {
        this.coMicroRed = coMicroRed;
        this.deMicroRed = deMicroRed;
        this.red = red;
    }

    public int getCoMicroRed() {
        return coMicroRed;
    }

    public void setCoMicroRed(int coMicroRed) {
        this.coMicroRed = coMicroRed;
    }

    public String getDeMicroRed() {
        return deMicroRed;
    }

    public void setDeMicroRed(String deMicroRed) {
        this.deMicroRed = deMicroRed;
    }

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }

}
