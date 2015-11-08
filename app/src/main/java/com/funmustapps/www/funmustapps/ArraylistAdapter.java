package com.funmustapps.www.funmustapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArraylistAdapter extends BaseAdapter {



	Context context;
//	String[] Ali;
    ArrayList<String> list2;
	String[] recipiespic;
	String[] name;
	LayoutInflater my;

	public ArraylistAdapter(Context context, ArrayList<String> list2) {
		// TODO Auto-generated constructor stub
		this.context = context;
		//this.recipiespic = recipiespic;
		//this.name =name ;
		this.list2=list2;
	}

	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list2.size();
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

		View itemView = my.inflate(R.layout.listsmsshow, parent, false);



		txtqut = (TextView) itemView.findViewById(R.id.txtsmstext);

		//picw = (TextView) itemView.findViewById(R.id.medium);
		//pictxt = (TextView) itemView.findViewById(R.id.textView2);

		txtqut.setText(list2.get(position));
	//	picw.setText(name[position]);
		//pictxt.setText(recipiespic[position]);
		
		return itemView;
	
		
	}





}
