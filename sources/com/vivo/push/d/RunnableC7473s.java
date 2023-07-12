package com.vivo.push.d;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.b.C7429q;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.AsyncTaskC7518k;
import com.vivo.push.util.C7512e;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7524q;
import com.vivo.push.util.C7525r;
import com.vivo.push.util.C7533z;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.s */
/* loaded from: classes11.dex */
final class RunnableC7473s implements Runnable {
    final /* synthetic */ InsideNotificationItem a;
    final /* synthetic */ C7429q b;
    final /* synthetic */ C7471r c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7473s(C7471r c7471r, InsideNotificationItem insideNotificationItem, C7429q c7429q) {
        this.c = c7471r;
        this.a = insideNotificationItem;
        this.b = c7429q;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        char c;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        C7471r c7471r = this.c;
        PushMessageCallback pushMessageCallback = ((AbstractC7480z) c7471r).b;
        context = ((AbstractRunnableC7491l) c7471r).a;
        if (pushMessageCallback.onNotificationMessageArrived(context, C7524q.a(this.a))) {
            StringBuilder sb = new StringBuilder("pkg name : ");
            context11 = ((AbstractRunnableC7491l) this.c).a;
            sb.append(context11.getPackageName());
            sb.append(" 应用主动拦截通知");
            C7523p.b("OnNotificationArrivedTask", sb.toString());
            context12 = ((AbstractRunnableC7491l) this.c).a;
            C7523p.b(context12, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.b.f()));
            context13 = ((AbstractRunnableC7491l) this.c).a;
            context14 = ((AbstractRunnableC7491l) this.c).a;
            String b = C7533z.b(context13, context14.getPackageName());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("remoteAppId", b);
            }
            C7512e.a(2120L, hashMap);
            return;
        }
        int b2 = this.c.b();
        if (b2 <= 0) {
            context2 = ((AbstractRunnableC7491l) this.c).a;
            InsideNotificationItem insideNotificationItem = this.a;
            long f = this.b.f();
            C7471r c7471r2 = this.c;
            PushMessageCallback pushMessageCallback2 = ((AbstractC7480z) c7471r2).b;
            context3 = ((AbstractRunnableC7491l) c7471r2).a;
            AsyncTaskC7518k asyncTaskC7518k = new AsyncTaskC7518k(context2, insideNotificationItem, f, pushMessageCallback2.isAllowNet(context3), new C7474t(this));
            boolean isShowBigPicOnMobileNet = this.a.isShowBigPicOnMobileNet();
            String purePicUrl = this.a.getPurePicUrl();
            if (TextUtils.isEmpty(purePicUrl)) {
                purePicUrl = this.a.getCoverUrl();
            }
            if (!TextUtils.isEmpty(purePicUrl)) {
                C7523p.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(isShowBigPicOnMobileNet)));
                if (!isShowBigPicOnMobileNet) {
                    context5 = ((AbstractRunnableC7491l) this.c).a;
                    C7523p.a(context5, "mobile net unshow");
                    context6 = ((AbstractRunnableC7491l) this.c).a;
                    NetworkInfo a = C7525r.a(context6);
                    if (a != null && a.getState() == NetworkInfo.State.CONNECTED) {
                        int type = a.getType();
                        c = type == 1 ? (char) 2 : type == 0 ? (char) 1 : (char) 3;
                    } else {
                        c = 0;
                    }
                    if (c == 1) {
                        purePicUrl = null;
                        this.a.clearCoverUrl();
                        this.a.clearPurePicUrl();
                    }
                } else {
                    context4 = ((AbstractRunnableC7491l) this.c).a;
                    C7523p.a(context4, "mobile net show");
                }
            }
            asyncTaskC7518k.execute(this.a.getIconUrl(), purePicUrl);
            return;
        }
        StringBuilder sb2 = new StringBuilder("pkg name : ");
        context7 = ((AbstractRunnableC7491l) this.c).a;
        sb2.append(context7.getPackageName());
        sb2.append(" notify channel switch is ");
        sb2.append(b2);
        C7523p.b("OnNotificationArrivedTask", sb2.toString());
        context8 = ((AbstractRunnableC7491l) this.c).a;
        C7523p.b(context8, "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(b2)));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("messageID", String.valueOf(this.b.f()));
        context9 = ((AbstractRunnableC7491l) this.c).a;
        context10 = ((AbstractRunnableC7491l) this.c).a;
        String b3 = C7533z.b(context9, context10.getPackageName());
        if (!TextUtils.isEmpty(b3)) {
            hashMap2.put("remoteAppId", b3);
        }
        C7512e.a(b2, hashMap2);
    }
}
