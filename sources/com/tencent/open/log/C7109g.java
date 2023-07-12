package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.youku.upsplayer.util.YKUpsConvert;
import tb.jn1;
import tb.n6;
import tb.r10;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.log.g */
/* loaded from: classes11.dex */
public final class C7109g {
    public static final C7109g a = new C7109g();

    public final String a(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? "-" : ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : "I" : "D" : "V";
    }

    public String a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        StringBuilder sb = new StringBuilder();
        sb.append(a(i));
        sb.append(r10.DIR);
        sb.append(time.format("%Y-%m-%d %H:%M:%S"));
        sb.append('.');
        if (j2 < 10) {
            sb.append("00");
        } else if (j2 < 100) {
            sb.append(YKUpsConvert.CHAR_ZERO);
        }
        sb.append(j2);
        sb.append(' ');
        sb.append(jn1.ARRAY_START);
        if (thread == null) {
            sb.append(n6.APN_UNKNOWN);
        } else {
            sb.append(thread.getName());
        }
        sb.append(jn1.ARRAY_END);
        sb.append(jn1.ARRAY_START);
        sb.append(str);
        sb.append(jn1.ARRAY_END);
        sb.append(' ');
        sb.append(str2);
        sb.append('\n');
        if (th != null) {
            sb.append("* Exception : \n");
            sb.append(Log.getStackTraceString(th));
            sb.append('\n');
        }
        return sb.toString();
    }
}
