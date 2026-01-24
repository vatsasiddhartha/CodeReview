🚀 CodeReview – Android App (Jetpack Compose)

CodeReview is a modern Android application built using Jetpack Compose and Material 3, designed for developers to run, check, and track code progress in a clean, dark, coder-friendly UI.

The app follows a scalable navigation architecture with authentication flow and a bottom navigation–based main dashboard.

✨ Features

🔐 Authentication Flow

Splash Screen

Login Screen

Signup Screen

Secure navigation handling (login removed from back stack)

🧭 Bottom Navigation Architecture

Home (Code Run)

Code Check

Progress Tracking

Visible only after successful login

🎨 Modern Dark UI

Inspired by coder-focused apps

Consistent color palette across screens

Smooth Material 3 components

⚙️ Jetpack Compose First

Fully declarative UI

Clean and readable composables

Easy to scale and maintain

🛠 Tech Stack

Language: Kotlin

UI: Jetpack Compose

Design System: Material 3

Navigation: Navigation Compose

Architecture: Modular & scalable composables

State Handling: remember, mutableStateOf

📂 Project Structure
com.example.codereview
│
├── Navigation
│   ├── AppNavGraph.kt
│   ├── BottomNavGraph.kt
│   ├── BottomNavigationBar.kt
│   └── Screen.kt
│
├── ComposableScreens
│   ├── SplashScreen.kt
│   ├── LoginScreen.kt
│   ├── SignupScreen.kt
│   ├── MainScreen.kt
│   ├── CoderunScreen.kt
│   ├── CodecheckScreen.kt
│   └── CodeprogressScreen.kt
│
└── ui.theme

🧭 Navigation Flow
SplashScreen
      ↓
LoginScreen ───→ SignupScreen
      ↓
MainScreen
      ↓
Bottom Navigation Screens
(Home | Check | Progress)


Bottom navigation is hidden on Splash, Login, and Signup screens.

After login, users are redirected to MainScreen.

🎨 UI Theme

Dark background inspired by coding environments

Neon blue highlights for actions

Rounded input fields and buttons

Minimal distractions, maximum focus

▶️ How to Run

Clone the repository

git clone https://github.com/your-username/codereview.git


Open in Android Studio

Sync Gradle

Run on emulator or physical device

🧩 Future Enhancements

🔐 Firebase Authentication

🧠 AI-based code review

📊 Progress analytics

☁️ Cloud sync

🌈 Animated UI transitions

👨‍💻 Author

Siddharth Vatsa
Android Developer | Kotlin | Jetpack Compose

Building developer-focused tools with clean UI and solid architecture.
