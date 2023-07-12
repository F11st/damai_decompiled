package tb;

import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: tb.js */
/* loaded from: classes.dex */
public class C9318js {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CONFIG_SVG_CODEC_TYPE = "damai_svg_codec_type";
    public static final String SVG_CODEC_TYPE_CSS_SUPPORT = "damai_svg_codec_type_css_support";
    public static final String SVG_CODEC_TYPE_OLD = "damai_svg_codec_type_old_version";
    public static final String SVG_CODEC_TYPE_ORANGE = "damai_svg_codec_type_orange";
    public static final String SVG_DECODER_SWITCH = "damai_svg_decoder_switch";

    private static String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1845124280") ? (String) ipChange.ipc$dispatch("1845124280", new Object[0]) : z20.B(CONFIG_SVG_CODEC_TYPE);
    }

    public static boolean b() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "361821071")) {
            return ((Boolean) ipChange.ipc$dispatch("361821071", new Object[0])).booleanValue();
        }
        try {
            i = OrangeConfigCenter.c().a(SVG_DECODER_SWITCH, "damai_svg_decoder_css_support_with_id_hook", 1);
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        return i == 1;
    }

    public static boolean c() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1262567818")) {
            return ((Boolean) ipChange.ipc$dispatch("-1262567818", new Object[0])).booleanValue();
        }
        if (AppConfig.v()) {
            String a = a();
            if (!SVG_CODEC_TYPE_ORANGE.equals(a)) {
                if (SVG_CODEC_TYPE_CSS_SUPPORT.equals(a)) {
                    return true;
                }
                if (SVG_CODEC_TYPE_OLD.equals(a)) {
                    return false;
                }
            }
        }
        try {
            i = OrangeConfigCenter.c().a(SVG_DECODER_SWITCH, "damai_svg_decoder_css_support", 1);
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        return i == 1;
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806421513")) {
            ipChange.ipc$dispatch("1806421513", new Object[0]);
            return;
        }
        try {
            OrangeConfigCenter.c().e(SVG_DECODER_SWITCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794664861")) {
            ipChange.ipc$dispatch("-1794664861", new Object[0]);
            return;
        }
        try {
            OrangeConfigCenter.c().g(SVG_DECODER_SWITCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
