package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C7594ab;
import com.xiaomi.push.C7672hn;
import com.xiaomi.push.C7786v;
import com.xiaomi.push.hm;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.youku.alixplayer.MsgID;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bz {
    private static String a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f953a;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f954a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f953a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    private static ii a(String str, String str2, hm hmVar) {
        return new ii("-1", false).d(str).b(str2).a(C7594ab.a(it.a(hmVar))).c(ht.UploadTinyData.f497a);
    }

    public static synchronized String a() {
        String str;
        synchronized (bz.class) {
            String format = f953a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(a, format)) {
                f954a.set(0L);
                a = format;
            }
            str = format + "-" + f954a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.xiaomi.push.ii> a(java.util.List<com.xiaomi.push.C7672hn> r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r0 = 0
            if (r11 != 0) goto L9
            java.lang.String r11 = "requests can not be null in TinyDataHelper.transToThriftObj()."
        L5:
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.d(r11)
            return r0
        L9:
            int r1 = r11.size()
            if (r1 != 0) goto L12
            java.lang.String r11 = "requests.length is 0 in TinyDataHelper.transToThriftObj()."
            goto L5
        L12:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.xiaomi.push.hm r2 = new com.xiaomi.push.hm
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 0
        L1f:
            int r6 = r11.size()
            if (r4 >= r6) goto Laa
            java.lang.Object r6 = r11.get(r4)
            com.xiaomi.push.hn r6 = (com.xiaomi.push.C7672hn) r6
            if (r6 != 0) goto L2f
            goto La6
        L2f:
            java.util.Map r7 = r6.m957a()
            if (r7 == 0) goto L6e
            java.util.Map r7 = r6.m957a()
            java.lang.String r8 = "item_size"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L6e
            java.util.Map r7 = r6.m957a()
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            boolean r9 = android.text.TextUtils.isEmpty(r7)
            if (r9 != 0) goto L56
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L56
            goto L57
        L56:
            r7 = 0
        L57:
            java.util.Map r9 = r6.m957a()
            int r9 = r9.size()
            r10 = 1
            if (r9 != r10) goto L66
            r6.a(r0)
            goto L6f
        L66:
            java.util.Map r9 = r6.m957a()
            r9.remove(r8)
            goto L6f
        L6e:
            r7 = 0
        L6f:
            if (r7 > 0) goto L76
            byte[] r7 = com.xiaomi.push.it.a(r6)
            int r7 = r7.length
        L76:
            if (r7 <= r14) goto L91
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TinyData is too big, ignore upload request item:"
            r7.append(r8)
            java.lang.String r6 = r6.d()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.d(r6)
            goto La6
        L91:
            int r8 = r5 + r7
            if (r8 <= r14) goto La2
            com.xiaomi.push.ii r2 = a(r12, r13, r2)
            r1.add(r2)
            com.xiaomi.push.hm r2 = new com.xiaomi.push.hm
            r2.<init>()
            r5 = 0
        La2:
            r2.a(r6)
            int r5 = r5 + r7
        La6:
            int r4 = r4 + 1
            goto L1f
        Laa:
            int r11 = r2.a()
            if (r11 == 0) goto Lb7
            com.xiaomi.push.ii r11 = a(r12, r13, r2)
            r1.add(r11)
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bz.a(java.util.List, java.lang.String, java.lang.String, int):java.util.ArrayList");
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        C7672hn c7672hn = new C7672hn();
        c7672hn.d(str);
        c7672hn.c(str2);
        c7672hn.a(j);
        c7672hn.b(str3);
        c7672hn.a("push_sdk_channel");
        c7672hn.g(context.getPackageName());
        c7672hn.e(context.getPackageName());
        c7672hn.a(true);
        c7672hn.b(System.currentTimeMillis());
        c7672hn.f(a());
        ca.a(context, c7672hn);
    }

    public static void a(String str, String str2, String str3, ao aoVar) {
        if (aoVar == null) {
            return;
        }
        C7672hn c7672hn = new C7672hn();
        c7672hn.d(str);
        c7672hn.c(str2);
        c7672hn.g(str3);
        c7672hn.e(str3);
        HashMap hashMap = new HashMap();
        hashMap.put("chid", String.valueOf(aoVar.a));
        hashMap.put("screen_on", String.valueOf(aoVar.f893a));
        hashMap.put("wifi", String.valueOf(aoVar.f895b));
        hashMap.put("rx_msg", String.valueOf(aoVar.f892a));
        hashMap.put("enqueue", String.valueOf(aoVar.f894b));
        hashMap.put(GiftNumBean.KEY_NUM, String.valueOf(aoVar.b));
        hashMap.put("run", String.valueOf(aoVar.c));
        hashMap.put("send", String.valueOf(System.currentTimeMillis()));
        c7672hn.a(hashMap);
        ca.a(c7672hn);
    }

    public static boolean a(C7672hn c7672hn, boolean z) {
        String str;
        if (c7672hn == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(c7672hn.f469a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(c7672hn.f476d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(c7672hn.f475c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!com.xiaomi.push.bp.m703a(c7672hn.f476d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (com.xiaomi.push.bp.m703a(c7672hn.f475c)) {
            String str2 = c7672hn.f474b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + c7672hn.f474b.length() + "), max size for data is " + MsgID.MEDIA_INFO_VIDEO_START_RECOVER + " , verfiy ClientUploadDataItem failed.";
        } else {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        }
        AbstractC7535b.m586a(str);
        return true;
    }

    public static boolean a(String str) {
        return !C7786v.m1249b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
