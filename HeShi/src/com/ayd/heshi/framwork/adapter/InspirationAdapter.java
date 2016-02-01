package com.ayd.heshi.framwork.adapter;

import java.util.List;

import org.w3c.dom.Text;

import com.ayd.heshi.R;
import com.ayd.heshi.framwork.bean.InspirationBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 灵感类的适配器
 * 
 * @author Administrator
 * 
 */
public class InspirationAdapter extends BaseAdapter {
	private List<InspirationBean> list;
	private LayoutInflater mInflater;

	public InspirationAdapter(Context context, List<InspirationBean> list) {
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// return null == list ? 0 : list.size();
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
			convertView = mInflater.inflate(R.layout.item_inspiration, null);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.inspiration_image);
			holder.msgNum = (TextView) convertView
					.findViewById(R.id.inspiration_msg_num);
			holder.loveNum = (TextView) convertView
					.findViewById(R.id.inspiration_love_num);
			holder.content = (TextView) convertView
					.findViewById(R.id.inspiration_content);
			holder.tab = (TextView) convertView
					.findViewById(R.id.inspiration_tab);
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
		ImageView image;// 图片
		TextView msgNum;// 信息总数
		TextView loveNum;// 关注总数
		TextView content;// 内容
		TextView tab;// 标签
	}

}
