# Java In-Memory Queryable Table
A Multi level query-able java in-memory table

---

Often times, we developers need a handy table-like data structure in memory that allows fast lookup by multiple attributes, e.g., querying rows based on specific column values. The `Java In-Memory Queryable Table` library provides a simple and efficient solution for managing in-memory tabular data with support for indexing and querying.

## Example Scenario

Imagine you have a dataset of historical figures like kings and queens, each with attributes such as name, age, and gender. Using the `Java In-Memory SQL Table`, you can easily create and manage this data structure:

```
// Create a table with specified columns
Set<ColumnDef> columns = Set.of(
    ColumnDef.builder().name("name").indexed(true).build(),
    ColumnDef.builder().name("field").indexed(true).build(),
    ColumnDef.builder().name("nationality").indexed(true).build(),
    ColumnDef.builder().name("awards").indexed(false).build()
);

Table scientistsTable = new Table(columns);

// Add rows 

// Query the table based on specific conditions
scientistsTable
    .query("field", field -> ((String) field).toLowerCase().equals("string theory"))
    .query("nationality", nationality -> ((String) nationality).equals("Indian"))
    .allRows()
    .forEach(r -> log.info(r.name()));

```

This example shows the creation of a table, addition of rows, and querying based on age conditions. The Java In-Memory SQL Table simplifies the process of managing and querying tabular data in your Java applications.

See unit test for a demonstration of all features using synthetic data.

## Features
* In-Memory Storage: Keep your data in memory for fast access and manipulation.
* Indexing: Index specific columns to accelerate query performance.
* Dynamic Schema: Define and work with dynamic schemas based on your data.

## License
This project is licensed under the MIT License. Feel free to use, modify, and distribute it as needed.