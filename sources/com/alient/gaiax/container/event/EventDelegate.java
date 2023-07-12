package com.alient.gaiax.container.event;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.nav.Action;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JZ\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH&¨\u0006\u0010"}, d2 = {"Lcom/alient/gaiax/container/event/EventDelegate;", "", "Landroid/view/View;", "view", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "eventName", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "Lcom/alient/oneservice/nav/Action;", "actions", "params", "Ltb/wt2;", "onEvent", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public interface EventDelegate {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onEvent$default(EventDelegate eventDelegate, View view, Context context, String str, JSONObject jSONObject, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEvent");
            }
            Map<String, ? extends Object> map3 = map2;
            if ((i & 32) != 0) {
                map3 = null;
            }
            eventDelegate.onEvent(view, context, str, jSONObject, map, map3);
        }
    }

    void onEvent(@Nullable View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, @Nullable Map<String, ? extends Action> map, @Nullable Map<String, ? extends Object> map2);
}
