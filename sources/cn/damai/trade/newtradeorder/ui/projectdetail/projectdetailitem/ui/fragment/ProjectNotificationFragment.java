package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.servicenotice.OnCompleteListener;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectNotificationFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private View.OnClickListener mOnCompleteClickListener;
    private OnCompleteListener mOnCompleteListener;
    private StatusNotice mStatusNotice;
    private DMIconFontTextView mTvNotificationComplete;
    private TextView mTvNotificationContent;
    private ImageView mTvNotificationImg;
    private TextView mTvNotificationTitle;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1720222308")) {
                ipChange.ipc$dispatch("1720222308", new Object[]{this, view});
            } else {
                ProjectNotificationFragment.this.mOnCompleteListener.onComplete(2);
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
            if (AndroidInstantRuntime.support(ipChange, "-463454619")) {
                ipChange.ipc$dispatch("-463454619", new Object[]{this, view});
            } else {
                ProjectNotificationFragment.this.openZoomImageActivity();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "701113964")) {
                ipChange.ipc$dispatch("701113964", new Object[]{this, eVar});
            } else if (eVar == null || (bitmap = eVar.b) == null || bitmap.isRecycled()) {
            } else {
                ProjectNotificationFragment.this.mTvNotificationImg.setImageBitmap(eVar.b);
            }
        }
    }

    private void initExtraData() {
        Parcelable parcelable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463397574")) {
            ipChange.ipc$dispatch("-1463397574", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null || (parcelable = arguments.getParcelable("status_notice")) == null) {
            return;
        }
        this.mStatusNotice = (StatusNotice) parcelable;
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383818571")) {
            ipChange.ipc$dispatch("-1383818571", new Object[]{this});
        } else {
            this.mOnCompleteClickListener = new a();
        }
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141064102")) {
            ipChange.ipc$dispatch("141064102", new Object[]{this});
            return;
        }
        this.mTvNotificationTitle = (TextView) this.rootView.findViewById(R$id.layer_title);
        this.mTvNotificationComplete = (DMIconFontTextView) this.rootView.findViewById(R$id.layer_close);
        this.mTvNotificationContent = (TextView) this.rootView.findViewById(R$id.project_notification_content_tv);
        this.mTvNotificationImg = (ImageView) this.rootView.findViewById(R$id.project_notification_content_img);
    }

    public static ProjectNotificationFragment newInstance(StatusNotice statusNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754776440")) {
            return (ProjectNotificationFragment) ipChange.ipc$dispatch("754776440", new Object[]{statusNotice});
        }
        ProjectNotificationFragment projectNotificationFragment = new ProjectNotificationFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("status_notice", statusNotice);
        projectNotificationFragment.setArguments(bundle);
        return projectNotificationFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openZoomImageActivity() {
        StatusNotice statusNotice;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151444809")) {
            ipChange.ipc$dispatch("-151444809", new Object[]{this});
            return;
        }
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || (statusNotice = this.mStatusNotice) == null || TextUtils.isEmpty(statusNotice.imageUrl)) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PicInfo picInfo = new PicInfo();
        picInfo.setPicUrl(this.mStatusNotice.imageUrl);
        arrayList.add(picInfo);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("pic_info", arrayList);
        bundle.putInt("position", 0);
        DMNav.from(this.mActivity).withExtras(bundle).toUri(cs.e());
    }

    private void setInitializedData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1036346678")) {
            ipChange.ipc$dispatch("-1036346678", new Object[]{this});
            return;
        }
        StatusNotice statusNotice = this.mStatusNotice;
        if (statusNotice != null) {
            String popupTitle = statusNotice.getPopupTitle();
            String popupContent = this.mStatusNotice.getPopupContent();
            this.mTvNotificationTitle.setText(popupTitle);
            this.mTvNotificationContent.setText(popupContent);
            if (!TextUtils.isEmpty(this.mStatusNotice.imageUrl)) {
                this.mTvNotificationImg.setVisibility(0);
                this.mTvNotificationImg.setOnClickListener(new b());
                cn.damai.common.image.a.b().f(this.mStatusNotice.imageUrl, 650, 900).n(new c()).f();
                return;
            }
            this.mTvNotificationImg.setVisibility(8);
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358581468")) {
            ipChange.ipc$dispatch("-1358581468", new Object[]{this});
        } else {
            this.mTvNotificationComplete.setOnClickListener(this.mOnCompleteClickListener);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1465055351") ? ((Integer) ipChange.ipc$dispatch("-1465055351", new Object[]{this})).intValue() : R$layout.project_item_pop_notification_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095950753")) {
            ipChange.ipc$dispatch("-2095950753", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "820897196")) {
            ipChange.ipc$dispatch("820897196", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-134068879")) {
            ipChange.ipc$dispatch("-134068879", new Object[]{this});
            return;
        }
        initExtraData();
        initViews();
        initListeners();
        setupListeners();
        setInitializedData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558199258")) {
            ipChange.ipc$dispatch("-1558199258", new Object[]{this, context});
            return;
        }
        super.onAttach(context);
        try {
            this.mOnCompleteListener = (OnCompleteListener) getParentFragment();
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894034153")) {
            ipChange.ipc$dispatch("-1894034153", new Object[]{this, view});
        }
    }
}
