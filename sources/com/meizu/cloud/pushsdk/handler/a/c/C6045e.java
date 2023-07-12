package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import org.json.JSONException;
import org.json.JSONObject;
import tb.C9556pm;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.c.e */
/* loaded from: classes10.dex */
public class C6045e {
    private int a;
    private String b = String.valueOf(-1);
    private String c = "";
    private String d = "";
    private int e = -1;
    private String f = "";

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.handler.a.c.e$a */
    /* loaded from: classes10.dex */
    public static class C6046a {
        public String a;
        public String b;
        String c;

        public C6046a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("code")) {
                    a(jSONObject.getString("code"));
                }
                if (!jSONObject.isNull("message")) {
                    b(jSONObject.getString("message"));
                }
                if (jSONObject.isNull("value")) {
                    return;
                }
                c(jSONObject.getString("value"));
            } catch (JSONException e) {
                DebugLogger.e("SecurityMessage", "covert json error " + e.getMessage());
            }
        }

        public String a() {
            return this.c;
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public String toString() {
            return "PublicKeyStatus{code='" + this.a + "', message='" + this.b + "', publicKey='" + this.c + "'}";
        }
    }

    public static String a(MessageV3 messageV3) {
        JSONObject jSONObject;
        String notificationMessage = messageV3.getNotificationMessage();
        String str = null;
        try {
            try {
                if (!TextUtils.isEmpty(notificationMessage)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(notificationMessage).getJSONObject("data");
                        if (!jSONObject2.isNull("extra")) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject("extra");
                            if (!jSONObject3.isNull("se")) {
                                str = jSONObject3.getString("se");
                            }
                        }
                    } catch (JSONException e) {
                        DebugLogger.e("SecurityMessage", "parse notification message error " + e.getMessage());
                        if (TextUtils.isEmpty(null)) {
                            jSONObject = new JSONObject(notificationMessage);
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(notificationMessage);
                        jSONObject.getString("se");
                    }
                }
            } catch (Exception unused) {
            }
            DebugLogger.i("SecurityMessage", "encrypt message " + str);
            return str;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(null)) {
                try {
                    new JSONObject(notificationMessage).getString("se");
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean a(String str, MessageV3 messageV3) {
        String str2;
        C6045e e = e(str);
        DebugLogger.e("SecurityMessage", "securityMessage " + e);
        if (System.currentTimeMillis() / 1000 > e.a()) {
            str2 = "message expire";
        } else if (!messageV3.getTitle().contains(e.c())) {
            str2 = "invalid title";
        } else if (!messageV3.getContent().contains(e.d())) {
            str2 = "invalid content";
        } else if (!String.valueOf(-1).equals(e.b()) && !e.b().equals(messageV3.getTaskId())) {
            str2 = "invalid taskId";
        } else if (e.e() != -1) {
            int e2 = e.e();
            if (e2 == 1) {
                if (!messageV3.getActivity().contains(e.f())) {
                    str2 = "invalid click activity";
                }
                return true;
            } else if (e2 == 2) {
                if (!messageV3.getWebUrl().contains(e.f())) {
                    str2 = "invalid web url";
                }
                return true;
            } else {
                if (e2 == 3 && !MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString().contains(e.f())) {
                    str2 = "invalid self define";
                }
                return true;
            }
        } else {
            str2 = "invalid click type";
        }
        DebugLogger.e("SecurityMessage", str2);
        return false;
    }

    private static C6045e e(String str) {
        C6045e c6045e = new C6045e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                c6045e.a(jSONObject.getInt(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP));
            }
            if (!jSONObject.isNull(IRequestConst.TI)) {
                c6045e.a(jSONObject.getString(IRequestConst.TI));
            }
            if (!jSONObject.isNull("tl")) {
                c6045e.b(jSONObject.getString("tl"));
            }
            if (!jSONObject.isNull("cont")) {
                c6045e.c(jSONObject.getString("cont"));
            }
            if (!jSONObject.isNull(IRequestConst.CT)) {
                c6045e.b(jSONObject.getInt(IRequestConst.CT));
            }
            if (!jSONObject.isNull(C9556pm.TAG)) {
                c6045e.d(jSONObject.getString(C9556pm.TAG));
            }
        } catch (Exception e) {
            DebugLogger.e("SecurityMessage", "parse decryptSign error " + e.getMessage());
        }
        return c6045e;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.f = str;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        return "SecurityMessage{timestamp=" + this.a + ", taskId='" + this.b + "', title='" + this.c + "', content='" + this.d + "', clickType=" + this.e + ", params='" + this.f + "'}";
    }
}
