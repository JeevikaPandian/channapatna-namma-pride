---

## ⚙️ Setup Instructions

### Prerequisites
- Android Studio (latest version)
- Android device or emulator (API 24 / Android 7.0+)
- Firebase account
- Google Gemini API key (free at https://aistudio.google.com)

### Steps to Run

**1. Clone the repository**
```bash
git clone https://github.com/JeevikaPandian/channapatna-namma-pride.git
cd channapatna-namma-pride
```

**2. Open in Android Studio**
- Open Android Studio → File → Open → select the cloned folder

**3. Add Firebase config**
- Go to https://console.firebase.google.com
- Create a project → Add Android app → package: `com.channapatna.nammapride`
- Download `google-services.json` and place it in the `app/` folder

**4. Add Gemini API Key**
- Get a free key from https://aistudio.google.com
- Open `app/build.gradle.kts` and replace:
```kotlin
buildConfigField("String", "GEMINI_API_KEY", "\"YOUR_GEMINI_API_KEY_HERE\"")
```

**5. Run the app**
- Click the ▶️ Run button in Android Studio
- Minimum SDK: Android 7.0 (API 24)

---

## 🔑 Demo Toy IDs to Test

| Toy ID | Artisan | Result |
|---|---|---|
| `423781` | Ramu Shilpi | ✅ Verified |
| `195023` | Meena Devi | ✅ Verified |
| `777001` | Prakash Kumar | ✅ Verified |
| `999999` | — | ❌ Counterfeit |

---

## 🔮 Future Enhancements

- QR code scanner for Toy ID
- Multi-language support (Kannada)
- Online payment gateway for direct toy purchases
- Artisan video content
- Google Play Store deployment

---

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
GI Tag — Government of India 🇮🇳
