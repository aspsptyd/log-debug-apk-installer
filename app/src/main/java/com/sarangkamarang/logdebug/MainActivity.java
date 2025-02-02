package com.sarangkamarang.logdebug;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LoggerToFiles logger = new LoggerToFiles(MainActivity.this);

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
        try {
            // Proses jika ingin ditambahkan
            logger.logToFile("Ini adalah percobaan untuk log ke dalam file .txt, bisa di custome berdasarkan kebutuhan");
        } catch (Exception error) {
            // Untuk catch data log ke file
            logger.logToFile(String.valueOf(error));
        }
    }
}