package com.josecuentas.jc_spinner.dao;

import android.database.Cursor;

import com.j256.ormlite.dao.Dao;

import org.json.JSONArray;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Jos? Cuentas Turpo on 10/06/2015 - 10:11 AM.
 * E-mail: jcuentast@gmail.com
 */
public abstract class BaseDao<E, K> {

    private DBHelper mDBHelper;
    protected Dao<E, K> mDao;
    //	private E entidad;
    private Class<E> classEntidad;

    public BaseDao(DBHelper dbHelper, Class<E> c) {
        this.mDBHelper = dbHelper;
        classEntidad = c;
    }

    protected DBHelper getDbHelper() {
        return mDBHelper;
    }

    public Dao<E, K> getDao() throws SQLException {
        if (mDao == null) {
            mDao = mDBHelper.getDao(classEntidad);
        }
        return mDao;
    }

    public void close() {
        mDao = null;
    }

    public abstract long crear(E entidad);

    public abstract long actualizar(E entidad);

    public abstract void actualizarIds(JSONArray array);

    public abstract E obtenerPorId(K llave);

    public abstract List<E> obtenerTodos();

    public abstract boolean eliminarPorId(K llave);

    public abstract boolean eliminarTodos();

    protected abstract E obtenerDesdeCursor(Cursor cursor);


}
