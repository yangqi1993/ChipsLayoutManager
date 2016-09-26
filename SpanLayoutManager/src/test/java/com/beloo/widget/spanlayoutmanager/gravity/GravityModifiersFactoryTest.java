package com.beloo.widget.spanlayoutmanager.gravity;

import android.view.Gravity;

import org.junit.Test;
import static org.junit.Assert.*;

public class GravityModifiersFactoryTest {

    private GravityModifiersFactory factory = new GravityModifiersFactory();

    @Test
    public void factoryShouldReturnCenterModifierForCenterGravity() {
        IGravityModifier gravityModifier = factory.getGravityModifier(Gravity.CENTER);
        assertTrue(gravityModifier instanceof CenterGravityModifier);
    }

    @Test
    public void factoryShouldReturnCenterModifierForCenterVerticalGravity() {
        IGravityModifier gravityModifier = factory.getGravityModifier(Gravity.CENTER_VERTICAL);
        assertTrue(gravityModifier instanceof CenterGravityModifier);
    }

    @Test
    public void factoryShouldReturnTopModifierForTopGravity() {
        IGravityModifier gravityModifier = factory.getGravityModifier(Gravity.TOP);
        assertTrue(gravityModifier instanceof TopGravityModifier);
    }

    @Test
    public void factoryShouldReturnBottomModifierForBottomGravity() {
        IGravityModifier gravityModifier = factory.getGravityModifier(Gravity.BOTTOM);
        assertTrue(gravityModifier instanceof BottomGravityModifier);
    }

    @Test
    public void factoryShouldReturnCenterModifierForUnknownGravity() {
        IGravityModifier gravityModifier = factory.getGravityModifier(Gravity.CENTER_HORIZONTAL);
        assertTrue(gravityModifier instanceof CenterGravityModifier);
    }

}