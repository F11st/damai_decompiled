package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.jb;
import com.xiaomi.push.jl;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class it {
    public static short a(Context context, Cif cif) {
        return a(context, cif.f624b);
    }

    public static short a(Context context, String str) {
        return (short) (C7667h.a(context, str, false).a() + 0 + (ak.b(context) ? 4 : 0) + (ak.a(context) ? 8 : 0) + (com.xiaomi.push.service.ax.m1181a(context) ? 16 : 0));
    }

    public static <T extends iu<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new iz("the message byte is empty.");
        }
        new iy(new jl.C7682a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends iu<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ja(new jb.C7681a()).a(t);
        } catch (iz e) {
            AbstractC7535b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
