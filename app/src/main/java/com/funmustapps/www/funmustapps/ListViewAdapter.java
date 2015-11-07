package com.funmustapps.www.funmustapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	
	
	Context context;
//	String[] Ali;
	String[] recipiespic;
	String[] name;
	LayoutInflater my;

	public ListViewAdapter(Context context, String[] name) {
		// TODO Auto-generated constructor stub
		this.context = context;
		//this.recipiespic = recipiespic;
		this.name =name ;
	}

	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView txtqut;
		TextView picw,pictxt;
		my = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = my.inflate(R.layout.item_layout, parent, false);



		//txtqut = (TextView) itemView.findViewById(R.id.textView1);

		//picw = (TextView) itemView.findViewById(R.id.medium);
		//pictxt = (TextView) itemView.findViewById(R.id.textView2);

	
	//	picw.setText(name[position]);
		//pictxt.setText(recipiespic[position]);
		
		return itemView;
	
		
	}





}
