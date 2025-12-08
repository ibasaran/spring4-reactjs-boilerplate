
# Modular Monolith Example

This is a runnable minimal modular monolith skeleton.

## Run locally (using docker-compose)

```bash
docker compose up --build
```

- Backend API: http://localhost:8080
- Web UI (Vite dev): http://localhost:3000

## Notes
- Liquibase changelog is in `persistence/src/main/resources/db/changelog/db.changelog-master.xml` and will run on startup via spring.liquibase in api-web.
- BaseEntity uses UUID id and automatic createdAt/updatedAt.
- Generic BaseController and GlobalExceptionHandler included.
- This is a minimal example for demo; security (JWT) is a placeholder and not production hardened.
