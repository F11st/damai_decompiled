package com.xiaomi.mipush.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.C7627db;
import com.xiaomi.push.C7673hv;
import com.xiaomi.push.C7675im;
import com.xiaomi.push.C7677io;
import com.xiaomi.push.C7784t;
import com.xiaomi.push.C7787w;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bp;
import com.xiaomi.push.bx;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ey;
import com.xiaomi.push.hj;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.C7756i;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class am {
    private static am a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f43a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f44a;

    /* renamed from: a  reason: collision with other field name */
    private Context f45a;

    private am(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f45a = applicationContext;
        if (applicationContext == null) {
            this.f45a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return com.xiaomi.push.service.al.b(context, str, map, i);
    }

    private PushMessageHandler.InterfaceC7557a a(Cif cif, boolean z, byte[] bArr, String str, int i, Intent intent) {
        eo a2;
        String packageName;
        String m858a;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        eo a3;
        String packageName2;
        String m858a2;
        int i2;
        String str5;
        ArrayList arrayList = null;
        try {
            iu a4 = ai.a(this.f45a, cif);
            if (a4 == null) {
                AbstractC7535b.d("receiving an un-recognized message. " + cif.f617a);
                eo.a(this.f45a).b(this.f45a.getPackageName(), en.m858a(i), str, "18");
                C7583s.c(this.f45a, cif, z);
                return null;
            }
            hj a5 = cif.a();
            AbstractC7535b.m586a("processing a message, action=" + a5);
            switch (an.a[a5.ordinal()]) {
                case 1:
                    if (!cif.m1030b()) {
                        AbstractC7535b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (C7564b.m629a(this.f45a).m640e() && !z) {
                        AbstractC7535b.m586a("receive a message in pause state. drop it");
                        eo.a(this.f45a).a(this.f45a.getPackageName(), en.m858a(i), str, "12");
                        return null;
                    } else {
                        C7675im c7675im = (C7675im) a4;
                        C7673hv a6 = c7675im.a();
                        if (a6 == null) {
                            AbstractC7535b.d("receive an empty message without push content, drop it");
                            eo.a(this.f45a).b(this.f45a.getPackageName(), en.m858a(i), str, "22");
                            C7583s.d(this.f45a, cif, z);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z) {
                            if (com.xiaomi.push.service.al.m1167a(cif)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f45a, a6.m980a(), cif.m1022a(), cif.f624b, a6.b());
                            } else {
                                hw hwVar = cif.m1022a() != null ? new hw(cif.m1022a()) : new hw();
                                if (hwVar.m989a() == null) {
                                    hwVar.a(new HashMap());
                                }
                                hwVar.m989a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f45a, a6.m980a(), hwVar, a6.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(c7675im.d()) && MiPushClient.aliasSetTime(this.f45a, c7675im.d()) < 0) {
                                MiPushClient.addAlias(this.f45a, c7675im.d());
                            } else if (!TextUtils.isEmpty(c7675im.c()) && MiPushClient.topicSubscribedTime(this.f45a, c7675im.c()) < 0) {
                                MiPushClient.addTopic(this.f45a, c7675im.c());
                            }
                        }
                        hw hwVar2 = cif.f618a;
                        if (hwVar2 == null || hwVar2.m989a() == null) {
                            str3 = null;
                            str4 = null;
                        } else {
                            str3 = cif.f618a.f532a.get("jobkey");
                            str4 = str3;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = a6.m980a();
                        }
                        if (z || !m609a(this.f45a, str3)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(c7675im, cif.m1022a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.al.m1168a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.al.m1163a(this.f45a, cif, bArr);
                                return null;
                            }
                            AbstractC7535b.m586a("receive a message, msgid=" + a6.m980a() + ", jobkey=" + str3 + ", btn=" + intExtra);
                            String a7 = com.xiaomi.push.service.al.a(generateMessage.getExtra(), intExtra);
                            if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a7)) {
                                Map<String, String> extra = generateMessage.getExtra();
                                if (intExtra != 0 && cif.m1022a() != null) {
                                    ao.a(this.f45a).a(cif.m1022a().c(), intExtra);
                                }
                                if (com.xiaomi.push.service.al.m1167a(cif)) {
                                    Intent a8 = a(this.f45a, cif.f624b, extra, intExtra);
                                    a8.putExtra("eventMessageType", i);
                                    a8.putExtra("messageId", str);
                                    a8.putExtra("jobkey", str4);
                                    String c = a6.c();
                                    if (!TextUtils.isEmpty(c)) {
                                        a8.putExtra("payload", c);
                                    }
                                    this.f45a.startActivity(a8);
                                    C7583s.a(this.f45a, cif);
                                    eo.a(this.f45a).a(this.f45a.getPackageName(), en.m858a(i), str, 3006, a7);
                                    return null;
                                }
                                Context context = this.f45a;
                                Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                if (a9 != null) {
                                    if (!a7.equals(bk.c)) {
                                        a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a9.putExtra("eventMessageType", i);
                                        a9.putExtra("messageId", str);
                                        a9.putExtra("jobkey", str4);
                                    }
                                    this.f45a.startActivity(a9);
                                    C7583s.a(this.f45a, cif);
                                    AbstractC7535b.m586a("start activity succ");
                                    eo.a(this.f45a).a(this.f45a.getPackageName(), en.m858a(i), str, 1006, a7);
                                    if (a7.equals(bk.c)) {
                                        eo.a(this.f45a).a(this.f45a.getPackageName(), en.m858a(i), str, "13");
                                        return null;
                                    }
                                    return null;
                                }
                                return null;
                            }
                            miPushMessage = generateMessage;
                        } else {
                            AbstractC7535b.m586a("drop a duplicate message, key=" + str3);
                            eo a10 = eo.a(this.f45a);
                            String packageName3 = this.f45a.getPackageName();
                            String m858a3 = en.m858a(i);
                            a10.c(packageName3, m858a3, str, "2:" + str3);
                            miPushMessage = null;
                        }
                        if (cif.m1022a() == null && !z) {
                            a(c7675im, cif);
                        }
                        return miPushMessage;
                    }
                case 2:
                    ik ikVar = (ik) a4;
                    String str6 = C7564b.m629a(this.f45a).f62a;
                    if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, ikVar.m1051a())) {
                        AbstractC7535b.m586a("bad Registration result:");
                        eo.a(this.f45a).b(this.f45a.getPackageName(), en.m858a(i), str, "21");
                        return null;
                    }
                    long m619a = ao.a(this.f45a).m619a();
                    if (m619a > 0 && SystemClock.elapsedRealtime() - m619a > 900000) {
                        AbstractC7535b.m586a("The received registration result has expired.");
                        eo.a(this.f45a).b(this.f45a.getPackageName(), en.m858a(i), str, "26");
                        return null;
                    }
                    C7564b.m629a(this.f45a).f62a = null;
                    int i3 = (ikVar.f680a > 0L ? 1 : (ikVar.f680a == 0L ? 0 : -1));
                    Context context2 = this.f45a;
                    if (i3 == 0) {
                        C7564b.m629a(context2).b(ikVar.f692e, ikVar.f693f, ikVar.f699l);
                        FCMPushHelper.persistIfXmsfSupDecrypt(this.f45a);
                        a3 = eo.a(this.f45a);
                        packageName2 = this.f45a.getPackageName();
                        m858a2 = en.m858a(i);
                        i2 = 6006;
                        str5 = "1";
                    } else {
                        a3 = eo.a(context2);
                        packageName2 = this.f45a.getPackageName();
                        m858a2 = en.m858a(i);
                        i2 = 6006;
                        str5 = "2";
                    }
                    a3.a(packageName2, m858a2, str, i2, str5);
                    if (!TextUtils.isEmpty(ikVar.f692e)) {
                        arrayList = new ArrayList();
                        arrayList.add(ikVar.f692e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.COMMAND_REGISTER.f325a, arrayList, ikVar.f680a, ikVar.f691d, null, ikVar.m1052a());
                    ao.a(this.f45a).m627d();
                    return generateCommandMessage;
                case 3:
                    if (!cif.m1030b()) {
                        AbstractC7535b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((iq) a4).f758a == 0) {
                        C7564b.m629a(this.f45a).m631a();
                        MiPushClient.clearExtras(this.f45a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    C7677io c7677io = (C7677io) a4;
                    if (c7677io.f733a == 0) {
                        MiPushClient.addTopic(this.f45a, c7677io.b());
                    }
                    if (!TextUtils.isEmpty(c7677io.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(c7677io.b());
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("resp-cmd:");
                    ey eyVar = ey.COMMAND_SUBSCRIBE_TOPIC;
                    sb.append(eyVar);
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                    sb.append(c7677io.a());
                    AbstractC7535b.e(sb.toString());
                    return PushMessageHelper.generateCommandMessage(eyVar.f325a, arrayList, c7677io.f733a, c7677io.f739d, c7677io.c(), null);
                case 5:
                    is isVar = (is) a4;
                    if (isVar.f778a == 0) {
                        MiPushClient.removeTopic(this.f45a, isVar.b());
                    }
                    if (!TextUtils.isEmpty(isVar.b())) {
                        arrayList = new ArrayList();
                        arrayList.add(isVar.b());
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("resp-cmd:");
                    ey eyVar2 = ey.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb2.append(eyVar2);
                    sb2.append(AVFSCacheConstants.COMMA_SEP);
                    sb2.append(isVar.a());
                    AbstractC7535b.e(sb2.toString());
                    return PushMessageHelper.generateCommandMessage(eyVar2.f325a, arrayList, isVar.f778a, isVar.f784d, isVar.c(), null);
                case 6:
                    C7627db.a(this.f45a.getPackageName(), this.f45a, a4, hj.Command, bArr.length);
                    ie ieVar = (ie) a4;
                    String b = ieVar.b();
                    List<String> m1016a = ieVar.m1016a();
                    if (ieVar.f605a == 0) {
                        if (TextUtils.equals(b, ey.COMMAND_SET_ACCEPT_TIME.f325a) && m1016a != null && m1016a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f45a, m1016a.get(0), m1016a.get(1));
                            if ("00:00".equals(m1016a.get(0)) && "00:00".equals(m1016a.get(1))) {
                                C7564b.m629a(this.f45a).a(true);
                            } else {
                                C7564b.m629a(this.f45a).a(false);
                            }
                            m1016a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m1016a);
                        } else if (TextUtils.equals(b, ey.COMMAND_SET_ALIAS.f325a) && m1016a != null && m1016a.size() > 0) {
                            MiPushClient.addAlias(this.f45a, m1016a.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_UNSET_ALIAS.f325a) && m1016a != null && m1016a.size() > 0) {
                            MiPushClient.removeAlias(this.f45a, m1016a.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_SET_ACCOUNT.f325a) && m1016a != null && m1016a.size() > 0) {
                            MiPushClient.addAccount(this.f45a, m1016a.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_UNSET_ACCOUNT.f325a) && m1016a != null && m1016a.size() > 0) {
                            MiPushClient.removeAccount(this.f45a, m1016a.get(0));
                        } else if (TextUtils.equals(b, ey.COMMAND_CHK_VDEVID.f325a)) {
                            return null;
                        }
                    }
                    List<String> list = m1016a;
                    AbstractC7535b.e("resp-cmd:" + b + AVFSCacheConstants.COMMA_SEP + ieVar.a());
                    return PushMessageHelper.generateCommandMessage(b, list, ieVar.f605a, ieVar.f613d, ieVar.c(), null);
                case 7:
                    C7627db.a(this.f45a.getPackageName(), this.f45a, a4, hj.Notification, bArr.length);
                    if (a4 instanceof ia) {
                        ia iaVar = (ia) a4;
                        String a11 = iaVar.a();
                        AbstractC7535b.e("resp-type:" + iaVar.b() + ", code:" + iaVar.f575a + AVFSCacheConstants.COMMA_SEP + a11);
                        if (ht.DisablePushMessage.f497a.equalsIgnoreCase(iaVar.f582d)) {
                            if (iaVar.f575a == 0) {
                                synchronized (af.class) {
                                    if (af.a(this.f45a).m608a(a11)) {
                                        af.a(this.f45a).c(a11);
                                        af a12 = af.a(this.f45a);
                                        au auVar = au.DISABLE_PUSH;
                                        if ("syncing".equals(a12.a(auVar))) {
                                            af.a(this.f45a).a(auVar, "synced");
                                            MiPushClient.clearNotification(this.f45a);
                                            MiPushClient.clearLocalNotificationType(this.f45a);
                                            PushMessageHandler.a();
                                            ao.a(this.f45a).m624b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(af.a(this.f45a).a(au.DISABLE_PUSH))) {
                                synchronized (af.class) {
                                    if (af.a(this.f45a).m608a(a11)) {
                                        if (af.a(this.f45a).a(a11) < 10) {
                                            af.a(this.f45a).b(a11);
                                            ao.a(this.f45a).a(true, a11);
                                        } else {
                                            af.a(this.f45a).c(a11);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (ht.EnablePushMessage.f497a.equalsIgnoreCase(iaVar.f582d)) {
                            if (iaVar.f575a == 0) {
                                synchronized (af.class) {
                                    if (af.a(this.f45a).m608a(a11)) {
                                        af.a(this.f45a).c(a11);
                                        af a13 = af.a(this.f45a);
                                        au auVar2 = au.ENABLE_PUSH;
                                        if ("syncing".equals(a13.a(auVar2))) {
                                            af.a(this.f45a).a(auVar2, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(af.a(this.f45a).a(au.ENABLE_PUSH))) {
                                synchronized (af.class) {
                                    if (af.a(this.f45a).m608a(a11)) {
                                        if (af.a(this.f45a).a(a11) < 10) {
                                            af.a(this.f45a).b(a11);
                                            ao.a(this.f45a).a(false, a11);
                                        } else {
                                            af.a(this.f45a).c(a11);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (ht.ThirdPartyRegUpdate.f497a.equalsIgnoreCase(iaVar.f582d)) {
                            b(iaVar);
                            break;
                        } else if (ht.UploadTinyData.f497a.equalsIgnoreCase(iaVar.f582d)) {
                            a(iaVar);
                            break;
                        }
                        af.a(this.f45a).c(a11);
                        break;
                    } else if (a4 instanceof ii) {
                        ii iiVar = (ii) a4;
                        if ("registration id expired".equalsIgnoreCase(iiVar.f641d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f45a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f45a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f45a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f45a);
                            AbstractC7535b.e("resp-type:" + iiVar.f641d + AVFSCacheConstants.COMMA_SEP + iiVar.m1037a());
                            MiPushClient.reInitialize(this.f45a, hx.RegIdExpired);
                            for (String str7 : allAlias) {
                                MiPushClient.removeAlias(this.f45a, str7);
                                MiPushClient.setAlias(this.f45a, str7, null);
                            }
                            for (String str8 : allTopic) {
                                MiPushClient.removeTopic(this.f45a, str8);
                                MiPushClient.subscribe(this.f45a, str8, null);
                            }
                            for (String str9 : allUserAccount) {
                                MiPushClient.removeAccount(this.f45a, str9);
                                MiPushClient.setUserAccount(this.f45a, str9, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f45a);
                                MiPushClient.addAcceptTime(this.f45a, split[0], split[1]);
                                break;
                            }
                        } else if (ht.ClientInfoUpdateOk.f497a.equalsIgnoreCase(iiVar.f641d)) {
                            if (iiVar.m1038a() != null && iiVar.m1038a().containsKey("app_version")) {
                                C7564b.m629a(this.f45a).m632a(iiVar.m1038a().get("app_version"));
                                break;
                            }
                        } else if (ht.AwakeApp.f497a.equalsIgnoreCase(iiVar.f641d)) {
                            if (cif.m1030b() && iiVar.m1038a() != null && iiVar.m1038a().containsKey("awake_info")) {
                                Context context3 = this.f45a;
                                C7579o.a(context3, C7564b.m629a(context3).m630a(), ba.a(this.f45a).a(ho.AwakeInfoUploadWaySwitch.a(), 0), iiVar.m1038a().get("awake_info"));
                                break;
                            }
                        } else {
                            try {
                                if (ht.NormalClientConfigUpdate.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                    ih ihVar = new ih();
                                    it.a(ihVar, iiVar.m1043a());
                                    bb.a(ba.a(this.f45a), ihVar);
                                } else if (ht.CustomClientConfigUpdate.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                    ig igVar = new ig();
                                    it.a(igVar, iiVar.m1043a());
                                    bb.a(ba.a(this.f45a), igVar);
                                } else if (ht.SyncInfoResult.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                    av.a(this.f45a, iiVar);
                                    break;
                                } else if (ht.ForceSync.f497a.equalsIgnoreCase(iiVar.f641d)) {
                                    AbstractC7535b.m586a("receive force sync notification");
                                    av.a(this.f45a, false);
                                    break;
                                } else if (ht.CancelPushMessage.f497a.equals(iiVar.f641d)) {
                                    AbstractC7535b.e("resp-type:" + iiVar.f641d + AVFSCacheConstants.COMMA_SEP + iiVar.m1037a());
                                    if (iiVar.m1038a() != null) {
                                        int i4 = -2;
                                        if (iiVar.m1038a().containsKey(bk.M)) {
                                            String str10 = iiVar.m1038a().get(bk.M);
                                            if (!TextUtils.isEmpty(str10)) {
                                                try {
                                                    i4 = Integer.parseInt(str10);
                                                } catch (NumberFormatException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i4 >= -1) {
                                            MiPushClient.clearNotification(this.f45a, i4);
                                        } else {
                                            MiPushClient.clearNotification(this.f45a, iiVar.m1038a().containsKey(bk.K) ? iiVar.m1038a().get(bk.K) : "", iiVar.m1038a().containsKey(bk.L) ? iiVar.m1038a().get(bk.L) : "");
                                        }
                                    }
                                    a(iiVar);
                                    break;
                                } else {
                                    try {
                                        if (ht.HybridRegisterResult.f497a.equals(iiVar.f641d)) {
                                            ik ikVar2 = new ik();
                                            it.a(ikVar2, iiVar.m1043a());
                                            MiPushClient4Hybrid.onReceiveRegisterResult(this.f45a, ikVar2);
                                        } else if (ht.HybridUnregisterResult.f497a.equals(iiVar.f641d)) {
                                            iq iqVar = new iq();
                                            it.a(iqVar, iiVar.m1043a());
                                            MiPushClient4Hybrid.onReceiveUnregisterResult(this.f45a, iqVar);
                                        } else if (!ht.PushLogUpload.f497a.equals(iiVar.f641d)) {
                                            if (ht.DetectAppAlive.f497a.equals(iiVar.f641d)) {
                                                AbstractC7535b.b("receive detect msg");
                                                b(iiVar);
                                                break;
                                            } else if (C7756i.a(iiVar)) {
                                                AbstractC7535b.b("receive notification handle by cpra");
                                                break;
                                            }
                                        }
                                        break;
                                    } catch (iz e2) {
                                        AbstractC7535b.a(e2);
                                        break;
                                    }
                                }
                                break;
                            } catch (iz unused) {
                                break;
                            }
                        }
                    }
                    break;
            }
            return null;
        } catch (C7585u e3) {
            AbstractC7535b.a(e3);
            a(cif);
            a2 = eo.a(this.f45a);
            packageName = this.f45a.getPackageName();
            m858a = en.m858a(i);
            str2 = com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN;
            a2.b(packageName, m858a, str, str2);
            C7583s.c(this.f45a, cif, z);
            return null;
        } catch (iz e4) {
            AbstractC7535b.a(e4);
            AbstractC7535b.d("receive a message which action string is not valid. is the reg expired?");
            a2 = eo.a(this.f45a);
            packageName = this.f45a.getPackageName();
            m858a = en.m858a(i);
            str2 = "20";
            a2.b(packageName, m858a, str, str2);
            C7583s.c(this.f45a, cif, z);
            return null;
        }
    }

    private PushMessageHandler.InterfaceC7557a a(Cif cif, byte[] bArr) {
        String str;
        iu a2;
        String str2 = null;
        try {
            a2 = ai.a(this.f45a, cif);
        } catch (C7585u e) {
            AbstractC7535b.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (iz e2) {
            AbstractC7535b.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            AbstractC7535b.d("message arrived: receiving an un-recognized message. " + cif.f617a);
            return null;
        }
        hj a3 = cif.a();
        AbstractC7535b.m586a("message arrived: processing an arrived message, action=" + a3);
        if (an.a[a3.ordinal()] != 1) {
            return null;
        }
        if (cif.m1030b()) {
            C7675im c7675im = (C7675im) a2;
            C7673hv a4 = c7675im.a();
            if (a4 != null) {
                hw hwVar = cif.f618a;
                if (hwVar != null && hwVar.m989a() != null) {
                    str2 = cif.f618a.f532a.get("jobkey");
                }
                MiPushMessage generateMessage = PushMessageHelper.generateMessage(c7675im, cif.m1022a(), false);
                generateMessage.setArrivedMessage(true);
                AbstractC7535b.m586a("message arrived: receive a message, msgid=" + a4.m980a() + ", jobkey=" + str2);
                return generateMessage;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        AbstractC7535b.d(str);
        return null;
    }

    public static am a(Context context) {
        if (a == null) {
            a = new am(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f45a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > ConfigStorage.DEFAULT_SMALL_MAX_AGE) {
            MiPushClient.reInitialize(this.f45a, hx.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f43a) {
            f44a.remove(str);
            C7564b.m629a(context);
            SharedPreferences a2 = C7564b.a(context);
            String a3 = bp.a(f44a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            C7784t.a(edit);
        }
    }

    private void a(ia iaVar) {
        String a2 = iaVar.a();
        AbstractC7535b.b("receive ack " + a2);
        Map<String, String> m1003a = iaVar.m1003a();
        if (m1003a != null) {
            String str = m1003a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AbstractC7535b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bx.a(this.f45a).a(a2, str, Boolean.valueOf(iaVar.f575a == 0));
        }
    }

    private void a(Cif cif) {
        AbstractC7535b.m586a("receive a message but decrypt failed. report now.");
        ii iiVar = new ii(cif.m1022a().f530a, false);
        iiVar.c(ht.DecryptMessageFail.f497a);
        iiVar.b(cif.m1023a());
        iiVar.d(cif.f624b);
        HashMap hashMap = new HashMap();
        iiVar.f636a = hashMap;
        hashMap.put(com.taobao.accs.common.Constants.SP_KEY_REG_ID, MiPushClient.getRegId(this.f45a));
        ao.a(this.f45a).a((ao) iiVar, hj.Notification, false, (hw) null);
    }

    private void a(ii iiVar) {
        ia iaVar = new ia();
        iaVar.c(ht.CancelPushMessageACK.f497a);
        iaVar.a(iiVar.m1037a());
        iaVar.a(iiVar.a());
        iaVar.b(iiVar.b());
        iaVar.e(iiVar.c());
        iaVar.a(0L);
        iaVar.d("success clear push message.");
        ao.a(this.f45a).a(iaVar, hj.Notification, false, true, null, false, this.f45a.getPackageName(), C7564b.m629a(this.f45a).m630a(), false);
    }

    private void a(C7675im c7675im, Cif cif) {
        hw m1022a = cif.m1022a();
        if (m1022a != null) {
            m1022a = br.a(m1022a.m987a());
        }
        hz hzVar = new hz();
        hzVar.b(c7675im.b());
        hzVar.a(c7675im.m1060a());
        hzVar.a(c7675im.a().a());
        if (!TextUtils.isEmpty(c7675im.c())) {
            hzVar.c(c7675im.c());
        }
        if (!TextUtils.isEmpty(c7675im.d())) {
            hzVar.d(c7675im.d());
        }
        hzVar.a(it.a(this.f45a, cif));
        ao.a(this.f45a).a((ao) hzVar, hj.AckMessage, m1022a);
    }

    private void a(String str, long j, EnumC7568e enumC7568e) {
        au a2 = C7575l.a(enumC7568e);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (af.class) {
                if (af.a(this.f45a).m608a(str)) {
                    af.a(this.f45a).c(str);
                    if ("syncing".equals(af.a(this.f45a).a(a2))) {
                        af.a(this.f45a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(af.a(this.f45a).a(a2))) {
            af.a(this.f45a).c(str);
        } else {
            synchronized (af.class) {
                if (af.a(this.f45a).m608a(str)) {
                    if (af.a(this.f45a).a(str) < 10) {
                        af.a(this.f45a).b(str);
                        ao.a(this.f45a).a(str, a2, enumC7568e);
                    } else {
                        af.a(this.f45a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m609a(Context context, String str) {
        synchronized (f43a) {
            C7564b.m629a(context);
            SharedPreferences a2 = C7564b.a(context);
            if (f44a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f44a = new LinkedList();
                for (String str2 : split) {
                    f44a.add(str2);
                }
            }
            if (f44a.contains(str)) {
                return true;
            }
            f44a.add(str);
            if (f44a.size() > 25) {
                f44a.poll();
            }
            String a3 = bp.a(f44a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            C7784t.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m610a(Cif cif) {
        Map<String, String> m989a = cif.m1022a() == null ? null : cif.m1022a().m989a();
        if (m989a == null) {
            return false;
        }
        String str = m989a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(ia iaVar) {
        Context context;
        EnumC7568e enumC7568e;
        AbstractC7535b.c("ASSEMBLE_PUSH : " + iaVar.toString());
        String a2 = iaVar.a();
        Map<String, String> m1003a = iaVar.m1003a();
        if (m1003a != null) {
            String str = m1003a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ag.FCM.name())) {
                AbstractC7535b.m586a("ASSEMBLE_PUSH : receive fcm token sync ack");
                context = this.f45a;
                enumC7568e = EnumC7568e.ASSEMBLE_PUSH_FCM;
            } else {
                if (str.contains("brand:" + ag.HUAWEI.name())) {
                    AbstractC7535b.m586a("ASSEMBLE_PUSH : receive hw token sync ack");
                    context = this.f45a;
                    enumC7568e = EnumC7568e.ASSEMBLE_PUSH_HUAWEI;
                } else {
                    if (str.contains("brand:" + ag.OPPO.name())) {
                        AbstractC7535b.m586a("ASSEMBLE_PUSH : receive COS token sync ack");
                        context = this.f45a;
                        enumC7568e = EnumC7568e.ASSEMBLE_PUSH_COS;
                    } else {
                        if (!str.contains("brand:" + ag.VIVO.name())) {
                            return;
                        }
                        AbstractC7535b.m586a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                        context = this.f45a;
                        enumC7568e = EnumC7568e.ASSEMBLE_PUSH_FTOS;
                    }
                }
            }
            C7572i.b(context, enumC7568e, str);
            a(a2, iaVar.f575a, enumC7568e);
        }
    }

    private void b(Cif cif) {
        hw m1022a = cif.m1022a();
        if (m1022a != null) {
            m1022a = br.a(m1022a.m987a());
        }
        hz hzVar = new hz();
        hzVar.b(cif.m1023a());
        hzVar.a(m1022a.m988a());
        hzVar.a(m1022a.m986a());
        if (!TextUtils.isEmpty(m1022a.m993b())) {
            hzVar.c(m1022a.m993b());
        }
        hzVar.a(it.a(this.f45a, cif));
        ao.a(this.f45a).a((ao) hzVar, hj.AckMessage, false, m1022a);
    }

    private void b(ii iiVar) {
        String str;
        Map<String, String> m1038a = iiVar.m1038a();
        if (m1038a == null) {
            str = "detect failed because null";
        } else {
            String str2 = (String) ay.a(m1038a, "pkgList", (Object) null);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f45a.getSystemService("activity")).getRunningAppProcesses();
                    if (C7787w.a(runningAppProcesses)) {
                        AbstractC7535b.m586a("detect failed because params illegal");
                        return;
                    }
                    String[] split = str2.split(",");
                    HashMap hashMap = new HashMap();
                    for (String str3 : split) {
                        String[] split2 = str3.split(Constants.WAVE_SEPARATOR);
                        if (split2.length >= 2) {
                            hashMap.put(split2[1], split2[0]);
                        }
                    }
                    C7787w.C7788a c7788a = new C7787w.C7788a(Constants.WAVE_SEPARATOR, ",");
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (hashMap.containsKey(runningAppProcessInfo.processName)) {
                            c7788a.a((String) hashMap.get(runningAppProcessInfo.processName), String.valueOf(runningAppProcessInfo.importance));
                            hashMap.remove(runningAppProcessInfo.processName);
                        }
                    }
                    if (c7788a.toString().length() <= 0) {
                        AbstractC7535b.b("detect failed because no alive process");
                        return;
                    }
                    ii iiVar2 = new ii();
                    iiVar2.a(iiVar.m1037a());
                    iiVar2.b(iiVar.b());
                    iiVar2.d(iiVar.c());
                    iiVar2.c(ht.DetectAppAliveResult.f497a);
                    HashMap hashMap2 = new HashMap();
                    iiVar2.f636a = hashMap2;
                    hashMap2.put("alive", c7788a.toString());
                    if (Boolean.parseBoolean((String) ay.a(m1038a, "reportNotAliveApp", "false")) && hashMap.size() > 0) {
                        C7787w.C7788a c7788a2 = new C7787w.C7788a("", ",");
                        for (String str4 : hashMap.keySet()) {
                            c7788a2.a((String) hashMap.get(str4), "");
                        }
                        iiVar2.f636a.put("notAlive", c7788a2.toString());
                    }
                    ao.a(this.f45a).a((ao) iiVar2, hj.Notification, false, (hw) null);
                    return;
                } catch (Throwable th) {
                    AbstractC7535b.m586a("detect failed " + th);
                    return;
                }
            }
            str = "detect failed because empty";
        }
        AbstractC7535b.m586a(str);
    }

    public PushMessageHandler.InterfaceC7557a a(Intent intent) {
        String str;
        eo a2;
        String packageName;
        String str2;
        eo a3;
        String packageName2;
        String format;
        String action = intent.getAction();
        AbstractC7535b.m586a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                AbstractC7535b.d("receiving an empty message, drop");
                eo.a(this.f45a).a(this.f45a.getPackageName(), intent, "12");
                return null;
            }
            Cif cif = new Cif();
            try {
                it.a(cif, byteArrayExtra);
                C7564b m629a = C7564b.m629a(this.f45a);
                hw m1022a = cif.m1022a();
                hj a4 = cif.a();
                hj hjVar = hj.SendMessage;
                if (a4 == hjVar && m1022a != null && !m629a.m640e() && !booleanExtra) {
                    m1022a.a("mrt", stringExtra);
                    m1022a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m610a(cif)) {
                        AbstractC7535b.b("this is a mina's message, ack later");
                        m1022a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m1022a.m986a()));
                        m1022a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) it.a(this.f45a, cif)));
                    } else {
                        b(cif);
                    }
                }
                if (cif.a() == hjVar && !cif.m1030b()) {
                    if (com.xiaomi.push.service.al.m1167a(cif)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = cif.b();
                        objArr[1] = m1022a != null ? m1022a.m988a() : "";
                        AbstractC7535b.m586a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        a3 = eo.a(this.f45a);
                        packageName2 = this.f45a.getPackageName();
                        format = String.format("13: %1$s", cif.b());
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = cif.b();
                        objArr2[1] = m1022a != null ? m1022a.m988a() : "";
                        AbstractC7535b.m586a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        a3 = eo.a(this.f45a);
                        packageName2 = this.f45a.getPackageName();
                        format = String.format("14: %1$s", cif.b());
                    }
                    a3.a(packageName2, intent, format);
                    C7583s.a(this.f45a, cif, booleanExtra);
                    return null;
                }
                if (cif.a() == hjVar && cif.m1030b() && com.xiaomi.push.service.al.m1167a(cif) && (!booleanExtra || m1022a == null || m1022a.m989a() == null || !m1022a.m989a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = cif.b();
                    objArr3[1] = m1022a != null ? m1022a.m988a() : "";
                    AbstractC7535b.m586a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    eo.a(this.f45a).a(this.f45a.getPackageName(), intent, String.format("25: %1$s", cif.b()));
                    C7583s.b(this.f45a, cif, booleanExtra);
                    return null;
                }
                if (m629a.m638c() || cif.f617a == hj.Registration) {
                    if (!m629a.m638c() || !m629a.m641f()) {
                        return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (cif.f617a != hj.UnRegistration) {
                        C7583s.e(this.f45a, cif, booleanExtra);
                        MiPushClient.unregisterPush(this.f45a);
                    } else if (cif.m1030b()) {
                        m629a.m631a();
                        MiPushClient.clearExtras(this.f45a);
                        PushMessageHandler.a();
                    } else {
                        AbstractC7535b.d("receiving an un-encrypt unregistration message");
                    }
                } else if (com.xiaomi.push.service.al.m1167a(cif)) {
                    return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    C7583s.e(this.f45a, cif, booleanExtra);
                    boolean m639d = m629a.m639d();
                    AbstractC7535b.d("receive message without registration. need re-register!registered?" + m639d);
                    eo.a(this.f45a).a(this.f45a.getPackageName(), intent, "15");
                    if (m639d) {
                        a();
                    }
                }
            } catch (iz e) {
                e = e;
                a2 = eo.a(this.f45a);
                packageName = this.f45a.getPackageName();
                str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP;
                a2.a(packageName, intent, str2);
                AbstractC7535b.a(e);
                return null;
            } catch (Exception e2) {
                e = e2;
                a2 = eo.a(this.f45a);
                packageName = this.f45a.getPackageName();
                str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP;
                a2.a(packageName, intent, str2);
                AbstractC7535b.a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            Cif cif2 = new Cif();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    it.a(cif2, byteArrayExtra2);
                }
            } catch (iz unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(cif2.a()));
            miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            AbstractC7535b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                AbstractC7535b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            Cif cif3 = new Cif();
            try {
                it.a(cif3, byteArrayExtra3);
                C7564b m629a2 = C7564b.m629a(this.f45a);
                if (com.xiaomi.push.service.al.m1167a(cif3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!m629a2.m638c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!m629a2.m638c() || !m629a2.m641f()) {
                    return a(cif3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                AbstractC7535b.d(str);
            } catch (Exception e3) {
                AbstractC7535b.d("fail to deal with arrived message. " + e3);
            }
        }
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
