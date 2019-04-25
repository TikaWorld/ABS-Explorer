package com.toyproject.abs_explorer;

import static org.junit.Assert.*;
import org.junit.Test;

public class KyoboSearcherTest {
    @Test
    public void searchTest() {
        KyoboSearcher kyoboSearcher = new KyoboSearcher();
        System.out.println(kyoboSearcher.search("Computer Architecture"));
    }
}
