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

```
@Modifying
@Query("delete from User u where u.role.id = ?1")
void deleteInBulkByRoleId(long roleId);
```

