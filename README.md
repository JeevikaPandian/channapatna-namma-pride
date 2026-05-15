# 🪆 Channapatna Namma Pride

An Android application to verify, explore, and celebrate authentic GI-certified Channapatna lacquered wooden toys from Karnataka, India.

---

## 🚨 Problem Statement

Authentic Channapatna wooden toys hold a Geographical Indication (GI) tag from the Government of India. However, cheap plastic imitations flood the market, making it impossible for buyers to identify genuine products. Local artisans remain unrecognized and lose income to counterfeiters.

---

## 💡 Solution

Channapatna Namma Pride provides a digital verification platform where every authentic toy is assigned a unique 6-digit Toy ID registered in Firebase Firestore. Buyers scan this ID to instantly verify authenticity and connect with the artisan who made it.

---

## ✨ Features

- 🔍 **Toy Verification** — Enter 6-digit Toy ID to verify authenticity via Firebase Firestore
- 🤖 **NammaBot AI** — Heritage chatbot powered by Google Gemini API
- 🛍️ **Toy Catalogue** — Filterable grid of GI-certified toys by category
- 🗺️ **Workshop Locator** — 5 verified artisan workshops with Google Maps integration
- 📚 **Learn** — 5-step lac-dyeing craft process, videos, GI tag explainer
- 🔊 **Text-to-Speech** — Artisan stories read aloud
- 🎤 **Voice Input** — Speak the Toy ID or chat with NammaBot
- 📴 **Offline Fallback** — Works without internet using local data

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Kotlin | Primary programming language |
| Android Studio | Development environment |
| XML | UI layouts |
| Firebase Firestore | Cloud database for toy verification |
| Google Gemini API | AI-powered NammaBot chatbot |
| Retrofit + OkHttp | Network calls |
| Android Navigation Component | Fragment navigation |
| Material Design 3 | UI components |
| Android TTS | Text-to-Speech readout |
| SpeechRecognizer | Voice input |
| MVVM Architecture | Clean code structure |

---

## 📁 Project Structure

    app/src/main/
    ├── java/com/channapatna/nammapride/
    │   ├── MainActivity.kt
    │   ├── model/Models.kt
    │   ├── data/
    │   │   ├── AppData.kt
    │   │   ├── ToyRepository.kt
    │   │   ├── AnthropicApiService.kt
    │   │   └── RetrofitClient.kt
    │   └── ui/
    │       ├── home/
    │       ├── verify/
    │       ├── ai/
    │       ├── catalogue/
    │       ├── workshops/
    │       └── learn/
    └── res/
        ├── layout/
        ├── drawable/
        ├── navigation/
        └── values/

---

## ⚙️ Setup Instructions

### Prerequisites
- Android Studio (latest version)
- Android device or emulator (API 24 / Android 7.0+)
- Firebase account
- Google Gemini API key (free at https://aistudio.google.com)

### Steps to Run

**1. Clone the repository**

    git clone https://github.com/JeevikaPandian/channapatna-namma-pride.git
    cd channapatna-namma-pride

**2. Open in Android Studio**
- Open Android Studio → File → Open → select the cloned folder

**3. Add Firebase config**
- Go to https://console.firebase.google.com
- Create a project → Add Android app → package: com.channapatna.nammapride
- Download google-services.json and place it in the app/ folder

**4. Add Gemini API Key**
- Get a free key from https://aistudio.google.com
- Open app/build.gradle.kts and replace YOUR_GEMINI_API_KEY_HERE with your actual key

**5. Run the app**
- Click the Run button in Android Studio
- Minimum SDK: Android 7.0 (API 24)

---

## 🔑 Demo Toy IDs to Test

| Toy ID | Artisan | Result |
|---|---|---|
| 423781 | Ramu Shilpi | Verified |
| 195023 | Meena Devi | Verified |
| 777001 | Prakash Kumar | Verified |
| 999999 | — | Counterfeit |

---

## 🔮 Future Enhancements

- QR code scanner for Toy ID
- Multi-language support (Kannada)
- Online payment gateway for direct toy purchases
- Artisan video content
- Google Play Store deployment

---
## Screenshots



## 👩‍💻 Developed By

**Jeevika N P**

USN: 1AT22CG0036

Atria Institute of Technology, Bangalore

Internship at: MindMatrix

Guide: Prof. Poornima T

Academic Year: 2025-26

---

## 📜 License

Built for the Channapatna artisan community.
GI Tag — Government of India
