package com.example.dellpc.project_pfe.Model;

public class TypeDiplomes {
    private int code_diplomes ;
    private String label ;

    public TypeDiplomes(int code_diplomes, String label) {
        code_diplomes = code_diplomes;
        this.label = label;
    }

    public int getCode_niveauAnInt() {
        return code_diplomes;
    }

    public void setCode_niveauAnInt(int code_niveauAnInt) {
        code_diplomes = code_niveauAnInt;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
