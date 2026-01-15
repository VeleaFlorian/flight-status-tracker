package com.example.flightstatustracker.data.repository;

import com.example.flightstatustracker.data.local.AppDatabase;
import com.example.flightstatustracker.data.remote.FlightApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class FlightRepositoryImpl_Factory implements Factory<FlightRepositoryImpl> {
  private final Provider<FlightApiService> apiProvider;

  private final Provider<AppDatabase> dbProvider;

  public FlightRepositoryImpl_Factory(Provider<FlightApiService> apiProvider,
      Provider<AppDatabase> dbProvider) {
    this.apiProvider = apiProvider;
    this.dbProvider = dbProvider;
  }

  @Override
  public FlightRepositoryImpl get() {
    return newInstance(apiProvider.get(), dbProvider.get());
  }

  public static FlightRepositoryImpl_Factory create(Provider<FlightApiService> apiProvider,
      Provider<AppDatabase> dbProvider) {
    return new FlightRepositoryImpl_Factory(apiProvider, dbProvider);
  }

  public static FlightRepositoryImpl newInstance(FlightApiService api, AppDatabase db) {
    return new FlightRepositoryImpl(api, db);
  }
}
