# Modüler Spring React Örneği

Bu proje, çalıştırılabilir minimal bir modüler Spring mimarisi iskeletidir.

## Lokal Çalıştırma (docker-compose kullanarak)

```bash
docker compose up --build

Backend API: http://localhost:8080

Web UI (Vite dev): http://localhost:3000

Notlar

Liquibase changelog dosyası persistence/src/main/resources/db/changelog/db.changelog-master.xml konumundadır ve api-web içerisindeki spring.liquibase ayarları sayesinde uygulama başlatılırken otomatik olarak çalışır.

BaseEntity, UUID tabanlı id yapısını ve otomatik createdAt / updatedAt alanlarını içerir.

Generic BaseController ve GlobalExceptionHandler projeye dahildir.
