package com.app.food;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FoodStepDefinitions {
    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothieSchema superSmoothieSchema = new SuperSmoothieSchema(drinkCatalog);
    private MorningFreshnessMember member;

   /* @Given("the following drink categories:")
    public void the_following_drink_categories(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }*/

    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
        drinkCategories.stream().forEach(
                drinkCategory -> {
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer points = Integer.parseInt(drinkCategory.get("Points"));
                    drinkCatalog.addDrink(drink, category);
                    superSmoothieSchema.setPointsPerCategory(category, points);

                }
        );
    }

    @Given("^(.*) is a Morning Freshness Member$")
    public void michael_is_a_Morning_Freshness_Member(String name) {
        member = new MorningFreshnessMember(name, superSmoothieSchema);

    }

    //@When("Michael purchases {\\d+} (.*) drinks?")
    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void michael_purchases_Apple_and_Kale_drinks(String name, Integer amount, String drink) {
        member.orders(amount, drink);
    }

    @Then("he should earn {int} points")
    public void he_should_earn_points(Integer expectedPoints) {
         assertThat(member.getPoints()==expectedPoints);
    }


}
