package com.example.test.config;

import ma.glasnost.orika.metadata.ClassMapBuilder;

public interface ObjectMapping<A, B> {

    void classMap(ClassMapBuilder<A, B> classMapBuilder);
}
