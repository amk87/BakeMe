package com.example.android.bakeme.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipe implements Parcelable {

    @SerializedName("id")
    private Integer mRecipeId;

    @SerializedName("name")
    private String mRecipeName;

    @SerializedName("ingredients")
    private List<Ingredient> mIngredients;

    @SerializedName("steps")
    private List<PreparationStep> mPreparationSteps;

    @SerializedName("servings")
    private Integer mServingSize;

    @SerializedName("image")
    private String mRecipeImageResourceId;


    // Empty Constructor
    public Recipe() {
    }

    public Recipe(int id, String name, List<Ingredient> ingredients, List<PreparationStep> steps, int servingSize) {
        this.mRecipeId = id;
        this.mRecipeName = name;
        this.mIngredients = ingredients;
        this.mPreparationSteps = steps;
        this.mServingSize = servingSize;
    }

    public Integer getmRecipeId() {
        return mRecipeId;
    }

    public void setmRecipeId(Integer mRecipeId) {
        this.mRecipeId = mRecipeId;
    }

    public String getmRecipeName() {
        return mRecipeName;
    }

    public void setmRecipeName(String mRecipeName) {
        this.mRecipeName = mRecipeName;
    }

    public List<Ingredient> getmIngredients() {
        return mIngredients;
    }

    public void setmIngredients(List<Ingredient> mIngredients) {
        this.mIngredients = mIngredients;
    }

    public List<PreparationStep> getmPreparationSteps() {
        return mPreparationSteps;
    }

    public void setmPreparationSteps(List<PreparationStep> mPreparationSteps) {
        this.mPreparationSteps = mPreparationSteps;
    }

    public Integer getmServingSize() {
        return mServingSize;
    }

    public void setmServingSize(Integer mServingSize) {
        this.mServingSize = mServingSize;
    }

    public String getmRecipeImageResourceId() {
        return mRecipeImageResourceId;
    }

    public void setmRecipeImageResourceIdByName(String mRecipeImageResourceId) {
        this.mRecipeImageResourceId = mRecipeImageResourceId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mRecipeId);
        dest.writeString(this.mRecipeName);
        dest.writeTypedList(this.mIngredients);
        dest.writeTypedList(this.mPreparationSteps);
        dest.writeInt(this.mServingSize);
        dest.writeString(this.mRecipeImageResourceId);
    }

    protected Recipe(Parcel in) {
        this.mRecipeId = in.readInt();
        this.mRecipeName = in.readString();
        this.mIngredients = in.createTypedArrayList(Ingredient.CREATOR);
        this.mPreparationSteps = in.createTypedArrayList(PreparationStep.CREATOR);
        this.mServingSize = in.readInt();
        this.mRecipeImageResourceId = in.readString();
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
