# Spring Data JPA Learnings

* Use `@Immutable` when the underlying table won't change. Any update will be ignored. But add/delete is possible. The class can have all argument constructor but no need of a setter
