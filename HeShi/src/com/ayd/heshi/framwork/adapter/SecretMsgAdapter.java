package com.ayd.heshi.framwork.adapter;

import java.util.ArrayList;
import java.util.List;

import com.ayd.heshi.R;
import com.ayd.heshi.framwork.bean.SecretMsgBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SecretMsgAdapter extends BaseAdapter {
	private List<SecretMsgBean> list = new ArrayList<SecretMsgBean>();
	private LayoutInflater mInflater;

	public SecretMsgAdapter(Context context, List<SecretMsgBean> list) {
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// return null == list ? 0: list.size();
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
			convertView = mInflater.inflate(R.layout.item_secret_msg, null);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.secret_msg_image);
			holder.nickName = (TextView) convertView
					.findViewById(R.id.secret_msg_nickname);
			holder.content = (TextView) convertView
					.findViewById(R.id.secret_msg_content);
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
		TextView content;
	}

}
