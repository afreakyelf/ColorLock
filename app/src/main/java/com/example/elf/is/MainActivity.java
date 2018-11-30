package com.example.elf.is;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

//import petrov.kristiyan.colorpicker.ColorPicker;

import petrov.kristiyan.colorpicker.ColorPicker;

import static com.example.elf.is.myDatabase.co;
import static com.example.elf.is.myDatabase.getData;


public class MainActivity extends AppCompatActivity {

    EditText n1, n2, n3, n4;
    TextView cleard;
    View v1, v2, v3, v4;
    Button b1, b2, b3, b4, set, view;
    String s1, s2, s3, s4;
    int color1, color2, color3, color4;

    myDatabase mydatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydatabase = new myDatabase(this);

        cleard = findViewById(R.id.cleardata);
        cleard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydatabase.delete();
            }
        });

        n1 = findViewById(R.id.number1);
        n2 = findViewById(R.id.number2);
        n3 = findViewById(R.id.number3);
        n4 = findViewById(R.id.number4);

        v1 = findViewById(R.id.c1);
        v2 = findViewById(R.id.c2);
        v3 = findViewById(R.id.c3);
        v4 = findViewById(R.id.c4);

  /*      b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
*/

        set = findViewById(R.id.setpassword);


        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
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
                            public void onChooseColor(int position, int color) {
                                // put code
                                color1 = color;
                              //  v1.setBackgroundColor(color1);
                                ((GradientDrawable)v1.getBackground()).setColor(color1);
                            }

                            @Override
                            public void onCancel() {
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();

            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
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
                            public void onChooseColor(int position, int color) {
                                // put code
                                color2 = color;
                                ((GradientDrawable)v2.getBackground()).setColor(color2);
                            }

                            @Override
                            public void onCancel() {
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
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
                            public void onChooseColor(int position, int color) {
                                // put code
                                color3 = color;
                                ((GradientDrawable)v3.getBackground()).setColor(color3);
                            }

                            @Override
                            public void onCancel() {
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();
            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
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
                            public void onChooseColor(int position, int color) {
                                // put code
                                color4 = color;
                                ((GradientDrawable)v4.getBackground()).setColor(color4);

                            }

                            @Override
                            public void onCancel() {
                                colorPicker.dismissDialog();
                            }
                        })
                        .show();
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                s1 = n1.getText().toString();
                s2 = n2.getText().toString();
                s3 = n3.getText().toString();
                s4 = n4.getText().toString();

                if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4))
                {
                    Toast.makeText(MainActivity.this, "Please enter numbers", Toast.LENGTH_SHORT).show();
                }else {
                    if (String.valueOf(color1) == null || String.valueOf(color2) == null || String.valueOf(color3) == null || String.valueOf(color4) == null) {
                        Toast.makeText(MainActivity.this, "Please select Colors", Toast.LENGTH_SHORT).show();
                    } else {
                        mydatabase.insertData(s1, String.valueOf(color1));
                        mydatabase.insertData(s2, String.valueOf(color2));
                        mydatabase.insertData(s3, String.valueOf(color3));
                        mydatabase.insertData(s4, String.valueOf(color4));


                        startActivity(new Intent(MainActivity.this, unlock.class));
                    }

                }

            }
        });


    }
}
