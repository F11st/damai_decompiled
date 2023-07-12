package tb;

import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ct1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class pt1 {
    /* JADX WARN: Removed duplicated region for block: B:20:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0029 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.ArrayList<java.lang.String> a(@org.jetbrains.annotations.Nullable java.lang.String[] r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r7 == 0) goto L2c
            int r1 = r7.length
            r2 = 0
            r3 = 1
            if (r1 != 0) goto Le
            r1 = 1
            goto Lf
        Le:
            r1 = 0
        Lf:
            r1 = r1 ^ r3
            if (r1 == 0) goto L2c
            int r1 = r7.length
            r4 = 0
        L14:
            if (r4 >= r1) goto L2c
            r5 = r7[r4]
            if (r5 == 0) goto L23
            boolean r6 = kotlin.text.g.s(r5)
            if (r6 == 0) goto L21
            goto L23
        L21:
            r6 = 0
            goto L24
        L23:
            r6 = 1
        L24:
            if (r6 != 0) goto L29
            r0.add(r5)
        L29:
            int r4 = r4 + 1
            goto L14
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.pt1.a(java.lang.String[]):java.util.ArrayList");
    }

    @Nullable
    public static final <T> T b(@Nullable WeakReference<T> weakReference) {
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static final boolean c(@NotNull String str) {
        b41.i(str, "sceneName");
        ArrayList<String> g = lt1.Companion.a().g();
        if (g != null) {
            try {
                HashMap hashMap = new HashMap();
                if (!(!g.isEmpty()) || g.size() <= 0) {
                    return false;
                }
                hashMap.put("localPopupPages", g.toArray().toString());
                Iterator<String> it = g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    b41.h(next, AdvanceSetting.NETWORK_TYPE);
                    if (b41.d(str, next)) {
                        h(str, "localPopupPages_container", hashMap);
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static final boolean d(ArrayList<String> arrayList, String str, String str2) {
        if (arrayList != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("from", str2);
                if (!(!arrayList.isEmpty()) || arrayList.size() <= 0) {
                    return false;
                }
                hashMap.put("sceneTypes", arrayList.toArray().toString());
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    b41.h(next, AdvanceSetting.NETWORK_TYPE);
                    if (b41.d(str, next)) {
                        h(str, "sceneType_container", hashMap);
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static final boolean e(@Nullable PopupResponseBean popupResponseBean) {
        ArrayList<PopupDetailBean> arrayList;
        PopupDetailBean popupDetailBean;
        PopupDetailBean.PopupItem popupItem;
        String str;
        if (popupResponseBean == null || (arrayList = popupResponseBean.show) == null || arrayList.size() <= 0 || (popupDetailBean = arrayList.get(0)) == null || (popupItem = popupDetailBean.item) == null || (str = popupItem.templateUrl) == null) {
            return false;
        }
        b41.h(str, "templateUrl");
        return true;
    }

    public static final boolean f(@NotNull String str) {
        b41.i(str, "sceneName");
        ct1.a aVar = ct1.Companion;
        if (d(aVar.a().f(), str, "net_sceneType") || d(aVar.a().e(), str, "orange_sceneType")) {
            return true;
        }
        return d(lt1.Companion.a().h(), str, "local_sceneType");
    }

    public static final void g(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable HashMap<String, String> hashMap) {
        boolean s;
        b41.i(str, "spmb");
        b41.i(str2, "spmc");
        b41.i(str3, "spmd");
        TrackInfo trackInfo = new TrackInfo();
        s = kotlin.text.o.s(str);
        if (s) {
            str = AgooConstants.MESSAGE_POPUP;
        }
        trackInfo.setSpmb(str);
        trackInfo.setSpmc(str2);
        trackInfo.setSpmd(str3);
        trackInfo.setArgs(hashMap);
        UserTrackProviderProxy.click(trackInfo, false);
    }

    public static final void h(@NotNull String str, @NotNull String str2, @Nullable HashMap<String, String> hashMap) {
        b41.i(str, "spmc");
        b41.i(str2, "spmd");
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpmb(AgooConstants.MESSAGE_POPUP);
        trackInfo.setSpmc(str);
        trackInfo.setSpmd(str2);
        trackInfo.setArgs(hashMap);
        UserTrackProviderProxy.click(trackInfo, false);
    }
}
