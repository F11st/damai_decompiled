package cn.damai.solid;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.solid.bean.SoGroupEnum;
import cn.damai.solid.bean.SoInstallResult;
import cn.damai.solid.listener.SoInstallListener;
import cn.damai.solid.listener.SoMainListener;
import cn.damai.solid.util.Constant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.Status;
import com.youku.arch.solid.lifecycle.OnSoGroupStatusChangeListener;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.arch.solid.lifecycle.SolidResponse;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class SoLibInstallActivity extends DamaiBaseActivity implements OnSoGroupStatusChangeListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EXTRA_KEY = "extra_key";
    private Extra mGuideExtra;

    private void downloadSoGroup(SoGroupEnum soGroupEnum) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344733493")) {
            ipChange.ipc$dispatch("-344733493", new Object[]{this, soGroupEnum});
            return;
        }
        startProgressDialog("组件加载中...");
        SolidRequest solidRequest = new SolidRequest();
        solidRequest.name = soGroupEnum.soGroupName;
        a.f("SoLibInstallActivity downloadSoGroup " + soGroupEnum.soGroupName);
        SolidServer.registerListener(solidRequest, new SoMainListener(this));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798950651")) {
            ipChange.ipc$dispatch("-798950651", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1928730683") ? ((Integer) ipChange.ipc$dispatch("-1928730683", new Object[]{this})).intValue() : R$layout.activity_so_group_install;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523107754")) {
            ipChange.ipc$dispatch("-1523107754", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399160981")) {
            ipChange.ipc$dispatch("1399160981", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1808941848")) {
            ipChange.ipc$dispatch("-1808941848", new Object[]{this});
            return;
        }
        Extra extra = (Extra) getIntent().getParcelableExtra("extra_key");
        this.mGuideExtra = extra;
        if (extra != null && extra.isValid()) {
            downloadSoGroup(this.mGuideExtra.toEnum());
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096651794")) {
            ipChange.ipc$dispatch("1096651794", new Object[]{this});
            return;
        }
        super.onDestroy();
        if (this.mGuideExtra != null) {
            a.d().e(this.mGuideExtra.listenerKey);
        }
    }

    @Override // com.youku.arch.solid.lifecycle.SolidListener
    public void onResponse(SolidResponse solidResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119886094")) {
            ipChange.ipc$dispatch("119886094", new Object[]{this, solidResponse});
            return;
        }
        stopProgressDialog();
        a d = a.d();
        SoInstallListener e = d.e(this.mGuideExtra.listenerKey);
        a.f("SoLibInstallActivity onResponse groupName:" + solidResponse.groupName + " status:" + solidResponse.status.name());
        if (e != null) {
            Status status = Status.DOWNLOADED;
            Status status2 = solidResponse.status;
            if (status == status2) {
                SoInstallResult c = d.c(this.mGuideExtra.toEnum());
                if (c.isSoInstallSuccess) {
                    e.onInstallSuccess();
                } else {
                    e.onInstallFail(c.errCode, c.alarmMsg);
                }
            } else {
                String name = status2.name();
                e.onInstallFail(Constant.CODE_ACTIVITY_LOAD_FAIL, "SoLibInstallActivity soGroup:" + solidResponse.groupName + " failed status:" + name);
            }
        }
        finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592162439")) {
            return (String) ipChange.ipc$dispatch("-592162439", new Object[]{this});
        }
        return null;
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class Extra implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<Extra> CREATOR = new a();
        public int listenerKey;
        public String soGroupEnumName;

        /* compiled from: Taobao */
        /* loaded from: classes16.dex */
        public class a implements Parcelable.Creator<Extra> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Extra createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-290868501") ? (Extra) ipChange.ipc$dispatch("-290868501", new Object[]{this, parcel}) : new Extra(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public Extra[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1749148656") ? (Extra[]) ipChange.ipc$dispatch("-1749148656", new Object[]{this, Integer.valueOf(i)}) : new Extra[i];
            }
        }

        public Extra() {
            this.listenerKey = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1630367241")) {
                return ((Integer) ipChange.ipc$dispatch("-1630367241", new Object[]{this})).intValue();
            }
            return 0;
        }

        public boolean isValid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "770186003") ? ((Boolean) ipChange.ipc$dispatch("770186003", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.soGroupEnumName) || this.listenerKey == -1 || toEnum() == null) ? false : true;
        }

        public SoGroupEnum toEnum() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1067249114")) {
                return (SoGroupEnum) ipChange.ipc$dispatch("1067249114", new Object[]{this});
            }
            try {
                return SoGroupEnum.valueOf(this.soGroupEnumName);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-288424012")) {
                ipChange.ipc$dispatch("-288424012", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.soGroupEnumName);
            parcel.writeInt(this.listenerKey);
        }

        public Extra(String str, int i) {
            this.listenerKey = -1;
            this.soGroupEnumName = str;
            this.listenerKey = i;
        }

        protected Extra(Parcel parcel) {
            this.listenerKey = -1;
            this.soGroupEnumName = parcel.readString();
            this.listenerKey = parcel.readInt();
        }
    }
}
