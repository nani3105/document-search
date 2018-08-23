package com.kurra.document.search

import groovy.transform.ToString

/**
 * User: Niranjan.kurra - Date: 8/21/18 7:24 PM
 */
@ToString
class Relevancy {
    String fileName
    int count

    def incrementCount() {
        count++
    }
}
