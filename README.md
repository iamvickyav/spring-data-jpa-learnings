# Spring Data JPA Learnings

* Use `@Immutable` when the underlying table won't change. Any update will be ignored. But add/delete is possible. The class can have all argument constructor but no need of a setter

> An immutable attribute is ignored by the dirty-checking process, and so the persistence context does not need to keep track of its state. This may help reduce memory allocation

* When you don't want to expose all methods of Repository by extending JPARepository

```
@RepositoryDefinition(domainClass = Address.class, idClass = Integer.class)
public interface AddressRepository {
  List<Address> findAllByCity(String city);
  List<Address> findByZipCode(String zipCode);
}
```

* Delete In Bulk

```java
// Created Query - Hibernate: delete from department where id=? Hibernate: delete from department where id=?
// stats - 498620 nanoseconds spent preparing 4 JDBC statements; 4169679 nanoseconds spent executing 4 JDBC statements;
List<Department> all = departmentRepository.findAll();
departmentRepository.deleteAll(all);
```

```java
// Created the query - delete from department d1_0 where d1_0.id=? or d1_0.id=?
// Read -  325820 nanoseconds spent preparing 1 JDBC statements and 272963 nanoseconds spent executing 1 JDBC statements;
// stats - 751162 nanoseconds spent preparing 1 JDBC statements; 673530 nanoseconds spent executing 1 JDBC statements;
List<Department> all = departmentRepository.findAll();
departmentRepository.deleteAllInBatch(all);
```

```
// Created the query - delete from department d1_0 where d1_0.id in (?,?)
// Read -  356527 nanoseconds spent preparing 1 JDBC statements and 321557 nanoseconds spent executing 1 JDBC statements;
// Write - 660139 nanoseconds spent preparing 1 JDBC statements and 710499 nanoseconds spent executing 1 JDBC statements;
List<Department> all = departmentRepository.findAll();
departmentRepository.deleteAllByIdInBatch(all.stream().map(Department::getId).collect(Collectors.toList()));
```

```
@Modifying
@Query("delete from User u where u.role.id = ?1")
void deleteInBulkByRoleId(long roleId);
```

