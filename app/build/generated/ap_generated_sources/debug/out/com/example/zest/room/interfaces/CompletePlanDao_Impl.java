package com.example.zest.room.interfaces;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.zest.room.entities.CompletePlan;
import com.example.zest.room.entities.Plan;
import com.example.zest.room.entities.PlanDate;
import com.example.zest.room.entities.PlanDatesJoin;
import com.example.zest.room.general.Converters;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CompletePlanDao_Impl extends CompletePlanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Plan> __insertionAdapterOfPlan;

  private final EntityInsertionAdapter<PlanDate> __insertionAdapterOfPlanDate;

  private final EntityInsertionAdapter<PlanDatesJoin> __insertionAdapterOfPlanDatesJoin;

  private final EntityDeletionOrUpdateAdapter<Plan> __deletionAdapterOfPlan;

  private final EntityDeletionOrUpdateAdapter<PlanDate> __deletionAdapterOfPlanDate;

  private final EntityDeletionOrUpdateAdapter<PlanDatesJoin> __deletionAdapterOfPlanDatesJoin;

  private final EntityDeletionOrUpdateAdapter<Plan> __updateAdapterOfPlan;

  private final EntityDeletionOrUpdateAdapter<PlanDate> __updateAdapterOfPlanDate;

  private final EntityDeletionOrUpdateAdapter<PlanDatesJoin> __updateAdapterOfPlanDatesJoin;

  public CompletePlanDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlan = new EntityInsertionAdapter<Plan>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Plan` (`planId`,`cost`,`name`,`isGeneratePlanType`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Plan value) {
        stmt.bindLong(1, value.planId);
        if (value.cost == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.cost);
        }
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        final Integer _tmp;
        _tmp = value.isGeneratePlanType == null ? null : (value.isGeneratePlanType ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
      }
    };
    this.__insertionAdapterOfPlanDate = new EntityInsertionAdapter<PlanDate>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PlanDate` (`planDateId`,`breakfast`,`lunch`,`dinner`,`snack`,`date`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlanDate value) {
        stmt.bindLong(1, value.planDateId);
        stmt.bindLong(2, value.breakfast);
        stmt.bindLong(3, value.lunch);
        stmt.bindLong(4, value.dinner);
        stmt.bindLong(5, value.snack);
        final Long _tmp;
        _tmp = Converters.dateToTimestamp(value.date);
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
      }
    };
    this.__insertionAdapterOfPlanDatesJoin = new EntityInsertionAdapter<PlanDatesJoin>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PlanDatesJoin` (`planId`,`planDateId`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlanDatesJoin value) {
        stmt.bindLong(1, value.planId);
        stmt.bindLong(2, value.planDateId);
      }
    };
    this.__deletionAdapterOfPlan = new EntityDeletionOrUpdateAdapter<Plan>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Plan` WHERE `planId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Plan value) {
        stmt.bindLong(1, value.planId);
      }
    };
    this.__deletionAdapterOfPlanDate = new EntityDeletionOrUpdateAdapter<PlanDate>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PlanDate` WHERE `planDateId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlanDate value) {
        stmt.bindLong(1, value.planDateId);
      }
    };
    this.__deletionAdapterOfPlanDatesJoin = new EntityDeletionOrUpdateAdapter<PlanDatesJoin>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PlanDatesJoin` WHERE `planId` = ? AND `planDateId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlanDatesJoin value) {
        stmt.bindLong(1, value.planId);
        stmt.bindLong(2, value.planDateId);
      }
    };
    this.__updateAdapterOfPlan = new EntityDeletionOrUpdateAdapter<Plan>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Plan` SET `planId` = ?,`cost` = ?,`name` = ?,`isGeneratePlanType` = ? WHERE `planId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Plan value) {
        stmt.bindLong(1, value.planId);
        if (value.cost == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindDouble(2, value.cost);
        }
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        final Integer _tmp;
        _tmp = value.isGeneratePlanType == null ? null : (value.isGeneratePlanType ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        stmt.bindLong(5, value.planId);
      }
    };
    this.__updateAdapterOfPlanDate = new EntityDeletionOrUpdateAdapter<PlanDate>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PlanDate` SET `planDateId` = ?,`breakfast` = ?,`lunch` = ?,`dinner` = ?,`snack` = ?,`date` = ? WHERE `planDateId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlanDate value) {
        stmt.bindLong(1, value.planDateId);
        stmt.bindLong(2, value.breakfast);
        stmt.bindLong(3, value.lunch);
        stmt.bindLong(4, value.dinner);
        stmt.bindLong(5, value.snack);
        final Long _tmp;
        _tmp = Converters.dateToTimestamp(value.date);
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        stmt.bindLong(7, value.planDateId);
      }
    };
    this.__updateAdapterOfPlanDatesJoin = new EntityDeletionOrUpdateAdapter<PlanDatesJoin>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PlanDatesJoin` SET `planId` = ?,`planDateId` = ? WHERE `planId` = ? AND `planDateId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PlanDatesJoin value) {
        stmt.bindLong(1, value.planId);
        stmt.bindLong(2, value.planDateId);
        stmt.bindLong(3, value.planId);
        stmt.bindLong(4, value.planDateId);
      }
    };
  }

  @Override
  long insertPlan(final Plan plan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfPlan.insertAndReturnId(plan);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insertPlanDate(final PlanDate planDate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfPlanDate.insertAndReturnId(planDate);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertPlanDatesJoins(final PlanDatesJoin... planDatesJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfPlanDatesJoin.insertAndReturnIdsArray(planDatesJoins);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Plan plan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPlan.handle(plan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PlanDate planDate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPlanDate.handle(planDate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PlanDatesJoin planDatesJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPlanDatesJoin.handle(planDatesJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  void updatePlan(final Plan... plan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPlan.handleMultiple(plan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePlanDates(final PlanDate... planDate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPlanDate.handleMultiple(planDate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePlanDatesJoins(final PlanDatesJoin... planDatesJoins) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPlanDatesJoin.handleMultiple(planDatesJoins);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final CompletePlan plan) {
    __db.beginTransaction();
    try {
      CompletePlanDao_Impl.super.delete(plan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public CompletePlan GetPlan(final long id) {
    final String _sql = "SELECT * FROM `plan` WHERE planId=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "planId");
        final int _cursorIndexOfCost = CursorUtil.getColumnIndexOrThrow(_cursor, "cost");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfIsGeneratePlanType = CursorUtil.getColumnIndexOrThrow(_cursor, "isGeneratePlanType");
        final LongSparseArray<ArrayList<PlanDate>> _collectionDay = new LongSparseArray<ArrayList<PlanDate>>();
        while (_cursor.moveToNext()) {
          if (!_cursor.isNull(_cursorIndexOfPlanId)) {
            final long _tmpKey = _cursor.getLong(_cursorIndexOfPlanId);
            ArrayList<PlanDate> _tmpDayCollection = _collectionDay.get(_tmpKey);
            if (_tmpDayCollection == null) {
              _tmpDayCollection = new ArrayList<PlanDate>();
              _collectionDay.put(_tmpKey, _tmpDayCollection);
            }
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipPlanDateAscomExampleZestRoomEntitiesPlanDate(_collectionDay);
        final CompletePlan _result;
        if(_cursor.moveToFirst()) {
          final Plan _tmpPlan;
          if (! (_cursor.isNull(_cursorIndexOfPlanId) && _cursor.isNull(_cursorIndexOfCost) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfIsGeneratePlanType))) {
            final long _tmpPlanId;
            _tmpPlanId = _cursor.getLong(_cursorIndexOfPlanId);
            final Double _tmpCost;
            if (_cursor.isNull(_cursorIndexOfCost)) {
              _tmpCost = null;
            } else {
              _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Boolean _tmpIsGeneratePlanType;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsGeneratePlanType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsGeneratePlanType);
            }
            _tmpIsGeneratePlanType = _tmp == null ? null : _tmp != 0;
            _tmpPlan = new Plan(_tmpPlanId,_tmpCost,_tmpName,_tmpIsGeneratePlanType);
          }  else  {
            _tmpPlan = null;
          }
          ArrayList<PlanDate> _tmpDayCollection_1 = null;
          if (!_cursor.isNull(_cursorIndexOfPlanId)) {
            final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfPlanId);
            _tmpDayCollection_1 = _collectionDay.get(_tmpKey_1);
          }
          if (_tmpDayCollection_1 == null) {
            _tmpDayCollection_1 = new ArrayList<PlanDate>();
          }
          _result = new CompletePlan();
          _result.plan = _tmpPlan;
          _result.day = _tmpDayCollection_1;
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

  @Override
  public LiveData<CompletePlan> GetPlanAsync(final long id) {
    final String _sql = "SELECT * FROM `plan` WHERE planId=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"PlanDatesJoin","PlanDate","plan"}, true, new Callable<CompletePlan>() {
      @Override
      public CompletePlan call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "planId");
            final int _cursorIndexOfCost = CursorUtil.getColumnIndexOrThrow(_cursor, "cost");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfIsGeneratePlanType = CursorUtil.getColumnIndexOrThrow(_cursor, "isGeneratePlanType");
            final LongSparseArray<ArrayList<PlanDate>> _collectionDay = new LongSparseArray<ArrayList<PlanDate>>();
            while (_cursor.moveToNext()) {
              if (!_cursor.isNull(_cursorIndexOfPlanId)) {
                final long _tmpKey = _cursor.getLong(_cursorIndexOfPlanId);
                ArrayList<PlanDate> _tmpDayCollection = _collectionDay.get(_tmpKey);
                if (_tmpDayCollection == null) {
                  _tmpDayCollection = new ArrayList<PlanDate>();
                  _collectionDay.put(_tmpKey, _tmpDayCollection);
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipPlanDateAscomExampleZestRoomEntitiesPlanDate(_collectionDay);
            final CompletePlan _result;
            if(_cursor.moveToFirst()) {
              final Plan _tmpPlan;
              if (! (_cursor.isNull(_cursorIndexOfPlanId) && _cursor.isNull(_cursorIndexOfCost) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfIsGeneratePlanType))) {
                final long _tmpPlanId;
                _tmpPlanId = _cursor.getLong(_cursorIndexOfPlanId);
                final Double _tmpCost;
                if (_cursor.isNull(_cursorIndexOfCost)) {
                  _tmpCost = null;
                } else {
                  _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
                }
                final String _tmpName;
                if (_cursor.isNull(_cursorIndexOfName)) {
                  _tmpName = null;
                } else {
                  _tmpName = _cursor.getString(_cursorIndexOfName);
                }
                final Boolean _tmpIsGeneratePlanType;
                final Integer _tmp;
                if (_cursor.isNull(_cursorIndexOfIsGeneratePlanType)) {
                  _tmp = null;
                } else {
                  _tmp = _cursor.getInt(_cursorIndexOfIsGeneratePlanType);
                }
                _tmpIsGeneratePlanType = _tmp == null ? null : _tmp != 0;
                _tmpPlan = new Plan(_tmpPlanId,_tmpCost,_tmpName,_tmpIsGeneratePlanType);
              }  else  {
                _tmpPlan = null;
              }
              ArrayList<PlanDate> _tmpDayCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfPlanId)) {
                final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfPlanId);
                _tmpDayCollection_1 = _collectionDay.get(_tmpKey_1);
              }
              if (_tmpDayCollection_1 == null) {
                _tmpDayCollection_1 = new ArrayList<PlanDate>();
              }
              _result = new CompletePlan();
              _result.plan = _tmpPlan;
              _result.day = _tmpDayCollection_1;
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CompletePlan>> GetAllCompletePlanAsync() {
    final String _sql = "SELECT * FROM `plan`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"PlanDatesJoin","PlanDate","plan"}, true, new Callable<List<CompletePlan>>() {
      @Override
      public List<CompletePlan> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "planId");
            final int _cursorIndexOfCost = CursorUtil.getColumnIndexOrThrow(_cursor, "cost");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfIsGeneratePlanType = CursorUtil.getColumnIndexOrThrow(_cursor, "isGeneratePlanType");
            final LongSparseArray<ArrayList<PlanDate>> _collectionDay = new LongSparseArray<ArrayList<PlanDate>>();
            while (_cursor.moveToNext()) {
              if (!_cursor.isNull(_cursorIndexOfPlanId)) {
                final long _tmpKey = _cursor.getLong(_cursorIndexOfPlanId);
                ArrayList<PlanDate> _tmpDayCollection = _collectionDay.get(_tmpKey);
                if (_tmpDayCollection == null) {
                  _tmpDayCollection = new ArrayList<PlanDate>();
                  _collectionDay.put(_tmpKey, _tmpDayCollection);
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipPlanDateAscomExampleZestRoomEntitiesPlanDate(_collectionDay);
            final List<CompletePlan> _result = new ArrayList<CompletePlan>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final CompletePlan _item;
              final Plan _tmpPlan;
              if (! (_cursor.isNull(_cursorIndexOfPlanId) && _cursor.isNull(_cursorIndexOfCost) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfIsGeneratePlanType))) {
                final long _tmpPlanId;
                _tmpPlanId = _cursor.getLong(_cursorIndexOfPlanId);
                final Double _tmpCost;
                if (_cursor.isNull(_cursorIndexOfCost)) {
                  _tmpCost = null;
                } else {
                  _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
                }
                final String _tmpName;
                if (_cursor.isNull(_cursorIndexOfName)) {
                  _tmpName = null;
                } else {
                  _tmpName = _cursor.getString(_cursorIndexOfName);
                }
                final Boolean _tmpIsGeneratePlanType;
                final Integer _tmp;
                if (_cursor.isNull(_cursorIndexOfIsGeneratePlanType)) {
                  _tmp = null;
                } else {
                  _tmp = _cursor.getInt(_cursorIndexOfIsGeneratePlanType);
                }
                _tmpIsGeneratePlanType = _tmp == null ? null : _tmp != 0;
                _tmpPlan = new Plan(_tmpPlanId,_tmpCost,_tmpName,_tmpIsGeneratePlanType);
              }  else  {
                _tmpPlan = null;
              }
              ArrayList<PlanDate> _tmpDayCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfPlanId)) {
                final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfPlanId);
                _tmpDayCollection_1 = _collectionDay.get(_tmpKey_1);
              }
              if (_tmpDayCollection_1 == null) {
                _tmpDayCollection_1 = new ArrayList<PlanDate>();
              }
              _item = new CompletePlan();
              _item.plan = _tmpPlan;
              _item.day = _tmpDayCollection_1;
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<CompletePlan> GetAllCompletePlan() {
    final String _sql = "SELECT * FROM `plan`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "planId");
        final int _cursorIndexOfCost = CursorUtil.getColumnIndexOrThrow(_cursor, "cost");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfIsGeneratePlanType = CursorUtil.getColumnIndexOrThrow(_cursor, "isGeneratePlanType");
        final LongSparseArray<ArrayList<PlanDate>> _collectionDay = new LongSparseArray<ArrayList<PlanDate>>();
        while (_cursor.moveToNext()) {
          if (!_cursor.isNull(_cursorIndexOfPlanId)) {
            final long _tmpKey = _cursor.getLong(_cursorIndexOfPlanId);
            ArrayList<PlanDate> _tmpDayCollection = _collectionDay.get(_tmpKey);
            if (_tmpDayCollection == null) {
              _tmpDayCollection = new ArrayList<PlanDate>();
              _collectionDay.put(_tmpKey, _tmpDayCollection);
            }
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshipPlanDateAscomExampleZestRoomEntitiesPlanDate(_collectionDay);
        final List<CompletePlan> _result = new ArrayList<CompletePlan>(_cursor.getCount());
        while(_cursor.moveToNext()) {
          final CompletePlan _item;
          final Plan _tmpPlan;
          if (! (_cursor.isNull(_cursorIndexOfPlanId) && _cursor.isNull(_cursorIndexOfCost) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfIsGeneratePlanType))) {
            final long _tmpPlanId;
            _tmpPlanId = _cursor.getLong(_cursorIndexOfPlanId);
            final Double _tmpCost;
            if (_cursor.isNull(_cursorIndexOfCost)) {
              _tmpCost = null;
            } else {
              _tmpCost = _cursor.getDouble(_cursorIndexOfCost);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Boolean _tmpIsGeneratePlanType;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsGeneratePlanType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsGeneratePlanType);
            }
            _tmpIsGeneratePlanType = _tmp == null ? null : _tmp != 0;
            _tmpPlan = new Plan(_tmpPlanId,_tmpCost,_tmpName,_tmpIsGeneratePlanType);
          }  else  {
            _tmpPlan = null;
          }
          ArrayList<PlanDate> _tmpDayCollection_1 = null;
          if (!_cursor.isNull(_cursorIndexOfPlanId)) {
            final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfPlanId);
            _tmpDayCollection_1 = _collectionDay.get(_tmpKey_1);
          }
          if (_tmpDayCollection_1 == null) {
            _tmpDayCollection_1 = new ArrayList<PlanDate>();
          }
          _item = new CompletePlan();
          _item.plan = _tmpPlan;
          _item.day = _tmpDayCollection_1;
          _result.add(_item);
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

  @Override
  public PlanDate GetPlanDates(final long id) {
    final String _sql = "SELECT * FROM plandate WHERE planDateId=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPlanDateId = CursorUtil.getColumnIndexOrThrow(_cursor, "planDateId");
      final int _cursorIndexOfBreakfast = CursorUtil.getColumnIndexOrThrow(_cursor, "breakfast");
      final int _cursorIndexOfLunch = CursorUtil.getColumnIndexOrThrow(_cursor, "lunch");
      final int _cursorIndexOfDinner = CursorUtil.getColumnIndexOrThrow(_cursor, "dinner");
      final int _cursorIndexOfSnack = CursorUtil.getColumnIndexOrThrow(_cursor, "snack");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final PlanDate _result;
      if(_cursor.moveToFirst()) {
        final long _tmpPlanDateId;
        _tmpPlanDateId = _cursor.getLong(_cursorIndexOfPlanDateId);
        final long _tmpBreakfast;
        _tmpBreakfast = _cursor.getLong(_cursorIndexOfBreakfast);
        final long _tmpLunch;
        _tmpLunch = _cursor.getLong(_cursorIndexOfLunch);
        final long _tmpDinner;
        _tmpDinner = _cursor.getLong(_cursorIndexOfDinner);
        final long _tmpSnack;
        _tmpSnack = _cursor.getLong(_cursorIndexOfSnack);
        final Date _tmpDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDate);
        }
        _tmpDate = Converters.fromTimestamp(_tmp);
        _result = new PlanDate(_tmpPlanDateId,_tmpBreakfast,_tmpLunch,_tmpDinner,_tmpSnack,_tmpDate);
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
  public List<PlanDatesJoin> GetPlanDateJoins() {
    final String _sql = "select * from plandatesjoin";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPlanId = CursorUtil.getColumnIndexOrThrow(_cursor, "planId");
      final int _cursorIndexOfPlanDateId = CursorUtil.getColumnIndexOrThrow(_cursor, "planDateId");
      final List<PlanDatesJoin> _result = new ArrayList<PlanDatesJoin>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PlanDatesJoin _item;
        final long _tmpPlanId;
        _tmpPlanId = _cursor.getLong(_cursorIndexOfPlanId);
        final long _tmpPlanDateId;
        _tmpPlanDateId = _cursor.getLong(_cursorIndexOfPlanDateId);
        _item = new PlanDatesJoin(_tmpPlanId,_tmpPlanDateId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipPlanDateAscomExampleZestRoomEntitiesPlanDate(
      final LongSparseArray<ArrayList<PlanDate>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<PlanDate>> _tmpInnerMap = new LongSparseArray<ArrayList<PlanDate>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipPlanDateAscomExampleZestRoomEntitiesPlanDate(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<PlanDate>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipPlanDateAscomExampleZestRoomEntitiesPlanDate(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `PlanDate`.`planDateId` AS `planDateId`,`PlanDate`.`breakfast` AS `breakfast`,`PlanDate`.`lunch` AS `lunch`,`PlanDate`.`dinner` AS `dinner`,`PlanDate`.`snack` AS `snack`,`PlanDate`.`date` AS `date`,_junction.`planId` FROM `PlanDatesJoin` AS _junction INNER JOIN `PlanDate` ON (_junction.`planDateId` = `PlanDate`.`planDateId`) WHERE _junction.`planId` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = 6; // _junction.planId;
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfPlanDateId = CursorUtil.getColumnIndexOrThrow(_cursor, "planDateId");
      final int _cursorIndexOfBreakfast = CursorUtil.getColumnIndexOrThrow(_cursor, "breakfast");
      final int _cursorIndexOfLunch = CursorUtil.getColumnIndexOrThrow(_cursor, "lunch");
      final int _cursorIndexOfDinner = CursorUtil.getColumnIndexOrThrow(_cursor, "dinner");
      final int _cursorIndexOfSnack = CursorUtil.getColumnIndexOrThrow(_cursor, "snack");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final long _tmpKey = _cursor.getLong(_itemKeyIndex);
          ArrayList<PlanDate> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final PlanDate _item_1;
            final long _tmpPlanDateId;
            _tmpPlanDateId = _cursor.getLong(_cursorIndexOfPlanDateId);
            final long _tmpBreakfast;
            _tmpBreakfast = _cursor.getLong(_cursorIndexOfBreakfast);
            final long _tmpLunch;
            _tmpLunch = _cursor.getLong(_cursorIndexOfLunch);
            final long _tmpDinner;
            _tmpDinner = _cursor.getLong(_cursorIndexOfDinner);
            final long _tmpSnack;
            _tmpSnack = _cursor.getLong(_cursorIndexOfSnack);
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = Converters.fromTimestamp(_tmp);
            _item_1 = new PlanDate(_tmpPlanDateId,_tmpBreakfast,_tmpLunch,_tmpDinner,_tmpSnack,_tmpDate);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
