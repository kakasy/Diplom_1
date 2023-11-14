import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;

    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][]{
                {IngredientType.FILLING, "Бекон", 7.5f},
                {IngredientType.SAUCE, "Чипотл Саусвест", 9.0f},
        };
    }

    @Test
    public void getPriceIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }
}
