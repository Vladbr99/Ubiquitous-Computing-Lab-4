
package com.example.lab4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        int position = getIntent().getIntExtra("recipePosition", 0);

        if (savedInstanceState == null) {
            IngredientsFragment detailFragment = new IngredientsFragment();
            detailFragment.setRecipePosition(position);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail_container, detailFragment)
                    .commit();
        }
    }
}
