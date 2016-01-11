package com.neusoft.fruitvegemis.activity;

import java.util.Map;

import com.neusoft.fruitvegemis.R;
import com.neusoft.fruitvegemis.adapter.OrderAdapter;
import com.neusoft.fruitvegemis.app.AppInterface;
import com.neusoft.fruitvegemis.app.BaseApplication;
import com.neusoft.fruitvegemis.datapool.UOrderRecord;
import com.neusoft.fruitvegemis.persistence.FruitVgDBManager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class OrderFragment extends Fragment {
	public static final String TAG = "OrderFragment";

	private ListView mOrderList;
	private OrderAdapter mAdapter;
	private AppInterface mApp;

	public static OrderFragment getInstance() {
		OrderFragment fragment = new OrderFragment();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mApp = BaseApplication.mBaseApplication.getAppInterface();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_order, null);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initUI(view);
		initData();
	}

	private void initUI(View view) {
		mOrderList = (ListView) view.findViewById(R.id.orderList);
	}

	private void initData() {
		mAdapter = new OrderAdapter(getActivity());
		FruitVgDBManager fVgDBManager = (FruitVgDBManager) mApp
				.getManager(AppInterface.FRUITVG);
		Map<String, UOrderRecord> records = fVgDBManager.getUserOrder();
		mOrderList.setAdapter(mAdapter);
	}
}
