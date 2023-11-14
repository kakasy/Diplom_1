import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bunMock;

    @Mock
    Ingredient ingredientMock1;

    @Mock
    Ingredient ingredientMock2;

    @Mock
    Ingredient ingredientMock3;

    @Mock
    Ingredient ingredientMock4;


    @Test
    public void getBurgerPriceTest() {
        Mockito.when(bunMock.getPrice()).thenReturn(300.0f);
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.getPrice();

        Mockito.verify(bunMock, Mockito.times(1)).getPrice();

        assertEquals(600.0f, burger.getPrice(), 0);
    }


    @Test
    public void getBurgerPriceWithIngredientTest() {

        Mockito.when(bunMock.getPrice()).thenReturn(19.99f); // х2

        Mockito.when(ingredientMock1.getPrice()).thenReturn(10.0f); //+
        Mockito.when(ingredientMock2.getPrice()).thenReturn(6.0f); //+
        Mockito.when(ingredientMock3.getPrice()).thenReturn(8.0f); //+
        Mockito.when(ingredientMock4.getPrice()).thenReturn(12.0f); //+

        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.ingredients = new ArrayList<>(List.of(ingredientMock1, ingredientMock2, ingredientMock3, ingredientMock4));
        burger.getPrice();

        Mockito.verify(bunMock, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock1, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock2, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock3, Mockito.times(1)).getPrice();
        Mockito.verify(ingredientMock4, Mockito.times(1)).getPrice();

        assertEquals(75.98f, burger.getPrice(), 0.1);
    }


    @Test
    public void getReceiptBurgerTest() {
        Burger burger = new Burger();

        String name = "Булочка из ржаного хлеба";
        String cutlet = "Куриная котлета";
        String caesarSauce = "Соус Цезарь";

        Bun bun = new Bun(name, 10.2f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, cutlet, 19.99f);
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, caesarSauce, 99.95f);

        burger.setBuns(bun);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);

        System.out.println(burger.getReceipt());

        assertEquals("(==== " + name + " ====)\r\n" +
                "= filling " + cutlet + " =\r\n" +
                "= sauce " + caesarSauce + " =\r\n" +
                "(==== " + name + " ====)\r\n" +
                "\r\nPrice: 140,339996\r\n", burger.getReceipt());
    }


    @Test
    public void addIngredientToBurgerTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.addIngredient(ingredientMock4);

        assertEquals(4, burger.ingredients.size());
    }


    @Test
    public void removeIngredientFromBurgerTest() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>(List.of(ingredientMock1, ingredientMock2, ingredientMock3, ingredientMock4));
        burger.removeIngredient(2);

        assertEquals(3, burger.ingredients.size());
    }


    @Test
    public void moveIngredientInBurgerTest() {
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>(List.of(ingredientMock1, ingredientMock2, ingredientMock3, ingredientMock4));
        burger.moveIngredient(2, 0);

        assertEquals(new ArrayList<>(List.of(ingredientMock3, ingredientMock1, ingredientMock2, ingredientMock4))
                , burger.ingredients);
    }
}
