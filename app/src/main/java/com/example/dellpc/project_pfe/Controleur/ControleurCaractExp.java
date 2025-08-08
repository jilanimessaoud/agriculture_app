package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Json.DAOAjoutJson;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.Model.Secteur;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape2;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape3;
import com.example.dellpc.project_pfe.View.CaracteristiquePersonneEtape1;
import com.example.dellpc.project_pfe.View.ViewMenuAjout;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtape2;
import com.example.dellpc.project_pfe.View.ViewDialogSubmit;
import com.example.dellpc.project_pfe.View.ViewLogin;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import java.util.ArrayList;

public class ControleurCaractExp implements View.OnClickListener

{

    boolean connectionInternet ;
    ConnectionDetector connectionDetector ;
    int sizeDelegation ;
    Context context  ,contextAjout;
    EditText editTextGerant  , editTextExploitant ,editTextDelegation ,editTextSecteur,editTextGouvernorat,
            editTextCodePostal,editTextNom,editTextPrenom,editTextTlf,editTextAge,editTextNbHomme,editTextNbFemme;

    RadioGroup radioGroup  ,radioGroupCnss;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4 ;
    Spinner spinnerNV,spinnerFormation ,SpinerDiplome,ActivitePrincipale ,spinnerAssurance,spinnerEntrevs ;

    DAOSQlite DAOSQlite;
    TextView textViewTiter ;
    boolean testCinGerant ,testDelegation ,testSecteur,testCinExploitant ,
            testCode,testNom ,testPrenom,testAge,testTlf,testGouvenorat ;
    Bundle bundle ;

    FragmentManager fragmentManager;

    public ControleurCaractExp() {
    }

    /// constructor pout class caracteristiquePersonne Etape 3
    public ControleurCaractExp(Context context, RadioGroup radioGroup, RadioGroup radioGroupCnss, RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, Spinner spinnerNV, Spinner spinnerFormation, Bundle bundle, Context contextAjout, FragmentManager fragmentManager) {
        this.context = context;
        this.radioGroup = radioGroup;
        this.radioGroupCnss = radioGroupCnss;
        this.radioButton1 = radioButton1;
        this.radioButton2 = radioButton2;
        this.radioButton3 = radioButton3;
        this.radioButton4 = radioButton4;
        this.spinnerAssurance = spinnerNV;
        this.spinnerEntrevs = spinnerFormation;
        this.bundle =bundle ;
        this.fragmentManager=fragmentManager ;
        this.contextAjout=contextAjout;
    }
//constructor pour class CaracteristiquePersonneEtape2
    public ControleurCaractExp(Context context, EditText editTextNbHomme, EditText editTextNbFemme, RadioGroup radioGroup, RadioButton radioButton1, RadioButton radioButton2, Spinner spinnerNV, Spinner spinnerFormation, Spinner spinerDiplome, Spinner activitePrincipale, Bundle bundle) {
        this.context = context;
        this.editTextNbHomme = editTextNbHomme;
        this.editTextNbFemme = editTextNbFemme;
        this.radioGroup = radioGroup;
        this.radioButton1 = radioButton1;
        this.radioButton2 = radioButton2;
        this.spinnerNV = spinnerNV;
        this.spinnerFormation = spinnerFormation;
        this.SpinerDiplome = spinerDiplome;
        ActivitePrincipale = activitePrincipale;
        this.bundle=bundle ;
    }
    //constructor pour class Identification Exploitation
    public ControleurCaractExp(Context context, EditText editTextGerant, EditText
            editTextExploitant, EditText editTextDelegation, EditText editTextSecteur, Context contextAjout, Bundle bundle, FragmentManager fragmentManager) {
        this.context = context;
        this.editTextGerant = editTextGerant;
        this.editTextExploitant = editTextExploitant;
        this.editTextDelegation = editTextDelegation;
        this.editTextSecteur = editTextSecteur;
        this.contextAjout=contextAjout ;
        this.bundle=bundle ;
        this.fragmentManager=fragmentManager ;


    }
    //constructor pour class CaracteristiquePersonneEtape1
    public ControleurCaractExp(Context context, EditText editTextExploitant, EditText editTextDelegation, EditText editTextSecteur,
                               EditText editTextGouvernorat, EditText editTextCodePostal, EditText editTextNom, EditText
                                                        editTextPrenom, EditText editTextTlf, EditText editTextAge, RadioGroup radioGroup, TextView textView, RadioButton radioButton, RadioButton radioButton1, Bundle bundle) {
        this.context = context;
        this.editTextExploitant = editTextExploitant;
        this.editTextDelegation = editTextDelegation;
        this.editTextSecteur = editTextSecteur;
        this.editTextGouvernorat = editTextGouvernorat;
        this.editTextCodePostal = editTextCodePostal;
        this.editTextNom = editTextNom;
        this.editTextPrenom = editTextPrenom;
        this.editTextTlf = editTextTlf;
        this.editTextAge = editTextAge;
        this.radioGroup = radioGroup;
        this.textViewTiter = textView ;
        this.radioButton1=radioButton ;
        this.radioButton2=radioButton1;
        this.bundle = bundle ;

    }


