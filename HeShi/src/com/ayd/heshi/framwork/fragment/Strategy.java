package com.ayd.heshi.framwork.fragment;

import java.util.ArrayList;
import java.util.List;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.framwork.activity.MainActivity;
import com.ayd.heshi.framwork.adapter.StrategyNewAnswerAdapter;
import com.ayd.heshi.framwork.adapter.StrategyNewQuestionAdapter;
import com.ayd.heshi.framwork.adapter.StrategySpecialAdapter;
import com.ayd.heshi.framwork.bean.StrategyNewAnswerBean;
import com.ayd.heshi.framwork.bean.StrategyNewQuestionBean;
import com.ayd.heshi.framwork.bean.StrategySpecialBean;

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
 * ���Խ���
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class Strategy extends Fragment implements OnClickListener {
	// actionBar�ؼ�
	private ImageView actionBarImage;
	private EditText actionBarEt;// ����
	private TextView acitonBarText;// ����

	// ����ؼ�
	private TextView specialText, newAnswerText, newQuestionText;
	private ListView listView;

	private List<StrategySpecialBean> specialList = new ArrayList<StrategySpecialBean>();// ���Ե�ר���б�
	private List<StrategyNewAnswerBean> answerlist = new ArrayList<StrategyNewAnswerBean>();// ���Ե����»ش��б�
	private List<StrategyNewQuestionBean> questionList = new ArrayList<StrategyNewQuestionBean>();// ���Ե����������б�
	private StrategySpecialAdapter specialAdapter;
	private StrategyNewAnswerAdapter answerAdapter;
	private StrategyNewQuestionAdapter questionAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_strategy, container,
				false);
		findView(view);
		return view;
	}

	/**
	 * ��ʼ������
	 */
	private void findView(View v) {
		specialText = (TextView) v.findViewById(R.id.strategy_special);
		actionBarImage = (ImageView) v.findViewById(R.id.main_action_bar_image);
		actionBarEt = (EditText) v.findViewById(R.id.main_action_bar_edittext);
		acitonBarText = (TextView) v.findViewById(R.id.main_action_bar_text);
		acitonBarText.setText(string.make_question);
		actionBarImage.setOnClickListener(this);
		acitonBarText.setOnClickListener(this);

		newAnswerText = (TextView) v.findViewById(R.id.strategy_new_answer);
		newQuestionText = (TextView) v.findViewById(R.id.strategy_new_question);
		specialText.setOnClickListener(this);
		newAnswerText.setOnClickListener(this);
		newQuestionText.setOnClickListener(this);

		listView = (ListView) v.findViewById(R.id.strategy_list);
		addList(1);
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
			// ����

			break;
		case R.id.strategy_special:
			// ����ר���б�
			addList(0);
			setTextColor(0);
			break;
		case R.id.strategy_new_answer:
			// �������»ش��б�
			addList(1);
			setTextColor(1);
			break;
		case R.id.strategy_new_question:
			// �������������б�
			addList(2);
			setTextColor(2);
			break;
		}
	}

	/**
	 * ���ݲ�ͬ����������ز�ͬ���б� 0ר��,1���»ش�,2��������
	 */
	private void addList(int index) {
		switch (index) {
		case 0:
			System.out.println("==�����0=");
			specialAdapter = new StrategySpecialAdapter(getActivity(),
					specialList);
			listView.setAdapter(specialAdapter);
			break;
		case 1:
			System.out.println("==�����1=");
			answerAdapter = new StrategyNewAnswerAdapter(getActivity(),
					answerlist);
			listView.setAdapter(answerAdapter);
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					StrategyNewAnswerBean newAnswerBean = answerlist
							.get(position);

				}
			});
			break;
		case 2:
			System.out.println("==�����2=");
			questionAdapter = new StrategyNewQuestionAdapter(getActivity(),
					questionList);
			listView.setAdapter(questionAdapter);
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					StrategyNewQuestionBean newQuestionBean = questionList
							.get(position);

				}
			});
			break;
		}
	}

	/**
	 * ���ݵ��������仯������ɫ
	 */
	private void setTextColor(int index) {
		switch (index) {
		case 0:
			specialText.setTextColor(getResources().getColor(R.color.brown));
			newAnswerText.setTextColor(getResources().getColor(R.color.black));
			newQuestionText
					.setTextColor(getResources().getColor(R.color.black));
			break;
		case 1:
			specialText.setTextColor(getResources().getColor(R.color.black));
			newAnswerText.setTextColor(getResources().getColor(R.color.brown));
			newQuestionText
					.setTextColor(getResources().getColor(R.color.black));
			break;
		case 2:
			specialText.setTextColor(getResources().getColor(R.color.black));
			newAnswerText.setTextColor(getResources().getColor(R.color.black));
			newQuestionText
					.setTextColor(getResources().getColor(R.color.brown));
			break;
		}
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

}
