package com.example.dellpc.project_pfe.Model;

public class Famille {
    private int code_famille  ;
    private int N_homme ;
    private int  N_famme ;

    public Famille(int code_famille, int n_homme, int n_famme) {
        this.code_famille = code_famille;
        N_homme = n_homme;
        N_famme = n_famme;
    }

    public int getCode_famille() {
        return code_famille;
    }

    public void setCode_famille(int code_famille) {
        this.code_famille = code_famille;
    }

    public int getN_homme() {
        return N_homme;
    }

    public void setN_homme(int n_homme) {
        N_homme = n_homme;
    }

    public int getN_famme() {
        return N_famme;
    }

    public void setN_famme(int n_famme) {
        N_famme = n_famme;
    }
}
