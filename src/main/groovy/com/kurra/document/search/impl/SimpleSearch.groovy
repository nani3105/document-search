package com.kurra.document.search.impl

import com.kurra.document.search.Search
import groovy.util.logging.Slf4j

/**
 * User: Niranjan.kurra - Date: 8/21/18 10:16 PM
 */
@Slf4j
class SimpleSearch extends AbstractSearch {
    @Override
    Map<String, Integer> search(String query) {
        URL url = getClass().getClassLoader().getResource('documents')
        File folder = new File(url.toURI())
        File[] documents = folder.listFiles()
        if (log.isDebugEnabled()) {
            log.debug("Number of files found ${documents.size()}")
        }
        Map<String, Integer> documentMatches = new HashMap<>()
        for (File document : documents) {
            if (log.isDebugEnabled()) {
                log.debug("Streaming document ${document.name}")
            }
            document.eachLine { line ->
                String[] words = tokenizeLine(line)
                for (String word : words) {
                    if (query.equals(word)) {
                        documentMatches.containsKey(document.name) ?
                                documentMatches.put(document.name, ++documentMatches.get(document.name)) : documentMatches.put(document.name, 1)
                    }
                }
            }
        }
        documentMatches
    }
}
