package ec.com.asofar.asofarinventory.Servicio;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.android.volley.*;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.com.asofar.asofarinventory.DTO.ListLog;
import ec.com.asofar.asofarinventory.DTO.UsuarioDTO;
import ec.com.asofar.asofarinventory.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServicioWs {

    private Context context;
    public static final int MY_DEFAULT_TIMEOUT = 15000;
    private AdminSQLiteOpenHelper admin;
    private SQLiteDatabase db;
    Activity activityCompat;


    public ServicioWs(Context context,Activity activityCompat) {
        this.context = context;
        this.activityCompat = activityCompat;
        admin = new AdminSQLiteOpenHelper(getContext(), "dbSistemaFace", null, 1);
        db = admin.getWritableDatabase();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public void send_loguin(String user, String password) throws JSONException {


        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = getContext().getString(R.string.URL_LOGUIN);
        JSONArray params = new JSONArray();
        RegistroBase reg = new RegistroBase(context);
        //array request volley POST_REQUEST
        String data = "{\"user\":\""+user+"\", \"password \":\""+password+"\" }";
        JSONObject json = new JSONObject(data);
        params.put(json);


        System.out.println("ENVIO: " + data);
        //send array request POST with vole
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.POST, url,params , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



                Gson gson = new Gson();
                List<ListLog> res  = gson.fromJson(response.toString(), new TypeToken<List<ListLog>>() {
                }.getType());

                if (res.size()>0) {

                    for(ListLog ls : res){

                        if(ls.getRespuesta().equals("Logueado con Exito")){

                            List<UsuarioDTO> lsU = ls.getUsuario();
                            for(UsuarioDTO l : lsU){



                            }



                        }

                    }


                }






                Log.d("JSON_ARRAY",response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error",error.toString());

            }
        }){};

        System.out.println("JSON_ARRAY: "+stringRequest.toString());


        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(stringRequest);

    }




}
