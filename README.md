# BLACKX SHARK

Native Android storefront starter for authorized prepaid products, with a separate API and admin console.

## Repository layout
- `android-app/`: Kotlin, Jetpack Compose, MVVM Android client.
- `backend/`: TypeScript Express API and Prisma schema.
- `admin-dashboard/`: React/Vite admin console starter.
- `.github/workflows/android-apk.yml`: CI build; uploads a debug APK artifact.

## Build the Android app
Open `android-app` in Android Studio or run:
```bash
cd android-app
./gradlew assembleDebug
```
APK: `android-app/app/build/outputs/apk/debug/app-debug.apk`.

GitHub Actions builds on pushes to `main` and manual dispatch. Download the APK from the workflow run's Artifacts section.

## Important production setup
This repository bootstrap is not a production commerce deployment. Before accepting real payments:
1. Deploy the API and PostgreSQL database.
2. Set secrets and configure a real HTTPS API URL.
3. Configure an authorized payment gateway and server-side webhook verification. UPI UTR submissions must remain pending until verified.
4. Create the first super-admin securely using a one-time server-side provisioning process.
5. Configure storage, FCM, backups, monitoring, and privacy/legal policies.
6. Run tests, security review, and a signed release build with protected signing secrets.

Never place gateway secrets, admin credentials, or signing keys in the APK.
