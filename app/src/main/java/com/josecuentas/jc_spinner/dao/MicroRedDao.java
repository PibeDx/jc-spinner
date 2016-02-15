package com.josecuentas.jc_spinner.dao;

/**
 * Created by MiRey on 1/02/16.
 */

import android.database.Cursor;
import android.util.Log;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import com.josecuentas.jc_spinner.model.MicroRed;

import org.json.JSONArray;

import java.util.List;


public class MicroRedDao extends BaseDao<MicroRed, Integer>  {


    public MicroRedDao(DBHelper dbHelper, Class c) {super(dbHelper, c); }


    @Override
    public long crear(MicroRed entidad) {
        int id =0;
        try {
            mDao = getDao();
            id = mDao.create(entidad);
            id = entidad.getCoMicroRed();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Genera MicroRed Dao", "Error creando microred + " + e);
        }
        return id;
    }

    @Override
    public long actualizar(MicroRed entidad) {
        return 0;
    }

    @Override
    public void actualizarIds(JSONArray array) {

    }

    @Override
    public MicroRed obtenerPorId(Integer llave) {
        MicroRed codigoMicrored= null;
        try {
            mDao = getDao();
            QueryBuilder<MicroRed, Integer> queryBuilder = mDao.queryBuilder();
            Where where = queryBuilder.where();
            where.eq(MicroRed.CO_MICRO_RED, llave);
            queryBuilder.prepare();
            codigoMicrored = queryBuilder.queryForFirst();
        } catch (Exception e) {
            Log.e("obtenerPorId", "error al obtenerPorId");
            e.printStackTrace();
        }
        return codigoMicrored;
    }

    @Override
    public List<MicroRed> obtenerTodos() {
        List<MicroRed> listaMicroRed = null;
        try {
            mDao = getDao();
            QueryBuilder<MicroRed, Integer> queryBuilder = mDao.queryBuilder();
            queryBuilder.prepare();
            listaMicroRed = queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMicroRed;
    }


    public List<MicroRed> obtenerTodosByIdRed(int idRed) {
        List<MicroRed> listaMicroRed = null;
        try {
            mDao = getDao();
            QueryBuilder<MicroRed, Integer> queryBuilder = mDao.queryBuilder();
            Where where = queryBuilder.where();
            where.eq("red_id", idRed);
            queryBuilder.prepare();
            listaMicroRed = queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMicroRed;
    }

    @Override
    public boolean eliminarPorId(Integer llave) {
        return false;
    }

    @Override
    public boolean eliminarTodos() {
        try {
            mDao = getDao();
            int cantDelete = TableUtils.clearTable(mDao.getConnectionSource(), MicroRed.class);
            Log.e(this.getClass().getSimpleName(), "Eliminado: "+cantDelete);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.getClass().getSimpleName(), "Error eliminando todo");
            return false;
        }
    }

    @Override
    protected MicroRed obtenerDesdeCursor(Cursor cursor) {
        return null;
    }
}
