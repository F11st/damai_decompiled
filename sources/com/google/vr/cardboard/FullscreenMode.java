package com.google.vr.cardboard;

import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FullscreenMode {
    private final Window a;

    public FullscreenMode(Window window) {
        this.a = window;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.a.getDecorView().setSystemUiVisibility(5894);
    }

    private void d() {
        if (Build.VERSION.SDK_INT < 19) {
            final Handler handler = new Handler();
            this.a.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.google.vr.cardboard.FullscreenMode.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if ((i & 2) == 0) {
                        handler.postDelayed(new Runnable() { // from class: com.google.vr.cardboard.FullscreenMode.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FullscreenMode.this.c();
                            }
                        }, 2000L);
                    }
                }
            });
        }
    }

    public void b() {
        c();
        d();
    }
}
