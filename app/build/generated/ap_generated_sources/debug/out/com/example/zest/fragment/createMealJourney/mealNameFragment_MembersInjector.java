// Generated by Dagger (https://dagger.dev).
package com.example.zest.fragment.createMealJourney;

import com.example.zest.services.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class mealNameFragment_MembersInjector implements MembersInjector<mealNameFragment> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public mealNameFragment_MembersInjector(Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  public static MembersInjector<mealNameFragment> create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new mealNameFragment_MembersInjector(sharedPreferencesProvider);
  }

  @Override
  public void injectMembers(mealNameFragment instance) {
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.fragment.createMealJourney.mealNameFragment.sharedPreferences")
  public static void injectSharedPreferences(mealNameFragment instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }
}
