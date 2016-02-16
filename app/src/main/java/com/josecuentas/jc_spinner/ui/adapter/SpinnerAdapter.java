package com.josecuentas.jc_spinner.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.josecuentas.jc_spinner.R;

import java.util.List;






public class SpinnerAdapter extends ArrayAdapter<SpinnerVal> {

	private Context context;
	private List<SpinnerVal> listaValues;
	private int position;
	LayoutInflater inflater;
	private int resource;

	public SpinnerAdapter(Context context, int textViewResourceId,
		List<SpinnerVal> listValues) {
		super(context, textViewResourceId, listValues);
		this.context = context;
		this.listaValues =  listValues;
		this.inflater = LayoutInflater.from(context);
		this.resource = textViewResourceId;
	}

	public int getCount() {
		return listaValues.size();
	}

	public SpinnerVal getItem(int position) {
		return listaValues.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public String getIdSpinnerValues(){
		return listaValues.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView label = new TextView(context);
		label.setTextColor(Color.parseColor("#1A237E"));
		label.setPadding(10, 10, 0, 10);
		label.setTextSize(context.getResources().getInteger(R.integer.size_textospinner));
		label.setText(listaValues.get(position).getValue());
		return label;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		TextView label = new TextView(context);
		label.setTextColor(Color.parseColor("#1A237E"));
		label.setPadding(10, 10, 0, 10);
		label.setTextSize(context.getResources().getInteger(R.integer.size_textospinner));
		label.setText(listaValues.get(position).getValue());
		return label;
	}
}