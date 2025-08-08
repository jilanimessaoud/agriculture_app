package com.example.dellpc.project_pfe.Model;

public class NiveauInstruction {
    private int Code_niveauAnInt ;
    private String label ;

    public NiveauInstruction(int code_niveauAnInt, String label) {
        Code_niveauAnInt = code_niveauAnInt;
        this.label = label;
    }

    public int getCode_niveauAnInt() {
        return Code_niveauAnInt;
    }

    public void setCode_niveauAnInt(int code_niveauAnInt) {
        Code_niveauAnInt = code_niveauAnInt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
