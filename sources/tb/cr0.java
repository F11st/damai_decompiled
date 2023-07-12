package tb;

import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.common.Constants;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.youku.live.dsl.danmaku.DanmakuItemBuilder;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hs0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class cr0 {
    @NotNull
    public static final cr0 INSTANCE = new cr0();

    private cr0() {
    }

    @Nullable
    public final AlignContent a(@NotNull String str) {
        b41.i(str, "target");
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    return AlignContent.Stretch;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    return AlignContent.Center;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    return AlignContent.FlexStart;
                }
                break;
            case 441309761:
                if (str.equals("space-between")) {
                    return AlignContent.SpaceBetween;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    return AlignContent.FlexEnd;
                }
                break;
            case 1937124468:
                if (str.equals("space-around")) {
                    return AlignContent.SpaceAround;
                }
                break;
        }
        return null;
    }

    @Nullable
    public final AlignItems b(@NotNull String str) {
        b41.i(str, "target");
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    return AlignItems.Stretch;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    return AlignItems.Baseline;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    return AlignItems.Center;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    return AlignItems.FlexStart;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    return AlignItems.FlexEnd;
                }
                break;
        }
        return null;
    }

    @Nullable
    public final AlignSelf c(@NotNull String str) {
        b41.i(str, "target");
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    return AlignSelf.Stretch;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    return AlignSelf.Baseline;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    return AlignSelf.Center;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    return AlignSelf.FlexStart;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    return AlignSelf.Auto;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    return AlignSelf.FlexEnd;
                }
                break;
        }
        return null;
    }

    @Nullable
    public final Float d(@NotNull String str) {
        boolean K;
        List t0;
        b41.i(str, "ratio");
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (Exception unused) {
            try {
                K = StringsKt__StringsKt.K(str, ":", false, 2, null);
                if (K) {
                    t0 = StringsKt__StringsKt.t0(str, new String[]{":"}, false, 0, 6, null);
                    return Float.valueOf(Float.parseFloat((String) t0.get(0)) / Float.parseFloat((String) t0.get(1)));
                }
            } catch (Exception unused2) {
            }
            return null;
        }
    }

    @Nullable
    public final lz1<hs0> e(@NotNull JSONObject jSONObject) {
        hs0 hs0Var;
        hs0 hs0Var2;
        hs0 hs0Var3;
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString("border");
        if (string != null) {
            hs0 d = hs0.Companion.d(string);
            return new lz1<>(d, d, d, d);
        }
        String string2 = jSONObject.getString("border-left");
        String string3 = jSONObject.getString("border-right");
        String string4 = jSONObject.getString("border-top");
        String string5 = jSONObject.getString("border-bottom");
        boolean z = false;
        hs0 hs0Var4 = null;
        if (string2 == null || string2.length() == 0) {
            if (string3 == null || string3.length() == 0) {
                if (string4 == null || string4.length() == 0) {
                    if (string5 == null || string5.length() == 0) {
                        return null;
                    }
                }
            }
        }
        if (string2 == null || string2.length() == 0) {
            hs0Var = null;
        } else {
            hs0.C9228b c9228b = hs0.Companion;
            b41.h(string2, "start");
            hs0Var = c9228b.d(string2);
        }
        if (string3 == null || string3.length() == 0) {
            hs0Var2 = null;
        } else {
            hs0.C9228b c9228b2 = hs0.Companion;
            b41.h(string3, "end");
            hs0Var2 = c9228b2.d(string3);
        }
        if (string4 == null || string4.length() == 0) {
            hs0Var3 = null;
        } else {
            hs0.C9228b c9228b3 = hs0.Companion;
            b41.h(string4, "top");
            hs0Var3 = c9228b3.d(string4);
        }
        if (!((string5 == null || string5.length() == 0) ? true : true)) {
            hs0.C9228b c9228b4 = hs0.Companion;
            b41.h(string5, "bottom");
            hs0Var4 = c9228b4.d(string5);
        }
        return new lz1<>(hs0Var, hs0Var2, hs0Var3, hs0Var4);
    }

    @Nullable
    public final Direction f(@NotNull String str) {
        b41.i(str, "target");
        int hashCode = str.hashCode();
        if (hashCode != 107498) {
            if (hashCode != 1728122231) {
                if (hashCode == 1946980603 && str.equals("inherit")) {
                    return Direction.Inherit;
                }
            } else if (str.equals("absolute")) {
                return Direction.RTL;
            }
        } else if (str.equals("ltr")) {
            return Direction.LTR;
        }
        return null;
    }

    @Nullable
    public final Display g(@NotNull String str) {
        b41.i(str, "target");
        if (b41.d(str, Constants.Name.FLEX)) {
            return Display.Flex;
        }
        if (b41.d(str, "none")) {
            return Display.None;
        }
        return null;
    }

    @NotNull
    public final hs0 h(@NotNull String str) {
        b41.i(str, "target");
        return hs0.Companion.d(str);
    }

    @Nullable
    public final FlexDirection i(@NotNull String str) {
        b41.i(str, "target");
        switch (str.hashCode()) {
            case -1448970769:
                if (str.equals("row-reverse")) {
                    return FlexDirection.RowReverse;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    return FlexDirection.Column;
                }
                break;
            case 113114:
                if (str.equals(DanmakuItemBuilder.KEY_ROW)) {
                    return FlexDirection.Row;
                }
                break;
            case 1272730475:
                if (str.equals("column-reverse")) {
                    return FlexDirection.ColumnReverse;
                }
                break;
        }
        return null;
    }

    public final float j(@NotNull String str) {
        b41.i(str, "target");
        return Float.parseFloat(str);
    }

    public final float k(@NotNull String str) {
        b41.i(str, "target");
        return Float.parseFloat(str);
    }

    @Nullable
    public final FlexWrap l(@NotNull String str) {
        b41.i(str, "target");
        int hashCode = str.hashCode();
        if (hashCode != -1039592053) {
            if (hashCode != -749527969) {
                if (hashCode == 3657802 && str.equals("wrap")) {
                    return FlexWrap.Wrap;
                }
            } else if (str.equals("wrap-reverse")) {
                return FlexWrap.WrapReverse;
            }
        } else if (str.equals("nowrap")) {
            return FlexWrap.NoWrap;
        }
        return null;
    }

    @Nullable
    public final JustifyContent m(@NotNull String str) {
        b41.i(str, "target");
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    return JustifyContent.Center;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    return JustifyContent.FlexStart;
                }
                break;
            case 441309761:
                if (str.equals("space-between")) {
                    return JustifyContent.SpaceBetween;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    return JustifyContent.FlexEnd;
                }
                break;
            case 1937124468:
                if (str.equals("space-around")) {
                    return JustifyContent.SpaceAround;
                }
                break;
            case 2055030478:
                if (str.equals("space-evenly")) {
                    return JustifyContent.SpaceEvenly;
                }
                break;
        }
        return null;
    }

    @Nullable
    public final lz1<hs0> n(@NotNull JSONObject jSONObject) {
        hs0 hs0Var;
        hs0 hs0Var2;
        hs0 hs0Var3;
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString(Constants.Name.MARGIN);
        if (string == null) {
            String string2 = jSONObject.getString(W3CStyleConstants.MARGIN_LEFT);
            String string3 = jSONObject.getString(W3CStyleConstants.MARGIN_RIGHT);
            String string4 = jSONObject.getString(W3CStyleConstants.MARGIN_TOP);
            String string5 = jSONObject.getString(W3CStyleConstants.MARGIN_BOTTOM);
            boolean z = false;
            hs0 hs0Var4 = null;
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        if (string5 == null || string5.length() == 0) {
                            return null;
                        }
                    }
                }
            }
            if (string2 == null || string2.length() == 0) {
                hs0Var = null;
            } else {
                hs0.C9228b c9228b = hs0.Companion;
                b41.h(string2, "start");
                hs0Var = c9228b.d(string2);
            }
            if (string3 == null || string3.length() == 0) {
                hs0Var2 = null;
            } else {
                hs0.C9228b c9228b2 = hs0.Companion;
                b41.h(string3, "end");
                hs0Var2 = c9228b2.d(string3);
            }
            if (string4 == null || string4.length() == 0) {
                hs0Var3 = null;
            } else {
                hs0.C9228b c9228b3 = hs0.Companion;
                b41.h(string4, "top");
                hs0Var3 = c9228b3.d(string4);
            }
            if (!((string5 == null || string5.length() == 0) ? true : true)) {
                hs0.C9228b c9228b4 = hs0.Companion;
                b41.h(string5, "bottom");
                hs0Var4 = c9228b4.d(string5);
            }
            return new lz1<>(hs0Var, hs0Var2, hs0Var3, hs0Var4);
        }
        hs0 d = hs0.Companion.d(string);
        return new lz1<>(d, d, d, d);
    }

    @Nullable
    public final ld2<hs0> o(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString("max-width");
        String string2 = jSONObject.getString("max-height");
        if (string == null && string2 == null) {
            return null;
        }
        return new ld2<>(string != null ? hs0.Companion.d(string) : null, string2 != null ? hs0.Companion.d(string2) : null);
    }

    @Nullable
    public final ld2<hs0> p(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString("min-width");
        String string2 = jSONObject.getString("min-height");
        if (string == null && string2 == null) {
            return null;
        }
        return new ld2<>(string != null ? hs0.Companion.d(string) : null, string2 != null ? hs0.Companion.d(string2) : null);
    }

    @Nullable
    public final Overflow q(@NotNull String str) {
        b41.i(str, "target");
        int hashCode = str.hashCode();
        if (hashCode != -1217487446) {
            if (hashCode != -907680051) {
                if (hashCode == 466743410 && str.equals("visible")) {
                    return Overflow.Visible;
                }
            } else if (str.equals("scroll")) {
                return Overflow.Scroll;
            }
        } else if (str.equals("hidden")) {
            return Overflow.Hidden;
        }
        return null;
    }

    @Nullable
    public final lz1<hs0> r(@NotNull JSONObject jSONObject) {
        hs0 hs0Var;
        hs0 hs0Var2;
        hs0 hs0Var3;
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString(Constants.Name.PADDING);
        if (string == null) {
            String string2 = jSONObject.getString(W3CStyleConstants.PADDING_LEFT);
            String string3 = jSONObject.getString(W3CStyleConstants.PADDING_RIGHT);
            String string4 = jSONObject.getString(W3CStyleConstants.PADDING_TOP);
            String string5 = jSONObject.getString(W3CStyleConstants.PADDING_BOTTOM);
            boolean z = false;
            hs0 hs0Var4 = null;
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        if (string5 == null || string5.length() == 0) {
                            return null;
                        }
                    }
                }
            }
            if (string2 == null || string2.length() == 0) {
                hs0Var = null;
            } else {
                hs0.C9228b c9228b = hs0.Companion;
                b41.h(string2, "start");
                hs0Var = c9228b.d(string2);
            }
            if (string3 == null || string3.length() == 0) {
                hs0Var2 = null;
            } else {
                hs0.C9228b c9228b2 = hs0.Companion;
                b41.h(string3, "end");
                hs0Var2 = c9228b2.d(string3);
            }
            if (string4 == null || string4.length() == 0) {
                hs0Var3 = null;
            } else {
                hs0.C9228b c9228b3 = hs0.Companion;
                b41.h(string4, "top");
                hs0Var3 = c9228b3.d(string4);
            }
            if (!((string5 == null || string5.length() == 0) ? true : true)) {
                hs0.C9228b c9228b4 = hs0.Companion;
                b41.h(string5, "bottom");
                hs0Var4 = c9228b4.d(string5);
            }
            return new lz1<>(hs0Var, hs0Var2, hs0Var3, hs0Var4);
        }
        hs0 d = hs0.Companion.d(string);
        return new lz1<>(d, d, d, d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
        if ((r12 == null || r12.length() == 0) == false) goto L27;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tb.lz1<tb.hs0> s(@org.jetbrains.annotations.NotNull com.alibaba.fastjson.JSONObject r12) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.cr0.s(com.alibaba.fastjson.JSONObject):tb.lz1");
    }

    @Nullable
    public final lz1<hs0> t(@NotNull JSONObject jSONObject) {
        hs0 hs0Var;
        hs0 hs0Var2;
        hs0 hs0Var3;
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString("left");
        String string2 = jSONObject.getString("right");
        String string3 = jSONObject.getString("top");
        String string4 = jSONObject.getString("bottom");
        boolean z = false;
        hs0 hs0Var4 = null;
        if (string == null || string.length() == 0) {
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        return null;
                    }
                }
            }
        }
        if (string == null || string.length() == 0) {
            hs0Var = null;
        } else {
            hs0.C9228b c9228b = hs0.Companion;
            b41.h(string, "start");
            hs0Var = c9228b.d(string);
        }
        if (string2 == null || string2.length() == 0) {
            hs0Var2 = null;
        } else {
            hs0.C9228b c9228b2 = hs0.Companion;
            b41.h(string2, "end");
            hs0Var2 = c9228b2.d(string2);
        }
        if (string3 == null || string3.length() == 0) {
            hs0Var3 = null;
        } else {
            hs0.C9228b c9228b3 = hs0.Companion;
            b41.h(string3, "top");
            hs0Var3 = c9228b3.d(string3);
        }
        if (!((string4 == null || string4.length() == 0) ? true : true)) {
            hs0.C9228b c9228b4 = hs0.Companion;
            b41.h(string4, "bottom");
            hs0Var4 = c9228b4.d(string4);
        }
        return new lz1<>(hs0Var, hs0Var2, hs0Var3, hs0Var4);
    }

    @Nullable
    public final PositionType u(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString("position");
        if (string == null) {
            return null;
        }
        return INSTANCE.v(string);
    }

    @Nullable
    public final PositionType v(@NotNull String str) {
        b41.i(str, "target");
        if (b41.d(str, "relative")) {
            return PositionType.Relative;
        }
        if (b41.d(str, "absolute")) {
            return PositionType.Absolute;
        }
        return null;
    }

    @Nullable
    public final ld2<hs0> w(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "cssJson");
        String string = jSONObject.getString("width");
        String string2 = jSONObject.getString("height");
        if (string == null && string2 == null) {
            return null;
        }
        return new ld2<>(string != null ? hs0.Companion.d(string) : null, string2 != null ? hs0.Companion.d(string2) : null);
    }
}
