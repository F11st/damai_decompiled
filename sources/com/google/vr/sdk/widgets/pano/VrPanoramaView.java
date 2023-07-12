package com.google.vr.sdk.widgets.pano;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import com.google.vr.cardboard.annotations.UsedByNative;
import com.google.vr.sdk.widgets.common.VrEventListener;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.sdk.widgets.common.VrWidgetView;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class VrPanoramaView extends VrWidgetView {
    private static final boolean DEBUG = false;
    private static final String TAG = VrPanoramaView.class.getSimpleName();
    private VrPanoramaEventListener eventListener;
    private VrPanoramaRenderer renderer;

    /* compiled from: Taobao */
    @UsedByNative
    /* loaded from: classes10.dex */
    public static class Options {
        public static final int TYPE_MONO = 1;
        public static final int TYPE_STEREO_OVER_UNDER = 2;
        @UsedByNative
        public int inputType = 1;

        void validate() {
            int i = this.inputType;
            if (i <= 0 || i >= 3) {
                String str = VrPanoramaView.TAG;
                int i2 = this.inputType;
                StringBuilder sb = new StringBuilder(38);
                sb.append("Invalid Options.inputType: ");
                sb.append(i2);
                Log.e(str, sb.toString());
                this.inputType = 1;
            }
        }
    }

    public VrPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eventListener = new VrPanoramaEventListener();
    }

    public void loadImageFromBitmap(Bitmap bitmap, Options options) {
        if (options == null) {
            options = new Options();
        } else {
            options.validate();
        }
        this.renderer.loadImageFromBitmap(bitmap, options, this.eventListener);
    }

    public void loadImageFromByteArray(byte[] bArr, Options options) {
        if (options == null) {
            options = new Options();
        } else {
            options.validate();
        }
        this.renderer.loadImageFromByteArray(bArr, options, this.eventListener);
    }

    public void setEventListener(VrPanoramaEventListener vrPanoramaEventListener) {
        super.setEventListener((VrEventListener) vrPanoramaEventListener);
        this.eventListener = vrPanoramaEventListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.vr.sdk.widgets.common.VrWidgetView
    public VrPanoramaRenderer createRenderer(Context context, VrWidgetRenderer.GLThreadScheduler gLThreadScheduler, float f, float f2) {
        VrPanoramaRenderer vrPanoramaRenderer = new VrPanoramaRenderer(getContext(), gLThreadScheduler, f, f2);
        this.renderer = vrPanoramaRenderer;
        return vrPanoramaRenderer;
    }

    public VrPanoramaView(Context context) {
        super(context);
        this.eventListener = new VrPanoramaEventListener();
    }
}
