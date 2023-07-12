package com.alibaba.pictures.share.common.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.share.R$anim;
import com.alibaba.pictures.share.R$id;
import com.alibaba.pictures.share.R$layout;
import com.alibaba.pictures.share.R$styleable;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.share.ShareService;
import com.alibaba.pictures.share.common.ui.adapter.ShareChannelAdapter;
import com.alibaba.pictures.share.common.ui.adapter.ShareMenuAdapter;
import com.alibaba.pictures.share.common.ui.widget.IShareMenu;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fa0;
import tb.jf2;
import tb.ob2;
import tb.wb2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001c\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00065"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/widget/HorizontalShareMenu;", "Landroid/widget/LinearLayout;", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu;", "Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter$OnShareMenuItemClickListener;", "Lcom/alibaba/pictures/share/common/share/ShareService$ShareActionListener;", "", "startDelay", "Ltb/wt2;", "setAnimation", "", "channelTypes", "setChannels", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", WXBridgeManager.METHOD_CALLBACK, "setMenuCallback", "", "channel", "doSingleChannelShare", "", "isTwoLines", "separateToTwoLines", RemoteMessageConst.Notification.CHANNEL_ID, "onMenuItemClick", "Lcom/alibaba/pictures/share/common/share/ShareChannel;", "shareChannel", "onComplete", "Lcom/alibaba/pictures/share/common/share/ShareException;", "exception", "onException", "showType", "Ljava/lang/String;", "Landroid/view/View;", "dividerView", "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView;", "shareRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "actionRecyclerView", "Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter;", "shareAdapter", "Lcom/alibaba/pictures/share/common/ui/adapter/ShareMenuAdapter;", "actionAdapter", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", "Z", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class HorizontalShareMenu extends LinearLayout implements ShareService.ShareActionListener, ShareMenuAdapter.OnShareMenuItemClickListener, IShareMenu {
    private static transient /* synthetic */ IpChange $ipChange;
    private ShareMenuAdapter actionAdapter;
    private RecyclerView actionRecyclerView;
    private IShareMenu.MenuCallback callback;
    private View dividerView;
    private boolean isTwoLines;
    private RecyclerView.ItemDecoration itemDecoration;
    private ShareMenuAdapter shareAdapter;
    private RecyclerView shareRecyclerView;
    private final wb2 shareService;
    private String showType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalShareMenu(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(attributeSet, TemplateDom.KEY_ATTRS);
        this.isTwoLines = true;
        wb2 wb2Var = wb2.INSTANCE;
        this.shareService = wb2Var;
        this.itemDecoration = new RecyclerView.ItemDecoration() { // from class: com.alibaba.pictures.share.common.ui.widget.HorizontalShareMenu$itemDecoration$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "797991887")) {
                    ipChange.ipc$dispatch("797991887", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                b41.i(rect, "outRect");
                b41.i(view, "view");
                b41.i(recyclerView, "parent");
                b41.i(state, "state");
                super.getItemOffsets(rect, view, recyclerView, state);
                if (recyclerView.getChildLayoutPosition(view) == 0) {
                    rect.left = fa0.a(8.0f);
                }
            }
        };
        LayoutInflater.from(context).inflate(R$layout.home_share_container, (ViewGroup) this, true);
        this.dividerView = findViewById(R$id.share_container_divider);
        View findViewById = findViewById(R$id.share_channel_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.shareRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R$id.action_channel_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.actionRecyclerView = (RecyclerView) findViewById2;
        RecyclerView recyclerView = this.shareRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        }
        RecyclerView recyclerView2 = this.actionRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
        }
        RecyclerView recyclerView3 = this.shareRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(this.itemDecoration);
        }
        RecyclerView recyclerView4 = this.actionRecyclerView;
        if (recyclerView4 != null) {
            recyclerView4.addItemDecoration(this.itemDecoration);
        }
        ShareMenuAdapter shareMenuAdapter = new ShareMenuAdapter(context);
        RecyclerView recyclerView5 = this.shareRecyclerView;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(shareMenuAdapter);
        }
        shareMenuAdapter.g(this);
        wt2 wt2Var = wt2.INSTANCE;
        this.shareAdapter = shareMenuAdapter;
        ShareMenuAdapter shareMenuAdapter2 = new ShareMenuAdapter(context);
        RecyclerView recyclerView6 = this.actionRecyclerView;
        if (recyclerView6 != null) {
            recyclerView6.setAdapter(shareMenuAdapter2);
        }
        shareMenuAdapter2.g(this);
        this.actionAdapter = shareMenuAdapter2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShareMenu, 0, 0);
        b41.h(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.ShareMenu, 0, 0)");
        String string = obtainStyledAttributes.getString(R$styleable.ShareMenu_share_channel);
        this.showType = string;
        setChannels(string);
        obtainStyledAttributes.recycle();
        wb2Var.c(this);
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void doSingleChannelShare(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1769413958")) {
            ipChange.ipc$dispatch("1769413958", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        IShareMenu.MenuCallback menuCallback = this.callback;
        if (menuCallback != null) {
            menuCallback.shareStart(i);
        }
    }

    @Override // com.alibaba.pictures.share.common.share.ShareService.ShareActionListener
    public void onComplete(@Nullable ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1987308052")) {
            ipChange.ipc$dispatch("1987308052", new Object[]{this, shareChannel});
            return;
        }
        IShareMenu.MenuCallback menuCallback = this.callback;
        if (menuCallback == null || shareChannel == null) {
            return;
        }
        int i = shareChannel.value;
        if (menuCallback != null) {
            menuCallback.shareComplete(i);
        }
    }

    @Override // com.alibaba.pictures.share.common.share.ShareService.ShareActionListener
    public void onException(@Nullable ShareChannel shareChannel, @Nullable ShareException shareException) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-181226270")) {
            ipChange.ipc$dispatch("-181226270", new Object[]{this, shareChannel, shareException});
            return;
        }
        IShareMenu.MenuCallback menuCallback = this.callback;
        if (menuCallback == null || shareChannel == null) {
            return;
        }
        int i = shareChannel.value;
        if (menuCallback != null) {
            menuCallback.shareException(i, shareException);
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.adapter.ShareMenuAdapter.OnShareMenuItemClickListener
    public void onMenuItemClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371122852")) {
            ipChange.ipc$dispatch("-1371122852", new Object[]{this, Integer.valueOf(i)});
        } else {
            doSingleChannelShare(i);
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void separateToTwoLines(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "338276505")) {
            ipChange.ipc$dispatch("338276505", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isTwoLines = z;
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void setAnimation(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "881242330")) {
            ipChange.ipc$dispatch("881242330", new Object[]{this, Long.valueOf(j)});
            return;
        }
        ShareManager shareManager = ShareManager.INSTANCE;
        if (shareManager.b().b() == 0.0f) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.item_slide_in_bottom);
        b41.h(loadAnimation, "this");
        loadAnimation.setInterpolator(new jf2(shareManager.b().b()));
        loadAnimation.setStartOffset(j);
        wt2 wt2Var = wt2.INSTANCE;
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(loadAnimation, 0.1f);
        RecyclerView recyclerView = this.shareRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutAnimation(layoutAnimationController);
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void setChannels(@Nullable String str) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1174204522")) {
            ipChange.ipc$dispatch("-1174204522", new Object[]{this, str});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "" + ShareChannel.ALL.value;
        }
        String str2 = str;
        ShareMenuAdapter shareMenuAdapter = this.shareAdapter;
        if (shareMenuAdapter != null) {
            shareMenuAdapter.d();
        }
        ShareMenuAdapter shareMenuAdapter2 = this.actionAdapter;
        if (shareMenuAdapter2 != null) {
            shareMenuAdapter2.d();
        }
        if (str2 == null) {
            return;
        }
        Context context = getContext();
        b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
        ShareChannelAdapter shareChannelAdapter = new ShareChannelAdapter(context, str2, false, 4, null);
        if (shareChannelAdapter.isEmpty()) {
            RecyclerView recyclerView3 = this.shareRecyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(8);
            }
            RecyclerView recyclerView4 = this.actionRecyclerView;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(8);
            }
            View view = this.dividerView;
            if (view != null) {
                view.setVisibility(8);
            }
            ShareMenuAdapter shareMenuAdapter3 = this.shareAdapter;
            if (shareMenuAdapter3 != null) {
                shareMenuAdapter3.notifyDataSetChanged();
            }
            ShareMenuAdapter shareMenuAdapter4 = this.actionAdapter;
            if (shareMenuAdapter4 != null) {
                shareMenuAdapter4.notifyDataSetChanged();
                return;
            }
            return;
        }
        RecyclerView recyclerView5 = this.shareRecyclerView;
        if (recyclerView5 != null) {
            recyclerView5.setVisibility(0);
        }
        RecyclerView recyclerView6 = this.actionRecyclerView;
        if (recyclerView6 != null) {
            recyclerView6.setVisibility(0);
        }
        Iterator<ob2> it = shareChannelAdapter.iterator();
        while (it.hasNext()) {
            ob2 next = it.next();
            try {
                if (this.isTwoLines) {
                    if (next.b() > ShareChannel.NONE.value && next.b() < ShareChannel.ALL.value) {
                        ShareMenuAdapter shareMenuAdapter5 = this.shareAdapter;
                        if (shareMenuAdapter5 != null) {
                            b41.h(next, "chanel");
                            shareMenuAdapter5.c(next);
                        }
                    } else {
                        ShareMenuAdapter shareMenuAdapter6 = this.actionAdapter;
                        if (shareMenuAdapter6 != null) {
                            b41.h(next, "chanel");
                            shareMenuAdapter6.c(next);
                        }
                    }
                } else {
                    ShareMenuAdapter shareMenuAdapter7 = this.shareAdapter;
                    if (shareMenuAdapter7 != null) {
                        b41.h(next, "chanel");
                        shareMenuAdapter7.c(next);
                    }
                }
            } catch (Exception unused) {
            }
        }
        ShareMenuAdapter shareMenuAdapter8 = this.shareAdapter;
        if (shareMenuAdapter8 != null && shareMenuAdapter8.getItemCount() == 0 && (recyclerView2 = this.shareRecyclerView) != null) {
            recyclerView2.setVisibility(8);
        }
        ShareMenuAdapter shareMenuAdapter9 = this.actionAdapter;
        if (shareMenuAdapter9 != null && shareMenuAdapter9.getItemCount() == 0 && (recyclerView = this.actionRecyclerView) != null) {
            recyclerView.setVisibility(8);
        }
        ShareMenuAdapter shareMenuAdapter10 = this.shareAdapter;
        if (shareMenuAdapter10 != null) {
            shareMenuAdapter10.notifyDataSetChanged();
        }
        ShareMenuAdapter shareMenuAdapter11 = this.actionAdapter;
        if (shareMenuAdapter11 != null) {
            shareMenuAdapter11.notifyDataSetChanged();
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void setMenuCallback(@Nullable IShareMenu.MenuCallback menuCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409147167")) {
            ipChange.ipc$dispatch("-1409147167", new Object[]{this, menuCallback});
            return;
        }
        this.callback = menuCallback;
        if (menuCallback == null) {
            this.shareService.c(null);
        }
    }
}
