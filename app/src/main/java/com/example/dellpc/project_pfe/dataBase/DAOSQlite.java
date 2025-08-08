package com.example.dellpc.project_pfe.dataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dellpc.project_pfe.Model.Caracteristique_exploitation;
import com.example.dellpc.project_pfe.Model.Delegation;
import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.Model.Produit;
import com.example.dellpc.project_pfe.Model.ProduitExploitation;
import com.example.dellpc.project_pfe.Model.Secteur;
import com.example.dellpc.project_pfe.Model.TypeProduit;
import com.example.dellpc.project_pfe.Model.Utilisateur;

import java.util.ArrayList;

public class DAOSQlite extends SQLiteOpenHelper {
    public static final String DBname = "finaleBase.db";

    public DAOSQlite(Context context) {

        super(context, DBname, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table sectuer(id INTEGER PRIMARY KEY AUTOINCREMENT , label TEXT NOT NULL ) ");

        db.execSQL("create table compteuser(user TEXT Not Null  " + ", pass TEXT Not Null , nom TEXT NOT NULL, prenom TEXT NOT NULL , type TEXT NOT NULL  ,PRIMARY KEY(user,pass)) ");
        db.execSQL("create table delegation(id INTEGER PRIMARY KEY , label TEXT NOT NULL ) ");
        db.execSQL("create table secteur(id INTEGER NOT NULL ,idDelegation INTEGER  NOT NULL ,  label TEXT NOT NULL ,PRIMARY KEY(id,idDelegation )) ");

        db.execSQL("create table Exploitation_TypeProduit(Exploitation_id INTEGER NOT NULL ," +
                "idP INTEGER NOT NULL,idTypeP INTEGER NOT NULL,Nombre Text NOT NULL,PRIMARY KEY(Exploitation_id,idP ,idTypeP)) ");

        db.execSQL("create table Produit(id INTEGER NOT NULL PRIMARY KEY ,  label TEXT NOT NULL)");

        db.execSQL("create table Exploitant(cin TEXT PRIMARY KEY ) ");
        db.execSQL("create table Gerant(cin TEXT PRIMARY KEY ) ");
        db.execSQL("create table Personne(cin TEXT PRIMARY KEY ,  nom TEXT NOT NULL,  prenom TEXT NOT NULL " +
                ",  gouvernorat TEXT NOT NULL ,  delegation TEXT NOT NULL , secteur TEXT NOT NULL , codePostale INTEGER NOT NULL , " +
                "   sexe TEXT NOT NULL ,  tlf  TEXT NOT NULL  ,  age INTEGER NOT NULL " +
                ",  niveauInstruction  TEXT NOT NULL ,  TypeFormation  TEXT NOT NULL ,  TypeDiplome  TEXT NOT NULL , " +
                " ActivitePrincipale  TEXT NOT NULL ,  NBFamileHomme  INTEGER NOT NULL ,  NBFamileFemme  INTEGER NOT NULL " +
                ",  Assurance  TEXT NOT NULL ,  EntravesDeveloppement  TEXT NOT NULL ,  Credit  TEXT NOT NULL ,  cnss  TEXT NOT NULL) ");

        db.execSQL("create table Exploitation(codeExploitation INTEGER PRIMARY KEY AUTOINCREMENT , cinGerant TEXT NOT NULL,cinExploitant TEXT NOT NULL, " +
                " codesecteur INTEGER NOT NULL ,SpTotale REAL NOT NULL,SpLabourable REAL NOT NULL " +
                " , SpIrrigable REAL NOT NULL ,spCultivee REAL NOT NULL,SourceEau Text NOT NULL" +
                ",typeEngrais Text NOT NULL,TypeSanitaire Text NOT NULL" +
                ",NombresSondage INTEGER NOT NULL,NombrePuits INTEGER NOT NULL,NombreEmploiyer INTEGER NOT NULL) ");

        db.execSQL("create table CaracteristiqueExploitaton" +
                "(codeExploitation INTEGER NOT NULL PRIMARY KEY ,SpTotale REAL NOT NULL,SpLabourable REAL NOT NULL " +
                ", SpIrrigable REAL NOT NULL ,spCultivee REAL NOT NULL,SourceEau Text NOT NULL" +
                ",typeEngrais Text NOT NULL,TypeSanitaire Text NOT NULL" +
                ",NombresSondage INTEGER NOT NULL,NombrePuits INTEGER NOT NULL,NombreEmploiyer INTEGER NOT NULL," +
                "FOREIGN KEY(codeExploitation) REFERENCES Exploitation(codeExploitation)" +

                ") ");
        db.execSQL("create table TypeProduit(numero INTEGER NOT NULL  ,idProduit INTEGER NOT NULL ,idTypeProduit INTEGER NOT NULL  ,  label TEXT NOT NULL" +
                ",PRIMARY KEY(numero,idProduit ,idTypeProduit))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertUser(Utilisateur utilisateur) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", utilisateur.getUser());
        contentValues.put("pass", utilisateur.getPassword());
        contentValues.put("nom", utilisateur.getNom());
        contentValues.put("prenom", utilisateur.getPrenom());
        contentValues.put("type", utilisateur.getType());
        long result = db.insert("compteuser", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean modifDataCaractristiqueExploitation(Caracteristique_exploitation caracteristique_exploitation) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("codeExploitation", caracteristique_exploitation.getCode());
        contentValues.put("SpTotale", caracteristique_exploitation.getSpTotale());
        contentValues.put("SpLabourable", caracteristique_exploitation.getSpLabourable());
        contentValues.put("SpIrrigable", caracteristique_exploitation.getSpIrrigable());
        contentValues.put("spCultivee", caracteristique_exploitation.getSpCultivee());
        contentValues.put("SourceEau", caracteristique_exploitation.getSourceEau());
        contentValues.put("typeEngrais", caracteristique_exploitation.getTypeEngrais());
        contentValues.put("TypeSanitaire", caracteristique_exploitation.getTypeSanitaire());
        contentValues.put("NombresSondage", caracteristique_exploitation.getNombresSondage());
        contentValues.put("NombrePuits", caracteristique_exploitation.getNombrePuits());
        contentValues.put("NombreEmploiyer", caracteristique_exploitation.getNombreEmploiyer());


        long result = db.update("CaracteristiqueExploitaton", contentValues, "codeExploitation = " + String.valueOf(caracteristique_exploitation.getCode()), null);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean modificationExploitation(Exploitation exploitation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cinGerant", exploitation.getCinGerant());
        contentValues.put("cinExploitant", exploitation.getCinExploitant());
        contentValues.put("codesecteur", exploitation.getSecteur());
        contentValues.put("SpTotale", exploitation.getSpTotale());
        contentValues.put("SpLabourable", exploitation.getSpLabourable());
        contentValues.put("SpIrrigable", exploitation.getSpIrrigable());
        contentValues.put("spCultivee", exploitation.getSpCultivee());
        contentValues.put("SourceEau", exploitation.getSourceEau());
        contentValues.put("typeEngrais", exploitation.getTypeEngrais());
        contentValues.put("TypeSanitaire", exploitation.getTypeSanitaire());
        contentValues.put("NombresSondage", exploitation.getNombresSondage());
        contentValues.put("NombrePuits", exploitation.getNombrePuits());
        contentValues.put("NombreEmploiyer", exploitation.getNombreEmploiyer());


        long result = db.update("Exploitation", contentValues, "codeExploitation = " + String.valueOf(exploitation.getCodExploitation()), null);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataTypeProduit(int numero, int idp, int idpType, String label) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("numero", numero);
        contentValues.put("idProduit", idp);
        contentValues.put("idTypeProduit", idpType);
        contentValues.put("label", label);

        long result = db.insert("TypeProduit", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataCaractristiqueExploitation(Caracteristique_exploitation caracteristique_exploitation) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("codeExploitation", caracteristique_exploitation.getCode());
        contentValues.put("SpTotale", caracteristique_exploitation.getSpTotale());
        contentValues.put("SpLabourable", caracteristique_exploitation.getSpLabourable());
        contentValues.put("SpIrrigable", caracteristique_exploitation.getSpIrrigable());
        contentValues.put("spCultivee", caracteristique_exploitation.getSpCultivee());
        contentValues.put("SourceEau", caracteristique_exploitation.getSourceEau());
        contentValues.put("typeEngrais", caracteristique_exploitation.getTypeEngrais());
        contentValues.put("TypeSanitaire", caracteristique_exploitation.getTypeSanitaire());
        contentValues.put("NombresSondage", caracteristique_exploitation.getNombresSondage());
        contentValues.put("NombrePuits", caracteristique_exploitation.getNombrePuits());
        contentValues.put("NombreEmploiyer", caracteristique_exploitation.getNombreEmploiyer());

        long result = db.insert("CaracteristiqueExploitaton", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataExploitation(Exploitation exploitation) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cinGerant", exploitation.getCinGerant());
        contentValues.put("cinExploitant", exploitation.getCinExploitant());
        contentValues.put("codesecteur", exploitation.getSecteur());
        contentValues.put("SpTotale", exploitation.getSpTotale());
        contentValues.put("SpLabourable", exploitation.getSpLabourable());
        contentValues.put("SpIrrigable", exploitation.getSpIrrigable());
        contentValues.put("spCultivee", exploitation.getSpCultivee());
        contentValues.put("SourceEau", exploitation.getSourceEau());
        contentValues.put("typeEngrais", exploitation.getTypeEngrais());
        contentValues.put("TypeSanitaire", exploitation.getTypeSanitaire());
        contentValues.put("NombresSondage", exploitation.getNombresSondage());
        contentValues.put("NombrePuits", exploitation.getNombrePuits());
        contentValues.put("NombreEmploiyer", exploitation.getNombreEmploiyer());

        long result = db.insert("Exploitation", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataPersonne(Personne personne)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("secteur", personne.getSecteur());
        contentValues.put("codePostale", personne.getCodePostale());
        contentValues.put("gouvernorat", personne.getGouvernorat());
        contentValues.put("delegation", personne.getDelegation());
        contentValues.put("age", personne.getAge());
        contentValues.put("cin", personne.getCin());
        contentValues.put("nom", personne.getNom());
        contentValues.put("prenom", personne.getPrenom());
        contentValues.put("sexe", personne.getSexe());
        contentValues.put("tlf", personne.getTlf());
        contentValues.put("niveauInstruction", personne.getNiveauInstruction());
        contentValues.put("TypeFormation", personne.getTypeFormation());
        contentValues.put("TypeDiplome", personne.getTypeDiplome());
        contentValues.put("ActivitePrincipale", personne.getActivitePrincipale());
        contentValues.put("NBFamileHomme", personne.getnBFamileHomme());
        contentValues.put("NBFamileFemme", personne.getnBFamileFemme());
        contentValues.put("Assurance", personne.getAssurance());
        contentValues.put("EntravesDeveloppement", personne.getEntravesDeveloppement());
        contentValues.put("Credit", personne.getCredit());
        contentValues.put("cnss", personne.getCnss());

        long result = db.insert("Personne", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }


    public boolean modifDataPersonne(Personne personne)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("secteur", personne.getSecteur());
        contentValues.put("codePostale", personne.getCodePostale());
        contentValues.put("gouvernorat", personne.getGouvernorat());
        contentValues.put("delegation", personne.getDelegation());
        contentValues.put("age", personne.getAge());
        contentValues.put("nom", personne.getNom());
        contentValues.put("prenom", personne.getPrenom());
        contentValues.put("sexe", personne.getSexe());
        contentValues.put("tlf", personne.getTlf());
        contentValues.put("niveauInstruction", personne.getNiveauInstruction());
        contentValues.put("TypeFormation", personne.getTypeFormation());
        contentValues.put("TypeDiplome", personne.getTypeDiplome());
        contentValues.put("ActivitePrincipale", personne.getActivitePrincipale());
        contentValues.put("NBFamileHomme", personne.getnBFamileHomme());
        contentValues.put("NBFamileFemme", personne.getnBFamileFemme());
        contentValues.put("Assurance", personne.getAssurance());
        contentValues.put("EntravesDeveloppement", personne.getEntravesDeveloppement());
        contentValues.put("Credit", personne.getCredit());
        contentValues.put("cnss", personne.getCnss());

        long result = db.update("Personne", contentValues,"cin = '"+personne.getCin()+"'",null);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataExploitan(String cin) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cin", cin);

        long result = db.insert("Exploitant", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataGErant(String cin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cin", cin);
        long result = db.insert("Gerant", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataProduit(int id, String label) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("label", label);
        //contentValues.put("animl_id",1);

        long result = db.insert("Produit", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataProduitExploitation_TypeProduit(int idExploit, int idP, String qnt, int typeProduit) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Exploitation_id", idExploit);
        contentValues.put("idP", idP);
        contentValues.put("idTypeP", typeProduit);
        contentValues.put("Nombre", qnt);

        //contentValues.put("animl_id",1);

        long result = db.insert("Exploitation_TypeProduit", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean modifDataProduitExploitation_TypeProduit(int idExploit, int idP, String qnt, int typeProduit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Nombre", qnt);

        long result = db.update("Exploitation_TypeProduit", contentValues,
                "Exploitation_id=" + String.valueOf(idExploit) + " and idP = +" + String.valueOf(idP) + " and idTypeP = " + String.valueOf(typeProduit), null);
        if (result == -1)
            return false;
        else return true;


    }


    public boolean insertDataDelegation(int id, String label) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("label", label);
        //contentValues.put("animl_id",1);

        long result = db.insert("delegation", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public boolean insertDataSecteur(int id, int idDelegation, String label) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("idDelegation", idDelegation);
        contentValues.put("label", label);
        //contentValues.put("animl_id",1);

        long result = db.insert("secteur", null, contentValues);
        if (result == -1)
            return false;
        else return true;
    }

    public ArrayList getAllProduit() {
        Produit produit;
        ArrayList<Produit> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Produit ", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            produit = new Produit(result.getInt(0), result.getString(1));
            arrayList.add(produit);
            result.moveToNext();
        }
        return arrayList;
    }

    public ArrayList getAllDelegation() {
        Delegation delegation;
        ArrayList<Delegation> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from delegation ", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            delegation = new Delegation(result.getString(1), 1, result.getInt(0));
            arrayList.add(delegation);
            result.moveToNext();
        }
        return arrayList;
    }

    public ArrayList getAllSecteur(String code) {
        Secteur secteur;
        ArrayList<Secteur> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        String req = "select * from secteur where idDelegation =" + code;
        Cursor result = db.rawQuery(req, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            secteur = new Secteur(result.getInt(0), result.getString(2), result.getInt(1));
            arrayList.add(secteur);
            result.moveToNext();
        }
        return arrayList;
    }

    public String getDelegation(String code) {
        Secteur secteur;
        ArrayList<Secteur> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        String req = "select * from secteur where id =" + code;
        Cursor result = db.rawQuery(req, null);
        result.moveToFirst();
        String codeDelegaton = "";
        while (result.isAfterLast() == false) {
            codeDelegaton = String.valueOf(result.getInt(1));
            result.moveToNext();
            return codeDelegaton;

        }
        return codeDelegaton;
    }

    public ArrayList getAllTypeProduit() {

        TypeProduit typeProduit;
        ArrayList<TypeProduit> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from TypeProduit ", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            typeProduit = new TypeProduit(result.getInt(0), result.getInt(2), result.getInt(1), result.getString(3));
            arrayList.add(typeProduit);
            result.moveToNext();
        }
        return arrayList;
    }

    public String getSecteur(String code) {
        Secteur secteur;
        ArrayList<Secteur> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        String req = "select * from secteur where id =" + code;
        Cursor result = db.rawQuery(req, null);
        result.moveToFirst();
        String labelSecteur = "";
        while (result.isAfterLast() == false) {
            labelSecteur = String.valueOf(result.getString(2));
            result.moveToNext();
            return labelSecteur;

        }
        return labelSecteur;
    }

    public ArrayList<Exploitation> getAllExploitation(String cin) {

        ArrayList<Exploitation> list = new ArrayList<>();
        Exploitation exploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation where cinGerant = '" + cin + "'", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            exploitation = new Exploitation();
            exploitation.setCinExploitant(result.getString(2));
            exploitation.setCinGerant(result.getString(1));
            exploitation.setSecteur(result.getInt(3));
            exploitation.setCodExploitation(result.getInt(0));
            list.add(exploitation);
            result.moveToNext();
        }

        return list;
    }

    public boolean recherchExploitant(String cin) {
        int code = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Personne where cin = " + cin, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            code++;
            result.moveToNext();
        }
        if (code == -1)
            return false;
        else return true;
    }

    public ArrayList getlistProduct(String code) {

        TypeProduit typeProduit;
        ArrayList<TypeProduit> arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from TypeProduit where idProduit = " + code, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            typeProduit = new TypeProduit(result.getInt(0), result.getInt(2), result.getInt(1), result.getString(3));
            arrayList.add(typeProduit);
            result.moveToNext();
        }
        return arrayList;
    }

    public Produit getProduit(String code) {

        Produit produit = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Produit where id =" + code, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            produit = new Produit(result.getInt(0), result.getString(1));
            result.moveToNext();
        }
        return produit;
    }
    public Produit getLabelProduit(String label) {

        Produit produit = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Produit where label = '" + label+ "'", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            produit = new Produit(result.getInt(0), result.getString(1));
            result.moveToNext();
        }
        return produit;
    }

    public Utilisateur getUtilisateur(String user, String pass) {

        Utilisateur utilisateur = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from compteuser where user =  '" + user + "' and pass='" + pass + "'", null);
        if (result.moveToFirst())
            result.moveToFirst();
        while (result.isAfterLast() == false) {
            utilisateur = new Utilisateur(result.getString(0), result.getString(1),
                    result.getString(2), result.getString(3), result.getString(4));
            result.moveToNext();
        }

        return utilisateur;
    }

    public Exploitation getExploitation(String code) {

        Exploitation exploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation where codeExploitation = " + code, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            exploitation = new Exploitation();
            exploitation.setCinExploitant(result.getString(2));
            exploitation.setCinGerant(result.getString(1));
            exploitation.setSecteur(result.getInt(3));
            exploitation.setCodExploitation(result.getInt(0));
            exploitation.setSpTotale(result.getDouble(4));
            exploitation.setSpLabourable(result.getDouble(5));
            exploitation.setSpIrrigable(result.getDouble(6));
            exploitation.setSpCultivee(result.getDouble(7));
            exploitation.setSourceEau(result.getString(8));
            exploitation.setTypeEngrais(result.getString(9));
            exploitation.setTypeSanitaire(result.getString(10));
            exploitation.setNombresSondage(result.getInt(11));
            exploitation.setNombrePuits(result.getInt(12));
            exploitation.setNombreEmploiyer(result.getInt(13));

            result.moveToNext();
        }

        return exploitation;
    }

    public Caracteristique_exploitation getCaraExploitation(String code) {

        Caracteristique_exploitation caracteristique_exploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from CaracteristiqueExploitaton where codeExploitation = " + code, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            caracteristique_exploitation = new Caracteristique_exploitation();
            caracteristique_exploitation.setCode(result.getInt(0));
            caracteristique_exploitation.setSpTotale(result.getDouble(1));
            caracteristique_exploitation.setSpLabourable(result.getDouble(2));
            caracteristique_exploitation.setSpIrrigable(result.getDouble(3));
            caracteristique_exploitation.setSpCultivee(result.getDouble(4));
            caracteristique_exploitation.setSourceEau(result.getString(5));
            caracteristique_exploitation.setTypeEngrais(result.getString(6));
            caracteristique_exploitation.setTypeSanitaire(result.getString(7));
            caracteristique_exploitation.setNombresSondage(result.getInt(8));
            caracteristique_exploitation.setNombrePuits(result.getInt(9));
            caracteristique_exploitation.setNombreEmploiyer(result.getInt(10));

            result.moveToNext();
        }

        return caracteristique_exploitation;
    }

    public ArrayList<Caracteristique_exploitation> getAllCaraExploitation() {
        ArrayList<Caracteristique_exploitation> liste = new ArrayList<>();
        Caracteristique_exploitation caracteristique_exploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from CaracteristiqueExploitaton ", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            caracteristique_exploitation = new Caracteristique_exploitation();
            caracteristique_exploitation.setCode(result.getInt(0));
            caracteristique_exploitation.setSpTotale(result.getDouble(1));
            caracteristique_exploitation.setSpLabourable(result.getDouble(2));
            caracteristique_exploitation.setSpIrrigable(result.getDouble(3));
            caracteristique_exploitation.setSpCultivee(result.getDouble(4));
            caracteristique_exploitation.setSourceEau(result.getString(5));
            caracteristique_exploitation.setTypeEngrais(result.getString(6));
            caracteristique_exploitation.setTypeSanitaire(result.getString(7));
            caracteristique_exploitation.setNombresSondage(result.getInt(8));
            caracteristique_exploitation.setNombrePuits(result.getInt(9));
            caracteristique_exploitation.setNombreEmploiyer(result.getInt(10));
            liste.add(caracteristique_exploitation);
            result.moveToNext();
        }

        return liste;
    }

    public ArrayList<ProduitExploitation> getAllCProducExploitation() {
        ArrayList<ProduitExploitation> liste = new ArrayList<>();
        ProduitExploitation produitExploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation_TypeProduit ", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            produitExploitation = new ProduitExploitation();
            produitExploitation.setCodeTypeProduit(result.getInt(2));
            produitExploitation.setCodeProduit(result.getInt(1));
            produitExploitation.setCodeExploitation(result.getInt(0));
            produitExploitation.setCnt(result.getString(3));
            liste.add(produitExploitation);
            result.moveToNext();

        }

        return liste;
    }

