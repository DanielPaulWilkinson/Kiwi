// Generated by Dagger (https://dagger.dev).
package com.example.zest.fragment.createPlanJourney;

import com.example.zest.services.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class typeOfPlanFragment_MembersInjector implements MembersInjector<typeOfPlanFragment> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public typeOfPlanFragment_MembersInjector(Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  public static MembersInjector<typeOfPlanFragment> create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new typeOfPlanFragment_MembersInjector(sharedPreferencesProvider);
  }

  @Override
  public void injectMembers(typeOfPlanFragment instance) {
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.fragment.createPlanJourney.typeOfPlanFragment.sharedPreferences")
  public static void injectSharedPreferences(typeOfPlanFragment instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }
}