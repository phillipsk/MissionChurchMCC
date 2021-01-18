/*
 * Copyright (c) 2021  Kevin Phillips, Mission Church of Our Lord Jesus Christ
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.missionchurchcooljc.common.network.api

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChurchWebsiteRepository {
    private val service: ChurchWebsiteService

    companion object {
        private const val BASE_URL = "http://god.works/"
    }

    init {
        val retrofit = Retrofit.Builder()
            //1
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //2
            .build()
        //3
        service = retrofit.create(ChurchWebsiteService::class.java)
    }

    fun getRepositories(callback: Callback<ChurchWebsiteResponse>) {
        //4
        service.getHighlightsExternal().enqueue(callback)
    }
}