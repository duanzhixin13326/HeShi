package com.ayd.heshi.framwork.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.framwork.activity.MainActivity;
import com.ayd.heshi.framwork.activity.WriteInspirationActivity;
import com.ayd.heshi.framwork.adapter.InspirationAdapter;
import com.ayd.heshi.framwork.bean.InspirationBean;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 灵感界面
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class Inspiration extends Fragment implements OnClickListener {
	// actionBar控件
	private ImageView actionBarImage;
	private EditText actionBarEt;// 搜索
	private TextView acitonBarText;// 分类

	private List<InspirationBean> list = new ArrayList<InspirationBean>();
	private ListView listView;
	private InspirationAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_inspiration, container,
				false);
		findView(view);
		return view;
	}

	/**
	 * 初始化界面
	 */
	private void findView(View v) {
		listView = (ListView) v.findViewById(R.id.inspiration_list);
		actionBarImage = (ImageView) v.findViewById(R.id.main_action_bar_image);
		actionBarEt = (EditText) v.findViewById(R.id.main_action_bar_edittext);
		acitonBarText = (TextView) v.findViewById(R.id.main_action_bar_text);
		acitonBarText.setText(string.write_inspiration);
		actionBarImage.setOnClickListener(this);
		acitonBarText.setOnClickListener(this);

		adapter = new InspirationAdapter(getActivity(), list);
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
		case R.id.main_action_bar_image:
			// 打开侧滑栏
			MainActivity mainActivity = (MainActivity) getActivity();
			mainActivity.backToLeft();
			break;
		case R.id.main_action_bar_text:
			// 写灵感
			Intent intent = new Intent(getActivity(),
					WriteInspirationActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
