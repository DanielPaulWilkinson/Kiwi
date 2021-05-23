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
public final class brandOfIngredientFragment_MembersInjector implements MembersInjector<brandOfIngredientFragment> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<FixedThreadPool> fixedThreadPoolProvider;

  public brandOfIngredientFragment_MembersInjector(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.fixedThreadPoolProvider = fixedThreadPoolProvider;
  }

  public static MembersInjector<brandOfIngredientFragment> create(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    return new brandOfIngredientFragment_MembersInjector(sharedPreferencesProvider, fixedThreadPoolProvider);
  }

  @Override
  public void injectMembers(brandOfIngredientFragment instance) {
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectFixedThreadPool(instance, fixedThreadPoolProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.fragment.createIngredientJourney.brandOfIngredientFragment.sharedPreferences")
  public static void injectSharedPreferences(brandOfIngredientFragment instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }

  @InjectedFieldSignature("com.example.zest.fragment.createIngredientJourney.brandOfIngredientFragment.fixedThreadPool")
  public static void injectFixedThreadPool(brandOfIngredientFragment instance,
      FixedThreadPool fixedThreadPool) {
    instance.fixedThreadPool = fixedThreadPool;
  }
}
