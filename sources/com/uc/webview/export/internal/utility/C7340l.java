package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.utility.C7337j;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.l */
/* loaded from: classes11.dex */
public final class C7340l {

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.l$b */
    /* loaded from: classes11.dex */
    public static class C7342b implements ValueCallback<Object[]> {
        private String a;

        public C7342b(String str) {
            this.a = str;
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Object[] objArr) {
            Object[] objArr2 = objArr;
            Log.d("VerifyStat", "orign: " + this.a + " objects: " + Arrays.toString(objArr2));
            if (objArr2 != null && objArr2.length == 2 && (objArr2[0] instanceof Integer) && (objArr2[1] instanceof Integer)) {
                String num = ((Integer) objArr2[1]).toString();
                int intValue = ((Integer) objArr2[0]).intValue();
                if (intValue == 8) {
                    IWaStat.WaStat.stat(String.format("%s_err_%s", this.a, num));
                } else if (intValue != 10) {
                } else {
                    IWaStat.WaStat.stat(String.format("%s_ver_%s", this.a, num));
                }
            }
        }
    }

    public static boolean a(String str, Context context, Context context2, ValueCallback<Object[]> valueCallback) {
        try {
            C7358w.a(str, context);
            boolean a = a(str, context, context2, valueCallback, null);
            if (!a) {
                C7358w.a(str, context, a);
            }
            return a;
        } catch (UCSetupException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.l$a */
    /* loaded from: classes11.dex */
    public static class C7341a {
        public static Signature[] a(Context context, String str) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("SignatureVerifier", e.getMessage());
                return null;
            }
        }

        private static Signature[] b(Context context, String str) throws Exception {
            Object newInstance;
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                newInstance = cls.getConstructor(String.class).newInstance("");
            }
            Object invoke = i >= 21 ? cls.getMethod("parsePackage", File.class, Integer.TYPE).invoke(newInstance, new File(str), 0) : cls.getMethod("parsePackage", File.class, String.class, DisplayMetrics.class, Integer.TYPE).invoke(newInstance, new File(str), null, context.getResources().getDisplayMetrics(), 0);
            try {
                cls.getMethod("collectCertificates", Class.forName("android.content.pm.PackageParser$Package"), Integer.TYPE).invoke(newInstance, invoke, 64);
                return (Signature[]) invoke.getClass().getField("mSignatures").get(invoke);
            } catch (Throwable unused) {
                cls.getMethod("collectCertificates", Class.forName("android.content.pm.PackageParser$Package"), Boolean.TYPE).invoke(newInstance, invoke, Boolean.TRUE);
                Object obj = invoke.getClass().getField("mSigningDetails").get(invoke);
                return (Signature[]) obj.getClass().getField("signatures").get(obj);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static android.content.pm.Signature[] a(android.content.Context r10, java.lang.String r11, android.webkit.ValueCallback<java.lang.Object[]> r12) {
            /*
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r2 = 0
                r1[r2] = r11
                java.lang.String r3 = "getUninstalledAPKSignature(): archiveApkFilePath = %1s"
                java.lang.String r1 = java.lang.String.format(r3, r1)
                java.lang.String r3 = "SignatureVerifier"
                com.uc.webview.export.internal.utility.Log.d(r3, r1)
                r1 = 0
                long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r6 = "sc_vrfv1"
                java.lang.String r6 = com.uc.webview.export.extension.UCCore.getParam(r6)     // Catch: java.lang.Throwable -> Lc7
                boolean r6 = java.lang.Boolean.parseBoolean(r6)     // Catch: java.lang.Throwable -> Lc7
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Throwable -> Lc7
                if (r6 != 0) goto L28
                r6 = 0
                goto L2c
            L28:
                boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> Lc7
            L2c:
                r7 = 2
                if (r6 != 0) goto L69
                boolean r8 = com.uc.webview.export.cyclone.UCCyclone.detectZipByFileType(r11)     // Catch: java.lang.Throwable -> Lc7
                if (r8 != 0) goto L37
                r8 = 0
                goto L43
            L37:
                boolean r8 = com.uc.webview.export.internal.utility.C7321a.a(r11)     // Catch: java.lang.Throwable -> Lc7
                if (r8 == 0) goto L3f
                r8 = 1
                goto L43
            L3f:
                boolean r8 = com.uc.webview.export.internal.utility.AbstractC7359x.a(r11)     // Catch: java.lang.Throwable -> Lc7
            L43:
                if (r8 == 0) goto L69
                java.lang.String r10 = "摘要校验V2!"
                com.uc.webview.export.internal.utility.Log.d(r3, r10)     // Catch: java.lang.Throwable -> Lc7
                java.security.cert.X509Certificate[][] r10 = com.uc.webview.export.internal.utility.C7321a.b(r11)     // Catch: java.lang.Throwable -> Lc7
                int r11 = r10.length     // Catch: java.lang.Throwable -> Lc7
                android.content.pm.Signature[] r11 = new android.content.pm.Signature[r11]     // Catch: java.lang.Throwable -> Lc7
                r6 = 0
            L52:
                int r8 = r10.length     // Catch: java.lang.Throwable -> Lc7
                if (r6 >= r8) goto L67
                android.content.pm.Signature r8 = new android.content.pm.Signature     // Catch: java.lang.Throwable -> Lc7
                r9 = r10[r6]     // Catch: java.lang.Throwable -> Lc7
                r9 = r9[r2]     // Catch: java.lang.Throwable -> Lc7
                byte[] r9 = r9.getEncoded()     // Catch: java.lang.Throwable -> Lc7
                r8.<init>(r9)     // Catch: java.lang.Throwable -> Lc7
                r11[r6] = r8     // Catch: java.lang.Throwable -> Lc7
                int r6 = r6 + 1
                goto L52
            L67:
                r10 = 2
                goto L7f
            L69:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r9 = "摘要校验V1! 强制V1:"
                r8.<init>(r9)     // Catch: java.lang.Throwable -> Lc7
                r8.append(r6)     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> Lc7
                com.uc.webview.export.internal.utility.Log.d(r3, r6)     // Catch: java.lang.Throwable -> Lc7
                android.content.pm.Signature[] r11 = b(r10, r11)     // Catch: java.lang.Throwable -> Lc7
                r10 = 1
            L7f:
                if (r12 == 0) goto L96
                java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L95
                r7 = 10
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L95
                r6[r2] = r7     // Catch: java.lang.Throwable -> L95
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L95
                r6[r0] = r10     // Catch: java.lang.Throwable -> L95
                r12.onReceiveValue(r6)     // Catch: java.lang.Throwable -> L95
                goto L96
            L95:
            L96:
                if (r11 == 0) goto La5
                int r10 = r11.length     // Catch: java.lang.Throwable -> Lc7
                if (r10 <= 0) goto La5
                java.lang.String r10 = "摘要校验成功!"
                com.uc.webview.export.internal.utility.Log.d(r3, r10)     // Catch: java.lang.Throwable -> La2
                r1 = r11
                goto Laa
            La2:
                r10 = move-exception
                r1 = r11
                goto Lc8
            La5:
                java.lang.String r10 = "摘要校验失败"
                com.uc.webview.export.internal.utility.Log.e(r3, r10)     // Catch: java.lang.Throwable -> Lc7
            Laa:
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r11 = "耗时："
                r10.<init>(r11)     // Catch: java.lang.Throwable -> Lc7
                long r11 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc7
                long r11 = r11 - r4
                r10.append(r11)     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r11 = "ms"
                r10.append(r11)     // Catch: java.lang.Throwable -> Lc7
                java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lc7
                com.uc.webview.export.internal.utility.Log.i(r3, r10)     // Catch: java.lang.Throwable -> Lc7
                goto Ld2
            Lc7:
                r10 = move-exception
            Lc8:
                r10.printStackTrace()
                java.lang.String r10 = r10.getMessage()
                com.uc.webview.export.internal.utility.Log.e(r3, r10)
            Ld2:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.C7340l.C7341a.a(android.content.Context, java.lang.String, android.webkit.ValueCallback):android.content.pm.Signature[]");
        }

        static Signature[] a(byte[] bArr) throws Exception {
            X509Certificate[][] a = C7321a.a(ByteBuffer.wrap(bArr));
            Signature[] signatureArr = new Signature[a.length];
            for (int i = 0; i < a.length; i++) {
                signatureArr[i] = new Signature(a[i][0].getEncoded());
            }
            return signatureArr;
        }

        public static PublicKey[] a(Signature[] signatureArr) {
            if (signatureArr != null) {
                try {
                    if (signatureArr.length != 0) {
                        int length = signatureArr.length;
                        PublicKey[] publicKeyArr = new PublicKey[length];
                        for (int i = 0; i < length; i++) {
                            publicKeyArr[i] = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i].toByteArray()))).getPublicKey();
                        }
                        return publicKeyArr;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("SignatureVerifier", "获取公钥异常：\n" + e.getMessage());
                }
            }
            return null;
        }

        public static final boolean a(PublicKey[] publicKeyArr) {
            return publicKeyArr == null || publicKeyArr.length <= 0;
        }
    }

    public static boolean a(String str, Context context, Context context2, ValueCallback<Object[]> valueCallback, C7337j.C7338a c7338a) {
        StringBuilder sb;
        long currentTimeMillis;
        Signature[] a;
        StringBuilder sb2;
        StringBuilder sb3;
        if (new File(str).exists()) {
            Log.d("SignatureVerifier", "verify: file = " + str);
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                currentTimeMillis = System.currentTimeMillis();
                a = C7341a.a(context, str, valueCallback);
            } catch (Throwable th) {
                if (valueCallback != null) {
                    try {
                        valueCallback.onReceiveValue(new Object[]{8, Integer.valueOf(th.getClass().getName().hashCode())});
                    }
                }
                if (c7338a != null) {
                    c7338a.a(C7337j.C7338a.m);
                }
                if (c7338a != null) {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_SIG_VERIFY_EXCEPTION);
                }
                if (c7338a != null) {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_SIG_VERIFY_EXCEPTION_VALUE, C7337j.b(th.toString()));
                }
                th.printStackTrace();
                sb = new StringBuilder("Verify: total costs:");
            }
            if (a == null || a.length <= 0) {
                Log.d("SignatureVerifier", "verify: failed: Signatures of archive is empty. Costs " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(new Object[]{8, 1});
                }
                if (c7338a != null) {
                    c7338a.a(C7337j.C7338a.i);
                }
                sb3 = new StringBuilder("Verify: total costs:");
            } else {
                PublicKey[] a2 = C7341a.a(a);
                if (C7341a.a(a2)) {
                    Log.d("SignatureVerifier", "verify: failed: PublicKeys of archive is empty. Costs " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(new Object[]{8, 2});
                    }
                    if (c7338a != null) {
                        c7338a.a(C7337j.C7338a.j);
                    }
                    sb3 = new StringBuilder("Verify: total costs:");
                } else {
                    Log.d("SignatureVerifier", "verify: step 0: get PublicKeys of archive ok. Costs " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                    if (context2 != null) {
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (a(a2, C7341a.a(context, context2.getPackageName()))) {
                            Log.d("SignatureVerifier", "verify: step 1: get Signatures of app from current context and verify ok. Costs " + (System.currentTimeMillis() - currentTimeMillis3) + "ms.");
                            sb2 = new StringBuilder("Verify: total costs:");
                            sb2.append(System.currentTimeMillis() - currentTimeMillis2);
                            sb2.append("ms");
                            Log.d("SignatureVerifier", sb2.toString());
                            return true;
                        }
                        Log.d("SignatureVerifier", "verify: step 1: get Signatures of app from current context and verify failed. Costs " + (System.currentTimeMillis() - currentTimeMillis3) + "ms.");
                    }
                    long currentTimeMillis4 = System.currentTimeMillis();
                    if (a(a2, C7341a.a(Base64.decode("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", 2)))) {
                        Log.d("SignatureVerifier", "verify: step 2: get Signatures of app from hardcode app and verify ok. Costs " + (System.currentTimeMillis() - currentTimeMillis4) + "ms.");
                        sb2 = new StringBuilder("Verify: total costs:");
                        sb2.append(System.currentTimeMillis() - currentTimeMillis2);
                        sb2.append("ms");
                        Log.d("SignatureVerifier", sb2.toString());
                        return true;
                    }
                    Log.d("SignatureVerifier", "verify: step 2: get Signatures of app from hardcode app and verify failed. Costs " + (System.currentTimeMillis() - currentTimeMillis4) + "ms.");
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(new Object[]{8, 3});
                    }
                    sb = new StringBuilder("Verify: total costs:");
                    sb.append(System.currentTimeMillis() - currentTimeMillis2);
                    sb.append("ms");
                    Log.d("SignatureVerifier", sb.toString());
                    if (c7338a != null) {
                        c7338a.a(C7337j.C7338a.l);
                        return false;
                    }
                    return false;
                }
            }
            sb3.append(System.currentTimeMillis() - currentTimeMillis2);
            sb3.append("ms");
            Log.d("SignatureVerifier", sb3.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #0 {all -> 0x0057, blocks: (B:3:0x0005, B:5:0x000f, B:11:0x0019, B:13:0x0022, B:14:0x002a, B:16:0x0033, B:17:0x003b, B:23:0x004b, B:20:0x0043), top: B:30:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean a(java.security.PublicKey[] r8, android.content.pm.Signature[] r9) {
        /*
            java.lang.String r0 = "公钥校验错误：Implement.isEmpty(appPublicKeys) == true"
            java.lang.String r1 = "SignatureVerifier"
            r2 = 0
            java.security.PublicKey[] r9 = com.uc.webview.export.internal.utility.C7340l.C7341a.a(r9)     // Catch: java.lang.Throwable -> L57
            boolean r3 = com.uc.webview.export.internal.utility.C7340l.C7341a.a(r9)     // Catch: java.lang.Throwable -> L57
            if (r3 == 0) goto L13
            com.uc.webview.export.internal.utility.Log.d(r1, r0)     // Catch: java.lang.Throwable -> L57
            return r2
        L13:
            r3 = 1
            if (r9 == 0) goto L43
            if (r8 != 0) goto L19
            goto L43
        L19:
            java.util.HashSet r4 = new java.util.HashSet     // Catch: java.lang.Throwable -> L57
            r4.<init>()     // Catch: java.lang.Throwable -> L57
            int r5 = r9.length     // Catch: java.lang.Throwable -> L57
            r6 = 0
        L20:
            if (r6 >= r5) goto L2a
            r7 = r9[r6]     // Catch: java.lang.Throwable -> L57
            r4.add(r7)     // Catch: java.lang.Throwable -> L57
            int r6 = r6 + 1
            goto L20
        L2a:
            java.util.HashSet r9 = new java.util.HashSet     // Catch: java.lang.Throwable -> L57
            r9.<init>()     // Catch: java.lang.Throwable -> L57
            int r5 = r8.length     // Catch: java.lang.Throwable -> L57
            r6 = 0
        L31:
            if (r6 >= r5) goto L3b
            r7 = r8[r6]     // Catch: java.lang.Throwable -> L57
            r9.add(r7)     // Catch: java.lang.Throwable -> L57
            int r6 = r6 + 1
            goto L31
        L3b:
            boolean r8 = r4.equals(r9)     // Catch: java.lang.Throwable -> L57
            if (r8 == 0) goto L48
            r8 = 1
            goto L49
        L43:
            java.lang.String r8 = "Sign.equals: s1 == null || s2 == null"
            com.uc.webview.export.internal.utility.Log.e(r1, r8)     // Catch: java.lang.Throwable -> L57
        L48:
            r8 = 0
        L49:
            if (r8 != 0) goto L51
            java.lang.String r8 = "公钥校验错误：Implement.equals(appPublicKeys, archiveKeys) == false"
            com.uc.webview.export.internal.utility.Log.d(r1, r8)     // Catch: java.lang.Throwable -> L57
            return r2
        L51:
            java.lang.String r8 = "公钥校验正确!"
            com.uc.webview.export.internal.utility.Log.d(r1, r8)
            return r3
        L57:
            r8 = move-exception
            r8.printStackTrace()
            com.uc.webview.export.internal.utility.Log.d(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.C7340l.a(java.security.PublicKey[], android.content.pm.Signature[]):boolean");
    }
}
