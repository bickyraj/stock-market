package com.bickyraj.demo.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChristmasTreeTest {

    @Test
    public void whenDecoratorsInjectedAtRuntime_thenConfigSuccess() {
        ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
        assertEquals(tree1.decorate(), "Christmas Tree with Garland");
        ChristmasTree tree2 = new BubbleLight(new Garland(new Garland(new ChristmasTreeImpl())));
        assertEquals(tree2.decorate(),
                "Christmas Tree with Garland with Garland with Bubble Lights");
    }
}
