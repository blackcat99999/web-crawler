Here is a refreshed, accurate `README.md` updated to match all your current Java source files, project structure, and build configuration (`jsoup-1.22.2.jar`):

---

# WebCrawlerCoreJava

## Overview

A high-performance, multi-threaded web crawler built from scratch in Java. This tool uses a **Producer-Consumer** architecture to navigate through web pages starting from a seed URL, extracting links, and performing real-time keyword frequency analysis across crawled web pages.

---

## Features

* **Multi-threading:** Utilizes `ExecutorService` with a fixed thread pool of 10 threads for parallel processing.
* **Thread-Safe Architecture:** Implements `LinkedBlockingQueue` and `ConcurrentHashMap` to maintain state integrity across concurrent thread updates.
* **Keyword Mining:** Scans webpage text using custom tokenization to track and tabulate occurrences of specified target words.
* **BFS Navigation:** Employs Breadth-First Search (BFS) traversal to discover and visit new URLs while avoiding infinite loops using a thread-safe visited URL set.
* **Modular Design:** Decouples networking (`PageFetcher`), DOM extraction (`LinkExtractor`), thread coordination (`CrawlManager`), and text analytics (`WordAnalyzer`).

---

## Technologies Used

* **Java SE 8**
* **Jsoup (v1.22.2):** For fetching HTML content and extracting hyperlink DOM elements.
* **Java Concurrency API:** `ExecutorService`, `LinkedBlockingQueue`, and concurrent collection structures.

---

## How to Run

1. **Prerequisites:** Ensure you have Java 8 (or higher) and Eclipse IDE installed.
2. **Add Jsoup Dependency:** Download `jsoup-1.22.2.jar` and add it to your project's **Build Path**.
3. **Configure Seed & Keywords:** Open `src/crawler/Main.java` to set your desired seed URL (`manager.addUrl(...)`) and target keywords (`keywords`).
4. **Execute:** Run the `Main.java` class as a **Java Application**.

---

## Sample Output

```text
--- Final Multi-Threaded Results ---
News: 45
Sport: 12
Weather: 8
Climate: 3

```

---

## Project Structure Section

| Class | Responsibility |
| --- | --- |
| **`Main`** | Application entry point, thread pool orchestration, and final reporting. |
| **`CrawlManager`** | Manages the thread-safe URL queue and tracks unique visited URLs. |
| **`WebWorker`** | Core worker task executed by worker threads to process single pages. |
| **`WordAnalyzer`** | Text normalization, tokenization, and target keyword frequency counting. |
| **`PageFetcher`** | Network helper that handles HTML downloading via Jsoup. |
| **`LinkExtractor`** | DOM parser helper that extracts absolute hyper-references (`abs:href`) from HTML elements. |
