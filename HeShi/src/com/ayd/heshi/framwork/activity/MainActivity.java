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
 * ������
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class MainActivity extends BaseActivity {
	private Context context;

	// ������ؼ�
	private TextView mainInspiration;
	private TextView mainStrategy;
	private TextView mainDesigner;

	// ����fragment
	private Designer designer;
	private Inspiration inspiration;
	private MyCares myCares;
	private SecretMessage secretMessage;
	private Strategy strategy;
	private FragmentManager fragmentManager;

	// ��໬���Ŀؼ�
	private RelativeLayout left_mySecret, left_myInspiration, left_myCares,
			left_nightCode, left_setMsg, left_usernamePsw, left_helpSug,
			left_quitLogin;
	// ��໬������ʾ
	private ImageView left_menuIamge;// ����ͼƬ
	private TextView left_inckName, left_autograph;// �ǳƺ�ǩ��

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_main);
	}

	@Override
	public void dealLogicBeforeInitView() {
		context = getApplicationContext();
	}

	public SlidingMenu slidingMenu;// �໬��
	private View view_left;

	@Override
	public void initView() {
		createSlidingmenu();// ������໬��

		// ����������ؼ�
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
		// ��һ������ʱѡ�е�0��tab
		setTabSelection(0);
	}

	/**
	 * ��໬��ʵ�ֵĴ�������
	 */
	private void createSlidingmenu() {
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);// ��������Ļ�ϴ������һ���
		slidingMenu.setShadowDrawable(R.drawable.shadow);// ���ñ߽����Ӱ
		slidingMenu.setShadowWidthRes(R.dimen.shadow_width);// ������Ӱ���
		slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_width);// ���ò˵����

		// ��������ģʽ
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);// ���ô���Ļ�ϻ�����Χ
		// ���õ��뵭���ı���
		slidingMenu.setFadeDegree(0.4f);
		slidingMenu.setBehindScrollScale(0.3f);

		// ��ߵ�view��ʼ��
		view_left = LayoutInflater.from(this).inflate(R.layout.main_left_menu,
				null);
		slidingMenu.setMenu(view_left);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);// ���໬�����ӵ�activity��
		// ���û���ʱ�˵����Ƿ��뵭��
		slidingMenu.setFadeEnabled(true);
		initLeftMenu();
	}

	/**
	 * ��ʼ����໬��
	 */
	public void initLeftMenu() {
		left_menuIamge = (ImageView) view_left
				.findViewById(R.id.left_menu_iamge);
		left_inckName = (TextView) view_left
				.findViewById(R.id.left_menu_nickname);
		left_autograph = (TextView) view_left
				.findViewById(R.id.left_menu_autograph);

		// ���Ŀؼ�
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
			// ���
			setTabSelection(0);
			// ����������ɫ
			changTextColor(0);
			break;
		case R.id.main_activity_strategy:
			// ����
			setTabSelection(1);
			changTextColor(1);
			break;
		case R.id.main_activity_designer:
			// ���ʦ
			setTabSelection(2);
			changTextColor(2);
			break;
		case R.id.left_my_secret_message:
			// �ҵ�˽��
			setTabSelection(3);
			slidingMenu.showContent();// ��ʾ�ұ�
			changTextColor(3);
			break;
		case R.id.left_my_inspirations:
			// �ҵ���п�
			// slidingMenu.showContent();// ��ʾ�ұ� -- ��Ҫ��
			startActivity(new Intent(context, InspirationHome.class));
			break;
		case R.id.left_my_cares:
			// �ҵĹ�ע
			setTabSelection(4);
			slidingMenu.showContent();// ��ʾ�ұ�
			changTextColor(3);
			break;
		case R.id.left_night_mode:
			// ҹ��ģʽ -- ����
			startActivity(new Intent(context, LoginActivity.class));

			break;
		case R.id.left_set_msg:
			// ��Ϣ����
			startActivity(new Intent(context, SetMessageActivity.class));
			break;
		case R.id.left_username_psw:
			// �ʺź�����
			startActivity(new Intent(context, AccountPswActivity.class));
			break;
		case R.id.left_help_and_sug:
			// �����뷴��
			startActivity(new Intent(context, HelpSugActivity.class));
			break;
		case R.id.left_quit_login:
			// �˳���¼

			break;
		}
	}

	/**
	 * ���ݴ����index����������ѡ�е�tabҳ ÿ��tabҳ��Ӧ���±�0��У�1���ԣ�2���ʦ��3�ҵ�˽�ţ�4�ҵĹ�ע
	 */
	private void setTabSelection(int index) {
		// ÿ��ѡ��֮ǰ��������ϴε�ѡ��״̬
		clearSelection();
		// ����һ��Fragment����
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0:
			// ���������Ϣtabʱ���ı�ؼ���������ɫ
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
	 * ��������е�ѡ��״̬
	 */
	private void clearSelection() {

	}

	/**
	 * ����fragment
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
	 * ����������ɫ
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
	 * ���ص���һ��tab�ķ���
	 */
	public void backToTabOne() {
		setTabSelection(0);
		changTextColor(0);
	}

	/**
	 * �л�����ߵĲ໬��
	 */
	public void backToLeft() {
		// ��������໬��
		slidingMenu.showMenu(true);// �л����
	}
}