    // Vérifiez que le texte ne contient que des caractères
    boolean testToString (String text)
    {

        String Alpha= "AZERTYUIOPQSDFGHJKLMWXCVBN ";
        boolean test =true ;
        if (text.length()<3 ) return false ;
        for (int i =0 ;i<text.length();i++)
        {
            int positionCar = Alpha.indexOf(String.valueOf(text.charAt(i)));
            if (positionCar==-1)

            {
                return false ;
            }

        }
        return test ;
    }

// Vérifiez que le texte ne contient que des chiffres

    boolean testTextNumber (String text )
    {
        if (text.length()==0 ) return false ;
        String carCin = "1234567890" ;
        boolean test =true ;
        for (int i =0 ;i<text.length();i++)
        {
            int positionCar = carCin.indexOf(String.valueOf(text.charAt(i)));
            if (positionCar==-1)

            {
                return false ;
            }

        }
        return test ;
    }
    // Vérifier que la longueur du texte égale 8 (cin =8 )
    boolean testLong(String text)
    {
        return text.length()==8 ;
    }
    // veifier que le longuer du text = size(size >>>listeSecteur )
  public   boolean testSize(String text , int size)
    {

        if (testTextNumber(text))
        {  if (!(Integer.parseInt(text)>0&&Integer.parseInt(text)<=11)){return false ; }
            if (Integer.parseInt(text)>size){return false ;}
            else
                return  true ;
        }
        else return false ;

    }
    // verifier que le code secteur existe dans mon base de donné
   public boolean testCodeSecteur (boolean testDelegation)
    {
        if (!testTextNumber(editTextSecteur.getText().toString()))return false ;
        ///verifier que code de secteur a été  saisir>= primier elem de listeSeecteur
        boolean test1ErCode ;
        // verifier que  code de secteur a été saisir <= dernier elem
        boolean testFinCode ;
        if (testDelegation == false) return false ;
        ArrayList<Secteur> secteurs = new ArrayList<>() ;
        secteurs = DAOSQlite.getAllSecteur(editTextDelegation.getText().toString());
        test1ErCode = Integer.valueOf(editTextSecteur.getText().toString())>=secteurs.get(0).getCode_secteur();
        testFinCode =Integer.valueOf(editTextSecteur.getText().toString())<=secteurs.get(secteurs.size()-1).getCode_secteur();
        if (test1ErCode&&testFinCode)return true ;
        else return false ;
    }
    // verifier age >18 et <80
    boolean testAge(String text)
    {
        if (!testTextNumber(text)) return false ;
        else return Integer.parseInt(text)>18&&Integer.parseInt(text)<80 ;
    }
    // vérifier que cin , nom , prenom , age , numero tlf code postal , gouvernorat ,secteur ,delegation
    Boolean testStarActivityPersonneEtape1 ()
    {

        testCinExploitant = testTextNumber(
                editTextExploitant.getText().toString())
                &&
                testLong(editTextExploitant.getText().toString());
        testNom = testToString(editTextNom.getText().toString().toUpperCase().trim());
        testPrenom =  testToString(editTextPrenom.getText().toString().toUpperCase().trim());
        testAge = testAge(editTextAge.getText().toString());
        testTlf = testTextNumber(editTextTlf.getText().toString());
        testCode = testTextNumber(editTextCodePostal.getText().toString());
        testGouvenorat = testToString(editTextGouvernorat.getText().toString().toUpperCase().trim());
        testSecteur = testToString(editTextSecteur.getText().toString().toUpperCase().trim());
        testDelegation = testToString(editTextDelegation.getText().toString().toUpperCase().trim());
        if (testCinExploitant==false)editTextExploitant.setError("Se compose de 8 chiffres");
        if (!testNom) editTextNom.setError("Vérifiez le nom");
        if (!testPrenom) editTextPrenom.setError("Vérifiez le Prénom");
        if (!testAge) editTextAge.setError("Vérifiez le age");
        if (!testTlf) editTextTlf.setError("Vérifiez Numéro de téléphone");
        if (!testCode) editTextCodePostal.setError("Vérifiez Cd Postal");
        if (!testGouvenorat)editTextGouvernorat.setError("Vérifiez Gouvernorat");
        if (!testDelegation)editTextDelegation.setError("Vérifiez delegation");
        if (!testSecteur)editTextSecteur.setError("Vérifiez Secteur");
        return testSecteur&&testDelegation&&testGouvenorat&&testCinExploitant&&testNom&&testPrenom&&testAge&&testTlf&&testCode&&testGouvenorat;
    }

