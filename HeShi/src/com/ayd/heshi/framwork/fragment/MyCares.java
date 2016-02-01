package com.ayd.heshi.framwork.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.framwork.activity.MainActivity;
import com.ayd.heshi.framwork.adapter.MyCareAdapter;
import com.ayd.heshi.framwork.bean.MyCareBean;

/**
 * 我的关注界面
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class MyCares extends Fragment implements OnClickListener {
	// actionbar控件
	private Button acitonBarBtn;// 返回
	private TextView actionBarTitle;// 抬头
	private TextView actionBarWrite;// 写信

	private List<MyCareBean> list = new ArrayList<MyCareBean>();
	private ListView listView;
	private MyCareAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_cares, container,
				false);
		findView(view);
		return view;
	}

	/**
	 * 初始化界面
	 */
	private void findView(View v) {
		acitonBarBtn = (Button) v.findViewById(R.id.main_action_bar_button);
		acitonBarBtn.setOnClickListener(this);
		actionBarTitle = (TextView) v.findViewById(R.id.main_action_bar_title);
		actionBarTitle.setText(string.my_cares);
		actionBarWrite = (TextView) v.findViewById(R.id.main_action_bar_write);
		actionBarWrite.setVisibility(View.INVISIBLE);
		actionBarWrite.setEnabled(false);

		listView = (ListView) v.findViewById(R.id.mycare_list);
		adapter = new MyCareAdapter(getActivity(), list);
		listView.setAdapter(adapter);
	}

	/**
	 * 把数据添加到listview中 -- 暂时没有接口，所以加载的方法不一致，先直接在初始化界面中进行加载
	 */
	private void addData() {

	}

	/**
	 * 获取数据的接口
	 */
	private void getData() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_action_bar_button:
			// 返回
			MainActivity mainActivity = (MainActivity) getActivity();
			mainActivity.backToTabOne();
			break;
		}
	}
}
