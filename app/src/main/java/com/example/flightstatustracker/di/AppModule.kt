package com.example.flightstatustracker.di

import android.app.Application
import androidx.room.Room
import com.example.flightstatustracker.data.local.AppDatabase
import com.example.flightstatustracker.data.local.dao.FlightDao
import com.example.flightstatustracker.data.remote.FlightApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFlightApiService(): FlightApiService {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl("http://api.aviationstack.com/v1/") // Note: HTTP not HTTPS for free plan usually, but assuming HTTPS or cleartext enabled
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(FlightApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "flight_tracker.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideFlightDao(db: AppDatabase): FlightDao {
        return db.flightDao
    }
}
