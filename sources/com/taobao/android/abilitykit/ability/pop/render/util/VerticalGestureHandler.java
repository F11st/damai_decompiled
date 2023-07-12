package com.taobao.android.abilitykit.ability.pop.render.util;

import android.view.View;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class VerticalGestureHandler implements IGestureHandler {
    private int a;
    @NonNull
    private final Callback b;
    private boolean c;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.abilitykit.ability.pop.render.util.VerticalGestureHandler$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$state;
        final /* synthetic */ View val$touchedView;

        AnonymousClass1(View view, int i) {
            this.val$touchedView = view;
            this.val$state = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            VerticalGestureHandler.this.b.onStateChanged(this.val$touchedView, this.val$state);
            if (VerticalGestureHandler.this.c) {
                VerticalGestureHandler.this.b.onCloseBlocked(this.val$touchedView);
                VerticalGestureHandler.this.c = false;
            }
            VerticalGestureHandler.this.a = this.val$state;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Callback {
        boolean canContentViewScrollVertical(int i);

        boolean isAnimating();

        boolean isPanEnabled();

        void onCloseBlocked(@NonNull View view);

        void onStateChanged(@NonNull View view, int i);
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface State {
        public static final int ANIMATING = 4;
        public static final int CLOSED = 3;
        public static final int COLLAPSE = 2;
        public static final int EXPAND = 1;
        public static final int INIT = 0;
    }
}
