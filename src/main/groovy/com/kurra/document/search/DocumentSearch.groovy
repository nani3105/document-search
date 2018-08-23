package com.kurra.document.search

import com.kurra.document.search.impl.IndexedSearch
import com.kurra.document.search.impl.PatternSearch
import com.kurra.document.search.impl.SimpleSearch

import java.util.regex.Pattern

import static com.kurra.document.search.SearchType.INDEXED_SEARCH
import static com.kurra.document.search.SearchType.PATTERN_SEARCH
import static com.kurra.document.search.SearchType.SIMPLE_SEARCH

/**
 * User: Niranjan.kurra - Date: 8/21/18 5:25 PM
 */
class DocumentSearch {

    Search simpleSearch = new SimpleSearch()
    Search patternSearch = new PatternSearch()
    Search indexedSearch = new IndexedSearch()

    static void main(String[] args) {
        def documentSearch = new DocumentSearch()
        documentSearch.bootstrap()
    }

    void bootstrap() {
        Scanner sc = new Scanner(System.in)
        println 'Enter the search term: '
        String query = sc.next()
        println 'Enter Search Method: 1) String Match 2) Regular Expression 3) Indexed'
        SearchType searchType = SearchType.values()[sc.nextInt() - 1]
        Map<String, Integer> countMap = [:]
        def start = System.currentTimeMillis()
        switch (searchType) {
            case SIMPLE_SEARCH:
                countMap = simpleSearch.search(query)
                break
            case PATTERN_SEARCH:
                countMap = patternSearch.search(query)
                break
            case INDEXED_SEARCH:
                countMap = indexedSearch.search(query)
                break
            default:
                println 'Error'
        }

        def now = System.currentTimeMillis()
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            println "${entry.key} -- ${entry.value} matches"
        }

        println "Elasped Time : ${now - start} ms"
    }

}
