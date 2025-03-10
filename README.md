# TMDB CLI - Java Movie Fetcher

## Overview

TMDB CLI is a command-line tool that fetches and displays movie information from **The Movie Database (TMDB) API**. Users can query popular, top-rated, upcoming, and now-playing movies directly from the terminal.

## Features

- Fetch and display movies from TMDB API.
- Supports different movie categories: `popular`, `top`, `upcoming`, `playing`.
- CLI interface for easy interaction.
- Error handling for API failures and invalid inputs.

## Prerequisites

- Install **Java 17+**
- Install **Apache Maven**
- Obtain a **TMDB API key** from [TMDB](https://www.themoviedb.org/settings/api)

## Setup Instructions

### 1. Clone the Repository

```sh
 git clone https://github.com/your-repo/tmdb-cli.git
 cd tmdb-cli
```

### 2. Set Up the TMDB API Key

- Create a `.env` file in the root directory:

```sh
echo "TMDB_API_KEY=your_api_key_here" > .env
```

- Alternatively, export the API key as an environment variable:
  - Windows (PowerShell):
    ```sh
    $env:TMDB_API_KEY="your_api_key_here"
    ```
  - Linux/macOS:
    ```sh
    export TMDB_API_KEY="your_api_key_here"
    ```

### 3. Build the Project (Creating JAR File)

Ensure you have **Maven** installed and run:

```sh
mvn clean package
```

This will generate the JAR file in the `target/` directory.

### 4. Run the CLI Tool

To execute the JAR file, use:

```sh
java -jar target/tmdb_cli-1.0-SNAPSHOT.jar --type popular
```

#### Available Commands

```sh
java -jar target/tmdb_cli-1.0-SNAPSHOT.jar --type popular   # Fetch popular movies
java -jar target/tmdb_cli-1.0-SNAPSHOT.jar --type top       # Fetch top-rated movies
java -jar target/tmdb_cli-1.0-SNAPSHOT.jar --type upcoming  # Fetch upcoming movies
java -jar target/tmdb_cli-1.0-SNAPSHOT.jar --type playing   # Fetch now-playing movies
```

### 5. Debugging Common Issues

- **Error: Unable to access jarfile** → Ensure the JAR file exists in the `target/` directory.
- **Error parsing JSON** → Verify your API key is correct and TMDB API is reachable.
- **Environment Variable Not Found** → Ensure `TMDB_API_KEY` is correctly set.

## Project Structure

```
tmdb-cli/
├── src/
│   ├── main/
│   │   ├── java/com/tmdb/cli/
│   │   │   ├
│   │   │   ├── MovieService.java  # Handles API requests
│   │   │   ├── CLIHandler.java    # Parses CLI arguments
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuration
├── target/
│   ├── tmdb_cli-1.0-SNAPSHOT.jar
├── pom.xml  # Maven dependencies
├── README.md
```

## Dependencies

This project uses:

- **Maven** for build automation.
- **Jackson** for JSON parsing.
- **HttpClient** for making API requests.

  
roadmap.sh backend practice project
https://roadmap.sh/projects/tmdb-cli

## Contributors

- **JothiPrakash** - Developer

Happy coding! 🚀

