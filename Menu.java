package com.hexaware.MLP156.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 * foodName to store foodname.
 * venId to store vendor Id.
 * foodType to store the type of food.
 * calories to store the calorie of food.
 * foodAmt is to store price of food.
 */
  private int foodId;
  private String foodName;
  private int venId;
  private String foodType;
  private String calories;
  private double foodAmt;
  /**
  * Default Constructor.
  */
  public Menu() {
  }
/**
 * @param argFoodId to initialize argFoodId attributes.
 * @param argFoodName to initialize argFoodName attributes.
 * @param argVenId to initialize argVenId attributes.
 * @param argFoodType to initialize argFoodType attributes.
 * @param argCalories to initialize argCalories attributes.
 * @param argFoodAmt to initialize argFoodAmt attributes.
 */
  public Menu(final int argFoodId, final String argFoodName,
        final int argVenId, final String argFoodType, final String argCalories, final double argFoodAmt) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.venId = argVenId;
    this.foodType = argFoodType;
    this.calories = argCalories;
    this.foodAmt = argFoodAmt;
  }
  @Override
    public final boolean equals(final Object obj) {

    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)
            && Objects.equals(foodName, menu.foodName)
            && Objects.equals(venId, menu.venId)
            && Objects.equals(foodType, menu.foodType)
            && Objects.equals(calories, menu.calories)
            && Objects.equals(foodAmt, menu.foodAmt)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(foodId, foodName, venId, foodType, calories, foodAmt);
  }
  /**
  * @return this food ID.
  */
  public final int getFoodId() {
    return foodId;
  }
  /**
  * @param argFoodId gets the food id.
  */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /**
  * @return this food ID.
  */
  public final String getFoodName() {
    return foodName;
  }
  /**
  * @param argFoodName gets the food name.
  */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  /**
  * @return this Vendor ID.
  */
  public final int getVenId() {
    return venId;
  }
  /**
  * @param argVenId gets the vendor id.
  */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
  /**
  * @return this food Type.
  */
  public final String getFoodType() {
    return foodType;
  }
  /**
  * @param argFoodType gets the food type.
  */
  public final void setFoodType(final String argFoodType) {
    this.foodType = argFoodType;
  }
  /**
  * @return this food Amount.
  */
  public final double getFoodAmt() {
    return foodAmt;
  }
  /**
  * @param argFoodAmt gets the food amount.
  */
  public final void setFoodAmt(final double argFoodAmt) {
    this.foodAmt = argFoodAmt;
  }
 /**
  * @return this food Calories.
  */
  public final String getCalories() {
    return calories;
  }
    /**
  * @param argCalories gets the food amount.
  */

  public final void setCalories(final String argCalories) {
    this.calories = argCalories;
  }

  @Override
  public final String toString() {
    return "Menu [calories=" + calories + ", foodAmt=" + foodAmt + ", foodId=" + foodId + ", foodName=" + foodName
        + ", foodType=" + foodType + ", venId=" + venId + "]";
  }
}
