package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.Model.Produit;
import com.example.dellpc.project_pfe.Model.TypeProduit;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.View.MenuModification;
import com.example.dellpc.project_pfe.View.CaracteristiqueExploitationEtape2;
import com.example.dellpc.project_pfe.View.ProduitExploitation;
import com.example.dellpc.project_pfe.View.ViewDialogSubmit;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DAOModificationJuson
{
    ArrayList<String> listLebelProduit=new ArrayList<>() ;
    ArrayList<Double>listeValeurDouble  =new ArrayList<>() ;
    ArrayList<Integer>listeValeurInteger  =new ArrayList<>() ;

    Context contextModification  ,contextActivity;
    DAOSQlite DAOSQlite;
    public DAOModificationJuson(Context contextModification, Context contextActivity) {
        this.contextModification = contextModification;
        this.contextActivity = contextActivity;
    }
    public void modifPersonne(final Personne personne, final Bundle bundle)
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                boolean    test_modif =    jsonResponse.getBoolean("test_modif");
                    if (test_modif)

                    {
                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();

                        Intent   intent = new Intent(contextActivity.getApplicationContext(),MenuModification.class);
                        intent.putExtras(bundle) ;contextActivity.startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(contextActivity.getApplicationContext(),"Modifier au moins un champ",Toast.LENGTH_LONG).show();
                    }
                   } catch (JSONException e)
                {

                    e.printStackTrace();

                }

            }

        };
        RequesteModificationExploitant valeurAjout = new RequesteModificationExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",personne.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(valeurAjout);


    }
    public void chercher(final EditText codeExploitation, final EditText gerant, final EditText exploitant , final EditText codedelegation , final EditText codeSecteur, final int idButton, final Bundle bundle)
    {
        DAOSQlite =new DAOSQlite(contextActivity) ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
               //       Toast.makeText(contextActivity.getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
                   Boolean testModify = jsonResponse.getBoolean("testExist") ;
                    if (testModify)
                    {
                       if (idButton!=R.id.suivant)
                       {
                           gerant.setText(jsonResponse.getString("gerant"));
                           exploitant.setText(jsonResponse.getString("exploitant"));
                           codeSecteur.setText(jsonResponse.getString("secteur"));
                           codedelegation.setText(DAOSQlite.getDelegation(jsonResponse.getString("secteur")));

                       }
                       else
                           {
                               Intent intent = new Intent(contextActivity.getApplicationContext(),CaracteristiqueExploitationEtape2.class) ;
                               bundle.putString("cinGerant",gerant.getText().toString());
                               bundle.putString("cinExploitant",exploitant.getText().toString());
                               bundle.putInt("Codesecteur",Integer.parseInt(codeSecteur.getText().toString())); ;
                               bundle.putString("numeroExploiataion",codeExploitation.getText().toString()); ;
                               intent.putExtras(bundle) ;
                               contextActivity.startActivity(intent);
                           }
                    }
                    else
                    {
                        if (idButton==R.id.suivant)
                        codeExploitation.setError("Vérifier " + codeExploitation.getHint().toString());
                    }

                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteSuprimExploitation valeurAjout = new RequesteSuprimExploitation("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",codeExploitation.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(valeurAjout);


    }

    public void getCarcteristiqueExpEtape1(final EditText spt, final EditText spLp, final EditText spClt , final EditText spIrr , final EditText nbEmpl, final String nExploitation)
    {
        DAOSQlite =new DAOSQlite(contextActivity) ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    Boolean testModify = jsonResponse.getBoolean("testExist") ;
                    if (testModify)
                    {
                        spt.setText(jsonResponse.getString("Sptotale"));
                        spClt.setText(jsonResponse.getString("spcltive"));
                        spLp.setText(jsonResponse.getString("Splap"));
                        spIrr.setText(jsonResponse.getString("spirrg"));
                        nbEmpl.setText(jsonResponse.getString("nbEmp"));

                       }
                    else
                    {
                      //  codeExploitation.setError("Vérifier " + codeExploitation.getHint().toString());
                    }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteModificationCarcExplEtape1 valeurAjout = new RequesteModificationCarcExplEtape1("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",nExploitation,responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(valeurAjout);


    }
    public void modifOccupSol(final Exploitation exploitation,  final Bundle bundle)
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean test_Modif = jsonResponse.getBoolean("test_Modif");
                    if (test_Modif)
                    {
                        Intent intent = new Intent(contextActivity.getApplicationContext(),MenuModification.class) ;
                        intent.putExtras(bundle) ;
                        contextActivity.startActivity(intent);
                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(contextActivity.getApplicationContext(),"Modifier au moins un champ",Toast.LENGTH_LONG).show();
                    }
                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteModifyOccupSol modifOccupSol = new RequesteModifyOccupSol("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",exploitation.toString()+","+String.valueOf(exploitation.getCodExploitation()),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(modifOccupSol);


    }
    public void modifProduit(final Spinner spinner, final EditText editText, final Bundle bundle, final boolean click)
    {
        final ArrayList<Produit>listP = new ArrayList<>() ;
        final ArrayList<String>lbaleProduit = new ArrayList<>() ;
        DAOSQlite = new DAOSQlite(contextActivity) ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Produit produit = new Produit() ;
                    JSONObject jsonResponse = new JSONObject(response);
                    if (jsonResponse.getBoolean("test_exist"))
                    {
                    JSONArray array = jsonResponse.getJSONArray("tab_Produit") ;
                    for (int i=0;i<array.length();i++)
                    {
                            String codeProduit = array.getJSONObject(i).getString(String.valueOf(i+1)) ;
                            produit = new Produit(Integer.parseInt(codeProduit), DAOSQlite.getProduit(codeProduit).getLabel()) ;
                            listP.add(produit) ;
                            lbaleProduit.add(DAOSQlite.getProduit(codeProduit).getLabel());

                    }
                    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(contextModification,android.R.layout.simple_spinner_item
                            ,lbaleProduit);

                    if (click)

                        {
                            int choix= spinner.getSelectedItemPosition() ;
                            Intent    intent = new Intent(contextActivity,ProduitExploitation.class);
                            bundle.putString("titre",spinner.getItemAtPosition(choix).toString());
                            Produit p=  (Produit)listP.get(choix);
                            if (p.getId()==1||p.getId()==1)
                                bundle.putInt("double", 0);
                            else  bundle.putInt("double",1);
                            bundle.putString("code",String.valueOf(p.getId()));
                            bundle.putString("exploitation",editText.getText().toString());
                            bundle.putInt("modification",1);
                            intent.putExtras(bundle);
                            contextActivity.startActivity(intent);

                        }
                        else
                            {
                                spinner.setAdapter(stringArrayAdapter);
                            }
                    }

                    else
                        {
                            editText.setError("Vérifier");
                        }
                }
                        catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };

        RequesteGetProduitsExploitation modifOccupSol = new RequesteGetProduitsExploitation("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",editText.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(modifOccupSol);


    }
    public void getTypeProduit(final View viewInf , final Bundle bundle, final ListView listView, final Button button, final FragmentManager fragmentManager, final ArrayList<Integer> listCodeTypeProduit)
    {

        ArrayList<String> listLebelProduit=new ArrayList<>() ;
        ArrayList typeProduits= new ArrayList() ;
        TypeProduit typeProduit = new TypeProduit() ;
        DAOSQlite =new DAOSQlite(contextActivity) ;

        typeProduits = DAOSQlite.getlistProduct(bundle.getString("code"));
        listLebelProduit= typeProduit.getLabels(typeProduits) ;
        final ArrayList<String>cnts=new ArrayList<>( );
        final ArrayList<String> finalListLebelProduit = listLebelProduit;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Produit produit = new Produit() ;
                    JSONObject jsonResponse = new JSONObject(response);
                        JSONArray array = jsonResponse.getJSONArray("tab_Produit") ;
                        for (int i=0;i<array.length();i++)
                        {
                            String cnt = array.getJSONObject(i).getString(String.valueOf(i+1)) ;
                            cnts.add(cnt) ;

                            if (testDouble(cnt))
                            {
                                listeValeurDouble.add(Double.parseDouble(cnt)) ;
                            }
                            if (testInteger(cnt))
                            {
                                listeValeurInteger.add(Integer.parseInt(cnt)) ;
                            }

                            CustomorAdapteur  customorAdapteur= new CustomorAdapteur(finalListLebelProduit,bundle,cnts,listeValeurDouble,listeValeurInteger) ;
                            listView.setAdapter(customorAdapteur);

                        }
                    final ViewDialogSubmit viewDialogSubmit = new ViewDialogSubmit() ;
                    viewDialogSubmit.setBundle(bundle);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v)
                            {


                                if (bundle.getInt("double")==1)
                                {

                                        viewDialogSubmit.seTValeuProduit(bundle.getString("code"), stringAjoutDouble(listeValeurDouble, listCodeTypeProduit), bundle.getString("exploitation"), contextActivity, contextModification,null,listCodeTypeProduit,listeValeurDouble);
                                        viewDialogSubmit.show(fragmentManager,null);

//Toast.makeText(contextActivity.getApplicationContext(),stringAjoutDouble(listeValeurDouble, listCodeTypeProduit),Toast.LENGTH_LONG
  //      ).show();
                                }

                                else
                                {

                                        viewDialogSubmit.seTValeuProduit(bundle.getString("code"),stringAjoutInteger(listeValeurInteger,listCodeTypeProduit),bundle.getString("exploitation"),contextActivity,contextModification,listeValeurInteger,listCodeTypeProduit,null);
                                        viewDialogSubmit.show(fragmentManager,null);

//Toast.makeText(contextActivity.getApplicationContext(),stringAjoutInteger(listeValeurInteger,listCodeTypeProduit),Toast.LENGTH_LONG).show();


                                }



                            }
                        });

                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };

        RequesteGetValeurTypeProduit modifOccupSol = new RequesteGetValeurTypeProduit("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",bundle.getString("exploitation"),bundle.getString("code"),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(modifOccupSol);


    }

    String stringAjoutDouble(ArrayList<Double>listeValeur,ArrayList<Integer> listeCodeTypeProduit)
    {
        String result ="";
        for (int i = 0 ; i<listeValeur.size();i++)
        {
            result=result+String.valueOf(listeCodeTypeProduit.get(i))+":"+String.valueOf(listeValeur.get(i))+",";
        }
        return result ;
    }
    String stringAjoutInteger(ArrayList<Integer>listeValeur,ArrayList<Integer> listeCodeTypeProduit)
    {
        String result ="";
        for (int i = 0 ; i<listeValeur.size();i++)
        {
            result=result+String.valueOf(listeCodeTypeProduit.get(i))+":"+String.valueOf(listeValeur.get(i))+",";
        }
        return result ;
    }    public  void modifTypeProduit(final String codeProduit , final String stringValeur, final String codeExploitation )
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    boolean testModif;
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean test_Modif = jsonResponse.getBoolean("test_modif");
                    if (test_Modif)
                    {

                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(contextActivity.getApplicationContext(),"Modifier au moins un champ",Toast.LENGTH_LONG).show();
                    }
                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteAjoutProduit valeurAjout = new RequesteAjoutProduit("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",stringValeur,codeExploitation,codeProduit,responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(valeurAjout);

    }


    public void getExploitant(final EditText cin, final EditText nom , final EditText prenom , final EditText tlf , final EditText age , final EditText codePostale ,
                              final EditText delegation, final EditText gouvernorat, final EditText secteur , final RadioButton rFemme, final RadioButton rHomme)
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean testcin = jsonResponse.getBoolean("testcin");
                    if (testcin)
                    {
                       nom.setText(jsonResponse.getString("nom"));
                       prenom.setText(jsonResponse.getString("prenom"));
                       tlf.setText(jsonResponse.getString("tlf"));
                       age.setText(jsonResponse.getString("age"));
                       codePostale.setText(jsonResponse.getString("codePostale"));
                       delegation.setText(jsonResponse.getString("delegation"));
                       gouvernorat.setText(jsonResponse.getString("gouvernorat"));
                       secteur.setText(jsonResponse.getString("secteur"));
                       String sexe = jsonResponse.getString("sexe") ;
                       if (sexe.equals("Femme")){rFemme.setChecked(true);  ;}
                           else{rHomme.setChecked(true);}
                    }
                    else
                    {
                //        cin.setError("Vérifier " + cin.getHint().toString());
                        nom.setText(null);
                        prenom.setText(null);
                        tlf.setText(null);
                        age.setText(null);
                        codePostale.setText(null);
                        delegation.setText(null);
                        gouvernorat.setText(null);
                        secteur.setText(null);

                    }
                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteGetExploitant modifOccupSol = new RequesteGetExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",cin.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(modifOccupSol);


    }
    public void getExploitantEtape2 (final Spinner nv, final Spinner diplome, final Spinner formation, final Spinner activite , final EditText nbHom, final EditText  nbFamme,String cin)
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean testcin = jsonResponse.getBoolean("testcin");
                    if (testcin)
                    {
                        nbFamme.setText(jsonResponse.getString("NF"));
                        nbHom.setText(jsonResponse.getString("NH"));
                        nv.setSelection(Integer.parseInt(jsonResponse.getString("nv")));
                        diplome.setSelection(Integer.parseInt(jsonResponse.getString("diplome")));
                        formation.setSelection(Integer.parseInt(jsonResponse.getString("formation")));
                        activite.setSelection(Integer.parseInt(jsonResponse.getString("ActP")));

                    }
                    else
                    {

                    }
                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteGetExploitant modifOccupSol = new RequesteGetExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",cin.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(modifOccupSol);


    }
    public void getExploitantEtape3 (final Spinner assurance, final Spinner entravs, final RadioButton rcredit, final RadioButton rNonCredit, final RadioButton rCnss, final RadioButton rNoncnss, String cin)
    {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean testcin = jsonResponse.getBoolean("testcin");
                    if (testcin)
                    {
                        assurance.setSelection(Integer.parseInt(jsonResponse.getString("assurs")));
                        entravs.setSelection(Integer.parseInt(jsonResponse.getString("entDev")));
                        if (jsonResponse.getString("credit").equals("Non"))
                        {
                                rNonCredit.setChecked(true);
                        }
                        else {
                            rcredit.setChecked(true);
                            }
                        if (jsonResponse.getString("cnss").equals("Non"))
                        {
                            rNoncnss.setChecked(true);
                        }
                        else
                            {rCnss.setChecked(true);}
                    }
                    else
                    {

                    }
                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteGetExploitant modifOccupSol = new RequesteGetExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",cin.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(modifOccupSol);


    }

    public void getCarcteristiqueExpEtape2(final EditText nPuits, final EditText nSondage, final String nExploitation, final RadioButton rPrive, final RadioButton
     rPublic, final RadioButton rEng, final RadioButton rNEngr, final RadioButton rSn, final RadioButton nonSntr)
    {
        DAOSQlite =new DAOSQlite(contextActivity) ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    Boolean testModify = jsonResponse.getBoolean("testExist") ;
                    if (testModify)
                    {
                        nPuits.setText(jsonResponse.getString("nbPuits"));
                        nSondage.setText(jsonResponse.getString("nbSondage"));
                        if (jsonResponse.getString("SourceD").equals("Privé"))
                        {
                            rPrive.setChecked(true);
                        }
                        else {rPublic.setChecked(true);}
                        if (jsonResponse.getString("typeE").equals("Non"))
                        {
                            rNEngr.setChecked(true);
                        }
                        else
                        {
                            rEng.setChecked(true);
                        }

                        if (jsonResponse.getString("typeS").equals("Non"))
                        {
                            nonSntr.setChecked(true);
                        }
                        else
                        {
                            rSn.setChecked(true);
                        }

                    }
                    else
                    {
                        //  codeExploitation.setError("Vérifier " + codeExploitation.getHint().toString());
                    }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteModificationCarcExplEtape1 valeurAjout = new RequesteModificationCarcExplEtape1("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",nExploitation.toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(valeurAjout);


    }

    public void ModificationExploitation(final String valeur , final EditText editTextExp, final EditText editTextgerant, final EditText editTextExploitant)
    {
        DAOSQlite =new DAOSQlite(contextActivity) ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    Toast.makeText(contextActivity.getApplicationContext(),editTextExp.getText().toString()+","+valeur,Toast.LENGTH_LONG);
                       boolean testExp = jsonResponse.getBoolean("testExist");
                       boolean testCinGerant = jsonResponse.getBoolean("testcing");
                       boolean testCinExploitant = jsonResponse.getBoolean("testcin");
                    boolean testmodification = jsonResponse.getBoolean("test_modification");
                if (testCinExploitant&&testExp&&testCinGerant)
                {
                 if (testmodification)
                    {

                        Toast.makeText(contextActivity.getApplicationContext(),"operation terminée Avec succès",Toast.LENGTH_LONG).show();
                    }
                    else
                        {
                            Toast.makeText(contextActivity.getApplicationContext(),"Modifier au moins un champ",Toast.LENGTH_LONG).show();
                        }
                }else
                    {
                        if (!testExp){editTextExp.setError(editTextExp.getHint().toString()+" Ne existe pas");}
                        if (!testCinExploitant){editTextExploitant.setError(editTextExp.getHint().toString()+" Ne existe pas");}
                        if (!testCinGerant){editTextgerant.setError(editTextgerant.getHint().toString()+" Ne existe pas");}

                    }
                } catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteModificationIdentificationExploitation valeurAjout = new RequesteModificationIdentificationExploitation("http://192.168.43.74/ProjectRecensementGenerale" +
                "/modification.php",editTextExp.getText().toString()+","+valeur,responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextModification);
        queue.add(valeurAjout);


    }
    boolean testInteger (String text)
    {
        try {
            Integer.parseInt(text);
            return  true ;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false ;
        }
    }
    boolean testDouble(String text )

    {
        try {
            Double.parseDouble(text);
            return true ;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false ;
        }
    }
    class CustomorAdapteur extends BaseAdapter
    {
        ArrayList<String> listLebelProduit ;
        View view ;
        Bundle bundle ;
        ArrayList<Double> listeValeurDouble  ;
        ArrayList<Integer>listeValeurInteger ;
        ArrayList <String>cnts ;
        public CustomorAdapteur(ArrayList<String> listLebelProduit,Bundle bundle,ArrayList <String>cnts,ArrayList<Double> listeValeurDouble, ArrayList<Integer>listeValeurInteger ) {
            this.listLebelProduit=listLebelProduit ;
            this.view =view ;
            this.bundle=bundle ;
            this.cnts=cnts ;
            this.listeValeurDouble=listeValeurDouble ;
            this.listeValeurInteger=listeValeurInteger ;
        }

        @Override
        public int getCount() {

            return this.cnts.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) contextActivity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.liste_produit, null, true);

            final TextView textView = convertView.findViewById(R.id.produit) ;
            final EditText editText  =convertView.findViewById(R.id.cnt) ;
            textView.setText(this.listLebelProduit.get(position));
            editText.setText(cnts.get(position));
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                                  }

                @Override
                public void afterTextChanged(Editable s) {
                    if (bundle.getInt("double")==1)
                    {

                        if (!testDouble(editText.getText().toString()))
                            editText.setError("Vérifeir  ");
                        else
                        {
                            listeValeurDouble.set(position,Double.parseDouble(editText.getText().toString()));
                        }
                    }
                    else
                    {
                        if (!testInteger(editText.getText().toString()))
                            editText.setError("Vérifeir  ");
                        else
                        {
                            listeValeurInteger.set(position,Integer.parseInt(editText.getText().toString())) ;
                        }
                    }

                }
            });
            return convertView ;
        }

    }
}
