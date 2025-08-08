package com.example.dellpc.project_pfe.Json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dellpc.project_pfe.Model.Delegation;
import com.example.dellpc.project_pfe.Model.Exploitation;
import com.example.dellpc.project_pfe.Model.Personne;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DAOJsonConsulter
{
    DAOSQlite DAOSQlite;
    Exploitation exploitation ;
ArrayList <Delegation> listDelegation = new ArrayList<>() ;
    Context contextActivty ;
    Context contextAjout ;
    Personne personne ;

    ArrayList<Personne>listPersonne = new ArrayList<>( ) ;
    ArrayList<Exploitation> listeExploitation = new ArrayList<>() ;
    public DAOJsonConsulter(Context contextActivty, Context contextAjout) {
        this.contextActivty = contextActivty;
        this.contextAjout = contextAjout;
    }

    public void getListeExploitant(final ListView listView, final String[] Assurances , final String[] entrDev , final String[] nVInstrction , final String[] formation
    , final String[] diplome , final String[] ActiPrn ) {

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try
                {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray array = jsonResponse.getJSONArray("tab_Exploitant");
                    for (int i= 0 ; i<array.length();i++ )
                    {

                        personne=new Personne();
                        personne.setCin(array.getJSONObject(i).getString("cin"));
                        personne.setAge(array.getJSONObject(i).getInt("age"));
                        personne.setNom(array.getJSONObject(i).getString("nom"));
                        personne.setPrenom(array.getJSONObject(i).getString("prenom"));
                        personne.setTlf(array.getJSONObject(i).getString("tlf"));
                        personne.setSexe(array.getJSONObject(i).getString("sexe"));
                        personne.setGouvernorat(array.getJSONObject(i).getString("gouvernorat"));
                        personne.setCodePostale(array.getJSONObject(i).getInt("codePostale"));
                        personne.setDelegation(array.getJSONObject(i).getString("delegation"));
                        personne.setSecteur(array.getJSONObject(i).getString("Secteur"));
                        personne.setNiveauInstruction(array.getJSONObject(i).getString("niveauInstruction"));
                        personne.setTypeFormation(array.getJSONObject(i).getString("TypeFormation"));
                        personne.setTypeDiplome(array.getJSONObject(i).getString("TypeDiplome"));
                        personne.setActivitePrincipale(array.getJSONObject(i).getString("ActivitePrincipale"));
                        personne.setnBFamileFemme(array.getJSONObject(i).getInt("NBFamileFemme"));
                        personne.setnBFamileHomme(array.getJSONObject(i).getInt("NBFamileHomme"));
                        personne.setEntravesDeveloppement(array.getJSONObject(i).getString("EntravesDeveloppement"));
                        personne.setCredit(array.getJSONObject(i).getString("Credit"));
                        personne.setCnss(array.getJSONObject(i).getString("cnss"));
                        personne.setAssurance(array.getJSONObject(i).getString("Assurance"));
                        listPersonne.add(personne) ;
                    }
                    CustomorAdapteur customorAdapteur = new CustomorAdapteur(Assurances,entrDev,nVInstrction,formation,diplome,ActiPrn);
                    listView.setAdapter(customorAdapteur);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        };
        RequesteValeurBaseRG requesteValeurBaseRG = new RequesteValeurBaseRG("http://192.168.43.74/ProjectRecensementGenerale/ConsultDonner.php",responseListener);
        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(requesteValeurBaseRG);

    }


    public void getExploitant(final ListView listView, final String[] Assurances , final String[] entrDev , final String[] nVInstrction , final String[] formation
            , final String[] diplome , final String[] ActiPrn ,EditText cin)
    {
        listPersonne=new ArrayList<>() ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                   boolean testExiste = jsonResponse.getBoolean("exist");

                    if (!testExiste)
                    {

                    }
                    else
                    {
                        JSONArray array = jsonResponse.getJSONArray("tab_Exploitant");
                        for (int i= 0 ; i<array.length();i++ )
                        {

                            personne=new Personne();
                            personne.setCin(array.getJSONObject(i).getString("cin"));
                            personne.setAge(array.getJSONObject(i).getInt("age"));
                            personne.setNom(array.getJSONObject(i).getString("nom"));
                            personne.setPrenom(array.getJSONObject(i).getString("prenom"));
                            personne.setTlf(array.getJSONObject(i).getString("tlf"));
                            personne.setSexe(array.getJSONObject(i).getString("sexe"));
                            personne.setGouvernorat(array.getJSONObject(i).getString("gouvernorat"));
                            personne.setCodePostale(array.getJSONObject(i).getInt("codePostale"));
                            personne.setDelegation(array.getJSONObject(i).getString("delegation"));
                            personne.setSecteur(array.getJSONObject(i).getString("Secteur"));
                            personne.setNiveauInstruction(array.getJSONObject(i).getString("niveauInstruction"));
                            personne.setTypeFormation(array.getJSONObject(i).getString("TypeFormation"));
                            personne.setTypeDiplome(array.getJSONObject(i).getString("TypeDiplome"));
                            personne.setActivitePrincipale(array.getJSONObject(i).getString("ActivitePrincipale"));
                            personne.setnBFamileFemme(array.getJSONObject(i).getInt("NBFamileFemme"));
                            personne.setnBFamileHomme(array.getJSONObject(i).getInt("NBFamileHomme"));
                            personne.setEntravesDeveloppement(array.getJSONObject(i).getString("EntravesDeveloppement"));
                            personne.setCredit(array.getJSONObject(i).getString("Credit"));
                            personne.setCnss(array.getJSONObject(i).getString("cnss"));
                            personne.setAssurance(array.getJSONObject(i).getString("Assurance"));
                            listPersonne.add(personne) ;
                        }

                        CustomorAdapteur customorAdapteur = new CustomorAdapteur(Assurances,entrDev,nVInstrction,formation,diplome,ActiPrn);
                        listView.setAdapter(customorAdapteur);

                    }

                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteGetExploitant modifOccupSol = new RequesteGetExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ConsultDonner.php",cin.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(modifOccupSol);


    }

    public void getExploitation(final ListView listView,EditText cin)
    {
        DAOSQlite = new DAOSQlite(contextActivty) ;
        listDelegation= DAOSQlite.getAllDelegation() ;
        listPersonne=new ArrayList<>() ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean testExiste = jsonResponse.getBoolean("exist_Exploitation");

                    if (!testExiste)
                    {

                    }
                    else
                    {
                        JSONArray array = jsonResponse.getJSONArray("tabExploitation");
                        listeExploitation=new ArrayList<>() ;
                        for (int i= 0 ; i<array.length();i++ )
                        {

                         exploitation = new Exploitation();
                         exploitation.setSecteur(array.getJSONObject(i).getInt("secteur"));
                         exploitation.setCodExploitation(array.getJSONObject(i).getInt("codeExploitation"));
                         exploitation.setCinExploitant(array.getJSONObject(i).getString("exploitant"));
                         exploitation.setCinGerant(array.getJSONObject(i).getString("gerant"));
                         exploitation.setSpTotale(array.getJSONObject(i).getDouble("Sptotale"));
                         exploitation.setSpLabourable(array.getJSONObject(i).getDouble("Splap"));
                         exploitation.setSpCultivee(array.getJSONObject(i).getDouble("spcltive"));
                         exploitation.setSpIrrigable(array.getJSONObject(i).getDouble("spirrg"));
                         exploitation.setNombreEmploiyer(array.getJSONObject(i).getInt("nbEmp"));
                         exploitation.setNombrePuits(array.getJSONObject(i).getInt("nbPuits"));
                         exploitation.setNombresSondage(array.getJSONObject(i).getInt("nbSondage"));
                         exploitation.setTypeEngrais(array.getJSONObject(i).getString("typeE"));
                         exploitation.setTypeSanitaire(array.getJSONObject(i).getString("typeS"));
                         exploitation.setSourceEau(array.getJSONObject(i).getString("SourceD"));
                         listeExploitation.add(exploitation) ;
                        }
                        CustomorAdapteurExplitation customorAdapteurExplitation = new CustomorAdapteurExplitation() ;
                        listView.setAdapter(customorAdapteurExplitation);

                    }

                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteGetExploitant modifOccupSol = new RequesteGetExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ConsultDonner.php",cin.getText().toString(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(modifOccupSol);
    }

    public void getAllProduit(String code, final ListView  listView)
    {

        final ArrayList <String> listep= new ArrayList<>() ;
        DAOSQlite = new DAOSQlite(contextActivty) ;
        listDelegation= DAOSQlite.getAllDelegation() ;
        listPersonne=new ArrayList<>() ;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    boolean testExiste = jsonResponse.getBoolean("exist_Exploitation");

                    if (!testExiste)
                    {

                    }
                    else
                    {
                        JSONArray array = jsonResponse.getJSONArray("tabExploitation");
                        listeExploitation=new ArrayList<>() ;
                        for (int i= 0 ; i<array.length();i++ )
                        {
                        listep.add(array.getJSONObject(i).getString("labe")+" : "+array.getJSONObject(i).getString("cnt"));


                        }

                    ArrayAdapter    arrayAdapter = new ArrayAdapter(contextAjout,R.layout.liste_des_lieux,R.id.leux,listep);
                        listView.setAdapter(arrayAdapter);
                    }

                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                }

            }

        };
        RequesteGetExploitant modifOccupSol = new RequesteGetExploitant("http://192.168.43.74/ProjectRecensementGenerale" +
                "/ListeProduit.php",code.trim(),responseListener);

        RequestQueue queue = Volley.newRequestQueue(contextAjout);
        queue.add(modifOccupSol);


    }
    class CustomorAdapteur extends BaseAdapter
    {
        String[] Assurances , entrDev , nVInstrction , formation, diplome , ActiPrn ;

        public CustomorAdapteur(String[] assurances, String[] entrDev, String[] nVInstrction, String[] formation, String[] diplome, String[] actiPrn) {
            this.Assurances = assurances;
            this.entrDev = entrDev;
            this.nVInstrction = nVInstrction;
            this.formation = formation;
            this.diplome = diplome;
            ActiPrn = actiPrn;
        }


        @Override
        public int getCount() {

            return listPersonne.size();
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

            LayoutInflater inflater = (LayoutInflater) contextActivty
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itms_exploitant, null, true);
            TextView textView0 = convertView.findViewById(R.id.t0) ;
            TextView textView1 = convertView.findViewById(R.id.t1) ;
            TextView textView2 = convertView.findViewById(R.id.t2) ;
            TextView textView3 = convertView.findViewById(R.id.t3) ;
            TextView textView4 = convertView.findViewById(R.id.t5) ;
            TextView textView5 = convertView.findViewById(R.id.t6) ;
            TextView textView6 = convertView.findViewById(R.id.t7) ;
            TextView textView7 = convertView.findViewById(R.id.t8) ;
            TextView textView8 = convertView.findViewById(R.id.t9) ;
            TextView textView9 = convertView.findViewById(R.id.t10) ;
            TextView textView10 = convertView.findViewById(R.id.t11) ;
            TextView textView11 = convertView.findViewById(R.id.t12) ;
            TextView textView12= convertView.findViewById(R.id.t13) ;
            TextView textView13= convertView.findViewById(R.id.t4) ;
            TextView textView14= convertView.findViewById(R.id.t14) ;
            TextView textView15= convertView.findViewById(R.id.t15) ;

            personne = listPersonne.get(position) ;
            textView1.setText(textView1.getText()+" "+personne.getNom()+" "+personne.getPrenom());
            textView2.setText(textView2.getText()+" "+String.valueOf(personne.getAge()));
            textView3.setText(textView3.getText()+" "+String.valueOf(personne.getCodePostale()+" "+personne.getSecteur()+" "+personne.getDelegation()+" "+personne.getGouvernorat()));
            textView4.setText(textView4.getText()+" "+personne.getTlf());
            textView5.setText(textView5.getText()+" "+personne.getCnss());
            if (testInteger(personne.getNiveauInstruction()))
            {
                if (nVInstrction.length>Integer.parseInt( personne.getNiveauInstruction()))
                {
                    textView6.setText(textView6.getText()+" "+nVInstrction[Integer.parseInt( personne.getNiveauInstruction())]);

                }
            }
            if (testInteger(personne.getTypeFormation()))
            {
                if (formation.length>Integer.parseInt(personne.getTypeFormation()))
                {
                    textView7.setText(textView7.getText()+" "+formation[Integer.parseInt(personne.getTypeFormation())]);
                }
            }

            if (testInteger(personne.getAssurance()))

            {
                if (Assurances.length>Integer.parseInt(personne.getAssurance()))
                {
                      textView8.setText(textView8.getText()+" "+Assurances[Integer.parseInt(personne.getAssurance())]);
                }
            }


            textView9.setText(textView9.getText()+" "+personne.getCredit());
                if (testInteger(personne.getTypeDiplome()))
                {
                    if (diplome.length>Integer.parseInt(personne.getTypeDiplome()))
                    {
                    textView10.setText(textView10.getText()+" "+diplome[Integer.parseInt(personne.getTypeDiplome())]);

                    }
                }

            textView11.setText(textView11.getText()+" "+String.valueOf(personne.getnBFamileHomme()));

            textView12.setText(textView12.getText()+" "+String.valueOf(personne.getnBFamileFemme()));

            textView0.setText(textView0.getText()+" "+personne.getCin());

            textView13.setText(textView13.getText()+" "+personne.getSexe());
            if (testInteger(personne.getActivitePrincipale()))
            {
                if (ActiPrn.length>Integer.parseInt(personne.getActivitePrincipale()))
                {
                      textView14.setText(textView14.getText()+" "+ActiPrn[Integer.parseInt(personne.getActivitePrincipale())]);

                }

            }
            if (testInteger(personne.getEntravesDeveloppement()))
            {
                if (entrDev.length>Integer.parseInt(personne.getEntravesDeveloppement()))
                {
                    textView15.setText(textView15.getText()+" "+entrDev[Integer.parseInt(personne.getEntravesDeveloppement())]);

                }
            }

            return convertView ;
        }
    }
    boolean testInteger(String text)
    {
        try {
            Integer.parseInt(text) ;
            return  true ;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false ;
        }
    }
    class CustomorAdapteurExplitation extends BaseAdapter
    {

        public CustomorAdapteurExplitation() {

        }


        @Override
        public int getCount() {

            return listeExploitation.size();
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
            LayoutInflater inflater = (LayoutInflater) contextActivty
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itms_exploitoitation, null, true);
            TextView textView0 = convertView.findViewById(R.id.t0) ;
            TextView textView1 = convertView.findViewById(R.id.t1) ;
            TextView textView2 = convertView.findViewById(R.id.t2) ;
            TextView textView3 = convertView.findViewById(R.id.t3) ;
            TextView textView4 = convertView.findViewById(R.id.t4) ;
            TextView textView5 = convertView.findViewById(R.id.t5) ;
            TextView textView6 = convertView.findViewById(R.id.t6) ;
            TextView textView7 = convertView.findViewById(R.id.t7) ;
            TextView textView8 = convertView.findViewById(R.id.t8) ;
            TextView textView9 = convertView.findViewById(R.id.t9) ;
            TextView textView10 = convertView.findViewById(R.id.t10) ;
            TextView textView11 = convertView.findViewById(R.id.t11) ;
            TextView textView12= convertView.findViewById(R.id.t12) ;
            TextView textView13= convertView.findViewById(R.id.t13) ;
            TextView textView14= convertView.findViewById(R.id.t14) ;
            textView0.setText(textView0.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getCodExploitation()));
            textView1.setText(textView1.getText().toString()+" "+listeExploitation.get(position).getCinExploitant());
            textView2.setText(textView2.getText().toString()+" "+listeExploitation.get(position).getCinGerant());


            String code =    DAOSQlite.getDelegation(String.valueOf(listeExploitation.get(position).getSecteur())) ;
            Delegation delegation = listDelegation.get(Integer.parseInt(code)-1);

            textView3.setText(textView3.getText().toString()+" "+delegation.getLabel());
            textView4.setText(textView4.getText().toString()+" "+ DAOSQlite.getSecteur(String.valueOf(listeExploitation.get(position).getSecteur())));
            textView5.setText(textView5.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getSpTotale()));
            textView6.setText(textView6.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getSpLabourable()));
            textView7.setText(textView7.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getSpCultivee()));
            textView8.setText(textView8.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getSpIrrigable()));
            textView9.setText(textView9.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getNombreEmploiyer()));
            textView10.setText(textView10.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getSourceEau()));
            textView11.setText(textView11.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getNombrePuits()));
            textView12.setText(textView12.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getNombresSondage()));
            textView13.setText(textView13.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getTypeEngrais()));
            textView14.setText(textView14.getText().toString()+" "+String.valueOf(listeExploitation.get(position).getTypeSanitaire()));


            return convertView ;
        }
    }
}
