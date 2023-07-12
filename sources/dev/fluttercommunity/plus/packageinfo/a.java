package dev.fluttercommunity.plus.packageinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.youku.upsplayer.util.YKUpsConvert;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @NotNull
    public static final C0403a Companion = new C0403a(null);
    @Nullable
    private Context a;
    @Nullable
    private MethodChannel b;

    /* compiled from: Taobao */
    /* renamed from: dev.fluttercommunity.plus.packageinfo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0403a {
        private C0403a() {
        }

        public /* synthetic */ C0403a(k50 k50Var) {
            this();
        }
    }

    private final String a(byte[] bArr) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};
        char[] cArr2 = new char[bArr.length * 2];
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            int i4 = i * 2;
            cArr2[i4] = cArr[i3 >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
            i = i2;
        }
        return new String(cArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        if ((r5.length == 0) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String b(android.content.pm.PackageManager r5) {
        /*
            r4 = this;
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La1
            r2 = 28
            if (r1 < r2) goto L5c
            android.content.Context r1 = r4.a     // Catch: java.lang.Throwable -> La1
            tb.b41.f(r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Throwable -> La1
            r2 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r1, r2)     // Catch: java.lang.Throwable -> La1
            android.content.pm.SigningInfo r5 = r5.signingInfo     // Catch: java.lang.Throwable -> La1
            if (r5 != 0) goto L1b
            return r0
        L1b:
            boolean r1 = r5.hasMultipleSigners()     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto L3e
            android.content.pm.Signature[] r5 = r5.getApkContentsSigners()     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = "signingInfo.apkContentsSigners"
            tb.b41.h(r5, r1)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r5 = kotlin.collections.e.u(r5)     // Catch: java.lang.Throwable -> La1
            android.content.pm.Signature r5 = (android.content.pm.Signature) r5     // Catch: java.lang.Throwable -> La1
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = "signingInfo.apkContentsS…ers.first().toByteArray()"
            tb.b41.h(r5, r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r5 = r4.d(r5)     // Catch: java.lang.Throwable -> La1
            goto L5a
        L3e:
            android.content.pm.Signature[] r5 = r5.getSigningCertificateHistory()     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = "signingInfo.signingCertificateHistory"
            tb.b41.h(r5, r1)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r5 = kotlin.collections.e.u(r5)     // Catch: java.lang.Throwable -> La1
            android.content.pm.Signature r5 = (android.content.pm.Signature) r5     // Catch: java.lang.Throwable -> La1
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = "signingInfo.signingCerti…ory.first().toByteArray()"
            tb.b41.h(r5, r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r5 = r4.d(r5)     // Catch: java.lang.Throwable -> La1
        L5a:
            r0 = r5
            goto La1
        L5c:
            android.content.Context r1 = r4.a     // Catch: java.lang.Throwable -> La1
            tb.b41.f(r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Throwable -> La1
            r2 = 64
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r1, r2)     // Catch: java.lang.Throwable -> La1
            android.content.pm.Signature[] r5 = r5.signatures     // Catch: java.lang.Throwable -> La1
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L79
            int r3 = r5.length     // Catch: java.lang.Throwable -> La1
            if (r3 != 0) goto L76
            r3 = 1
            goto L77
        L76:
            r3 = 0
        L77:
            if (r3 == 0) goto L7a
        L79:
            r1 = 1
        L7a:
            if (r1 != 0) goto La1
            java.lang.String r1 = "packageInfo.signatures"
            tb.b41.h(r5, r1)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r1 = kotlin.collections.e.u(r5)     // Catch: java.lang.Throwable -> La1
            if (r1 != 0) goto L88
            goto La1
        L88:
            java.lang.String r1 = "signatures"
            tb.b41.h(r5, r1)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r5 = kotlin.collections.e.u(r5)     // Catch: java.lang.Throwable -> La1
            android.content.pm.Signature r5 = (android.content.pm.Signature) r5     // Catch: java.lang.Throwable -> La1
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = "signatures.first().toByteArray()"
            tb.b41.h(r5, r1)     // Catch: java.lang.Throwable -> La1
            java.lang.String r5 = r4.d(r5)     // Catch: java.lang.Throwable -> La1
            goto L5a
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.fluttercommunity.plus.packageinfo.a.b(android.content.pm.PackageManager):java.lang.String");
    }

    private final long c(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return packageInfo.versionCode;
    }

    private final String d(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        b41.h(digest, "hashText");
        return a(digest);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        b41.i(flutterPluginBinding, "binding");
        this.a = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "dev.fluttercommunity.plus/package_info");
        this.b = methodChannel;
        b41.f(methodChannel);
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        b41.i(flutterPluginBinding, "binding");
        this.a = null;
        MethodChannel methodChannel = this.b;
        b41.f(methodChannel);
        methodChannel.setMethodCallHandler(null);
        this.b = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        b41.i(methodCall, "call");
        b41.i(result, "result");
        try {
            if (b41.d(methodCall.method, "getAll")) {
                Context context = this.a;
                b41.f(context);
                PackageManager packageManager = context.getPackageManager();
                Context context2 = this.a;
                b41.f(context2);
                PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
                b41.h(packageManager, "packageManager");
                String b = b(packageManager);
                HashMap hashMap = new HashMap();
                hashMap.put("appName", packageInfo.applicationInfo.loadLabel(packageManager).toString());
                Context context3 = this.a;
                b41.f(context3);
                hashMap.put("packageName", context3.getPackageName());
                hashMap.put("version", packageInfo.versionName);
                b41.h(packageInfo, "info");
                hashMap.put("buildNumber", String.valueOf(c(packageInfo)));
                if (b != null) {
                    hashMap.put("buildSignature", b);
                }
                result.success(hashMap);
                return;
            }
            result.notImplemented();
        } catch (PackageManager.NameNotFoundException e) {
            result.error("Name not found", e.getMessage(), null);
        }
    }
}
