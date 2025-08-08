package com.example.dellpc.project_pfe.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.project_pfe.Controleur.ConnectionDetector;
import com.example.dellpc.project_pfe.Json.DAOAjoutJson;
import com.example.dellpc.project_pfe.Json.DAOModificationJuson;
import com.example.dellpc.project_pfe.Model.Caracteristique_exploitation;
import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import java.util.ArrayList;

public class ViewDialogSubmit extends AppCompatDialogFragment {
ListView listView ;
ArrayList<String> list ;
 ArrayList<Integer> cntProduitEntier =new ArrayList<>();
 ArrayList<Double>cntProduitReel=new ArrayList<>() ;
    ArrayList<Integer> listTypeProduit =new ArrayList<>();
 Personne personne ;
boolean insertData ;
Context contextAjout,contextActivity ;
boolean conectionInternet ;
DAOSQlite DAOSQlite;
ConnectionDetector connectionDetector ;

Intent intent ;
Bundle bundle;
    Caracteristique_exploitation caracteristique_exploitation ;
    Exploitation exploitation ;
    EditText editTextExploitant , editTextGerant ;
    String codeProduit ;
    String valuer ;
    String codeExploitation ;
    DAOAjoutJson DAOAjoutJson;
    public ViewDialogSubmit() {

                         }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);
        String[] Assurances = getResources().getStringArray(R.array.TypeAssurance);
        String[] entrDev = getResources().getStringArray(R.array.AutravesDevelop);
        String[] nVInstrction = getResources().getStringArray(R.array.NV_inst);
        String[] formation = getResources().getStringArray(R.array.typeFormation);
        String[] diplome = getResources().getStringArray(R.array.diplome);
        String[] ActiPrn = getResources().getStringArray(R.array.activite);
        connectionDetector = new ConnectionDetector(contextActivity);
        conectionInternet= connectionDetector.isConnected() ;
        listView = (ListView)view.findViewById(R.id.listeDialog);
        list = new ArrayList<>();

        if (personne!=null)
        {
            list.add("cin : " + personne.getCin());
            list.add("nom : " + personne.getNom());
            list.add("prenom : " + personne.getPrenom());
            list.add("age : " + personne.getAge());
            list.add("adresse : " + String.valueOf(personne.getCodePostale())+" " + personne.getSecteur()+" " +personne.getDelegation()+" " +personne.getGouvernorat());
            list.add("sexe : " + personne.getSexe());
            list.add("Numéro de téléphone : " + personne.getTlf());
            list.add("cnss : " + personne.getCnss());
            list.add("niveau d'Instruction : " +nVInstrction[Integer.parseInt( personne.getNiveauInstruction())]);
            list.add("Type de Formation : " + formation[Integer.parseInt(personne.getTypeFormation())]);
            list.add("Activite Principale : " + ActiPrn[Integer.parseInt(personne.getActivitePrincipale())]);
            list.add("Nombre d'hommes membres de la famille : " + personne.getnBFamileHomme());
            list.add("Nombre de femmes membres de la famille : " + personne.getnBFamileFemme());
            list.add("Assurance : " + Assurances[Integer.parseInt(personne.getAssurance())]);
            list.add("Entraves de Developpement : " + entrDev[Integer.parseInt(personne.getEntravesDeveloppement())]);
            list.add("Credit : " + personne.getCredit());
            list.add("type de diplôme : " + diplome[Integer.parseInt(personne.getTypeDiplome())]);

         }

        else if (exploitation!=null)
        {
            list.add("cin  gerant : "+ exploitation.getCinGerant());
            list.add("cin  exploitnt : "+exploitation.getCinExploitant());
            list.add("code secteur  :  " +  String.valueOf(exploitation.getSecteur()));
            list.add("Superficie Totale : " +String.valueOf(exploitation.getSpTotale())) ;
            list.add("Superficie la bourable : "+String.valueOf(exploitation.getSpLabourable())) ;
            list.add("Superficie Cultivée : "+String.valueOf(exploitation.getSpCultivee())) ;
            list.add("Superficie irrigable : "+String.valueOf(exploitation.getSpIrrigable())) ;
            list.add("Nombre d'employés :"+String.valueOf(exploitation.getNombreEmploiyer())) ;
            list.add("Type du péimétre irrigué : "+exploitation.getSourceEau()) ;
            list.add("Nombre de puits sur l'exploitation : "+String.valueOf(exploitation.getNombrePuits())) ;
            list.add("Nombre de sontage sul l'exploitation : "+String.valueOf(exploitation.getNombresSondage()) ) ;
            list.add("Est-ce que l'engrais est utilisé ? : "+exploitation.getTypeEngrais());
            list.add("Des pesticides sont-ils utilisés? : "+exploitation.getTypeSanitaire());
        }
        else if (caracteristique_exploitation !=null )
        {
            list.add("Numero exploitation : "+String.valueOf(caracteristique_exploitation.getCode()) ) ;
            list.add("Superficie Totale : " +String.valueOf(caracteristique_exploitation.getSpTotale())) ;
            list.add("Superficie la bourable : "+String.valueOf(caracteristique_exploitation.getSpLabourable())) ;
            list.add("Superficie Cultivée : "+String.valueOf(caracteristique_exploitation.getSpCultivee())) ;
            list.add("Superficie irrigable : "+String.valueOf(caracteristique_exploitation.getSpIrrigable())) ;
            list.add("Nombre d'employés :"+String.valueOf(caracteristique_exploitation.getNombreEmploiyer())) ;
            list.add("Type du péimétre irrigué : "+caracteristique_exploitation.getSourceEau()) ;
            list.add("Nombre de puits sur l'exploitation : "+String.valueOf(caracteristique_exploitation.getNombrePuits())) ;
            list.add("Nombre de sontage sul l'exploitation : "+String.valueOf(caracteristique_exploitation.getNombresSondage()) ) ;
            list.add("Est-ce que l'engrais est utilisé ? : "+caracteristique_exploitation.getTypeEngrais());
            list.add("Des pesticides sont-ils utilisés? : "+caracteristique_exploitation.getTypeSanitaire());
        }

        CustomorAdapteur customorAdapteur = new CustomorAdapteur();
        listView.setAdapter(customorAdapteur);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view).setTitle("Voulez-vous enregistrer ?").setNegativeButton("annuler" , new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setView(view).setTitle("Voulez-vous enregistrer ?").setPositiveButton("ok" , new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            DAOAjoutJson = new DAOAjoutJson(contextAjout,contextActivity);
            DAOSQlite =new DAOSQlite(contextActivity) ;
              if (personne!=null)
              {
                    savePersonne();
              }
               else if (exploitation!=null)saveExploitation();


              else if (caracteristique_exploitation!=null)

              {
                saveCaracteristiqueExploitation();
              }

        else  saveProduit();
            }
        });
        return builder.create();
    }
    public void  setValeu(Caracteristique_exploitation caracteristique_exploitation,Exploitation exploitation ,Personne personne,Context contextAjout,Context contextActivity,Bundle bundle)
    {
        this.personne=personne  ;
        this.contextActivity=contextActivity;
        this.contextAjout=contextAjout ;
        this.bundle=bundle ;
        this.exploitation = exploitation ;
        this.caracteristique_exploitation = caracteristique_exploitation ;
    }
    public  void setEditText (EditText editTextExploitant,EditText editTextGerant)
    {
        this.editTextExploitant =editTextExploitant ;
        this.editTextGerant = editTextGerant ;

    }
    public  void seTValeuProduit(String codeProduit , String valuer , String codeExploitation,Context contextActivity,
     Context contextAjout,ArrayList<Integer> cntProduitEntier,ArrayList<Integer>listTypeProduit,ArrayList<Double>cntProduitReel)

    {
        this.codeProduit =codeProduit ;
        this.valuer = valuer ;
        this.codeExploitation =codeExploitation ;
        this.contextAjout=contextAjout ;
        this.contextActivity=contextActivity ;
        this.listTypeProduit=listTypeProduit ;
        this.cntProduitEntier=cntProduitEntier;
        this.cntProduitReel=cntProduitReel ;

    }

