package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.huawei.hms.opendevice.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0087\u0002\u001a\r\u0010\u0002\u001a\u00020\b*\u00020\bH\u0086\n\u001a\r\u0010\u0003\u001a\u00020\b*\u00020\bH\u0086\n\u001a\r\u0010\u0004\u001a\u00020\b*\u00020\bH\u0086\n\u001a\r\u0010\u0005\u001a\u00020\b*\u00020\bH\u0086\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\bH\u0087\b\u001a\r\u0010\u000b\u001a\u00020\n*\u00020\bH\u0087\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\nH\u0087\n\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\nH\u0087\n\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\nH\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\nH\u0087\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\nH\u0087\b\u001a\r\u0010\f\u001a\u00020\b*\u00020\nH\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\n*\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\n*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0010H\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0010H\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0010H\u0087\f\u001a\r\u0010\f\u001a\u00020\b*\u00020\u0011H\u0087\b\"\u0018\u0010\u0014\u001a\u00020\b*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0018\u0010\u0016\u001a\u00020\b*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\"\u0018\u0010\u0018\u001a\u00020\b*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013\"\u0018\u0010\u001a\u001a\u00020\b*\u00020\b8Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013\"\u0018\u0010\u001d\u001a\u00020\u0001*\u00020\b8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0018\u0010\u0014\u001a\u00020\u0001*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u001e\"\u0018\u0010\u0016\u001a\u00020\u0001*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u001e\"\u0018\u0010\u0018\u001a\u00020\u0001*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001e\"\u0018\u0010\u001a\u001a\u00020\u0001*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001e\"\u0018\u0010\u001d\u001a\u00020\u0001*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001e\"\u0018\u0010 \u001a\u00020\u001f*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!\"\u0018\u0010\"\u001a\u00020\u001f*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010!\"\u0018\u0010\u000e\u001a\u00020\u0010*\u00020\n8Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroid/graphics/Color;", "", "component1", "component2", "component3", "component4", c.a, "plus", "", "toColor", "", "toColorLong", "toColorInt", "Landroid/graphics/ColorSpace$Named;", "colorSpace", "convertTo", "Landroid/graphics/ColorSpace;", "", "getAlpha", "(I)I", "alpha", "getRed", "red", "getGreen", "green", "getBlue", "blue", "getLuminance", "(I)F", "luminance", "(J)F", "", "isSrgb", "(J)Z", "isWideGamut", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(@NotNull Color color) {
        b41.i(color, "<this>");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(@NotNull Color color) {
        b41.i(color, "<this>");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(@NotNull Color color) {
        b41.i(color, "<this>");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(@NotNull Color color) {
        b41.i(color, "<this>");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, @NotNull ColorSpace.Named named) {
        b41.i(named, "colorSpace");
        return Color.convert(i, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    @NotNull
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = Color.colorSpace(j);
        b41.h(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return Color.green(j);
    }

    public static final int getGreen(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i) {
        return Color.luminance(i);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return Color.red(j);
    }

    public static final int getRed(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return Color.isWideGamut(j);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color plus(@NotNull Color color, @NotNull Color color2) {
        b41.i(color, "<this>");
        b41.i(color2, c.a);
        Color compositeColors = ColorUtils.compositeColors(color2, color);
        b41.h(compositeColors, "compositeColors(c, this)");
        return compositeColors;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(@ColorInt int i) {
        Color valueOf = Color.valueOf(i);
        b41.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j) {
        return Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i) {
        return Color.pack(i);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, @NotNull ColorSpace colorSpace) {
        b41.i(colorSpace, "colorSpace");
        return Color.convert(i, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return Color.luminance(j);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color toColor(long j) {
        Color valueOf = Color.valueOf(j);
        b41.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    @ColorInt
    public static final int toColorInt(@NotNull String str) {
        b41.i(str, "<this>");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, @NotNull ColorSpace.Named named) {
        b41.i(named, "colorSpace");
        return Color.convert(j, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, @NotNull ColorSpace colorSpace) {
        b41.i(colorSpace, "colorSpace");
        return Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace.Named named) {
        b41.i(color, "<this>");
        b41.i(named, "colorSpace");
        Color convert = color.convert(ColorSpace.get(named));
        b41.h(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @RequiresApi(26)
    @NotNull
    public static final Color convertTo(@NotNull Color color, @NotNull ColorSpace colorSpace) {
        b41.i(color, "<this>");
        b41.i(colorSpace, "colorSpace");
        Color convert = color.convert(colorSpace);
        b41.h(convert, "convert(colorSpace)");
        return convert;
    }
}
