package com.alibaba.youku.webp4pexode;

import android.os.Build;
import com.taobao.pexode.mimetype.MimeType;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WebpMimeType {
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static final int MAX_WEBP_HEADER_SIZE = 21;
    public static final MimeType WEBPD = new MimeType("WEBP", "WEBPD", true, new String[]{"WEBPD"}, new MimeType.MimeTypeChecker() { // from class: com.alibaba.youku.webp4pexode.WebpMimeType.1
        private boolean webpSupportRequired(byte[] bArr, int i, int i2) {
            WebpImageType webpImageType;
            new WebpHeaderParser();
            try {
                webpImageType = WebpHeaderParser.getType(bArr, i, i2);
            } catch (IOException unused) {
                webpImageType = WebpImageType.NONE_WEBP;
            }
            return Build.VERSION.SDK_INT >= 17 && WebpHeaderParser.isAnimatedWebpType(webpImageType);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return webpSupportRequired(bArr, 0, 21);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 21;
        }
    });
}
