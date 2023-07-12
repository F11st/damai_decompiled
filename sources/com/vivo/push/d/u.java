package com.vivo.push.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class u extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.vivo.push.o oVar) {
        super(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        Intent parseUri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) oVar;
        InsideNotificationItem f = pVar.f();
        if (f == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a = com.vivo.push.util.q.a(f);
        boolean equals = this.a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.a);
        }
        if (equals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(pVar.e()));
            hashMap.put("platform", this.a.getPackageName());
            Context context = this.a;
            String b = com.vivo.push.util.z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            xVar.a(hashMap);
            com.vivo.push.e.a().a(xVar);
            com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a.getSkipType() + jn1.ARRAY_END_STR);
            int skipType = a.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new v(this, this.a, a.getParams())).start();
                a(a);
                return;
            } else if (skipType == 2) {
                String skipContent = a.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    z = false;
                }
                if (z) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    intent.setFlags(268435456);
                    b(intent, a.getParams());
                    try {
                        this.a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.p.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "url not legal");
                }
                a(a);
                return;
            } else if (skipType == 3) {
                a(a);
                return;
            } else if (skipType != 4) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a.getSkipType());
                return;
            } else {
                String skipContent2 = a.getSkipContent();
                try {
                    parseUri = Intent.parseUri(skipContent2, 1);
                    str = parseUri.getPackage();
                } catch (Exception e) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(skipContent2)), e);
                }
                if (!TextUtils.isEmpty(str) && !this.a.getPackageName().equals(str)) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                if (!TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                parseUri.setSelector(null);
                parseUri.setPackage(this.a.getPackageName());
                parseUri.addFlags(335544320);
                b(parseUri, a.getParams());
                ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.a.getPackageManager(), 65536);
                if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                    com.vivo.push.util.p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
                    return;
                }
                this.a.startActivity(parseUri);
                a(a);
                return;
            }
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a + " ; isMatch is " + equals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.m.c(new w(this, uPSNotificationMessage));
    }
}
