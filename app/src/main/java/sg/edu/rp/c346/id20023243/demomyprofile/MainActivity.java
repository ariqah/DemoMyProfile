package sg.edu.rp.c346.id20023243.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGpa = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //SharedPreferences is for saving and retrieving key-value pairs of primitive data types;
        //usually to save SMALL collection of key value pairs
        //data will still exists even when app is killed

        //obtain SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //obtain SharedPreferences editor; to edit key-value pairs into the editor
        SharedPreferences.Editor prefEditor = prefs.edit();

        //setting key-value pairs in the editor
        prefEditor.putString("name",etName.getText().toString());
        prefEditor.putFloat("gpa", Float.parseFloat(etGpa.getText().toString()));

        //to save changes made to the SharedPreferences
        prefEditor.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();

        //obtain SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //retrieve saved data from SharedPreferences
        // insert default value in case no matching data
        String name = prefs.getString("name","Unknown");
        float gpa = prefs.getFloat("gpa", 0f); //0f to indicate that it is float, not double

        //update UI elements with the retrieved data
        etName.setText(name);
        etGpa.setText(String.valueOf(gpa)); //or setText(""+gpa);

    }
}