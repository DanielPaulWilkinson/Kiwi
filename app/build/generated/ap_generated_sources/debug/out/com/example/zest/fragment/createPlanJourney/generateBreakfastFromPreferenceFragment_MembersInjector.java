// Generated by Dagger (https://dagger.dev).
package com.example.zest.fragment.createPlanJourney;

import com.example.zest.async.FixedThreadPool;
import com.example.zest.room.repositories.CompleteMealRepository;
import com.example.zest.room.repositories.CompletePlanRepository;
import com.example.zest.services.ImageProcessing;
import com.example.zest.services.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class generateBreakfastFromPreferenceFragment_MembersInjector implements MembersInjector<generateBreakfastFromPreferenceFragment> {
  private final Provider<CompleteMealRepository> completeMealRepositoryProvider;

  private final Provider<CompletePlanRepository> completePlanRepositoryProvider;

  private final Provider<FixedThreadPool> fixedThreadPoolProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<ImageProcessing> imageProcessingProvider;

  public generateBreakfastFromPreferenceFragment_MembersInjector(
      Provider<CompleteMealRepository> completeMealRepositoryProvider,
      Provider<CompletePlanRepository> completePlanRepositoryProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<ImageProcessing> imageProcessingProvider) {
    this.completeMealRepositoryProvider = completeMealRepositoryProvider;
    this.completePlanRepositoryProvider = completePlanRepositoryProvider;
    this.fixedThreadPoolProvider = fixedThreadPoolProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.imageProcessingProvider = imageProcessingProvider;
  }

  public static MembersInjector<generateBreakfastFromPreferenceFragment> create(
      Provider<CompleteMealRepository> completeMealRepositoryProvider,
      Provider<CompletePlanRepository> completePlanRepositoryProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<ImageProcessing> imageProcessingProvider) {
    return new generateBreakfastFromPreferenceFragment_MembersInjector(completeMealRepositoryProvider, completePlanRepositoryProvider, fixedThreadPoolProvider, sharedPreferencesProvider, imageProcessingProvider);
  }

  @Override
  public void injectMembers(generateBreakfastFromPreferenceFragment instance) {
    injectCompleteMealRepository(instance, completeMealRepositoryProvider.get());
    injectCompletePlanRepository(instance, completePlanRepositoryProvider.get());
    injectFixedThreadPool(instance, fixedThreadPoolProvider.get());
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectImageProcessing(instance, imageProcessingProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateBreakfastFromPreferenceFragment.completeMealRepository")
  public static void injectCompleteMealRepository(generateBreakfastFromPreferenceFragment instance,
      CompleteMealRepository completeMealRepository) {
    instance.completeMealRepository = completeMealRepository;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateBreakfastFromPreferenceFragment.completePlanRepository")
  public static void injectCompletePlanRepository(generateBreakfastFromPreferenceFragment instance,
      CompletePlanRepository completePlanRepository) {
    instance.completePlanRepository = completePlanRepository;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateBreakfastFromPreferenceFragment.fixedThreadPool")
  public static void injectFixedThreadPool(generateBreakfastFromPreferenceFragment instance,
      FixedThreadPool fixedThreadPool) {
    instance.fixedThreadPool = fixedThreadPool;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateBreakfastFromPreferenceFragment.sharedPreferences")
  public static void injectSharedPreferences(generateBreakfastFromPreferenceFragment instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateBreakfastFromPreferenceFragment.imageProcessing")
  public static void injectImageProcessing(generateBreakfastFromPreferenceFragment instance,
      ImageProcessing imageProcessing) {
    instance.imageProcessing = imageProcessing;
  }
}