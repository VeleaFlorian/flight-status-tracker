package com.example.flightstatustracker.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.flightstatustracker.data.local.dao.FlightDao;
import com.example.flightstatustracker.data.local.dao.FlightDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile FlightDao _flightDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `flights` (`id` TEXT NOT NULL, `date` TEXT NOT NULL, `status` TEXT NOT NULL, `departureAirport` TEXT, `departureTimezone` TEXT, `departureIata` TEXT, `departureIcao` TEXT, `departureTerminal` TEXT, `departureGate` TEXT, `departureDelay` INTEGER, `departureScheduled` TEXT, `departureEstimated` TEXT, `departureActual` TEXT, `arrivalAirport` TEXT, `arrivalTimezone` TEXT, `arrivalIata` TEXT, `arrivalIcao` TEXT, `arrivalTerminal` TEXT, `arrivalGate` TEXT, `arrivalDelay` INTEGER, `arrivalScheduled` TEXT, `arrivalEstimated` TEXT, `arrivalActual` TEXT, `airlineName` TEXT, `airlineIata` TEXT, `airlineIcao` TEXT, `flightNumber` TEXT, `flightIata` TEXT, `flightIcao` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e0719dfdfaa00e130d23ccaec890bf1a')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `flights`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsFlights = new HashMap<String, TableInfo.Column>(29);
        _columnsFlights.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureAirport", new TableInfo.Column("departureAirport", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureTimezone", new TableInfo.Column("departureTimezone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureIata", new TableInfo.Column("departureIata", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureIcao", new TableInfo.Column("departureIcao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureTerminal", new TableInfo.Column("departureTerminal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureGate", new TableInfo.Column("departureGate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureDelay", new TableInfo.Column("departureDelay", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureScheduled", new TableInfo.Column("departureScheduled", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureEstimated", new TableInfo.Column("departureEstimated", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("departureActual", new TableInfo.Column("departureActual", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalAirport", new TableInfo.Column("arrivalAirport", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalTimezone", new TableInfo.Column("arrivalTimezone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalIata", new TableInfo.Column("arrivalIata", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalIcao", new TableInfo.Column("arrivalIcao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalTerminal", new TableInfo.Column("arrivalTerminal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalGate", new TableInfo.Column("arrivalGate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalDelay", new TableInfo.Column("arrivalDelay", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalScheduled", new TableInfo.Column("arrivalScheduled", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalEstimated", new TableInfo.Column("arrivalEstimated", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("arrivalActual", new TableInfo.Column("arrivalActual", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("airlineName", new TableInfo.Column("airlineName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("airlineIata", new TableInfo.Column("airlineIata", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("airlineIcao", new TableInfo.Column("airlineIcao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("flightNumber", new TableInfo.Column("flightNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("flightIata", new TableInfo.Column("flightIata", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFlights.put("flightIcao", new TableInfo.Column("flightIcao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFlights = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFlights = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFlights = new TableInfo("flights", _columnsFlights, _foreignKeysFlights, _indicesFlights);
        final TableInfo _existingFlights = TableInfo.read(db, "flights");
        if (!_infoFlights.equals(_existingFlights)) {
          return new RoomOpenHelper.ValidationResult(false, "flights(com.example.flightstatustracker.data.local.entity.FlightEntity).\n"
                  + " Expected:\n" + _infoFlights + "\n"
                  + " Found:\n" + _existingFlights);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e0719dfdfaa00e130d23ccaec890bf1a", "be64fd22cbc5a6cb5f185fe872a12b13");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "flights");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `flights`");
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
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(FlightDao.class, FlightDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public FlightDao getFlightDao() {
    if (_flightDao != null) {
      return _flightDao;
    } else {
      synchronized(this) {
        if(_flightDao == null) {
          _flightDao = new FlightDao_Impl(this);
        }
        return _flightDao;
      }
    }
  }
}
