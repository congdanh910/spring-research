package com.example.couchbase.utils.couchbase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

public class CouchbaseCriteriaBuilder {

    private StringBuilder builder;

    public CouchbaseCriteriaBuilder () {
        builder = new StringBuilder();
    }

    public CouchbaseCriteriaBuilder compare (String key, Object value, ComparisonType type) {
        Assert.notNull(key, "key parameter can't be  null");
        Assert.notNull(value, "value parameter can't be  null");
        Assert.notNull(type, "type parameter can't be  null");

        this.builder.append(key).append(type.getOperation());
        if ( value instanceof String ) {
            this.builder.append(CouchbaseCriteriaBuilder.standardizeStringValue(value));
        }
        else {
            this.builder.append(value.toString());
        }

        return this;
    }

    //    public CouchbaseCriteriaBuilder in (String key, List<?> values) {
    //        Assert.notNull(key, "key parameter can't be  null");
    //        Assert.notNull(values, "values parameter can't be  null");
    //
    //        this.builder.append(key).append(" IN [");
    //        this.builder.append(
    //            values.stream()
    //                  .map(value -> standardizeStringValue(value))
    //                  .collect(Collectors.joining(","))
    //        );
    //        this.builder.append("]");
    //
    //        return this;
    //    }

    public CouchbaseCriteriaBuilder in (String key, List<Object> values) {
        Assert.notNull(key, "key parameter can't be  null");
        Assert.notNull(values, "values parameter can't be  null");

        this.builder.append(key).append(" IN [");
        this.builder.append(
            values.stream()
                  .map(value -> {
                      if ( value instanceof String ) {
                          return standardizeStringValue(value);
                      }
                      else {
                          return ((Object) value).toString();
                      }
                  })
                  .collect(Collectors.joining(","))
        );
        this.builder.append("]");

        return this;
    }

    private static String standardizeStringValue (Object value) {
        return new StringBuffer("'").append(value).append("'").toString();
    }

}
