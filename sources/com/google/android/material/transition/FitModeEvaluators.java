package com.google.android.material.transition;

import android.graphics.RectF;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.1
        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float lerp = TransitionUtils.lerp(f4, f6, f2, f3, f, true);
            float f8 = lerp / f4;
            float f9 = lerp / f6;
            return new FitModeResult(f8, f9, lerp, f5 * f8, lerp, f7 * f9);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.2
        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f;
            rectF.left += abs;
            rectF.right -= abs;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float lerp = TransitionUtils.lerp(f5, f7, f2, f3, f, true);
            float f8 = lerp / f5;
            float f9 = lerp / f7;
            return new FitModeResult(f8, f9, f4 * f8, lerp, f6 * f9, lerp);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };

    private FitModeEvaluators() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FitModeEvaluator get(int i, boolean z, RectF rectF, RectF rectF2) {
        if (i == 0) {
            return shouldAutoFitToWidth(z, rectF, rectF2) ? WIDTH : HEIGHT;
        } else if (i != 1) {
            if (i == 2) {
                return HEIGHT;
            }
            throw new IllegalArgumentException("Invalid fit mode: " + i);
        } else {
            return WIDTH;
        }
    }

    private static boolean shouldAutoFitToWidth(boolean z, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f = (height2 * width) / width2;
        float f2 = (width2 * height) / width;
        if (z) {
            if (f >= height) {
                return true;
            }
        } else if (f2 >= height2) {
            return true;
        }
        return false;
    }
}
