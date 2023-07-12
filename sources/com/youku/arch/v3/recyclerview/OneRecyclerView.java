package com.youku.arch.v3.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.youku.arch.v3.recyclerview.OneRecyclerView;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001b\u001c\u001dB)\b\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Ltb/wt2;", "setMainScrollListener", "Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrolledListener;", "onScrolledListener", "addScrolledListener", "removeScrolledListener", "Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrollIdleListener;", "onScrollIdleListener", "addScrollIdleListener", "removeScrollIdleListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mainScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "onScrollIdleListeners", "Ljava/util/List;", "onScrolledListeners", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnScrollIdleListener", "OnScrolledListener", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class OneRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneRecyclerView";
    @Nullable
    private RecyclerView.OnScrollListener mainScrollListener;
    @Nullable
    private List<OnScrollIdleListener> onScrollIdleListeners;
    @Nullable
    private List<OnScrolledListener> onScrolledListeners;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrollIdleListener;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstVisibleItemPosition", "lastVisibleItemPosition", "Ltb/wt2;", "onScrollIdle", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface OnScrollIdleListener {
        void onScrollIdle(@Nullable RecyclerView recyclerView, int i, int i2);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/youku/arch/v3/recyclerview/OneRecyclerView$OnScrolledListener;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", Constants.Name.DISTANCE_Y, "firstVisibleItemPosition", "lastVisibleItemPosition", "Ltb/wt2;", GXTemplateEngine.g.TYPE_ON_SCROLLED, "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface OnScrolledListener {
        void onScrolled(@Nullable RecyclerView recyclerView, int i, int i2, int i3, int i4);
    }

    @JvmOverloads
    public OneRecyclerView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public OneRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ OneRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setMainScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480976749")) {
            ipChange.ipc$dispatch("480976749", new Object[]{this});
        } else if (this.mainScrollListener == null && (getLayoutManager() instanceof LinearLayoutManager)) {
            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.youku.arch.v3.recyclerview.OneRecyclerView$setMainScrollListener$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
                    List list;
                    List list2;
                    List<OneRecyclerView.OnScrollIdleListener> list3;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1949810653")) {
                        ipChange2.ipc$dispatch("-1949810653", new Object[]{this, recyclerView, Integer.valueOf(i)});
                        return;
                    }
                    b41.i(recyclerView, "recyclerView");
                    if (i == 0) {
                        list = OneRecyclerView.this.onScrollIdleListeners;
                        if (list != null) {
                            list2 = OneRecyclerView.this.onScrollIdleListeners;
                            b41.f(list2);
                            if (list2.isEmpty()) {
                                return;
                            }
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) OneRecyclerView.this.getLayoutManager();
                            b41.f(linearLayoutManager);
                            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                            LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) OneRecyclerView.this.getLayoutManager();
                            b41.f(linearLayoutManager2);
                            int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
                            list3 = OneRecyclerView.this.onScrollIdleListeners;
                            b41.f(list3);
                            for (OneRecyclerView.OnScrollIdleListener onScrollIdleListener : list3) {
                                onScrollIdleListener.onScrollIdle(OneRecyclerView.this, findFirstVisibleItemPosition, findLastVisibleItemPosition);
                            }
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
                    List list;
                    List list2;
                    List<OneRecyclerView.OnScrolledListener> list3;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1175948132")) {
                        ipChange2.ipc$dispatch("-1175948132", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                        return;
                    }
                    b41.i(recyclerView, "recyclerView");
                    list = OneRecyclerView.this.onScrolledListeners;
                    if (list != null) {
                        list2 = OneRecyclerView.this.onScrolledListeners;
                        b41.f(list2);
                        if (list2.isEmpty()) {
                            return;
                        }
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) OneRecyclerView.this.getLayoutManager();
                        b41.f(linearLayoutManager);
                        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                        LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) OneRecyclerView.this.getLayoutManager();
                        b41.f(linearLayoutManager2);
                        int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
                        list3 = OneRecyclerView.this.onScrolledListeners;
                        b41.f(list3);
                        for (OneRecyclerView.OnScrolledListener onScrolledListener : list3) {
                            onScrolledListener.onScrolled(OneRecyclerView.this, i, i2, findFirstVisibleItemPosition, findLastVisibleItemPosition);
                        }
                        if (AppInfoProviderProxy.isDebuggable()) {
                            Log.i("OneRecyclerView", b41.r("onScrolled start = ", Integer.valueOf(findFirstVisibleItemPosition)));
                        }
                    }
                }
            };
            this.mainScrollListener = onScrollListener;
            Objects.requireNonNull(onScrollListener, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
            addOnScrollListener(onScrollListener);
        }
    }

    public final void addScrollIdleListener(@Nullable OnScrollIdleListener onScrollIdleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046496030")) {
            ipChange.ipc$dispatch("-1046496030", new Object[]{this, onScrollIdleListener});
        } else if (onScrollIdleListener == null) {
        } else {
            setMainScrollListener();
            if (this.onScrollIdleListeners == null) {
                this.onScrollIdleListeners = Collections.synchronizedList(new ArrayList());
            }
            List<OnScrollIdleListener> list = this.onScrollIdleListeners;
            b41.f(list);
            list.add(onScrollIdleListener);
        }
    }

    public final void addScrolledListener(@Nullable OnScrolledListener onScrolledListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330756670")) {
            ipChange.ipc$dispatch("-1330756670", new Object[]{this, onScrolledListener});
        } else if (onScrolledListener == null) {
        } else {
            setMainScrollListener();
            if (this.onScrolledListeners == null) {
                this.onScrolledListeners = Collections.synchronizedList(new ArrayList());
            }
            List<OnScrolledListener> list = this.onScrolledListeners;
            b41.f(list);
            list.add(onScrolledListener);
        }
    }

    public final void removeScrollIdleListener(@Nullable OnScrollIdleListener onScrollIdleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278804755")) {
            ipChange.ipc$dispatch("-278804755", new Object[]{this, onScrollIdleListener});
            return;
        }
        List<OnScrollIdleListener> list = this.onScrollIdleListeners;
        if (list == null || onScrollIdleListener == null) {
            return;
        }
        b41.f(list);
        list.remove(onScrollIdleListener);
    }

    public final void removeScrolledListener(@Nullable OnScrolledListener onScrolledListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032129357")) {
            ipChange.ipc$dispatch("1032129357", new Object[]{this, onScrolledListener});
            return;
        }
        List<OnScrolledListener> list = this.onScrolledListeners;
        if (list == null || onScrolledListener == null) {
            return;
        }
        b41.f(list);
        list.remove(onScrolledListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OneRecyclerView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.f(context);
    }
}
