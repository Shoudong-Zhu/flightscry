# Flightscry

Flightscry is a proof of concept (PoC) for a mobile application that allows users to view their flight itineraries conveniently on their phones. This application uses Backpack, Skyscanner’s custom UI library, to create a user interface.

## Features

- Displays flight number
- Shows departure and arrival airport codes and times

## Installation


1. **Open the project in Android Studio:**
   Open Android Studio and select `Open an existing project`. Navigate to the cloned directory and select it.

2**Sync Gradle:**
   Once the project is opened, let Gradle sync. If not prompted, click `File > Sync Project with Gradle Files`.

3**Run the app:**
   Click the `Run` button (green arrow) in the upper right corner. Select a virtual device or a physical device to run the app.

## Usage

- Launch the application to view a sample flight itinerary with flight number, departure, and arrival details.

## Dependencies

- Backpack Android library
    ```gradle
    implementation 'net.skyscanner.backpack:backpack-android:43.0.0'
    ```