void saveProduit()
{
    int cntInt ;
    double cntDoublr ;
    if (conectionInternet)

            {
                if (bundle.getInt("modification") == 0)
                    DAOAjoutJson.Ajout(codeProduit,valuer,codeExploitation);
                else
                    {

                        DAOModificationJuson modificationJuson = new DAOModificationJuson(contextAjout,contextActivity);
                        modificationJuson.modifTypeProduit(codeProduit,valuer,codeExploitation);
                        //Toast.makeText(contextActivity.getApplicationContext(),"modif",Toast.LENGTH_LONG).show();

                    }

                    }

else
    {
       for (int i = 0 ; i<listTypeProduit.size();i++)
       {


           if (cntProduitReel!=null)
           {
               if (bundle.getInt("modification") != 0)
               {
                   insertData = DAOSQlite.modifDataProduitExploitation_TypeProduit(Integer.parseInt(codeExploitation),Integer.parseInt(codeProduit),String.valueOf(cntProduitReel.get(i)),listTypeProduit.get(i));
  //                 Toast.makeText(contextActivity.getApplicationContext(),String.valueOf(insertData),Toast.LENGTH_LONG).show();

               }
               else
               {
                   insertData = DAOSQlite.insertDataProduitExploitation_TypeProduit
                           (Integer.parseInt(codeExploitation),Integer.parseInt(codeProduit),String.valueOf(cntProduitReel.get(i)),listTypeProduit.get(i));

               }

           }
           else
           {
               if (bundle.getInt("modification") != 0)
               {
                   insertData = DAOSQlite.modifDataProduitExploitation_TypeProduit(Integer.parseInt(codeExploitation),Integer.parseInt(codeProduit),String.valueOf(cntProduitEntier.get(i)),listTypeProduit.get(i));
//                   Toast.makeText(contextActivity.getApplicationContext(),String.valueOf(insertData),Toast.LENGTH_LONG).show();

               }
               else
               {
                   insertData = DAOSQlite.insertDataProduitExploitation_TypeProduit
                           (Integer.parseInt(codeExploitation),Integer.parseInt(codeProduit),String.valueOf(cntProduitEntier.get(i)),listTypeProduit.get(i));
               }

           }



       }
        if (insertData)
        { Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
        }
    }
}
void savePersonne()
{

    if (!conectionInternet)
    {
        if  (bundle.getInt("modification")!=0)
        {
            insertData= DAOSQlite.modifDataPersonne(personne) ;
            if (insertData)
            {
                intent = new Intent(contextActivity.getApplicationContext(),MenuModification.class);
                Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                intent.putExtras(bundle) ;
                contextActivity.startActivity(intent);
            }

        }
       else
           {
               insertData = DAOSQlite.insertDataPersonne(personne) ;
               if (insertData)
               {
                   intent = new Intent(contextActivity.getApplicationContext(),ViewMenuAjout.class);
                   Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                   intent.putExtras(bundle) ;
                   contextActivity.startActivity(intent);
               }

           }

    }
    else
    {
        if  (bundle.getInt("modification")!=0)
        {

            DAOModificationJuson modificationJuson = new DAOModificationJuson(contextAjout,contextActivity) ;
            modificationJuson.modifPersonne(personne,bundle);
        }
        else   DAOAjoutJson.ajoutPersonne(personne,bundle);

    }
}
void saveCaracteristiqueExploitation()
{
    if (!conectionInternet)
    {
        if  (bundle.getInt("modification")!=0)
        {
            insertData = DAOSQlite.modifDataCaractristiqueExploitation(caracteristique_exploitation) ;
            if (insertData)
            {
                intent = new Intent(contextActivity.getApplicationContext(),MenuModification.class);
                Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                intent.putExtras(bundle) ;
                contextActivity.startActivity(intent);
            }
        }
        else
            {
                insertData = DAOSQlite.insertDataCaractristiqueExploitation(caracteristique_exploitation);

                if (insertData)
                {
                    intent = new Intent(contextActivity.getApplicationContext(),ViewMenuAjout.class);
                    Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                    intent.putExtras(bundle) ;
                    contextActivity.startActivity(intent);
                }
            }



    }
    else
    {
        if  (bundle.getInt("modification")!=0)
        {
            DAOModificationJuson modificationJuson = new DAOModificationJuson(contextAjout,contextActivity) ;
          //  modificationJuson.modifOccupSol(caracteristique_exploitation,bundle);
        }
        else DAOAjoutJson.ajoutOccupSol(caracteristique_exploitation, bundle);

    }
}
public void setBundle(Bundle bundle)
{
    this.bundle = bundle ;
}

