package com.youku.resource.utils;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PaletteUtils {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface IPaletteListener {
        void onDominantColor(int i);
    }

    public static void getDominantColor(Bitmap bitmap, final IPaletteListener iPaletteListener) {
        if (bitmap == null || iPaletteListener == null) {
            return;
        }
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() { // from class: com.youku.resource.utils.PaletteUtils.1
            @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
            public void onGenerated(@NonNull Palette palette) {
                if (UIMode.getInstance().isDarkMode() || palette == null || palette.getDominantSwatch() == null) {
                    return;
                }
                float[] hsl = palette.getDominantSwatch().getHsl();
                if (hsl[1] <= 0.1f) {
                    hsl[1] = 0.05f;
                    hsl[2] = 0.9f;
                } else {
                    hsl[1] = 0.6f;
                    hsl[2] = 0.8f;
                }
                int HSLToColor = ColorUtils.HSLToColor(hsl);
                IPaletteListener iPaletteListener2 = IPaletteListener.this;
                if (iPaletteListener2 != null) {
                    iPaletteListener2.onDominantColor(HSLToColor);
                }
            }
        });
    }
}
