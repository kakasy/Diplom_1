import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bunMock;

    @Test
    public void getNameBunTest() {
        bunMock.getName();
        bunMock.getName();
        bunMock.getName();
        Mockito.verify(bunMock, Mockito.times(3)).getName();
    }

    @Test
    public void getPriceBunTest() {
        bunMock.getPrice();
        bunMock.getPrice();
        bunMock.getPrice();
        Mockito.verify(bunMock, Mockito.times(3)).getPrice();
    }


    @Test
    public void getNameBunStubTest() {
        Mockito.when(bunMock.getName()).thenReturn("Багет");
        assertEquals("Багет", bunMock.getName());
    }


    @Test
    public void getPriceBunStubTest() {
        Mockito.when(bunMock.getPrice()).thenReturn(250.0f);
        assertEquals(250.0f, bunMock.getPrice(), 0);
    }
}
