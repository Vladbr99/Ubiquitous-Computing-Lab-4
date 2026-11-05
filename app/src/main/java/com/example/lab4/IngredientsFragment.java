package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class IngredientsFragment extends Fragment {

    private int recipePosition = 0;

    public void setRecipePosition(int position) {
        recipePosition = position;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);

        TextView recipeTitle = view.findViewById(R.id.recipeTitle);
        TextView ingredientsText = view.findViewById(R.id.ingredientsText);
        TextView methodText = view.findViewById(R.id.methodText);

        ArrayList<Recipe> recipes = RecipeLoader.loadRecipes(requireContext());

        if (recipePosition >= 0 && recipePosition < recipes.size()) {

            Recipe recipe = recipes.get(recipePosition);

            recipeTitle.setText(recipe.getName());

            String ingredients = "";

            for (String ingredient : recipe.getIngredients()) {
                ingredients += "• " + ingredient + "\n";
            }

            ingredientsText.setText(ingredients);
            methodText.setText(recipe.getMethod());
        }

        return view;
    }
}
