package com.example.pc.countappsharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int i=0;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    private int colorcode;
    SharedPreferences sp;
    private String spFilename="com.example.pc.countappsharedpref";
    private String count_key="count_key";
    private String color_key="color_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txt);
        btn1=findViewById(R.id.black);
        btn2=findViewById(R.id.red);
        btn3=findViewById(R.id.blue);
        btn4=findViewById(R.id.green);
        sp=getSharedPreferences(spFilename,MODE_PRIVATE);

            i=sp.getInt(count_key,0);

            colorcode=sp.getInt(color_key,1);
            if(i!=0){
                textView.setText(String.valueOf(i));
                textView.setBackgroundColor(colorcode);
            }


        }

        //btn5=findViewById(R.id.countinc);
        //btn6=findViewById(R.id.reset);



    public void black(View view) {
         colorcode=getResources().getColor(R.color.black);
        textView.setBackgroundColor(colorcode);
    }

    public void red(View view) {
        colorcode=getResources().getColor(R.color.red);
        textView.setBackgroundColor(colorcode);
    }

    public void blue(View view) {
        colorcode=getResources().getColor(R.color.blue);
        textView.setBackgroundColor(colorcode);

    }

    public void green(View view) {
        colorcode=getResources().getColor(R.color.green);
        textView.setBackgroundColor(colorcode);

    }

    public void reset(View view) {
        i=0;
        textView.setText(String.valueOf(i));
    }

    public void countinc(View view) {
        i++;
        textView.setText(String.valueOf(i));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(count_key,i);
        editor.putInt(color_key,colorcode);
        editor.commit();
        Toast.makeText(this, "Data is Saved", Toast.LENGTH_SHORT).show();
    }
}
