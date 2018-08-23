package com.kurra.document.search.impl;

import com.kurra.document.search.Search;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * User: Niranjan.kurra - Date: 8/22/18 5:37 PM
 */
public class IndexedSearchTest extends AbstractTest {

    Search search = new IndexedSearch();

    @Override
    Search getSearch() {
        return this.search;
    }
}