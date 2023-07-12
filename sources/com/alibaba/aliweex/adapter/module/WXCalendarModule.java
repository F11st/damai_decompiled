package com.alibaba.aliweex.adapter.module;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Calendar;
import tb.jf;
import tb.w30;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXCalendarModule extends WXModule {
    static final int REQUEST_CALENDAR_PERMISSION_CODE = 25;
    public static final String TAG = "WXCalendarModule";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class PerReceiver extends BroadcastReceiver {
        PermissionCallback a;

        PerReceiver(PermissionCallback permissionCallback) {
            this.a = permissionCallback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                boolean z = false;
                if (intent.getIntExtra("requestCode", 0) == 25) {
                    int[] intArrayExtra = intent.getIntArrayExtra(WXModule.GRANT_RESULTS);
                    String[] stringArrayExtra = intent.getStringArrayExtra("permissions");
                    for (int i = 0; intArrayExtra != null && i < intArrayExtra.length; i++) {
                        if (intArrayExtra[i] != 0) {
                            this.a.onPermissionsDenied(stringArrayExtra[i]);
                            break;
                        }
                    }
                    z = true;
                    if (z) {
                        this.a.onPermissionsGranted();
                    }
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            } catch (Throwable th) {
                WXLogUtils.e(WXCalendarModule.TAG, th);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface PermissionCallback {
        void onPermissionsDenied(String str);

        void onPermissionsGranted();
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements PermissionCallback {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSCallback b;
        final /* synthetic */ JSCallback c;

        a(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSONObject;
            this.b = jSCallback;
            this.c = jSCallback2;
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsDenied(String str) {
            JSCallback jSCallback = this.c;
            WXCalendarModule wXCalendarModule = WXCalendarModule.this;
            jSCallback.invoke(wXCalendarModule.buildError("no permission:" + str));
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsGranted() {
            if (!this.a.containsKey("batch")) {
                WXCalendarModule.this.addSingleEvent(this.a);
                this.b.invoke(null);
                return;
            }
            JSONArray jSONArray = this.a.getJSONArray("batch");
            for (int i = 0; i < jSONArray.size(); i++) {
                WXCalendarModule.this.addSingleEvent(jSONArray.getJSONObject(i));
            }
            this.b.invoke(null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class b implements PermissionCallback {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSCallback b;
        final /* synthetic */ JSCallback c;

        b(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSONObject;
            this.b = jSCallback;
            this.c = jSCallback2;
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsDenied(String str) {
            JSCallback jSCallback = this.c;
            WXCalendarModule wXCalendarModule = WXCalendarModule.this;
            jSCallback.invoke(wXCalendarModule.buildError("no permission:" + str));
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsGranted() {
            if (!this.a.containsKey("batch")) {
                if (WXCalendarModule.this.checkSingleEvent(this.a)) {
                    this.b.invoke(Boolean.TRUE);
                    return;
                } else {
                    this.b.invoke(Boolean.FALSE);
                    return;
                }
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = this.a.getJSONArray("batch");
            for (int i = 0; i < jSONArray2.size(); i++) {
                jSONArray.add(Boolean.valueOf(WXCalendarModule.this.checkSingleEvent(jSONArray2.getJSONObject(i))));
            }
            this.b.invoke(jSONArray);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class c implements PermissionCallback {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSCallback b;
        final /* synthetic */ JSCallback c;

        c(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
            this.a = jSONObject;
            this.b = jSCallback;
            this.c = jSCallback2;
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsDenied(String str) {
            JSCallback jSCallback = this.c;
            WXCalendarModule wXCalendarModule = WXCalendarModule.this;
            jSCallback.invoke(wXCalendarModule.buildError("no permission: " + str));
        }

        @Override // com.alibaba.aliweex.adapter.module.WXCalendarModule.PermissionCallback
        public void onPermissionsGranted() {
            if (!this.a.containsKey("batch")) {
                WXCalendarModule.this.removeSingleEvent(this.a);
                this.b.invoke(null);
                return;
            }
            JSONArray jSONArray = this.a.getJSONArray("batch");
            for (int i = 0; i < jSONArray.size(); i++) {
                WXCalendarModule.this.removeSingleEvent(jSONArray.getJSONObject(i));
            }
            this.b.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean addSingleEvent(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("note");
            String string3 = jSONObject.getString("startDate");
            String string4 = jSONObject.getString("endDate");
            int intValue = jSONObject.getIntValue("timeOffset");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(w30.b(string3));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(w30.b(string4));
            return jf.c(this.mWXSDKInstance.getContext(), string, string2, calendar, calendar2, intValue / 60);
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject buildError(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", (Object) "WX_FAILED");
        jSONObject.put("message", (Object) str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSingleEvent(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("startDate");
            String string3 = jSONObject.getString("endDate");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(w30.b(string2));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(w30.b(string3));
            return jf.d(this.mWXSDKInstance.getContext(), string, "", calendar, calendar2);
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeSingleEvent(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("startDate");
            String string3 = jSONObject.getString("endDate");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(w30.b(string2));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(w30.b(string3));
            return jf.e(this.mWXSDKInstance.getContext(), string, calendar, calendar2);
        } catch (Exception e) {
            WXLogUtils.e(TAG, e);
            return false;
        }
    }

    private void requestPermission(PermissionCallback permissionCallback, String... strArr) {
        try {
            ActivityCompat.requestPermissions((Activity) this.mWXSDKInstance.getContext(), strArr, 25);
            LocalBroadcastManager.getInstance(this.mWXSDKInstance.getContext()).registerReceiver(new PerReceiver(permissionCallback), new IntentFilter(WXModule.ACTION_REQUEST_PERMISSIONS_RESULT));
        } catch (Throwable th) {
            WXLogUtils.e(TAG, th);
        }
    }

    @JSMethod
    public void addEvent(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        requestPermission(new a(jSONObject, jSCallback, jSCallback2), "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
    }

    @JSMethod
    public void checkEvent(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        requestPermission(new b(jSONObject, jSCallback, jSCallback2), "android.permission.READ_CALENDAR");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
        if (r7 == 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
        r14.invoke(buildError("undefine permission: " + r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
        r2.add("android.permission.WRITE_CALENDAR");
     */
    @com.taobao.weex.annotation.JSMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkPermission(com.alibaba.fastjson.JSONObject r12, com.taobao.weex.bridge.JSCallback r13, com.taobao.weex.bridge.JSCallback r14) {
        /*
            r11 = this;
            java.lang.String r0 = "permissions"
            com.taobao.weex.WXSDKInstance r1 = r11.mWXSDKInstance     // Catch: java.lang.Throwable -> Lbe
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> Lbe
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbe
            r2.<init>()     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r3 = "android.permission.WRITE_CALENDAR"
            java.lang.String r4 = "android.permission.READ_CALENDAR"
            if (r12 == 0) goto L84
            com.alibaba.fastjson.JSONArray r5 = r12.getJSONArray(r0)     // Catch: java.lang.Throwable -> Lbe
            if (r5 == 0) goto L84
            com.alibaba.fastjson.JSONArray r12 = r12.getJSONArray(r0)     // Catch: java.lang.Throwable -> Lbe
            int r0 = r12.size()     // Catch: java.lang.Throwable -> Lbe
            if (r0 != 0) goto L2d
            java.lang.String r12 = "permissions.size() == 0"
            com.alibaba.fastjson.JSONObject r12 = r11.buildError(r12)     // Catch: java.lang.Throwable -> Lbe
            r14.invoke(r12)     // Catch: java.lang.Throwable -> Lbe
            return
        L2d:
            r0 = 0
            r5 = 0
        L2f:
            int r6 = r12.size()     // Catch: java.lang.Throwable -> Lbe
            if (r5 >= r6) goto L8a
            java.lang.String r6 = r12.getString(r5)     // Catch: java.lang.Throwable -> Lbe
            r7 = -1
            int r8 = r6.hashCode()     // Catch: java.lang.Throwable -> Lbe
            r9 = 3496342(0x355996, float:4.899419E-39)
            r10 = 1
            if (r8 == r9) goto L54
            r9 = 113399775(0x6c257df, float:7.3103804E-35)
            if (r8 == r9) goto L4a
            goto L5d
        L4a:
            java.lang.String r8 = "write"
            boolean r8 = r6.equals(r8)     // Catch: java.lang.Throwable -> Lbe
            if (r8 == 0) goto L5d
            r7 = 1
            goto L5d
        L54:
            java.lang.String r8 = "read"
            boolean r8 = r6.equals(r8)     // Catch: java.lang.Throwable -> Lbe
            if (r8 == 0) goto L5d
            r7 = 0
        L5d:
            if (r7 == 0) goto L7e
            if (r7 == r10) goto L7a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbe
            r12.<init>()     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r13 = "undefine permission: "
            r12.append(r13)     // Catch: java.lang.Throwable -> Lbe
            r12.append(r6)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Lbe
            com.alibaba.fastjson.JSONObject r12 = r11.buildError(r12)     // Catch: java.lang.Throwable -> Lbe
            r14.invoke(r12)     // Catch: java.lang.Throwable -> Lbe
            return
        L7a:
            r2.add(r3)     // Catch: java.lang.Throwable -> Lbe
            goto L81
        L7e:
            r2.add(r4)     // Catch: java.lang.Throwable -> Lbe
        L81:
            int r5 = r5 + 1
            goto L2f
        L84:
            r2.add(r4)     // Catch: java.lang.Throwable -> Lbe
            r2.add(r3)     // Catch: java.lang.Throwable -> Lbe
        L8a:
            java.util.Iterator r12 = r2.iterator()     // Catch: java.lang.Throwable -> Lbe
        L8e:
            boolean r0 = r12.hasNext()     // Catch: java.lang.Throwable -> Lbe
            if (r0 == 0) goto Lb9
            java.lang.Object r0 = r12.next()     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Lbe
            int r2 = androidx.core.content.ContextCompat.checkSelfPermission(r1, r0)     // Catch: java.lang.Throwable -> Lbe
            if (r2 == 0) goto L8e
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbe
            r12.<init>()     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r13 = "no permission: "
            r12.append(r13)     // Catch: java.lang.Throwable -> Lbe
            r12.append(r0)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> Lbe
            com.alibaba.fastjson.JSONObject r12 = r11.buildError(r12)     // Catch: java.lang.Throwable -> Lbe
            r14.invoke(r12)     // Catch: java.lang.Throwable -> Lbe
            return
        Lb9:
            r12 = 0
            r13.invoke(r12)     // Catch: java.lang.Throwable -> Lbe
            goto Lca
        Lbe:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            com.alibaba.fastjson.JSONObject r12 = r11.buildError(r12)
            r14.invoke(r12)
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.aliweex.adapter.module.WXCalendarModule.checkPermission(com.alibaba.fastjson.JSONObject, com.taobao.weex.bridge.JSCallback, com.taobao.weex.bridge.JSCallback):void");
    }

    @JSMethod
    public void removeEvent(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        requestPermission(new c(jSONObject, jSCallback, jSCallback2), "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
    }
}
