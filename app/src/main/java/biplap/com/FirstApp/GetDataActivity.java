package biplap.com.FirstApp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getResponseFromServer();
    }


    private void getResponseFromServer() {
        String url="http://192.168.209.2/bcaApiMblPro/get_contacts.php";
        RequestQueue requestQueue = Volley.newRequestQueue(GetDataActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseJson(response);
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
    private void parseJson(String response) {
        ArrayList<ServerResponseDTO> responseDTOArrayList = new ArrayList<>();
        try {
            JSONObject responseObject = new JSONObject(response);
            JSONArray jsonArray =responseObject.getJSONArray("data");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject =jsonArray.getJSONObject(i);
                String name= jsonObject.getString("name");
                String email= jsonObject.getString("email");
                String address= jsonObject.getString("address");
                String phone= jsonObject.getString("phone");
                ServerResponseDTO serverResponseDTO = new ServerResponseDTO(name,email,address,phone);
                responseDTOArrayList.add(serverResponseDTO);

                Log.d("GetDataFrom server", String.valueOf(+responseDTOArrayList.size()));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}