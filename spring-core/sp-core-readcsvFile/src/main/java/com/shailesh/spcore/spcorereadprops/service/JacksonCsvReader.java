package com.shailesh.spcore.spcorereadprops.service;

import java.util.List;

public interface JacksonCsvReader {
    <T> List<T> loadObjectList(Class<T> type, String fileName);
    List<String[]> loadManyToManyRelationship(String fileName);
}
