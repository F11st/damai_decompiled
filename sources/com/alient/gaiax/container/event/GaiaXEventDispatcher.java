package com.alient.gaiax.container.event;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.nav.Action;
import com.xiaomi.mipush.sdk.MiPushClient;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J^\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006R.\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00150\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/alient/gaiax/container/event/GaiaXEventDispatcher;", "", "Landroid/view/View;", "view", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "pageName", "eventName", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "Lcom/alient/oneservice/nav/Action;", "actions", "params", "Ltb/wt2;", "dispatch", "Lcom/alient/gaiax/container/event/EventDelegate;", "eventDelegate", "register", MiPushClient.COMMAND_UNREGISTER, "", "eventDelegates", "Ljava/util/Map;", "<init>", "()V", "Companion", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class GaiaXEventDispatcher {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<GaiaXEventDispatcher> instance$delegate;
    @NotNull
    private final Map<String, Map<String, EventDelegate>> eventDelegates = new LinkedHashMap();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/alient/gaiax/container/event/GaiaXEventDispatcher$Companion;", "", "Lcom/alient/gaiax/container/event/GaiaXEventDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/gaiax/container/event/GaiaXEventDispatcher;", "instance", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GaiaXEventDispatcher getInstance() {
            return (GaiaXEventDispatcher) GaiaXEventDispatcher.instance$delegate.getValue();
        }
    }

    static {
        Lazy<GaiaXEventDispatcher> a;
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<GaiaXEventDispatcher>() { // from class: com.alient.gaiax.container.event.GaiaXEventDispatcher$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GaiaXEventDispatcher invoke() {
                return new GaiaXEventDispatcher();
            }
        });
        instance$delegate = a;
    }

    public static /* synthetic */ void unregister$default(GaiaXEventDispatcher gaiaXEventDispatcher, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        gaiaXEventDispatcher.unregister(str, str2);
    }

    public final void dispatch(@Nullable View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable JSONObject jSONObject, @Nullable Map<String, ? extends Action> map, @Nullable Map<String, ? extends Object> map2) {
        EventDelegate eventDelegate;
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "pageName");
        b41.i(str2, "eventName");
        Map<String, EventDelegate> map3 = this.eventDelegates.get(str);
        if (map3 == null || (eventDelegate = map3.get(str2)) == null) {
            return;
        }
        eventDelegate.onEvent(view, context, str2, jSONObject, map, map2);
    }

    public final void register(@NotNull String str, @NotNull String str2, @NotNull EventDelegate eventDelegate) {
        b41.i(str, "pageName");
        b41.i(str2, "eventName");
        b41.i(eventDelegate, "eventDelegate");
        if (this.eventDelegates.containsKey(str)) {
            Map<String, EventDelegate> map = this.eventDelegates.get(str);
            if (map == null) {
                return;
            }
            map.put(str2, eventDelegate);
            return;
        }
        Map<String, Map<String, EventDelegate>> map2 = this.eventDelegates;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str2, eventDelegate);
        map2.put(str, linkedHashMap);
    }

    public final void unregister(@NotNull String str, @Nullable String str2) {
        Map<String, EventDelegate> map;
        b41.i(str, "pageName");
        if (str2 == null) {
            str2 = null;
        } else {
            Map<String, EventDelegate> map2 = this.eventDelegates.get(str);
            if (map2 != null) {
                map2.remove(str2);
            }
        }
        if (str2 != null || (map = this.eventDelegates.get(str)) == null) {
            return;
        }
        map.clear();
    }
}
