## WebCrawlerCoreJava

### Overview

A high-performance, multi-threaded web crawler built from scratch in Java. This tool uses a **Producer-Consumer** architecture to navigate through web pages starting from a seed URL, extracting links, and performing real-time keyword frequency analysis.

### Features

* **Multi-threading**: Utilizes `ExecutorService` and a fixed thread pool of 10 threads for parallel processing.
* **Thread-Safe Architecture**: Implements `LinkedBlockingQueue` and `ConcurrentHashMap` to ensure data integrity during concurrent updates.
* **Keyword Mining**: Scans webpage text using custom tokenization to track the occurrence of specific target words.
* **BFS Navigation**: Uses Breadth-First Search logic to discover and visit new links while avoiding infinite loops via a visited URL set.

### Technologies Used

* **Java SE 8**
* **Jsoup**: For HTML fetching and parsing.
* **Java Concurrency API**: `ExecutorService`, `Future`, and Concurrent Collections.

### How to Run

1. **Prerequisites**: Ensure you have Java 8 (or higher) and Eclipse IDE installed.
2. **Add Jsoup**: Download the `jsoup-1.17.2.jar` and add it to your project's **Build Path**.
3. **Configure Seed**: Open `Main.java` and set your `seedUrl` and `targetKeywords`.
4. **Execute**: Run the `Main` class as a Java Application.

### Sample Output

```text
------------Key Word Freq---------------------------
Sports  = 69
Weather = 4
News    = 7
---------------------------------------------------
Total Pages visited: 100

```

---

### Project Structure Section

| Class | Responsibility |
| --- | --- |
| **Main** | Orchestration and reporting. |
| **CrawlManager** | Thread-safe URL queue management. |
| **WebWorker** | The core logic for individual page processing. |
| **WordAnalyzer** | Text processing and keyword counting. |
