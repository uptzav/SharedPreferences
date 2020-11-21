package com.example.almacenamientosp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import kotlin.io.ConstantsKt;


public class MainActivity extends AppCompatActivity {

  

    private  static  final String TAG = "MainActivity";
    private  SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mUsuario, mClave;
    private Button btnLogin;
    private CheckBox mCheckbox;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsuario =(EditText)findViewById(R.id.edt_usuario);
        mClave =(EditText)findViewById(R.id.edt_password);
        btnLogin =(Button) findViewById(R.id.btn_login);
        mCheckbox =(CheckBox) findViewById(R.id.checkBox);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mEditor = mPreferences.edit();

        //TODO: revisar las preferencias
        checkSharedPreferences();

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mCheckbox.isChecked()){
                    mEditor.putString(getString(R.string.checkbox), "True");
        String name =mUsuario.getText().toString();
        mEditor.putString(getString(R.string.name), name);
        String password = mClave.getText().toString();
        mEditor.putString(getString(R.string.password), password);
        mEditor.commit();

        //TODO Accion luego del login
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                   startActivity(intent);


                }else{
                    mEditor.putString(getString(R.string.checkbox), "false");
                    mEditor.putString(getString(R.string.name), "");
                    mEditor.putString(getString(R.string.password), "");
                    mEditor.commit();

                }
            }
                                    }


        );

    }

    private  void checkSharedPreferences(){

        String checkBox = mPreferences.getString(getString(R.string.checkbox), "false");
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");
        mUsuario.setText(name);
        mClave.setText(password);

        if (checkBox.equals("true")){
            mCheckbox.setChecked(true);
        }else {
            mCheckbox.setChecked(false);
        }

    }

}