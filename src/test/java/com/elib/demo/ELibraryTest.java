package com.elib.demo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ELibraryTest {
    private GoldenMaster goldenMaster;

    @Before
    public void setUp() {
        goldenMaster = new GoldenMaster();
    }

    @Ignore
    @Test
    public void should_generate_golden_master() throws IOException {
        goldenMaster.generateGoldenMaster();
    }

    @Test
    public void should_match_golden_master() throws IOException {
        String expected = goldenMaster.readGoldenMaster().trim().replaceAll("\r", "").replaceAll("\n", "");
        String actual = goldenMaster.runResult().trim().replaceAll("\r\n", "").replaceAll("\n", "");

        assertEquals(expected, actual);
    }
}
