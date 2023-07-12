package com.uc.webview.export.extension;

import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class ExtImageDecoder {

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public static class ExtImageDecoderParam {
        public String format = "";
        public String version = "";
        public String decoderPath = "";
        public String[] dependedPath = null;
        public String filenameExtension = "";
        public int headerLength = 0;
        public boolean progressiveDecode = true;
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public interface ImageDecoderListener extends InvokeObject {
        void onDecode(String str, String str2, int i);

        void onInit(int i);
    }

    public static void requestExtImageDecoderResult() {
        UCMobileWebKit uCMobileWebKit;
        if (WebView.getCoreType() != 3 || (uCMobileWebKit = SDKFactory.d) == null) {
            return;
        }
        try {
            uCMobileWebKit.invoke(106, null);
        } catch (AbstractMethodError unused) {
        }
    }

    public static void setExtImageDecoder(ExtImageDecoderParam extImageDecoderParam, ImageDecoderListener imageDecoderListener) {
        if (imageDecoderListener == null) {
            return;
        }
        if (WebView.getCoreType() == 3 && SDKFactory.d != null) {
            try {
                SDKFactory.d.invoke(105, new Object[]{extImageDecoderParam, new a(imageDecoderListener), new b(imageDecoderListener)});
                return;
            } catch (AbstractMethodError unused) {
                return;
            }
        }
        imageDecoderListener.onInit(3);
    }
}
