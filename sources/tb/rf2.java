package tb;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class rf2 {
    public static final int FLAG_ADD_FUNCTIONALITY_ALL_DISABLE;
    public static final int FLAG_ADD_FUNCTIONALITY_DROP_DOWN_DISABLE;
    public static final int FLAG_ADD_FUNCTIONALITY_RESIZE_DISABLE;
    public static final int FLAG_BODY_MOVE_ENABLE;
    public static final int FLAG_DECORATION_CLOSE_DISABLE;
    public static final int FLAG_DECORATION_MAXIMIZE_DISABLE;
    public static final int FLAG_DECORATION_MOVE_DISABLE;
    public static final int FLAG_DECORATION_RESIZE_DISABLE;
    public static final int FLAG_DECORATION_SYSTEM;
    public static final int FLAG_FIX_COMPATIBILITY_ALL_DISABLE;
    public static final int FLAG_WINDOW_ASPECT_RATIO_ENABLE;
    public static final int FLAG_WINDOW_BRING_TO_FRONT_ON_TAP;
    public static final int FLAG_WINDOW_BRING_TO_FRONT_ON_TOUCH;
    public static final int FLAG_WINDOW_EDGE_LIMITS_ENABLE;
    public static final int FLAG_WINDOW_FOCUSABLE_DISABLE;
    public static final int FLAG_WINDOW_FOCUS_INDICATOR_DISABLE;
    public static final int FLAG_WINDOW_HIDE_ENABLE;
    public static final int FLAG_WINDOW_PINCH_RESIZE_ENABLE;
    private static int a;

    static {
        int i = 0 + 1;
        a = i;
        int i2 = 1 << 0;
        FLAG_DECORATION_SYSTEM = i2;
        int i3 = i + 1;
        a = i3;
        FLAG_DECORATION_CLOSE_DISABLE = (1 << i) | i2;
        int i4 = i3 + 1;
        a = i4;
        FLAG_DECORATION_RESIZE_DISABLE = (1 << i3) | i2;
        int i5 = i4 + 1;
        a = i5;
        FLAG_DECORATION_MAXIMIZE_DISABLE = (1 << i4) | i2;
        int i6 = i5 + 1;
        a = i6;
        FLAG_DECORATION_MOVE_DISABLE = i2 | (1 << i5);
        int i7 = i6 + 1;
        a = i7;
        FLAG_BODY_MOVE_ENABLE = 1 << i6;
        int i8 = i7 + 1;
        a = i8;
        FLAG_WINDOW_HIDE_ENABLE = 1 << i7;
        int i9 = i8 + 1;
        a = i9;
        FLAG_WINDOW_BRING_TO_FRONT_ON_TOUCH = 1 << i8;
        int i10 = i9 + 1;
        a = i10;
        FLAG_WINDOW_BRING_TO_FRONT_ON_TAP = 1 << i9;
        int i11 = i10 + 1;
        a = i11;
        FLAG_WINDOW_EDGE_LIMITS_ENABLE = 1 << i10;
        int i12 = i11 + 1;
        a = i12;
        FLAG_WINDOW_ASPECT_RATIO_ENABLE = 1 << i11;
        int i13 = i12 + 1;
        a = i13;
        FLAG_WINDOW_PINCH_RESIZE_ENABLE = 1 << i12;
        int i14 = i13 + 1;
        a = i14;
        FLAG_WINDOW_FOCUSABLE_DISABLE = 1 << i13;
        int i15 = i14 + 1;
        a = i15;
        FLAG_WINDOW_FOCUS_INDICATOR_DISABLE = 1 << i14;
        int i16 = i15 + 1;
        a = i16;
        FLAG_FIX_COMPATIBILITY_ALL_DISABLE = 1 << i15;
        int i17 = i16 + 1;
        a = i17;
        FLAG_ADD_FUNCTIONALITY_ALL_DISABLE = 1 << i16;
        int i18 = i17 + 1;
        a = i18;
        FLAG_ADD_FUNCTIONALITY_RESIZE_DISABLE = 1 << i17;
        a = i18 + 1;
        FLAG_ADD_FUNCTIONALITY_DROP_DOWN_DISABLE = 1 << i18;
    }
}
