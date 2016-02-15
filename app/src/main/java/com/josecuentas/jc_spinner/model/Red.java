package com.josecuentas.jc_spinner.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by IID on 1/02/16.
 */

@DatabaseTable(tableName = "RED")
public class Red {

    public static final String CO_RED = "coRed";
    public static final String DE_RED = "deRed";
    public static final String _ID_CODE = "codeRed";

    @DatabaseField(id = true, columnName = CO_RED)
    private int coRed;
    @DatabaseField(columnName = DE_RED)
    private String getDeRed;
    @DatabaseField(columnName = _ID_CODE)
    private String idCode;

    @ForeignCollectionField
    private ForeignCollection<MicroRed> microReds;

    public Red(){

    }

    public Red(int coRed, String getDeRed, String idCode) {
        this.coRed = coRed;
        this.getDeRed = getDeRed;
        this.idCode = idCode;
    }

    public Red(int coRed) {
        this.coRed = coRed;
    }

    public int getCoRed() {
        return coRed;
    }

    public void setCoRed(int coRed) {
        this.coRed = coRed;
    }

    public String getGetDeRed() {
        return getDeRed;
    }

    public void setGetDeRed(String getDeRed) {
        this.getDeRed = getDeRed;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }


    public ForeignCollection<MicroRed> getMicroReds() {
        return microReds;
    }

    public void setMicroReds(ForeignCollection<MicroRed> microReds) {
        this.microReds = microReds;
    }

}
