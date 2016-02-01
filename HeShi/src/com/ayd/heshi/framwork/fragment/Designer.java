package com.ayd.heshi.framwork.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.framwork.activity.MainActivity;
import com.ayd.heshi.framwork.adapter.DesignerAdapter;
import com.ayd.heshi.framwork.bean.DesiginerBean;
import com.ayd.heshi.framwork.popupwindow.MorePopupWindow;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 设计师界面
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class Designer extends Fragment implements OnClickListener {
	// actionBar控件
	private ImageView actionBarImage;
	private EditText actionBarEt;// 搜索
	private TextView acitonBarText;// 分类

	private List<DesiginerBean> list = new ArrayList<DesiginerBean>();
	private ListView listView;
	private DesignerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_designer, container,
				false);
		findView(view);
		return view;
	}

	/**
	 * 初始化界面
	 */
	private void findView(View v) {
		listView = (ListView) v.findViewById(R.id.designer_list);
		actionBarImage = (ImageView) v.findViewById(R.id.main_action_bar_image);
		actionBarEt = (EditText) v.findViewById(R.id.main_action_bar_edittext);
		acitonBarText = (TextView) v.findViewById(R.id.main_action_bar_text);
		acitonBarText.setText(string.make_kinds);
		actionBarImage.setOnClickListener(this);
		acitonBarText.setOnClickListener(this);

		adapter = new DesignerAdapter(getActivity(), list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
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
			// 分类 - 弹出窗体
			MorePopupWindow morePopupWindow = new MorePopupWindow(getActivity());
			morePopupWindow.showPopupWindow(acitonBarText);
			break;

		default:
			break;
		}
	}
}
