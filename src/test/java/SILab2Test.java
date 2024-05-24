import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void everyBranchTest(){
        // 1
        int p1 = 100;
        List<Item> list1 = null;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(list1, p1));
        // 2
        List<Item> list2 = new ArrayList<>();
        list2.add(new Item("first", "565d", 100, 0.5f));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(list2, p1));
        // 3
        List<Item> list3 = new ArrayList<>();
        list3.add(new Item("first", null, 100, 0.5f));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(list3, p1));
        // 4
        List<Item> list4 = new ArrayList<>();
        list4.add(new Item("", "5654", 100, 0.5f));
        SILab2.checkCart(list4, p1);
        assertEquals("unknown", list4.get(0).getName());
        // 5
        int p2 = 1000;
        List<Item> list5 = new ArrayList<>();
        list5.add(new Item("first", "5654", 100, 0));
        list5.add(new Item("second", "5655", 50, 0));
        assertTrue(SILab2.checkCart(list5, p2));
        // 6
        List<Item> list6 = new ArrayList<>();
        list6.add(new Item("first", "5654", 100, 0));
        list6.add(new Item("second", "5655", 200, 0));
        list6.add(new Item("third", "1234", 500, 0));
        assertFalse(SILab2.checkCart(list6, p1));
        // 7
        List<Item> list7 = new ArrayList<>();
        list7.add(new Item("first", "5654", 100, 0.2f));
        list7.add(new Item("second", "5655", 200, 0.4f));
        assertTrue(SILab2.checkCart(list7, p2));
        // 8
        List<Item> list8 = new ArrayList<>();
        list8.add(new Item("first", "5654", 100, 0.2f));
        list8.add(new Item("second", "5655", 200, 0.4f));
        list8.add(new Item("third", "1234", 500, 0.6f));
        assertFalse(SILab2.checkCart(list8, p1));
    }

    @Test
    public void multipleConditionTest(){
        // 1
        List<Item> list1 = new ArrayList<>();
        list1.add(new Item("first","0987", 200, 0.5f));
        assertFalse(SILab2.checkCart(list1,269));
        // 2
        List<Item> list2 = new ArrayList<>();
        list2.add(new Item("first","0987",400,0));
        assertFalse(SILab2.checkCart(list2,370));
        // 3
        List<Item> list3 = new ArrayList<>();
        list3.add(new Item("first","5654",500,0.5f));
        assertFalse(SILab2.checkCart(list3,359));
        // 4
        List<Item> list4 = new ArrayList<>();
        list4.add(new Item("first","0987",500,0.5f));
        assertTrue(SILab2.checkCart(list4,330));
    }
}