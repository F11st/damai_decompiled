package com.alibaba.pictures.share.common.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.pictures.share.R$anim;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.ui.widget.HorizontalShareMenu;
import com.alibaba.pictures.share.common.ui.widget.IShareMenu;
import com.alibaba.pictures.share.common.ui.widget.ShareHelperCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.model.PlayerInteract;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C9796v;
import tb.b41;
import tb.k50;
import tb.pb2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001CB\u0007¢\u0006\u0004\b@\u0010AJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0017J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\nH&J-\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00150\u00142\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0007H\u0014R\u0018\u0010&\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u001b8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\u00128\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006D"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/BaseShareActivity;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/view/View$OnClickListener;", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", "Lcom/alibaba/pictures/share/common/ui/widget/ShareHelperCallback;", "Landroid/os/Bundle;", "savedInstanceState", "Ltb/wt2;", "onCreate", "initView", "", "layoutId", "initParams", "", "enableTwoShareLines", "showShareTitle", "resetShareChannels", "shareChannel", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "getShareInfo", "", "Landroid/util/Pair;", "", "", "getShareExtra", "(I)[Landroid/util/Pair;", "getConfigShareChannels", "Landroid/view/View;", "v", PlayerInteract.ELEMENT_DEFAULT_ACTION, "channel", "shareComplete", "Lcom/alibaba/pictures/share/common/share/ShareException;", "exception", "shareException", "shareStart", "finish", "onDestroy", "buttonContainer", "Landroid/view/View;", "Lcom/alibaba/pictures/share/common/ui/widget/HorizontalShareMenu;", "shareMenu", "Lcom/alibaba/pictures/share/common/ui/widget/HorizontalShareMenu;", "shareTitle", "Landroid/widget/TextView;", "cancelBtn", "Landroid/widget/TextView;", "Landroid/graphics/Bitmap;", "shareImage", "Landroid/graphics/Bitmap;", Constants.Name.DEFAULT_WIDTH, "I", Constants.Name.DEFAULT_HEIGHT, "shareContent", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "shareChannels", "Ljava/lang/String;", "shareImageUrl", "Lcom/alibaba/pictures/share/common/ui/IShareResult;", "iShareResult", "Lcom/alibaba/pictures/share/common/ui/IShareResult;", "Landroid/view/animation/Animation;", "mAnimation", "Landroid/view/animation/Animation;", "<init>", "()V", "Companion", "a", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public abstract class BaseShareActivity extends FragmentActivity implements View.OnClickListener, IShareMenu.MenuCallback, ShareHelperCallback {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3636a Companion = new C3636a(null);
    @NotNull
    public static final String PARAMS_SHARE_CHANNELS = "params_shareChannels";
    @NotNull
    public static final String PARAMS_SHARE_CONTENT = "params_shareContent";
    @JvmField
    @Nullable
    protected View buttonContainer;
    @JvmField
    @Nullable
    protected TextView cancelBtn;
    @JvmField
    @Nullable
    protected IShareResult iShareResult;
    private Animation mAnimation;
    @JvmField
    @Nullable
    protected String shareChannels;
    @JvmField
    @Nullable
    protected ShareContent shareContent;
    private pb2 shareHelper;
    @JvmField
    @Nullable
    protected Bitmap shareImage;
    @JvmField
    @Nullable
    protected String shareImageUrl;
    @JvmField
    @Nullable
    protected HorizontalShareMenu shareMenu;
    @JvmField
    @Nullable
    protected View shareTitle;
    @JvmField
    protected int defaultWidth = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
    @JvmField
    protected int defaultHeight = 800;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.common.ui.BaseShareActivity$a */
    /* loaded from: classes8.dex */
    public static final class C3636a {
        private C3636a() {
        }

        public /* synthetic */ C3636a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.common.ui.BaseShareActivity$b  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static final class animationAnimation$AnimationListenerC3637b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        animationAnimation$AnimationListenerC3637b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1191809522")) {
                ipChange.ipc$dispatch("-1191809522", new Object[]{this, animation});
                return;
            }
            b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            BaseShareActivity.super.finish();
            BaseShareActivity.this.overridePendingTransition(0, 0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "784559782")) {
                ipChange.ipc$dispatch("784559782", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-77482521")) {
                ipChange.ipc$dispatch("-77482521", new Object[]{this, animation});
            } else {
                b41.i(animation, C9796v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }
    }

    public boolean enableTwoShareLines() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1706588147")) {
            return ((Boolean) ipChange.ipc$dispatch("1706588147", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // android.app.Activity
    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614787329")) {
            ipChange.ipc$dispatch("-614787329", new Object[]{this});
            return;
        }
        View view = this.buttonContainer;
        if (view != null && view.getVisibility() == 0) {
            if (this.mAnimation == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.tpp_slide_out_bottom);
                this.mAnimation = loadAnimation;
                if (loadAnimation != null) {
                    loadAnimation.setAnimationListener(new animationAnimation$AnimationListenerC3637b());
                }
            }
            View view2 = this.buttonContainer;
            if (view2 != null) {
                view2.startAnimation(this.mAnimation);
                return;
            }
            return;
        }
        super.finish();
    }

    @Nullable
    public final String getConfigShareChannels() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588904859")) {
            return (String) ipChange.ipc$dispatch("-1588904859", new Object[]{this});
        }
        ShareManager.IOrangeConfig o = ShareManager.INSTANCE.b().o();
        if (o != null) {
            return o.getShareChannelConfig();
        }
        return null;
    }

    @NotNull
    public Pair<String, Object>[] getShareExtra(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1993995863") ? (Pair[]) ipChange.ipc$dispatch("-1993995863", new Object[]{this, Integer.valueOf(i)}) : new Pair[0];
    }

    @Nullable
    public abstract ShareContent getShareInfo(int i);

    public void initParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296568700")) {
            ipChange.ipc$dispatch("296568700", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("params_shareContent");
            if (!(serializableExtra instanceof ShareContent)) {
                serializableExtra = null;
            }
            this.shareContent = (ShareContent) serializableExtra;
            this.shareChannels = intent.getStringExtra("params_shareChannels");
        }
    }

    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920733891")) {
            ipChange.ipc$dispatch("-1920733891", new Object[]{this});
            return;
        }
        this.buttonContainer = findViewById(R$id.button_container);
        HorizontalShareMenu horizontalShareMenu = (HorizontalShareMenu) findViewById(R$id.h5_share_menu);
        this.shareMenu = horizontalShareMenu;
        if (horizontalShareMenu != null) {
            horizontalShareMenu.setAnimation(300L);
        }
        this.shareTitle = findViewById(R$id.share_menu_title);
        this.cancelBtn = (TextView) findViewById(R$id.cancle_btn);
        ((RelativeLayout) findViewById(R$id.share_root)).setOnClickListener(this);
        HorizontalShareMenu horizontalShareMenu2 = this.shareMenu;
        if (horizontalShareMenu2 != null) {
            horizontalShareMenu2.setMenuCallback(this);
        }
        TextView textView = this.cancelBtn;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        HorizontalShareMenu horizontalShareMenu3 = this.shareMenu;
        if (horizontalShareMenu3 != null) {
            horizontalShareMenu3.separateToTwoLines(enableTwoShareLines());
        }
        View view = this.shareTitle;
        if (view != null) {
            view.setVisibility(8);
        }
        pb2 pb2Var = new pb2(this);
        this.shareHelper = pb2Var;
        pb2Var.a(this);
    }

    @LayoutRes
    public int layoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1704223456") ? ((Integer) ipChange.ipc$dispatch("-1704223456", new Object[]{this})).intValue() : R$layout.h5_share_activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "803676643")) {
            ipChange.ipc$dispatch("803676643", new Object[]{this, view});
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "66930653")) {
            ipChange.ipc$dispatch("66930653", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(layoutId());
        initParams();
        initView();
        resetShareChannels();
        View view = this.buttonContainer;
        if (view != null) {
            view.startAnimation(AnimationUtils.loadAnimation(this, R$anim.tpp_slide_in_bottom));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1926065757")) {
            ipChange.ipc$dispatch("1926065757", new Object[]{this});
            return;
        }
        pb2 pb2Var = this.shareHelper;
        if (pb2Var != null) {
            pb2Var.b(this);
        }
        HorizontalShareMenu horizontalShareMenu = this.shareMenu;
        if (horizontalShareMenu != null) {
            horizontalShareMenu.setMenuCallback(null);
        }
        Animation animation = this.mAnimation;
        if (animation != null) {
            animation.setAnimationListener(null);
        }
        super.onDestroy();
    }

    public void resetShareChannels() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360514766")) {
            ipChange.ipc$dispatch("-1360514766", new Object[]{this});
            return;
        }
        HorizontalShareMenu horizontalShareMenu = this.shareMenu;
        if (horizontalShareMenu != null) {
            horizontalShareMenu.setChannels(this.shareChannels);
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu.MenuCallback, com.alibaba.pictures.share.common.ui.widget.ShareHelperCallback
    public void shareComplete(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "221931619")) {
            ipChange.ipc$dispatch("221931619", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        IShareResult iShareResult = this.iShareResult;
        if (iShareResult != null) {
            iShareResult.shareComplete(i);
        }
        finish();
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu.MenuCallback, com.alibaba.pictures.share.common.ui.widget.ShareHelperCallback
    public void shareException(int i, @Nullable ShareException shareException) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1352621909")) {
            ipChange.ipc$dispatch("1352621909", new Object[]{this, Integer.valueOf(i), shareException});
            return;
        }
        IShareResult iShareResult = this.iShareResult;
        if (iShareResult != null) {
            iShareResult.shareException(i, shareException);
        }
        finish();
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu.MenuCallback
    public void shareStart(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092737644")) {
            ipChange.ipc$dispatch("-1092737644", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        pb2 pb2Var = this.shareHelper;
        if (pb2Var != null) {
            pb2Var.c(i, getShareInfo(i), getShareExtra(i));
        }
    }

    public boolean showShareTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285007648")) {
            return ((Boolean) ipChange.ipc$dispatch("285007648", new Object[]{this})).booleanValue();
        }
        return true;
    }
}
