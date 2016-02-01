package com.ayd.heshi.framwork.activity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.base.BaseActivity;
import com.ayd.heshi.framwork.fragment.Designer;
import com.ayd.heshi.framwork.fragment.Inspiration;
import com.ayd.heshi.framwork.fragment.MyCares;
import com.ayd.heshi.framwork.fragment.SecretMessage;
import com.ayd.heshi.framwork.fragment.Strategy;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 主界面
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class MainActivity extends BaseActivity {
	private Context context;

	// 主界面控件
	private TextView mainInspiration;
	private TextView mainStrategy;
	private TextView mainDesigner;

	// 几个fragment
	private Designer designer;
	private Inspiration inspiration;
	private MyCares myCares;
	private SecretMessage secretMessage;
	private Strategy strategy;
	private FragmentManager fragmentManager;

	// 左侧滑栏的控件
	private RelativeLayout left_mySecret, left_myInspiration, left_myCares,
			left_nightCode, left_setMsg, left_usernamePsw, left_helpSug,
			left_quitLogin;
	// 左侧滑栏的显示
	private ImageView left_menuIamge;// 个人图片
	private TextView left_inckName, left_autograph;// 昵称和签名

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_main);
	}

	@Override
	public void dealLogicBeforeInitView() {
		context = getApplicationContext();
	}

	public SlidingMenu slidingMenu;// 侧滑栏
	private View view_left;

	@Override
	public void initView() {
		createSlidingmenu();// 定义左侧滑栏

		// 定义主界面控件
		mainDesigner = (TextView) findViewById(R.id.main_activity_designer);
		mainInspiration = (TextView) findViewById(R.id.main_activity_inspiration);
		mainStrategy = (TextView) findViewById(R.id.main_activity_strategy);
		mainDesigner.setOnClickListener(this);
		mainInspiration.setOnClickListener(this);
		mainStrategy.setOnClickListener(this);
	}

	@Override
	public void dealLogicAfterInitView() {
		fragmentManager = getFragmentManager();
		// 第一次启动时选中第0个tab
		setTabSelection(0);
	}

	/**
	 * 左侧滑栏实现的代码区域
	 */
	private void createSlidingmenu() {
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);// 设置在屏幕上从左往右划出
		slidingMenu.setShadowDrawable(R.drawable.shadow);// 设置边界的阴影
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);// 设置阴影宽度
		slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_width);// 设置菜单宽度

		// 设置手势模式
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);// 设置从屏幕上滑动范围
		// 设置淡入淡出的比例
		slidingMenu.setFadeDegree(0.4f);
		slidingMenu.setBehindScrollScale(0.3f);

		// 左边的view初始化
		view_left = LayoutInflater.from(this).inflate(R.layout.main_left_menu,
				null);
		slidingMenu.setMenu(view_left);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);// 将侧滑栏附加到activity上
		// 设置滑动时菜单的是否淡入淡出
		slidingMenu.setFadeEnabled(true);
		initLeftMenu();
	}

	/**
	 * 初始化左侧滑栏
	 */
	public void initLeftMenu() {
		left_menuIamge = (ImageView) view_left
				.findViewById(R.id.left_menu_iamge);
		left_inckName = (TextView) view_left
				.findViewById(R.id.left_menu_nickname);
		left_autograph = (TextView) view_left
				.findViewById(R.id.left_menu_autograph);

		// 左侧的控件
		left_mySecret = (RelativeLayout) view_left
				.findViewById(R.id.left_my_secret_message);
		left_myInspiration = (RelativeLayout) view_left
				.findViewById(R.id.left_my_inspirations);
		left_myCares = (RelativeLayout) view_left
				.findViewById(R.id.left_my_cares);
		left_nightCode = (RelativeLayout) view_left
				.findViewById(R.id.left_night_mode);
		left_setMsg = (RelativeLayout) view_left
				.findViewById(R.id.left_set_msg);
		left_usernamePsw = (RelativeLayout) view_left
				.findViewById(R.id.left_username_psw);
		left_helpSug = (RelativeLayout) view_left
				.findViewById(R.id.left_help_and_sug);
		left_quitLogin = (RelativeLayout) view_left
				.findViewById(R.id.left_quit_login);

		left_mySecret.setOnClickListener(this);
		left_myInspiration.setOnClickListener(this);
		left_myCares.setOnClickListener(this);
		left_nightCode.setOnClickListener(this);
		left_setMsg.setOnClickListener(this);
		left_usernamePsw.setOnClickListener(this);
		left_helpSug.setOnClickListener(this);
		left_quitLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_activity_inspiration:
			// 灵感
			setTabSelection(0);
			// 更改字体颜色
			changTextColor(0);
			break;
		case R.id.main_activity_strategy:
			// 攻略
			setTabSelection(1);
			changTextColor(1);
			break;
		case R.id.main_activity_designer:
			// 设计师
			setTabSelection(2);
			changTextColor(2);
			break;
		case R.id.left_my_secret_message:
			// 我的私信
			setTabSelection(3);
			slidingMenu.showContent();// 显示右边
			changTextColor(3);
			break;
		case R.id.left_my_inspirations:
			// 我的灵感库
			// slidingMenu.showContent();// 显示右边 -- 需要吗？
			startActivity(new Intent(context, InspirationHome.class));
			break;
		case R.id.left_my_cares:
			// 我的关注
			setTabSelection(4);
			slidingMenu.showContent();// 显示右边
			changTextColor(3);
			break;
		case R.id.left_night_mode:
			// 夜间模式 -- 测试
			startActivity(new Intent(context, LoginActivity.class));

			break;
		case R.id.left_set_msg:
			// 消息设置
			startActivity(new Intent(context, SetMessageActivity.class));
			break;
		case R.id.left_username_psw:
			// 帐号和密码
			startActivity(new Intent(context, AccountPswActivity.class));
			break;
		case R.id.left_help_and_sug:
			// 帮助与反馈
			startActivity(new Intent(context, HelpSugActivity.class));
			break;
		case R.id.left_quit_login:
			// 退出登录

			break;
		}
	}

	/**
	 * 根据传入的index参数来设置选中的tab页 每个tab页对应的下表。0灵感，1攻略，2设计师，3我的私信，4我的关注
	 */
	private void setTabSelection(int index) {
		// 每次选中之前先清除掉上次的选中状态
		clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了消息tab时，改变控件的文字颜色
			if (inspiration == null) {
				inspiration = new Inspiration();
				transaction.add(R.id.main_activity_content, inspiration);
			} else {
				transaction.show(inspiration);
			}
			break;
		case 1:
			if (strategy == null) {
				strategy = new Strategy();
				transaction.add(R.id.main_activity_content, strategy);
			} else {
				transaction.show(strategy);
			}
			break;
		case 2:
			if (designer == null) {
				designer = new Designer();
				transaction.add(R.id.main_activity_content, designer);
			} else {
				transaction.show(designer);
			}
			break;
		case 3:
			if (secretMessage == null) {
				secretMessage = new SecretMessage();
				transaction.add(R.id.main_activity_content, secretMessage);
			} else {
				transaction.show(secretMessage);
			}
			break;
		case 4:
			if (myCares == null) {
				myCares = new MyCares();
				transaction.add(R.id.main_activity_content, myCares);
			} else {
				transaction.show(myCares);
			}
			break;
		}
		transaction.commit();
	}

	/**
	 * 清除掉所有的选中状态
	 */
	private void clearSelection() {

	}

	/**
	 * 隐藏fragment
	 * 
	 * @param transaction
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (designer != null) {
			transaction.hide(designer);
		}
		if (inspiration != null) {
			transaction.hide(inspiration);
		}
		if (myCares != null) {
			transaction.hide(myCares);
		}
		if (secretMessage != null) {
			transaction.hide(secretMessage);
		}
		if (strategy != null) {
			transaction.hide(strategy);
		}
	}

	/**
	 * 更改字体颜色
	 */
	private void changTextColor(int index) {
		switch (index) {
		case 0:
			mainInspiration
					.setTextColor(getResources().getColor(R.color.brown));
			mainStrategy.setTextColor(getResources().getColor(R.color.write));
			mainDesigner.setTextColor(getResources().getColor(R.color.write));
			break;
		case 1:
			mainInspiration
					.setTextColor(getResources().getColor(R.color.write));
			mainStrategy.setTextColor(getResources().getColor(R.color.brown));
			mainDesigner.setTextColor(getResources().getColor(R.color.write));
			break;
		case 2:
			mainInspiration
					.setTextColor(getResources().getColor(R.color.write));
			mainStrategy.setTextColor(getResources().getColor(R.color.write));
			mainDesigner.setTextColor(getResources().getColor(R.color.brown));
			break;
		case 3:
			mainInspiration
					.setTextColor(getResources().getColor(R.color.write));
			mainStrategy.setTextColor(getResources().getColor(R.color.write));
			mainDesigner.setTextColor(getResources().getColor(R.color.write));
			break;
		}
	}

	/**
	 * 返回到第一个tab的方法
	 */
	public void backToTabOne() {
		setTabSelection(0);
		changTextColor(0);
	}

	/**
	 * 切换到左边的侧滑栏
	 */
	public void backToLeft() {
		// 点击弹出侧滑栏
		slidingMenu.showMenu(true);// 切换左边
	}
}
