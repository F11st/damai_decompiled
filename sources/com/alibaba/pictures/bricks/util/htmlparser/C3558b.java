package com.alibaba.pictures.bricks.util.htmlparser;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import com.alibaba.pictures.bricks.util.htmlparser.C3558b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hi;
import tb.k50;

/* compiled from: Taobao */
/* renamed from: com.alibaba.pictures.bricks.util.htmlparser.b */
/* loaded from: classes7.dex */
public final class C3558b {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3560b Companion = new C3560b(null);
    private static final String b = C3558b.class.getSimpleName();
    @Nullable
    private static LruCache<String, Bitmap> c = new C3559a(((int) Runtime.getRuntime().maxMemory()) / 6);
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.util.htmlparser.b$a */
    /* loaded from: classes7.dex */
    public static final class C3559a extends LruCache<String, Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;

        C3559a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(@NotNull String str, @Nullable Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1887565234")) {
                return ((Integer) ipChange.ipc$dispatch("-1887565234", new Object[]{this, str, bitmap})).intValue();
            }
            b41.i(str, "key");
            if (bitmap != null) {
                return bitmap.getByteCount();
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.util.htmlparser.b$b */
    /* loaded from: classes7.dex */
    public static final class C3560b {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3560b() {
        }

        public /* synthetic */ C3560b(k50 k50Var) {
            this();
        }
    }

    private final String b(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306638931")) {
            return (String) ipChange.ipc$dispatch("306638931", new Object[]{this, bArr});
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append(YKUpsConvert.CHAR_ZERO);
            }
            sb.append(hexString);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "sb.toString()");
        return sb2;
    }

    private final long c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895676915")) {
            return ((Long) ipChange.ipc$dispatch("-895676915", new Object[]{this})).longValue();
        }
        File[] listFiles = new File(this.a).listFiles();
        long j = 0;
        b41.h(listFiles, "fileList");
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                j += file.length();
            }
        }
        if (j > 10485760) {
            Arrays.sort(listFiles, new Comparator() { // from class: tb.k11
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int d;
                    d = C3558b.d((File) obj, (File) obj2);
                    return d;
                }
            });
            for (File file2 : listFiles) {
                j -= file2.length();
                file2.delete();
                if (j < 10485760) {
                    break;
                }
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(File file, File file2) {
        int f0;
        int f02;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326566116")) {
            return ((Integer) ipChange.ipc$dispatch("1326566116", new Object[]{file, file2})).intValue();
        }
        String name = file.getName();
        b41.h(name, "o1.name");
        String name2 = file.getName();
        b41.h(name2, "o1.name");
        f0 = StringsKt__StringsKt.f0(name2, JSMethod.NOT_SET, 0, false, 6, null);
        String substring = name.substring(f0 + 1);
        b41.h(substring, "this as java.lang.String).substring(startIndex)");
        int parseInt = Integer.parseInt(substring);
        String name3 = file2.getName();
        b41.h(name3, "o2.name");
        String name4 = file2.getName();
        b41.h(name4, "o2.name");
        f02 = StringsKt__StringsKt.f0(name4, JSMethod.NOT_SET, 0, false, 6, null);
        String substring2 = name3.substring(f02 + 1);
        b41.h(substring2, "this as java.lang.String).substring(startIndex)");
        return parseInt - Integer.parseInt(substring2);
    }

    private final String e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218813855")) {
            return (String) ipChange.ipc$dispatch("218813855", new Object[]{this, str});
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bytes = str.getBytes(hi.UTF_8);
            b41.h(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            b41.h(digest, "mDigest.digest()");
            return b(digest);
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    @NotNull
    public final OutputStream f(@NotNull String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428342263")) {
            return (OutputStream) ipChange.ipc$dispatch("1428342263", new Object[]{this, str});
        }
        b41.i(str, "key");
        long c2 = c();
        String str2 = b;
        Log.d(str2, "cache size is :" + c2);
        File file = new File(this.a, e(str) + "_0");
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public final void g(@NotNull String str, @Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096525310")) {
            ipChange.ipc$dispatch("-1096525310", new Object[]{this, str, bitmap});
            return;
        }
        b41.i(str, "key");
        LruCache<String, Bitmap> lruCache = c;
        b41.f(lruCache);
        lruCache.put(str, bitmap);
    }
}
