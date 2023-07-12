package com.youku.arch.v3.core;

import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.util.Util;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fJ4\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fJ,\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fR\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/youku/arch/v3/core/EventDispatcher;", "", "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "pageContainer", "", "Lcom/youku/arch/v3/core/Coordinate;", "coordinates", "Lcom/youku/arch/v3/event/EventHandler;", "getTargets", "container", "coordinate", "getEventHandler", "", "type", "", "params", "Ltb/wt2;", "dispatchEvent", "eventHandler", "", "Lcom/youku/arch/v3/core/IContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "<init>", "(Lcom/youku/arch/v3/core/IContext;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EventDispatcher {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String TAG = "OneArch.EventDispatcher";
    @NotNull
    private final IContext pageContext;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/EventDispatcher$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public EventDispatcher(@NotNull IContext iContext) {
        b41.i(iContext, com.youku.arch.v3.data.Constants.PAGE_CONTEXT);
        this.pageContext = iContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventHandler getEventHandler(IContainer<ModelValue> iContainer, Coordinate coordinate) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-161658264")) {
            return (EventHandler) ipChange.ipc$dispatch("-161658264", new Object[]{this, iContainer, coordinate});
        }
        if (coordinate.isContainerCoordinate()) {
            return iContainer;
        }
        Util.throwIf(iContainer.getChildCount() <= coordinate.getModuleIndex() || coordinate.getModuleIndex() < -1);
        IModule<ModuleValue> iModule = iContainer.getModules().get(coordinate.getModuleIndex());
        if (coordinate.isModuleCoordinate()) {
            return iModule;
        }
        Util.throwIf(iModule.getChildCount() <= coordinate.getComponentIndex() || coordinate.getComponentIndex() < -1);
        IComponent<ComponentValue> iComponent = iModule.getComponents().get(coordinate.getComponentIndex());
        if (coordinate.isComponentCoordinate()) {
            return iComponent;
        }
        if (iComponent.getChildCount() > coordinate.getItemIndex() && coordinate.getItemIndex() >= -1) {
            z = false;
        }
        Util.throwIf(z);
        return coordinate.isItemCoordinate() ? iComponent.getItems().get(coordinate.getItemIndex()) : iContainer;
    }

    private final List<EventHandler> getTargets(final IContainer<ModelValue> iContainer, final List<Coordinate> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406537115")) {
            return (List) ipChange.ipc$dispatch("-406537115", new Object[]{this, iContainer, list});
        }
        final ArrayList arrayList = new ArrayList();
        if (b41.d(Looper.getMainLooper(), Looper.myLooper())) {
            synchronized (iContainer) {
                if (list != null) {
                    for (Coordinate coordinate : list) {
                        arrayList.add(getEventHandler(iContainer, coordinate));
                    }
                    wt2 wt2Var = wt2.INSTANCE;
                }
            }
        } else {
            this.pageContext.runOnLoaderThreadLocked(new Function0<wt2>() { // from class: com.youku.arch.v3.core.EventDispatcher$getTargets$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final wt2 invoke() {
                    EventHandler eventHandler;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1190742020")) {
                        return (wt2) ipChange2.ipc$dispatch("1190742020", new Object[]{this});
                    }
                    List<Coordinate> list2 = list;
                    if (list2 == null) {
                        return null;
                    }
                    ArrayList<EventHandler> arrayList2 = arrayList;
                    EventDispatcher eventDispatcher = this;
                    IContainer<ModelValue> iContainer2 = iContainer;
                    for (Coordinate coordinate2 : list2) {
                        eventHandler = eventDispatcher.getEventHandler(iContainer2, coordinate2);
                        arrayList2.add(eventHandler);
                    }
                    return wt2.INSTANCE;
                }
            });
        }
        return arrayList;
    }

    public final void dispatchEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129238084")) {
            ipChange.ipc$dispatch("129238084", new Object[]{this, str, map});
            return;
        }
        b41.i(str, "type");
        IContainer<ModelValue> pageContainer = this.pageContext.getPageContainer();
        if (pageContainer == null) {
            return;
        }
        pageContainer.onMessage(str, map);
    }

    public final void dispatchEvent(@Nullable List<Coordinate> list, @NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366288243")) {
            ipChange.ipc$dispatch("1366288243", new Object[]{this, list, str, map});
            return;
        }
        b41.i(str, "type");
        IContainer<ModelValue> pageContainer = this.pageContext.getPageContainer();
        if (pageContainer == null) {
            return;
        }
        try {
            for (EventHandler eventHandler : getTargets(pageContainer, list)) {
                dispatchEvent(eventHandler, str, map);
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                throw e;
            }
        }
    }

    public final boolean dispatchEvent(@NotNull EventHandler eventHandler, @NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365535637")) {
            return ((Boolean) ipChange.ipc$dispatch("-1365535637", new Object[]{this, eventHandler, str, map})).booleanValue();
        }
        b41.i(eventHandler, "eventHandler");
        b41.i(str, "type");
        return eventHandler.onMessage(str, map);
    }
}
