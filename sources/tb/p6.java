package tb;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.app.AppConfigItem;
import com.alibaba.poplayer.utils.Monitor;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class p6 extends com.alibaba.poplayer.trigger.a<AppConfigItem> {
    public static final String KEY_CONFIG_APP = "poplayer_app_config";
    public static final String KEY_CONFIG_WHITE_LIST = "poplayer_app_white_list";
    @Monitor.TargetField(name = ip1.MONITOR_WHITELIST)
    protected List<String> i;

    public p6(IConfigAdapter iConfigAdapter) {
        super(iConfigAdapter, KEY_CONFIG_APP, com.alibaba.poplayer.trigger.a.KEY_BLACK_LIST);
        this.i = new ArrayList();
        dt1.a("AppConfigMgr use " + AppConfigItem.LOG);
    }

    private boolean z(Event event, List<BaseConfigItem.a> list) {
        if (list != null && !list.isEmpty()) {
            for (BaseConfigItem.a aVar : list) {
                if (n(event, aVar) && e(event, aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.a
    /* renamed from: A */
    public AppConfigItem r(String str) {
        String[] strArr;
        try {
            AppConfigItem appConfigItem = (AppConfigItem) JSON.parseObject(str, AppConfigItem.class);
            if (appConfigItem.survivalWhiteList != null && appConfigItem.survivalBlackList != null) {
                dt1.b("App parseConfig error. survivalBlackList and survivalWhiteList exist at the same time", new Object[0]);
                return null;
            }
            BaseConfigItem.a t = t(str, appConfigItem.uuid);
            appConfigItem.pageInfo = t;
            if (!TextUtils.isEmpty(t.a) || (!((strArr = appConfigItem.pageInfo.b) == null || strArr.length == 0) || appConfigItem.whiteList == null || appConfigItem.blackList == null)) {
                return appConfigItem;
            }
            dt1.b("App parseConfig error. whitelist and blacklist exist at the same time", new Object[0]);
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.alibaba.poplayer.trigger.a
    /* renamed from: B */
    public AppConfigItem s(Event event) {
        JSONObject u = u(Uri.parse(event.originUri));
        String[] strArr = {"whiteList", "blackList", "survivalWhiteList", "survivalBlackList"};
        for (int i = 0; i < 4; i++) {
            try {
                String str = strArr[i];
                String str2 = (String) u.opt(str);
                if (!TextUtils.isEmpty(str2)) {
                    u.remove(str);
                    u.put("array_" + str, URLDecoder.decode(str2, "utf-8"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        AppConfigItem appConfigItem = (AppConfigItem) JSON.parseObject(u.toString(), AppConfigItem.class);
        try {
            if (!TextUtils.isEmpty(u.optString("array_whiteList"))) {
                appConfigItem.whiteList = (ArrayList) JSON.parseArray((String) u.get("array_whiteList"), BaseConfigItem.a.class);
            }
            if (!TextUtils.isEmpty(u.optString("array_blackList"))) {
                appConfigItem.blackList = (ArrayList) JSON.parseArray((String) u.get("array_blackList"), BaseConfigItem.a.class);
            }
            if (!TextUtils.isEmpty(u.optString("array_survivalWhiteList"))) {
                appConfigItem.survivalWhiteList = (ArrayList) JSON.parseArray((String) u.get("array_survivalWhiteList"), BaseConfigItem.a.class);
            }
            if (!TextUtils.isEmpty(u.optString("array_survivalBlackList"))) {
                appConfigItem.survivalBlackList = (ArrayList) JSON.parseArray((String) u.get("array_survivalBlackList"), BaseConfigItem.a.class);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        ArrayList<BaseConfigItem.a> arrayList = appConfigItem.blackList;
        if ((arrayList != null && arrayList != null) || (appConfigItem.survivalWhiteList != null && appConfigItem.survivalBlackList != null)) {
            dt1.b("App parseConfig error. whitelist and blacklist exist at the same time", new Object[0]);
            return null;
        }
        appConfigItem.pageInfo = t(u.toString(), appConfigItem.uuid);
        return appConfigItem;
    }

    @Override // com.alibaba.poplayer.trigger.a
    public vw2<AppConfigItem> h(Event event) {
        return x(event, "");
    }

    @Override // com.alibaba.poplayer.trigger.a
    protected void p(List<AppConfigItem> list, String str, List<String> list2) {
        d7.A().w();
    }

    @Override // com.alibaba.poplayer.trigger.a
    protected void v(IConfigAdapter iConfigAdapter, Context context) {
        try {
            String configItemByKey = iConfigAdapter.getConfigItemByKey(context, KEY_CONFIG_WHITE_LIST);
            dt1.b("App white List :{%s}.", configItemByKey);
            synchronized (this.i) {
                this.i = com.alibaba.poplayer.trigger.a.l(configItemByKey) ? new ArrayList<>() : Arrays.asList(configItemByKey.split(","));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public tb.vw2<com.alibaba.poplayer.trigger.app.AppConfigItem> x(com.alibaba.poplayer.trigger.Event r11, java.lang.String... r12) {
        /*
            r10 = this;
            if (r11 != 0) goto L4
            r11 = 0
            return r11
        L4:
            int r0 = r11.source
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L20
            if (r12 == 0) goto L20
            int r0 = r12.length
            r3 = 2
            if (r0 != r3) goto L20
            com.alibaba.poplayer.trigger.Event r0 = new com.alibaba.poplayer.trigger.Event
            int r5 = r11.domain
            r6 = r12[r1]
            r7 = r12[r2]
            java.lang.String r8 = r11.attachActivityKeyCode
            r9 = 1
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            goto L21
        L20:
            r0 = r11
        L21:
            boolean r12 = r10.q(r11)
            if (r12 == 0) goto L36
            tb.vw2 r12 = new tb.vw2
            r12.<init>()
            java.util.ArrayList<T extends com.alibaba.poplayer.trigger.BaseConfigItem> r0 = r12.a
            com.alibaba.poplayer.trigger.app.AppConfigItem r11 = r10.s(r11)
            r0.add(r11)
            return r12
        L36:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List<ConfigItemType extends com.alibaba.poplayer.trigger.BaseConfigItem> r3 = r10.b
            java.util.Iterator r3 = r3.iterator()
        L41:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L9b
            java.lang.Object r4 = r3.next()
            com.alibaba.poplayer.trigger.app.AppConfigItem r4 = (com.alibaba.poplayer.trigger.app.AppConfigItem) r4
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r6 = "AppConfigManager.whitelist check."
            tb.dt1.b(r6, r5)
            java.util.List<java.lang.String> r5 = r10.i
            boolean r5 = r10.m(r5)
            if (r5 != 0) goto L5d
            goto L41
        L5d:
            int r5 = r11.source
            if (r5 != r2) goto L73
            com.alibaba.poplayer.trigger.BaseConfigItem$a r5 = r4.pageInfo
            boolean r5 = r10.n(r11, r5)
            if (r5 != 0) goto L6a
            goto L41
        L6a:
            com.alibaba.poplayer.trigger.BaseConfigItem$a r5 = r4.pageInfo
            boolean r5 = r10.e(r11, r5)
            if (r5 != 0) goto L89
            goto L41
        L73:
            java.util.ArrayList<com.alibaba.poplayer.trigger.BaseConfigItem$a> r5 = r4.whiteList
            if (r5 == 0) goto L7e
            boolean r5 = r10.z(r0, r5)
            if (r5 != 0) goto L7e
            goto L41
        L7e:
            java.util.ArrayList<com.alibaba.poplayer.trigger.BaseConfigItem$a> r5 = r4.blackList
            if (r5 == 0) goto L89
            boolean r5 = r10.z(r0, r5)
            if (r5 == 0) goto L89
            goto L41
        L89:
            boolean r5 = r10.y(r4, r0)
            if (r5 != 0) goto L97
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "AppConfigManager.config{%s} can not survival in this page."
            tb.dt1.b(r5, r4)
            goto L41
        L97:
            r12.add(r4)
            goto L41
        L9b:
            tb.vw2 r11 = r10.f(r11, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.p6.x(com.alibaba.poplayer.trigger.Event, java.lang.String[]):tb.vw2");
    }

    public boolean y(AppConfigItem appConfigItem, Event event) {
        ArrayList<BaseConfigItem.a> arrayList = appConfigItem.survivalWhiteList;
        if (arrayList != null) {
            return z(event, arrayList);
        }
        return !z(event, appConfigItem.survivalBlackList);
    }
}
