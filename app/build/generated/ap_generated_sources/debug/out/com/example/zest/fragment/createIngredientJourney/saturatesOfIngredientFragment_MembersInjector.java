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
public final class saturatesOfIngredientFragment_MembersInjector implements MembersInjector<saturatesOfIngredientFragment> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<FixedThreadPool> fixedThreadPoolProvider;

  public saturatesOfIngredientFragment_MembersInjector(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.fixedThreadPoolProvider = fixedThreadPoolProvider;
  }

  public static MembersInjector<saturatesOfIngredientFragment> create(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    return new saturatesOfIngredientFragment_MembersInjector(sharedPreferencesProvider, fixedThreadPoolProvider);
  }

  @Override
  public void injectMembers(saturatesOfIngredientFragment instance) {
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectFixedThreadPool(instance, fixedThreadPoolProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.fragment.createIngredientJourney.saturatesOfIngredientFragment.sharedPreferences")
  public static void injectSharedPreferences(saturatesOfIngredientFragment instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createIngredientJourney.saturatesOfIngredientFragment.fixedThreadPool")
  public static void injectFixedThreadPool(saturatesOfIngredientFragment instance,
      FixedThreadPool fixedThreadPool) {
    instance.fixedThreadPool = fixedThreadPool;
  }
}