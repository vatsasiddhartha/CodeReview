# ⚡ CodeReview — A Jetpack Compose Experience

> **Not just an app. A composable system.**  
> Built for developers. Animated for flow. Architected for scale.

---

## 🎬 App in Motion

CodeReview is a **motion-first Android application** built entirely with **Jetpack Compose**.

✨ Animated splash intro  
✨ Smooth authentication flow  
✨ Stateful bottom navigation  
✨ Clean transitions without XML or Fragments  

Everything is **Compose-driven**, modern, and scalable.

---

## 🧠 Architecture Overview

```text
SplashScreen
     ↓
Login / Signup
     ↓
MainScreen
     ↓
Bottom Navigation
 ┌──────────┬──────────┬──────────┐
 │ CodeRun  │ CodeCheck│ Progress │
 └──────────┴──────────┴──────────┘
📦 com.example.codereview
│
├── 🔀 Navigation
│   ├── AppNavGraph.kt
│   ├── BottomNavGraph.kt
│   ├── BottomNavigationBar.kt
│   └── Screen.kt
│
├── 🎨 ComposableScreens
│   ├── SplashScreen.kt
│   ├── LoginScreen.kt
│   ├── SignupScreen.kt
│   ├── MainScreen.kt
│   ├── CoderunScreen.kt
│   ├── CodecheckScreen.kt
│   └── CodeprogressScreen.kt
🔮 Roadmap

🎞 Advanced screen animations

🤖 AI-powered code review

☁️ Cloud sync

🔐 Firebase authentication

📈 Developer analytics dashboard

👨‍💻 Author

Siddharth Vatsa
Android Developer | Kotlin | Jetpack Compose
