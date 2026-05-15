package com.channapatna.nammapride.data

import com.channapatna.nammapride.model.ToyVerification
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ToyRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val toysCollection = firestore.collection("toys")

    /**
     * Verify a toy by its 6-digit ID.
     * Falls back to local [AppData.toyDatabase] if Firestore is unavailable.
     */
    suspend fun verifyToy(toyId: String): Result<ToyVerification?> {
        return try {
            val doc = toysCollection.document(toyId).get().await()
            if (doc.exists()) {
                val toy = doc.toObject(ToyVerification::class.java)
                Result.success(toy)
            } else {
                // Fallback to local demo data
                val localToy = AppData.toyDatabase[toyId]
                Result.success(localToy)
            }
        } catch (e: Exception) {
            // If Firebase fails, use local data (offline-first)
            val localToy = AppData.toyDatabase[toyId]
            Result.success(localToy)
        }
    }
}
