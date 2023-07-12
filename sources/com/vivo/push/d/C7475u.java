package com.vivo.push.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7481e;
import com.vivo.push.C7492m;
import com.vivo.push.b.C7428p;
import com.vivo.push.b.C7436x;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7524q;
import com.vivo.push.util.C7533z;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.u */
/* loaded from: classes11.dex */
final class C7475u extends AbstractC7480z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7475u(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
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

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        Intent parseUri;
        String str;
        C7428p c7428p = (C7428p) abstractC7496o;
        InsideNotificationItem f = c7428p.f();
        if (f == null) {
            C7523p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a = C7524q.a(f);
        boolean equals = this.a.getPackageName().equals(c7428p.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.a);
        }
        if (equals) {
            C7436x c7436x = new C7436x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put("messageID", String.valueOf(c7428p.e()));
            hashMap.put("platform", this.a.getPackageName());
            Context context = this.a;
            String b = C7533z.b(context, context.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            c7436x.a(hashMap);
            C7481e.a().a(c7436x);
            C7523p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a.getSkipType() + jn1.ARRAY_END_STR);
            int skipType = a.getSkipType();
            boolean z = true;
            if (skipType == 1) {
                new Thread(new RunnableC7476v(this, this.a, a.getParams())).start();
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
                        C7523p.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    C7523p.a("OnNotificationClickTask", "url not legal");
                }
                a(a);
                return;
            } else if (skipType == 3) {
                a(a);
                return;
            } else if (skipType != 4) {
                C7523p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a.getSkipType());
                return;
            } else {
                String skipContent2 = a.getSkipContent();
                try {
                    parseUri = Intent.parseUri(skipContent2, 1);
                    str = parseUri.getPackage();
                } catch (Exception e) {
                    C7523p.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(skipContent2)), e);
                }
                if (!TextUtils.isEmpty(str) && !this.a.getPackageName().equals(str)) {
                    C7523p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
                if (!TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
                    C7523p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                    return;
                }
                parseUri.setSelector(null);
                parseUri.setPackage(this.a.getPackageName());
                parseUri.addFlags(335544320);
                b(parseUri, a.getParams());
                ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.a.getPackageManager(), 65536);
                if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                    C7523p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
                    return;
                }
                this.a.startActivity(parseUri);
                a(a);
                return;
            }
        }
        C7523p.a("OnNotificationClickTask", "notify is " + a + " ; isMatch is " + equals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        C7492m.c(new RunnableC7477w(this, uPSNotificationMessage));
    }
}
