package com.ayd.heshi.framwork.adapter;

import java.util.List;

import com.ayd.heshi.R;
import com.ayd.heshi.framwork.bean.StrategySpecialBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StrategySpecialAdapter extends BaseAdapter {
	private List<StrategySpecialBean> list;
	private LayoutInflater mInflater;

	public StrategySpecialAdapter(Context context,
			List<StrategySpecialBean> list) {
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		if(null == list){
			return 0;
		}else{
			if(list.size() > 0){
				return list.size();
			}else{
				return 5;
			}
		}
//		return null == list ? 0 : list.size();
//		return 5;
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
			convertView = mInflater.inflate(R.layout.item_strategy_special,
					null);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.strategy_special_image);
			holder.title = (TextView) convertView
					.findViewById(R.id.strategy_special_title);
			holder.content = (TextView) convertView
					.findViewById(R.id.strategy_special_content);
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
		ImageView image;
		TextView title;
		TextView content;
	}

}
