package com.example.flightstatustracker.di;

import com.example.flightstatustracker.data.remote.FlightApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideFlightApiServiceFactory implements Factory<FlightApiService> {
  @Override
  public FlightApiService get() {
    return provideFlightApiService();
  }

  public static AppModule_ProvideFlightApiServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FlightApiService provideFlightApiService() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFlightApiService());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideFlightApiServiceFactory INSTANCE = new AppModule_ProvideFlightApiServiceFactory();
  }
}
