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
public final class generateLunchFromPreferenceFragment_MembersInjector implements MembersInjector<generateLunchFromPreferenceFragment> {
  private final Provider<CompleteMealRepository> completeMealRepositoryProvider;

  private final Provider<CompletePlanRepository> completePlanRepositoryProvider;

  private final Provider<FixedThreadPool> fixedThreadPoolProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<ImageProcessing> imageProcessingProvider;

  public generateLunchFromPreferenceFragment_MembersInjector(
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

  public static MembersInjector<generateLunchFromPreferenceFragment> create(
      Provider<CompleteMealRepository> completeMealRepositoryProvider,
      Provider<CompletePlanRepository> completePlanRepositoryProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<ImageProcessing> imageProcessingProvider) {
    return new generateLunchFromPreferenceFragment_MembersInjector(completeMealRepositoryProvider, completePlanRepositoryProvider, fixedThreadPoolProvider, sharedPreferencesProvider, imageProcessingProvider);
  }

  @Override
  public void injectMembers(generateLunchFromPreferenceFragment instance) {
    injectCompleteMealRepository(instance, completeMealRepositoryProvider.get());
    injectCompletePlanRepository(instance, completePlanRepositoryProvider.get());
    injectFixedThreadPool(instance, fixedThreadPoolProvider.get());
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectImageProcessing(instance, imageProcessingProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateLunchFromPreferenceFragment.completeMealRepository")
  public static void injectCompleteMealRepository(generateLunchFromPreferenceFragment instance,
      CompleteMealRepository completeMealRepository) {
    instance.completeMealRepository = completeMealRepository;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateLunchFromPreferenceFragment.completePlanRepository")
  public static void injectCompletePlanRepository(generateLunchFromPreferenceFragment instance,
      CompletePlanRepository completePlanRepository) {
    instance.completePlanRepository = completePlanRepository;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateLunchFromPreferenceFragment.fixedThreadPool")
  public static void injectFixedThreadPool(generateLunchFromPreferenceFragment instance,
      FixedThreadPool fixedThreadPool) {
    instance.fixedThreadPool = fixedThreadPool;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateLunchFromPreferenceFragment.sharedPreferences")
  public static void injectSharedPreferences(generateLunchFromPreferenceFragment instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.generateLunchFromPreferenceFragment.imageProcessing")
  public static void injectImageProcessing(generateLunchFromPreferenceFragment instance,
      ImageProcessing imageProcessing) {
    instance.imageProcessing = imageProcessing;
  }
}