package com.example.dellpc.project_pfe.Model;

public class Zone {
    private int code_zone ;
    private String label ;

    public Zone(int code_zone, String label) {
        code_zone = code_zone;
        this.label = label;
    }

    public int getCode_niveauAnInt() {
        return code_zone;
    }

    public void setCode_niveauAnInt(int code_niveauAnInt) {
        code_zone = code_niveauAnInt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
