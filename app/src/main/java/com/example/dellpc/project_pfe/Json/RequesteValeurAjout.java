package com.example.dellpc.project_pfe.Json;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RequesteValeurAjout extends  StringRequest{


    private Map<String, String> params;

    public RequesteValeurAjout(String LOGIN_REQUEST_URL , String value, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params = new HashMap<>();
        params.put("StringAjout", value);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