    private void passCarecteristiquePerssoneEtape2()
    {
        Intent intent = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape3.class);
        bundle.putInt("etape",1);
        boolean testNBhomme = testTextNumber(editTextNbHomme.getText().toString());
        boolean testFemme = testTextNumber(editTextNbFemme.getText().toString());
        if (!testNBhomme) editTextNbHomme.setError("Se compose de nombres");
        if (!testFemme)editTextNbFemme.setError("Se compose de nombres");
        if (testFemme&&testNBhomme)
        {

            bundle.putString("NV",String.valueOf(spinnerNV.getSelectedItemPosition()));
            bundle.putString("Formation",String.valueOf(spinnerFormation.getSelectedItemPosition()));
            bundle.putString("Diplome",String.valueOf(SpinerDiplome.getSelectedItemPosition()));
            bundle.putString("principale",String.valueOf(ActivitePrincipale.getSelectedItemPosition()));

            bundle.putString("homme",editTextNbHomme.getText().toString());
            bundle.putString("femme",editTextNbFemme.getText().toString());
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }
    void  setBundel ()
    {
        if (radioGroup.getCheckedRadioButtonId()==R.id.radioButton)
        {
            bundle.putString("sexe",radioButton1.getText().toString());
          //  Toast.makeText(context.getApplicationContext(),radioButton1.getText().toString(),Toast.LENGTH_LONG).show();
        }
        else
        {
            bundle.putString("sexe",radioButton2.getText().toString());
        //    Toast.makeText(context.getApplicationContext(),radioButton2.getText().toString(),Toast.LENGTH_LONG).show();
        }
        bundle.putString("cin",editTextExploitant.getText().toString());
        bundle.putString("age",editTextAge.getText().toString());
        bundle.putString("postale",editTextCodePostal.getText().toString());
        bundle.putString("nom",editTextNom.getText().toString());
        bundle.putString("penom",editTextPrenom.getText().toString());
        bundle.putString("tlf",editTextTlf.getText().toString());
        bundle.putString("gouvernorat",editTextGouvernorat.getText().toString());
        bundle.putString("secteur",editTextSecteur.getText().toString());
        bundle.putString("delegation",editTextDelegation.getText().toString());

    }

