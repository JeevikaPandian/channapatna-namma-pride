# 🪆 Channapatna Namma Pride — Android App

An Android application to discover, verify, and celebrate authentic Channapatna GI-certified lacquered wooden toys from Karnataka, India.

---

## ✨ Features

| Screen | Description |
|---|---|
| 🏠 **Home** | Hero banner, quick actions, featured artisans, GI tag info |
| 🔍 **Verify** | 6-digit Toy ID verification via Firebase Firestore + TTS readout |
| 🤖 **AI Guide (NammaBot)** | Claude-powered heritage chatbot with voice input & TTS |
| 🛍️ **Catalogue** | Filterable toy grid (Tops, Horses, Dolls, Animals, Puzzles) |
| 🗺️ **Workshops** | 5 verified artisan workshop locations with Maps deep-link |
| 📚 **Learn** | Craft process steps, video placeholders, GI tag explainer |

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Architecture:** MVVM + Navigation Component
- **UI:** Material Components, ViewBinding, RecyclerView
- **Backend:** Firebase Firestore (toy verification)
- **AI:** Anthropic Claude API (`claude-sonnet-4-20250514`)
- **Networking:** Retrofit 2 + OkHttp + Gson
- **Async:** Kotlin Coroutines
- **Voice:** Android SpeechRecognizer + TextToSpeech

---

## 🚀 Setup Instructions

### Step 1 — Clone / Open in Android Studio

Open Android Studio → **File → Open** → select the `ChannapatnaNammaPride` folder.

### Step 2 — Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project called `channapatna-namma-pride`
3. Add an Android app with package name: `com.channapatna.nammapride`
4. Download `google-services.json` and place it in `app/`
5. In Firestore, create a collection called `toys` with documents:
   - Document ID: `423781`
   - Fields: `artisan`, `avatar`, `village`, `years`, `specialty`, `toy`, `lac`, `batch`, `status`
   - (See `AppData.kt` for the full seed data)

### Step 3 — Add Anthropic API Key

Open `app/build.gradle.kts` and replace:

```kotlin
buildConfigField("String", "ANTHROPIC_API_KEY", "\"YOUR_ANTHROPIC_API_KEY_HERE\"")
```

with your actual key from [console.anthropic.com](https://console.anthropic.com/).

> ⚠️ Never commit your API key to version control. Use `local.properties` or Android secrets plugin for production.

### Step 4 — Update SDK Path

Open `local.properties` and set:

```
sdk.dir=/path/to/your/Android/Sdk
```

### Step 5 — Build & Run

Click **▶ Run** in Android Studio, or:

```bash
./gradlew assembleDebug
```

---

## 📁 Project Structure

```
app/src/main/
├── java/com/channapatna/nammapride/
│   ├── MainActivity.kt              # NavController + BottomNav host
│   ├── model/Models.kt              # All data classes
│   ├── data/
│   │   ├── AppData.kt               # Static data, toy DB, NammaBot prompt
│   │   ├── ToyRepository.kt         # Firebase + local fallback
│   │   ├── AnthropicApiService.kt   # Retrofit interface
│   │   └── RetrofitClient.kt        # OkHttp singleton
│   └── ui/
│       ├── home/                    # HomeFragment + ArtisanCardAdapter
│       ├── verify/                  # VerifyFragment (TTS, voice, Firebase)
│       ├── ai/                      # AiFragment + ChatAdapter (Claude API)
│       ├── catalogue/               # CatalogueFragment + ToyGridAdapter
│       ├── workshops/               # WorkshopsFragment + WorkshopAdapter
│       └── learn/                   # LearnFragment + ProcessStepAdapter
└── res/
    ├── layout/                      # 12 XML layout files
    ├── drawable/                    # 16 drawable/shape XMLs + 5 nav icons
    ├── navigation/nav_graph.xml
    ├── menu/bottom_nav_menu.xml
    ├── values/colors, strings, themes
    └── xml/network_security_config.xml
```

---

## 🎯 Demo Toy IDs

| ID | Artisan | Result |
|---|---|---|
| `423781` | Ramu Shilpi | ✅ Verified |
| `195023` | Meena Devi | ✅ Verified |
| `777001` | Prakash Kumar | ✅ Verified |
| `999999` | — | ❌ Counterfeit |

---

## 📜 License

Built for the Channapatna artisan community. GI Tag — Government of India.
