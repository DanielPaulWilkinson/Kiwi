package com.example.zest.room.general;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.zest.room.interfaces.CompleteMealDao;
import com.example.zest.room.interfaces.CompleteMealDao_Impl;
import com.example.zest.room.interfaces.CompletePlanDao;
import com.example.zest.room.interfaces.CompletePlanDao_Impl;
import com.example.zest.room.interfaces.IngredientsDao;
import com.example.zest.room.interfaces.IngredientsDao_Impl;
import com.example.zest.room.interfaces.MealDao;
import com.example.zest.room.interfaces.MealDao_Impl;
import com.example.zest.room.interfaces.MealIngredientsJoinDao;
import com.example.zest.room.interfaces.MealIngredientsJoinDao_Impl;
import com.example.zest.room.interfaces.MealMethodJoinDao;
import com.example.zest.room.interfaces.MealMethodJoinDao_Impl;
import com.example.zest.room.interfaces.MethodDao;
import com.example.zest.room.interfaces.MethodDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDB_Impl extends RoomDB {
  private volatile MealDao _mealDao;

  private volatile CompletePlanDao _completePlanDao;

  private volatile IngredientsDao _ingredientsDao;

  private volatile MethodDao _methodDao;

  private volatile MealIngredientsJoinDao _mealIngredientsJoinDao;

  private volatile CompleteMealDao _completeMealDao;

  private volatile MealMethodJoinDao _mealMethodJoinDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Meal` (`mealId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `cheap` INTEGER, `healthScore` REAL, `vegetarian` INTEGER, `vegan` INTEGER, `glutenFree` INTEGER, `veryHealthy` INTEGER, `dairyFree` INTEGER, `veryPopular` INTEGER, `sustainable` INTEGER, `pricePerServing` REAL, `spoonId` INTEGER, `servings` INTEGER NOT NULL, `sourceUrl` TEXT, `summary` TEXT, `image` TEXT, `readyInMinutes` INTEGER NOT NULL, `diets` TEXT, `dishTypes` TEXT, `occasions` TEXT, `likes` TEXT, `usedIngredientCount` TEXT, `cuisines` TEXT, `isSpoonacularMeal` INTEGER, `totalCalories` REAL, `timeOfDay` INTEGER, `complexity` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MealIngredientsJoin` (`mealId` INTEGER NOT NULL, `ingredientsId` INTEGER NOT NULL, `amount` REAL NOT NULL, PRIMARY KEY(`mealId`, `ingredientsId`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_MealIngredientsJoin_mealId` ON `MealIngredientsJoin` (`mealId`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_MealIngredientsJoin_ingredientsId` ON `MealIngredientsJoin` (`ingredientsId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Ingredients` (`ingredientsId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `spoonId` INTEGER, `name` TEXT, `description` TEXT, `brand` TEXT, `aisle` TEXT, `nameClean` TEXT, `original` TEXT, `consistency` TEXT, `freezable` INTEGER NOT NULL, `microwaveable` INTEGER NOT NULL, `vegan` INTEGER NOT NULL, `glutenFree` INTEGER NOT NULL, `servingSize` REAL, `unit` TEXT, `energy` REAL, `fat` REAL, `ofWhichSaturates` REAL, `fiber` REAL, `protein` REAL, `salt` REAL, `calories` REAL, `sugar` REAL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MealMethodJoin` (`mealId` INTEGER NOT NULL, `methodId` INTEGER NOT NULL, PRIMARY KEY(`mealId`, `methodId`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_MealMethodJoin_mealId` ON `MealMethodJoin` (`mealId`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_MealMethodJoin_methodId` ON `MealMethodJoin` (`methodId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Method` (`methodId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `method` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Plan` (`planId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cost` REAL, `name` TEXT, `isGeneratePlanType` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PlanDate` (`planDateId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `breakfast` INTEGER NOT NULL, `lunch` INTEGER NOT NULL, `dinner` INTEGER NOT NULL, `snack` INTEGER NOT NULL, `date` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PlanDatesJoin` (`planId` INTEGER NOT NULL, `planDateId` INTEGER NOT NULL, PRIMARY KEY(`planId`, `planDateId`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_PlanDatesJoin_planId` ON `PlanDatesJoin` (`planId`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_PlanDatesJoin_planDateId` ON `PlanDatesJoin` (`planDateId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f0cd2695d3684dd25ca4d2a339f656c5')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Meal`");
        _db.execSQL("DROP TABLE IF EXISTS `MealIngredientsJoin`");
        _db.execSQL("DROP TABLE IF EXISTS `Ingredients`");
        _db.execSQL("DROP TABLE IF EXISTS `MealMethodJoin`");
        _db.execSQL("DROP TABLE IF EXISTS `Method`");
        _db.execSQL("DROP TABLE IF EXISTS `Plan`");
        _db.execSQL("DROP TABLE IF EXISTS `PlanDate`");
        _db.execSQL("DROP TABLE IF EXISTS `PlanDatesJoin`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMeal = new HashMap<String, TableInfo.Column>(28);
        _columnsMeal.put("mealId", new TableInfo.Column("mealId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("cheap", new TableInfo.Column("cheap", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("healthScore", new TableInfo.Column("healthScore", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("vegetarian", new TableInfo.Column("vegetarian", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("vegan", new TableInfo.Column("vegan", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("glutenFree", new TableInfo.Column("glutenFree", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("veryHealthy", new TableInfo.Column("veryHealthy", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("dairyFree", new TableInfo.Column("dairyFree", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("veryPopular", new TableInfo.Column("veryPopular", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("sustainable", new TableInfo.Column("sustainable", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("pricePerServing", new TableInfo.Column("pricePerServing", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("spoonId", new TableInfo.Column("spoonId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("servings", new TableInfo.Column("servings", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("sourceUrl", new TableInfo.Column("sourceUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("summary", new TableInfo.Column("summary", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("readyInMinutes", new TableInfo.Column("readyInMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("diets", new TableInfo.Column("diets", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("dishTypes", new TableInfo.Column("dishTypes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("occasions", new TableInfo.Column("occasions", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("likes", new TableInfo.Column("likes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("usedIngredientCount", new TableInfo.Column("usedIngredientCount", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("cuisines", new TableInfo.Column("cuisines", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("isSpoonacularMeal", new TableInfo.Column("isSpoonacularMeal", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("totalCalories", new TableInfo.Column("totalCalories", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("timeOfDay", new TableInfo.Column("timeOfDay", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeal.put("complexity", new TableInfo.Column("complexity", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeal = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMeal = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeal = new TableInfo("Meal", _columnsMeal, _foreignKeysMeal, _indicesMeal);
        final TableInfo _existingMeal = TableInfo.read(_db, "Meal");
        if (! _infoMeal.equals(_existingMeal)) {
          return new RoomOpenHelper.ValidationResult(false, "Meal(com.example.zest.room.entities.Meal).\n"
                  + " Expected:\n" + _infoMeal + "\n"
                  + " Found:\n" + _existingMeal);
        }
        final HashMap<String, TableInfo.Column> _columnsMealIngredientsJoin = new HashMap<String, TableInfo.Column>(3);
        _columnsMealIngredientsJoin.put("mealId", new TableInfo.Column("mealId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealIngredientsJoin.put("ingredientsId", new TableInfo.Column("ingredientsId", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealIngredientsJoin.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealIngredientsJoin = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealIngredientsJoin = new HashSet<TableInfo.Index>(2);
        _indicesMealIngredientsJoin.add(new TableInfo.Index("index_MealIngredientsJoin_mealId", false, Arrays.asList("mealId")));
        _indicesMealIngredientsJoin.add(new TableInfo.Index("index_MealIngredientsJoin_ingredientsId", false, Arrays.asList("ingredientsId")));
        final TableInfo _infoMealIngredientsJoin = new TableInfo("MealIngredientsJoin", _columnsMealIngredientsJoin, _foreignKeysMealIngredientsJoin, _indicesMealIngredientsJoin);
        final TableInfo _existingMealIngredientsJoin = TableInfo.read(_db, "MealIngredientsJoin");
        if (! _infoMealIngredientsJoin.equals(_existingMealIngredientsJoin)) {
          return new RoomOpenHelper.ValidationResult(false, "MealIngredientsJoin(com.example.zest.room.entities.MealIngredientsJoin).\n"
                  + " Expected:\n" + _infoMealIngredientsJoin + "\n"
                  + " Found:\n" + _existingMealIngredientsJoin);
        }
        final HashMap<String, TableInfo.Column> _columnsIngredients = new HashMap<String, TableInfo.Column>(23);
        _columnsIngredients.put("ingredientsId", new TableInfo.Column("ingredientsId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("spoonId", new TableInfo.Column("spoonId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("brand", new TableInfo.Column("brand", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("aisle", new TableInfo.Column("aisle", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("nameClean", new TableInfo.Column("nameClean", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("original", new TableInfo.Column("original", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("consistency", new TableInfo.Column("consistency", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("freezable", new TableInfo.Column("freezable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("microwaveable", new TableInfo.Column("microwaveable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("vegan", new TableInfo.Column("vegan", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("glutenFree", new TableInfo.Column("glutenFree", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("servingSize", new TableInfo.Column("servingSize", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("unit", new TableInfo.Column("unit", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("energy", new TableInfo.Column("energy", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("fat", new TableInfo.Column("fat", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("ofWhichSaturates", new TableInfo.Column("ofWhichSaturates", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("fiber", new TableInfo.Column("fiber", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("protein", new TableInfo.Column("protein", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("salt", new TableInfo.Column("salt", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("calories", new TableInfo.Column("calories", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIngredients.put("sugar", new TableInfo.Column("sugar", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIngredients = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIngredients = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIngredients = new TableInfo("Ingredients", _columnsIngredients, _foreignKeysIngredients, _indicesIngredients);
        final TableInfo _existingIngredients = TableInfo.read(_db, "Ingredients");
        if (! _infoIngredients.equals(_existingIngredients)) {
          return new RoomOpenHelper.ValidationResult(false, "Ingredients(com.example.zest.room.entities.Ingredients).\n"
                  + " Expected:\n" + _infoIngredients + "\n"
                  + " Found:\n" + _existingIngredients);
        }
        final HashMap<String, TableInfo.Column> _columnsMealMethodJoin = new HashMap<String, TableInfo.Column>(2);
        _columnsMealMethodJoin.put("mealId", new TableInfo.Column("mealId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealMethodJoin.put("methodId", new TableInfo.Column("methodId", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealMethodJoin = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealMethodJoin = new HashSet<TableInfo.Index>(2);
        _indicesMealMethodJoin.add(new TableInfo.Index("index_MealMethodJoin_mealId", false, Arrays.asList("mealId")));
        _indicesMealMethodJoin.add(new TableInfo.Index("index_MealMethodJoin_methodId", false, Arrays.asList("methodId")));
        final TableInfo _infoMealMethodJoin = new TableInfo("MealMethodJoin", _columnsMealMethodJoin, _foreignKeysMealMethodJoin, _indicesMealMethodJoin);
        final TableInfo _existingMealMethodJoin = TableInfo.read(_db, "MealMethodJoin");
        if (! _infoMealMethodJoin.equals(_existingMealMethodJoin)) {
          return new RoomOpenHelper.ValidationResult(false, "MealMethodJoin(com.example.zest.room.entities.MealMethodJoin).\n"
                  + " Expected:\n" + _infoMealMethodJoin + "\n"
                  + " Found:\n" + _existingMealMethodJoin);
        }
        final HashMap<String, TableInfo.Column> _columnsMethod = new HashMap<String, TableInfo.Column>(2);
        _columnsMethod.put("methodId", new TableInfo.Column("methodId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMethod.put("method", new TableInfo.Column("method", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMethod = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMethod = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMethod = new TableInfo("Method", _columnsMethod, _foreignKeysMethod, _indicesMethod);
        final TableInfo _existingMethod = TableInfo.read(_db, "Method");
        if (! _infoMethod.equals(_existingMethod)) {
          return new RoomOpenHelper.ValidationResult(false, "Method(com.example.zest.room.entities.Method).\n"
                  + " Expected:\n" + _infoMethod + "\n"
                  + " Found:\n" + _existingMethod);
        }
        final HashMap<String, TableInfo.Column> _columnsPlan = new HashMap<String, TableInfo.Column>(4);
        _columnsPlan.put("planId", new TableInfo.Column("planId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("cost", new TableInfo.Column("cost", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlan.put("isGeneratePlanType", new TableInfo.Column("isGeneratePlanType", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlan = new TableInfo("Plan", _columnsPlan, _foreignKeysPlan, _indicesPlan);
        final TableInfo _existingPlan = TableInfo.read(_db, "Plan");
        if (! _infoPlan.equals(_existingPlan)) {
          return new RoomOpenHelper.ValidationResult(false, "Plan(com.example.zest.room.entities.Plan).\n"
                  + " Expected:\n" + _infoPlan + "\n"
                  + " Found:\n" + _existingPlan);
        }
        final HashMap<String, TableInfo.Column> _columnsPlanDate = new HashMap<String, TableInfo.Column>(6);
        _columnsPlanDate.put("planDateId", new TableInfo.Column("planDateId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanDate.put("breakfast", new TableInfo.Column("breakfast", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanDate.put("lunch", new TableInfo.Column("lunch", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanDate.put("dinner", new TableInfo.Column("dinner", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanDate.put("snack", new TableInfo.Column("snack", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanDate.put("date", new TableInfo.Column("date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlanDate = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlanDate = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlanDate = new TableInfo("PlanDate", _columnsPlanDate, _foreignKeysPlanDate, _indicesPlanDate);
        final TableInfo _existingPlanDate = TableInfo.read(_db, "PlanDate");
        if (! _infoPlanDate.equals(_existingPlanDate)) {
          return new RoomOpenHelper.ValidationResult(false, "PlanDate(com.example.zest.room.entities.PlanDate).\n"
                  + " Expected:\n" + _infoPlanDate + "\n"
                  + " Found:\n" + _existingPlanDate);
        }
        final HashMap<String, TableInfo.Column> _columnsPlanDatesJoin = new HashMap<String, TableInfo.Column>(2);
        _columnsPlanDatesJoin.put("planId", new TableInfo.Column("planId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlanDatesJoin.put("planDateId", new TableInfo.Column("planDateId", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlanDatesJoin = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlanDatesJoin = new HashSet<TableInfo.Index>(2);
        _indicesPlanDatesJoin.add(new TableInfo.Index("index_PlanDatesJoin_planId", false, Arrays.asList("planId")));
        _indicesPlanDatesJoin.add(new TableInfo.Index("index_PlanDatesJoin_planDateId", false, Arrays.asList("planDateId")));
        final TableInfo _infoPlanDatesJoin = new TableInfo("PlanDatesJoin", _columnsPlanDatesJoin, _foreignKeysPlanDatesJoin, _indicesPlanDatesJoin);
        final TableInfo _existingPlanDatesJoin = TableInfo.read(_db, "PlanDatesJoin");
        if (! _infoPlanDatesJoin.equals(_existingPlanDatesJoin)) {
          return new RoomOpenHelper.ValidationResult(false, "PlanDatesJoin(com.example.zest.room.entities.PlanDatesJoin).\n"
                  + " Expected:\n" + _infoPlanDatesJoin + "\n"
                  + " Found:\n" + _existingPlanDatesJoin);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f0cd2695d3684dd25ca4d2a339f656c5", "de3c193a025f3d03efda098a9c3a81af");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Meal","MealIngredientsJoin","Ingredients","MealMethodJoin","Method","Plan","PlanDate","PlanDatesJoin");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Meal`");
      _db.execSQL("DELETE FROM `MealIngredientsJoin`");
      _db.execSQL("DELETE FROM `Ingredients`");
      _db.execSQL("DELETE FROM `MealMethodJoin`");
      _db.execSQL("DELETE FROM `Method`");
      _db.execSQL("DELETE FROM `Plan`");
      _db.execSQL("DELETE FROM `PlanDate`");
      _db.execSQL("DELETE FROM `PlanDatesJoin`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MealDao.class, MealDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CompletePlanDao.class, CompletePlanDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(IngredientsDao.class, IngredientsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MethodDao.class, MethodDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MealIngredientsJoinDao.class, MealIngredientsJoinDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CompleteMealDao.class, CompleteMealDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MealMethodJoinDao.class, MealMethodJoinDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  protected List<Migration> getAutoMigrations() {
    return Arrays.asList();
  }

  @Override
  public MealDao MealDao() {
    if (_mealDao != null) {
      return _mealDao;
    } else {
      synchronized(this) {
        if(_mealDao == null) {
          _mealDao = new MealDao_Impl(this);
        }
        return _mealDao;
      }
    }
  }

  @Override
  public CompletePlanDao PlanDao() {
    if (_completePlanDao != null) {
      return _completePlanDao;
    } else {
      synchronized(this) {
        if(_completePlanDao == null) {
          _completePlanDao = new CompletePlanDao_Impl(this);
        }
        return _completePlanDao;
      }
    }
  }

  @Override
  public IngredientsDao IngredientsDao() {
    if (_ingredientsDao != null) {
      return _ingredientsDao;
    } else {
      synchronized(this) {
        if(_ingredientsDao == null) {
          _ingredientsDao = new IngredientsDao_Impl(this);
        }
        return _ingredientsDao;
      }
    }
  }

  @Override
  public MethodDao MethodDao() {
    if (_methodDao != null) {
      return _methodDao;
    } else {
      synchronized(this) {
        if(_methodDao == null) {
          _methodDao = new MethodDao_Impl(this);
        }
        return _methodDao;
      }
    }
  }

  @Override
  public MealIngredientsJoinDao MealIngredientDao() {
    if (_mealIngredientsJoinDao != null) {
      return _mealIngredientsJoinDao;
    } else {
      synchronized(this) {
        if(_mealIngredientsJoinDao == null) {
          _mealIngredientsJoinDao = new MealIngredientsJoinDao_Impl(this);
        }
        return _mealIngredientsJoinDao;
      }
    }
  }

  @Override
  public CompleteMealDao completeMealDao() {
    if (_completeMealDao != null) {
      return _completeMealDao;
    } else {
      synchronized(this) {
        if(_completeMealDao == null) {
          _completeMealDao = new CompleteMealDao_Impl(this);
        }
        return _completeMealDao;
      }
    }
  }

  @Override
  public MealMethodJoinDao MealMethodDao() {
    if (_mealMethodJoinDao != null) {
      return _mealMethodJoinDao;
    } else {
      synchronized(this) {
        if(_mealMethodJoinDao == null) {
          _mealMethodJoinDao = new MealMethodJoinDao_Impl(this);
        }
        return _mealMethodJoinDao;
      }
    }
  }
}
