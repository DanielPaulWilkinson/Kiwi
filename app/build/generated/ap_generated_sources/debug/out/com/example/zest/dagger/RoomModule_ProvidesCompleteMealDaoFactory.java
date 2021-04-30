// Generated by Dagger (https://dagger.dev).
package com.example.zest.dagger;

import com.example.zest.room.general.RoomDB;
import com.example.zest.room.interfaces.CompleteMealDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomModule_ProvidesCompleteMealDaoFactory implements Factory<CompleteMealDao> {
  private final RoomModule module;

  private final Provider<RoomDB> databaseProvider;

  public RoomModule_ProvidesCompleteMealDaoFactory(RoomModule module,
      Provider<RoomDB> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public CompleteMealDao get() {
    return providesCompleteMealDao(module, databaseProvider.get());
  }

  public static RoomModule_ProvidesCompleteMealDaoFactory create(RoomModule module,
      Provider<RoomDB> databaseProvider) {
    return new RoomModule_ProvidesCompleteMealDaoFactory(module, databaseProvider);
  }

  public static CompleteMealDao providesCompleteMealDao(RoomModule instance, RoomDB database) {
    return Preconditions.checkNotNullFromProvides(instance.providesCompleteMealDao(database));
  }
}