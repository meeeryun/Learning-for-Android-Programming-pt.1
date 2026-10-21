package com.taeryun.middle_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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

        TextView tv_fruit = findViewById(R.id.tv_fruit);
        Button btn_a = findViewById(R.id.b_apple);
        Button btn_b = findViewById(R.id.b_pear);

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                if(v.getId() == R.id.b_apple) {
                    tv_fruit.setText("사과");
                }
                else {
                    tv_fruit.setText("배");
                }
            }
        };

        View.OnLongClickListener l_listener = new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                if(v.getId() == R.id.b_apple || v.getId() == R.id.b_pear) {
                    tv_fruit.setText("과일을 선택하세요"); // 이걸 여기에 넣어야 이벤트 주도 (Event Driven) 형태가 띔
                    return true;
                }
                else {
                    return false;
                }
            }
        };

        btn_a.setOnLongClickListener(l_listener);
        btn_b.setOnLongClickListener(l_listener); // longclick 이벤트

        btn_a.setOnClickListener(listener);
        btn_b.setOnClickListener(listener);
    }
}