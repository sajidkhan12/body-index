package com.example.bodyindex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView mbmidisplay,magedisplay,mweightdisplay,mheightdisplay,mbmicategory,mgender;
    Button mgotomain;
    Intent intent;

    ImageView mimageview;
    String mbmi;
    String cateogory;
    float intbmi;

    String height;
    String weight;

    float intheight,intweight;

    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        intent=getIntent();
        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        mbmidisplay=findViewById(R.id.bmidisplay);

        mbmicategory = findViewById(R.id.bmicategorydispaly);
        mgotomain=findViewById(R.id.gotomain);

        mimageview=findViewById(R.id.imageview);


        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);




        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);


        mbmi=Float.toString(intbmi);
        System.out.println(mbmi);

        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");

            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);


        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Moderate Thinness");

            mimageview.setImageResource(R.drawable.warning);


        }
        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("Mild Thinness");

            mimageview.setImageResource(R.drawable.warning);

        }
        else if(intbmi<24.9 && intbmi>18.5 )
        {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.ok);

        }
        else if(intbmi <29.9 && intbmi>25)
        {
            mbmicategory.setText("Overweight");
           
            mimageview.setImageResource(R.drawable.warning);

        }
        else if(intbmi<34.9 && intbmi>30)
        {
            mbmicategory.setText("Obese Class I");

            mimageview.setImageResource(R.drawable.warning);

        }
        else
        {
            mbmicategory.setText("Obese Class II");

            mimageview.setImageResource(R.drawable.crosss);

        }


        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        mgotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}