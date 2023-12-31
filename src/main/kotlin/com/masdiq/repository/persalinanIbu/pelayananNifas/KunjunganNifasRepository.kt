package com.masdiq.repository.persalinanIbu.pelayananNifas

import com.masdiq.model.persalinanIbu.pelayananNifas.KunjunganNifas

interface KunjunganNifasRepository {
    suspend fun getAllKunjunganNifas(): List<KunjunganNifas>

    suspend fun getKunjunganNifas(reqId: String): KunjunganNifas?

    suspend fun createOrUpdateKunjunganNifas(kunjunganNifas: KunjunganNifas): Boolean

    suspend fun deleteKunjunganNifas(reqId: String): Boolean
    suspend fun searchKunjunganNifas(reqId: String): List<KunjunganNifas>
}