    //passe a caracteristiqueExploitation etape 1
    void passCaracteristiqueExploitation()
    {
        testCinGerant = testTextNumber(editTextGerant.getText().toString())&&testLong(editTextGerant.getText().toString());
        testDelegation = testSize(editTextDelegation.getText().toString(),sizeDelegation);
        testSecteur =testCodeSecteur(testDelegation);
        testCinExploitant = testTextNumber(editTextExploitant.getText().toString())&&
                testLong(editTextExploitant.getText().toString());
        if (testCinGerant==false)editTextGerant.setError("Se compose de 8 chiffres");
        if (testCinExploitant==false)editTextExploitant.setError("Se compose de 8 chiffres");
        if (testDelegation==false){ editTextDelegation.setError("Svp Verfier code de Delegation"); }
        if (testSecteur==false){ editTextSecteur.setError("Svp verifier code de secteur");}
        if (testSecteur&&testDelegation&&testCinExploitant&&testCinGerant) {

          Intent intent = new Intent(contextAjout.getApplicationContext(),CaracteristiqueExploitationEtape2.class) ;
          bundle.putString("cinGerant",editTextGerant.getText().toString());
          bundle.putString("cinExploitant",editTextExploitant.getText().toString());
          bundle.putInt("Codesecteur",Integer.parseInt(editTextSecteur.getText().toString())); ;
          intent.putExtras(bundle) ;

          if (!connectionInternet)
          {
              Personne gerant = DAOSQlite.getPersonne(editTextGerant.getText().toString()) ;
              Personne exploitant  = DAOSQlite.getPersonne(editTextExploitant.getText().toString()) ;
              if (gerant==null)
              {
                editTextGerant.setError(editTextGerant.getHint().toString()+" N'existe pas" );
              }
              if (exploitant==null)
              {
                editTextExploitant.setError(editTextExploitant.getHint().toString()+" N'existe pas");
              }
              if (gerant!=null&&exploitant!=null) contextAjout.startActivity(intent);

          }
            else
            {
                DAOAjoutJson DAOAjoutJson = new DAOAjoutJson(contextAjout,context) ;
                DAOAjoutJson.ajoutExploitation(null,bundle,editTextGerant,editTextExploitant);
            }
        /*  Exploitation exploitation = new Exploitation();
          exploitation.setCinExploitant(editTextExploitant.getText().toString());
          exploitation.setCinGerant(editTextGerant.getText().toString());
          exploitation.setSecteur(Integer.parseInt(editTextSecteur.getText().toString()));
 if (!connectionInternet) contextAjout.startActivity(intent);
            else
                {
                    DAOAjoutJson ajoutJuson = new DAOAjoutJson(contextAjout,context) ;
                    ajoutJuson.ajoutExploitation(null,bundle,editTextGerant,editTextExploitant);
                }

          ViewDialogSubmit viewDialogSubmit = new ViewDialogSubmit() ;

          viewDialogSubmit.setEditText(editTextExploitant,editTextGerant);
          viewDialogSubmit.setValeu(null,exploitation,null,contextAjout,context,bundle);
          viewDialogSubmit.show(fragmentManager,"ok");
        */
        }





        // if(!DAOSQlite.recherchExploitant(editTextExploitant.getText().toString()))editTextExploitant.setError("Ne existe pas");
  //      if(!DAOSQlite.recherchExploitant(editTextGerant.getText().toString()))editTextGerant.setError("Ne existe pas");

    //    if (DAOSQlite.recherchExploitant(editTextGerant.getText().toString())&&testCinGerant&&testCinExploitant&&testDelegation&&testSecteur&&DAOSQlite.recherchExploitant(editTextExploitant.getText().toString()))
      //  {

        //    boolean insert = DAOSQlite.insertDataExploitation(exploitation);

          // if (!insert)Toast.makeText(context.getApplicationContext(),"Existe déjà",Toast.LENGTH_LONG).show();
           // else
               // {
         //           Toast.makeText(context.getApplicationContext(),"L'opération s'est terminée avec succès",Toast.LENGTH_LONG).show();

             //   }
        //}

    }

    void passActivityCaracteristiquePersEtap2()
    {
        setBundel();
        //etape pour verifier Rang de activity
        bundle.putInt("etape",1);
        Intent intentExploitant = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape2.class);
        intentExploitant.putExtras(bundle) ;
        if (testStarActivityPersonneEtape1())

        {
            if (connectionInternet)
            {
               // Toast.makeText(context.getApplicationContext(),"S",Toast.LENGTH_LONG).show();
                DAOAjoutJson daoAjoutJson = new DAOAjoutJson(context,contextAjout) ;
                daoAjoutJson.getExploitant( editTextExploitant,bundle);

            }
            else
                {
                     DAOSQlite daosQlite = new DAOSQlite(context);
                     Personne p = daosQlite.getPersonne(editTextExploitant.getText().toString()) ;
                     if (p==null)
                     {
                         if  (bundle.getInt("modification")==0) {

                             context.startActivity(intentExploitant);
                         }
                         else
                             {
                                 editTextExploitant.setError(editTextExploitant.getHint().toString() + " N'existe pas");
                             }
                     }
                     else {

                         if (bundle.getInt("modification") == 0) {

                             editTextExploitant.setError(editTextExploitant.getHint().toString() + " Déja existe");

                         }
                         else context.startActivity(intentExploitant);

                     }
                }

        }

    }
void getPersonne(Personne personne)

