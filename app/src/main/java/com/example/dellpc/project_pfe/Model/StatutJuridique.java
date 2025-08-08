package com.example.dellpc.project_pfe.Model;

public class StatutJuridique {
    private int code ;
    private String label ;

    public StatutJuridique(int code, String label) {
        code = code;
        this.label = label;
    }

    public int getCode_niveauAnInt() {
        return code;
    }

    public void setCode_niveauAnInt(int code_niveauAnInt) {
        code = code_niveauAnInt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
