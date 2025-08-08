package com.example.dellpc.project_pfe.Json;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RequesteAjoutProduit extends  StringRequest{


    private Map<String, String> params;

    public RequesteAjoutProduit(String LOGIN_REQUEST_URL , String value,String codeExp,String codeProduit, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params = new HashMap<>();
        params.put("StringValeu", value);
        params.put("codeExploitation", codeExp);
        params.put("codeProduit", codeProduit);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
