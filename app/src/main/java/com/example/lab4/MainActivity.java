package com.example.lab4;

import android.os.Bundle;

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

        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new RecipesFragment())
                    .commit();


            if (findViewById(R.id.detail_container) != null) {

                IngredientsFragment detailFragment = new IngredientsFragment();
                detailFragment.setRecipePosition(0);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.detail_container, detailFragment)
                        .commit();
            }
        }
    }

    public void showRecipeDetails(int position) {

        if (findViewById(R.id.detail_container) != null) {

            IngredientsFragment detailFragment = new IngredientsFragment();
            detailFragment.setRecipePosition(position);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail_container, detailFragment)
                    .commit();
        }
    }
}