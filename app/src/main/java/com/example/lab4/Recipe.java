package com.example.lab4;
import java.util.ArrayList;
public class Recipe {

    private String name;
    private ArrayList<String> ingredients;
    private String method;

    public Recipe(String name, ArrayList<String> ingredients, String method) {
        this.name = name;
        this.ingredients = ingredients;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getMethod() {
        return method;
    }
}
