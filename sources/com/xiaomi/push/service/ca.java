package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7594ab;
import com.xiaomi.push.C7613bm;
import com.xiaomi.push.C7672hn;
import com.xiaomi.push.C7674i;
import com.xiaomi.push.C7694r;
import com.xiaomi.push.it;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ca {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static ArrayList<C7672hn> f956a = new ArrayList<>();

    public static void a() {
        f956a.clear();
    }

    public static void a(Context context, C7672hn c7672hn) {
        if (bz.a(c7672hn.e())) {
            com.xiaomi.push.al.a(context).a(new cb(context, c7672hn));
        }
    }

    public static void a(C7672hn c7672hn) {
        if (f956a.size() > 10) {
            f956a.remove(0);
        }
        f956a.add(c7672hn);
    }

    public static byte[] a(Context context) {
        String a2 = C7694r.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = com.xiaomi.push.bp.a(20);
            C7694r.a(context).m1127a("mipush", "td_key", a2);
        }
        return a(a2);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(C7613bm.m701a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    public static void c(Context context, C7672hn c7672hn) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str;
        String str2;
        BufferedOutputStream a2 = a(context);
        try {
            try {
                byte[] b = C7674i.b(a2, it.a(c7672hn));
                if (b != null && b.length >= 1) {
                    if (b.length > 10240) {
                        str2 = "TinyData write to cache file failed case too much data content item:" + c7672hn.d() + "  ts:" + System.currentTimeMillis();
                        AbstractC7535b.m586a(str2);
                        C7594ab.a((Closeable) null);
                        C7594ab.a((Closeable) null);
                    }
                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        bufferedOutputStream3.write(com.xiaomi.push.af.a(b.length));
                        bufferedOutputStream3.write(b);
                        bufferedOutputStream3.flush();
                        C7594ab.a((Closeable) null);
                        C7594ab.a(bufferedOutputStream3);
                        return;
                    } catch (IOException e) {
                        bufferedOutputStream2 = bufferedOutputStream3;
                        e = e;
                        str = "TinyData write to cache file failed cause io exception item:" + c7672hn.d();
                        a2 = bufferedOutputStream2;
                        AbstractC7535b.a(str, e);
                        C7594ab.a((Closeable) null);
                        C7594ab.a((Closeable) a2);
                        return;
                    } catch (Exception e2) {
                        bufferedOutputStream = bufferedOutputStream3;
                        e = e2;
                        str = "TinyData write to cache file  failed item:" + c7672hn.d();
                        a2 = bufferedOutputStream;
                        AbstractC7535b.a(str, e);
                        C7594ab.a((Closeable) null);
                        C7594ab.a((Closeable) a2);
                        return;
                    } catch (Throwable th) {
                        a2 = bufferedOutputStream3;
                        th = th;
                        C7594ab.a((Closeable) null);
                        C7594ab.a(a2);
                        throw th;
                    }
                }
                str2 = "TinyData write to cache file failed case encryption fail item:" + c7672hn.d() + "  ts:" + System.currentTimeMillis();
                AbstractC7535b.m586a(str2);
                C7594ab.a((Closeable) null);
                C7594ab.a((Closeable) null);
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream2 = null;
            } catch (Exception e4) {
                e = e4;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                a2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
