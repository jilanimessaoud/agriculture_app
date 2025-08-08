package com.example.dellpc.project_pfe.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellpc.project_pfe.Model.TypeProduit;
import com.example.dellpc.project_pfe.R;
import com.example.dellpc.project_pfe.dataBase.DAOSQlite;

import java.util.ArrayList;

public class ModificationListeProduit extends AppCompatActivity implements  View.OnClickListener  {
    ListView listView  ;
    DAOSQlite DAOSQlite;
    Button buttonSave ,buttonBAss ,retour;
    ArrayList<TypeProduit> typeProduits=new ArrayList<>();
    ArrayList<String> listLebelProduit=new ArrayList<>() ;
    ArrayList<Double>listeValeur  =new ArrayList<>() ;
    ArrayList<String> listLebelProduitEtValeur =new ArrayList<>();
    ArrayList<Integer>listCodeTypeProduit = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification_liste_produit);
        intial();
    }

    void intial()
    {
        TypeProduit typeProduit = new TypeProduit() ;
        DAOSQlite =new DAOSQlite(this) ;
        typeProduits = DAOSQlite.getlistProduct("1");
        listLebelProduit= typeProduit.getLabels(typeProduits) ;
        listView = (ListView)findViewById(R.id.liste) ;
        retour=(Button)findViewById(R.id.Retour);
        buttonSave = (Button)findViewById(R.id.sauvegarder);
        intListValeur();
        CustomorAdapteur customorAdapteur = new CustomorAdapteur() ;
        listView.setAdapter(customorAdapteur);
        buttonSave.setOnClickListener(this);

    }
void intListValeur()
        {
            for(int i = 0;i<listLebelProduit.size();i++ )
            {
                listeValeur.add(0.0) ;
                listCodeTypeProduit.add(typeProduits.get(i).getIdType());
            }
        }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.sauvegarder)
        {

            Toast.makeText(getApplicationContext(),stringAjout(listeValeur,listCodeTypeProduit),Toast.LENGTH_LONG).show();
        }
    }

    class CustomorAdapteur extends BaseAdapter
    {
        public CustomorAdapteur() { }

        @Override
        public int getCount() {

            return listLebelProduit.size();
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
            convertView=getLayoutInflater().inflate(R.layout.liste_produit,null);
            final TextView textView = convertView.findViewById(R.id.produit) ;
            final EditText editText  =convertView.findViewById(R.id.cnt) ;
            textView.setText(listLebelProduit.get(position));
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                    if (testDouble(editText.getText().toString()))
                    listeValeur.set(position,Double.parseDouble(editText.getText().toString())) ;
                    else editText.setError("Vérifeir  ") ;

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            return convertView ;
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
    ///retourner un  string (code de produit +nombre )
    String stringAjout(ArrayList<Double>listeValeur,ArrayList<Integer> listeCodeTypeProduit)
    {
        String result ="";
        for (int i = 0 ; i<listeValeur.size();i++)
        {
            result=result+String.valueOf(listeCodeTypeProduit.get(i))+":"+String.valueOf(listeValeur.get(i))+",";
        }
        return result ;
    }
}
