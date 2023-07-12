package com.taobao.weex.appfram.clipboard;

import android.content.ClipData;
import android.content.Context;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXClipboardModule extends WXModule implements IWXClipboard {
    private static final String DATA = "data";
    private static final String RESULT = "result";
    private static final String RESULT_FAILED = "failed";
    private static final String RESULT_OK = "success";
    private final String CLIP_KEY = "WEEX_CLIP_KEY_MAIN";

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
        if (r7 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0085, code lost:
        if (r7 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008c, code lost:
        return r0.toString();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.CharSequence coerceToText(android.content.Context r7, android.content.ClipData.Item r8) {
        /*
            r6 = this;
            java.lang.CharSequence r0 = r8.getText()
            if (r0 == 0) goto L7
            return r0
        L7:
            android.net.Uri r0 = r8.getUri()
            r1 = 0
            if (r0 == 0) goto L8d
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58 java.io.FileNotFoundException -> L7d
            java.lang.String r8 = "text/*"
            android.content.res.AssetFileDescriptor r7 = r7.openTypedAssetFileDescriptor(r0, r8, r1)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58 java.io.FileNotFoundException -> L7d
            java.io.FileInputStream r7 = r7.createInputStream()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58 java.io.FileNotFoundException -> L7d
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e java.io.FileNotFoundException -> L53
            java.lang.String r2 = "UTF-8"
            r8.<init>(r7, r2)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L4e java.io.FileNotFoundException -> L53
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L48 java.io.FileNotFoundException -> L4a java.lang.Throwable -> L6e
            r2 = 128(0x80, float:1.8E-43)
            r1.<init>(r2)     // Catch: java.io.IOException -> L48 java.io.FileNotFoundException -> L4a java.lang.Throwable -> L6e
            r2 = 8192(0x2000, float:1.148E-41)
            char[] r2 = new char[r2]     // Catch: java.io.IOException -> L48 java.io.FileNotFoundException -> L4a java.lang.Throwable -> L6e
        L2e:
            int r3 = r8.read(r2)     // Catch: java.io.IOException -> L48 java.io.FileNotFoundException -> L4a java.lang.Throwable -> L6e
            if (r3 <= 0) goto L39
            r4 = 0
            r1.append(r2, r4, r3)     // Catch: java.io.IOException -> L48 java.io.FileNotFoundException -> L4a java.lang.Throwable -> L6e
            goto L2e
        L39:
            java.lang.String r0 = r1.toString()     // Catch: java.io.IOException -> L48 java.io.FileNotFoundException -> L4a java.lang.Throwable -> L6e
            r8.close()     // Catch: java.io.IOException -> L41
            goto L42
        L41:
        L42:
            if (r7 == 0) goto L47
            r7.close()     // Catch: java.io.IOException -> L47
        L47:
            return r0
        L48:
            r1 = move-exception
            goto L5c
        L4a:
            r1 = r8
            goto L7e
        L4c:
            r0 = move-exception
            goto L70
        L4e:
            r8 = move-exception
            r5 = r1
            r1 = r8
            r8 = r5
            goto L5c
        L53:
            goto L7e
        L55:
            r0 = move-exception
            r7 = r1
            goto L70
        L58:
            r7 = move-exception
            r8 = r1
            r1 = r7
            r7 = r8
        L5c:
            java.lang.String r2 = "ClippedData Failure loading text."
            com.taobao.weex.utils.WXLogUtils.w(r2, r1)     // Catch: java.lang.Throwable -> L6e
            if (r8 == 0) goto L68
            r8.close()     // Catch: java.io.IOException -> L67
            goto L68
        L67:
        L68:
            if (r7 == 0) goto L88
        L6a:
            r7.close()     // Catch: java.io.IOException -> L88
            goto L88
        L6e:
            r0 = move-exception
            r1 = r8
        L70:
            if (r1 == 0) goto L77
            r1.close()     // Catch: java.io.IOException -> L76
            goto L77
        L76:
        L77:
            if (r7 == 0) goto L7c
            r7.close()     // Catch: java.io.IOException -> L7c
        L7c:
            throw r0
        L7d:
            r7 = r1
        L7e:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.io.IOException -> L84
            goto L85
        L84:
        L85:
            if (r7 == 0) goto L88
            goto L6a
        L88:
            java.lang.String r7 = r0.toString()
            return r7
        L8d:
            android.content.Intent r7 = r8.getIntent()
            if (r7 == 0) goto L99
            r8 = 1
            java.lang.String r7 = r7.toUri(r8)
            return r7
        L99:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.appfram.clipboard.WXClipboardModule.coerceToText(android.content.Context, android.content.ClipData$Item):java.lang.CharSequence");
    }

    @Override // com.taobao.weex.appfram.clipboard.IWXClipboard
    @JSMethod
    public void getString(@Nullable JSCallback jSCallback) {
        Context context = this.mWXSDKInstance.getContext();
        HashMap hashMap = new HashMap(2);
        ClipData primaryClip = ClipboardManager.getPrimaryClip((android.content.ClipboardManager) context.getSystemService("clipboard"));
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            CharSequence coerceToText = coerceToText(context, primaryClip.getItemAt(0));
            hashMap.put("result", coerceToText != null ? "success" : "failed");
            hashMap.put("data", coerceToText != null ? coerceToText : "");
        } else {
            hashMap.put("result", "failed");
            hashMap.put("data", "");
        }
        if (jSCallback != null) {
            jSCallback.invoke(hashMap);
        }
    }

    @Override // com.taobao.weex.appfram.clipboard.IWXClipboard
    @JSMethod
    public void setString(String str) {
        if (str == null) {
            return;
        }
        ((android.content.ClipboardManager) this.mWXSDKInstance.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("WEEX_CLIP_KEY_MAIN", str));
    }
}
