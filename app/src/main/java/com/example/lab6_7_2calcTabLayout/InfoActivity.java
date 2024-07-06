package com.example.lab6_7_2calcTabLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab6_7_2calcTabLayout.databinding.ActivityInfoBinding;

import java.util.Objects;

public class InfoActivity extends AppCompatActivity {
    private ActivityInfoBinding binding;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().setTitle("Calc");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        result = intent.getStringExtra("result");

        assert result != null;
        if (!result.isEmpty()) {
            binding.result.setText("Результат вычислений:\n\n" + result);
        }

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            // О программе
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("О программе")
                    .setMessage("Это приложение калькулятора WeightUnitWizard.\n" +
                            "Оно предназначено для перевода единиц измерения массы.")
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        } else if (id == R.id.item2) {
            // Об авторе
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Об авторе")
                    .setMessage("Быкасова Анастасия Сергеевна, 211-361")
                    .setPositiveButton("OK", null)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}