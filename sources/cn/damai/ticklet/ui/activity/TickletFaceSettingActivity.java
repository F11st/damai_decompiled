package cn.damai.ticklet.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.user.a;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.fragment.TickletDialogShowFragment;
import cn.damai.ticklet.ui.fragment.TickletFaceBindFragment;
import cn.damai.ticklet.ui.fragment.TickletFaceUnbindFragment;
import cn.damai.ticklet.view.TickletWebDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.cb1;
import tb.in2;
import tb.j62;
import tb.un2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletFaceSettingActivity extends TickletBaseActivity implements TickletFaceBindFragment.OnFaceBindListener, TickletFaceUnbindFragment.OnFaceUnbindListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = TickletFaceSettingActivity.class.getSimpleName();
    private TicketDeatilResult detailResult;
    private boolean mFaceSettingSuccess;
    private View.OnClickListener mOnBackClickListener;
    private View.OnClickListener mOnIntroduceClickListener;
    private int mOperateType;
    private TickletDialogShowFragment mTicketShowFragment;
    private FrameLayout mTicketShowLayout;
    private TextView mTvTitleCancel;
    private TextView mTvTitleFunctionIntroduce;
    private TextView mTvtitle;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-410167632")) {
                ipChange.ipc$dispatch("-410167632", new Object[]{this, view});
            } else {
                TickletFaceSettingActivity.this.finishFaceBind();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1701122737")) {
                ipChange.ipc$dispatch("1701122737", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(un2.k().C());
            TickletFaceSettingActivity.this.showFaceFunctionIntroduceDialog();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TickletWebDialog a;

        c(TickletFaceSettingActivity tickletFaceSettingActivity, TickletWebDialog tickletWebDialog) {
            this.a = tickletWebDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-401221763")) {
                ipChange.ipc$dispatch("-401221763", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                this.a.onDestory();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements TickletDialogShowFragment.OnClickCloseListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.OnClickCloseListener
        public void onClose(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1130624108")) {
                ipChange.ipc$dispatch("-1130624108", new Object[]{this, Integer.valueOf(i)});
            } else {
                TickletFaceSettingActivity.this.closeTicketFragmentPopLayer();
            }
        }

        @Override // cn.damai.ticklet.ui.fragment.TickletDialogShowFragment.OnClickCloseListener
        public void updateTicketSate(UserTicketTable userTicketTable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "319889999")) {
                ipChange.ipc$dispatch("319889999", new Object[]{this, userTicketTable});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishFaceBind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845978341")) {
            ipChange.ipc$dispatch("1845978341", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("faceSettingSuccess", this.mFaceSettingSuccess);
        setResult(-1, intent);
        finish();
    }

    private void initIntentExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914019444")) {
            ipChange.ipc$dispatch("1914019444", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.mOperateType = intent.getIntExtra("operationType", -1);
            String str = TAG;
            cb1.b(str, "operateType = " + this.mOperateType);
            this.detailResult = (TicketDeatilResult) intent.getSerializableExtra("detailResult");
            String string = getResources().getString(R$string.ticklet_face_entrance_setting_title);
            this.mTvtitle.setText(string);
            TicketDeatilResult ticketDeatilResult = this.detailResult;
            if (ticketDeatilResult != null) {
                updatePageUT(string, ticketDeatilResult.getPerformId(), this.detailResult.getProjectId());
            } else {
                updatePageUT(string, "", "");
            }
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500723177")) {
            ipChange.ipc$dispatch("1500723177", new Object[]{this});
            return;
        }
        this.mOnBackClickListener = new a();
        this.mOnIntroduceClickListener = new b();
    }

    private void initTitleViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011697676")) {
            ipChange.ipc$dispatch("1011697676", new Object[]{this});
            return;
        }
        this.mTvTitleCancel = (TextView) findViewById(R$id.ticklet_face_setting_title_left_tv);
        this.mTvTitleFunctionIntroduce = (TextView) findViewById(R$id.ticklet_face_title_function_introduce_tv);
        this.mTvtitle = (TextView) findViewById(R$id.ticklet_face_entrance_title_text);
        this.mTicketShowLayout = (FrameLayout) findViewById(R$id.ticket_face_fg_container);
    }

    private boolean isTicketShowFragmentShowing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061048570")) {
            return ((Boolean) ipChange.ipc$dispatch("2061048570", new Object[]{this})).booleanValue();
        }
        TickletDialogShowFragment tickletDialogShowFragment = this.mTicketShowFragment;
        return tickletDialogShowFragment != null && tickletDialogShowFragment.isVisible();
    }

    private void setFaceSettingResult(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2110843088")) {
            ipChange.ipc$dispatch("2110843088", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mFaceSettingSuccess) {
        } else {
            this.mFaceSettingSuccess = z;
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132100496")) {
            ipChange.ipc$dispatch("-2132100496", new Object[]{this});
            return;
        }
        this.mTvTitleCancel.setOnClickListener(this.mOnBackClickListener);
        this.mTvTitleFunctionIntroduce.setOnClickListener(this.mOnIntroduceClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFaceFunctionIntroduceDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2132264317")) {
            ipChange.ipc$dispatch("-2132264317", new Object[]{this});
            return;
        }
        String string = getResources().getString(R$string.ticklet_face_introduce_dialog_title);
        TickletWebDialog tickletWebDialog = new TickletWebDialog(this);
        tickletWebDialog.setData(in2.DAMAI_FACE_FUNCTION_RULE_URL);
        DMDialog dMDialog = new DMDialog(this);
        dMDialog.v(string).u(tickletWebDialog).n(getString(R$string.ticklet_know), new c(this, tickletWebDialog));
        dMDialog.show();
    }

    private void showFaceOperationFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880616261")) {
            ipChange.ipc$dispatch("-1880616261", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        TicketDeatilResult ticketDeatilResult = this.detailResult;
        if (ticketDeatilResult != null) {
            extras.putString("projectId", ticketDeatilResult.getProjectId());
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        int i = this.mOperateType;
        if (i == 1) {
            fragment = TickletFaceBindFragment.newInstance(extras);
        } else if (i == 0) {
            fragment = TickletFaceUnbindFragment.newInstance(extras);
        }
        if (fragment != null) {
            beginTransaction.replace(R$id.ticklet_face_setting_container_fv, fragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private void updatePageUT(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875783641")) {
            ipChange.ipc$dispatch("875783641", new Object[]{this, str, str2, str3});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str3);
        hashMap.put("screening_id", str2);
        hashMap.put("titlelabel", str);
        hashMap.put("usercode", z20.E());
        a.b bVar = new a.b();
        bVar.i(un2.TICKLET_FACE_SETTING).j(hashMap);
        cn.damai.common.user.c.e().l(this, bVar);
    }

    public void closeTicketFragmentPopLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676596636")) {
            ipChange.ipc$dispatch("-676596636", new Object[]{this});
        } else if (isTicketShowFragmentShowing()) {
            getSupportFragmentManager().beginTransaction().remove(this.mTicketShowFragment).commitAllowingStateLoss();
            j62.b(this, j62.a(this));
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.ticklet.ui.activity.TickletFaceSettingActivity.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-446679172")) {
                        ipChange2.ipc$dispatch("-446679172", new Object[]{this});
                    } else {
                        TickletFaceSettingActivity.this.mTicketShowLayout.setVisibility(8);
                    }
                }
            }, 100L);
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063989030")) {
            ipChange.ipc$dispatch("-1063989030", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2006777648") ? ((Integer) ipChange.ipc$dispatch("-2006777648", new Object[]{this})).intValue() : R$layout.activity_ticklet_face_entrance_setting;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352403627")) {
            ipChange.ipc$dispatch("352403627", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public boolean handlerBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266995413")) {
            return ((Boolean) ipChange.ipc$dispatch("-266995413", new Object[]{this})).booleanValue();
        }
        TickletDialogShowFragment tickletDialogShowFragment = this.mTicketShowFragment;
        if (tickletDialogShowFragment != null && tickletDialogShowFragment.isVisible() && this.mTicketShowLayout.getVisibility() == 0) {
            closeTicketFragmentPopLayer();
            return true;
        }
        return false;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-589528352")) {
            ipChange.ipc$dispatch("-589528352", new Object[]{this});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931870653")) {
            ipChange.ipc$dispatch("931870653", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initTitleViews();
        initIntentExtra();
        initListeners();
        setupListeners();
        showFaceOperationFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887900323")) {
            ipChange.ipc$dispatch("-1887900323", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        cb1.b(TAG, "onCreate()");
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_FACE_SETTING));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162493405")) {
            ipChange.ipc$dispatch("162493405", new Object[]{this});
            return;
        }
        super.onDestroy();
        cb1.b(TAG, "onDestroy()");
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletFaceBindFragment.OnFaceBindListener
    public void onFaceBind(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1539498843")) {
            ipChange.ipc$dispatch("1539498843", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.mTvTitleCancel.setVisibility(8);
        } else {
            this.mTvTitleCancel.setVisibility(0);
        }
        setFaceSettingResult(z);
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletFaceBindFragment.OnFaceBindListener
    public void onFaceBindComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894809952")) {
            ipChange.ipc$dispatch("-1894809952", new Object[]{this});
        } else {
            finishFaceBind();
        }
    }

    @Override // cn.damai.ticklet.ui.fragment.TickletFaceUnbindFragment.OnFaceUnbindListener
    public void onFaceUnbind(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1395285506")) {
            ipChange.ipc$dispatch("-1395285506", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        setFaceSettingResult(z);
        finishFaceBind();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181443277")) {
            return ((Boolean) ipChange.ipc$dispatch("-1181443277", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            if (isTicketShowFragmentShowing()) {
                boolean handlerBack = handlerBack();
                if (handlerBack) {
                    return handlerBack;
                }
                finishFaceBind();
            } else {
                finishFaceBind();
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886899462")) {
            ipChange.ipc$dispatch("886899462", new Object[]{this, bundle, persistableBundle});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769967292")) {
            return (String) ipChange.ipc$dispatch("-769967292", new Object[]{this});
        }
        return null;
    }

    public void showCredentialsInfoDialog(TicketDeatilResult ticketDeatilResult, UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129800898")) {
            ipChange.ipc$dispatch("-129800898", new Object[]{this, ticketDeatilResult, userTicketTable});
        } else if (ticketDeatilResult == null || userTicketTable == null || ticketDeatilResult.getTicketInfoList() == null) {
        } else {
            this.mTicketShowLayout.setVisibility(0);
            ticketDeatilResult.getTicketInfoList().clear();
            ticketDeatilResult.getTicketInfoList().add(userTicketTable);
            TickletDialogShowFragment tickletDialogShowFragment = TickletDialogShowFragment.getInstance(ticketDeatilResult.getPerformId(), null, ticketDeatilResult, TickletDialogShowFragment.SHOW_TICKLET_FROM_UNBIND_FACE);
            this.mTicketShowFragment = tickletDialogShowFragment;
            tickletDialogShowFragment.setOnClickCloseListener(new d());
            getSupportFragmentManager().beginTransaction().replace(R$id.ticket_face_fg_container, this.mTicketShowFragment).commitAllowingStateLoss();
        }
    }
}
