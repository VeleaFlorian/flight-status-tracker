package com.example.flightstatustracker.presentation;

import com.example.flightstatustracker.domain.repository.FlightRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class FlightViewModel_Factory implements Factory<FlightViewModel> {
  private final Provider<FlightRepository> repositoryProvider;

  public FlightViewModel_Factory(Provider<FlightRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public FlightViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static FlightViewModel_Factory create(Provider<FlightRepository> repositoryProvider) {
    return new FlightViewModel_Factory(repositoryProvider);
  }

  public static FlightViewModel newInstance(FlightRepository repository) {
    return new FlightViewModel(repository);
  }
}
