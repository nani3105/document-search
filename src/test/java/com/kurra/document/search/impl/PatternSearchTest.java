package com.kurra.document.search.impl;

import com.kurra.document.search.Search;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * User: Niranjan.kurra - Date: 8/22/18 5:00 PM
 */
public class PatternSearchTest extends AbstractTest {

    Search search = new PatternSearch();

    @Test
    public void testPatternSearchWithRegex() {
        Map<String, Integer> result = search.search("(\\[.*\\])");
        assertThat(result, notNullValue());
        assertThat(result.size(), is(1));
        assertThat(result.get("hitchhikers.txt"), is(2));
    }

    @Override
    Search getSearch() {
        return this.search;
    }
}