package com.example.myapplicationtest;

import android.annotation.SuppressLint;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplicationtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int counter = 2;
    public ImageView imageView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Button button1 = findViewById(R.id.button11);
        Button button2 = findViewById(R.id.button12);

        imageView = findViewById(R.id.imageView3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button11:
            case R.id.button12:
                switchPhoto();
                break;
        }
    }

    public void switchPhoto() {
        if (counter % 2 == 0) {
            imageView.setImageIcon(Icon.createWithContentUri("@drawable/_002"));
        } else {
            imageView.setImageIcon(Icon.createWithContentUri("@drawable/_001"));
        }
        counter++;
    }
}