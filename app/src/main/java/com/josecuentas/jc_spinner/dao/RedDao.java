package com.josecuentas.jc_spinner.dao;

import android.database.Cursor;
import android.util.Log;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import com.josecuentas.jc_spinner.model.Red;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by IID on 1/02/16.
 */
public class RedDao extends BaseDao<Red, Integer>  {

    public RedDao(DBHelper dbHelper, Class c) {super(dbHelper, c); }

    @Override
    public long crear(Red entidad) {
        int id =0;
        try {
            mDao = getDao();
            id = mDao.create(entidad);
            id = entidad.getCoRed();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Genero Dao", "Error creando generos + " + e);
        }
        return id;
    }

    @Override
    public long actualizar(Red entidad) {
        return 0;
    }

    @Override
    public void actualizarIds(JSONArray array) {

    }

    @Override
    public Red obtenerPorId(Integer llave) {
        Red codigoRed= null;
        try {
            mDao = getDao();
            QueryBuilder<Red, Integer> queryBuilder = mDao.queryBuilder();
            Where where = queryBuilder.where();
            where.eq(Red.CO_RED, llave);
            queryBuilder.prepare();
            codigoRed = queryBuilder.queryForFirst();
        } catch (Exception e) {
            Log.e("obtenerPorId", "error al obtenerPorId");
            e.printStackTrace();
        }
        return codigoRed;
    }

    @Override
    public List<Red> obtenerTodos() {
        List<Red> listaRed = null;
        try {
            mDao = getDao();
            QueryBuilder<Red, Integer> queryBuilder = mDao.queryBuilder();
            queryBuilder.prepare();
            listaRed = queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRed;
    }


    @Override
    public boolean eliminarPorId(Integer llave) {
        return false;
    }

    @Override
    public boolean eliminarTodos() {
        try {
            mDao = getDao();
            int cantDelete = TableUtils.clearTable(mDao.getConnectionSource(), Red.class);
            Log.e(this.getClass().getSimpleName(), "Eliminado: "+cantDelete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getSimpleName(), "Error eliminando todo");
            return false;
        }
    }

    @Override
    protected Red obtenerDesdeCursor(Cursor cursor) {
        return null;
    }
}
