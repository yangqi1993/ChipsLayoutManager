package com.beloo.widget.spanlayoutmanager.gravity;

import android.graphics.Rect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TopGravityModifierTest {

    private TopGravityModifier topGravityModifier = new TopGravityModifier();

    public static Object[] data() {
        return new Object[][] {
                {0, 100, new Rect(0, 20, 0, 100), new Rect(0, 20, 0, 80)},
                {0, 100, new Rect(0, 20, 0, 80), new Rect(0, 0, 0, 60)},
                {0, 100, new Rect(0, 0, 0, 40), new Rect(0, 0, 0, 40)},
                {0, 100, new Rect(0, 10, 0, 20), new Rect(0, 0, 0, 10)},
                {0, 100, new Rect(0, 0, 0, 100), new Rect(0, 0, 0, 100)}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(source = GravityDataProvider.class, method = "invalidData")
    public void invalidDataForTopModifierShouldThrowIllegalArgumentException(int minTop, int maxBottom, Rect childRect) {
        topGravityModifier.modifyChildRect(minTop, maxBottom, childRect);
    }

    @Test
    @Parameters(method = "data")
    public void modifierShouldAlignInputRectToTop(int minTop, int maxBottom, Rect childRect, Rect testRect) {
        Rect resultRect = topGravityModifier.modifyChildRect(minTop, maxBottom, childRect);
        assertTrue(Mockito.verify(testRect).equals(resultRect));
    }
}