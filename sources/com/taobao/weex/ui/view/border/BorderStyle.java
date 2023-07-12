package com.taobao.weex.ui.view.border;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import com.taobao.weex.dom.CSSShorthand;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
enum BorderStyle {
    SOLID,
    DASHED,
    DOTTED;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.weex.ui.view.border.BorderStyle$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle = iArr;
            try {
                iArr[BorderStyle.DOTTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$taobao$weex$ui$view$border$BorderStyle[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Shader getLineShader(float f, int i, CSSShorthand.EDGE edge) {
        int i2 = AnonymousClass1.$SwitchMap$com$taobao$weex$ui$view$border$BorderStyle[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
        } else if (edge != CSSShorthand.EDGE.LEFT && edge != CSSShorthand.EDGE.RIGHT) {
            if (edge == CSSShorthand.EDGE.TOP || edge == CSSShorthand.EDGE.BOTTOM) {
                return new LinearGradient(0.0f, 0.0f, f * 2.0f, 0.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
            }
        } else {
            return new LinearGradient(0.0f, 0.0f, 0.0f, f * 2.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
        }
        if (edge != CSSShorthand.EDGE.LEFT && edge != CSSShorthand.EDGE.RIGHT) {
            if (edge == CSSShorthand.EDGE.TOP || edge == CSSShorthand.EDGE.BOTTOM) {
                return new LinearGradient(0.0f, 0.0f, 6.0f * f, 0.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
            }
            return null;
        }
        return new LinearGradient(0.0f, 0.0f, 0.0f, f * 6.0f, new int[]{i, 0}, new float[]{0.5f, 0.5f}, Shader.TileMode.REPEAT);
    }
}
