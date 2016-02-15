package com.josecuentas.jc_spinner.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.josecuentas.jc_spinner.model.MicroRed;
import com.josecuentas.jc_spinner.model.Red;

import java.sql.SQLException;

/**
 * Created by apurisaca on 20/01/2016.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {


    public static final String DATABASE_NAME = "androcode_ormlite.db2";
    private static final int DATABASE_VERSION = 9;
    


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
        try {
            TableUtils.createTable(connectionSource, Red.class);
            TableUtils.createTable(connectionSource, MicroRed.class);
           // Log.i("onCreate", "Se creó la BD " + this.getClass().getSimpleName());

        } catch (SQLException e) {
            Log.e("onCreate", "Error al crear tablas");
            e.printStackTrace();
//			throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
                          int arg3) {
        try {

            TableUtils.clearTable(connectionSource, Red.class);
            TableUtils.clearTable(connectionSource, MicroRed.class);
            Log.i("onUpgrade","Se actualizó la BD");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.e("onUpgrade", "No se actualizó la BD");
        }
        onCreate(arg0, connectionSource);

    }
    @Override
    public void close() {
        super.close();
    }



}
