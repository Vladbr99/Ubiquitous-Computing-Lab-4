
package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import android.content.Intent;

public class RecipesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        ListView recipeListView = view.findViewById(R.id.recipeListView);

        ArrayList<Recipe> recipes = RecipeLoader.loadRecipes(requireContext());

        ArrayList<String> recipeNames = new ArrayList<>();

        for (Recipe recipe : recipes) {
            recipeNames.add(recipe.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                recipeNames
        );

        recipeListView.setAdapter(adapter);


        recipeListView.setOnItemClickListener((parent, itemView, position, id) -> {

            MainActivity activity = (MainActivity) requireActivity();

            if (activity.findViewById(R.id.detail_container) != null) {

                activity.showRecipeDetails(position);

            } else {

                Intent intent = new Intent(requireContext(), RecipeDetailActivity.class);
                intent.putExtra("recipePosition", position);
                startActivity(intent);
            }
        });



        return view;
    }
}
