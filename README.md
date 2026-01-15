# Flight Status Tracker

An Android application built with Jetpack Compose to track flight status in real-time using the [Aviationstack API](https://aviationstack.com/).

## 📱 Features

*   **Real-time Flight Tracking**: View live status of flights (Active, Scheduled, Landed, Cancelled).
*   **Search Functionality**: Search by Flight Number (e.g., "AA100"), Airline Name, or IATA code.
*   **Detailed Flight Information**:
    *    Departure & Arrival times (Scheduled, Estimated, Actual).
    *   Terminal and Gate information.
    *   Delay tracking.
    *   Aircraft and Airline details.
*   **Offline Support**: Caches flight data locally using Room database, allowing you to view previously fetched flights without an internet connection.
*   **Modern UI**: Built entirely with Jetpack Compose using Material 3 design principles.

## 🛠 Tech Stack

*   **Language**: Kotlin
*   **UI Framework**: Jetpack Compose (Material 3)
*   **Architecture**: MVVM (Model-View-ViewModel)
*   **Dependency Injection**: Hilt
*   **Networking**: Retrofit + OkHttp
*   **Local Storage**: Room Database
*   **Async Processing**: Kotlin Coroutines & Flow

## 🚀 Getting Started

### Prerequisites

1.  **Android Studio**: Iguana (2023.2.1) or newer recommended.
2.  **JDK**: Java Development Kit 17.
3.  **Aviationstack API Key**: You need a free API key from [aviationstack.com](https://aviationstack.com/).

### Setup Instructions

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/flight-status-tracker.git
    ```

2.  **Open in Android Studio**:
    *   Open Android Studio and select "Open an existing Android Studio project".
    *   Navigate to the cloned directory.

3.  **Configure API Key**:
    *   **Option A (Recommended)**: Create a `local.properties` file in the root directory and add:
        ```properties
        aviationstack.api.key=YOUR_REAL_API_KEY_HERE
        ```
        *Then update `app/build.gradle.kts` to read this property instead of the hardcoded string.*
        
    *   **Option B (Quick Start)**: Open `app/build.gradle.kts` and replace the placeholder directly:
        ```kotlin
        // Replace "API-KEY" with your actual key
        buildConfigField("String", "AVIATIONSTACK_API_KEY", "\"YOUR_ACTUAL_KEY_37c...\"")
        ```
    
    *   **Important**: If you manually edited files to include "API-KEY", make sure to revert those changes or update them to use `BuildConfig.AVIATIONSTACK_API_KEY`.

4.  **Sync Project**:
    *   Click "Sync Now" in the notification bar or `File > Sync Project with Gradle Files`.

5.  **Run the App**:
    *   Connect an Android device or start an Emulator.
    *   Click the **Run** button (green arrow) in the toolbar.

## 📖 How it Works

### Architecture
The app follows the **Clean Architecture** principles with specific layers:

*   **Data Layer**:
    *   `FlightRepositoryImpl`: Single source of truth. It manages data fetching from the API and caching it into the local database.
    *   `FlightApiService`: Retrofit interface for network calls.
    *   `FlightDao`: Room DAO for database operations.
*   **Domain Layer**:
    *   `Flight`: Pure Kotlin data class represented in the UI.
    *   `FlightRepository`: Interface defining available operations.
*   **Presentation Layer**:
    *   `FlightViewModel`: Manages UI state (`FlightState`) and handles events (`FlightEvent`).
    *   `HomeScreen`: Displays the list of flights and search bar.
    *   `DetailsScreen`: Shows comprehensive details for a selected flight.

### Data Flow
1.  **Search/Load**: When you search for a flight, the app first checks the local database for immediate results.
2.  **Network Fetch**: Concurrently, it fetches fresh data from the Aviationstack API.
3.  **Cache Update**: The new data is saved to the database.
4.  **UI Update**: The UI observes the database (via Flow), so it automatically updates when the new data is saved.

## 👨‍💻 Creators

*   **Florian Velea**
*   **Victorita-Marinela Cotoi**