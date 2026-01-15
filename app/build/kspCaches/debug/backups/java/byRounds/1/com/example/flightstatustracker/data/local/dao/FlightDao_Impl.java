package com.example.flightstatustracker.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.flightstatustracker.data.local.entity.FlightEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FlightDao_Impl implements FlightDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FlightEntity> __insertionAdapterOfFlightEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearFlights;

  public FlightDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFlightEntity = new EntityInsertionAdapter<FlightEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `flights` (`id`,`date`,`status`,`departureAirport`,`departureTimezone`,`departureIata`,`departureIcao`,`departureTerminal`,`departureGate`,`departureDelay`,`departureScheduled`,`departureEstimated`,`departureActual`,`arrivalAirport`,`arrivalTimezone`,`arrivalIata`,`arrivalIcao`,`arrivalTerminal`,`arrivalGate`,`arrivalDelay`,`arrivalScheduled`,`arrivalEstimated`,`arrivalActual`,`airlineName`,`airlineIata`,`airlineIcao`,`flightNumber`,`flightIata`,`flightIcao`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FlightEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getDate());
        statement.bindString(3, entity.getStatus());
        if (entity.getDepartureAirport() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDepartureAirport());
        }
        if (entity.getDepartureTimezone() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDepartureTimezone());
        }
        if (entity.getDepartureIata() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getDepartureIata());
        }
        if (entity.getDepartureIcao() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDepartureIcao());
        }
        if (entity.getDepartureTerminal() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDepartureTerminal());
        }
        if (entity.getDepartureGate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDepartureGate());
        }
        if (entity.getDepartureDelay() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getDepartureDelay());
        }
        if (entity.getDepartureScheduled() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getDepartureScheduled());
        }
        if (entity.getDepartureEstimated() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getDepartureEstimated());
        }
        if (entity.getDepartureActual() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getDepartureActual());
        }
        if (entity.getArrivalAirport() == null) {
          statement.bindNull(14);
        } else {
          statement.bindString(14, entity.getArrivalAirport());
        }
        if (entity.getArrivalTimezone() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getArrivalTimezone());
        }
        if (entity.getArrivalIata() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getArrivalIata());
        }
        if (entity.getArrivalIcao() == null) {
          statement.bindNull(17);
        } else {
          statement.bindString(17, entity.getArrivalIcao());
        }
        if (entity.getArrivalTerminal() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getArrivalTerminal());
        }
        if (entity.getArrivalGate() == null) {
          statement.bindNull(19);
        } else {
          statement.bindString(19, entity.getArrivalGate());
        }
        if (entity.getArrivalDelay() == null) {
          statement.bindNull(20);
        } else {
          statement.bindLong(20, entity.getArrivalDelay());
        }
        if (entity.getArrivalScheduled() == null) {
          statement.bindNull(21);
        } else {
          statement.bindString(21, entity.getArrivalScheduled());
        }
        if (entity.getArrivalEstimated() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getArrivalEstimated());
        }
        if (entity.getArrivalActual() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getArrivalActual());
        }
        if (entity.getAirlineName() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getAirlineName());
        }
        if (entity.getAirlineIata() == null) {
          statement.bindNull(25);
        } else {
          statement.bindString(25, entity.getAirlineIata());
        }
        if (entity.getAirlineIcao() == null) {
          statement.bindNull(26);
        } else {
          statement.bindString(26, entity.getAirlineIcao());
        }
        if (entity.getFlightNumber() == null) {
          statement.bindNull(27);
        } else {
          statement.bindString(27, entity.getFlightNumber());
        }
        if (entity.getFlightIata() == null) {
          statement.bindNull(28);
        } else {
          statement.bindString(28, entity.getFlightIata());
        }
        if (entity.getFlightIcao() == null) {
          statement.bindNull(29);
        } else {
          statement.bindString(29, entity.getFlightIcao());
        }
      }
    };
    this.__preparedStmtOfClearFlights = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM flights";
        return _query;
      }
    };
  }

  @Override
  public Object insertFlights(final List<FlightEntity> flights,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFlightEntity.insert(flights);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearFlights(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearFlights.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearFlights.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FlightEntity>> getAllFlights() {
    final String _sql = "SELECT * FROM flights";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"flights"}, new Callable<List<FlightEntity>>() {
      @Override
      @NonNull
      public List<FlightEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDepartureAirport = CursorUtil.getColumnIndexOrThrow(_cursor, "departureAirport");
          final int _cursorIndexOfDepartureTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "departureTimezone");
          final int _cursorIndexOfDepartureIata = CursorUtil.getColumnIndexOrThrow(_cursor, "departureIata");
          final int _cursorIndexOfDepartureIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "departureIcao");
          final int _cursorIndexOfDepartureTerminal = CursorUtil.getColumnIndexOrThrow(_cursor, "departureTerminal");
          final int _cursorIndexOfDepartureGate = CursorUtil.getColumnIndexOrThrow(_cursor, "departureGate");
          final int _cursorIndexOfDepartureDelay = CursorUtil.getColumnIndexOrThrow(_cursor, "departureDelay");
          final int _cursorIndexOfDepartureScheduled = CursorUtil.getColumnIndexOrThrow(_cursor, "departureScheduled");
          final int _cursorIndexOfDepartureEstimated = CursorUtil.getColumnIndexOrThrow(_cursor, "departureEstimated");
          final int _cursorIndexOfDepartureActual = CursorUtil.getColumnIndexOrThrow(_cursor, "departureActual");
          final int _cursorIndexOfArrivalAirport = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalAirport");
          final int _cursorIndexOfArrivalTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalTimezone");
          final int _cursorIndexOfArrivalIata = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalIata");
          final int _cursorIndexOfArrivalIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalIcao");
          final int _cursorIndexOfArrivalTerminal = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalTerminal");
          final int _cursorIndexOfArrivalGate = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalGate");
          final int _cursorIndexOfArrivalDelay = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalDelay");
          final int _cursorIndexOfArrivalScheduled = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalScheduled");
          final int _cursorIndexOfArrivalEstimated = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalEstimated");
          final int _cursorIndexOfArrivalActual = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalActual");
          final int _cursorIndexOfAirlineName = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineName");
          final int _cursorIndexOfAirlineIata = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineIata");
          final int _cursorIndexOfAirlineIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineIcao");
          final int _cursorIndexOfFlightNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "flightNumber");
          final int _cursorIndexOfFlightIata = CursorUtil.getColumnIndexOrThrow(_cursor, "flightIata");
          final int _cursorIndexOfFlightIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "flightIcao");
          final List<FlightEntity> _result = new ArrayList<FlightEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FlightEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpDepartureAirport;
            if (_cursor.isNull(_cursorIndexOfDepartureAirport)) {
              _tmpDepartureAirport = null;
            } else {
              _tmpDepartureAirport = _cursor.getString(_cursorIndexOfDepartureAirport);
            }
            final String _tmpDepartureTimezone;
            if (_cursor.isNull(_cursorIndexOfDepartureTimezone)) {
              _tmpDepartureTimezone = null;
            } else {
              _tmpDepartureTimezone = _cursor.getString(_cursorIndexOfDepartureTimezone);
            }
            final String _tmpDepartureIata;
            if (_cursor.isNull(_cursorIndexOfDepartureIata)) {
              _tmpDepartureIata = null;
            } else {
              _tmpDepartureIata = _cursor.getString(_cursorIndexOfDepartureIata);
            }
            final String _tmpDepartureIcao;
            if (_cursor.isNull(_cursorIndexOfDepartureIcao)) {
              _tmpDepartureIcao = null;
            } else {
              _tmpDepartureIcao = _cursor.getString(_cursorIndexOfDepartureIcao);
            }
            final String _tmpDepartureTerminal;
            if (_cursor.isNull(_cursorIndexOfDepartureTerminal)) {
              _tmpDepartureTerminal = null;
            } else {
              _tmpDepartureTerminal = _cursor.getString(_cursorIndexOfDepartureTerminal);
            }
            final String _tmpDepartureGate;
            if (_cursor.isNull(_cursorIndexOfDepartureGate)) {
              _tmpDepartureGate = null;
            } else {
              _tmpDepartureGate = _cursor.getString(_cursorIndexOfDepartureGate);
            }
            final Integer _tmpDepartureDelay;
            if (_cursor.isNull(_cursorIndexOfDepartureDelay)) {
              _tmpDepartureDelay = null;
            } else {
              _tmpDepartureDelay = _cursor.getInt(_cursorIndexOfDepartureDelay);
            }
            final String _tmpDepartureScheduled;
            if (_cursor.isNull(_cursorIndexOfDepartureScheduled)) {
              _tmpDepartureScheduled = null;
            } else {
              _tmpDepartureScheduled = _cursor.getString(_cursorIndexOfDepartureScheduled);
            }
            final String _tmpDepartureEstimated;
            if (_cursor.isNull(_cursorIndexOfDepartureEstimated)) {
              _tmpDepartureEstimated = null;
            } else {
              _tmpDepartureEstimated = _cursor.getString(_cursorIndexOfDepartureEstimated);
            }
            final String _tmpDepartureActual;
            if (_cursor.isNull(_cursorIndexOfDepartureActual)) {
              _tmpDepartureActual = null;
            } else {
              _tmpDepartureActual = _cursor.getString(_cursorIndexOfDepartureActual);
            }
            final String _tmpArrivalAirport;
            if (_cursor.isNull(_cursorIndexOfArrivalAirport)) {
              _tmpArrivalAirport = null;
            } else {
              _tmpArrivalAirport = _cursor.getString(_cursorIndexOfArrivalAirport);
            }
            final String _tmpArrivalTimezone;
            if (_cursor.isNull(_cursorIndexOfArrivalTimezone)) {
              _tmpArrivalTimezone = null;
            } else {
              _tmpArrivalTimezone = _cursor.getString(_cursorIndexOfArrivalTimezone);
            }
            final String _tmpArrivalIata;
            if (_cursor.isNull(_cursorIndexOfArrivalIata)) {
              _tmpArrivalIata = null;
            } else {
              _tmpArrivalIata = _cursor.getString(_cursorIndexOfArrivalIata);
            }
            final String _tmpArrivalIcao;
            if (_cursor.isNull(_cursorIndexOfArrivalIcao)) {
              _tmpArrivalIcao = null;
            } else {
              _tmpArrivalIcao = _cursor.getString(_cursorIndexOfArrivalIcao);
            }
            final String _tmpArrivalTerminal;
            if (_cursor.isNull(_cursorIndexOfArrivalTerminal)) {
              _tmpArrivalTerminal = null;
            } else {
              _tmpArrivalTerminal = _cursor.getString(_cursorIndexOfArrivalTerminal);
            }
            final String _tmpArrivalGate;
            if (_cursor.isNull(_cursorIndexOfArrivalGate)) {
              _tmpArrivalGate = null;
            } else {
              _tmpArrivalGate = _cursor.getString(_cursorIndexOfArrivalGate);
            }
            final Integer _tmpArrivalDelay;
            if (_cursor.isNull(_cursorIndexOfArrivalDelay)) {
              _tmpArrivalDelay = null;
            } else {
              _tmpArrivalDelay = _cursor.getInt(_cursorIndexOfArrivalDelay);
            }
            final String _tmpArrivalScheduled;
            if (_cursor.isNull(_cursorIndexOfArrivalScheduled)) {
              _tmpArrivalScheduled = null;
            } else {
              _tmpArrivalScheduled = _cursor.getString(_cursorIndexOfArrivalScheduled);
            }
            final String _tmpArrivalEstimated;
            if (_cursor.isNull(_cursorIndexOfArrivalEstimated)) {
              _tmpArrivalEstimated = null;
            } else {
              _tmpArrivalEstimated = _cursor.getString(_cursorIndexOfArrivalEstimated);
            }
            final String _tmpArrivalActual;
            if (_cursor.isNull(_cursorIndexOfArrivalActual)) {
              _tmpArrivalActual = null;
            } else {
              _tmpArrivalActual = _cursor.getString(_cursorIndexOfArrivalActual);
            }
            final String _tmpAirlineName;
            if (_cursor.isNull(_cursorIndexOfAirlineName)) {
              _tmpAirlineName = null;
            } else {
              _tmpAirlineName = _cursor.getString(_cursorIndexOfAirlineName);
            }
            final String _tmpAirlineIata;
            if (_cursor.isNull(_cursorIndexOfAirlineIata)) {
              _tmpAirlineIata = null;
            } else {
              _tmpAirlineIata = _cursor.getString(_cursorIndexOfAirlineIata);
            }
            final String _tmpAirlineIcao;
            if (_cursor.isNull(_cursorIndexOfAirlineIcao)) {
              _tmpAirlineIcao = null;
            } else {
              _tmpAirlineIcao = _cursor.getString(_cursorIndexOfAirlineIcao);
            }
            final String _tmpFlightNumber;
            if (_cursor.isNull(_cursorIndexOfFlightNumber)) {
              _tmpFlightNumber = null;
            } else {
              _tmpFlightNumber = _cursor.getString(_cursorIndexOfFlightNumber);
            }
            final String _tmpFlightIata;
            if (_cursor.isNull(_cursorIndexOfFlightIata)) {
              _tmpFlightIata = null;
            } else {
              _tmpFlightIata = _cursor.getString(_cursorIndexOfFlightIata);
            }
            final String _tmpFlightIcao;
            if (_cursor.isNull(_cursorIndexOfFlightIcao)) {
              _tmpFlightIcao = null;
            } else {
              _tmpFlightIcao = _cursor.getString(_cursorIndexOfFlightIcao);
            }
            _item = new FlightEntity(_tmpId,_tmpDate,_tmpStatus,_tmpDepartureAirport,_tmpDepartureTimezone,_tmpDepartureIata,_tmpDepartureIcao,_tmpDepartureTerminal,_tmpDepartureGate,_tmpDepartureDelay,_tmpDepartureScheduled,_tmpDepartureEstimated,_tmpDepartureActual,_tmpArrivalAirport,_tmpArrivalTimezone,_tmpArrivalIata,_tmpArrivalIcao,_tmpArrivalTerminal,_tmpArrivalGate,_tmpArrivalDelay,_tmpArrivalScheduled,_tmpArrivalEstimated,_tmpArrivalActual,_tmpAirlineName,_tmpAirlineIata,_tmpAirlineIcao,_tmpFlightNumber,_tmpFlightIata,_tmpFlightIcao);
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
  public Flow<List<FlightEntity>> searchFlights(final String query) {
    final String _sql = "\n"
            + "        SELECT * FROM flights \n"
            + "        WHERE flightIata LIKE '%' || ? || '%' \n"
            + "        OR airlineName LIKE '%' || ? || '%' \n"
            + "        OR departureAirport LIKE '%' || ? || '%'\n"
            + "        OR arrivalAirport LIKE '%' || ? || '%'\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindString(_argIndex, query);
    _argIndex = 2;
    _statement.bindString(_argIndex, query);
    _argIndex = 3;
    _statement.bindString(_argIndex, query);
    _argIndex = 4;
    _statement.bindString(_argIndex, query);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"flights"}, new Callable<List<FlightEntity>>() {
      @Override
      @NonNull
      public List<FlightEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDepartureAirport = CursorUtil.getColumnIndexOrThrow(_cursor, "departureAirport");
          final int _cursorIndexOfDepartureTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "departureTimezone");
          final int _cursorIndexOfDepartureIata = CursorUtil.getColumnIndexOrThrow(_cursor, "departureIata");
          final int _cursorIndexOfDepartureIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "departureIcao");
          final int _cursorIndexOfDepartureTerminal = CursorUtil.getColumnIndexOrThrow(_cursor, "departureTerminal");
          final int _cursorIndexOfDepartureGate = CursorUtil.getColumnIndexOrThrow(_cursor, "departureGate");
          final int _cursorIndexOfDepartureDelay = CursorUtil.getColumnIndexOrThrow(_cursor, "departureDelay");
          final int _cursorIndexOfDepartureScheduled = CursorUtil.getColumnIndexOrThrow(_cursor, "departureScheduled");
          final int _cursorIndexOfDepartureEstimated = CursorUtil.getColumnIndexOrThrow(_cursor, "departureEstimated");
          final int _cursorIndexOfDepartureActual = CursorUtil.getColumnIndexOrThrow(_cursor, "departureActual");
          final int _cursorIndexOfArrivalAirport = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalAirport");
          final int _cursorIndexOfArrivalTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalTimezone");
          final int _cursorIndexOfArrivalIata = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalIata");
          final int _cursorIndexOfArrivalIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalIcao");
          final int _cursorIndexOfArrivalTerminal = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalTerminal");
          final int _cursorIndexOfArrivalGate = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalGate");
          final int _cursorIndexOfArrivalDelay = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalDelay");
          final int _cursorIndexOfArrivalScheduled = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalScheduled");
          final int _cursorIndexOfArrivalEstimated = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalEstimated");
          final int _cursorIndexOfArrivalActual = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalActual");
          final int _cursorIndexOfAirlineName = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineName");
          final int _cursorIndexOfAirlineIata = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineIata");
          final int _cursorIndexOfAirlineIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineIcao");
          final int _cursorIndexOfFlightNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "flightNumber");
          final int _cursorIndexOfFlightIata = CursorUtil.getColumnIndexOrThrow(_cursor, "flightIata");
          final int _cursorIndexOfFlightIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "flightIcao");
          final List<FlightEntity> _result = new ArrayList<FlightEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FlightEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpDepartureAirport;
            if (_cursor.isNull(_cursorIndexOfDepartureAirport)) {
              _tmpDepartureAirport = null;
            } else {
              _tmpDepartureAirport = _cursor.getString(_cursorIndexOfDepartureAirport);
            }
            final String _tmpDepartureTimezone;
            if (_cursor.isNull(_cursorIndexOfDepartureTimezone)) {
              _tmpDepartureTimezone = null;
            } else {
              _tmpDepartureTimezone = _cursor.getString(_cursorIndexOfDepartureTimezone);
            }
            final String _tmpDepartureIata;
            if (_cursor.isNull(_cursorIndexOfDepartureIata)) {
              _tmpDepartureIata = null;
            } else {
              _tmpDepartureIata = _cursor.getString(_cursorIndexOfDepartureIata);
            }
            final String _tmpDepartureIcao;
            if (_cursor.isNull(_cursorIndexOfDepartureIcao)) {
              _tmpDepartureIcao = null;
            } else {
              _tmpDepartureIcao = _cursor.getString(_cursorIndexOfDepartureIcao);
            }
            final String _tmpDepartureTerminal;
            if (_cursor.isNull(_cursorIndexOfDepartureTerminal)) {
              _tmpDepartureTerminal = null;
            } else {
              _tmpDepartureTerminal = _cursor.getString(_cursorIndexOfDepartureTerminal);
            }
            final String _tmpDepartureGate;
            if (_cursor.isNull(_cursorIndexOfDepartureGate)) {
              _tmpDepartureGate = null;
            } else {
              _tmpDepartureGate = _cursor.getString(_cursorIndexOfDepartureGate);
            }
            final Integer _tmpDepartureDelay;
            if (_cursor.isNull(_cursorIndexOfDepartureDelay)) {
              _tmpDepartureDelay = null;
            } else {
              _tmpDepartureDelay = _cursor.getInt(_cursorIndexOfDepartureDelay);
            }
            final String _tmpDepartureScheduled;
            if (_cursor.isNull(_cursorIndexOfDepartureScheduled)) {
              _tmpDepartureScheduled = null;
            } else {
              _tmpDepartureScheduled = _cursor.getString(_cursorIndexOfDepartureScheduled);
            }
            final String _tmpDepartureEstimated;
            if (_cursor.isNull(_cursorIndexOfDepartureEstimated)) {
              _tmpDepartureEstimated = null;
            } else {
              _tmpDepartureEstimated = _cursor.getString(_cursorIndexOfDepartureEstimated);
            }
            final String _tmpDepartureActual;
            if (_cursor.isNull(_cursorIndexOfDepartureActual)) {
              _tmpDepartureActual = null;
            } else {
              _tmpDepartureActual = _cursor.getString(_cursorIndexOfDepartureActual);
            }
            final String _tmpArrivalAirport;
            if (_cursor.isNull(_cursorIndexOfArrivalAirport)) {
              _tmpArrivalAirport = null;
            } else {
              _tmpArrivalAirport = _cursor.getString(_cursorIndexOfArrivalAirport);
            }
            final String _tmpArrivalTimezone;
            if (_cursor.isNull(_cursorIndexOfArrivalTimezone)) {
              _tmpArrivalTimezone = null;
            } else {
              _tmpArrivalTimezone = _cursor.getString(_cursorIndexOfArrivalTimezone);
            }
            final String _tmpArrivalIata;
            if (_cursor.isNull(_cursorIndexOfArrivalIata)) {
              _tmpArrivalIata = null;
            } else {
              _tmpArrivalIata = _cursor.getString(_cursorIndexOfArrivalIata);
            }
            final String _tmpArrivalIcao;
            if (_cursor.isNull(_cursorIndexOfArrivalIcao)) {
              _tmpArrivalIcao = null;
            } else {
              _tmpArrivalIcao = _cursor.getString(_cursorIndexOfArrivalIcao);
            }
            final String _tmpArrivalTerminal;
            if (_cursor.isNull(_cursorIndexOfArrivalTerminal)) {
              _tmpArrivalTerminal = null;
            } else {
              _tmpArrivalTerminal = _cursor.getString(_cursorIndexOfArrivalTerminal);
            }
            final String _tmpArrivalGate;
            if (_cursor.isNull(_cursorIndexOfArrivalGate)) {
              _tmpArrivalGate = null;
            } else {
              _tmpArrivalGate = _cursor.getString(_cursorIndexOfArrivalGate);
            }
            final Integer _tmpArrivalDelay;
            if (_cursor.isNull(_cursorIndexOfArrivalDelay)) {
              _tmpArrivalDelay = null;
            } else {
              _tmpArrivalDelay = _cursor.getInt(_cursorIndexOfArrivalDelay);
            }
            final String _tmpArrivalScheduled;
            if (_cursor.isNull(_cursorIndexOfArrivalScheduled)) {
              _tmpArrivalScheduled = null;
            } else {
              _tmpArrivalScheduled = _cursor.getString(_cursorIndexOfArrivalScheduled);
            }
            final String _tmpArrivalEstimated;
            if (_cursor.isNull(_cursorIndexOfArrivalEstimated)) {
              _tmpArrivalEstimated = null;
            } else {
              _tmpArrivalEstimated = _cursor.getString(_cursorIndexOfArrivalEstimated);
            }
            final String _tmpArrivalActual;
            if (_cursor.isNull(_cursorIndexOfArrivalActual)) {
              _tmpArrivalActual = null;
            } else {
              _tmpArrivalActual = _cursor.getString(_cursorIndexOfArrivalActual);
            }
            final String _tmpAirlineName;
            if (_cursor.isNull(_cursorIndexOfAirlineName)) {
              _tmpAirlineName = null;
            } else {
              _tmpAirlineName = _cursor.getString(_cursorIndexOfAirlineName);
            }
            final String _tmpAirlineIata;
            if (_cursor.isNull(_cursorIndexOfAirlineIata)) {
              _tmpAirlineIata = null;
            } else {
              _tmpAirlineIata = _cursor.getString(_cursorIndexOfAirlineIata);
            }
            final String _tmpAirlineIcao;
            if (_cursor.isNull(_cursorIndexOfAirlineIcao)) {
              _tmpAirlineIcao = null;
            } else {
              _tmpAirlineIcao = _cursor.getString(_cursorIndexOfAirlineIcao);
            }
            final String _tmpFlightNumber;
            if (_cursor.isNull(_cursorIndexOfFlightNumber)) {
              _tmpFlightNumber = null;
            } else {
              _tmpFlightNumber = _cursor.getString(_cursorIndexOfFlightNumber);
            }
            final String _tmpFlightIata;
            if (_cursor.isNull(_cursorIndexOfFlightIata)) {
              _tmpFlightIata = null;
            } else {
              _tmpFlightIata = _cursor.getString(_cursorIndexOfFlightIata);
            }
            final String _tmpFlightIcao;
            if (_cursor.isNull(_cursorIndexOfFlightIcao)) {
              _tmpFlightIcao = null;
            } else {
              _tmpFlightIcao = _cursor.getString(_cursorIndexOfFlightIcao);
            }
            _item = new FlightEntity(_tmpId,_tmpDate,_tmpStatus,_tmpDepartureAirport,_tmpDepartureTimezone,_tmpDepartureIata,_tmpDepartureIcao,_tmpDepartureTerminal,_tmpDepartureGate,_tmpDepartureDelay,_tmpDepartureScheduled,_tmpDepartureEstimated,_tmpDepartureActual,_tmpArrivalAirport,_tmpArrivalTimezone,_tmpArrivalIata,_tmpArrivalIcao,_tmpArrivalTerminal,_tmpArrivalGate,_tmpArrivalDelay,_tmpArrivalScheduled,_tmpArrivalEstimated,_tmpArrivalActual,_tmpAirlineName,_tmpAirlineIata,_tmpAirlineIcao,_tmpFlightNumber,_tmpFlightIata,_tmpFlightIcao);
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
  public Object getFlightById(final String flightId,
      final Continuation<? super FlightEntity> $completion) {
    final String _sql = "SELECT * FROM flights WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, flightId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FlightEntity>() {
      @Override
      @Nullable
      public FlightEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDepartureAirport = CursorUtil.getColumnIndexOrThrow(_cursor, "departureAirport");
          final int _cursorIndexOfDepartureTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "departureTimezone");
          final int _cursorIndexOfDepartureIata = CursorUtil.getColumnIndexOrThrow(_cursor, "departureIata");
          final int _cursorIndexOfDepartureIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "departureIcao");
          final int _cursorIndexOfDepartureTerminal = CursorUtil.getColumnIndexOrThrow(_cursor, "departureTerminal");
          final int _cursorIndexOfDepartureGate = CursorUtil.getColumnIndexOrThrow(_cursor, "departureGate");
          final int _cursorIndexOfDepartureDelay = CursorUtil.getColumnIndexOrThrow(_cursor, "departureDelay");
          final int _cursorIndexOfDepartureScheduled = CursorUtil.getColumnIndexOrThrow(_cursor, "departureScheduled");
          final int _cursorIndexOfDepartureEstimated = CursorUtil.getColumnIndexOrThrow(_cursor, "departureEstimated");
          final int _cursorIndexOfDepartureActual = CursorUtil.getColumnIndexOrThrow(_cursor, "departureActual");
          final int _cursorIndexOfArrivalAirport = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalAirport");
          final int _cursorIndexOfArrivalTimezone = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalTimezone");
          final int _cursorIndexOfArrivalIata = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalIata");
          final int _cursorIndexOfArrivalIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalIcao");
          final int _cursorIndexOfArrivalTerminal = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalTerminal");
          final int _cursorIndexOfArrivalGate = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalGate");
          final int _cursorIndexOfArrivalDelay = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalDelay");
          final int _cursorIndexOfArrivalScheduled = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalScheduled");
          final int _cursorIndexOfArrivalEstimated = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalEstimated");
          final int _cursorIndexOfArrivalActual = CursorUtil.getColumnIndexOrThrow(_cursor, "arrivalActual");
          final int _cursorIndexOfAirlineName = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineName");
          final int _cursorIndexOfAirlineIata = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineIata");
          final int _cursorIndexOfAirlineIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "airlineIcao");
          final int _cursorIndexOfFlightNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "flightNumber");
          final int _cursorIndexOfFlightIata = CursorUtil.getColumnIndexOrThrow(_cursor, "flightIata");
          final int _cursorIndexOfFlightIcao = CursorUtil.getColumnIndexOrThrow(_cursor, "flightIcao");
          final FlightEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpDepartureAirport;
            if (_cursor.isNull(_cursorIndexOfDepartureAirport)) {
              _tmpDepartureAirport = null;
            } else {
              _tmpDepartureAirport = _cursor.getString(_cursorIndexOfDepartureAirport);
            }
            final String _tmpDepartureTimezone;
            if (_cursor.isNull(_cursorIndexOfDepartureTimezone)) {
              _tmpDepartureTimezone = null;
            } else {
              _tmpDepartureTimezone = _cursor.getString(_cursorIndexOfDepartureTimezone);
            }
            final String _tmpDepartureIata;
            if (_cursor.isNull(_cursorIndexOfDepartureIata)) {
              _tmpDepartureIata = null;
            } else {
              _tmpDepartureIata = _cursor.getString(_cursorIndexOfDepartureIata);
            }
            final String _tmpDepartureIcao;
            if (_cursor.isNull(_cursorIndexOfDepartureIcao)) {
              _tmpDepartureIcao = null;
            } else {
              _tmpDepartureIcao = _cursor.getString(_cursorIndexOfDepartureIcao);
            }
            final String _tmpDepartureTerminal;
            if (_cursor.isNull(_cursorIndexOfDepartureTerminal)) {
              _tmpDepartureTerminal = null;
            } else {
              _tmpDepartureTerminal = _cursor.getString(_cursorIndexOfDepartureTerminal);
            }
            final String _tmpDepartureGate;
            if (_cursor.isNull(_cursorIndexOfDepartureGate)) {
              _tmpDepartureGate = null;
            } else {
              _tmpDepartureGate = _cursor.getString(_cursorIndexOfDepartureGate);
            }
            final Integer _tmpDepartureDelay;
            if (_cursor.isNull(_cursorIndexOfDepartureDelay)) {
              _tmpDepartureDelay = null;
            } else {
              _tmpDepartureDelay = _cursor.getInt(_cursorIndexOfDepartureDelay);
            }
            final String _tmpDepartureScheduled;
            if (_cursor.isNull(_cursorIndexOfDepartureScheduled)) {
              _tmpDepartureScheduled = null;
            } else {
              _tmpDepartureScheduled = _cursor.getString(_cursorIndexOfDepartureScheduled);
            }
            final String _tmpDepartureEstimated;
            if (_cursor.isNull(_cursorIndexOfDepartureEstimated)) {
              _tmpDepartureEstimated = null;
            } else {
              _tmpDepartureEstimated = _cursor.getString(_cursorIndexOfDepartureEstimated);
            }
            final String _tmpDepartureActual;
            if (_cursor.isNull(_cursorIndexOfDepartureActual)) {
              _tmpDepartureActual = null;
            } else {
              _tmpDepartureActual = _cursor.getString(_cursorIndexOfDepartureActual);
            }
            final String _tmpArrivalAirport;
            if (_cursor.isNull(_cursorIndexOfArrivalAirport)) {
              _tmpArrivalAirport = null;
            } else {
              _tmpArrivalAirport = _cursor.getString(_cursorIndexOfArrivalAirport);
            }
            final String _tmpArrivalTimezone;
            if (_cursor.isNull(_cursorIndexOfArrivalTimezone)) {
              _tmpArrivalTimezone = null;
            } else {
              _tmpArrivalTimezone = _cursor.getString(_cursorIndexOfArrivalTimezone);
            }
            final String _tmpArrivalIata;
            if (_cursor.isNull(_cursorIndexOfArrivalIata)) {
              _tmpArrivalIata = null;
            } else {
              _tmpArrivalIata = _cursor.getString(_cursorIndexOfArrivalIata);
            }
            final String _tmpArrivalIcao;
            if (_cursor.isNull(_cursorIndexOfArrivalIcao)) {
              _tmpArrivalIcao = null;
            } else {
              _tmpArrivalIcao = _cursor.getString(_cursorIndexOfArrivalIcao);
            }
            final String _tmpArrivalTerminal;
            if (_cursor.isNull(_cursorIndexOfArrivalTerminal)) {
              _tmpArrivalTerminal = null;
            } else {
              _tmpArrivalTerminal = _cursor.getString(_cursorIndexOfArrivalTerminal);
            }
            final String _tmpArrivalGate;
            if (_cursor.isNull(_cursorIndexOfArrivalGate)) {
              _tmpArrivalGate = null;
            } else {
              _tmpArrivalGate = _cursor.getString(_cursorIndexOfArrivalGate);
            }
            final Integer _tmpArrivalDelay;
            if (_cursor.isNull(_cursorIndexOfArrivalDelay)) {
              _tmpArrivalDelay = null;
            } else {
              _tmpArrivalDelay = _cursor.getInt(_cursorIndexOfArrivalDelay);
            }
            final String _tmpArrivalScheduled;
            if (_cursor.isNull(_cursorIndexOfArrivalScheduled)) {
              _tmpArrivalScheduled = null;
            } else {
              _tmpArrivalScheduled = _cursor.getString(_cursorIndexOfArrivalScheduled);
            }
            final String _tmpArrivalEstimated;
            if (_cursor.isNull(_cursorIndexOfArrivalEstimated)) {
              _tmpArrivalEstimated = null;
            } else {
              _tmpArrivalEstimated = _cursor.getString(_cursorIndexOfArrivalEstimated);
            }
            final String _tmpArrivalActual;
            if (_cursor.isNull(_cursorIndexOfArrivalActual)) {
              _tmpArrivalActual = null;
            } else {
              _tmpArrivalActual = _cursor.getString(_cursorIndexOfArrivalActual);
            }
            final String _tmpAirlineName;
            if (_cursor.isNull(_cursorIndexOfAirlineName)) {
              _tmpAirlineName = null;
            } else {
              _tmpAirlineName = _cursor.getString(_cursorIndexOfAirlineName);
            }
            final String _tmpAirlineIata;
            if (_cursor.isNull(_cursorIndexOfAirlineIata)) {
              _tmpAirlineIata = null;
            } else {
              _tmpAirlineIata = _cursor.getString(_cursorIndexOfAirlineIata);
            }
            final String _tmpAirlineIcao;
            if (_cursor.isNull(_cursorIndexOfAirlineIcao)) {
              _tmpAirlineIcao = null;
            } else {
              _tmpAirlineIcao = _cursor.getString(_cursorIndexOfAirlineIcao);
            }
            final String _tmpFlightNumber;
            if (_cursor.isNull(_cursorIndexOfFlightNumber)) {
              _tmpFlightNumber = null;
            } else {
              _tmpFlightNumber = _cursor.getString(_cursorIndexOfFlightNumber);
            }
            final String _tmpFlightIata;
            if (_cursor.isNull(_cursorIndexOfFlightIata)) {
              _tmpFlightIata = null;
            } else {
              _tmpFlightIata = _cursor.getString(_cursorIndexOfFlightIata);
            }
            final String _tmpFlightIcao;
            if (_cursor.isNull(_cursorIndexOfFlightIcao)) {
              _tmpFlightIcao = null;
            } else {
              _tmpFlightIcao = _cursor.getString(_cursorIndexOfFlightIcao);
            }
            _result = new FlightEntity(_tmpId,_tmpDate,_tmpStatus,_tmpDepartureAirport,_tmpDepartureTimezone,_tmpDepartureIata,_tmpDepartureIcao,_tmpDepartureTerminal,_tmpDepartureGate,_tmpDepartureDelay,_tmpDepartureScheduled,_tmpDepartureEstimated,_tmpDepartureActual,_tmpArrivalAirport,_tmpArrivalTimezone,_tmpArrivalIata,_tmpArrivalIcao,_tmpArrivalTerminal,_tmpArrivalGate,_tmpArrivalDelay,_tmpArrivalScheduled,_tmpArrivalEstimated,_tmpArrivalActual,_tmpAirlineName,_tmpAirlineIata,_tmpAirlineIcao,_tmpFlightNumber,_tmpFlightIata,_tmpFlightIcao);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
