package cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.trade.R$anim;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cs;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderDetailNoticeActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    View mAnimView;
    private LinearLayout mBottomLayout;
    private StatusNotice mStatusNotice;
    private DMIconFontTextView mTvNoticeComplete;
    private TextView mTvNoticeContent;
    private ImageView mTvNoticeImg;
    private View v_outside;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1127384068")) {
                ipChange.ipc$dispatch("-1127384068", new Object[]{this, view});
            } else {
                OrderDetailNoticeActivity.this.openZoomImageActivity();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-159302077")) {
                ipChange.ipc$dispatch("-159302077", new Object[]{this, eVar});
            } else if (eVar == null || (bitmap = eVar.b) == null || bitmap.isRecycled()) {
            } else {
                OrderDetailNoticeActivity.this.mTvNoticeImg.setImageBitmap(eVar.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "501522711")) {
                ipChange.ipc$dispatch("501522711", new Object[]{this, animation});
                return;
            }
            OrderDetailNoticeActivity.this.finish();
            OrderDetailNoticeActivity.this.overridePendingTransition(0, 0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1840745731")) {
                ipChange.ipc$dispatch("-1840745731", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-577811792")) {
                ipChange.ipc$dispatch("-577811792", new Object[]{this, animation});
            }
        }
    }

    private void initExtraData() {
        Bundle extras;
        Parcelable parcelable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320133470")) {
            ipChange.ipc$dispatch("-1320133470", new Object[]{this});
        } else if (getIntent() == null || (extras = getIntent().getExtras()) == null || (parcelable = extras.getParcelable("status_notice")) == null) {
        } else {
            this.mStatusNotice = (StatusNotice) parcelable;
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240554467")) {
            ipChange.ipc$dispatch("-1240554467", new Object[]{this});
            return;
        }
        this.mTvNoticeComplete.setOnClickListener(this);
        this.v_outside.setOnClickListener(this);
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493136654")) {
            ipChange.ipc$dispatch("1493136654", new Object[]{this});
            return;
        }
        this.v_outside = findViewById(R$id.v_outside);
        this.mTvNoticeComplete = (DMIconFontTextView) findViewById(R$id.layer_close);
        this.mTvNoticeContent = (TextView) findViewById(R$id.notice_content_tv);
        this.mTvNoticeImg = (ImageView) findViewById(R$id.notice_content_img);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.layout_bottom);
        this.mBottomLayout = linearLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = (int) (DisplayMetrics.getheightPixels(m62.b(this)) * 0.75d);
        this.mBottomLayout.setLayoutParams(layoutParams);
        this.mBottomLayout.startAnimation(AnimationUtils.loadAnimation(this, R$anim.activity_item_animshow));
        this.mBottomLayout.setOnClickListener(this);
        setAnimationView(this.mBottomLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openZoomImageActivity() {
        StatusNotice statusNotice;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2033665055")) {
            ipChange.ipc$dispatch("2033665055", new Object[]{this});
        } else if (isFinishing() || (statusNotice = this.mStatusNotice) == null || TextUtils.isEmpty(statusNotice.imageUrl)) {
        } else {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            PicInfo picInfo = new PicInfo();
            picInfo.setPicUrl(this.mStatusNotice.imageUrl);
            arrayList.add(picInfo);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pic_info", arrayList);
            bundle.putInt("position", 0);
            DMNav.from(this).withExtras(bundle).toUri(cs.e());
        }
    }

    private void setInitializedData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928973726")) {
            ipChange.ipc$dispatch("-1928973726", new Object[]{this});
            return;
        }
        StatusNotice statusNotice = this.mStatusNotice;
        if (statusNotice != null) {
            this.mTvNoticeContent.setText(statusNotice.getPopupContent());
            if (!TextUtils.isEmpty(this.mStatusNotice.imageUrl)) {
                this.mTvNoticeImg.setVisibility(0);
                this.mTvNoticeImg.setOnClickListener(new a());
                cn.damai.common.image.a.b().f(this.mStatusNotice.imageUrl, 650, 900).n(new b()).f();
                return;
            }
            this.mTvNoticeImg.setVisibility(8);
        }
    }

    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-601417668")) {
            ipChange.ipc$dispatch("-601417668", new Object[]{this});
        } else if (this.mAnimView == null) {
            finish();
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.activity_item_animexit);
            this.mAnimView.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new c());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1838410244") ? ((Integer) ipChange.ipc$dispatch("1838410244", new Object[]{this})).intValue() : R$layout.activity_order_notice;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325188361")) {
            ipChange.ipc$dispatch("325188361", new Object[]{this});
            return;
        }
        super.initView();
        hideBaseLayout();
        initExtraData();
        initViews();
        initListeners();
        setInitializedData();
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-989735761")) {
            ipChange.ipc$dispatch("-989735761", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.v_outside) {
            finishActivity();
        } else if (R$id.layer_close == id) {
            finishActivity();
        }
    }

    public void setAnimationView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080282587")) {
            ipChange.ipc$dispatch("1080282587", new Object[]{this, view});
        } else {
            this.mAnimView = view;
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678299272")) {
            return (String) ipChange.ipc$dispatch("-678299272", new Object[]{this});
        }
        return null;
    }
}
