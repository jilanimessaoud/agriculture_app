package com.example.dellpc.project_pfe.Controleur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtape2;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtpae3;
import com.example.dellpc.project_pfe.View.DoalogVerfieirNExploitation;
import com.example.dellpc.project_pfe.View.ViewMenuAjout;
import com.example.dellpc.project_pfe.View.ViewDialogSubmit;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

public class ControleurOccupSol implements View.OnClickListener
{
    Exploitation exploitation ;
    Context context,contextAjout ;
EditText t_superficieTotale ,t_superficieLabourable,t_superficieCultiv ,t_superIrrigable,t_NbEmpl ,nbPuit,nbSondage,textCode;
RadioButton radioButtonPrive,radioButtonPublic , radioButtonSint,radioButtonNotsint,radioButtonEngrais,radioButtonNotengrais ;
RadioGroup radioGroupTypeIrrg , radioGroupSintaire,radioGroupEnagrais ;
Bundle bundle ;
String typeENg = "", sintaire = "", typeIrrg;
FragmentManager fragmentManager ;

DAOSQlite DAOSQlite;
ConnectionDetector connectionDetector;
boolean connectionInternet ;
    /// controleur pour activity ooccupation su sol etape 1
public ControleurOccupSol(
        Context context, EditText t_superficieTotale, EditText t_superficieLabourable, EditText t_superficieCultiv, EditText t_superIrrigable, EditText t_NbEmpl,Bundle bundle,FragmentManager fragmentManager,EditText editText,Context contextAjout) {
    this.context = context;
    this.t_superficieTotale = t_superficieTotale;
    this.t_superficieLabourable = t_superficieLabourable;
    this.t_superficieCultiv = t_superficieCultiv;
    this.t_superIrrigable = t_superIrrigable;
    this.t_NbEmpl = t_NbEmpl;
    this.bundle=bundle ;
    this.fragmentManager=fragmentManager ;
    this.textCode=editText ;
    this.contextAjout=contextAjout;

}
    /// controleur pour activity ooccupation su sol etape 2
    public ControleurOccupSol(Context context, EditText nbPuit,
                              EditText nbSondage, RadioButton radioButtonPrive,
                              RadioButton radioButtonPublic, RadioButton radioButtonSint,
                              RadioButton radioButtonNotsint, RadioButton radioButtonEngrais, RadioButton radioButtonNotengrais, RadioGroup radioGroupTypeIrrg, RadioGroup radioGroupSintaire, RadioGroup radioGroupEnagrais,Bundle bundle,Context contextAjout, FragmentManager fragmentManager ) {
        this.context = context;
        this.nbPuit = nbPuit;
        this.nbSondage = nbSondage;
        this.radioButtonPrive = radioButtonPrive;
        this.radioButtonPublic = radioButtonPublic;
        this.radioButtonSint = radioButtonSint;
        this.radioButtonNotsint = radioButtonNotsint;
        this.radioButtonEngrais = radioButtonEngrais;
        this.radioButtonNotengrais = radioButtonNotengrais;
        this.radioGroupTypeIrrg = radioGroupTypeIrrg;
        this.radioGroupSintaire = radioGroupSintaire;
        this.radioGroupEnagrais = radioGroupEnagrais;
        this.bundle=bundle ;
        this.contextAjout = contextAjout ;
        this.fragmentManager=fragmentManager ;
    }
/// verifier validite EditText
    boolean testEditTExt()
    {
        if (!testTextDouble(t_superficieCultiv.getText().toString())){t_superficieCultiv.setError("Vérifier "+t_superficieCultiv.getHint().toString());}
        if (!testTextDouble(t_superficieLabourable.getText().toString())){t_superficieLabourable.setError("Vérifier "+t_superficieLabourable.getHint().toString());}
        if (!testTextDouble(t_superficieTotale.getText().toString())){t_superficieTotale.setError("Vérifier "+t_superficieTotale.getHint().toString());}
        if (!testTextDouble(t_superIrrigable.getText().toString())){t_superIrrigable.setError("Vérifier "+t_superIrrigable.getHint().toString());}
        if (!testTextInteger(t_NbEmpl.getText().toString())){t_NbEmpl.setError("Vérifier "+t_NbEmpl.getHint().toString());}

        return  testTextDouble(t_superficieCultiv.getText().toString())&&testTextDouble(t_superficieLabourable.getText().toString())&&
               testTextDouble(t_superficieTotale.getText().toString())&&
                testTextInteger(t_NbEmpl.getText().toString())&&testTextDouble(t_superIrrigable.getText().toString());
    }
    //methode pour verifier que text est double
    boolean testTextDouble (String text ) {
        try {
            Double.parseDouble(text);
           return true ;
            }
            catch (Exception e)
            {
                return false ;
            }
    }
    //methode pour verifier que text est Integer
    boolean testTextInteger (String text ) {
        try {
            Integer.parseInt(text);
            return true ;
        }
        catch (Exception e)
        {
            return false ;
        }
    }
    void getCaracteristiqueExploitation ()
    {
        DAOSQlite = new DAOSQlite(context);
        getValueButtonRadio();
        //caracteristique_exploitation = new Caracteristique_exploitation();
         exploitation=new Exploitation();
        if (bundle.getInt("modification")!=0)
        {
            exploitation.setCodExploitation(Integer.parseInt(bundle.getString("numeroExploiataion")));
        }
            exploitation.setCinExploitant(bundle.getString("cinExploitant"));
         exploitation.setCinGerant(bundle.getString("cinGerant"));
         exploitation.setSecteur(bundle.getInt("Codesecteur"));
         exploitation.setNombreEmploiyer(Integer.parseInt(bundle.getString("NbEmpl")));
        if (testTextInteger(nbPuit.getText().toString()))
            exploitation.setNombrePuits(Integer.parseInt(nbPuit.getText().toString()));
        else nbPuit.setError("Vérifier " + nbPuit.getHint().toString());
        if (testTextInteger(nbSondage.getText().toString()))
            exploitation.setNombresSondage(Integer.parseInt(nbSondage.getText().toString()));
        else nbSondage.setError("Vérifier " + nbSondage.getHint().toString());

        exploitation.setSourceEau(typeIrrg);
        exploitation.setSpCultivee(Double.parseDouble(bundle.getString("superficieCultiv")));
        exploitation.setSpIrrigable(Double.parseDouble(bundle.getString("superIrrigable")));
        exploitation.setSpLabourable(Double.parseDouble(bundle.getString("superficieLabourable")));
        exploitation.setSpTotale(Double.parseDouble(bundle.getString("superficieTotale")));
        exploitation.setTypeEngrais(typeENg);
        exploitation.setTypeSanitaire(sintaire);

    }
    //methode pour Sauvegarder un  caracteristique de exploitation
    void saveCaraccrerisitiqueExploitaton() {

        getCaracteristiqueExploitation () ;

        if (testTextInteger(nbSondage.getText().toString()) && testTextInteger(nbPuit.getText().toString()))
        {

           //boolean insert =  DAOSQlite.insertDataCaractristiqueExploitation(caracteristique_exploitation);
            //   DAOAjoutJson ajoutJuson = new DAOAjoutJson(contextAjout,context);
        //    ViewDialogSubmit viewDialogSubmit  = new ViewDialogSubmit();
          //  viewDialogSubmit.setValeu(caracteristique_exploitation,null,null,contextAjout,context,bundle);
           // viewDialogSubmit.show(fragmentManager,null);

            ViewDialogSubmit viewDialogSubmit = new ViewDialogSubmit() ;
            viewDialogSubmit.setBundle(bundle);
            viewDialogSubmit.setValeu(null,exploitation,null,contextAjout,context,bundle);
            viewDialogSubmit.show(fragmentManager,"ok");

        }
    }
    void setBundel()
    {
        bundle.putString("superficieTotale",t_superficieTotale.getText().toString());
        bundle.putString("superficieLabourable",t_superficieLabourable.getText().toString());
        bundle.putString("superficieCultiv",t_superficieCultiv.getText().toString());
        bundle.putString("superIrrigable",t_superIrrigable.getText().toString());
        bundle.putString("NbEmpl",t_NbEmpl.getText().toString());
    }
void getValueButtonRadio()
{
    if (radioGroupEnagrais.getCheckedRadioButtonId() == R.id.engrais) {
        typeENg = radioButtonEngrais.getText().toString();
    } else {
        typeENg = radioButtonNotengrais.getText().toString();

    }
    if (radioGroupSintaire.getCheckedRadioButtonId() == R.id.sinitaire) {
        sintaire = radioButtonSint.getText().toString();
    } else {
        sintaire = radioButtonNotsint.getText().toString();

    }

    if (radioGroupTypeIrrg.getCheckedRadioButtonId() == R.id.radioButtonprive) {
        typeIrrg = radioButtonPrive.getText().toString();
    } else {
        typeIrrg = radioButtonPublic.getText().toString();

    }

}
//verifier que t_superficieCultiv +t_superIrrigable+t_superficieLabourable<=t_superficieTotale
boolean  testSpTotale ()
        {

          if (Double.parseDouble(t_superficieCultiv.getText().toString())
                  +Double.parseDouble(t_superIrrigable.getText().toString())
                  +Double.parseDouble(t_superficieLabourable.getText().toString())>Double.parseDouble(t_superficieTotale.getText().toString()))
          {
              t_superficieTotale.setError(t_superficieCultiv.getHint().toString()+" + "+t_superficieLabourable.getHint().toString()+" + "+t_superIrrigable.getHint().toString()+" > "+t_superficieTotale.getHint().toString());
          return false ;
          }

            else return true ;
        }
//test code d'exploitation existe

