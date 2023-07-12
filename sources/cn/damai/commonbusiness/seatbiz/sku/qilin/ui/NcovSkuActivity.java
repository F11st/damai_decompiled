package cn.damai.commonbusiness.seatbiz.sku.qilin.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatPreloadExtra;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.td2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NcovSkuActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_ATOMSPLIT = "atomSplit";
    public static final String KEY_HAS_SET_REMINDER = "hasSetReminder";
    public static final String KEY_ISSHOWYK = "isShowYK";
    public static final String KEY_ITEMID = "itemId";
    public static final String KEY_PRIVILEGEID = "privilegeId";
    public static final String KEY_REMIND_COUNTDOWN = "remindCountDown";
    public static final String KEY_REMIND_SALE_TIME = "remindSaleTime";
    public static final String KEY_REMIND_TITLE = "remindTitle";
    public static final String KEY_SEAT_PRELOAD_EXTRA = "seat_preload_extra";
    public static final String KEY_SKUBEAN = "skubean";
    public static final String MESSAGE_CLOSE = "message_close";
    private String mAtomSplit;
    private Bundle mExtraBundle;
    private NcovSkuFragment mFragment;
    private boolean mIsShowYK;
    private long mItemId;
    private String mPrivilegeId;
    private SkuBean mSkuBean;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-133071737")) {
                ipChange.ipc$dispatch("-133071737", new Object[]{this, obj});
            } else if (NcovSkuActivity.this.isFinishing()) {
            } else {
                NcovSkuActivity.this.finish();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375786698")) {
            ipChange.ipc$dispatch("375786698", new Object[]{this});
        } else if (getIntent() == null || getIntent().getExtras() == null) {
        } else {
            Bundle extras = getIntent().getExtras();
            try {
                if (extras.getSerializable(KEY_SKUBEAN) != null) {
                    this.mSkuBean = (SkuBean) extras.getSerializable(KEY_SKUBEAN);
                }
                this.mItemId = Long.parseLong(extras.getString("itemId", "0"));
                this.mPrivilegeId = extras.getString(KEY_PRIVILEGEID, "");
                this.mAtomSplit = extras.getString(KEY_ATOMSPLIT, "");
                this.mIsShowYK = Boolean.valueOf(extras.getString(KEY_ISSHOWYK, "")).booleanValue();
                Bundle bundle = new Bundle();
                this.mExtraBundle = bundle;
                bundle.putString(KEY_REMIND_TITLE, extras.getString(KEY_REMIND_TITLE));
                this.mExtraBundle.putLong(KEY_REMIND_SALE_TIME, extras.getLong(KEY_REMIND_SALE_TIME));
                this.mExtraBundle.putLong(KEY_REMIND_COUNTDOWN, extras.getLong(KEY_REMIND_COUNTDOWN));
                SeatPreloadExtra.putPreloadExtraIfNeed(SeatPreloadExtra.obtainExtra(extras), this.mExtraBundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2118379206") ? ((Integer) ipChange.ipc$dispatch("2118379206", new Object[]{this})).intValue() : R$layout.activity_sku_ncov;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024340089")) {
            ipChange.ipc$dispatch("-2024340089", new Object[]{this});
            return;
        }
        super.initView();
        removeHeadTitleView();
        initBundle();
        this.mFragment = NcovSkuFragment.getInstance(this.mSkuBean, this.mItemId, this.mPrivilegeId, this.mAtomSplit, this.mIsShowYK, this.mExtraBundle);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.sku_contanier, this.mFragment);
        beginTransaction.commitAllowingStateLoss();
        setDamaiUTKeyBuilder(td2.i().l(this.mItemId));
        c.e().K(this);
        this.mDMMessage.b(MESSAGE_CLOSE, new a());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321925463")) {
            return ((Boolean) ipChange.ipc$dispatch("-1321925463", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            NcovSkuFragment ncovSkuFragment = this.mFragment;
            if (ncovSkuFragment == null || !ncovSkuFragment.handlerBack()) {
                return super.onKeyDown(i, keyEvent);
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629521222")) {
            return (String) ipChange.ipc$dispatch("-1629521222", new Object[]{this});
        }
        return null;
    }
}
