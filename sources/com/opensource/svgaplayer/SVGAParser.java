package com.opensource.svgaplayer;

import android.content.Context;
import android.os.Handler;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.weex.bridge.WXBridgeManager;
import com.uc.webview.export.media.MessageID;
import io.flutter.wpkbridge.WPKFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.eh2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class SVGAParser {
    @NotNull
    private FileDownloader a;
    private final Context b;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class FileDownloader {
        private boolean a;

        public final boolean a() {
            return this.a;
        }

        public void b(@NotNull final URL url, @NotNull final Function1<? super InputStream, wt2> function1, @NotNull final Function1<? super Exception, wt2> function12) {
            b41.j(url, "url");
            b41.j(function1, "complete");
            b41.j(function12, AKBaseAbility.CALLBACK_FAILURE);
            new Thread(new Runnable() { // from class: com.opensource.svgaplayer.SVGAParser$FileDownloader$resume$1
                /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[Catch: all -> 0x007e, Exception -> 0x0081, TRY_ENTER, TryCatch #11 {Exception -> 0x0081, all -> 0x007e, blocks: (B:17:0x0043, B:18:0x0045, B:20:0x004c, B:22:0x005c, B:36:0x0076, B:37:0x0079, B:38:0x007a), top: B:83:0x0043 }] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x008c A[Catch: all -> 0x0090, Exception -> 0x0092, TRY_ENTER, TryCatch #12 {Exception -> 0x0092, all -> 0x0090, blocks: (B:15:0x003c, B:23:0x005f, B:49:0x008c, B:50:0x008f), top: B:82:0x003c }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        r8 = this;
                        java.lang.String r0 = "SVGAParser"
                        android.net.http.HttpResponseCache r1 = android.net.http.HttpResponseCache.getInstalled()     // Catch: java.lang.Exception -> La6
                        if (r1 != 0) goto L1a
                        com.opensource.svgaplayer.SVGAParser$FileDownloader r1 = com.opensource.svgaplayer.SVGAParser.FileDownloader.this     // Catch: java.lang.Exception -> La6
                        boolean r1 = r1.a()     // Catch: java.lang.Exception -> La6
                        if (r1 != 0) goto L1a
                        java.lang.String r1 = "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache"
                        android.util.Log.e(r0, r1)     // Catch: java.lang.Exception -> La6
                        java.lang.String r1 = "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache "
                        android.util.Log.e(r0, r1)     // Catch: java.lang.Exception -> La6
                    L1a:
                        java.net.URL r0 = r2     // Catch: java.lang.Exception -> La6
                        java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Exception -> La6
                        boolean r1 = r0 instanceof java.net.HttpURLConnection     // Catch: java.lang.Exception -> La6
                        if (r1 != 0) goto L25
                        r0 = 0
                    L25:
                        java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Exception -> La6
                        if (r0 == 0) goto Laf
                        r1 = 20000(0x4e20, float:2.8026E-41)
                        r0.setConnectTimeout(r1)     // Catch: java.lang.Exception -> La6
                        java.lang.String r1 = "GET"
                        r0.setRequestMethod(r1)     // Catch: java.lang.Exception -> La6
                        r0.connect()     // Catch: java.lang.Exception -> La6
                        java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Exception -> La6
                        r1 = 1
                        r2 = 0
                        java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
                        r3.<init>()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
                        r4 = 4096(0x1000, float:5.74E-42)
                        byte[] r5 = new byte[r4]     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                    L45:
                        int r6 = r0.read(r5, r2, r4)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                        r7 = -1
                        if (r6 != r7) goto L7a
                        java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                        byte[] r5 = r3.toByteArray()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                        r4.<init>(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                        kotlin.jvm.functions.Function1 r5 = r3     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
                        r5.invoke(r4)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
                        tb.wt2 r5 = tb.wt2.INSTANCE     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
                        r4.close()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                        r3.close()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
                        if (r0 == 0) goto Laf
                        r0.close()     // Catch: java.lang.Exception -> La6
                        goto Laf
                    L68:
                        r5 = move-exception
                        r6 = 0
                        goto L74
                    L6b:
                        r5 = move-exception
                        r4.close()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
                        goto L73
                    L70:
                        r5 = move-exception
                        r6 = 1
                        goto L74
                    L73:
                        throw r5     // Catch: java.lang.Throwable -> L70
                    L74:
                        if (r6 != 0) goto L79
                        r4.close()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                    L79:
                        throw r5     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                    L7a:
                        r3.write(r5, r2, r6)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
                        goto L45
                    L7e:
                        r4 = move-exception
                        r5 = 0
                        goto L8a
                    L81:
                        r4 = move-exception
                        r3.close()     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L89
                        goto L89
                    L86:
                        r4 = move-exception
                        r5 = 1
                        goto L8a
                    L89:
                        throw r4     // Catch: java.lang.Throwable -> L86
                    L8a:
                        if (r5 != 0) goto L8f
                        r3.close()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
                    L8f:
                        throw r4     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
                    L90:
                        r1 = move-exception
                        goto L9e
                    L92:
                        r2 = move-exception
                        if (r0 == 0) goto L9d
                        r0.close()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9d
                        goto L9d
                    L99:
                        r2 = move-exception
                        r1 = r2
                        r2 = 1
                        goto L9e
                    L9d:
                        throw r2     // Catch: java.lang.Throwable -> L99
                    L9e:
                        if (r2 != 0) goto La5
                        if (r0 == 0) goto La5
                        r0.close()     // Catch: java.lang.Exception -> La6
                    La5:
                        throw r1     // Catch: java.lang.Exception -> La6
                    La6:
                        r0 = move-exception
                        r0.printStackTrace()
                        kotlin.jvm.functions.Function1 r1 = r4
                        r1.invoke(r0)
                    Laf:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser$FileDownloader$resume$1.run():void");
                }
            }).start();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "Ltb/wt2;", "onComplete", MessageID.onError, "library_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes10.dex */
    public interface ParseCompletion {
        void onComplete(@NotNull SVGAVideoEntity sVGAVideoEntity);

        void onError();
    }

    public SVGAParser(@NotNull Context context) {
        b41.j(context, WPKFactory.INIT_KEY_CONTEXT);
        this.b = context;
        this.a = new FileDownloader();
    }

    private final File d(String str) {
        return new File(this.b.getCacheDir().getAbsolutePath() + "/" + str + "/");
    }

    private final String e(String str) {
        byte[] digest;
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        Charset forName = Charset.forName("UTF-8");
        b41.e(forName, "Charset.forName(charsetName)");
        if (str != null) {
            byte[] bytes = str.getBytes(forName);
            b41.e(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            String str2 = "";
            for (byte b : messageDigest.digest()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                eh2 eh2Var = eh2.INSTANCE;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                b41.e(format, "java.lang.String.format(format, *args)");
                sb.append(format);
                str2 = sb.toString();
            }
            return str2;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(URL url) {
        String url2 = url.toString();
        b41.e(url2, "url.toString()");
        return e(url2);
    }

    private final byte[] g(byte[] bArr) {
        try {
            Inflater inflater = new Inflater();
            inflater.setInput(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int inflate = inflater.inflate(bArr2, 0, 2048);
                    if (inflate <= 0) {
                        inflater.end();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, inflate);
                } catch (Exception e) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused) {
                    }
                    throw e;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052 A[Catch: Exception -> 0x0056, all -> 0x013d, TRY_ENTER, TryCatch #6 {Exception -> 0x0056, blocks: (B:18:0x0036, B:20:0x0040, B:31:0x0052, B:32:0x0055), top: B:125:0x0036, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd A[Catch: Exception -> 0x00c1, all -> 0x013d, TRY_ENTER, TryCatch #20 {, blocks: (B:16:0x002c, B:18:0x0036, B:20:0x0040, B:31:0x0052, B:32:0x0055, B:35:0x005a, B:40:0x0093, B:42:0x00aa, B:54:0x00bd, B:55:0x00c0, B:59:0x00c9, B:64:0x00da, B:72:0x0100, B:97:0x0129, B:98:0x012c, B:100:0x012e, B:101:0x0134, B:57:0x00c2, B:58:0x00c8, B:103:0x0136, B:34:0x0057), top: B:137:0x002c, inners: #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0117 A[Catch: all -> 0x011b, Exception -> 0x011d, TRY_ENTER, TryCatch #19 {Exception -> 0x011d, all -> 0x011b, blocks: (B:65:0x00df, B:71:0x00fd, B:86:0x0117, B:87:0x011a), top: B:145:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129 A[Catch: Exception -> 0x012d, all -> 0x013d, TRY_ENTER, TryCatch #2 {Exception -> 0x012d, blocks: (B:64:0x00da, B:72:0x0100, B:73:0x0103, B:97:0x0129, B:98:0x012c), top: B:124:0x00da }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.opensource.svgaplayer.SVGAVideoEntity h(java.io.InputStream r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.h(java.io.InputStream, java.lang.String):com.opensource.svgaplayer.SVGAVideoEntity");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f A[Catch: Exception -> 0x0073, all -> 0x00e7, TRY_ENTER, TryCatch #5 {, blocks: (B:5:0x000a, B:11:0x0045, B:13:0x005c, B:25:0x006f, B:26:0x0072, B:30:0x007b, B:35:0x008c, B:43:0x00b2, B:68:0x00db, B:69:0x00de, B:71:0x00e0, B:72:0x00e6, B:28:0x0074, B:29:0x007a, B:76:0x00ea), top: B:89:0x000a, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c9 A[Catch: all -> 0x00cd, Exception -> 0x00cf, TRY_ENTER, TryCatch #16 {Exception -> 0x00cf, all -> 0x00cd, blocks: (B:36:0x0091, B:42:0x00af, B:57:0x00c9, B:58:0x00cc), top: B:97:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00db A[Catch: Exception -> 0x00df, all -> 0x00e7, TRY_ENTER, TryCatch #5 {, blocks: (B:5:0x000a, B:11:0x0045, B:13:0x005c, B:25:0x006f, B:26:0x0072, B:30:0x007b, B:35:0x008c, B:43:0x00b2, B:68:0x00db, B:69:0x00de, B:71:0x00e0, B:72:0x00e6, B:28:0x0074, B:29:0x007a, B:76:0x00ea), top: B:89:0x000a, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.opensource.svgaplayer.SVGAVideoEntity l(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.l(java.lang.String):com.opensource.svgaplayer.SVGAVideoEntity");
    }

    private final byte[] m(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr, 0, 2048);
                    if (read <= 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                throw e;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b A[Catch: all -> 0x0068, Exception -> 0x006b, TRY_ENTER, TryCatch #12 {Exception -> 0x006b, all -> 0x0068, blocks: (B:6:0x0013, B:8:0x0019, B:11:0x0028, B:17:0x0042, B:30:0x005b, B:31:0x005e, B:32:0x005f), top: B:75:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076 A[Catch: all -> 0x007a, Exception -> 0x007c, TRY_ENTER, TryCatch #11 {Exception -> 0x007c, all -> 0x007a, blocks: (B:5:0x000e, B:33:0x0061, B:45:0x0076, B:46:0x0079), top: B:76:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0088 A[Catch: Exception -> 0x008c, TRY_ENTER, TryCatch #2 {Exception -> 0x008c, blocks: (B:3:0x0007, B:34:0x0064, B:56:0x0088, B:57:0x008b), top: B:65:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void n(java.io.InputStream r9, java.lang.String r10) {
        /*
            r8 = this;
            java.io.File r10 = r8.d(r10)
            r10.mkdirs()
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L8c
            r0.<init>(r9)     // Catch: java.lang.Exception -> L8c
            r9 = 1
            r1 = 0
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
        L13:
            java.util.zip.ZipEntry r3 = r2.getNextEntry()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r3 == 0) goto L5f
            java.lang.String r4 = r3.getName()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            java.lang.String r5 = "/"
            r6 = 2
            r7 = 0
            boolean r4 = kotlin.text.g.K(r4, r5, r1, r6, r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r4 == 0) goto L28
            goto L13
        L28:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r4.<init>(r10, r3)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r4 = 2048(0x800, float:2.87E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
        L3a:
            int r5 = r2.read(r4)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            if (r5 > 0) goto L49
            tb.wt2 r4 = tb.wt2.INSTANCE     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            r3.close()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r2.closeEntry()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            goto L13
        L49:
            r3.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            goto L3a
        L4d:
            r4 = move-exception
            r5 = 0
            goto L59
        L50:
            r4 = move-exception
            r3.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            goto L58
        L55:
            r4 = move-exception
            r5 = 1
            goto L59
        L58:
            throw r4     // Catch: java.lang.Throwable -> L55
        L59:
            if (r5 != 0) goto L5e
            r3.close()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
        L5e:
            throw r4     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
        L5f:
            tb.wt2 r3 = tb.wt2.INSTANCE     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            r2.close()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
            r0.close()     // Catch: java.lang.Exception -> L8c
            goto L8f
        L68:
            r3 = move-exception
            r4 = 0
            goto L74
        L6b:
            r3 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L73
            goto L73
        L70:
            r3 = move-exception
            r4 = 1
            goto L74
        L73:
            throw r3     // Catch: java.lang.Throwable -> L70
        L74:
            if (r4 != 0) goto L79
            r2.close()     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
        L79:
            throw r3     // Catch: java.lang.Throwable -> L7a java.lang.Exception -> L7c
        L7a:
            r9 = move-exception
            goto L86
        L7c:
            r1 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L85
            goto L85
        L81:
            r1 = move-exception
            r9 = r1
            r1 = 1
            goto L86
        L85:
            throw r1     // Catch: java.lang.Throwable -> L81
        L86:
            if (r1 != 0) goto L8b
            r0.close()     // Catch: java.lang.Exception -> L8c
        L8b:
            throw r9     // Catch: java.lang.Exception -> L8c
        L8c:
            r10.delete()
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser.n(java.io.InputStream, java.lang.String):void");
    }

    public final void i(@NotNull InputStream inputStream, @NotNull String str, @NotNull ParseCompletion parseCompletion, boolean z) {
        b41.j(inputStream, "inputStream");
        b41.j(str, "cacheKey");
        b41.j(parseCompletion, WXBridgeManager.METHOD_CALLBACK);
        new Thread(new SVGAParser$parse$5(this, inputStream, str, z, parseCompletion)).start();
    }

    public final void j(@NotNull String str, @NotNull ParseCompletion parseCompletion) {
        b41.j(str, "assetsName");
        b41.j(parseCompletion, WXBridgeManager.METHOD_CALLBACK);
        try {
            InputStream open = this.b.getAssets().open(str);
            if (open != null) {
                i(open, e("file:///assets/" + str), parseCompletion, true);
            }
        } catch (Exception unused) {
        }
    }

    public final void k(@NotNull URL url, @NotNull final ParseCompletion parseCompletion) {
        final SVGAVideoEntity l;
        b41.j(url, "url");
        b41.j(parseCompletion, WXBridgeManager.METHOD_CALLBACK);
        if (d(f(url)).exists() && (l = l(f(url))) != null) {
            new Handler(this.b.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAParser$parse$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    parseCompletion.onComplete(SVGAVideoEntity.this);
                }
            });
        } else {
            this.a.b(url, new SVGAParser$parse$3(this, url, parseCompletion), new Function1<Exception, wt2>() { // from class: com.opensource.svgaplayer.SVGAParser$parse$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(Exception exc) {
                    invoke2(exc);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Exception exc) {
                    Context context;
                    b41.j(exc, AdvanceSetting.NETWORK_TYPE);
                    context = SVGAParser.this.b;
                    new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAParser$parse$4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            parseCompletion.onError();
                        }
                    });
                }
            });
        }
    }
}
