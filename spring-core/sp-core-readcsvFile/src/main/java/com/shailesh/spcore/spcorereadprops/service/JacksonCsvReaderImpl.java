package com.shailesh.spcore.spcorereadprops.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class JacksonCsvReaderImpl implements JacksonCsvReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonCsvReaderImpl.class);

    @Autowired
    CsvMapper csvMapper;

    @Override
    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        // An Empty Schema with headers.
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        try {
            File file = new ClassPathResource("user.csv").getFile();
            final MappingIterator<T> iterator = csvMapper.reader(type).with(csvSchema).readValues(file);
            return iterator.readAll();
        } catch (IOException e) {
            LOGGER.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<String[]> loadManyToManyRelationship(String fileName) {
        CsvSchema csvSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
        csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        try {
            final File file = new ClassPathResource("user.csv").getFile();
            final MappingIterator<String[]> iterator = csvMapper.reader(String[].class).with(csvSchema).readValues(file);
            return iterator.readAll();
        } catch (IOException e) {
            LOGGER.error(
                    "Error occurred while loading many to many relationship from file = " + fileName, e);
            return Collections.emptyList();
        }
    }
}
