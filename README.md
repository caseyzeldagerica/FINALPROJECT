# 🚀 Final Project QA Automation

Halo! Ini adalah repositori untuk Final Project QA Automation yang menggabungkan pengujian Web UI dan API dalam satu wadah (Repository) menggunakan pendekatan BDD (*Behavior Driven Development*).

## 🛠️ Tools & Library yang Digunakan
* **Java 21**: Bahasa pemrograman utama.
* **Gradle**: Sebagai *build automation tool*.
* **Cucumber (Gherkin)**: Untuk menulis skenario tes dengan format bahasa manusia.
* **Selenium WebDriver**: Untuk pengujian Web UI (diimplementasikan dengan struktur *Page Object Model*).
* **Rest Assured**: Untuk pengujian API (memvalidasi *status code* dan *response body*).
* **GitHub Actions**: Untuk CI/CD (*otomatis jalan saat ada Pull Request atau di-trigger manual*).

## 📂 Struktur Project
* `src/test/java/pages`: Berisi *Page Object Model* (POM) untuk web Demoblaze.
* `src/test/java/steps`: Berisi kode Java (*Step Definitions*) pembantu Cucumber.
* `src/test/java/runner`: Berisi Test Runner utama.
* `src/test/resources/features`: Berisi skenario tes `.feature` untuk API dan Web.

## 🚀 Cara Menjalankan Tes
Buka terminal (atau *command prompt*) dan jalankan perintah Gradle Task berikut:

1. **Mengeksekusi semua tes Web UI (Tag `@web`):**
   ```bash
   ./gradlew runWeb