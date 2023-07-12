package com.alibaba.pictures.share.common.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.pictures.share.R$color;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.alibaba.pictures.share.R$style;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.ui.widget.IShareMenu;
import com.alibaba.pictures.share.common.ui.widget.ShareHelperCallback;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.model.PlayerInteract;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.C8226x;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fa0;
import tb.hq2;
import tb.k50;
import tb.pb2;
import tb.yb2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001LB\u0007¢\u0006\u0004\bI\u0010JJ&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0017J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J/\u0010\"\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010!0 \u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u0011H&J\b\u0010&\u001a\u0004\u0018\u00010\u0017J\b\u0010(\u001a\u00020'H\u0016J\u0012\u0010*\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016J\u001a\u0010.\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010,H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0018\u00109\u001a\u0004\u0018\u0001088\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010$8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u00178\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b?\u0010@R:\u0010A\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010!0 \u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b\"\u0010C\"\u0004\bD\u0010ER\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/BaseShareDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", "Lcom/alibaba/pictures/share/common/ui/widget/ShareHelperCallback;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "Ltb/wt2;", "onViewCreated", "initView", "", "layoutId", "initParams", "onStart", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "showNow", "resetShareChannels", "channel", "shareStart", "shareChannel", "", "Landroid/util/Pair;", "", "getShareExtra", "(I)[Landroid/util/Pair;", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "getShareContentInfo", "getConfigShareChannels", "", "enableTwoShareLines", "v", PlayerInteract.ELEMENT_DEFAULT_ACTION, "shareComplete", "Lcom/alibaba/pictures/share/common/share/ShareException;", "exception", "shareException", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu;", "shareMenu", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu;", "Landroid/widget/TextView;", "cancelBtn", "Landroid/widget/TextView;", Constants.Name.DEFAULT_WIDTH, "I", Constants.Name.DEFAULT_HEIGHT, "Landroid/graphics/Bitmap;", "shareImage", "Landroid/graphics/Bitmap;", "shareContent", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "shareChannels", "Ljava/lang/String;", "buttonContainer", "Landroid/view/View;", "shareExtra", "[Landroid/util/Pair;", "()[Landroid/util/Pair;", "setShareExtra", "([Landroid/util/Pair;)V", "Lcom/alibaba/pictures/share/common/ui/IShareResult;", "iShareResult", "Lcom/alibaba/pictures/share/common/ui/IShareResult;", "<init>", "()V", "Companion", "a", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public abstract class BaseShareDialogFragment extends DialogFragment implements View.OnClickListener, IShareMenu.MenuCallback, ShareHelperCallback {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3638a Companion = new C3638a(null);
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
    public IShareResult iShareResult;
    @JvmField
    @Nullable
    protected String shareChannels;
    @JvmField
    @Nullable
    protected ShareContent shareContent;
    @Nullable
    private Pair<String, Object>[] shareExtra;
    @JvmField
    @Nullable
    protected Bitmap shareImage;
    @JvmField
    @Nullable
    protected IShareMenu shareMenu;
    @JvmField
    protected int defaultWidth = GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
    @JvmField
    protected int defaultHeight = 800;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.common.ui.BaseShareDialogFragment$a */
    /* loaded from: classes8.dex */
    public static final class C3638a {
        private C3638a() {
        }

        public /* synthetic */ C3638a(k50 k50Var) {
            this();
        }
    }

    public boolean enableTwoShareLines() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1290967786")) {
            return ((Boolean) ipChange.ipc$dispatch("1290967786", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Nullable
    public final String getConfigShareChannels() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "531971548")) {
            return (String) ipChange.ipc$dispatch("531971548", new Object[]{this});
        }
        ShareManager.IOrangeConfig o = ShareManager.INSTANCE.b().o();
        if (o != null) {
            return o.getShareChannelConfig();
        }
        return null;
    }

    @Nullable
    public abstract ShareContent getShareContentInfo(int i);

    @Nullable
    public final Pair<String, Object>[] getShareExtra() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-22550349") ? (Pair[]) ipChange.ipc$dispatch("-22550349", new Object[]{this}) : this.shareExtra;
    }

    public void initParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749852837")) {
            ipChange.ipc$dispatch("1749852837", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.shareContent = (ShareContent) arguments.getSerializable("params_shareContent");
            this.shareChannels = arguments.getString("params_shareChannels");
        }
    }

    public void initView(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643890284")) {
            ipChange.ipc$dispatch("643890284", new Object[]{this, view});
            return;
        }
        b41.i(view, "view");
        this.buttonContainer = view.findViewById(R$id.button_container);
        IShareMenu iShareMenu = (IShareMenu) view.findViewById(R$id.h5_share_menu);
        this.shareMenu = iShareMenu;
        if (iShareMenu != null) {
            iShareMenu.setMenuCallback(this);
        }
        View findViewById = view.findViewById(R$id.cancle_btn);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.cancelBtn = textView;
        textView.setOnClickListener(this);
        IShareMenu iShareMenu2 = this.shareMenu;
        if (iShareMenu2 != null) {
            iShareMenu2.separateToTwoLines(enableTwoShareLines());
        }
    }

    @LayoutRes
    public int layoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-263606647") ? ((Integer) ipChange.ipc$dispatch("-263606647", new Object[]{this})).intValue() : R$layout.layout_base_share_dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247474932")) {
            ipChange.ipc$dispatch("-1247474932", new Object[]{this, view});
        } else {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004180784")) {
            return (View) ipChange.ipc$dispatch("2004180784", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        return layoutInflater.inflate(layoutId(), viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-2082107668")) {
            ipChange.ipc$dispatch("-2082107668", new Object[]{this});
            return;
        }
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.getRequestedOrientation() == 0) {
            z = true;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int c = fa0.c();
        if (z) {
            c = (c * 3) / 5;
        }
        attributes.width = c;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(R$color.transparent);
        window.setDimAmount(0.5f);
        window.setGravity(z ? 17 : 80);
        window.setWindowAnimations(R$style.slide_in_out_bottom_anim);
        IShareMenu iShareMenu = this.shareMenu;
        if (iShareMenu != null) {
            iShareMenu.setAnimation(z ? 100L : 300L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990924051")) {
            ipChange.ipc$dispatch("-990924051", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
        initParams();
        initView(view);
        resetShareChannels();
    }

    public void resetShareChannels() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150098779")) {
            ipChange.ipc$dispatch("150098779", new Object[]{this});
            return;
        }
        IShareMenu iShareMenu = this.shareMenu;
        if (iShareMenu != null) {
            iShareMenu.setChannels(this.shareChannels);
        }
    }

    public final void setShareExtra(@Nullable Pair<String, Object>[] pairArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736027105")) {
            ipChange.ipc$dispatch("1736027105", new Object[]{this, pairArr});
        } else {
            this.shareExtra = pairArr;
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu.MenuCallback, com.alibaba.pictures.share.common.ui.widget.ShareHelperCallback
    public void shareComplete(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16123660")) {
            ipChange.ipc$dispatch("16123660", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        IShareResult iShareResult = this.iShareResult;
        if (iShareResult != null) {
            iShareResult.shareComplete(i);
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu.MenuCallback, com.alibaba.pictures.share.common.ui.widget.ShareHelperCallback
    public void shareException(int i, @Nullable ShareException shareException) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32652084")) {
            ipChange.ipc$dispatch("-32652084", new Object[]{this, Integer.valueOf(i), shareException});
            return;
        }
        IShareResult iShareResult = this.iShareResult;
        if (iShareResult != null) {
            iShareResult.shareException(i, shareException);
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu.MenuCallback
    public void shareStart(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009397643")) {
            ipChange.ipc$dispatch("1009397643", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Context context = getContext();
        if (context != null) {
            b41.h(context, "this");
            new pb2(context).c(i, getShareContentInfo(i), getShareExtra(i));
        }
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Map<String, String> m;
        Dialog dialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "489617719")) {
            ipChange.ipc$dispatch("489617719", new Object[]{this, fragmentManager, str});
            return;
        }
        b41.i(fragmentManager, "manager");
        if (getDialog() == null || (dialog = getDialog()) == null || !dialog.isShowing()) {
            try {
                fragmentManager.beginTransaction().remove(this).commit();
                if (isAdded() || fragmentManager.isStateSaved()) {
                    return;
                }
                super.show(fragmentManager, str);
            } catch (Exception e) {
                yb2 yb2Var = yb2.INSTANCE;
                kotlin.Pair[] pairArr = new kotlin.Pair[1];
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                pairArr[0] = hq2.a("error", message);
                m = C8226x.m(pairArr);
                yb2Var.c("BaseDialogFragment", m);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void showNow(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Map<String, String> m;
        Dialog dialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480106657")) {
            ipChange.ipc$dispatch("-480106657", new Object[]{this, fragmentManager, str});
            return;
        }
        b41.i(fragmentManager, "manager");
        if (getDialog() == null || (dialog = getDialog()) == null || !dialog.isShowing()) {
            try {
                fragmentManager.beginTransaction().remove(this).commit();
                if (isAdded() || fragmentManager.isStateSaved()) {
                    return;
                }
                super.showNow(fragmentManager, str);
            } catch (Exception e) {
                yb2 yb2Var = yb2.INSTANCE;
                kotlin.Pair[] pairArr = new kotlin.Pair[1];
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                pairArr[0] = hq2.a("error", message);
                m = C8226x.m(pairArr);
                yb2Var.c("BaseDialogFragment", m);
            }
        }
    }

    @Nullable
    public Pair<String, Object>[] getShareExtra(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "430977120") ? (Pair[]) ipChange.ipc$dispatch("430977120", new Object[]{this, Integer.valueOf(i)}) : this.shareExtra;
    }
}
