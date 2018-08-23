package com.kurra.document.search.impl;

import com.kurra.document.search.Search;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * User: Niranjan.kurra - Date: 8/22/18 5:37 PM
 */
abstract class AbstractTest {

    @Test
    public void testThePatternSearch() {
        Map<String, Integer> result = getSearch().search("the");
        assertThat(result, notNullValue());
        assertThat(result.size(), is(3));
        assertThat(result.get("hitchhikers.txt"), is(21));
        assertThat(result.get("french_armed_forces.txt"), is(57));
        assertThat(result.get("warp_drive.txt"), is(6));
    }

    abstract Search getSearch();
}
