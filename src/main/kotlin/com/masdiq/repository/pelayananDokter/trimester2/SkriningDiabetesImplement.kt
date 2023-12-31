package com.masdiq.repository.pelayananDokter.trimester2

import com.masdiq.model.pelayananDokter.trimester2.SkriningDiabetes
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colSkriningDiabetes = DATABASE.getCollection<SkriningDiabetes>()

class SkriningDiabetesImplement : SkriningDiabetesRepository {
    override suspend fun getAllSkriningDiabetes(): List<SkriningDiabetes> {
        return colSkriningDiabetes.find().toList()
    }

    override suspend fun getSkriningDiabetes(reqId: String): SkriningDiabetes? {
        return colSkriningDiabetes.findOneById(reqId)
    }

    override suspend fun createOrUpdateSkriningDiabetes(skriningDiabetes: SkriningDiabetes): Boolean {
        val dataFound = colSkriningDiabetes.findOneById(skriningDiabetes.id) != null

        return if (dataFound) {
            colSkriningDiabetes.updateOneById(skriningDiabetes.id, skriningDiabetes).wasAcknowledged()
        } else {
            skriningDiabetes.id = ObjectId().toString()
            colSkriningDiabetes.insertOne(skriningDiabetes).wasAcknowledged()
        }
    }

    override suspend fun deleteSkriningDiabetes(reqId: String): Boolean {
        val dataDelete = colSkriningDiabetes.findOne(SkriningDiabetes::id eq reqId)
        dataDelete?.let { data ->
            return colSkriningDiabetes.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchSkriningDiabetes(reqId: String): List<SkriningDiabetes> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colSkriningDiabetes.find(SkriningDiabetes::userId eq reqId).toList()
        }
    }
}