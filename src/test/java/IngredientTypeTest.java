import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauceTest() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeFillingTest() {
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
