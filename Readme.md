# Java Bean Mapping Benchmark

This is a simple benchmark that uses JMH to test various Java bean mappers. The benchmarks are focused on the thoughput (operations per second).

The tested mappers are the following:

 * bean-cp
 * BeanUtils
 * BULL
 * Datus
 * Dozer
 * JMapper
 * MapStuct
 * ModelMapper
 * MooMapper
 * Nomin
 * Orika
 * ReMap
 * Selma

See this article for more info: https://masterex.github.io/archive/2021/02/08/java-bean-mapping-in-depth.html

## How to run

```bash
mvn clean install
java -jar target/benchmarks.jar
```

## Mappers configuration

The mappers have been configured with the least possible configuration using the name conventions of the mapped fields where this is supported.

## Tests

There are Unit tests that try to ensure that the produced outcome is equivalent.

However, in some cases the produced outcome is not produced in an equivalent way.

Let's say we have the following classes:

#### Source

```java
public class Source {
    private List<String> field;
    // getters/setters
}
```

```java
public class Target {
    private List<String> field;
    // getters/setters
}
```

Some mappers will copy the `List` by reference to the target object (shallow copy) while others will create a new `List`.
In both cases the results will be equivalent (if we compare every entry in source and target list with `equals` they all will return true) but are not produced in an equivalent way (shallow copy is a cheaper operation than creating a new `List`).

There are tests which group these cases together.
