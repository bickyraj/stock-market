package com.bickyraj.demo.clothes.jacket;

import lombok.ToString;

@ToString
abstract class LeatherJacketDecorator extends LeatherJacket {
    LeatherJacket leatherJacketDecorator;
    public LeatherJacketDecorator(LeatherJacket leatherJacket) {
        this.leatherJacketDecorator = leatherJacket;
    }
}
