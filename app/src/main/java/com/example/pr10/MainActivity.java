package com.example.pr10;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;

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
    }
    public void AlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    EditText fio;
    EditText phone;
    EditText adress;
    public void OnArrange(View view) {
        fio = findViewById(R.id.EtFio);
        phone = findViewById(R.id.EtPhone);
        adress = findViewById(R.id.EtAddress);

        if(fio.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите ФИО");
        else if(phone.getText().length() == 0 || !phone.getText().toString().matches("^8 9\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}$")) AlertDialog("Уведомление", "Пожалуйста, укажите корректный номер телефона");
        else if(adress.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите адрес доставки");
        else {
            AlertDialog("Уведомление", "Заказ оформлен");
        }
    }
}