    @Override
    public void onClick(View v) {
    DAOSQlite =new DAOSQlite(context);
    connectionDetector = new ConnectionDetector(context) ;
    connectionInternet = connectionDetector.isConnected();
    Intent intent ;
            switch (v.getId())
            {
                ///
                // button dans activity occupation du sol etape 1 pour retourner a activity ViewMenuAjout

                case  R.id.imageButtonPredOccup :
                    intent = new Intent(context.getApplicationContext(),ViewMenuAjout.class);
                    bundle.putInt("etape",2);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    break;
                // button dans activity occupation du sol etape 1 pour passe a activity CaracteristiqueExploitationEtpae3

                case R.id.imageButtonSuivaOccup :

                    intent = new Intent(context.getApplicationContext(),CaracteristiqueExploitationEtpae3.class);
                    intent.putExtras(bundle);
                    boolean test = testEditTExt();
                    boolean existeExploitation = true;
                    boolean existeCaracteristiqueExploitation = true;
                    if (!connectionInternet)
                    {
                    }
                    if (test&&existeExploitation&&existeCaracteristiqueExploitation)
                    {

                        bundle.putInt("etape",1);
                        setBundel();
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                    break;
                // button dans activity occupation du sol etape 2 pour retour a activity CaracteristiqueExploitationEtape2
                case R.id.imageButtonretourOcup2:

                    intent = new Intent(context.getApplicationContext(),CaracteristiqueExploitationEtape2.class);
                    bundle.putInt("etape",2);
                    intent.putExtras(bundle);
                    context.startActivity(intent); break;
                // button dans activity occupation du sol etape 2 pour sauvegarder un  exploitation
                case R.id.buttonSaveOccup :
                    saveCaraccrerisitiqueExploitaton();
                    break;
                case R.id.info :
                    DoalogVerfieirNExploitation viewDialogInfoOcpSol = new DoalogVerfieirNExploitation() ;
                    viewDialogInfoOcpSol.setContext(contextAjout,context);
                    viewDialogInfoOcpSol.setCheckModification(false,true,false,true);
                    viewDialogInfoOcpSol.show(fragmentManager,"ok");
                    break;
            }
    }



}
