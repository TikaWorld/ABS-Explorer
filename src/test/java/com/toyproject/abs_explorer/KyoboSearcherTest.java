package com.toyproject.abs_explorer;

import static org.junit.Assert.*;
import org.junit.Test;

public class KyoboSearcherTest {
    @Test
    public void regularizationTest() {
        KyoboSearcher kyoboSearcher = new KyoboSearcher();
        String regularedWord =kyoboSearcher.regularization("Computer Architecture");
        System.out.println(regularedWord);
        assertEquals("Computer%20Architecture", regularedWord);
    }
}
