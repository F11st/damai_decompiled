package com.youku.upsplayer.util;

import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.upsplayer.module.AntiTheftChainUtLogType;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.vpm.constants.TableField;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AntiTheftChainUtUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.upsplayer.util.AntiTheftChainUtUtil$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType;

        static {
            int[] iArr = new int[AntiTheftChainUtLogType.values().length];
            $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType = iArr;
            try {
                iArr[AntiTheftChainUtLogType.ADSTART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.ADEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.VODSTART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.DOWNLOADSTART.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType[AntiTheftChainUtLogType.CKEYERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static void formMap(Map<String, String> map, UtAntiTheaftBean utAntiTheaftBean) {
        String str;
        String str2;
        map.put("utdid", "" + utAntiTheaftBean.utid);
        map.put(TableField.PS_ID, "" + utAntiTheaftBean.psid);
        map.put("ups_client_netip", "" + utAntiTheaftBean.upsClientNetip);
        map.put("ckey", "" + utAntiTheaftBean.ckey);
        map.put("vid", "" + utAntiTheaftBean.vid);
        map.put("title", "" + utAntiTheaftBean.title);
        map.put(WPKFactory.INSTANCE_KEY_LOG_TYPE, "" + utAntiTheaftBean.log_type);
        map.put("ccode", "" + utAntiTheaftBean.ccode);
        map.put("uid", "" + utAntiTheaftBean.uid);
        map.put("vip", "" + utAntiTheaftBean.vip);
        map.put("curent_time", System.currentTimeMillis() + "");
        map.put("curent_thread", Thread.currentThread().getId() + "");
        if (utAntiTheaftBean.isCkeyError && (str2 = utAntiTheaftBean.ckeyErrorMsg) != null) {
            map.put("error_msg", str2);
        }
        if (utAntiTheaftBean.clientid != null) {
            str = "" + utAntiTheaftBean.clientid;
        } else {
            str = "null";
        }
        map.put("client_id", str);
    }

    public static void utlog(AntiTheftChainClientType antiTheftChainClientType, AntiTheftChainUtLogType antiTheftChainUtLogType, UtAntiTheaftBean utAntiTheaftBean) {
        utlogbyAppKey(antiTheftChainClientType, antiTheftChainUtLogType, utAntiTheaftBean, "23640594");
    }

    private static void utlogExternal(UtAntiTheaftBean utAntiTheaftBean, String str) {
        HashMap hashMap = new HashMap();
        formMap(hashMap, utAntiTheaftBean);
        UtHelperProxy.getInstance().sendCustomEvent(str, "PAGE_ATC", "EVENT_ATC_LOG", null, 2341L, hashMap);
    }

    private static void utlogInternal(UtAntiTheaftBean utAntiTheaftBean) {
        HashMap hashMap = new HashMap();
        formMap(hashMap, utAntiTheaftBean);
        UtHelperProxy.getInstance().sendCustomEvent(null, "PAGE_ATC", "EVENT_ATC_LOG", null, 2341L, hashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void utlogbyAppKey(com.youku.antitheftchain.interfaces.AntiTheftChainClientType r1, com.youku.upsplayer.module.AntiTheftChainUtLogType r2, com.youku.upsplayer.module.UtAntiTheaftBean r3, java.lang.String r4) {
        /*
            if (r3 != 0) goto L3
            return
        L3:
            int[] r0 = com.youku.upsplayer.util.AntiTheftChainUtUtil.AnonymousClass1.$SwitchMap$com$youku$upsplayer$module$AntiTheftChainUtLogType
            int r2 = r2.ordinal()
            r2 = r0[r2]
            switch(r2) {
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto Lf;
                default: goto Le;
            }
        Le:
            goto L1c
        Lf:
            r2 = 6
            goto L1a
        L11:
            r2 = 5
            goto L1a
        L13:
            r2 = 4
            goto L1a
        L15:
            r2 = 3
            goto L1a
        L17:
            r2 = 2
            goto L1a
        L19:
            r2 = 1
        L1a:
            r3.log_type = r2
        L1c:
            com.youku.antitheftchain.interfaces.AntiTheftChainClientType r2 = com.youku.antitheftchain.interfaces.AntiTheftChainClientType.Internal
            if (r1 != r2) goto L24
            utlogInternal(r3)
            goto L2b
        L24:
            com.youku.antitheftchain.interfaces.AntiTheftChainClientType r2 = com.youku.antitheftchain.interfaces.AntiTheftChainClientType.External
            if (r1 != r2) goto L2b
            utlogExternal(r3, r4)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.upsplayer.util.AntiTheftChainUtUtil.utlogbyAppKey(com.youku.antitheftchain.interfaces.AntiTheftChainClientType, com.youku.upsplayer.module.AntiTheftChainUtLogType, com.youku.upsplayer.module.UtAntiTheaftBean, java.lang.String):void");
    }
}
