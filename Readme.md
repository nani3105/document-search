<h1 align="center">Document Search</h1>

## Table of Contents
- [Solution](#solution)
- [Technology Stack](#technology-stack)
- [Installation](#installation)
- [Analysis](#analysis)

## Solution
 - SimpleSearch
 ```text
    Upon search, we stream the files one by one and tokenize each line.
    And match each word with the query term. The idea behind streaming the files is to reduce the memory 
    fingerprint if the document size is large. If the document size is small, we could have loaded all the documents in memory and 
    would have searched it in memory. 
```

 - PatternSearch
 ```text
    Upon search, we stream the files one by one and tokenize each line.
    And match each word with the query term. The idea behind streaming the files is to reduce the memory 
    fingerprint if the document size is large. If the document size is small, we could have loaded all the documents in memory and 
    would have searched it in memory. Here Since we stream the files we loose some query matching ability on pattern matching.
    Here it would be to analyze the businees need and proceed with a solution compromising on consistency and availabilty.
```

 - IndexedSearch
 ```text
    Here, we would stream all the documents before the search.
    We generate an inverted index Map of the word and List or a map of postings (i.e) documentId or fileName
    We can even store the required metadata such as position in the document where the word matched,
    frequency of the word, rank etc.
    
    Upon search, we just look up the word in the map which is O(1) operation.
```

## Technology Stack
- Gradle
- Java

## Installation

```sh
$ ./gradlew build && java -jar build/libs/document-search-1.0-SNAPSHOT.jar
```


## Analysis

Indexed Search is faster as we generate an inverted indexed map. Here the looks are performed in O(1) operations.
But in real time, data processing in done in large volume. We need to scale the system.
Sharding can be an way to scale the system. Writing the data to disk for fault tolerance. 
Replication the index map between many node and datacenters.

Using Spark/Hadoop to make indexing the documents distributed.

Generally the basic workflow would be to 
stream the document
Tokenize the document based on different strategies.
Filter the document with stopwords etc.
And generate the relavent indexed map.