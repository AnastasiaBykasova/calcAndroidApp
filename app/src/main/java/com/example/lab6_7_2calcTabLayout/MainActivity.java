package com.example.lab6_7_2calcTabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab6_7_2calcTabLayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CalcFragment.onInputEventListener {
    private ActivityMainBinding binding;
    private static final String LOG_TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        FragmentStateAdapter pageAdapter = new MyAdapter(this);
        binding.pager.setAdapter(pageAdapter);

        getSupportActionBar().setTitle("Calc");

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tabLayout,
                binding.pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("Калькулятор");
                }
                else if (position == 1) {
                    tab.setText("О программе");
                }
                else if (position == 2) {
                    tab.setText("Об авторе");
                }
            }
        });
        tabLayoutMediator.attach();
    }

    public void inputEvent(String unit, double weight) {
        Intent intent = new Intent(this, InfoActivity.class);
        if (!unit.isEmpty()) {
            String res = startCalculations(unit, weight);
            intent.putExtra("result", res);
        }
        startActivity(intent);
    }

    private String startCalculations(String unit, double weight) {
        String resStr = "";
        switch (unit) {
            case "Караты":
                resStr = calculateCarats(weight);
                break;
            case "Граммы":
                resStr = calculateGrams(weight);
                break;
            case "Килограммы":
                resStr = calculateKilograms(weight);
                break;
            case "Центнеры":
                resStr = calculateHundredweight(weight);
                break;
            case "Тонны":
                resStr = calculateTons(weight);
                break;
            case "Фунты":
                resStr = calculatePounds(weight);
                break;
            case "Унции":
                resStr = calculateOunces(weight);
                break;
        }

        return resStr;
    }

    public static String calculateCarats(double carats) {
        String res = "";
        double grams = carats * 0.2;
        double kilograms = carats * 0.0002;
        double hundredweight = carats * 0.00002;
        double tons = carats * 0.0000002;
        double pounds = carats * 0.000440924;
        double ounces = carats * 0.00705479;
        res = "Граммы: " + grams + "\nКилограммы: " + kilograms + "\nЦентнеры: " + hundredweight +
                "\nТонны: " + tons + "\nФунты: " + pounds + "\nУнции: " + ounces;
        return res;
    }

    public static String calculateGrams(double grams) {
        String res = "";
        double carats = grams * 5;
        double kilograms = grams * 0.001;
        double hundredweight = grams * 0.00001;
        double tons = grams * 0.000001;
        double pounds = grams * 0.00220462;
        double ounces = grams * 0.035274;
        res = "Караты: " + carats + "\nКилограммы: " + kilograms + "\nЦентнеры: " + hundredweight +
                "\nТонны: " + tons + "\nФунты: " + pounds + "\nУнции: " + ounces;
        return res;
    }

    public static String calculateKilograms(double kilograms) {
        String res = "";
        double carats = kilograms * 5000;
        double grams = kilograms * 1000;
        double hundredweight = kilograms * 0.01;
        double tons = kilograms * 0.001;
        double pounds = kilograms * 2.20462;
        double ounces = kilograms * 35.274;
        res = "Караты: " + carats + "\nГраммы: " + grams + "\nЦентнеры: " + hundredweight +
                "\nТонны: " + tons + "\nФунты: " + pounds + "\nУнции: " + ounces;
        return res;
    }

    public static String calculateHundredweight(double hundredweight) {
        String res = "";
        double carats = hundredweight * 250000;
        double grams = hundredweight * 100000;
        double kilograms = hundredweight * 100;
        double tons = hundredweight * 0.1;
        double pounds = hundredweight * 220.462;
        double ounces = hundredweight * 3527.4;
        res = "Караты: " + carats + "\nГраммы: " + grams + "\nКилограммы: " + kilograms +
                "\nТонны: " + tons + "\nФунты: " + pounds + "\nУнции: " + ounces;
        return res;
    }

    public static String calculateTons(double tons) {
        String res = "";
        double carats = tons * 5000000;
        double grams = tons * 1000000;
        double kilograms = tons * 1000;
        double hundredweight = tons * 10;
        double pounds = tons * 2204.62;
        double ounces = tons * 35274;
        res = "Караты: " + carats + "\nГраммы: " + grams + "\nКилограммы: " + kilograms +
                "\nЦентнеры: " + hundredweight + "\nФунты: " + pounds + "\nУнции: " + ounces;
        return res;
    }

    public static String calculatePounds(double pounds) {
        String res = "";
        double carats = pounds * 5000000;
        double grams = pounds * 1000000;
        double kilograms = pounds * 1000;
        double hundredweight = pounds * 10;
        double tons = pounds * 2204.62;
        double ounces = pounds * 35274;
        res = "Караты: " + carats + "\nГраммы: " + grams + "\nКилограммы: " + kilograms +
                "\nЦентнеры: " + hundredweight + "\nТонны: " + tons + "\nУнции: " + ounces;
        return res;
    }

    public static String calculateOunces(double ounces) {
        String res = "";
        double carats = ounces * 5000000;
        double grams = ounces * 1000000;
        double kilograms = ounces * 1000;
        double hundredweight = ounces * 10;
        double tons = ounces * 2204.62;
        double pounds = ounces * 35274;
        res = "Караты: " + carats + "\nГраммы: " + grams + "\nКилограммы: " + kilograms +
                "\nЦентнеры: " + hundredweight + "\nТонны: " + tons + "\nФунты: " + pounds;
        return res;
    }

}
