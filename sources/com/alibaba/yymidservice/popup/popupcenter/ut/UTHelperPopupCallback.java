package com.alibaba.yymidservice.popup.popupcenter.ut;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface UTHelperPopupCallback {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.yymidservice.popup.popupcenter.ut.UTHelperPopupCallback$a */
    /* loaded from: classes8.dex */
    public static final class C4028a {
        public static /* synthetic */ void a(UTHelperPopupCallback uTHelperPopupCallback, HashMap hashMap, Map map, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeUt");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            uTHelperPopupCallback.closeUt(hashMap, map, z);
        }

        public static /* synthetic */ void b(UTHelperPopupCallback uTHelperPopupCallback, long j, HashMap hashMap, Map map, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposureUt");
            }
            uTHelperPopupCallback.exposureUt(j, hashMap, map, (i & 8) != 0 ? false : z);
        }
    }

    void closeUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z);

    void confirmUt(@Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z);

    void exposureUt(long j, @Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z);

    void itemUt(@Nullable View view, @Nullable HashMap<String, String> hashMap, @Nullable Map<String, ? extends JSONObject> map, boolean z);
}
