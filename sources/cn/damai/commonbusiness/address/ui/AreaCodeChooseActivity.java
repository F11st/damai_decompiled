package cn.damai.commonbusiness.address.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.address.adapter.AreaCodeChooseAdapter;
import cn.damai.commonbusiness.address.bean.PhoneAllowableBean;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AreaCodeChooseActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private AreaCodeChooseAdapter mAreaCodeChooseAdapter;
    private RecyclerView mAreaCodeRecyclerView;
    private FrameLayout mFvAreaCodeChooseRootView;
    private LinearLayout mLvAreaCodeChooseLayer;
    private AreaCodeChooseAdapter.OnAreaCodeItemClickListener mOnAreaCodeItemClickListener;
    private View.OnClickListener mOnCloseClickListener;
    private List<PhoneAllowableBean> mPhoneAllowableBeanList;
    private String mSelectedAreaCode;
    private PhoneAllowableBean mSelectedPhoneAllowableBean;
    private DMIconFontTextView mTvClose;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AreaCodeChooseActivity$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0567a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0567a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2080871790")) {
                ipChange.ipc$dispatch("-2080871790", new Object[]{this, view});
            } else {
                AreaCodeChooseActivity.this.finishActivity();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AreaCodeChooseActivity$b */
    /* loaded from: classes4.dex */
    public class C0568b implements AreaCodeChooseAdapter.OnAreaCodeItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0568b() {
        }

        @Override // cn.damai.commonbusiness.address.adapter.AreaCodeChooseAdapter.OnAreaCodeItemClickListener
        public void onItemClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2100859441")) {
                ipChange.ipc$dispatch("2100859441", new Object[]{this, Integer.valueOf(i)});
            } else if (AreaCodeChooseActivity.this.mPhoneAllowableBeanList == null || i < 0 || i >= AreaCodeChooseActivity.this.mPhoneAllowableBeanList.size()) {
            } else {
                AreaCodeChooseActivity areaCodeChooseActivity = AreaCodeChooseActivity.this;
                areaCodeChooseActivity.mSelectedPhoneAllowableBean = (PhoneAllowableBean) areaCodeChooseActivity.mPhoneAllowableBeanList.get(i);
                AreaCodeChooseActivity.this.mAreaCodeChooseAdapter.c(AreaCodeChooseActivity.this.mSelectedPhoneAllowableBean);
                Intent intent = new Intent();
                intent.putExtra("selected_phone_allowable", AreaCodeChooseActivity.this.mSelectedPhoneAllowableBean);
                AreaCodeChooseActivity.this.setResult(-1, intent);
                AreaCodeChooseActivity.this.finishActivity();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AreaCodeChooseActivity$c  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class animationAnimation$AnimationListenerC0569c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        animationAnimation$AnimationListenerC0569c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1595464493")) {
                ipChange.ipc$dispatch("1595464493", new Object[]{this, animation});
                return;
            }
            AreaCodeChooseActivity.this.finish();
            AreaCodeChooseActivity.this.overridePendingTransition(0, 0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1862007079")) {
                ipChange.ipc$dispatch("1862007079", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1566746810")) {
                ipChange.ipc$dispatch("-1566746810", new Object[]{this, animation});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630086318")) {
            ipChange.ipc$dispatch("-630086318", new Object[]{this});
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.anim_activity_item_exit);
        this.mLvAreaCodeChooseLayer.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new animationAnimation$AnimationListenerC0569c());
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74132276")) {
            ipChange.ipc$dispatch("-74132276", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                ToastUtil.i("暂不支持切换区号");
                finish();
                return;
            }
            ArrayList parcelableArrayList = extras.getParcelableArrayList("phone_allowable_list");
            this.mPhoneAllowableBeanList = parcelableArrayList;
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                ToastUtil.i("暂不支持切换区号");
                finish();
            }
            this.mSelectedAreaCode = extras.getString("selected_area_code");
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "5446727")) {
            ipChange.ipc$dispatch("5446727", new Object[]{this});
            return;
        }
        this.mOnCloseClickListener = new View$OnClickListenerC0567a();
        this.mOnAreaCodeItemClickListener = new C0568b();
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707774520")) {
            ipChange.ipc$dispatch("1707774520", new Object[]{this});
            return;
        }
        this.mFvAreaCodeChooseRootView = (FrameLayout) findViewById(R$id.area_code_choose_container_fv);
        this.mTvClose = (DMIconFontTextView) findViewById(R$id.area_code_choose_close_tv);
        this.mLvAreaCodeChooseLayer = (LinearLayout) findViewById(R$id.area_code_choose_layer_lv);
        this.mAreaCodeRecyclerView = (RecyclerView) findViewById(R$id.area_code_rlv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.mAreaCodeRecyclerView.setLayoutManager(linearLayoutManager);
        AreaCodeChooseAdapter areaCodeChooseAdapter = new AreaCodeChooseAdapter(this, this.mSelectedAreaCode, this.mPhoneAllowableBeanList);
        this.mAreaCodeChooseAdapter = areaCodeChooseAdapter;
        this.mAreaCodeRecyclerView.setAdapter(areaCodeChooseAdapter);
        this.mLvAreaCodeChooseLayer.startAnimation(AnimationUtils.loadAnimation(this, R$anim.anim_activity_item_enter));
        setStatusBar();
    }

    private void setStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144042549")) {
            ipChange.ipc$dispatch("1144042549", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.area_code_top_status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, -1);
            return;
        }
        kg2.f(this, false, -16777216);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241030190")) {
            ipChange.ipc$dispatch("-1241030190", new Object[]{this});
            return;
        }
        this.mFvAreaCodeChooseRootView.setOnClickListener(this.mOnCloseClickListener);
        this.mTvClose.setOnClickListener(this.mOnCloseClickListener);
        this.mAreaCodeChooseAdapter.b(this.mOnAreaCodeItemClickListener);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "556083132")) {
            ipChange.ipc$dispatch("556083132", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1946969262") ? ((Integer) ipChange.ipc$dispatch("1946969262", new Object[]{this})).intValue() : R$layout.activity_area_code_choose;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1635493747")) {
            ipChange.ipc$dispatch("-1635493747", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084804802")) {
            ipChange.ipc$dispatch("-2084804802", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193564831")) {
            ipChange.ipc$dispatch("193564831", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtraData();
        initViews();
        initListeners();
        setupListeners();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727265190")) {
            ipChange.ipc$dispatch("-1727265190", new Object[]{this});
        } else {
            finishActivity();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1751220898")) {
            return (String) ipChange.ipc$dispatch("1751220898", new Object[]{this});
        }
        return null;
    }
}