{
    String assurance = String.valueOf(spinnerAssurance.getSelectedItemPosition())  ;
    String AntrDev =String.valueOf(spinnerEntrevs.getSelectedItemPosition());
    String credit ="";
    String cnss="" ;

    if (radioGroup.getCheckedRadioButtonId()==R.id.CrediNon)
    {
        credit = radioButton2.getText().toString();
    }
    else
    {
        credit = radioButton1.getText().toString();

    }
    //  credit = radioButton3.getText().toString();
    if (radioGroupCnss.getCheckedRadioButtonId()==R.id.CNSsOui)
    {
        cnss = radioButton3.getText().toString();
    }
    else
    {
        cnss = radioButton4.getText().toString();
    }


    personne.setCin(bundle.getString("cin"));
    personne.setAge(Integer.parseInt(bundle.getString("age")));
    personne.setNom(bundle.getString("nom"));
    personne.setPrenom(bundle.getString("penom"));
    personne.setTlf(bundle.getString("tlf"));
    personne.setSexe(bundle.getString("sexe"));
    personne.setGouvernorat(bundle.getString("gouvernorat"));
    personne.setCodePostale(Integer.parseInt(bundle.getString("postale")));
    personne.setDelegation(bundle.getString("delegation"));
    personne.setSecteur(bundle.getString("secteur"));
    personne.setNiveauInstruction(bundle.getString("NV"));
    personne.setTypeFormation(bundle.getString("Formation"));
    personne.setTypeDiplome(bundle.getString("Diplome"));
    personne.setActivitePrincipale(bundle.getString("principale"));
    personne.setnBFamileFemme(Integer.parseInt(bundle.getString("femme")));
    personne.setnBFamileHomme(Integer.parseInt(bundle.getString("homme")));
    personne.setEntravesDeveloppement(AntrDev);
    personne.setCredit(credit);
    personne.setCnss(cnss);
    personne.setAssurance(assurance);

}
   // sauvegarder une personne
   void  savePersonne()
   {
       Personne personne = new Personne() ;
       getPersonne(personne);
       ViewDialogSubmit viewDialogSubmit = new ViewDialogSubmit() ;
       viewDialogSubmit.setValeu(null,null,personne,contextAjout,context,bundle);
       viewDialogSubmit.show(fragmentManager,"ok");


       // Toast.makeText(context.getApplicationContext(),personne.toString(),Toast.LENGTH_LONG).show();

      /* boolean insert = DAOSQlite.insertDataPersonne(personne);
       if (!insert)Toast.makeText(context.getApplicationContext(),"Existe déjà",Toast.LENGTH_LONG).show();
       else
       {
           Toast.makeText(context.getApplicationContext(),"L'opération s'est terminée avec succès",Toast.LENGTH_LONG).show();
           Intent intent= new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape1.class);
           bundle.putInt("etape",1);
           intent.putExtras(bundle);
           context.startActivity(intent);
       }*/
   }
    @Override
    public void onClick(View v) {
        //test connection a internet
        connectionDetector = new ConnectionDetector(context) ;
        connectionInternet = connectionDetector.isConnected();
        /// class dans package database
        // contient tout les méthodes nécessaire pour ajout et modification , suppression du données
        DAOSQlite = new DAOSQlite(context) ;

        /// methode dans DAOSQlite >>> recuperation liste de delegation
        sizeDelegation = DAOSQlite.getAllDelegation().size();

        switch(v.getId())
        {
            ///button dans activity dans  identification exploitation
            // buttonSave pour enregistrer un exploitation


                case R.id.imageButtonsuivant :
                //button dans activity caracteristique personne etape 1
                // passe a  activity caracteristique personne etape 2
                passActivityCaracteristiquePersEtap2();
                break;

            // button dans activity caracteristique personne etape 2
            // passe a  activity carecterestique personne etape 3
            case R.id.suivCarectristiqueExplEtap2 :
                passCarecteristiquePerssoneEtape2(); ;
                break;
            case  R.id.exit :
                //button dans activity identification exploitation ,personne
                // Retourner à la Activity login
                Intent intent = new Intent(context.getApplicationContext(),ViewLogin.class) ;
                bundle.putInt("etape",2);
                intent.putExtras(bundle) ;
                context.startActivity(intent);
                break;
            //button dans activity caracteristique personne etape 2
            // Retourner à la Activity caracterisitique personne etape  1

                case  R.id.predCarectristiqueExplEtap2 :
                Intent intent1 = new Intent(context.getApplicationContext(),CaracteristiquePersonneEtape1.class) ;
                bundle.putInt("etape",2);
                intent1.putExtras(bundle);
                context.startActivity(intent1);

                break;
            //button dans activity caracteristique persoone etape 3
            // Retourner à la Activity caracterisitique personne etape  2
            case R.id.predCarectristiqueExplEtap3:
                bundle.putInt("etape",2);
                Intent intent2 = new Intent(context.getApplicationContext(), CaracteristiquePersonneEtape2.class);
                intent2.putExtras(bundle);
                context.startActivity(intent2);
                break;
            case R.id.SavePerson:
                // button dans activity caracteristique personne etape 3
                // Inscrire une personne
                savePersonne();

                break;

            case R.id.Retour :
                intent = new Intent(contextAjout.getApplicationContext(),ViewMenuAjout.class) ;
                intent.putExtras(bundle) ;
                contextAjout.startActivity(intent);
                break;
            // button dans activityIdentification Exploitation
            case R.id.suivant :
                passCaracteristiqueExploitation();

                break;

            case R.id.imageButtonPred:
                intent = new Intent(context.getApplicationContext(),ViewMenuAjout.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                break;

        }
    }
}
