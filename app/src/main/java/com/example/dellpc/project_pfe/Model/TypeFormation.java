package com.example.dellpc.project_pfe.Model;

public class TypeFormation   {
    private int code_formaion ;
    private String label ;

    public TypeFormation(int code_formaion, String label) {
        code_formaion = code_formaion;
        this.label = label;
    }

    public int getCode_niveauAnInt() {
        return code_formaion;
    }

    public void setCode_niveauAnInt(int code_niveauAnInt) {
        code_formaion = code_niveauAnInt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
