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
 * ��н���
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class Inspiration extends Fragment implements OnClickListener {
	// actionBar�ؼ�
	private ImageView actionBarImage;
	private EditText actionBarEt;// ����
	private TextView acitonBarText;// ����

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
	 * ��ʼ������
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
	 * ��������ӵ�listview�� -- ��ʱû�нӿڣ����Լ��صķ�����һ�£���ֱ���ڳ�ʼ�������н��м���
	 */
	private void addData() {

	}

	/**
	 * ��ȡ���ݵĽӿ�
	 */
	private void getData() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_action_bar_image:
			// �򿪲໬��
			MainActivity mainActivity = (MainActivity) getActivity();
			mainActivity.backToLeft();
			break;
		case R.id.main_action_bar_text:
			// д���
			Intent intent = new Intent(getActivity(),
					WriteInspirationActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
