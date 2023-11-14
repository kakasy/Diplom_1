import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientMockTest {

    @Mock
    Ingredient ingredientMock;


    @Test
    public void getPriceIngredientTest() {
        ingredientMock.getPrice();
        ingredientMock.getPrice();
        ingredientMock.getPrice();
        ingredientMock.getPrice();
        Mockito.verify(ingredientMock, Mockito.times(4)).getPrice();
    }


    @Test
    public void getNameIngredientTest() {
        ingredientMock.getName();
        Mockito.verify(ingredientMock, Mockito.times(1)).getName();
    }


    @Test
    public void getTypeIngredientTest() {
        ingredientMock.getType();
        ingredientMock.getType();
        Mockito.verify(ingredientMock, Mockito.times(2)).getType();
    }


    @Test
    public void getNameIngredientStubTest() {
        Mockito.when(ingredientMock.getName()).thenReturn("Перец халапеньо");
        assertEquals("Перец халапеньо", ingredientMock.getName());
    }


    @Test
    public void getTypeIngredientStubTest() {
        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        assertEquals(IngredientType.FILLING, ingredientMock.getType());
    }


    @Test
    public void getPriceIngredientStubTest() {
        Mockito.when(ingredientMock.getPrice()).thenReturn(99.95f);
        assertEquals(99.95f, ingredientMock.getPrice(), 0);
    }


}
