package com.example.zest.room.interfaces;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.zest.room.entities.MealIngredientsJoin;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MealIngredientsJoinDao_Impl implements MealIngredientsJoinDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MealIngredientsJoin> __insertionAdapterOfMealIngredientsJoin;

  private final EntityDeletionOrUpdateAdapter<MealIngredientsJoin> __deletionAdapterOfMealIngredientsJoin;

  private final EntityDeletionOrUpdateAdapter<MealIngredientsJoin> __updateAdapterOfMealIngredientsJoin;

  public MealIngredientsJoinDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMealIngredientsJoin = new EntityInsertionAdapter<MealIngredientsJoin>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MealIngredientsJoin` (`mealId`,`ingredientsId`,`amount`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealIngredientsJoin value) {
        stmt.bindLong(1, value.mealId);
        stmt.bindLong(2, value.ingredientsId);
        stmt.bindDouble(3, value.amount);
      }
    };
    this.__deletionAdapterOfMealIngredientsJoin = new EntityDeletionOrUpdateAdapter<MealIngredientsJoin>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `MealIngredientsJoin` WHERE `mealId` = ? AND `ingredientsId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealIngredientsJoin value) {
        stmt.bindLong(1, value.mealId);
        stmt.bindLong(2, value.ingredientsId);
      }
    };
    this.__updateAdapterOfMealIngredientsJoin = new EntityDeletionOrUpdateAdapter<MealIngredientsJoin>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MealIngredientsJoin` SET `mealId` = ?,`ingredientsId` = ?,`amount` = ? WHERE `mealId` = ? AND `ingredientsId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealIngredientsJoin value) {
        stmt.bindLong(1, value.mealId);
        stmt.bindLong(2, value.ingredientsId);
        stmt.bindDouble(3, value.amount);
        stmt.bindLong(4, value.mealId);
        stmt.bindLong(5, value.ingredientsId);
      }
    };
  }

  @Override
  public void insert(final MealIngredientsJoin... mealIngredientsJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMealIngredientsJoin.insert(mealIngredientsJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MealIngredientsJoin mealIngredientsJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMealIngredientsJoin.handle(mealIngredientsJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final MealIngredientsJoin... mealIngredientsJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMealIngredientsJoin.handleMultiple(mealIngredientsJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public MealIngredientsJoin Get(final long ingredientid, final long mealid) {
    final String _sql = "SELECT * FROM MealIngredientsJoin WHERE ingredientsId=? and mealId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, ingredientid);
    _argIndex = 2;
    _statement.bindLong(_argIndex, mealid);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMealId = CursorUtil.getColumnIndexOrThrow(_cursor, "mealId");
      final int _cursorIndexOfIngredientsId = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredientsId");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final MealIngredientsJoin _result;
      if(_cursor.moveToFirst()) {
        final long _tmpMealId;
        _tmpMealId = _cursor.getLong(_cursorIndexOfMealId);
        final long _tmpIngredientsId;
        _tmpIngredientsId = _cursor.getLong(_cursorIndexOfIngredientsId);
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        _result = new MealIngredientsJoin(_tmpMealId,_tmpIngredientsId,_tmpAmount);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Double GetAmount(final long mealId, final long ingredientId) {
    final String _sql = "SELECT amount FROM MealIngredientsJoin WHERE ingredientsId=? and mealId=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, ingredientId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, mealId);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
      try {
        final Double _result;
        if(_cursor.moveToFirst()) {
          if (_cursor.isNull(0)) {
            _result = null;
          } else {
            _result = _cursor.getDouble(0);
          }
        } else {
          _result = null;
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }
}
