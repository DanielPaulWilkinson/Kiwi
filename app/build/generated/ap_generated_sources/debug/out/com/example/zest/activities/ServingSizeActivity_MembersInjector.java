// Generated by Dagger (https://dagger.dev).
package com.example.zest.activities;

import com.example.zest.async.FixedThreadPool;
import com.example.zest.room.repositories.IngredientRepository;
import com.example.zest.services.SharedPreferences;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ServingSizeActivity_MembersInjector implements MembersInjector<ServingSizeActivity> {
  private final Provider<IngredientRepository> ingredientRepositoryProvider;

  private final Provider<FixedThreadPool> fixedThreadPoolProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public ServingSizeActivity_MembersInjector(
      Provider<IngredientRepository> ingredientRepositoryProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    this.ingredientRepositoryProvider = ingredientRepositoryProvider;
    this.fixedThreadPoolProvider = fixedThreadPoolProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  public static MembersInjector<ServingSizeActivity> create(
      Provider<IngredientRepository> ingredientRepositoryProvider,
      Provider<FixedThreadPool> fixedThreadPoolProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new ServingSizeActivity_MembersInjector(ingredientRepositoryProvider, fixedThreadPoolProvider, sharedPreferencesProvider);
  }

  @Override
  public void injectMembers(ServingSizeActivity instance) {
    injectIngredientRepository(instance, ingredientRepositoryProvider.get());
    injectFixedThreadPool(instance, fixedThreadPoolProvider.get());
    injectSharedPreferences(instance, sharedPreferencesProvider.get());
  }

  @InjectedFieldSignature("com.example.zest.activities.ServingSizeActivity.ingredientRepository")
  public static void injectIngredientRepository(ServingSizeActivity instance,
      IngredientRepository ingredientRepository) {
    instance.ingredientRepository = ingredientRepository;
  }

  @InjectedFieldSignature("com.example.zest.activities.ServingSizeActivity.fixedThreadPool")
  public static void injectFixedThreadPool(ServingSizeActivity instance,
      FixedThreadPool fixedThreadPool) {
    instance.fixedThreadPool = fixedThreadPool;
  }

  @InjectedFieldSignature("com.example.zest.activities.ServingSizeActivity.sharedPreferences")
  public static void injectSharedPreferences(ServingSizeActivity instance,
      SharedPreferences sharedPreferences) {
    instance.sharedPreferences = sharedPreferences;
  }
}