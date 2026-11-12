# Implementation status

## Bootstrapped
- Native Kotlin/Jetpack Compose Android application shell, package ID and minimum API 26.
- GitHub Actions workflow to assemble a debug APK and retain it as a workflow artifact.
- TypeScript/Express API skeleton with health and category endpoints and validation example.
- Initial PostgreSQL Prisma models for categories, products and super-admin identities.
- Admin dashboard shell.

## Not yet production-ready
- Customer identity/session management and guest-order persistence.
- Complete catalog, inventory reservation, coupon and order APIs.
- Payment provider integration, signed webhook verification, reconciliation and refund handling.
- Admin login, RBAC, secure provisioning, audit trail and management screens.
- File storage, FCM, support tickets, privacy/terms content, monitoring and backups.
- Automated tests, dependency/security scans, release signing and device QA.

Checkout is intentionally disabled until authoritative database pricing and payment verification are implemented. No payment is marked paid based on a UTR or screenshot alone.
