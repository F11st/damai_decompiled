package com.loc;

import com.youku.live.livesdk.wkit.component.Constants;
import tb.f73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class y0 {
    public long a;
    public String b;
    public int d;
    public long e;
    public short g;
    public boolean h;
    public int c = -113;
    public long f = 0;

    public y0(boolean z) {
        this.h = z;
    }

    public static long a(String str) {
        long j;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j3 = 97;
                if (charAt < 97 || charAt > 102) {
                    j3 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (charAt != 58 && charAt != 124) {
                            return 0L;
                        }
                    }
                }
                j = (charAt - j3) + 10;
            } else {
                j = charAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0L;
        }
        return j2;
    }

    public static String c(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return f73.a(f73.b(j), ":");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public y0 clone() {
        y0 y0Var = new y0(this.h);
        y0Var.a = this.a;
        y0Var.b = this.b;
        y0Var.c = this.c;
        y0Var.d = this.d;
        y0Var.e = this.e;
        y0Var.f = this.f;
        y0Var.g = this.g;
        y0Var.h = this.h;
        return y0Var;
    }

    public final String b() {
        return this.h + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + this.a;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.a + ", ssid='" + this.b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + ((int) this.g) + ", connected=" + this.h + '}';
    }
}
