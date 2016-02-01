package com.ayd.heshi.framwork.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.framwork.bean.StrategyNewAnswerBean;

public class StrategyNewAnswerAdapter extends BaseAdapter {
	private List<StrategyNewAnswerBean> list;
	private LayoutInflater mInflater;

	public StrategyNewAnswerAdapter(Context context,
			List<StrategyNewAnswerBean> list) {
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// return null == list?0:list.size();
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
			convertView = mInflater.inflate(R.layout.item_strategy_newanswer,
					null);
			holder = new ViewHolder();
			holder.iamge = (ImageView) convertView
					.findViewById(R.id.strategy_iamge);
			holder.praiseTotal = (TextView) convertView
					.findViewById(R.id.strategy_total);
			holder.strategyTitle = (TextView) convertView
					.findViewById(R.id.strategy_title);
			holder.strategyContent = (TextView) convertView
					.findViewById(R.id.strategy_content);
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
		ImageView iamge;// 图片
		TextView praiseTotal;// 点赞总数
		TextView strategyTitle;// 攻略抬头
		TextView strategyContent;// 攻略主体内容
	}
}
