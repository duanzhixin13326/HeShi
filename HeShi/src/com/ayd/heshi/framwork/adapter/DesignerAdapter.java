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
import com.ayd.heshi.framwork.bean.DesiginerBean;

public class DesignerAdapter extends BaseAdapter {
	private List<DesiginerBean> list;
	private LayoutInflater mInflater;

	public DesignerAdapter(Context context, List<DesiginerBean> list) {
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// return null == list ?0：list.size() ;
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
			convertView = mInflater.inflate(R.layout.item_designer, null);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.designer_image);
			holder.nickName = (TextView) convertView
					.findViewById(R.id.designer_nickname);
			holder.introduce = (TextView) convertView
					.findViewById(R.id.designer_introduce);
			holder.content = (TextView) convertView
					.findViewById(R.id.designer_content);
			holder.total = (TextView) convertView
					.findViewById(R.id.designer_total);
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
		TextView nickName;
		TextView introduce;
		TextView content;
		TextView total;
	}
}
