// Generated by Dagger (https://dagger.dev).
package com.example.zest.fragment.createIngredientJourney;

import com.example.zest.async.FixedThreadPool;
import com.example.zest.services.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class sugarOfIngredientFragment_MembersInjector implements MembersInjector<sugarOfIngredientFragment> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<FixedThreadPool> fixedThreadPoolProvider;

  public sugarOfIngredientFragment_MembersInjector(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.fixedThreadPoolProvider = fixedThreadPoolProvider;
  }

  public static MembersInjector<sugarOfIngredientFragment> create(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    return new sugarOfIngredientFragment_MembersInjector(sharedPreferencesProvider, fixedThreadPoolProvider);
  }

  @Override
  public void injectMembers(sugarOfIngredientFragment instance) {
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectFixedThreadPool(instance, fixedThreadPoolProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.fragment.createIngredientJourney.sugarOfIngredientFragment.sharedPreferences")
  public static void injectSharedPreferences(sugarOfIngredientFragment instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createIngredientJourney.sugarOfIngredientFragment.fixedThreadPool")
  public static void injectFixedThreadPool(sugarOfIngredientFragment instance,
      FixedThreadPool fixedThreadPool) {
    instance.fixedThreadPool = fixedThreadPool;
  }
}