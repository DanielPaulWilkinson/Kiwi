package com.example.zest.room.interfaces;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.zest.room.entities.Ingredients;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IngredientsDao_Impl implements IngredientsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Ingredients> __insertionAdapterOfIngredients;

  private final EntityDeletionOrUpdateAdapter<Ingredients> __deletionAdapterOfIngredients;

  private final EntityDeletionOrUpdateAdapter<Ingredients> __updateAdapterOfIngredients;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public IngredientsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIngredients = new EntityInsertionAdapter<Ingredients>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Ingredients` (`ingredientsId`,`spoonId`,`name`,`description`,`brand`,`aisle`,`nameClean`,`original`,`consistency`,`freezable`,`microwaveable`,`vegan`,`glutenFree`,`servingSize`,`Units`,`energy`,`fat`,`ofWhichSaturates`,`fiber`,`protein`,`salt`,`calories`,`sugar`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ingredients value) {
        stmt.bindLong(1, value.ingredientsId);
        if (value.spoonId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.spoonId);
        }
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        if (value.description == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.description);
        }
        if (value.brand == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.brand);
        }
        if (value.aisle == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.aisle);
        }
        if (value.nameClean == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.nameClean);
        }
        if (value.original == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.original);
        }
        if (value.consistency == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.consistency);
        }
        final int _tmp;
        _tmp = value.freezable ? 1 : 0;
        stmt.bindLong(10, _tmp);
        final int _tmp_1;
        _tmp_1 = value.microwaveable ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.vegan ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        final int _tmp_3;
        _tmp_3 = value.glutenFree ? 1 : 0;
        stmt.bindLong(13, _tmp_3);
        if (value.servingSize == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindDouble(14, value.servingSize);
        }
        if (value.Units == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.Units);
        }
        if (value.energy == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindDouble(16, value.energy);
        }
        if (value.fat == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.fat);
        }
        if (value.ofWhichSaturates == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.ofWhichSaturates);
        }
        if (value.fiber == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindDouble(19, value.fiber);
        }
        if (value.protein == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.protein);
        }
        if (value.salt == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindDouble(21, value.salt);
        }
        if (value.calories == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.calories);
        }
        if (value.sugar == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindDouble(23, value.sugar);
        }
      }
    };
    this.__deletionAdapterOfIngredients = new EntityDeletionOrUpdateAdapter<Ingredients>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Ingredients` WHERE `ingredientsId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ingredients value) {
        stmt.bindLong(1, value.ingredientsId);
      }
    };
    this.__updateAdapterOfIngredients = new EntityDeletionOrUpdateAdapter<Ingredients>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Ingredients` SET `ingredientsId` = ?,`spoonId` = ?,`name` = ?,`description` = ?,`brand` = ?,`aisle` = ?,`nameClean` = ?,`original` = ?,`consistency` = ?,`freezable` = ?,`microwaveable` = ?,`vegan` = ?,`glutenFree` = ?,`servingSize` = ?,`Units` = ?,`energy` = ?,`fat` = ?,`ofWhichSaturates` = ?,`fiber` = ?,`protein` = ?,`salt` = ?,`calories` = ?,`sugar` = ? WHERE `ingredientsId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ingredients value) {
        stmt.bindLong(1, value.ingredientsId);
        if (value.spoonId == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.spoonId);
        }
        if (value.name == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.name);
        }
        if (value.description == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.description);
        }
        if (value.brand == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.brand);
        }
        if (value.aisle == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.aisle);
        }
        if (value.nameClean == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.nameClean);
        }
        if (value.original == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.original);
        }
        if (value.consistency == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.consistency);
        }
        final int _tmp;
        _tmp = value.freezable ? 1 : 0;
        stmt.bindLong(10, _tmp);
        final int _tmp_1;
        _tmp_1 = value.microwaveable ? 1 : 0;
        stmt.bindLong(11, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.vegan ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        final int _tmp_3;
        _tmp_3 = value.glutenFree ? 1 : 0;
        stmt.bindLong(13, _tmp_3);
        if (value.servingSize == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindDouble(14, value.servingSize);
        }
        if (value.Units == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.Units);
        }
        if (value.energy == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindDouble(16, value.energy);
        }
        if (value.fat == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.fat);
        }
        if (value.ofWhichSaturates == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.ofWhichSaturates);
        }
        if (value.fiber == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindDouble(19, value.fiber);
        }
        if (value.protein == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindDouble(20, value.protein);
        }
        if (value.salt == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindDouble(21, value.salt);
        }
        if (value.calories == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindDouble(22, value.calories);
        }
        if (value.sugar == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindDouble(23, value.sugar);
        }
        stmt.bindLong(24, value.ingredientsId);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ingredients";
        return _query;
      }
    };
  }

  @Override
  public long Create(final Ingredients ingredients) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfIngredients.insertAndReturnId(ingredients);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long[] insertIngredients(final List<Ingredients> ingredients) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long[] _result = __insertionAdapterOfIngredients.insertAndReturnIdsArray(ingredients);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Ingredients ingredients) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfIngredients.handle(ingredients);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateIngredients(final Ingredients... ingredients) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfIngredients.handleMultiple(ingredients);
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
  public Ingredients GetIngredient(final long id) {
    final String _sql = "SELECT * FROM ingredients WHERE ingredientsId=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
      try {
        final int _cursorIndexOfIngredientsId = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredientsId");
        final int _cursorIndexOfSpoonId = CursorUtil.getColumnIndexOrThrow(_cursor, "spoonId");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
        final int _cursorIndexOfBrand = CursorUtil.getColumnIndexOrThrow(_cursor, "brand");
        final int _cursorIndexOfAisle = CursorUtil.getColumnIndexOrThrow(_cursor, "aisle");
        final int _cursorIndexOfNameClean = CursorUtil.getColumnIndexOrThrow(_cursor, "nameClean");
        final int _cursorIndexOfOriginal = CursorUtil.getColumnIndexOrThrow(_cursor, "original");
        final int _cursorIndexOfConsistency = CursorUtil.getColumnIndexOrThrow(_cursor, "consistency");
        final int _cursorIndexOfFreezable = CursorUtil.getColumnIndexOrThrow(_cursor, "freezable");
        final int _cursorIndexOfMicrowaveable = CursorUtil.getColumnIndexOrThrow(_cursor, "microwaveable");
        final int _cursorIndexOfVegan = CursorUtil.getColumnIndexOrThrow(_cursor, "vegan");
        final int _cursorIndexOfGlutenFree = CursorUtil.getColumnIndexOrThrow(_cursor, "glutenFree");
        final int _cursorIndexOfServingSize = CursorUtil.getColumnIndexOrThrow(_cursor, "servingSize");
        final int _cursorIndexOfUnits = CursorUtil.getColumnIndexOrThrow(_cursor, "Units");
        final int _cursorIndexOfEnergy = CursorUtil.getColumnIndexOrThrow(_cursor, "energy");
        final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
        final int _cursorIndexOfOfWhichSaturates = CursorUtil.getColumnIndexOrThrow(_cursor, "ofWhichSaturates");
        final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
        final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
        final int _cursorIndexOfSalt = CursorUtil.getColumnIndexOrThrow(_cursor, "salt");
        final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
        final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
        final Ingredients _result;
        if(_cursor.moveToFirst()) {
          final long _tmpIngredientsId;
          _tmpIngredientsId = _cursor.getLong(_cursorIndexOfIngredientsId);
          final String _tmpName;
          _tmpName = _cursor.getString(_cursorIndexOfName);
          final String _tmpDescription;
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
          final String _tmpBrand;
          _tmpBrand = _cursor.getString(_cursorIndexOfBrand);
          final boolean _tmpFreezable;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfFreezable);
          _tmpFreezable = _tmp != 0;
          final boolean _tmpMicrowaveable;
          final int _tmp_1;
          _tmp_1 = _cursor.getInt(_cursorIndexOfMicrowaveable);
          _tmpMicrowaveable = _tmp_1 != 0;
          final boolean _tmpVegan;
          final int _tmp_2;
          _tmp_2 = _cursor.getInt(_cursorIndexOfVegan);
          _tmpVegan = _tmp_2 != 0;
          final boolean _tmpGlutenFree;
          final int _tmp_3;
          _tmp_3 = _cursor.getInt(_cursorIndexOfGlutenFree);
          _tmpGlutenFree = _tmp_3 != 0;
          final Double _tmpServingSize;
          if (_cursor.isNull(_cursorIndexOfServingSize)) {
            _tmpServingSize = null;
          } else {
            _tmpServingSize = _cursor.getDouble(_cursorIndexOfServingSize);
          }
          final String _tmpUnits;
          _tmpUnits = _cursor.getString(_cursorIndexOfUnits);
          final Double _tmpEnergy;
          if (_cursor.isNull(_cursorIndexOfEnergy)) {
            _tmpEnergy = null;
          } else {
            _tmpEnergy = _cursor.getDouble(_cursorIndexOfEnergy);
          }
          final Double _tmpFat;
          if (_cursor.isNull(_cursorIndexOfFat)) {
            _tmpFat = null;
          } else {
            _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
          }
          final Double _tmpOfWhichSaturates;
          if (_cursor.isNull(_cursorIndexOfOfWhichSaturates)) {
            _tmpOfWhichSaturates = null;
          } else {
            _tmpOfWhichSaturates = _cursor.getDouble(_cursorIndexOfOfWhichSaturates);
          }
          final Double _tmpFiber;
          if (_cursor.isNull(_cursorIndexOfFiber)) {
            _tmpFiber = null;
          } else {
            _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
          }
          final Double _tmpProtein;
          if (_cursor.isNull(_cursorIndexOfProtein)) {
            _tmpProtein = null;
          } else {
            _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
          }
          final Double _tmpSalt;
          if (_cursor.isNull(_cursorIndexOfSalt)) {
            _tmpSalt = null;
          } else {
            _tmpSalt = _cursor.getDouble(_cursorIndexOfSalt);
          }
          final Double _tmpCalories;
          if (_cursor.isNull(_cursorIndexOfCalories)) {
            _tmpCalories = null;
          } else {
            _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
          }
          final Double _tmpSugar;
          if (_cursor.isNull(_cursorIndexOfSugar)) {
            _tmpSugar = null;
          } else {
            _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
          }
          _result = new Ingredients(_tmpIngredientsId,_tmpName,_tmpDescription,_tmpBrand,_tmpServingSize,_tmpUnits,_tmpCalories,_tmpEnergy,_tmpFat,_tmpOfWhichSaturates,_tmpFiber,_tmpProtein,_tmpSalt,_tmpSugar,_tmpFreezable,_tmpMicrowaveable,_tmpVegan,_tmpGlutenFree);
          if (_cursor.isNull(_cursorIndexOfSpoonId)) {
            _result.spoonId = null;
          } else {
            _result.spoonId = _cursor.getLong(_cursorIndexOfSpoonId);
          }
          _result.aisle = _cursor.getString(_cursorIndexOfAisle);
          _result.nameClean = _cursor.getString(_cursorIndexOfNameClean);
          _result.original = _cursor.getString(_cursorIndexOfOriginal);
          _result.consistency = _cursor.getString(_cursorIndexOfConsistency);
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
  public List<Ingredients> GetIngredients() {
    final String _sql = "SELECT * FROM ingredients";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIngredientsId = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredientsId");
      final int _cursorIndexOfSpoonId = CursorUtil.getColumnIndexOrThrow(_cursor, "spoonId");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfBrand = CursorUtil.getColumnIndexOrThrow(_cursor, "brand");
      final int _cursorIndexOfAisle = CursorUtil.getColumnIndexOrThrow(_cursor, "aisle");
      final int _cursorIndexOfNameClean = CursorUtil.getColumnIndexOrThrow(_cursor, "nameClean");
      final int _cursorIndexOfOriginal = CursorUtil.getColumnIndexOrThrow(_cursor, "original");
      final int _cursorIndexOfConsistency = CursorUtil.getColumnIndexOrThrow(_cursor, "consistency");
      final int _cursorIndexOfFreezable = CursorUtil.getColumnIndexOrThrow(_cursor, "freezable");
      final int _cursorIndexOfMicrowaveable = CursorUtil.getColumnIndexOrThrow(_cursor, "microwaveable");
      final int _cursorIndexOfVegan = CursorUtil.getColumnIndexOrThrow(_cursor, "vegan");
      final int _cursorIndexOfGlutenFree = CursorUtil.getColumnIndexOrThrow(_cursor, "glutenFree");
      final int _cursorIndexOfServingSize = CursorUtil.getColumnIndexOrThrow(_cursor, "servingSize");
      final int _cursorIndexOfUnits = CursorUtil.getColumnIndexOrThrow(_cursor, "Units");
      final int _cursorIndexOfEnergy = CursorUtil.getColumnIndexOrThrow(_cursor, "energy");
      final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
      final int _cursorIndexOfOfWhichSaturates = CursorUtil.getColumnIndexOrThrow(_cursor, "ofWhichSaturates");
      final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
      final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
      final int _cursorIndexOfSalt = CursorUtil.getColumnIndexOrThrow(_cursor, "salt");
      final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
      final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
      final List<Ingredients> _result = new ArrayList<Ingredients>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ingredients _item;
        final long _tmpIngredientsId;
        _tmpIngredientsId = _cursor.getLong(_cursorIndexOfIngredientsId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpBrand;
        _tmpBrand = _cursor.getString(_cursorIndexOfBrand);
        final boolean _tmpFreezable;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfFreezable);
        _tmpFreezable = _tmp != 0;
        final boolean _tmpMicrowaveable;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfMicrowaveable);
        _tmpMicrowaveable = _tmp_1 != 0;
        final boolean _tmpVegan;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfVegan);
        _tmpVegan = _tmp_2 != 0;
        final boolean _tmpGlutenFree;
        final int _tmp_3;
        _tmp_3 = _cursor.getInt(_cursorIndexOfGlutenFree);
        _tmpGlutenFree = _tmp_3 != 0;
        final Double _tmpServingSize;
        if (_cursor.isNull(_cursorIndexOfServingSize)) {
          _tmpServingSize = null;
        } else {
          _tmpServingSize = _cursor.getDouble(_cursorIndexOfServingSize);
        }
        final String _tmpUnits;
        _tmpUnits = _cursor.getString(_cursorIndexOfUnits);
        final Double _tmpEnergy;
        if (_cursor.isNull(_cursorIndexOfEnergy)) {
          _tmpEnergy = null;
        } else {
          _tmpEnergy = _cursor.getDouble(_cursorIndexOfEnergy);
        }
        final Double _tmpFat;
        if (_cursor.isNull(_cursorIndexOfFat)) {
          _tmpFat = null;
        } else {
          _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
        }
        final Double _tmpOfWhichSaturates;
        if (_cursor.isNull(_cursorIndexOfOfWhichSaturates)) {
          _tmpOfWhichSaturates = null;
        } else {
          _tmpOfWhichSaturates = _cursor.getDouble(_cursorIndexOfOfWhichSaturates);
        }
        final Double _tmpFiber;
        if (_cursor.isNull(_cursorIndexOfFiber)) {
          _tmpFiber = null;
        } else {
          _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
        }
        final Double _tmpProtein;
        if (_cursor.isNull(_cursorIndexOfProtein)) {
          _tmpProtein = null;
        } else {
          _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
        }
        final Double _tmpSalt;
        if (_cursor.isNull(_cursorIndexOfSalt)) {
          _tmpSalt = null;
        } else {
          _tmpSalt = _cursor.getDouble(_cursorIndexOfSalt);
        }
        final Double _tmpCalories;
        if (_cursor.isNull(_cursorIndexOfCalories)) {
          _tmpCalories = null;
        } else {
          _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
        }
        final Double _tmpSugar;
        if (_cursor.isNull(_cursorIndexOfSugar)) {
          _tmpSugar = null;
        } else {
          _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
        }
        _item = new Ingredients(_tmpIngredientsId,_tmpName,_tmpDescription,_tmpBrand,_tmpServingSize,_tmpUnits,_tmpCalories,_tmpEnergy,_tmpFat,_tmpOfWhichSaturates,_tmpFiber,_tmpProtein,_tmpSalt,_tmpSugar,_tmpFreezable,_tmpMicrowaveable,_tmpVegan,_tmpGlutenFree);
        if (_cursor.isNull(_cursorIndexOfSpoonId)) {
          _item.spoonId = null;
        } else {
          _item.spoonId = _cursor.getLong(_cursorIndexOfSpoonId);
        }
        _item.aisle = _cursor.getString(_cursorIndexOfAisle);
        _item.nameClean = _cursor.getString(_cursorIndexOfNameClean);
        _item.original = _cursor.getString(_cursorIndexOfOriginal);
        _item.consistency = _cursor.getString(_cursorIndexOfConsistency);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Ingredients>> GetIngredientsLiveData() {
    final String _sql = "SELECT * FROM ingredients";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"ingredients"}, false, new Callable<List<Ingredients>>() {
      @Override
      public List<Ingredients> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIngredientsId = CursorUtil.getColumnIndexOrThrow(_cursor, "ingredientsId");
          final int _cursorIndexOfSpoonId = CursorUtil.getColumnIndexOrThrow(_cursor, "spoonId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfBrand = CursorUtil.getColumnIndexOrThrow(_cursor, "brand");
          final int _cursorIndexOfAisle = CursorUtil.getColumnIndexOrThrow(_cursor, "aisle");
          final int _cursorIndexOfNameClean = CursorUtil.getColumnIndexOrThrow(_cursor, "nameClean");
          final int _cursorIndexOfOriginal = CursorUtil.getColumnIndexOrThrow(_cursor, "original");
          final int _cursorIndexOfConsistency = CursorUtil.getColumnIndexOrThrow(_cursor, "consistency");
          final int _cursorIndexOfFreezable = CursorUtil.getColumnIndexOrThrow(_cursor, "freezable");
          final int _cursorIndexOfMicrowaveable = CursorUtil.getColumnIndexOrThrow(_cursor, "microwaveable");
          final int _cursorIndexOfVegan = CursorUtil.getColumnIndexOrThrow(_cursor, "vegan");
          final int _cursorIndexOfGlutenFree = CursorUtil.getColumnIndexOrThrow(_cursor, "glutenFree");
          final int _cursorIndexOfServingSize = CursorUtil.getColumnIndexOrThrow(_cursor, "servingSize");
          final int _cursorIndexOfUnits = CursorUtil.getColumnIndexOrThrow(_cursor, "Units");
          final int _cursorIndexOfEnergy = CursorUtil.getColumnIndexOrThrow(_cursor, "energy");
          final int _cursorIndexOfFat = CursorUtil.getColumnIndexOrThrow(_cursor, "fat");
          final int _cursorIndexOfOfWhichSaturates = CursorUtil.getColumnIndexOrThrow(_cursor, "ofWhichSaturates");
          final int _cursorIndexOfFiber = CursorUtil.getColumnIndexOrThrow(_cursor, "fiber");
          final int _cursorIndexOfProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "protein");
          final int _cursorIndexOfSalt = CursorUtil.getColumnIndexOrThrow(_cursor, "salt");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfSugar = CursorUtil.getColumnIndexOrThrow(_cursor, "sugar");
          final List<Ingredients> _result = new ArrayList<Ingredients>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Ingredients _item;
            final long _tmpIngredientsId;
            _tmpIngredientsId = _cursor.getLong(_cursorIndexOfIngredientsId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpBrand;
            _tmpBrand = _cursor.getString(_cursorIndexOfBrand);
            final boolean _tmpFreezable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFreezable);
            _tmpFreezable = _tmp != 0;
            final boolean _tmpMicrowaveable;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfMicrowaveable);
            _tmpMicrowaveable = _tmp_1 != 0;
            final boolean _tmpVegan;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfVegan);
            _tmpVegan = _tmp_2 != 0;
            final boolean _tmpGlutenFree;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfGlutenFree);
            _tmpGlutenFree = _tmp_3 != 0;
            final Double _tmpServingSize;
            if (_cursor.isNull(_cursorIndexOfServingSize)) {
              _tmpServingSize = null;
            } else {
              _tmpServingSize = _cursor.getDouble(_cursorIndexOfServingSize);
            }
            final String _tmpUnits;
            _tmpUnits = _cursor.getString(_cursorIndexOfUnits);
            final Double _tmpEnergy;
            if (_cursor.isNull(_cursorIndexOfEnergy)) {
              _tmpEnergy = null;
            } else {
              _tmpEnergy = _cursor.getDouble(_cursorIndexOfEnergy);
            }
            final Double _tmpFat;
            if (_cursor.isNull(_cursorIndexOfFat)) {
              _tmpFat = null;
            } else {
              _tmpFat = _cursor.getDouble(_cursorIndexOfFat);
            }
            final Double _tmpOfWhichSaturates;
            if (_cursor.isNull(_cursorIndexOfOfWhichSaturates)) {
              _tmpOfWhichSaturates = null;
            } else {
              _tmpOfWhichSaturates = _cursor.getDouble(_cursorIndexOfOfWhichSaturates);
            }
            final Double _tmpFiber;
            if (_cursor.isNull(_cursorIndexOfFiber)) {
              _tmpFiber = null;
            } else {
              _tmpFiber = _cursor.getDouble(_cursorIndexOfFiber);
            }
            final Double _tmpProtein;
            if (_cursor.isNull(_cursorIndexOfProtein)) {
              _tmpProtein = null;
            } else {
              _tmpProtein = _cursor.getDouble(_cursorIndexOfProtein);
            }
            final Double _tmpSalt;
            if (_cursor.isNull(_cursorIndexOfSalt)) {
              _tmpSalt = null;
            } else {
              _tmpSalt = _cursor.getDouble(_cursorIndexOfSalt);
            }
            final Double _tmpCalories;
            if (_cursor.isNull(_cursorIndexOfCalories)) {
              _tmpCalories = null;
            } else {
              _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
            }
            final Double _tmpSugar;
            if (_cursor.isNull(_cursorIndexOfSugar)) {
              _tmpSugar = null;
            } else {
              _tmpSugar = _cursor.getDouble(_cursorIndexOfSugar);
            }
            _item = new Ingredients(_tmpIngredientsId,_tmpName,_tmpDescription,_tmpBrand,_tmpServingSize,_tmpUnits,_tmpCalories,_tmpEnergy,_tmpFat,_tmpOfWhichSaturates,_tmpFiber,_tmpProtein,_tmpSalt,_tmpSugar,_tmpFreezable,_tmpMicrowaveable,_tmpVegan,_tmpGlutenFree);
            if (_cursor.isNull(_cursorIndexOfSpoonId)) {
              _item.spoonId = null;
            } else {
              _item.spoonId = _cursor.getLong(_cursorIndexOfSpoonId);
            }
            _item.aisle = _cursor.getString(_cursorIndexOfAisle);
            _item.nameClean = _cursor.getString(_cursorIndexOfNameClean);
            _item.original = _cursor.getString(_cursorIndexOfOriginal);
            _item.consistency = _cursor.getString(_cursorIndexOfConsistency);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
