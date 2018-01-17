package sample;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ModulationTest {
    @Test
    public void byte2short() throws Exception {
        byte arrayA[] = {24, 111, -59, 120, 0, 36, -128, 127};
        short arrayB[][] = {{28440, 9216}, {30917, 32640}};
        assertArrayEquals(arrayB, Modulation.byte2short(arrayA, 8));
    }

    @Test
    public void short2byte() throws Exception {
        byte arrayA[] = {24, 111, -59, 120, 0, 36, -128, 127};
        short arrayB[][] = {{28440, 9216}, {30917, 32640}};
        assertArrayEquals(arrayA, Modulation.short2byte(arrayB));
    }

}