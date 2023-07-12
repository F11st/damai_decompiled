package cn.damai.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.user.c;
import cn.damai.push.model.PushMessageBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.e80;
import tb.lv2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PushSwitcher {
    private static transient /* synthetic */ IpChange $ipChange;
    private static int e;
    private Context a;
    public String b = null;
    public String c = null;
    public PushChannel d;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum PushChannel {
        AGOO,
        XIAOMI,
        TSYNC,
        HUAWEI,
        MEIZHU,
        WANGXIN,
        MPASS,
        CMNS
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        Context a;
        private String b = null;
        private String c = null;
        private PushChannel d = PushChannel.AGOO;

        public a(Context context) {
            this.a = context;
        }

        public PushSwitcher a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "165106274")) {
                return (PushSwitcher) ipChange.ipc$dispatch("165106274", new Object[]{this});
            }
            PushSwitcher pushSwitcher = new PushSwitcher(this.a);
            pushSwitcher.c = this.c;
            pushSwitcher.b = this.b;
            pushSwitcher.d = this.d;
            return pushSwitcher;
        }

        public a b(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2119137043")) {
                return (a) ipChange.ipc$dispatch("-2119137043", new Object[]{this, str});
            }
            this.c = str;
            return this;
        }

        public a c(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2125433752")) {
                return (a) ipChange.ipc$dispatch("-2125433752", new Object[]{this, str});
            }
            this.b = str;
            return this;
        }

        public a d(PushChannel pushChannel) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2078624522")) {
                return (a) ipChange.ipc$dispatch("2078624522", new Object[]{this, pushChannel});
            }
            this.d = pushChannel;
            return this;
        }
    }

    public PushSwitcher(Context context) {
        this.a = context;
    }

    private String a(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007891801")) {
            return (String) ipChange.ipc$dispatch("1007891801", new Object[]{this, jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        if (!TextUtils.isEmpty(this.b)) {
            jSONObject.put("id", (Object) this.b);
        }
        jSONObject.put("channel", (Object) this.d.name());
        jSONObject.put("brand", (Object) Build.getBRAND());
        jSONObject.put("model", (Object) e80.b());
        jSONObject.put("android", (Object) e80.e());
        jSONObject.put("version", (Object) AppConfig.q());
        return jSONObject.toJSONString();
    }

    private void b(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943300923")) {
            ipChange.ipc$dispatch("-943300923", new Object[]{this, jSONObject});
        } else if (jSONObject == null) {
        } else {
            HashMap hashMap = new HashMap(lv2.a(jSONObject));
            if (!TextUtils.isEmpty(this.b)) {
                hashMap.put("id", this.b);
            }
            c.e().A(hashMap, "agoo_damai_info", "push");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.push.PushSwitcher.$ipChange
            java.lang.String r1 = "-661167503"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            if (r2 == 0) goto L1a
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r4 = 0
            r2[r4] = r7
            r2[r3] = r8
            r8 = 2
            r2[r8] = r9
            r0.ipc$dispatch(r1, r2)
            return
        L1a:
            com.alibaba.pictures.accs.AgooMessage r0 = new com.alibaba.pictures.accs.AgooMessage
            r0.<init>()
            r1 = 0
            tb.yh0 r2 = tb.yh0.INSTANCE     // Catch: java.lang.Exception -> L43
            java.lang.Class<cn.damai.push.model.PushMessageBean> r4 = cn.damai.push.model.PushMessageBean.class
            java.lang.Object r2 = r2.c(r9, r4)     // Catch: java.lang.Exception -> L43
            cn.damai.push.model.PushMessageBean r2 = (cn.damai.push.model.PushMessageBean) r2     // Catch: java.lang.Exception -> L43
            java.lang.String r1 = "PushSwitcher"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L41
            r4.<init>()     // Catch: java.lang.Exception -> L41
            java.lang.String r5 = "agoo onMessage ,msg= "
            r4.append(r5)     // Catch: java.lang.Exception -> L41
            r4.append(r2)     // Catch: java.lang.Exception -> L41
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L41
            tb.cb1.b(r1, r4)     // Catch: java.lang.Exception -> L41
            goto L50
        L41:
            r1 = move-exception
            goto L47
        L43:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L47:
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = "StackTrace"
            tb.cb1.c(r4, r1)
        L50:
            if (r2 != 0) goto L53
            return
        L53:
            java.util.Random r1 = new java.util.Random
            r1.<init>()
            int r1 = r1.nextInt()
            cn.damai.push.PushSwitcher.e = r1
            java.lang.String r1 = r7.b
            r0.setMsgId(r1)
            java.lang.String r1 = r7.c
            r0.setMsgId(r1)
            java.lang.String r1 = r2.title
            r0.setTitle(r1)
            java.lang.String r1 = r2.text
            r0.setText(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.setSound(r1)
            cn.damai.push.model.PushMessageBean$Exts r1 = r2.exts
            java.lang.String r1 = r1.tag
            r0.setTag(r1)
            cn.damai.push.model.PushMessageBean$Exts r1 = r2.exts
            java.lang.String r1 = r1.url
            r0.setUrl(r1)
            r0.setMsgBody(r9)
            int r9 = cn.damai.push.PushSwitcher.e
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r0.setNotifyId(r9)
            int r9 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r9 < r1) goto Lab
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.setNotifyImportance(r1)
            java.lang.String r1 = "default_channel"
            r0.setNotifyChannelId(r1)
            java.lang.String r1 = "大麦应用通知"
            r0.setNotifyChannelName(r1)
        Lab:
            cn.damai.push.model.PushMessageBean$Exts r1 = r2.exts
            r0.setExtObj(r1)
            tb.e4.e(r8, r0)
            r0 = 16
            if (r9 < r0) goto Lba
            r7.e(r8, r2)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.push.PushSwitcher.c(android.content.Context, java.lang.String):void");
    }

    private void e(Context context, PushMessageBean pushMessageBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1957390557")) {
            ipChange.ipc$dispatch("-1957390557", new Object[]{this, context, pushMessageBean});
            return;
        }
        Intent intent = new Intent();
        intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
        intent.setPackage("cn.damai");
        intent.putExtra("msb", pushMessageBean);
        intent.putExtra("type", 7);
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965469615")) {
            ipChange.ipc$dispatch("-965469615", new Object[]{this});
        } else if (TextUtils.isEmpty(this.c)) {
        } else {
            Log.e("PushSwitcher", "process 中 " + this.c);
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            try {
                JSONObject parseObject = JSON.parseObject(this.c);
                if (parseObject.containsKey("channel") && "agoo".equals(parseObject.getString("channel"))) {
                    this.d = PushChannel.AGOO;
                }
                a(parseObject);
                b(parseObject);
            } catch (Exception e2) {
                Log.e("PushSwitcher", "catch 中 " + e2);
                Log.w("StackTrace", e2);
            }
            c(this.a, this.c);
        }
    }
}
