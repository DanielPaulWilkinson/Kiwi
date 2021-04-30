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
import com.example.zest.enums.ComplexityEnum;
import com.example.zest.enums.TimeOfDayEnum;
import com.example.zest.room.entities.Ingredients;
import com.example.zest.room.entities.Meal;
import com.example.zest.room.entities.MealIngredientsJoin;
import com.example.zest.room.entities.MealMethodJoin;
import com.example.zest.room.entities.Method;
import com.example.zest.room.general.Converters;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MealDao_Impl implements MealDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Method> __insertionAdapterOfMethod;

  private final EntityInsertionAdapter<MealMethodJoin> __insertionAdapterOfMealMethodJoin;

  private final EntityInsertionAdapter<MealIngredientsJoin> __insertionAdapterOfMealIngredientsJoin;

  private final EntityInsertionAdapter<Ingredients> __insertionAdapterOfIngredients;

  private final EntityInsertionAdapter<Meal> __insertionAdapterOfMeal;

  private final EntityDeletionOrUpdateAdapter<Method> __deletionAdapterOfMethod;

  private final EntityDeletionOrUpdateAdapter<MealMethodJoin> __deletionAdapterOfMealMethodJoin;

  private final EntityDeletionOrUpdateAdapter<MealIngredientsJoin> __deletionAdapterOfMealIngredientsJoin;

  private final EntityDeletionOrUpdateAdapter<Ingredients> __deletionAdapterOfIngredients;

  private final EntityDeletionOrUpdateAdapter<Meal> __deletionAdapterOfMeal;

  private final EntityDeletionOrUpdateAdapter<Method> __updateAdapterOfMethod;

  private final EntityDeletionOrUpdateAdapter<MealMethodJoin> __updateAdapterOfMealMethodJoin;

  private final EntityDeletionOrUpdateAdapter<MealIngredientsJoin> __updateAdapterOfMealIngredientsJoin;

  private final EntityDeletionOrUpdateAdapter<Ingredients> __updateAdapterOfIngredients;

  private final EntityDeletionOrUpdateAdapter<Meal> __updateAdapterOfMeal;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MealDao_Impl(RoomDatabase __db) {
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
    this.__insertionAdapterOfMeal = new EntityInsertionAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Meal` (`mealId`,`title`,`cheap`,`healthScore`,`vegetarian`,`vegan`,`glutenFree`,`veryHealthy`,`dairyFree`,`veryPopular`,`sustainable`,`pricePerServing`,`spoonId`,`servings`,`sourceUrl`,`summary`,`image`,`readyInMinutes`,`diets`,`dishTypes`,`occasions`,`likes`,`usedIngredientCount`,`cuisines`,`timeOfDay`,`complexity`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        stmt.bindLong(1, value.mealId);
        if (value.title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.title);
        }
        final Integer _tmp;
        _tmp = value.cheap == null ? null : (value.cheap ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.healthScore == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.healthScore);
        }
        final Integer _tmp_1;
        _tmp_1 = value.vegetarian == null ? null : (value.vegetarian ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
        final Integer _tmp_2;
        _tmp_2 = value.vegan == null ? null : (value.vegan ? 1 : 0);
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_2);
        }
        final Integer _tmp_3;
        _tmp_3 = value.glutenFree == null ? null : (value.glutenFree ? 1 : 0);
        if (_tmp_3 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_3);
        }
        final Integer _tmp_4;
        _tmp_4 = value.veryHealthy == null ? null : (value.veryHealthy ? 1 : 0);
        if (_tmp_4 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_4);
        }
        final Integer _tmp_5;
        _tmp_5 = value.dairyFree == null ? null : (value.dairyFree ? 1 : 0);
        if (_tmp_5 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_5);
        }
        final Integer _tmp_6;
        _tmp_6 = value.veryPopular == null ? null : (value.veryPopular ? 1 : 0);
        if (_tmp_6 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp_6);
        }
        final Integer _tmp_7;
        _tmp_7 = value.sustainable == null ? null : (value.sustainable ? 1 : 0);
        if (_tmp_7 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp_7);
        }
        if (value.pricePerServing == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.pricePerServing);
        }
        if (value.spoonId == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.spoonId);
        }
        stmt.bindLong(14, value.servings);
        if (value.sourceUrl == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.sourceUrl);
        }
        if (value.summary == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.summary);
        }
        if (value.image == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.image);
        }
        stmt.bindLong(18, value.readyInMinutes);
        if (value.diets == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.diets);
        }
        if (value.dishTypes == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.dishTypes);
        }
        if (value.occasions == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.occasions);
        }
        if (value.likes == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.likes);
        }
        if (value.usedIngredientCount == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.usedIngredientCount);
        }
        if (value.cuisines == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.cuisines);
        }
        final int _tmp_8;
        _tmp_8 = Converters.fromTimeOfDayEnumToInt(value.timeOfDay);
        stmt.bindLong(25, _tmp_8);
        final int _tmp_9;
        _tmp_9 = Converters.fromComplexityToInt(value.complexity);
        stmt.bindLong(26, _tmp_9);
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
    this.__deletionAdapterOfMeal = new EntityDeletionOrUpdateAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Meal` WHERE `mealId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        stmt.bindLong(1, value.mealId);
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
    this.__updateAdapterOfMeal = new EntityDeletionOrUpdateAdapter<Meal>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Meal` SET `mealId` = ?,`title` = ?,`cheap` = ?,`healthScore` = ?,`vegetarian` = ?,`vegan` = ?,`glutenFree` = ?,`veryHealthy` = ?,`dairyFree` = ?,`veryPopular` = ?,`sustainable` = ?,`pricePerServing` = ?,`spoonId` = ?,`servings` = ?,`sourceUrl` = ?,`summary` = ?,`image` = ?,`readyInMinutes` = ?,`diets` = ?,`dishTypes` = ?,`occasions` = ?,`likes` = ?,`usedIngredientCount` = ?,`cuisines` = ?,`timeOfDay` = ?,`complexity` = ? WHERE `mealId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meal value) {
        stmt.bindLong(1, value.mealId);
        if (value.title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.title);
        }
        final Integer _tmp;
        _tmp = value.cheap == null ? null : (value.cheap ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        if (value.healthScore == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindDouble(4, value.healthScore);
        }
        final Integer _tmp_1;
        _tmp_1 = value.vegetarian == null ? null : (value.vegetarian ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
        final Integer _tmp_2;
        _tmp_2 = value.vegan == null ? null : (value.vegan ? 1 : 0);
        if (_tmp_2 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_2);
        }
        final Integer _tmp_3;
        _tmp_3 = value.glutenFree == null ? null : (value.glutenFree ? 1 : 0);
        if (_tmp_3 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_3);
        }
        final Integer _tmp_4;
        _tmp_4 = value.veryHealthy == null ? null : (value.veryHealthy ? 1 : 0);
        if (_tmp_4 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_4);
        }
        final Integer _tmp_5;
        _tmp_5 = value.dairyFree == null ? null : (value.dairyFree ? 1 : 0);
        if (_tmp_5 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp_5);
        }
        final Integer _tmp_6;
        _tmp_6 = value.veryPopular == null ? null : (value.veryPopular ? 1 : 0);
        if (_tmp_6 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, _tmp_6);
        }
        final Integer _tmp_7;
        _tmp_7 = value.sustainable == null ? null : (value.sustainable ? 1 : 0);
        if (_tmp_7 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp_7);
        }
        if (value.pricePerServing == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.pricePerServing);
        }
        if (value.spoonId == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.spoonId);
        }
        stmt.bindLong(14, value.servings);
        if (value.sourceUrl == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.sourceUrl);
        }
        if (value.summary == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.summary);
        }
        if (value.image == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.image);
        }
        stmt.bindLong(18, value.readyInMinutes);
        if (value.diets == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.diets);
        }
        if (value.dishTypes == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.dishTypes);
        }
        if (value.occasions == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.occasions);
        }
        if (value.likes == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.likes);
        }
        if (value.usedIngredientCount == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.usedIngredientCount);
        }
        if (value.cuisines == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.cuisines);
        }
        final int _tmp_8;
        _tmp_8 = Converters.fromTimeOfDayEnumToInt(value.timeOfDay);
        stmt.bindLong(25, _tmp_8);
        final int _tmp_9;
        _tmp_9 = Converters.fromComplexityToInt(value.complexity);
        stmt.bindLong(26, _tmp_9);
        stmt.bindLong(27, value.mealId);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM meal";
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
  public long Create(final Meal meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfMeal.insertAndReturnId(meal);
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
  public void Delete(final Meal meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMeal.handle(meal);
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
  public void Update(final Meal... meal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMeal.handleMultiple(meal);
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

  @Override
  public Meal Get(final long id) {
    final String _sql = "SELECT * FROM meal WHERE mealId=? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMealId = CursorUtil.getColumnIndexOrThrow(_cursor, "mealId");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfCheap = CursorUtil.getColumnIndexOrThrow(_cursor, "cheap");
      final int _cursorIndexOfHealthScore = CursorUtil.getColumnIndexOrThrow(_cursor, "healthScore");
      final int _cursorIndexOfVegetarian = CursorUtil.getColumnIndexOrThrow(_cursor, "vegetarian");
      final int _cursorIndexOfVegan = CursorUtil.getColumnIndexOrThrow(_cursor, "vegan");
      final int _cursorIndexOfGlutenFree = CursorUtil.getColumnIndexOrThrow(_cursor, "glutenFree");
      final int _cursorIndexOfVeryHealthy = CursorUtil.getColumnIndexOrThrow(_cursor, "veryHealthy");
      final int _cursorIndexOfDairyFree = CursorUtil.getColumnIndexOrThrow(_cursor, "dairyFree");
      final int _cursorIndexOfVeryPopular = CursorUtil.getColumnIndexOrThrow(_cursor, "veryPopular");
      final int _cursorIndexOfSustainable = CursorUtil.getColumnIndexOrThrow(_cursor, "sustainable");
      final int _cursorIndexOfPricePerServing = CursorUtil.getColumnIndexOrThrow(_cursor, "pricePerServing");
      final int _cursorIndexOfSpoonId = CursorUtil.getColumnIndexOrThrow(_cursor, "spoonId");
      final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
      final int _cursorIndexOfSourceUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sourceUrl");
      final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfReadyInMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "readyInMinutes");
      final int _cursorIndexOfDiets = CursorUtil.getColumnIndexOrThrow(_cursor, "diets");
      final int _cursorIndexOfDishTypes = CursorUtil.getColumnIndexOrThrow(_cursor, "dishTypes");
      final int _cursorIndexOfOccasions = CursorUtil.getColumnIndexOrThrow(_cursor, "occasions");
      final int _cursorIndexOfLikes = CursorUtil.getColumnIndexOrThrow(_cursor, "likes");
      final int _cursorIndexOfUsedIngredientCount = CursorUtil.getColumnIndexOrThrow(_cursor, "usedIngredientCount");
      final int _cursorIndexOfCuisines = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisines");
      final int _cursorIndexOfTimeOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "timeOfDay");
      final int _cursorIndexOfComplexity = CursorUtil.getColumnIndexOrThrow(_cursor, "complexity");
      final Meal _result;
      if(_cursor.moveToFirst()) {
        final long _tmpMealId;
        _tmpMealId = _cursor.getLong(_cursorIndexOfMealId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final Boolean _tmpCheap;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfCheap)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfCheap);
        }
        _tmpCheap = _tmp == null ? null : _tmp != 0;
        final Double _tmpHealthScore;
        if (_cursor.isNull(_cursorIndexOfHealthScore)) {
          _tmpHealthScore = null;
        } else {
          _tmpHealthScore = _cursor.getDouble(_cursorIndexOfHealthScore);
        }
        final Boolean _tmpVegetarian;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfVegetarian)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfVegetarian);
        }
        _tmpVegetarian = _tmp_1 == null ? null : _tmp_1 != 0;
        final Boolean _tmpVegan;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfVegan)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfVegan);
        }
        _tmpVegan = _tmp_2 == null ? null : _tmp_2 != 0;
        final Boolean _tmpGlutenFree;
        final Integer _tmp_3;
        if (_cursor.isNull(_cursorIndexOfGlutenFree)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getInt(_cursorIndexOfGlutenFree);
        }
        _tmpGlutenFree = _tmp_3 == null ? null : _tmp_3 != 0;
        final Boolean _tmpVeryHealthy;
        final Integer _tmp_4;
        if (_cursor.isNull(_cursorIndexOfVeryHealthy)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getInt(_cursorIndexOfVeryHealthy);
        }
        _tmpVeryHealthy = _tmp_4 == null ? null : _tmp_4 != 0;
        final Boolean _tmpDairyFree;
        final Integer _tmp_5;
        if (_cursor.isNull(_cursorIndexOfDairyFree)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getInt(_cursorIndexOfDairyFree);
        }
        _tmpDairyFree = _tmp_5 == null ? null : _tmp_5 != 0;
        final Boolean _tmpVeryPopular;
        final Integer _tmp_6;
        if (_cursor.isNull(_cursorIndexOfVeryPopular)) {
          _tmp_6 = null;
        } else {
          _tmp_6 = _cursor.getInt(_cursorIndexOfVeryPopular);
        }
        _tmpVeryPopular = _tmp_6 == null ? null : _tmp_6 != 0;
        final Boolean _tmpSustainable;
        final Integer _tmp_7;
        if (_cursor.isNull(_cursorIndexOfSustainable)) {
          _tmp_7 = null;
        } else {
          _tmp_7 = _cursor.getInt(_cursorIndexOfSustainable);
        }
        _tmpSustainable = _tmp_7 == null ? null : _tmp_7 != 0;
        final Double _tmpPricePerServing;
        if (_cursor.isNull(_cursorIndexOfPricePerServing)) {
          _tmpPricePerServing = null;
        } else {
          _tmpPricePerServing = _cursor.getDouble(_cursorIndexOfPricePerServing);
        }
        final Long _tmpSpoonId;
        if (_cursor.isNull(_cursorIndexOfSpoonId)) {
          _tmpSpoonId = null;
        } else {
          _tmpSpoonId = _cursor.getLong(_cursorIndexOfSpoonId);
        }
        final int _tmpServings;
        _tmpServings = _cursor.getInt(_cursorIndexOfServings);
        final String _tmpSourceUrl;
        _tmpSourceUrl = _cursor.getString(_cursorIndexOfSourceUrl);
        final String _tmpSummary;
        _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        final int _tmpReadyInMinutes;
        _tmpReadyInMinutes = _cursor.getInt(_cursorIndexOfReadyInMinutes);
        final String _tmpDiets;
        _tmpDiets = _cursor.getString(_cursorIndexOfDiets);
        final String _tmpDishTypes;
        _tmpDishTypes = _cursor.getString(_cursorIndexOfDishTypes);
        final String _tmpOccasions;
        _tmpOccasions = _cursor.getString(_cursorIndexOfOccasions);
        final String _tmpLikes;
        _tmpLikes = _cursor.getString(_cursorIndexOfLikes);
        final String _tmpUsedIngredientCount;
        _tmpUsedIngredientCount = _cursor.getString(_cursorIndexOfUsedIngredientCount);
        final TimeOfDayEnum _tmpTimeOfDay;
        final int _tmp_8;
        _tmp_8 = _cursor.getInt(_cursorIndexOfTimeOfDay);
        _tmpTimeOfDay = Converters.fromIntToTimeOfDay(_tmp_8);
        final ComplexityEnum _tmpComplexity;
        final int _tmp_9;
        _tmp_9 = _cursor.getInt(_cursorIndexOfComplexity);
        _tmpComplexity = Converters.fromIntToComplexity(_tmp_9);
        _result = new Meal(_tmpMealId,_tmpSpoonId,_tmpTitle,_tmpSummary,_tmpHealthScore,_tmpPricePerServing,_tmpCheap,_tmpSourceUrl,_tmpVegetarian,_tmpVegan,_tmpGlutenFree,_tmpVeryHealthy,_tmpDairyFree,_tmpVeryPopular,_tmpSustainable,_tmpDiets,_tmpServings,_tmpReadyInMinutes,_tmpImage,_tmpDishTypes,_tmpOccasions,_tmpLikes,_tmpUsedIngredientCount,_tmpTimeOfDay,_tmpComplexity);
        _result.cuisines = _cursor.getString(_cursorIndexOfCuisines);
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
  public List<Meal> GetAll() {
    final String _sql = "SELECT * FROM meal";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
      try {
        final int _cursorIndexOfMealId = CursorUtil.getColumnIndexOrThrow(_cursor, "mealId");
        final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
        final int _cursorIndexOfCheap = CursorUtil.getColumnIndexOrThrow(_cursor, "cheap");
        final int _cursorIndexOfHealthScore = CursorUtil.getColumnIndexOrThrow(_cursor, "healthScore");
        final int _cursorIndexOfVegetarian = CursorUtil.getColumnIndexOrThrow(_cursor, "vegetarian");
        final int _cursorIndexOfVegan = CursorUtil.getColumnIndexOrThrow(_cursor, "vegan");
        final int _cursorIndexOfGlutenFree = CursorUtil.getColumnIndexOrThrow(_cursor, "glutenFree");
        final int _cursorIndexOfVeryHealthy = CursorUtil.getColumnIndexOrThrow(_cursor, "veryHealthy");
        final int _cursorIndexOfDairyFree = CursorUtil.getColumnIndexOrThrow(_cursor, "dairyFree");
        final int _cursorIndexOfVeryPopular = CursorUtil.getColumnIndexOrThrow(_cursor, "veryPopular");
        final int _cursorIndexOfSustainable = CursorUtil.getColumnIndexOrThrow(_cursor, "sustainable");
        final int _cursorIndexOfPricePerServing = CursorUtil.getColumnIndexOrThrow(_cursor, "pricePerServing");
        final int _cursorIndexOfSpoonId = CursorUtil.getColumnIndexOrThrow(_cursor, "spoonId");
        final int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
        final int _cursorIndexOfSourceUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sourceUrl");
        final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
        final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
        final int _cursorIndexOfReadyInMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "readyInMinutes");
        final int _cursorIndexOfDiets = CursorUtil.getColumnIndexOrThrow(_cursor, "diets");
        final int _cursorIndexOfDishTypes = CursorUtil.getColumnIndexOrThrow(_cursor, "dishTypes");
        final int _cursorIndexOfOccasions = CursorUtil.getColumnIndexOrThrow(_cursor, "occasions");
        final int _cursorIndexOfLikes = CursorUtil.getColumnIndexOrThrow(_cursor, "likes");
        final int _cursorIndexOfUsedIngredientCount = CursorUtil.getColumnIndexOrThrow(_cursor, "usedIngredientCount");
        final int _cursorIndexOfCuisines = CursorUtil.getColumnIndexOrThrow(_cursor, "cuisines");
        final int _cursorIndexOfTimeOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "timeOfDay");
        final int _cursorIndexOfComplexity = CursorUtil.getColumnIndexOrThrow(_cursor, "complexity");
        final List<Meal> _result = new ArrayList<Meal>(_cursor.getCount());
        while(_cursor.moveToNext()) {
          final Meal _item;
          final long _tmpMealId;
          _tmpMealId = _cursor.getLong(_cursorIndexOfMealId);
          final String _tmpTitle;
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
          final Boolean _tmpCheap;
          final Integer _tmp;
          if (_cursor.isNull(_cursorIndexOfCheap)) {
            _tmp = null;
          } else {
            _tmp = _cursor.getInt(_cursorIndexOfCheap);
          }
          _tmpCheap = _tmp == null ? null : _tmp != 0;
          final Double _tmpHealthScore;
          if (_cursor.isNull(_cursorIndexOfHealthScore)) {
            _tmpHealthScore = null;
          } else {
            _tmpHealthScore = _cursor.getDouble(_cursorIndexOfHealthScore);
          }
          final Boolean _tmpVegetarian;
          final Integer _tmp_1;
          if (_cursor.isNull(_cursorIndexOfVegetarian)) {
            _tmp_1 = null;
          } else {
            _tmp_1 = _cursor.getInt(_cursorIndexOfVegetarian);
          }
          _tmpVegetarian = _tmp_1 == null ? null : _tmp_1 != 0;
          final Boolean _tmpVegan;
          final Integer _tmp_2;
          if (_cursor.isNull(_cursorIndexOfVegan)) {
            _tmp_2 = null;
          } else {
            _tmp_2 = _cursor.getInt(_cursorIndexOfVegan);
          }
          _tmpVegan = _tmp_2 == null ? null : _tmp_2 != 0;
          final Boolean _tmpGlutenFree;
          final Integer _tmp_3;
          if (_cursor.isNull(_cursorIndexOfGlutenFree)) {
            _tmp_3 = null;
          } else {
            _tmp_3 = _cursor.getInt(_cursorIndexOfGlutenFree);
          }
          _tmpGlutenFree = _tmp_3 == null ? null : _tmp_3 != 0;
          final Boolean _tmpVeryHealthy;
          final Integer _tmp_4;
          if (_cursor.isNull(_cursorIndexOfVeryHealthy)) {
            _tmp_4 = null;
          } else {
            _tmp_4 = _cursor.getInt(_cursorIndexOfVeryHealthy);
          }
          _tmpVeryHealthy = _tmp_4 == null ? null : _tmp_4 != 0;
          final Boolean _tmpDairyFree;
          final Integer _tmp_5;
          if (_cursor.isNull(_cursorIndexOfDairyFree)) {
            _tmp_5 = null;
          } else {
            _tmp_5 = _cursor.getInt(_cursorIndexOfDairyFree);
          }
          _tmpDairyFree = _tmp_5 == null ? null : _tmp_5 != 0;
          final Boolean _tmpVeryPopular;
          final Integer _tmp_6;
          if (_cursor.isNull(_cursorIndexOfVeryPopular)) {
            _tmp_6 = null;
          } else {
            _tmp_6 = _cursor.getInt(_cursorIndexOfVeryPopular);
          }
          _tmpVeryPopular = _tmp_6 == null ? null : _tmp_6 != 0;
          final Boolean _tmpSustainable;
          final Integer _tmp_7;
          if (_cursor.isNull(_cursorIndexOfSustainable)) {
            _tmp_7 = null;
          } else {
            _tmp_7 = _cursor.getInt(_cursorIndexOfSustainable);
          }
          _tmpSustainable = _tmp_7 == null ? null : _tmp_7 != 0;
          final Double _tmpPricePerServing;
          if (_cursor.isNull(_cursorIndexOfPricePerServing)) {
            _tmpPricePerServing = null;
          } else {
            _tmpPricePerServing = _cursor.getDouble(_cursorIndexOfPricePerServing);
          }
          final Long _tmpSpoonId;
          if (_cursor.isNull(_cursorIndexOfSpoonId)) {
            _tmpSpoonId = null;
          } else {
            _tmpSpoonId = _cursor.getLong(_cursorIndexOfSpoonId);
          }
          final int _tmpServings;
          _tmpServings = _cursor.getInt(_cursorIndexOfServings);
          final String _tmpSourceUrl;
          _tmpSourceUrl = _cursor.getString(_cursorIndexOfSourceUrl);
          final String _tmpSummary;
          _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
          final String _tmpImage;
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
          final int _tmpReadyInMinutes;
          _tmpReadyInMinutes = _cursor.getInt(_cursorIndexOfReadyInMinutes);
          final String _tmpDiets;
          _tmpDiets = _cursor.getString(_cursorIndexOfDiets);
          final String _tmpDishTypes;
          _tmpDishTypes = _cursor.getString(_cursorIndexOfDishTypes);
          final String _tmpOccasions;
          _tmpOccasions = _cursor.getString(_cursorIndexOfOccasions);
          final String _tmpLikes;
          _tmpLikes = _cursor.getString(_cursorIndexOfLikes);
          final String _tmpUsedIngredientCount;
          _tmpUsedIngredientCount = _cursor.getString(_cursorIndexOfUsedIngredientCount);
          final TimeOfDayEnum _tmpTimeOfDay;
          final int _tmp_8;
          _tmp_8 = _cursor.getInt(_cursorIndexOfTimeOfDay);
          _tmpTimeOfDay = Converters.fromIntToTimeOfDay(_tmp_8);
          final ComplexityEnum _tmpComplexity;
          final int _tmp_9;
          _tmp_9 = _cursor.getInt(_cursorIndexOfComplexity);
          _tmpComplexity = Converters.fromIntToComplexity(_tmp_9);
          _item = new Meal(_tmpMealId,_tmpSpoonId,_tmpTitle,_tmpSummary,_tmpHealthScore,_tmpPricePerServing,_tmpCheap,_tmpSourceUrl,_tmpVegetarian,_tmpVegan,_tmpGlutenFree,_tmpVeryHealthy,_tmpDairyFree,_tmpVeryPopular,_tmpSustainable,_tmpDiets,_tmpServings,_tmpReadyInMinutes,_tmpImage,_tmpDishTypes,_tmpOccasions,_tmpLikes,_tmpUsedIngredientCount,_tmpTimeOfDay,_tmpComplexity);
          _item.cuisines = _cursor.getString(_cursorIndexOfCuisines);
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
  public LiveData<List<Long>> GetIds() {
    final String _sql = "select mealId from meal";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"meal"}, true, new Callable<List<Long>>() {
      @Override
      public List<Long> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final List<Long> _result = new ArrayList<Long>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final Long _item;
              if (_cursor.isNull(0)) {
                _item = null;
              } else {
                _item = _cursor.getLong(0);
              }
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
}
