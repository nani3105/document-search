package com.kurra.document.search.impl

import com.kurra.document.search.Relevancy
import com.kurra.document.search.Search

/**
 * User: Niranjan.kurra - Date: 8/21/18 10:24 PM
 */
class IndexedSearch extends AbstractSearch {

    Map<String, Map<Integer, Relevancy>> invertedIndexMap = [:]

    IndexedSearch() {
        URL url = getClass().getClassLoader().getResource('documents')
        File folder = new File(url.toURI())
        File[] documents = folder.listFiles()
        for (File document : documents) {
            document.eachLine { line ->
                String[] words = tokenizeLine(line)
                for (String word : words) {
                    Integer hash = document.name.hashCode()
                    if (invertedIndexMap.containsKey(word)) {
                        def fileMap = invertedIndexMap.get(word)
                        def relavency = fileMap.get(hash)
                        if (relavency) {
                            relavency.incrementCount()
                        } else {
                            fileMap.put(hash, new Relevancy(fileName: document.name, count: 1))
                        }
                    } else {
                        invertedIndexMap.put(word, new HashMap<Integer, Relevancy>(){{
                            put(hash, new Relevancy(fileName: document.name, count: 1))
                        }})
                    }
                }
            }
        }
    }

    @Override
    Map<String, Integer> search(String query) {
        Map<String, Integer> documentMatches = new HashMap<>()
        def frequencyMap = invertedIndexMap.get(query)
        frequencyMap?.each { key, value ->
            documentMatches.put(value.fileName, value.count)
        }
        documentMatches
    }
}
