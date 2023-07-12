package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.cj;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.cd */
/* loaded from: classes11.dex */
public class C7616cd extends cf {
    public C7616cd(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static C7616cd a(Context context, String str, int i) {
        AbstractC7535b.b("delete  messages when db size is too bigger");
        String m736a = cj.a(context).m736a(str);
        if (TextUtils.isEmpty(m736a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + m736a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new C7616cd(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    private void a(long j) {
        String[] strArr = ((cj.C7620d) this).f167a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.cj.AbstractRunnableC7617a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = cp.a(m738a());
            long j = cb.f150a;
            if (a <= j) {
                AbstractC7535b.b("db size is suitable");
                return;
            }
            long j2 = (long) ((((a - j) * 1.2d) / j) * longValue);
            a(j2);
            bx a2 = bx.a(context);
            a2.a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
            super.a(context, obj);
        }
    }
}
