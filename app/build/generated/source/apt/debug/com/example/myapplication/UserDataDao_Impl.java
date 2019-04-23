package com.example.myapplication;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public class UserDataDao_Impl implements UserDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfuser_data;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfuser_data;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfuser_data;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUserData;

  public UserDataDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfuser_data = new EntityInsertionAdapter<user_data>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user_data`(`id`,`name`,`email`,`phone`,`dob`,`password`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, user_data value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getDob() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDob());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
      }
    };
    this.__deletionAdapterOfuser_data = new EntityDeletionOrUpdateAdapter<user_data>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user_data` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, user_data value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfuser_data = new EntityDeletionOrUpdateAdapter<user_data>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user_data` SET `id` = ?,`name` = ?,`email` = ?,`phone` = ?,`dob` = ?,`password` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, user_data value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getDob() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDob());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        stmt.bindLong(7, value.getId());
      }
    };
    this.__preparedStmtOfDeleteUserData = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM user_data";
        return _query;
      }
    };
  }

  @Override
  public void saveAll(user_data user_data) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfuser_data.insert(user_data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(user_data user_data) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfuser_data.insert(user_data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(user_data user_data) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfuser_data.handle(user_data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(user_data user_data) {
    __db.beginTransaction();
    try {
      __updateAdapterOfuser_data.handle(user_data);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUserData() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUserData.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUserData.release(_stmt);
    }
  }

  @Override
  public int getUser(String email, String password) {
    final String _sql = "SELECT * FROM user_data WHERE email = ? AND password = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
