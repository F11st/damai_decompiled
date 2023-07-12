package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.C5943a;
import com.meizu.cloud.pushsdk.c.a.C5950c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.C6092b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.io.File;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.platform.a.a */
/* loaded from: classes10.dex */
public class C6090a {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;

    public C6090a(Context context) {
        this.a = "https://api-push.meizu.com/garcia/api/client/";
        this.b = this.a + "message/registerPush";
        this.c = this.a + "message/unRegisterPush";
        this.d = this.a + "advance/unRegisterPush";
        this.e = this.a + "message/getRegisterSwitch";
        this.f = this.a + "message/changeRegisterSwitch";
        this.g = this.a + "message/changeAllSwitch";
        this.h = this.a + "message/subscribeTags";
        this.i = this.a + "message/unSubscribeTags";
        this.j = this.a + "message/unSubAllTags";
        this.k = this.a + "message/getSubTags";
        this.l = this.a + "message/subscribeAlias";
        this.m = this.a + "message/unSubscribeAlias";
        this.n = this.a + "message/getSubAlias";
        this.o = this.a + "advance/changeRegisterSwitch";
        C5943a.a();
        if (MzSystemUtils.isOverseas()) {
            this.a = "https://api-push.in.meizu.com/garcia/api/client/";
            this.b = this.a + "message/registerPush";
            this.c = this.a + "message/unRegisterPush";
            this.d = this.a + "advance/unRegisterPush";
            this.e = this.a + "message/getRegisterSwitch";
            this.f = this.a + "message/changeRegisterSwitch";
            this.g = this.a + "message/changeAllSwitch";
            this.h = this.a + "message/subscribeTags";
            this.i = this.a + "message/unSubscribeTags";
            this.j = this.a + "message/unSubAllTags";
            this.k = this.a + "message/getSubTags";
            this.l = this.a + "message/subscribeAlias";
            this.m = this.a + "message/unSubscribeAlias";
            this.n = this.a + "message/getSubAlias";
            this.o = this.a + "advance/changeRegisterSwitch";
        }
    }

    public C5950c a(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "register post map " + linkedHashMap2);
        return C5943a.b(this.b).a(linkedHashMap2).a().a();
    }

    public C5950c a(String str, String str2, String str3, int i, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("msgType", String.valueOf(i));
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", this.f + " switchPush post map " + linkedHashMap2);
        return C5943a.b(this.f).a(linkedHashMap2).a().a();
    }

    public C5950c<String> a(String str, String str2, String str3, File file) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RemoteMessageConst.MSGID, str);
        linkedHashMap.put("deviceId", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, "4a2ca769d79f4856bb3bd982d30de790"));
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMap2.put("errorMsg", str3);
        }
        DebugLogger.i("PushAPI", "uploadLogFile post map " + linkedHashMap2);
        return C5943a.c("https://api-push.meizu.com/garcia/api/client/log/upload").a(linkedHashMap2).a("logFile", file).a().a();
    }

    public C5950c a(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(IRequestConst.TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return C5943a.b(this.h).a(linkedHashMap2).a().a();
    }

    public C5950c a(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("subSwitch", z ? "1" : "0");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", this.g + " switchPush post map " + linkedHashMap2);
        return C5943a.b(this.g).a(linkedHashMap2).a().a();
    }

    public C5950c b(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put("deviceId", str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "unregister post map " + linkedHashMap2);
        return C5943a.a(this.c).a(linkedHashMap2).a().a();
    }

    public C5950c b(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put(IRequestConst.TAGS, str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return C5943a.b(this.i).a(linkedHashMap2).a().a();
    }

    public C5950c c(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        return C5943a.a(this.e).a(linkedHashMap2).a().a();
    }

    public C5950c c(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put("appKey", str2);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return C5943a.b(this.l).a(linkedHashMap2).a().a();
    }

    public C5950c d(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeAllTags post map " + linkedHashMap2);
        return C5943a.b(this.j).a(linkedHashMap2).a().a();
    }

    public C5950c d(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        linkedHashMap.put("alias", str4);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "subScribeTags post map " + linkedHashMap2);
        return C5943a.b(this.m).a(linkedHashMap2).a().a();
    }

    public C5950c e(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ALBiometricsKeys.KEY_APP_ID, str);
        linkedHashMap.put(PushConstants.KEY_PUSH_ID, str3);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        linkedHashMap2.put("sign", C6092b.a(linkedHashMap, str2));
        DebugLogger.i("PushAPI", "checkPush post map " + linkedHashMap2);
        return C5943a.a(this.k).a(linkedHashMap2).a().a();
    }
}