    public ArrayList<ProduitExploitation> getAllProducExploitation(String code) {
        ArrayList<ProduitExploitation> liste = new ArrayList<>();
        ProduitExploitation produitExploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation_TypeProduit where Exploitation_id = " + code + " GROUP BY idP", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            produitExploitation = new ProduitExploitation();
            produitExploitation.setCodeTypeProduit(result.getInt(2));
            produitExploitation.setCodeProduit(result.getInt(1));
            produitExploitation.setCodeExploitation(result.getInt(0));
            produitExploitation.setCnt(result.getString(3));
            liste.add(produitExploitation);
            result.moveToNext();

        }

        return liste;
    }

    public ArrayList<ProduitExploitation> getExploitationTypeProduit(String code, String codeP) {
        ArrayList<ProduitExploitation> liste = new ArrayList<>();
        ProduitExploitation produitExploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation_TypeProduit where Exploitation_id = " + code + " and idP = " + codeP, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            produitExploitation = new ProduitExploitation();
            produitExploitation.setCodeTypeProduit(result.getInt(2));
            produitExploitation.setCodeProduit(result.getInt(1));
            produitExploitation.setCodeExploitation(result.getInt(0));
            produitExploitation.setCnt(result.getString(3));
            liste.add(produitExploitation);
            result.moveToNext();

        }

        return liste;
    }

    public ProduitExploitation getProducExploitation(String code, String produit) {
        ProduitExploitation produitExploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation_TypeProduit where  Exploitation_id = " + code + " and idP = " + produit, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            produitExploitation = new ProduitExploitation();
            produitExploitation.setCodeTypeProduit(result.getInt(2));
            produitExploitation.setCodeProduit(result.getInt(1));
            produitExploitation.setCodeExploitation(result.getInt(0));
            produitExploitation.setCnt(result.getString(3));
            result.moveToNext();

        }

        return produitExploitation;
    }

    public Personne getPersonne(String cin) {
        Personne personne = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Personne where cin = '"+cin+"'", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {

            personne = new Personne();
            personne.setCin(cin);
            personne.setNom(result.getString(1));
            personne.setPrenom(result.getString(2));
            personne.setGouvernorat(result.getString(3));
            personne.setDelegation(result.getString(4));
            personne.setSecteur(result.getString(5));
            personne.setCodePostale(result.getInt(6));
            personne.setSexe(result.getString(7));
            personne.setTlf(result.getString(8));
            personne.setAge(result.getInt(9));
            personne.setNiveauInstruction(result.getString(10));
            personne.setTypeFormation(result.getString(11));
            personne.setTypeDiplome(result.getString(12));
            personne.setActivitePrincipale(result.getString(13));
            personne.setnBFamileHomme(result.getInt(14));
            personne.setnBFamileFemme(result.getInt(15));
            personne.setAssurance(result.getString(16));
            personne.setEntravesDeveloppement(result.getString(17));
            personne.setCredit(result.getString(18));
            personne.setCnss(result.getString(19));
            result.moveToNext();

        }

        return personne;

    }
    public ArrayList<Personne> getAllPersonne(String cin) {
        ArrayList<Personne> personnes =new ArrayList<>() ;
        Personne personne = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Personne WHERE cin LIKE '%"+cin+"%' ", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            personne = new Personne();
            personne.setCin(result.getString(0));
            personne.setNom(result.getString(1));
            personne.setPrenom(result.getString(2));
            personne.setGouvernorat(result.getString(3));
            personne.setDelegation(result.getString(4));
            personne.setSecteur(result.getString(5));
            personne.setCodePostale(result.getInt(6));
            personne.setSexe(result.getString(7));
            personne.setTlf(result.getString(8));
            personne.setAge(result.getInt(9));
            personne.setNiveauInstruction(result.getString(10));
            personne.setTypeFormation(result.getString(11));
            personne.setTypeDiplome(result.getString(12));
            personne.setActivitePrincipale(result.getString(13));
            personne.setnBFamileHomme(result.getInt(14));
            personne.setnBFamileFemme(result.getInt(15));
            personne.setAssurance(result.getString(16));
            personne.setEntravesDeveloppement(result.getString(17));
            personne.setCredit(result.getString(18));
            personne.setCnss(result.getString(19));
            result.moveToNext();
            personnes.add(personne) ;
        }

        return personnes;

    }
    public ArrayList<Exploitation> getAllExploitation()
    {
        ArrayList<Exploitation> exploitations=new ArrayList<>() ;
        Exploitation exploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            exploitation = new Exploitation();
            exploitation.setCinExploitant(result.getString(2));
            exploitation.setCinGerant(result.getString(1));
            exploitation.setSecteur(result.getInt(3));
            exploitation.setCodExploitation(result.getInt(0));
            exploitation.setSpTotale(result.getDouble(4));
            exploitation.setSpLabourable(result.getDouble(5));
            exploitation.setSpIrrigable(result.getDouble(6));
            exploitation.setSpCultivee(result.getDouble(7));
            exploitation.setSourceEau(result.getString(8));
            exploitation.setTypeEngrais(result.getString(9));
            exploitation.setTypeSanitaire(result.getString(10));
            exploitation.setNombresSondage(result.getInt(11));
            exploitation.setNombrePuits(result.getInt(12));
            exploitation.setNombreEmploiyer(result.getInt(13));
            exploitations.add(exploitation) ;
            result.moveToNext();
        }

        return exploitations;
    }

    public ArrayList<Exploitation> RechercherExploitation(String cin )
    {
        ArrayList<Exploitation> exploitations=new ArrayList<>() ;
        Exploitation exploitation = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from Exploitation WHERE cinExploitant LIKE '%"+cin+"%' ", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            exploitation = new Exploitation();
            exploitation.setCinExploitant(result.getString(2));
            exploitation.setCinGerant(result.getString(1));
            exploitation.setSecteur(result.getInt(3));
            exploitation.setCodExploitation(result.getInt(0));
            exploitation.setSpTotale(result.getDouble(4));
            exploitation.setSpLabourable(result.getDouble(5));
            exploitation.setSpIrrigable(result.getDouble(6));
            exploitation.setSpCultivee(result.getDouble(7));
            exploitation.setSourceEau(result.getString(8));
            exploitation.setTypeEngrais(result.getString(9));
            exploitation.setTypeSanitaire(result.getString(10));
            exploitation.setNombresSondage(result.getInt(11));
            exploitation.setNombrePuits(result.getInt(12));
            exploitation.setNombreEmploiyer(result.getInt(13));
            exploitations.add(exploitation) ;
            result.moveToNext();
        }

        return exploitations;
    }
   public boolean suprimerExploitant (String cin)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("Personne","cin='"+cin+"'",null);
        if (result == -1)
            return false;
        else return true;
    }
    public boolean suprimerExploitation (String code)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("Exploitation","codeExploitation="+code,null);
        if (result == -1)
            return false;
        else return true;
    }

}

