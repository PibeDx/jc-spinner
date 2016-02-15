package com.josecuentas.jc_spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.josecuentas.jc_spinner.dao.DBHelper;
import com.josecuentas.jc_spinner.dao.MicroRedDao;
import com.josecuentas.jc_spinner.dao.RedDao;
import com.josecuentas.jc_spinner.model.MicroRed;
import com.josecuentas.jc_spinner.model.Red;
import com.josecuentas.jc_spinner.ui.adapter.SpinnerAdapter;
import com.josecuentas.jc_spinner.ui.adapter.SpinnerVal;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();



    @Bind(R.id.txv_mensaje) TextView mTxvMensaje;
    @Bind(R.id.sp_red) Spinner mSpRed;
    @Bind(R.id.sp_microred) Spinner mSpMicrored;
    SpinnerAdapter mRedAdapter;
    SpinnerAdapter mMicroRedAdapter;
    String idRed = "-1", idMicroRed = "-1";

    DBHelper mDBHelper;
    RedDao mRedDao;
    MicroRedDao mMicroRedDao;

    Red mRed;
    MicroRed mMicroRed;
    SpinnerVal mSpinnerValRed, mSpinnerValMicroRed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDao();
        clearData();
        initData();
        initSpinnerAdapters();
        //initSpinnerOnItemSelectListener();
        initSelectionSpinner();

        mRed = new Red(2, "Red 2", String.valueOf(2));
        mMicroRed = new MicroRed(5, "MicroRed5", new Red(2));
        mSpinnerValRed = new SpinnerVal("2","Red 2");
        mSpinnerValMicroRed = new SpinnerVal("5", "MicroRed5");

        int positionRed = mRedAdapter.getPosition(mSpinnerValRed);
        Log.i(TAG, "positionRed: " +positionRed);
        mSpRed.setSelection(positionRed);

        initSpinnerMicroRed(2);

        int positionMicroRed = mMicroRedAdapter.getPosition(mSpinnerValMicroRed);
        Log.i(TAG, "positionMicroRed: " +positionMicroRed);
        mSpMicrored.setSelection(positionMicroRed);
        initSpinnerOnItemSelectListener();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    private void initDao() {
        mDBHelper = new DBHelper(getBaseContext());
        mRedDao = new RedDao(mDBHelper, Red.class);
        mMicroRedDao = new MicroRedDao(mDBHelper, MicroRed.class);
    }

    private void clearData() {
        mRedDao.eliminarTodos();
        mMicroRedDao.eliminarTodos();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            int id= i+1;
            String codigo = String.valueOf(i+1);
            String name = "Red "+ id;
            mRedDao.crear(new Red(id,name,codigo));
            createMicroRed(id, i);
        }
    }

    private void createMicroRed(int idRed, int cantidad) {
        for (int i = 0; i < 3 ; i++) {
            int numero = (idRed-1)*3+1;
            String name = "MicroRed" + (numero+i);
            mMicroRedDao.crear(new MicroRed(numero+i,name, new Red(idRed)));
        }
    }


    private void initSpinnerAdapters() {
        List<Red> redList = mRedDao.obtenerTodos();
        List<SpinnerVal> spinnerReds = new ArrayList<>();
        for (Red red : redList) {
            spinnerReds.add(new SpinnerVal(String.valueOf(red.getCoRed()),red.getGetDeRed()));
        }
        mRedAdapter = new SpinnerAdapter(getBaseContext(),android.R.layout.simple_dropdown_item_1line, spinnerReds);
        mSpRed.setAdapter(mRedAdapter);
    }
    private void initSpinnerOnItemSelectListener() {
        mSpRed.setOnItemSelectedListener(new spRedOnItemSelectListenes());
    }

    class spRedOnItemSelectListenes implements AdapterView.OnItemSelectedListener {
        @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            idRed= mRedAdapter.getItem(position).getId();
            Log.i(TAG, idRed);
            ///Log.i(TAG, String.valueOf(mMinsa.getRed().getCoRed()));
            if (!idRed.equals("-1")) {
//                if (/*microRedAdapter==null && */!idRed.equals(String.valueOf(mMinsa.getRed().getCoRed()))) {
                Log.i(TAG, "microRedAdapter!=null");
                initSpinnerMicroRed(Integer.valueOf(idRed));
//                }

            }
            SpinnerVal red = mRedAdapter.getItem(position);
            //SpinnerVal redSpinnerVal = new SpinnerVal(String.valueOf(minsa.getRed().getCoRed()),minsa.getRed().getGetDeRed());
            int positions = mRedAdapter.getPosition(red);
            Log.i(TAG,"position redSpinnerVal: "+positions);
        }
        @Override public void onNothingSelected(AdapterView<?> parent) {}
    }

    private void initSelectionSpinner() {

    }

    private void initSpinnerMicroRed(int idRed) {
        List<MicroRed> microRedList = mMicroRedDao.obtenerTodosByIdRed(idRed);
        List<SpinnerVal> spinnerReds = new ArrayList<>();
        for (MicroRed microRed : microRedList) {
            spinnerReds.add(new SpinnerVal(String.valueOf(microRed.getCoMicroRed()), microRed.getDeMicroRed()));
        }
        mMicroRedAdapter = new SpinnerAdapter(getBaseContext(), android.R.layout.simple_dropdown_item_1line, spinnerReds);
        mSpMicrored.setAdapter(mMicroRedAdapter);
    }
}
