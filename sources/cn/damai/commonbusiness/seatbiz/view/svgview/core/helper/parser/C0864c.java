package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser;

import androidx.core.view.MotionEventCompat;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.c */
/* loaded from: classes.dex */
public class C0864c {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("aliceblue", 15792383);
        hashMap.put("antiquewhite", 16444375);
        hashMap.put("aqua", 65535);
        hashMap.put("aquamarine", 8388564);
        hashMap.put("azure", 15794175);
        hashMap.put("beige", 16119260);
        hashMap.put("bisque", 16770244);
        hashMap.put("black", 0);
        hashMap.put("blanchedalmond", 16772045);
        hashMap.put("blue", 255);
        hashMap.put("blueviolet", 9055202);
        hashMap.put("brown", 10824234);
        hashMap.put("burlywood", 14596231);
        hashMap.put("cadetblue", 6266528);
        hashMap.put("chartreuse", 8388352);
        hashMap.put("chocolate", 13789470);
        hashMap.put("coral", 16744272);
        hashMap.put("cornflowerblue", 6591981);
        hashMap.put("cornsilk", 16775388);
        hashMap.put("crimson", 14423100);
        hashMap.put("cyan", 65535);
        hashMap.put("darkblue", Integer.valueOf((int) SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR));
        hashMap.put("darkcyan", 35723);
        hashMap.put("darkgoldenrod", 12092939);
        hashMap.put("darkgray", 11119017);
        hashMap.put("darkgreen", 25600);
        hashMap.put("darkgrey", 11119017);
        hashMap.put("darkkhaki", 12433259);
        hashMap.put("darkmagenta", 9109643);
        hashMap.put("darkolivegreen", 5597999);
        hashMap.put("darkorange", 16747520);
        hashMap.put("darkorchid", 10040012);
        hashMap.put("darkred", 9109504);
        hashMap.put("darksalmon", 15308410);
        hashMap.put("darkseagreen", 9419919);
        hashMap.put("darkslateblue", 4734347);
        hashMap.put("darkslategray", 3100495);
        hashMap.put("darkslategrey", 3100495);
        hashMap.put("darkturquoise", 52945);
        hashMap.put("darkviolet", 9699539);
        hashMap.put("deeppink", 16716947);
        hashMap.put("deepskyblue", 49151);
        hashMap.put("dimgray", 6908265);
        hashMap.put("dimgrey", 6908265);
        hashMap.put("dodgerblue", 2003199);
        hashMap.put("firebrick", 11674146);
        hashMap.put("floralwhite", 16775920);
        hashMap.put("forestgreen", 2263842);
        hashMap.put("fuchsia", 16711935);
        hashMap.put("gainsboro", 14474460);
        hashMap.put("ghostwhite", 16316671);
        hashMap.put("gold", 16766720);
        hashMap.put("goldenrod", 14329120);
        hashMap.put("gray", 8421504);
        hashMap.put("green", 32768);
        hashMap.put("greenyellow", 11403055);
        hashMap.put("grey", 8421504);
        hashMap.put("honeydew", 15794160);
        hashMap.put("hotpink", 16738740);
        hashMap.put("indianred", 13458524);
        hashMap.put("indigo", 4915330);
        hashMap.put("ivory", 16777200);
        hashMap.put("khaki", 15787660);
        hashMap.put("lavender", 15132410);
        hashMap.put("lavenderblush", 16773365);
        hashMap.put("lawngreen", 8190976);
        hashMap.put("lemonchiffon", 16775885);
        hashMap.put("lightblue", 11393254);
        hashMap.put("lightcoral", 15761536);
        hashMap.put("lightcyan", 14745599);
        hashMap.put("lightgoldenrodyellow", 16448210);
        hashMap.put("lightgray", 13882323);
        hashMap.put("lightgreen", 9498256);
        hashMap.put("lightgrey", 13882323);
        hashMap.put("lightpink", 16758465);
        hashMap.put("lightsalmon", 16752762);
        hashMap.put("lightseagreen", 2142890);
        hashMap.put("lightskyblue", 8900346);
        hashMap.put("lightslategray", 7833753);
        hashMap.put("lightslategrey", 7833753);
        hashMap.put("lightsteelblue", 11584734);
        hashMap.put("lightyellow", 16777184);
        hashMap.put("lime", Integer.valueOf((int) MotionEventCompat.ACTION_POINTER_INDEX_MASK));
        hashMap.put("limegreen", 3329330);
        hashMap.put("linen", 16445670);
        hashMap.put("magenta", 16711935);
        hashMap.put("maroon", 8388608);
        hashMap.put("mediumaquamarine", 6737322);
        hashMap.put("mediumblue", 205);
        hashMap.put("mediumorchid", 12211667);
        hashMap.put("mediumpurple", 9662683);
        hashMap.put("mediumseagreen", 3978097);
        hashMap.put("mediumslateblue", 8087790);
        hashMap.put("mediumspringgreen", 64154);
        hashMap.put("mediumturquoise", 4772300);
        hashMap.put("mediumvioletred", 13047173);
        hashMap.put("midnightblue", 1644912);
        hashMap.put("mintcream", 16121850);
        hashMap.put("mistyrose", 16770273);
        hashMap.put("moccasin", 16770229);
        hashMap.put("navajowhite", 16768685);
        hashMap.put("navy", 128);
        hashMap.put("oldlace", 16643558);
        hashMap.put("olive", 8421376);
        hashMap.put("olivedrab", 7048739);
        hashMap.put("orange", 16753920);
        hashMap.put("orangered", 16729344);
        hashMap.put("orchid", 14315734);
        hashMap.put("palegoldenrod", 15657130);
        hashMap.put("palegreen", 10025880);
        hashMap.put("paleturquoise", 11529966);
        hashMap.put("palevioletred", 14381203);
        hashMap.put("papayawhip", 16773077);
        hashMap.put("peachpuff", 16767673);
        hashMap.put("peru", 13468991);
        hashMap.put("pink", 16761035);
        hashMap.put("plum", 14524637);
        hashMap.put("powderblue", 11591910);
        hashMap.put("purple", 8388736);
        hashMap.put("red", 16711680);
        hashMap.put("rosybrown", 12357519);
        hashMap.put("royalblue", 4286945);
        hashMap.put("saddlebrown", 9127187);
        hashMap.put("salmon", 16416882);
        hashMap.put("sandybrown", 16032864);
        hashMap.put("seagreen", 3050327);
        hashMap.put("seashell", 16774638);
        hashMap.put("sienna", 10506797);
        hashMap.put("silver", 12632256);
        hashMap.put("skyblue", 8900331);
        hashMap.put("slateblue", 6970061);
        hashMap.put("slategray", 7372944);
        hashMap.put("slategrey", 7372944);
        hashMap.put(BQCCameraParam.SCENE_SNOW, 16775930);
        hashMap.put("springgreen", 65407);
        hashMap.put("steelblue", 4620980);
        hashMap.put("tan", 13808780);
        hashMap.put("teal", 32896);
        hashMap.put("thistle", 14204888);
        hashMap.put("tomato", 16737095);
        hashMap.put("turquoise", 4251856);
        hashMap.put("violet", 15631086);
        hashMap.put("wheat", 16113331);
        hashMap.put("white", 16777215);
        hashMap.put("whitesmoke", 16119285);
        hashMap.put("yellow", 16776960);
        hashMap.put("yellowgreen", 10145074);
        a = Collections.unmodifiableMap(hashMap);
    }

    private static int a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-619746932")) {
            return ((Integer) ipChange.ipc$dispatch("-619746932", new Object[]{Integer.valueOf(i)})).intValue();
        }
        int i2 = i & 3840;
        int i3 = (i2 << 12) | (i2 << 8);
        int i4 = i & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
        int i5 = i & 15;
        return i5 | i3 | (i4 << 4) | (i4 << 8) | (i5 << 4);
    }

    public static Integer b(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1268017979") ? (Integer) ipChange.ipc$dispatch("1268017979", new Object[]{str}) : a.get(str);
    }

    public static Integer c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36503929")) {
            return (Integer) ipChange.ipc$dispatch("36503929", new Object[]{str});
        }
        if (str == null) {
            return null;
        }
        if (str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            try {
                int parseInt = Integer.parseInt(str.substring(1), 16);
                if (str.length() == 4) {
                    parseInt = a(parseInt);
                }
                return Integer.valueOf(parseInt);
            } catch (NumberFormatException unused) {
                return null;
            }
        } else if (str.startsWith("rgb(") && str.endsWith(jn1.BRACKET_END_STR)) {
            String[] split = str.substring(4, str.length() - 1).split(",");
            try {
                return e(d(split[0]), d(split[1]), d(split[2]));
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused2) {
                return null;
            }
        } else {
            return b(str);
        }
    }

    private static int d(String str) throws NumberFormatException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462523906")) {
            return ((Integer) ipChange.ipc$dispatch("1462523906", new Object[]{str})).intValue();
        }
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (trim.endsWith("%")) {
            return Math.round((Float.parseFloat(trim.substring(0, trim.length() - 1)) / 100.0f) * 255.0f);
        }
        return Integer.parseInt(trim);
    }

    private static Integer e(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2123971909") ? (Integer) ipChange.ipc$dispatch("2123971909", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) : Integer.valueOf(((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255));
    }
}
