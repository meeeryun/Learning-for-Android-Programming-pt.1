package com.taeryun.middle_1;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tv_msg = findViewById(R.id.tv_msg);
        TextView tv_promptColor = findViewById(R.id.tv_promptColor);
        TextView tv_promptStyle = findViewById(R.id.tv_promptStyle);

        RadioGroup rg = findViewById(R.id.radioGroup);

        CompoundButton tb_b = findViewById(R.id.cb_bold);
        CompoundButton tb_i = findViewById(R.id.cb_italic);

        ToggleButton config = findViewById(R.id.tb_config);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                if(i == R.id.rb_red) {
                    tv_msg.setTextColor(Color.RED);
                }
                else if(i == R.id.rb_green) {
                    tv_msg.setTextColor(Color.GREEN);
                }
                else if(i == R.id.rb_blue){
                    tv_msg.setTextColor(Color.BLUE);
                }
            }
        });

        tb_b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                int currentStyle = tv_msg.getTypeface() != null ? tv_msg.getTypeface().getStyle() : Typeface.NORMAL;
                int newStyle;

                if(b) {
                    newStyle = currentStyle + Typeface.BOLD;
                }
                else {
                    newStyle = currentStyle - Typeface.BOLD;
                }

                tv_msg.setTypeface(null, newStyle);
            }
        });

        tb_i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                int currentStyle = tv_msg.getTypeface() != null ? tv_msg.getTypeface().getStyle() : Typeface.NORMAL;
                int newStyle;

                if(b) {
                    newStyle = currentStyle + Typeface.ITALIC;
                }
                else {
                    newStyle = currentStyle - Typeface.ITALIC;
                }

                tv_msg.setTypeface(null, newStyle);
            }
        });

        config.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b) {
                    tv_promptColor.setVisibility(View.GONE);
                    tv_promptStyle.setVisibility(View.GONE);

                    rg.setVisibility(View.GONE);

                    tb_b.setVisibility(View.GONE);
                    tb_i.setVisibility(View.GONE);

                    config.getTextOn();
                }
                else {
                    tv_promptColor.setVisibility(View.VISIBLE);
                    tv_promptStyle.setVisibility(View.VISIBLE);

                    rg.setVisibility(View.VISIBLE);

                    tb_b.setVisibility(View.VISIBLE);
                    tb_i.setVisibility(View.VISIBLE);
                    config.getTextOff();
                }
            }
        });
    }
}