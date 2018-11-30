package com.example.elf.is;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

import static com.example.elf.is.myDatabase.co;
import static com.example.elf.is.myDatabase.co1;
import static com.example.elf.is.myDatabase.getData;
import static com.example.elf.is.myDatabase.number;
import static com.example.elf.is.myDatabase.number3;

public class unlock extends AppCompatActivity {

   static EditText n1,n2,n3,n4;
    static  View v1,v2,v3,v4;
    static  Button b1,b2,b3,b4,set,view,newp;
    static  String s1,s2,s3,s4;
    static  int color1,color2,color3,color4;

    myDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);


        mydatabase = new myDatabase(this);

        n1 = findViewById(R.id.number1);
        n2 = findViewById(R.id.number2);
        n3 = findViewById(R.id.number3);
        n4 = findViewById(R.id.number4);

        v1 = findViewById(R.id.c1);
        v2 = findViewById(R.id.c2);
        v3 = findViewById(R.id.c3);
        v4 = findViewById(R.id.c4);

        newp = findViewById(R.id.newpassword);

        set = findViewById(R.id.unlock);


        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ColorPicker colorPicker = new ColorPicker(unlock.this);
                ArrayList<String> colors = new ArrayList<>();
                colors.add("#FF0000");
                colors.add("#00FF00");
                colors.add("#0000FF");
                colors.add("#008000");
                colors.add("#000080");
                colors.add("#FF00FF");

                colorPicker.setColors(colors)
                        .setColumns(3)
                        .setRoundColorButton(true)
                        .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                            @Override
                            public void onChooseColor(int position,int color) {
                                // put code
                                color1=color;
                                ((GradientDrawable)v1.getBackground()).setColor(color1);
                            }

                            @Override
                            public void onCancel(){
                                // put code
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();

            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final ColorPicker colorPicker = new ColorPicker(unlock.this);
                ArrayList<String> colors = new ArrayList<>();
                colors.add("#FF0000");
                colors.add("#00FF00");
                colors.add("#0000FF");
                colors.add("#008000");
                colors.add("#000080");
                colors.add("#FF00FF");



                colorPicker.setColors(colors)
                        .setColumns(3)
                        .setRoundColorButton(true)
                        .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                            @Override
                            public void onChooseColor(int position,int color) {
                                // put code
                                color2=color;
                                ((GradientDrawable)v2.getBackground()).setColor(color2);
                            }

                            @Override
                            public void onCancel(){
                                // put code
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ColorPicker colorPicker = new ColorPicker(unlock.this);
                ArrayList<String> colors = new ArrayList<>();
                colors.add("#FF0000");
                colors.add("#00FF00");
                colors.add("#0000FF");
                colors.add("#008000");
                colors.add("#000080");
                colors.add("#FF00FF");


                colorPicker.setColors(colors)
                        .setColumns(3)
                        .setRoundColorButton(true)
                        .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                            @Override
                            public void onChooseColor(int position,int color) {
                                // put code
                                color3=color;
                                ((GradientDrawable)v3.getBackground()).setColor(color3);
                            }

                            @Override
                            public void onCancel(){
                                // put code
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();
            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ColorPicker colorPicker = new ColorPicker(unlock.this);
                ArrayList<String> colors = new ArrayList<>();
                colors.add("#FF0000");
                colors.add("#00FF00");
                colors.add("#0000FF");
                colors.add("#008000");
                colors.add("#000080");
                colors.add("#FF00FF");



                colorPicker.setColors(colors)
                        .setColumns(3)
                        .setRoundColorButton(true)
                        .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                            @Override
                            public void onChooseColor(int position,int color) {
                                // put code
                                color4=color;
                                ((GradientDrawable)v4.getBackground()).setColor(color4);
                            }

                            @Override
                            public void onCancel(){
                                // put code
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();
            }
        });


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gobi(unlock.this);
            }
        });

        newp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydatabase.delete();
                startActivity(new Intent(unlock.this,MainActivity.class));
            }
        });



    }


    public static void gobi(Context applicationContext){


        s1 = n1.getText().toString();
        s2 = n2.getText().toString();
        s3 = n3.getText().toString();
        s4 = n4.getText().toString();

        getData();

        Log.d("colors", String.valueOf(co[0])+String.valueOf(co[1])+String.valueOf(co[2]));

        if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4))
        {
            Toast.makeText(applicationContext, "Please enter numbers", Toast.LENGTH_SHORT).show();
        }else {
            if(s1.equals(number[0]) && s2.equals(number[1]) && s3.equals(number[2]) && s4.equals(number[3])){
                if(String.valueOf(color1).equals(co[0]) && String.valueOf(color2).equals(co[1]) && String.valueOf(color3).equals(co[2]) && String.valueOf(color4).equals(co[3])){
                    Toast.makeText(applicationContext, "Phone Unlocked", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(applicationContext, "Colors didn't match", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(applicationContext, "Enter numbers Correctly", Toast.LENGTH_SHORT).show();
            }
        }




    }

}
