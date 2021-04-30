// Generated by Dagger (https://dagger.dev).
package com.example.zest.activities;

import com.example.zest.async.FixedThreadPool;
import com.example.zest.services.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OnBoardingActivity_MembersInjector implements MembersInjector<OnBoardingActivity> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<FixedThreadPool> fixedThreadPoolProvider;

  public OnBoardingActivity_MembersInjector(Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    this.fixedThreadPoolProvider = fixedThreadPoolProvider;
  }

  public static MembersInjector<OnBoardingActivity> create(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider) {
    return new OnBoardingActivity_MembersInjector(sharedPreferencesProvider, fixedThreadPoolProvider);
  }

  @Override
  public void injectMembers(OnBoardingActivity instance) {
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
    injectFixedThreadPool(instance, fixedThreadPoolProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.activities.OnBoardingActivity.sharedPreferences")
  public static void injectSharedPreferences(OnBoardingActivity instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }

  @InjectedFieldSignature("com.example.zest.activities.OnBoardingActivity.fixedThreadPool")
  public static void injectFixedThreadPool(OnBoardingActivity instance,
      FixedThreadPool fixedThreadPool) {
    instance.fixedThreadPool = fixedThreadPool;
  }
}