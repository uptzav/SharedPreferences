package com.example.almacenamientosp;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private  TextView txt_home;

    private SharedPreferences prefs;
    private String prefName = "Mypreferences";
    private static final String KEY_FONT_SIZE = "font";
    private static final String KEY_TEXT_VALUE = "text";

    Button mRedColor;
    Button mGreenColor;
    Button mYellowColor;
    Button mBlueColor;
    Button mOrangeColor;
    Button mVioletColor;
    Button mCelesteColor;
    Button mTurqColor;
    Button mBlackColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText edit = (EditText) findViewById(R.id.editText1);
        final SeekBar seek = (SeekBar) findViewById(R.id.seekBar1);
        final TextView tv = (TextView) findViewById(R.id.textView2);
        Button ok = (Button) findViewById(R.id.button1);

        mRedColor = (Button) findViewById(R.id.btnRed);
        mGreenColor = (Button) findViewById(R.id.btnGreen);
        mYellowColor = (Button) findViewById(R.id.btnYellow);
        mBlueColor = (Button) findViewById(R.id.btnBlue);
        mOrangeColor = (Button) findViewById(R.id.btnOrange);
        mVioletColor = (Button) findViewById(R.id.btnViolet);
        mCelesteColor = (Button) findViewById(R.id.btnCeleste);
        mTurqColor = (Button) findViewById(R.id.btnTurq);
        mBlackColor = (Button) findViewById(R.id.btnBlack);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                prefs = getSharedPreferences(prefName, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putFloat(KEY_FONT_SIZE, edit.getTextSize());
                editor.putString(KEY_TEXT_VALUE, edit.getText().toString());
                editor.commit();
                Toast.makeText(getBaseContext(),
                        "Size of the font is saved successfully",
                        Toast.LENGTH_LONG).show();
                tv.setText(edit.getText().toString());
                tv.setTextSize(seek.getProgress());
            }
        });

        SharedPreferences prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        float fontSize = prefs.getFloat(KEY_FONT_SIZE, 14);
        seek.setProgress((int) fontSize);
        edit.setText(prefs.getString(KEY_TEXT_VALUE, " "));
        edit.setTextSize(seek.getProgress());



        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                edit.setTextSize(progress);
            }
        });




        if(getColor() != getResources().getColor(R.color.colorPrimary)){
            toolbar.setBackgroundColor(getColor());
            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                getWindow().setStatusBarColor(getColor());
            }
        }

        mRedColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorred));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorred));
                }
                storeColor(getResources().getColor(R.color.colorred));
            }
        });

        mGreenColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorgreen));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorgreen));
                }
                storeColor(getResources().getColor(R.color.colorgreen));
            }
        });

        mYellowColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.coloryellow));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.coloryellow));
                }
                storeColor(getResources().getColor(R.color.coloryellow));
            }
        });

        mBlueColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorblue));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorblue));
                }
                storeColor(getResources().getColor(R.color.colorblue));
            }
        });

        mOrangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colororange));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colororange));
                }
                storeColor(getResources().getColor(R.color.colororange));
            }
        });

        mVioletColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorviolet));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorviolet));
                }
                storeColor(getResources().getColor(R.color.colorviolet));
            }
        });

        mCelesteColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorceleste));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorceleste));
                }
                storeColor(getResources().getColor(R.color.colorceleste));
            }
        });


        mTurqColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorturq));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorturq));
                }
                storeColor(getResources().getColor(R.color.colorturq));
            }
        });

        mBlackColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorblack));
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorblack));
                }
                storeColor(getResources().getColor(R.color.colorblack));
            }
        });

        // ((TextView)findViewById(R.id.text_home)).setText(name);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private  void storeColor(int color){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("color", color);
        mEditor.apply();

    }

    private  int getColor(){
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        int selectedColor = mSharedPreferences.getInt("color", getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }
}