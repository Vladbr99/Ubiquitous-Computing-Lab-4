package com.example.lab4;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
public class RecipeLoader {

    public static ArrayList<Recipe> loadRecipes(Context context) {

        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            InputStream input = context.getAssets().open("recipes.json");

            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            input.close();

            String json = new String(buffer, StandardCharsets.UTF_8);

            JSONObject jsonObject = new JSONObject(json);
            JSONArray recipeArray = jsonObject.getJSONArray("recipes");

            for (int i = 0; i < recipeArray.length(); i++) {

                JSONObject item = recipeArray.getJSONObject(i);

                String name = item.getString("name");
                String method = item.getString("method");

                JSONArray ingredientArray = item.getJSONArray("ingredients");
                ArrayList<String> ingredients = new ArrayList<>();

                for (int j = 0; j < ingredientArray.length(); j++) {
                    ingredients.add(ingredientArray.getString(j));
                }

                recipes.add(new Recipe(name, ingredients, method));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return recipes;
    }
}
