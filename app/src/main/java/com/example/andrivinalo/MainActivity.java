package com.example.andrivinalo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    int result;
    EditText nombre;
    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random()
                * (max - min)) + min);
    }

    public void makeToast(String str)
    {
        Toast.makeText(
                MainActivity.this,
                str,
                Toast.LENGTH_SHORT)
                .show();
    }

    public void clickFunction(View view)
    {
        int userGuessing;
        EditText variable
                = (EditText)findViewById(
                R.id.editId);
        userGuessing
                = Integer.parseInt(
                variable
                        .getText()
                        .toString());
        if (userGuessing < result) {

            makeToast("prueba un numero mas grande");
        }
        else if (userGuessing > result) {
            makeToast("prueba un numero mas pequeño");
        }
        else {
            guardarnombre();
            cargarnombre();
            openActivity();


            makeToast(
                    "felicidades");

        }
    }


    private void cargarnombre(){
        SharedPreferences nombr= getSharedPreferences
                ("TU NOMBRE", Context.MODE_PRIVATE);

        String user =nombr.getString("usuario","fdshgdsa");

    }

    private void guardarnombre (){
        nombre= findViewById(R.id.editId2);
        SharedPreferences nombr= getSharedPreferences
                ("TU NOMBRE", Context.MODE_PRIVATE);
        String nombreds = nombre.getText().toString();

        SharedPreferences.Editor editor=nombr.edit();
        editor.putString("nombress",nombreds);
        editor.commit();

        nombre.setText(nombreds);
    }



    public void openActivity() {
        Intent intent = new Intent(this, recibidor.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {

        nombre= findViewById(R.id.editId2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int min = 1;
        int max = 5;
        result = getRandomNumber(min, max);
    }



}