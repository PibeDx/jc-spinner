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




//import pe.gob.susalud.vector.model.SpinnerVal;

public class SpinnerAdapter extends ArrayAdapter<SpinnerVal> {

	private Context context;
//	private SpinnerVal[] values;
	private List<SpinnerVal> listaValues;
	private int position;
	LayoutInflater inflater;
	private int resource;

	public SpinnerAdapter(Context context, int textViewResourceId,
			/*SpinnerVal[] values,*/ List<SpinnerVal> listValues) {
		super(context, textViewResourceId, listValues);
		this.context = context;
//		this.values = values;
		this.listaValues =  listValues;
		this.inflater = LayoutInflater.from(context);
		this.resource = textViewResourceId;
	}

	public int getCount() {
//		return values.length;
		return listaValues.size();
	}

	public SpinnerVal getItem(int position) {
//		return values[position];
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

//		View view;
//		TextView text;
//
//		if (convertView == null) {
//			view = inflater.inflate(resource, parent, false);
//		} else {
//			view = convertView;
//		}
//
//		try {
//			if (/*mFieldId == 0*/false) {
//				//  If no custom field is assigned, assume the whole resource is a TextView
//				text = (TextView) view;
//			} else {
//				//  Otherwise, find the TextView field within the layout
//				text = (TextView) view.findViewById(android.R.id.text1);
//			}
//		} catch (ClassCastException e) {
//			Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
//			throw new IllegalStateException(
//					"ArrayAdapter requires the resource ID to be a TextView", e);
//		}
//
//		SpinnerVal item = getItem(position);
//		if (item instanceof CharSequence) {
//			text.setText((CharSequence)item.getValue());
//		} else {
//			text.setText(item.getValue().toString());
//		}
//		this.position = position;

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

	class PlaceHolder {
		TextView txvValue;
	}

}
