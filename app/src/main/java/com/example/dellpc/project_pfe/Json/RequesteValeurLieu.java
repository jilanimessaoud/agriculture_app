package com.example.dellpc.project_pfe.Json;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RequesteValeurLieu extends  StringRequest{


    private Map<String, String> params;

    public RequesteValeurLieu(String LOGIN_REQUEST_URL, String codeGouvernorat,String codeDelegation,String codeSecteur,Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("codeGouvernorat", codeGouvernorat);
        params.put("codeDelegation", codeDelegation);
        params.put("codesecteur", codeSecteur);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
