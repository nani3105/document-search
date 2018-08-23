package com.kurra.document.search.impl

import com.kurra.document.search.Search

/**
 * User: Niranjan.kurra - Date: 8/21/18 10:33 PM
 */
abstract class AbstractSearch implements Search {

    protected String[] tokenizeLine(String line) {
        line.split(" ")
    }
}
