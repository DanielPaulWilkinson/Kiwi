package com.example.zest.room.interfaces;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.zest.room.entities.Method;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MethodDao_Impl implements MethodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Method> __insertionAdapterOfMethod;

  private final EntityDeletionOrUpdateAdapter<Method> __deletionAdapterOfMethod;

  private final EntityDeletionOrUpdateAdapter<Method> __updateAdapterOfMethod;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MethodDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMethod = new EntityInsertionAdapter<Method>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Method` (`methodId`,`method`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Method value) {
        stmt.bindLong(1, value.methodId);
        if (value.method == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.method);
        }
      }
    };
    this.__deletionAdapterOfMethod = new EntityDeletionOrUpdateAdapter<Method>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Method` WHERE `methodId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Method value) {
        stmt.bindLong(1, value.methodId);
      }
    };
    this.__updateAdapterOfMethod = new EntityDeletionOrUpdateAdapter<Method>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Method` SET `methodId` = ?,`method` = ? WHERE `methodId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Method value) {
        stmt.bindLong(1, value.methodId);
        if (value.method == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.method);
        }
        stmt.bindLong(3, value.methodId);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM method";
        return _query;
      }
    };
  }

  @Override
  public long Create(final Method method) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfMethod.insertAndReturnId(method);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Method method) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMethod.handle(method);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMethod(final Method... method) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMethod.handleMultiple(method);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Method GetMethod(final long id) {
    final String _sql = "SELECT * FROM Method WHERE methodId=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMethodId = CursorUtil.getColumnIndexOrThrow(_cursor, "methodId");
      final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
      final Method _result;
      if(_cursor.moveToFirst()) {
        final long _tmpMethodId;
        _tmpMethodId = _cursor.getLong(_cursorIndexOfMethodId);
        final String _tmpMethod;
        _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
        _result = new Method(_tmpMethodId,_tmpMethod);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
