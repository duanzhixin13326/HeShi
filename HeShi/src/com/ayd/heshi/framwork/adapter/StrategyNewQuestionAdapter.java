package com.ayd.heshi.framwork.adapter;

import java.util.List;

import com.ayd.heshi.R;
import com.ayd.heshi.framwork.bean.StrategyNewQuestionBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StrategyNewQuestionAdapter extends BaseAdapter {
	private List<StrategyNewQuestionBean> list;
	private LayoutInflater mInflater;

	public StrategyNewQuestionAdapter(Context context,
			List<StrategyNewQuestionBean> list) {
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
//		return null == list ? 0 : list.size();
		return 5;
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_strategy_newquestion,
					null);
			holder = new ViewHolder();
			holder.questionTitle = (TextView) convertView
					.findViewById(R.id.strategy_question_title);
			holder.questionNum = (TextView) convertView
					.findViewById(R.id.strategy_question_num);
			holder.questionCares = (TextView) convertView
					.findViewById(R.id.strategy_question_cares);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// 把内容添加进去 -- 内容暂时没有
		// if (list != null && list.size() > 0) {
		//
		// }
		return convertView;
	}

	class ViewHolder {
		TextView questionTitle;
		TextView questionNum;
		TextView questionCares;
	}

}
