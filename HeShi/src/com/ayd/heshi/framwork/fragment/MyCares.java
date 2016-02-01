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
 * �ҵĹ�ע����
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class MyCares extends Fragment implements OnClickListener {
	// actionbar�ؼ�
	private Button acitonBarBtn;// ����
	private TextView actionBarTitle;// ̧ͷ
	private TextView actionBarWrite;// д��

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
	 * ��ʼ������
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
		case R.id.main_action_bar_button:
			// ����
			MainActivity mainActivity = (MainActivity) getActivity();
			mainActivity.backToTabOne();
			break;
		}
	}
}
