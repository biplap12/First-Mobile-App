package biplap.com.FirstApp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

import java.util.HashMap;
import java.util.Map;

public class PostDataServerActivity extends AppCompatActivity {

    Button buttonPost;
    EditText editTextName,editTextEmail,editTextAddress,editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_data_server);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonPost=findViewById(R.id.btnPost);
        editTextName=findViewById(R.id.postName);
        editTextEmail=findViewById(R.id.postEmail);
        editTextAddress=findViewById(R.id.postAddress);
        editTextPhone=findViewById(R.id.postPhone);

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDataServer();
            }

            private void postDataServer() {
                String url = "https://192.168.110.220/bcaApiMblPro/save_contacts.php";
                RequestQueue requestQueue = Volley.newRequestQueue(PostDataServerActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("PostDataServer", "Response: " + response);
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("PostDataServer", "onErrorResponse: " + error.toString());
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        HashMap<String, String> params = new HashMap<>();
                        params.put("name", editTextName.getText().toString());
                        params.put("address", editTextAddress.getText().toString());
                        params.put("phone", editTextPhone.getText().toString());
                        params.put("email", editTextEmail.getText().toString());
                        return params;
                    }
                };

                requestQueue.add(stringRequest);
            }
        });

    }
}