void saveExploitation()
{
    if (!conectionInternet)
    {
        if (bundle.getInt("modification")!=0)
        {
            //Toast.makeText(contextActivity.getApplicationContext(),String.valueOf(exploitation.getCodExploitation()),Toast.LENGTH_LONG).show();
            insertData= DAOSQlite.modificationExploitation(exploitation);
           // insertData=false;
        }
        else
            insertData = DAOSQlite.insertDataExploitation(exploitation);

       if (insertData)

       {
           Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
           if (bundle.getInt("modification")!=0)
                intent = new Intent(contextActivity.getApplicationContext(),MenuModification.class) ;
           else
            intent = new Intent(contextActivity.getApplicationContext(),ViewMenuAjout.class) ;
            intent.putExtras(bundle) ;
           contextActivity.startActivity(intent);

       }

    }
    else
        {
            if (bundle.getInt("modification")!=0)
            {

                DAOModificationJuson modificationJuson = new DAOModificationJuson(contextAjout,contextActivity) ;
                modificationJuson.modifOccupSol(exploitation,bundle);

            }
            else     DAOAjoutJson.ajoutExploitation(exploitation, bundle,null,null);

        }
}
    class CustomorAdapteur extends BaseAdapter
    {
        public CustomorAdapteur() { }

        @Override
        public int getCount() {

            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.liste_des_lieux,null);
            TextView textView = convertView.findViewById(R.id.leux) ;
            textView.setText(list.get(position));
            return convertView ;
        }
    }
}
