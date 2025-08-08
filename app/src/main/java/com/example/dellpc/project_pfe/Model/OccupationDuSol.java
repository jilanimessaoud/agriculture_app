package com.example.dellpc.project_pfe.Model;

public class OccupationDuSol {
    private int code_occupation;
    private int Nombre_de_bloc ;
    private int superficie_totals;
    private int superficie_labourable ;
    private int superficie_cultive ;
    private int superficie_irrigable;
    private int superficie_irrigee;
    private String type_perimetre_irriguee  ;
    private int Nb_puis__exploitation;
    private int Nb_sondage__exploitation ;
    private int longeur_vent  ;
    private String test_culture_intercalaire  ;
    private String test_culture_double  ;
    private int   code_bloc  ;

    public int getCode_occupation() {
        return code_occupation;
    }

    public void setCode_occupation(int code_occupation) {
        this.code_occupation = code_occupation;
    }

    public int getNombre_de_bloc() {
        return Nombre_de_bloc;
    }

    public void setNombre_de_bloc(int nombre_de_bloc) {
        Nombre_de_bloc = nombre_de_bloc;
    }

    public int getSuperficie_totals() {
        return superficie_totals;
    }

    public void setSuperficie_totals(int superficie_totals) {
        this.superficie_totals = superficie_totals;
    }

    public int getSuperficie_labourable() {
        return superficie_labourable;
    }

    public void setSuperficie_labourable(int superficie_labourable) {
        this.superficie_labourable = superficie_labourable;
    }

    public int getSuperficie_cultive() {
        return superficie_cultive;
    }

    public void setSuperficie_cultive(int superficie_cultive) {
        this.superficie_cultive = superficie_cultive;
    }

    public int getSuperficie_irrigable() {
        return superficie_irrigable;
    }

    public void setSuperficie_irrigable(int superficie_irrigable) {
        this.superficie_irrigable = superficie_irrigable;
    }

    public int getSuperficie_irrigee() {
        return superficie_irrigee;
    }

    public void setSuperficie_irrigee(int superficie_irrigee) {
        this.superficie_irrigee = superficie_irrigee;
    }

    public String getType_perimetre_irriguee() {
        return type_perimetre_irriguee;
    }

    public void setType_perimetre_irriguee(String type_perimetre_irriguee) {
        this.type_perimetre_irriguee = type_perimetre_irriguee;
    }

    public int getNb_puis__exploitation() {
        return Nb_puis__exploitation;
    }

    public void setNb_puis__exploitation(int nb_puis__exploitation) {
        Nb_puis__exploitation = nb_puis__exploitation;
    }

    public int getNb_sondage__exploitation() {
        return Nb_sondage__exploitation;
    }

    public void setNb_sondage__exploitation(int nb_sondage__exploitation) {
        Nb_sondage__exploitation = nb_sondage__exploitation;
    }

    public int getLongeur_vent() {
        return longeur_vent;
    }

    public void setLongeur_vent(int longeur_vent) {
        this.longeur_vent = longeur_vent;
    }

    public String getTest_culture_intercalaire() {
        return test_culture_intercalaire;
    }

    public void setTest_culture_intercalaire(String test_culture_intercalaire) {
        this.test_culture_intercalaire = test_culture_intercalaire;
    }

    public String getTest_culture_double() {
        return test_culture_double;
    }

    public void setTest_culture_double(String test_culture_double) {
        this.test_culture_double = test_culture_double;
    }

    public int getCode_bloc() {
        return code_bloc;
    }

    public void setCode_bloc(int code_bloc) {
        this.code_bloc = code_bloc;
    }

    public OccupationDuSol(int code_occupation, int nombre_de_bloc, int superficie_totals, int superficie_labourable, int superficie_cultive, int superficie_irrigable, int superficie_irrigee, String type_perimetre_irriguee, int nb_puis__exploitation, int nb_sondage__exploitation, int longeur_vent, String test_culture_intercalaire, String test_culture_double, int code_bloc) {

        this.code_occupation = code_occupation;
        Nombre_de_bloc = nombre_de_bloc;
        this.superficie_totals = superficie_totals;
        this.superficie_labourable = superficie_labourable;
        this.superficie_cultive = superficie_cultive;
        this.superficie_irrigable = superficie_irrigable;
        this.superficie_irrigee = superficie_irrigee;
        this.type_perimetre_irriguee = type_perimetre_irriguee;
        Nb_puis__exploitation = nb_puis__exploitation;
        Nb_sondage__exploitation = nb_sondage__exploitation;
        this.longeur_vent = longeur_vent;
        this.test_culture_intercalaire = test_culture_intercalaire;
        this.test_culture_double = test_culture_double;
        this.code_bloc = code_bloc;
    }
}
