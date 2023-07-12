package com.taobao.securityjni.bcast;

import android.content.Intent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.jn1;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class AppStateManager {
    public static final String DNS_ACTION = "setaobao.bbox.DNS";
    public static final String EXTRA_DNS_IP = "IPAddress";
    public static final String EXTRA_DNS_LOCAL = "DNSinfolocal";
    public static final String EXTRA_DNS_NET = "DNSinfonet";
    public static final String EXTRA_RT = "RTinfo";
    public static final String EXTRA_SPITEP = "SPITEPinfo";
    private static final int IPV4_SIZE = 4;
    public static int Init = 0;
    public static final String RT_ACTION = "setaobao.bbox.RT";
    public static final int RT_VALUE_100_PERMISSION = 10;
    public static final int RT_VALUE_INVALID = -1;
    public static final int RT_VALUE_LIKELY_1 = 1;
    public static final int RT_VALUE_LIKELY_2 = 2;
    public static final int RT_VALUE_LIKELY_3 = 3;
    public static final int RT_VALUE_LIKELY_4 = 4;
    public static final int RT_VALUE_LIKELY_5 = 5;
    public static final int RT_VALUE_LIKELY_6 = 6;
    public static final int RT_VALUE_LIKELY_7 = 7;
    public static final int RT_VALUE_LIKELY_8 = 8;
    public static final int RT_VALUE_LIKELY_9 = 9;
    public static final int RT_VALUE_UNDETECTABLE = 0;
    public static final String SPITEP_ACTION = "setaobao.bbox.SPITEP";
    public static final int SPITEP_VALUE_NS_0 = 0;
    public static final int SPITEP_VALUE_NS_1 = 1;
    public static final int SPITEP_VALUE_NS_2 = 2;
    public static final int SPITEP_VALUE_NS_3 = 3;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DoaminIP {
        public byte[][] ip;
        public String name;

        private String IpToString() {
            StringBuilder sb = new StringBuilder();
            if (this.ip == null) {
                return "null";
            }
            int i = 0;
            while (true) {
                byte[][] bArr = this.ip;
                if (i < bArr.length) {
                    byte[] bArr2 = bArr[i];
                    sb.append("ip[");
                    sb.append(i);
                    sb.append("]=");
                    if (bArr2 != null) {
                        for (int i2 = 0; i2 < bArr2.length; i2++) {
                            sb.append(bArr2[i2] & 255);
                            if (i2 != bArr2.length - 1) {
                                sb.append(jn1.CONDITION_IF_MIDDLE);
                            }
                        }
                    } else {
                        sb.append("null");
                    }
                    sb.append(AltriaXLaunchTime.SPACE);
                    i++;
                } else {
                    return sb.toString();
                }
            }
        }

        public String toString() {
            return "DoaminIP [name=" + this.name + ", ip=" + IpToString() + jn1.ARRAY_END_STR;
        }
    }

    public static final ArrayList<DoaminIP> parserDomainIP(Intent intent) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(EXTRA_DNS_IP);
        byte[][] bArr = null;
        if (byteArrayExtra == null) {
            return null;
        }
        ArrayList<DoaminIP> arrayList = new ArrayList<>();
        int i = 0;
        while (i < byteArrayExtra.length) {
            int i2 = byteArrayExtra[i] & 255;
            String str = new String(byteArrayExtra, i + 1, i2);
            int i3 = i + i2 + 1;
            int i4 = byteArrayExtra[i3] & 255;
            int i5 = i4 + i3;
            if (i5 > byteArrayExtra.length - 1) {
                break;
            }
            int i6 = i4 / 4;
            if (i6 > 0) {
                bArr = (byte[][]) Array.newInstance(byte.class, i6, 4);
                for (int i7 = 0; i7 < i6; i7++) {
                    System.arraycopy(byteArrayExtra, i3 + 1 + (i7 * 4), bArr[i7], 0, 4);
                }
            }
            i = i5 + 1;
            DoaminIP doaminIP = new DoaminIP();
            doaminIP.name = str;
            doaminIP.ip = bArr;
            arrayList.add(doaminIP);
        }
        return arrayList;
    }
}
