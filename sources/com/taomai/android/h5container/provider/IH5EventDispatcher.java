package com.taomai.android.h5container.provider;

import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¨\u0006\t"}, d2 = {"Lcom/taomai/android/h5container/provider/IH5EventDispatcher;", "", "", "type", "data", "Ltb/wt2;", WXBridgeManager.METHOD_FIRE_EVENT, "eventName", "fireGlobalEvent", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public interface IH5EventDispatcher {
    void fireEvent(@Nullable String str, @Nullable String str2);

    void fireGlobalEvent(@Nullable String str, @Nullable String str2);
}
