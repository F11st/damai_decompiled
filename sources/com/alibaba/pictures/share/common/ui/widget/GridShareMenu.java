package com.alibaba.pictures.share.common.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.alibaba.pictures.share.R$anim;
import com.alibaba.pictures.share.R$styleable;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.ui.adapter.GridViewAdapter;
import com.alibaba.pictures.share.common.ui.adapter.ShareChannelAdapter;
import com.alibaba.pictures.share.common.ui.widget.IShareMenu;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jf2;
import tb.ob2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J0\u0010\u001a\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010 ¨\u0006'"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/widget/GridShareMenu;", "Landroid/widget/GridView;", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu;", "Landroid/widget/AdapterView$OnItemClickListener;", "", "channels", "Ltb/wt2;", "setChannels", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", WXBridgeManager.METHOD_CALLBACK, "setMenuCallback", "", "channel", "doSingleChannelShare", "", "isTwoLines", "separateToTwoLines", "", "startDelay", "setAnimation", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "position", "id", "onItemClick", "showType", "Ljava/lang/String;", "Lcom/alibaba/pictures/share/common/ui/adapter/GridViewAdapter;", "adapter", "Lcom/alibaba/pictures/share/common/ui/adapter/GridViewAdapter;", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class GridShareMenu extends GridView implements AdapterView.OnItemClickListener, IShareMenu {
    private static transient /* synthetic */ IpChange $ipChange;
    private GridViewAdapter adapter;
    private IShareMenu.MenuCallback callback;
    private String showType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridShareMenu(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(attributeSet, TemplateDom.KEY_ATTRS);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShareMenu, 0, 0);
        b41.h(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.ShareMenu, 0, 0)");
        String string = obtainStyledAttributes.getString(R$styleable.ShareMenu_share_channel);
        this.showType = string;
        setChannels(string);
        obtainStyledAttributes.recycle();
        setNumColumns(4);
        setOnItemClickListener(this);
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void doSingleChannelShare(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041831592")) {
            ipChange.ipc$dispatch("2041831592", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        IShareMenu.MenuCallback menuCallback = this.callback;
        if (menuCallback != null) {
            menuCallback.shareStart(i);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(@Nullable AdapterView<?> adapterView, @Nullable View view, int i, long j) {
        ob2 item;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566683325")) {
            ipChange.ipc$dispatch("-1566683325", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        GridViewAdapter gridViewAdapter = this.adapter;
        if (gridViewAdapter == null || (item = gridViewAdapter.getItem(i)) == null) {
            return;
        }
        doSingleChannelShare(Integer.valueOf(item.b()).intValue());
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void separateToTwoLines(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1172052869")) {
            ipChange.ipc$dispatch("-1172052869", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void setAnimation(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616513476")) {
            ipChange.ipc$dispatch("-1616513476", new Object[]{this, Long.valueOf(j)});
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
        setLayoutAnimation(new LayoutAnimationController(loadAnimation, 0.1f));
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void setChannels(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325444872")) {
            ipChange.ipc$dispatch("-1325444872", new Object[]{this, str});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "" + ShareChannel.ALL.value;
        }
        if (str != null) {
            Context context = getContext();
            b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
            GridViewAdapter gridViewAdapter = new GridViewAdapter(context);
            gridViewAdapter.initChannelItems(new ShareChannelAdapter(gridViewAdapter.getContext(), str, true));
            setAdapter((ListAdapter) gridViewAdapter);
            gridViewAdapter.notifyDataSetChanged();
            wt2 wt2Var = wt2.INSTANCE;
            this.adapter = gridViewAdapter;
        }
    }

    @Override // com.alibaba.pictures.share.common.ui.widget.IShareMenu
    public void setMenuCallback(@Nullable IShareMenu.MenuCallback menuCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883132609")) {
            ipChange.ipc$dispatch("-883132609", new Object[]{this, menuCallback});
        } else {
            this.callback = menuCallback;
        }
    }
}
