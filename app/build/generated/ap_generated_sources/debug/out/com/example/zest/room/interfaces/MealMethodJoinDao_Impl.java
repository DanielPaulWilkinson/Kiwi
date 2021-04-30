package com.example.zest.room.interfaces;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.zest.room.entities.MealMethodJoin;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MealMethodJoinDao_Impl implements MealMethodJoinDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MealMethodJoin> __insertionAdapterOfMealMethodJoin;

  private final EntityDeletionOrUpdateAdapter<MealMethodJoin> __deletionAdapterOfMealMethodJoin;

  private final EntityDeletionOrUpdateAdapter<MealMethodJoin> __updateAdapterOfMealMethodJoin;

  public MealMethodJoinDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMealMethodJoin = new EntityInsertionAdapter<MealMethodJoin>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MealMethodJoin` (`mealId`,`methodId`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealMethodJoin value) {
        stmt.bindLong(1, value.mealId);
        stmt.bindLong(2, value.methodId);
      }
    };
    this.__deletionAdapterOfMealMethodJoin = new EntityDeletionOrUpdateAdapter<MealMethodJoin>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `MealMethodJoin` WHERE `mealId` = ? AND `methodId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealMethodJoin value) {
        stmt.bindLong(1, value.mealId);
        stmt.bindLong(2, value.methodId);
      }
    };
    this.__updateAdapterOfMealMethodJoin = new EntityDeletionOrUpdateAdapter<MealMethodJoin>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MealMethodJoin` SET `mealId` = ?,`methodId` = ? WHERE `mealId` = ? AND `methodId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealMethodJoin value) {
        stmt.bindLong(1, value.mealId);
        stmt.bindLong(2, value.methodId);
        stmt.bindLong(3, value.mealId);
        stmt.bindLong(4, value.methodId);
      }
    };
  }

  @Override
  public void insertMealMethod(final MealMethodJoin... mealMethodJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMealMethodJoin.insert(mealMethodJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MealMethodJoin mealMethodJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMealMethodJoin.handle(mealMethodJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateIngredients(final MealMethodJoin... mealMethodJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMealMethodJoin.handleMultiple(mealMethodJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
