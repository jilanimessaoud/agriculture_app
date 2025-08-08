package com.example.dellpc.project_pfe.View;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dellpc.project_pfe.Model.Delegation;
import com.example.dellpc.project_pfe.R;

import java.util.ArrayList;


import java.util.ArrayList;

public class Dialogs extends AppCompatDialogFragment {

    ListView listViewDelegation ;
    int p ;
    public ArrayList<String> listeDelegation  ;
    codeLieuxListener  listener ;

    public Dialogs() {
    }

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        listViewDelegation = (ListView)view.findViewById(R.id.listeDialog);
        CustomorAdapteur customorAdapteur = new CustomorAdapteur();


        listViewDelegation.setAdapter(customorAdapteur);
        listViewDelegation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int testColor = 0  ;
            int color =0 ;
            int positionClick ;
            View viewClick ;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                p = position ;

                if (testColor==0)
                {
                    positionClick = position ;
                    viewClick=view;
                    color =view.getSolidColor() ;
                    view.setBackgroundColor(Color.CYAN);
                    testColor++;
                }

                if ((testColor%2==0))
                {
                    viewClick.setBackgroundColor(color);
                    viewClick = view ;
                    view.setBackgroundColor(Color.CYAN);

                }

                else if  (testColor%2!=0){
                    viewClick.setBackgroundColor(color);
                    viewClick = view ;
                    view.setBackgroundColor(Color.CYAN);

                }

            }
        });
        builder.setView(view).setTitle("login").setNegativeButton("ok" , new OnClickListener() {
            /**
             * This method will be invoked when a button in the dialog is clicked.
             *
             * @param dialog the dialog that received the click
             * @param which  the button that was clicked (ex.
             *               {@link DialogInterface#BUTTON_POSITIVE}) or the position
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //listener.applyCode(p);
            }
        });
        return builder.create();
    }

    public void setListeDelegation(ArrayList<String> listeDelegation) {
        this.listeDelegation = listeDelegation;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener=(codeLieuxListener) context ;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString()+"must implement");
        }



    }
    public interface  codeLieuxListener {
        void applyCode(int code) ;

    }
    class CustomorAdapteur extends BaseAdapter
    {
        public CustomorAdapteur() { }

        @Override
        public int getCount() {

            return listeDelegation.size();
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
            textView.setText(listeDelegation.get(position));
            return convertView ;
        }
    }
}
