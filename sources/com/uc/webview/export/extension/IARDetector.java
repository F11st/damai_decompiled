package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.interfaces.InvokeObject;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public interface IARDetector {

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public static class ARDetector implements IARDetector {
        protected ResultListener mListener = null;

        @Override // com.uc.webview.export.extension.IARDetector
        public String getVersion() {
            return "-1";
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void init(int i, int i2, int i3, int i4, int i5) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public final boolean isDetector() {
            return true;
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void pause() {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void removeMarkers() {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void resume() {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void setARSessionFrame(ARSessionFrame aRSessionFrame) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public final String setARSessionFrameFilter(ARSessionFrame aRSessionFrame) {
            return null;
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void setMarkers(String[] strArr) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void setOption(String str) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void setResultListener(ResultListener resultListener) {
            this.mListener = resultListener;
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void stop() {
        }
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public static class ARFilter implements IARDetector {
        protected ResultListener mListener = null;

        @Override // com.uc.webview.export.extension.IARDetector
        public String getVersion() {
            return "-1";
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void init(int i, int i2, int i3, int i4, int i5) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public final boolean isDetector() {
            return false;
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void pause() {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void removeMarkers() {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void resume() {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public final void setARSessionFrame(ARSessionFrame aRSessionFrame) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public String setARSessionFrameFilter(ARSessionFrame aRSessionFrame) {
            return "";
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void setMarkers(String[] strArr) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void setOption(String str) {
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void setResultListener(ResultListener resultListener) {
            this.mListener = resultListener;
        }

        @Override // com.uc.webview.export.extension.IARDetector
        public void stop() {
        }
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public static class ARSessionFrame {
        public byte[] data;
        public int format;
        public int frameId;
        public int height;
        public int imageRotation;
        public int rotation;
        public int width;
    }

    /* compiled from: Taobao */
    @Api
    /* loaded from: classes11.dex */
    public interface ResultListener extends InvokeObject {
        void onInit(int i);

        void onResult(String str);

        void onResult(String str, Object obj);
    }

    String getVersion();

    void init(int i, int i2, int i3, int i4, int i5);

    boolean isDetector();

    void pause();

    void removeMarkers();

    void resume();

    void setARSessionFrame(ARSessionFrame aRSessionFrame);

    String setARSessionFrameFilter(ARSessionFrame aRSessionFrame);

    void setMarkers(String[] strArr);

    void setOption(String str);

    void setResultListener(ResultListener resultListener);

    void stop();
}
