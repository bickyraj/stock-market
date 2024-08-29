package com.bickyraj.demo.interfaces;

public class BubbleLight extends TreeDecorator {
    public BubbleLight(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}
