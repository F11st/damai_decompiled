package com.taobao.weex.utils;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.utils.SingleFunctionParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXResourceUtils {
    private static final Map<String, Integer> a;
    private static final SingleFunctionParser.FlatMapper<Integer> b;
    private static final SingleFunctionParser.NonUniformMapper<Number> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum ColorConvertHandler {
        NAMED_COLOR_HANDLER { // from class: com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler.1
            @Override // com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler
            @NonNull
            Pair<Boolean, Integer> handle(String str) {
                if (WXResourceUtils.a.containsKey(str)) {
                    return new Pair<>(Boolean.TRUE, WXResourceUtils.a.get(str));
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        },
        RGB_HANDLER { // from class: com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler.2
            @Override // com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler
            @NonNull
            Pair<Boolean, Integer> handle(String str) {
                if (str.length() == 4) {
                    int parseInt = Integer.parseInt(str.substring(1, 2), 16);
                    int parseInt2 = Integer.parseInt(str.substring(2, 3), 16);
                    int parseInt3 = Integer.parseInt(str.substring(3, 4), 16);
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.rgb(parseInt + (parseInt << 4), parseInt2 + (parseInt2 << 4), parseInt3 + (parseInt3 << 4))));
                } else if (str.length() != 7 && str.length() != 9) {
                    return new Pair<>(Boolean.FALSE, 0);
                } else {
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.parseColor(str)));
                }
            }
        },
        FUNCTIONAL_RGB_HANDLER { // from class: com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler.3
            @Override // com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler
            @NonNull
            Pair<Boolean, Integer> handle(String str) {
                List parse = new SingleFunctionParser(str, WXResourceUtils.b).parse("rgb");
                if (parse != null && parse.size() == 3) {
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.rgb(((Integer) parse.get(0)).intValue(), ((Integer) parse.get(1)).intValue(), ((Integer) parse.get(2)).intValue())));
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        },
        FUNCTIONAL_RGBA_HANDLER { // from class: com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler.4
            @Override // com.taobao.weex.utils.WXResourceUtils.ColorConvertHandler
            @NonNull
            Pair<Boolean, Integer> handle(String str) {
                List parse = new SingleFunctionParser(str, WXResourceUtils.c).parse("rgba");
                if (parse.size() == 4) {
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(Color.argb(ColorConvertHandler.parseAlpha(((Number) parse.get(3)).floatValue()), ((Number) parse.get(0)).intValue(), ((Number) parse.get(1)).intValue(), ((Number) parse.get(2)).intValue())));
                }
                return new Pair<>(Boolean.FALSE, 0);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        public static int parseAlpha(float f) {
            return (int) (f * 255.0f);
        }

        @NonNull
        abstract Pair<Boolean, Integer> handle(String str);
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        b = new SingleFunctionParser.FlatMapper<Integer>() { // from class: com.taobao.weex.utils.WXResourceUtils.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.taobao.weex.utils.SingleFunctionParser.FlatMapper
            public Integer map(String str) {
                int i = 255;
                int parseUnitOrPercent = WXUtils.parseUnitOrPercent(str, 255);
                if (parseUnitOrPercent < 0) {
                    i = 0;
                } else if (parseUnitOrPercent <= 255) {
                    i = parseUnitOrPercent;
                }
                return Integer.valueOf(i);
            }
        };
        c = new SingleFunctionParser.NonUniformMapper<Number>() { // from class: com.taobao.weex.utils.WXResourceUtils.2
            @Override // com.taobao.weex.utils.SingleFunctionParser.NonUniformMapper
            public List<Number> map(List<String> list) {
                ArrayList arrayList = new ArrayList(4);
                int i = 0;
                while (i < 3) {
                    int i2 = 255;
                    int parseUnitOrPercent = WXUtils.parseUnitOrPercent(list.get(i), 255);
                    if (parseUnitOrPercent < 0) {
                        i2 = 0;
                    } else if (parseUnitOrPercent <= 255) {
                        i2 = parseUnitOrPercent;
                    }
                    arrayList.add(Integer.valueOf(i2));
                    i++;
                }
                arrayList.add(Float.valueOf(list.get(i)));
                return arrayList;
            }
        };
        hashMap.put("aliceblue", -984833);
        hashMap.put("antiquewhite", -332841);
        hashMap.put("aqua", -16711681);
        hashMap.put("aquamarine", -8388652);
        hashMap.put("azure", -983041);
        hashMap.put("beige", -657956);
        hashMap.put("bisque", -6972);
        hashMap.put("black", -16777216);
        hashMap.put("blanchedalmond", -5171);
        hashMap.put("blue", -16776961);
        hashMap.put("blueviolet", -7722014);
        hashMap.put("brown", -5952982);
        hashMap.put("burlywood", -2180985);
        hashMap.put("cadetblue", -10510688);
        hashMap.put("chartreuse", -8388864);
        hashMap.put("chocolate", -2987746);
        hashMap.put("coral", -32944);
        hashMap.put("cornflowerblue", -10185235);
        hashMap.put("cornsilk", -1828);
        hashMap.put("crimson", -2354116);
        hashMap.put("cyan", -16711681);
        hashMap.put("darkblue", -16777077);
        hashMap.put("darkcyan", -16741493);
        hashMap.put("darkgoldenrod", -4684277);
        hashMap.put("darkgray", -5658199);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkkhaki", -4343957);
        hashMap.put("darkmagenta", -7667573);
        hashMap.put("darkolivegreen", -11179217);
        hashMap.put("darkorange", -29696);
        hashMap.put("darkorchid", -6737204);
        hashMap.put("darkred", -7667712);
        hashMap.put("darksalmon", -1468806);
        hashMap.put("darkseagreen", -7357297);
        hashMap.put("darkslateblue", -12042869);
        hashMap.put("darkslategray", -13676721);
        hashMap.put("darkslategrey", -13676721);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        hashMap.put("deeppink", -60269);
        hashMap.put("deepskyblue", -16728065);
        hashMap.put("dimgray", -9868951);
        hashMap.put("dimgrey", -9868951);
        hashMap.put("dodgerblue", -14774017);
        hashMap.put("firebrick", -5103070);
        hashMap.put("floralwhite", -1296);
        hashMap.put("forestgreen", -14513374);
        hashMap.put("fuchsia", -65281);
        hashMap.put("gainsboro", -2302756);
        hashMap.put("ghostwhite", -460545);
        hashMap.put("gold", -10496);
        hashMap.put("goldenrod", -2448096);
        hashMap.put("gray", -8355712);
        hashMap.put("grey", -8355712);
        hashMap.put("green", -16744448);
        hashMap.put("greenyellow", -5374161);
        hashMap.put("honeydew", -983056);
        hashMap.put("hotpink", -38476);
        hashMap.put("indianred", -3318692);
        hashMap.put("indigo", -11861886);
        hashMap.put("ivory", -16);
        hashMap.put("khaki", -989556);
        hashMap.put("lavender", -1644806);
        hashMap.put("lavenderblush", -3851);
        hashMap.put("lawngreen", -8586240);
        hashMap.put("lemonchiffon", -1331);
        hashMap.put("lightblue", -5383962);
        hashMap.put("lightcoral", -1015680);
        hashMap.put("lightcyan", -2031617);
        hashMap.put("lightgoldenrodyellow", -329006);
        hashMap.put("lightgray", -2894893);
        hashMap.put("lightgrey", -2894893);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightpink", -18751);
        hashMap.put("lightsalmon", -24454);
        hashMap.put("lightseagreen", -14634326);
        hashMap.put("lightskyblue", -7876870);
        hashMap.put("lightslategray", -8943463);
        hashMap.put("lightslategrey", -8943463);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        hashMap.put("lime", -16711936);
        hashMap.put("limegreen", -13447886);
        hashMap.put("linen", -331546);
        hashMap.put("magenta", -65281);
        hashMap.put("maroon", -8388608);
        hashMap.put("mediumaquamarine", -10039894);
        hashMap.put("mediumblue", -16777011);
        hashMap.put("mediumorchid", -4565549);
        hashMap.put("mediumpurple", -7114533);
        hashMap.put("mediumseagreen", -12799119);
        hashMap.put("mediumslateblue", -8689426);
        hashMap.put("mediumspringgreen", -16713062);
        hashMap.put("mediumturquoise", -12004916);
        hashMap.put("mediumvioletred", -3730043);
        hashMap.put("midnightblue", -15132304);
        hashMap.put("mintcream", -655366);
        hashMap.put("mistyrose", -6943);
        hashMap.put("moccasin", -6987);
        hashMap.put("navajowhite", -8531);
        hashMap.put("navy", -16777088);
        hashMap.put("oldlace", -133658);
        hashMap.put("olive", -8355840);
        hashMap.put("olivedrab", -9728477);
        hashMap.put("orange", -23296);
        hashMap.put("orangered", -47872);
        hashMap.put("orchid", -2461482);
        hashMap.put("palegoldenrod", -1120086);
        hashMap.put("palegreen", -6751336);
        hashMap.put("paleturquoise", -5247250);
        hashMap.put("palevioletred", -2396013);
        hashMap.put("papayawhip", -4139);
        hashMap.put("peachpuff", -9543);
        hashMap.put("peru", -3308225);
        hashMap.put("pink", -16181);
        hashMap.put("plum", -2252579);
        hashMap.put("powderblue", -5185306);
        hashMap.put("purple", -8388480);
        hashMap.put("rebeccapurple", -10079335);
        hashMap.put("red", Integer.valueOf((int) SupportMenu.CATEGORY_MASK));
        hashMap.put("rosybrown", -4419697);
        hashMap.put("royalblue", -12490271);
        hashMap.put("saddlebrown", -7650029);
        hashMap.put("salmon", -360334);
        hashMap.put("sandybrown", -744352);
        hashMap.put("seagreen", -13726889);
        hashMap.put("seashell", -2578);
        hashMap.put("sienna", -6270419);
        hashMap.put("silver", -4144960);
        hashMap.put("skyblue", -7876885);
        hashMap.put("slateblue", -9807155);
        hashMap.put("slategray", -9404272);
        hashMap.put("slategrey", -9404272);
        hashMap.put(BQCCameraParam.SCENE_SNOW, -1286);
        hashMap.put("springgreen", -16711809);
        hashMap.put("steelblue", -12156236);
        hashMap.put("tan", -2968436);
        hashMap.put("teal", -16744320);
        hashMap.put("thistle", -2572328);
        hashMap.put("tomato", -40121);
        hashMap.put("turquoise", -12525360);
        hashMap.put("violet", -1146130);
        hashMap.put("wheat", -663885);
        hashMap.put("white", -1);
        hashMap.put("whitesmoke", -657931);
        hashMap.put("yellow", Integer.valueOf((int) InputDeviceCompat.SOURCE_ANY));
        hashMap.put("yellowgreen", -6632142);
        hashMap.put("transparent", 0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r8.equals("totop") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static float[] d(java.lang.String r8, float r9, float r10) {
        /*
            r0 = 4
            float[] r1 = new float[r0]
            r1 = {x0084: FILL_ARRAY_DATA  , data: [0, 0, 0, 0} // fill-array
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 != 0) goto L1a
            java.lang.String r2 = "\\s*"
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replaceAll(r2, r3)
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r2)
        L1a:
            r8.hashCode()
            r2 = -1
            int r3 = r8.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            switch(r3) {
                case -1352032154: goto L60;
                case -1137407871: goto L55;
                case -868157182: goto L4a;
                case -172068863: goto L3f;
                case 110550266: goto L36;
                case 1176531318: goto L2b;
                default: goto L29;
            }
        L29:
            r0 = -1
            goto L6a
        L2b:
            java.lang.String r0 = "tobottomright"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L34
            goto L29
        L34:
            r0 = 5
            goto L6a
        L36:
            java.lang.String r3 = "totop"
            boolean r8 = r8.equals(r3)
            if (r8 != 0) goto L6a
            goto L29
        L3f:
            java.lang.String r0 = "totopleft"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L48
            goto L29
        L48:
            r0 = 3
            goto L6a
        L4a:
            java.lang.String r0 = "toleft"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L53
            goto L29
        L53:
            r0 = 2
            goto L6a
        L55:
            java.lang.String r0 = "toright"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L5e
            goto L29
        L5e:
            r0 = 1
            goto L6a
        L60:
            java.lang.String r0 = "tobottom"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L69
            goto L29
        L69:
            r0 = 0
        L6a:
            switch(r0) {
                case 0: goto L81;
                case 1: goto L7e;
                case 2: goto L7b;
                case 3: goto L76;
                case 4: goto L73;
                case 5: goto L6e;
                default: goto L6d;
            }
        L6d:
            goto L83
        L6e:
            r1[r5] = r9
            r1[r4] = r10
            goto L83
        L73:
            r1[r6] = r10
            goto L83
        L76:
            r1[r7] = r9
            r1[r6] = r10
            goto L83
        L7b:
            r1[r7] = r9
            goto L83
        L7e:
            r1[r5] = r9
            goto L83
        L81:
            r1[r4] = r10
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.utils.WXResourceUtils.d(java.lang.String, float, float):float[]");
    }

    @NonNull
    private static List<String> e(String str) {
        String nextToken;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.trim();
        if (!str.startsWith("linear-gradient")) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(str.indexOf(jn1.BRACKET_START_STR) + 1, str.lastIndexOf(jn1.BRACKET_END_STR)), ",");
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str2 = null;
            while (stringTokenizer.hasMoreTokens()) {
                nextToken = stringTokenizer.nextToken();
                if (nextToken.contains(jn1.BRACKET_START_STR)) {
                    str2 = nextToken + ",";
                } else if (nextToken.contains(jn1.BRACKET_END_STR)) {
                    break;
                } else if (str2 != null) {
                    str2 = str2 + nextToken + ",";
                } else {
                    arrayList.add(nextToken);
                }
            }
            return arrayList;
            arrayList.add(str2 + nextToken);
        }
    }

    public static int getColor(String str) {
        return getColor(str, Integer.MIN_VALUE);
    }

    public static Shader getShader(String str, float f, float f2) {
        List<String> e = e(str);
        if (e == null || e.size() != 3) {
            return null;
        }
        float[] d = d(e.get(0), f, f2);
        return new LinearGradient(d[0], d[1], d[2], d[3], getColor(e.get(1), -1), getColor(e.get(2), -1), Shader.TileMode.CLAMP);
    }

    public static boolean isNamedColor(String str) {
        return a.containsKey(str);
    }

    public static int getColor(String str, int i) {
        Pair<Boolean, Integer> handle;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        String trim = str.trim();
        Integer num = WXUtils.a.get(trim);
        if (num != null) {
            return num.intValue();
        }
        for (ColorConvertHandler colorConvertHandler : ColorConvertHandler.values()) {
            try {
                handle = colorConvertHandler.handle(trim);
            } catch (RuntimeException e) {
                WXLogUtils.v("Color_Parser", WXLogUtils.getStackTrace(e));
            }
            if (((Boolean) handle.first).booleanValue()) {
                i = ((Integer) handle.second).intValue();
                WXUtils.a.put(trim, Integer.valueOf(i));
                break;
            }
            continue;
        }
        return i;
    }
}
