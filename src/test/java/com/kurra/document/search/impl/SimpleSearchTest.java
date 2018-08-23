package com.kurra.document.search.impl;

import com.kurra.document.search.Search;

/**
 * User: Niranjan.kurra - Date: 8/22/18 6:06 PM
 */
public class SimpleSearchTest extends AbstractTest {
    Search search = new SimpleSearch();

    @Override
    Search getSearch() {
        return this.search;
    }
}
