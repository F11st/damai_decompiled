package com.youku.arch.v3.view;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.component.GenericComponent;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.View;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\b&\u0018\u0000 I*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\b\b\u0002\u0010\u0007*\u00020\u00062\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b:\u0001IB7\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010$\u001a\u0004\u0018\u00010+¢\u0006\u0004\bD\u0010EB7\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bD\u0010FB?\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010'\u001a\u00020&\u0012\u0010\u0010$\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001f¢\u0006\u0004\bD\u0010GB+\b\u0016\u0012\u0006\u0010.\u001a\u00028\u0001\u0012\u0006\u0010)\u001a\u00028\u0002\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bD\u0010HJ!\u0010\r\u001a\u00028\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J!\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J&\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\t2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J\u001c\u0010%\u001a\u00020\u00172\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 \u0018\u00010\u001fJ\u000e\u0010(\u001a\u00020\u00172\u0006\u0010'\u001a\u00020&J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u000bR\u0018\u0010$\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010,R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010-R\"\u0010.\u001a\u00028\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010)\u001a\u00028\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u0013\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0019R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006J"}, d2 = {"Lcom/youku/arch/v3/view/AbsPresenter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/view/IContract$Model;", "MODEL", "Lcom/youku/arch/v3/view/IContract$View;", "VIEW", "Lcom/youku/arch/v3/view/IContract$Presenter;", "", "vClassName", "Landroid/view/View;", "renderView", "createView", "(Ljava/lang/String;Landroid/view/View;)Lcom/youku/arch/v3/view/IContract$View;", "Landroid/view/ViewGroup;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "findInnerRecyclerView", "item", "mClassName", "createModel", "(Lcom/youku/arch/v3/IItem;Ljava/lang/String;)Lcom/youku/arch/v3/view/IContract$Model;", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "(Lcom/youku/arch/v3/IItem;)V", "preAsyncInit", "saveState", "onCreate", "onDestroy", "type", "", "", "params", "", "onMessage", Constants.CONFIG, "updateConfig", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", "updateEventHandler", "view", "updateView", "Lcom/alibaba/fastjson/JSONObject;", "Lcom/alibaba/fastjson/JSONObject;", "Ljava/lang/String;", "model", "Lcom/youku/arch/v3/view/IContract$Model;", "getModel", "()Lcom/youku/arch/v3/view/IContract$Model;", "setModel", "(Lcom/youku/arch/v3/view/IContract$Model;)V", "Lcom/youku/arch/v3/view/IContract$View;", "getView", "()Lcom/youku/arch/v3/view/IContract$View;", "setView", "(Lcom/youku/arch/v3/view/IContract$View;)V", "Lcom/youku/arch/v3/IItem;", "getItem", "()Lcom/youku/arch/v3/IItem;", "setItem", "Lcom/youku/arch/v3/event/EventHandler;", "getEventHandler", "()Lcom/youku/arch/v3/event/EventHandler;", "setEventHandler", "(Lcom/youku/arch/v3/event/EventHandler;)V", "isInited", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Lcom/alibaba/fastjson/JSONObject;)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/util/Map;)V", "(Lcom/youku/arch/v3/view/IContract$Model;Lcom/youku/arch/v3/view/IContract$View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class AbsPresenter<DATA extends IItem<ItemValue>, MODEL extends IContract.Model<DATA>, VIEW extends IContract.View> implements IContract.Presenter<DATA, MODEL> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.AbsPresenter";
    @Nullable
    private JSONObject config;
    @NotNull
    private EventHandler eventHandler;
    private volatile boolean isInited;
    public DATA item;
    @Nullable
    private String mClassName;
    public MODEL model;
    public VIEW view;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/view/AbsPresenter$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (tb.b41.d(r2 instanceof java.lang.Boolean ? (java.lang.Boolean) r2 : null, java.lang.Boolean.TRUE) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AbsPresenter(@org.jetbrains.annotations.Nullable java.lang.String r2, @org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.Nullable android.view.View r4, @org.jetbrains.annotations.NotNull com.youku.arch.v3.event.EventHandler r5, @org.jetbrains.annotations.Nullable com.alibaba.fastjson.JSONObject r6) {
        /*
            r1 = this;
            java.lang.String r0 = "vClassName"
            tb.b41.i(r3, r0)
            java.lang.String r0 = "eventHandler"
            tb.b41.i(r5, r0)
            r1.<init>()
            r1.mClassName = r2
            if (r6 == 0) goto L27
            java.lang.String r2 = "PresenterCreator.inAdvance"
            java.lang.Object r2 = r6.get(r2)
            boolean r0 = r2 instanceof java.lang.Boolean
            if (r0 == 0) goto L1e
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            goto L1f
        L1e:
            r2 = 0
        L1f:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r2 = tb.b41.d(r2, r0)
            if (r2 != 0) goto L52
        L27:
            com.youku.arch.v3.view.IContract$View r2 = r1.createView(r3, r4)     // Catch: java.lang.Throwable -> L36
            r1.setView(r2)     // Catch: java.lang.Throwable -> L36
            com.youku.arch.v3.view.IContract$View r2 = r1.getView()     // Catch: java.lang.Throwable -> L36
            r2.bindPresenter(r1)     // Catch: java.lang.Throwable -> L36
            goto L52
        L36:
            r2 = move-exception
            boolean r3 = com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable()
            if (r3 == 0) goto L52
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.String r2 = r2.getMessage()
            java.lang.String r0 = "createView occur exception "
            java.lang.String r2 = tb.b41.r(r0, r2)
            r3[r4] = r2
            java.lang.String r2 = "OneArch.AbsPresenter"
            com.youku.arch.v3.util.LogUtil.e(r2, r3)
        L52:
            r1.eventHandler = r5
            r1.config = r6
            if (r6 != 0) goto L5f
            com.alibaba.fastjson.JSONObject r2 = new com.alibaba.fastjson.JSONObject
            r2.<init>()
            r1.config = r2
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.view.AbsPresenter.<init>(java.lang.String, java.lang.String, android.view.View, com.youku.arch.v3.event.EventHandler, com.alibaba.fastjson.JSONObject):void");
    }

    private final VIEW createView(String str, android.view.View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1831543711")) {
            return (VIEW) ipChange.ipc$dispatch("1831543711", new Object[]{this, str, view});
        }
        Object f = a.k(str, getClass().getClassLoader()).c(view).f();
        b41.h(f, "on(vClassName, this.java….create(renderView).get()");
        return (VIEW) f;
    }

    private final RecyclerView findInnerRecyclerView(ViewGroup viewGroup) {
        RecyclerView findInnerRecyclerView;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-256440769")) {
            return (RecyclerView) ipChange.ipc$dispatch("-256440769", new Object[]{this, viewGroup});
        }
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        while (true) {
            int i2 = i + 1;
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof RecyclerView) {
                return (RecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (findInnerRecyclerView = findInnerRecyclerView((ViewGroup) childAt)) != null) {
                return findInnerRecyclerView;
            }
            if (i2 >= childCount) {
                return null;
            }
            i = i2;
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    @NotNull
    public MODEL createModel(@NotNull DATA data, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189951661")) {
            return (MODEL) ipChange.ipc$dispatch("-189951661", new Object[]{this, data, str});
        }
        b41.i(data, "item");
        Object f = a.k(str, getClass().getClassLoader()).b().f();
        b41.h(f, "on(mClassName, this.java…assLoader).create().get()");
        return (MODEL) f;
    }

    @NotNull
    public final EventHandler getEventHandler() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1981846623") ? (EventHandler) ipChange.ipc$dispatch("1981846623", new Object[]{this}) : this.eventHandler;
    }

    @NotNull
    public final DATA getItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506553139")) {
            return (DATA) ipChange.ipc$dispatch("506553139", new Object[]{this});
        }
        DATA data = this.item;
        if (data != null) {
            return data;
        }
        b41.A("item");
        return null;
    }

    @NotNull
    public final MODEL getModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1848211483")) {
            return (MODEL) ipChange.ipc$dispatch("-1848211483", new Object[]{this});
        }
        MODEL model = this.model;
        if (model != null) {
            return model;
        }
        b41.A("model");
        return null;
    }

    @NotNull
    public final VIEW getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "20642149")) {
            return (VIEW) ipChange.ipc$dispatch("20642149", new Object[]{this});
        }
        VIEW view = this.view;
        if (view != null) {
            return view;
        }
        b41.A("view");
        return null;
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public synchronized void init(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256935758")) {
            ipChange.ipc$dispatch("-1256935758", new Object[]{this, data});
            return;
        }
        b41.i(data, "item");
        setItem(data);
        if (!this.isInited) {
            this.isInited = true;
            setModel(createModel(data, this.mClassName));
        }
        getModel().parseModel(data);
        if (data.getComponent() instanceof GenericComponent) {
            ((GenericComponent) data.getComponent()).setDataBound(true);
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420967541")) {
            ipChange.ipc$dispatch("420967541", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "257279295")) {
            ipChange.ipc$dispatch("257279295", new Object[]{this});
        }
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1006378835")) {
            return ((Boolean) ipChange.ipc$dispatch("-1006378835", new Object[]{this, str, map})).booleanValue();
        }
        b41.i(str, "type");
        if (!b41.d(FragmentEvent.ON_FRAGMENT_RECYCLERVIEW_SCROLL_IDLE, str) || getItem().getComponent().getInnerAdapter() == null || getView().getRenderView() == null) {
            return false;
        }
        android.view.View renderView = getView().getRenderView();
        if (!(renderView instanceof RecyclerView)) {
            renderView = renderView instanceof ViewGroup ? findInnerRecyclerView((ViewGroup) renderView) : null;
        }
        RecyclerView recyclerView = (RecyclerView) renderView;
        RecyclerView.LayoutManager layoutManager = recyclerView == null ? null : recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return false;
        }
        boolean z = false;
        while (true) {
            int i = findFirstVisibleItemPosition + 1;
            android.view.View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition != null) {
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(findViewByPosition);
                VBaseHolder vBaseHolder = childViewHolder instanceof VBaseHolder ? (VBaseHolder) childViewHolder : null;
                z = vBaseHolder != null && vBaseHolder.onMessage(str, map);
            }
            if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                return z;
            }
            findFirstVisibleItemPosition = i;
        }
    }

    public final synchronized void preAsyncInit(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183007381")) {
            ipChange.ipc$dispatch("-183007381", new Object[]{this, data});
            return;
        }
        b41.i(data, "item");
        if (!this.isInited) {
            this.isInited = true;
            setModel(createModel(data, this.mClassName));
        }
        getModel().parseModel(data);
    }

    @Override // com.youku.arch.v3.view.IContract.Presenter
    public void saveState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1005371046")) {
            ipChange.ipc$dispatch("1005371046", new Object[]{this});
        }
    }

    public final void setEventHandler(@NotNull EventHandler eventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-512322267")) {
            ipChange.ipc$dispatch("-512322267", new Object[]{this, eventHandler});
            return;
        }
        b41.i(eventHandler, "<set-?>");
        this.eventHandler = eventHandler;
    }

    public final void setItem(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1028495347")) {
            ipChange.ipc$dispatch("-1028495347", new Object[]{this, data});
            return;
        }
        b41.i(data, "<set-?>");
        this.item = data;
    }

    public final void setModel(@NotNull MODEL model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305416459")) {
            ipChange.ipc$dispatch("-305416459", new Object[]{this, model});
            return;
        }
        b41.i(model, "<set-?>");
        this.model = model;
    }

    public final void setView(@NotNull VIEW view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-463905053")) {
            ipChange.ipc$dispatch("-463905053", new Object[]{this, view});
            return;
        }
        b41.i(view, "<set-?>");
        this.view = view;
    }

    public final void updateConfig(@Nullable Map<String, ? extends Object> map) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145742240")) {
            ipChange.ipc$dispatch("2145742240", new Object[]{this, map});
            return;
        }
        JSONObject jSONObject2 = this.config;
        if (jSONObject2 != null) {
            jSONObject2.clear();
        }
        if (map == null || (jSONObject = this.config) == null) {
            return;
        }
        jSONObject.putAll(map);
    }

    public final void updateEventHandler(@NotNull EventHandler eventHandler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "630957684")) {
            ipChange.ipc$dispatch("630957684", new Object[]{this, eventHandler});
            return;
        }
        b41.i(eventHandler, "eventHandler");
        this.eventHandler = eventHandler;
    }

    public final void updateView(@NotNull String str, @Nullable android.view.View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921301370")) {
            ipChange.ipc$dispatch("-921301370", new Object[]{this, str, view});
            return;
        }
        b41.i(str, "vClassName");
        if (view != null) {
            setView(createView(str, view));
            if (getView() != null) {
                getView().bindPresenter(this);
                return;
            }
            throw new IllegalStateException(b41.r("createView null ", str).toString());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbsPresenter(@Nullable String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        this(str, str2, view, eventHandler, JSON.parseObject(str3));
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AbsPresenter(@org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.Nullable android.view.View r10, @org.jetbrains.annotations.NotNull com.youku.arch.v3.event.EventHandler r11, @org.jetbrains.annotations.Nullable java.util.Map<?, ?> r12) {
        /*
            r7 = this;
            java.lang.String r0 = "vClassName"
            tb.b41.i(r9, r0)
            java.lang.String r0 = "eventHandler"
            tb.b41.i(r11, r0)
            java.lang.Object r12 = com.alibaba.fastjson.JSON.toJSON(r12)
            java.lang.String r0 = "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject"
            java.util.Objects.requireNonNull(r12, r0)
            r6 = r12
            com.alibaba.fastjson.JSONObject r6 = (com.alibaba.fastjson.JSONObject) r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.view.AbsPresenter.<init>(java.lang.String, java.lang.String, android.view.View, com.youku.arch.v3.event.EventHandler, java.util.Map):void");
    }

    public AbsPresenter(@NotNull MODEL model, @NotNull VIEW view, @NotNull EventHandler eventHandler, @Nullable String str) {
        b41.i(model, "model");
        b41.i(view, "view");
        b41.i(eventHandler, "eventHandler");
        this.mClassName = null;
        setModel(model);
        setView(view);
        getView().bindPresenter(this);
        this.eventHandler = eventHandler;
        if (str == null || str.length() == 0) {
            this.config = new JSONObject();
        } else {
            this.config = JSON.parseObject(str);
        }
    }
}
