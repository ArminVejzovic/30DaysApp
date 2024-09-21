# 30DaysApp,
30 Days Of Adventures App

30 Days of Adventures is a fun and engaging Android app designed to provide users with daily tips and challenges to inspire adventure and exploration over the course of a month. This app was built using Jetpack Compose, embracing Material Design principles for a sleek, modern 
interface.

💻 Technologies Used

    Language: Kotlin
    UI Framework: Jetpack Compose
    Design: Material Design
    Development Environment: Android Studio

📱 App Overview

30 Days of Adventures encourages users to step out of their comfort zone and experience something new every day. Whether it's trying a new activity, exploring a new place, or simply thinking differently, each day brings a new adventure!
Key Features:

    Daily Adventure Tips: A new tip or challenge every day with text and an image.
    Interactive Cards: Click a card to expand and reveal the adventure's full description. Clicking again will collapse the description.
    Scrollable UI: Users can browse through tips in a smooth scrolling interface.
    Material Design: The app follows Material Design principles for consistency and visual appeal.

🔧 Project Structure

The app was built using Jetpack Compose for a responsive and efficient user interface. Here’s an overview of the core components:

    Data Model: Each adventure tip is stored in a simple data model containing fields like:
        Day Number
        Title
        Image (Resource ID)
        Description

    UI:
        The tips are displayed using a LazyColumn for smooth scrolling through all 30 days.
        Cards were created using Card() composable, styled with padding, margins, and typography.

    Material Theming: The app uses Material Design Guidelines to ensure consistent padding, typography, and color use throughout the app.

🚀 How to Run the Project

Clone the repository:

bash

      git clone https://github.com/your-username/30DaysApp.git

Open the project in Android Studio.

Sync Gradle files to install dependencies.

Run the app on an emulator or connected device:

    Select a device from AVD Manager or plug in your Android device.
    Click Run (Shift + F10) to start the app.

Enjoy exploring your 30 Days of Adventures!

