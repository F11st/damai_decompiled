package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class FlutterViewOverlay extends View {
    @Nullable
    private static FlutterViewOverlay overlay;

    private FlutterViewOverlay(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void createOverlay(@NonNull View view, @NonNull String str) {
        if (FlutterFPS.ENABLE) {
            removeOverlay();
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof FrameLayout)) {
                FlutterViewOverlay flutterViewOverlay = new FlutterViewOverlay(view.getContext());
                overlay = flutterViewOverlay;
                ((FrameLayout) parent).addView(flutterViewOverlay);
            }
            FlutterFPS.setRenderingMode(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onRenderViewDraw() {
        if (overlay == null || !FlutterFPS.calculate()) {
            return;
        }
        overlay.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeOverlay() {
        FlutterViewOverlay flutterViewOverlay = overlay;
        if (flutterViewOverlay != null) {
            ViewParent parent = flutterViewOverlay.getParent();
            if (parent != null && (parent instanceof FrameLayout)) {
                ((FrameLayout) parent).removeView(overlay);
            }
            overlay = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        FlutterFPS.draw(canvas, this, false);
    }
}
