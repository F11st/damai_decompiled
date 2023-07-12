package tb;

import android.content.Context;
import android.net.Uri;
import anet.channel.status.NetworkStatusHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.compat.mtop.MtopConnectTimeoutException;
import com.taobao.phenix.compat.mtop.MtopIndifferentException;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.phenix.loader.network.HttpLoader;
import com.youku.phone.xcdnengine.Xcdn;
import com.youku.phone.xcdnengine.XcdnEngine;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.text.C8604o;
import mtopsdk.mtop.util.ErrorConstant;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class e23 implements HttpLoader {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9067a Companion = new C9067a(null);
    private XcdnEngine a;
    private final qh1 b;
    private final Context c;

    /* compiled from: Taobao */
    /* renamed from: tb.e23$a */
    /* loaded from: classes7.dex */
    public static final class C9067a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9067a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2145300885")) {
                return (String) ipChange.ipc$dispatch("2145300885", new Object[]{this, str});
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                Charset charset = hi.UTF_8;
                if (str != null) {
                    byte[] bytes = str.getBytes(charset);
                    b41.h(bytes, "(this as java.lang.String).getBytes(charset)");
                    messageDigest.update(bytes);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder();
                    b41.h(digest, "messageDigest");
                    for (byte b : digest) {
                        String hexString = Integer.toHexString(b & 255);
                        while (hexString.length() < 2) {
                            hexString = YKUpsConvert.CHAR_ZERO + hexString;
                        }
                        sb.append(hexString);
                    }
                    String sb2 = sb.toString();
                    b41.h(sb2, "hexString.toString()");
                    return sb2;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Error e) {
                e.printStackTrace();
                return "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public /* synthetic */ C9067a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.e23$b */
    /* loaded from: classes7.dex */
    public static final class C9068b implements XcdnEngine.Callback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String b;
        final /* synthetic */ HttpLoader.FinishCallback c;

        C9068b(String str, HttpLoader.FinishCallback finishCallback) {
            this.b = str;
            this.c = finishCallback;
        }

        @Override // com.youku.phone.xcdnengine.XcdnEngine.Callback, com.youku.phone.xcdn.api.IXcdnCallback
        public final void onEvent(long j, int i, int i2, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1182055195")) {
                ipChange.ipc$dispatch("-1182055195", new Object[]{this, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str});
            } else if (i == 8) {
                if (i2 == 32) {
                    if (e23.this.e(this.b) != null) {
                        this.c.onFinished(new p22(e23.this.e(this.b), 0, (int) new File(this.b).length()));
                    } else {
                        this.c.onError(new HttpCodeResponseException(10000));
                    }
                } else if (i2 > 1000 && i2 < 2000) {
                    if (!NetworkStatusHelper.n()) {
                        this.c.onError(new MtopIndifferentException(-200, ErrorConstant.ERRMSG_NO_NETWORK));
                    } else {
                        this.c.onError(new MtopConnectTimeoutException(i2));
                    }
                } else {
                    this.c.onError(new HttpCodeResponseException(i2));
                }
            }
        }
    }

    public e23(@NotNull Context context) {
        b41.i(context, "mContext");
        this.c = context;
        this.b = new qh1(context);
    }

    private final boolean b(String str) {
        boolean F;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "258994239")) {
            return ((Boolean) ipChange.ipc$dispatch("258994239", new Object[]{this, str})).booleanValue();
        }
        F = C8604o.F(str, "http", false, 2, null);
        return F;
    }

    private final boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022176629")) {
            return ((Boolean) ipChange.ipc$dispatch("2022176629", new Object[]{this, str})).booleanValue();
        }
        Uri parse = Uri.parse(str);
        b41.h(parse, "uri");
        String host = parse.getHost();
        return host != null && b41.d(host, "gw.alicdn.com");
    }

    private final Future<?> d(String str, Map<String, String> map, boolean z, HttpLoader.FinishCallback finishCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980355425")) {
            return (Future) ipChange.ipc$dispatch("-1980355425", new Object[]{this, str, map, Boolean.valueOf(z), finishCallback});
        }
        if (this.a == null) {
            this.a = new XcdnEngine(this.c);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("biz_id", z ? "27" : "9");
        hashMap.put(Xcdn.Config.CONFIG_USE_MINER, z ? "1" : "0");
        hashMap.put("support_http", "1");
        hashMap.put("dwn_prio", "2");
        hashMap.put(Xcdn.Config.CONFIG_START_TIMEMS, String.valueOf(System.currentTimeMillis()) + "");
        hashMap.put("retry_count", "1");
        StringBuilder sb = new StringBuilder();
        File cacheDir = this.c.getCacheDir();
        b41.h(cacheDir, "mContext.cacheDir");
        sb.append(cacheDir.getAbsolutePath());
        sb.append("/xcdn-file/");
        sb.append(Companion.b(str));
        String sb2 = sb.toString();
        XcdnEngine xcdnEngine = this.a;
        b41.f(xcdnEngine);
        long xcdnDownload = xcdnEngine.xcdnDownload(str, sb2, hashMap, new C9068b(sb2, finishCallback));
        if (xcdnDownload < 0) {
            finishCallback.onError(new HttpCodeResponseException((int) xcdnDownload));
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] e(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "close fc exception"
            java.lang.String r1 = "close fis exception"
            java.lang.String r2 = "XcdnLoader"
            com.android.alibaba.ip.runtime.IpChange r3 = tb.e23.$ipChange
            java.lang.String r4 = "683130594"
            boolean r5 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r3, r4)
            r6 = 0
            if (r5 == 0) goto L20
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r6] = r11
            r1 = 1
            r0[r1] = r12
            java.lang.Object r12 = r3.ipc$dispatch(r4, r0)
            byte[] r12 = (byte[]) r12
            return r12
        L20:
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L6b
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L6b
            r5.<init>(r12)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L6b
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L6b
            java.nio.channels.FileChannel r12 = r4.getChannel()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L64
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            r5.<init>()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            r7 = 10240(0x2800, float:1.4349E-41)
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r7)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
        L3a:
            int r8 = r12.read(r7)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            r9 = -1
            if (r8 == r9) goto L4c
            byte[] r9 = r7.array()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            r5.write(r9, r6, r8)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            r7.position(r6)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            goto L3a
        L4c:
            byte[] r3 = r5.toByteArray()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            r4.close()     // Catch: java.lang.Exception -> L54
            goto L57
        L54:
            android.util.Log.e(r2, r1)
        L57:
            r12.close()     // Catch: java.lang.Exception -> L5b
            goto L5e
        L5b:
            android.util.Log.e(r2, r0)
        L5e:
            return r3
        L5f:
            r12 = move-exception
            r10 = r3
            r3 = r12
            r12 = r10
            goto L86
        L64:
            r12 = r3
            goto L6d
        L66:
            r12 = move-exception
            r4 = r3
            r3 = r12
            r12 = r4
            goto L86
        L6b:
            r12 = r3
            r4 = r12
        L6d:
            java.lang.String r5 = "read file exception"
            android.util.Log.e(r2, r5)     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L7b
            r4.close()     // Catch: java.lang.Exception -> L78
            goto L7b
        L78:
            android.util.Log.e(r2, r1)
        L7b:
            if (r12 == 0) goto L84
            r12.close()     // Catch: java.lang.Exception -> L81
            goto L84
        L81:
            android.util.Log.e(r2, r0)
        L84:
            return r3
        L85:
            r3 = move-exception
        L86:
            if (r4 == 0) goto L8f
            r4.close()     // Catch: java.lang.Exception -> L8c
            goto L8f
        L8c:
            android.util.Log.e(r2, r1)
        L8f:
            if (r12 == 0) goto L98
            r12.close()     // Catch: java.lang.Exception -> L95
            goto L98
        L95:
            android.util.Log.e(r2, r0)
        L98:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.e23.e(java.lang.String):byte[]");
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void connectTimeout(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1738713143")) {
            ipChange.ipc$dispatch("1738713143", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b.connectTimeout(i);
        }
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    @Nullable
    public Future<?> load(@NotNull String str, @NotNull Map<String, String> map, @NotNull HttpLoader.FinishCallback finishCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004241747")) {
            return (Future) ipChange.ipc$dispatch("1004241747", new Object[]{this, str, map, finishCallback});
        }
        b41.i(str, "url");
        b41.i(map, "map");
        b41.i(finishCallback, "finishCallback");
        if (!c(str) && b(str)) {
            return d(str, map, true, finishCallback);
        }
        return this.b.load(str, map, finishCallback);
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void readTimeout(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "114548839")) {
            ipChange.ipc$dispatch("114548839", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b.readTimeout(i);
        }
    }
}
