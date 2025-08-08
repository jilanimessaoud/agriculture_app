package com.example.dellpc.project_pfe.Json;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RequesteValeurLogin extends  StringRequest{


    private Map<String, String> params;

    public RequesteValeurLogin(String LOGIN_REQUEST_URL,String username, String password,Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
