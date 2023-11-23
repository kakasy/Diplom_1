import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    @Test
    public void availableBunsInDatabaseTest() {
        Database database = new Database();

        Bun blackBun = new Bun("black bun", 100);
        Bun whiteBun = new Bun("white bun", 200);
        Bun redBun = new Bun("red bun", 300);

        List<Bun> buns = new ArrayList<>(List.of(blackBun, whiteBun, redBun));

        assertEquals(buns.size(), database.availableBuns().size());

        for (int i = 0; i < buns.size(); i++) {

            assertEquals(buns.get(i).getName(), database.availableBuns().get(i).getName());
            assertEquals(buns.get(i).getPrice(), database.availableBuns().get(i).getPrice(), 0);

        }
    }


    @Test
    public void availableIngredientsInDatabaseTest() {
        Database database = new Database();

        Ingredient hotSauce = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient sourCream = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient chiliCream = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);

        Ingredient cutlet = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient dinosaur = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        Ingredient sausage = new Ingredient(IngredientType.FILLING, "sausage", 300);

        List<Ingredient> ingredients = new ArrayList<>(List.of(hotSauce, sourCream,
                chiliCream, cutlet, dinosaur, sausage));

        assertEquals(ingredients.size(), database.availableIngredients().size());

        for (int i = 0; i < ingredients.size(); i++) {

            assertEquals(ingredients.get(i).getPrice(), database.availableIngredients().get(i).getPrice(), 0);
            assertEquals(ingredients.get(i).getName(), database.availableIngredients().get(i).getName());
            assertEquals(ingredients.get(i).getType(), database.availableIngredients().get(i).getType());

        }
    }
}
