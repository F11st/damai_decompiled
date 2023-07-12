package tb;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class c92 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SEAT_DECODER_SWITCH = "damai_seat_decoder_switch";

    public static boolean a() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1140897899")) {
            return ((Boolean) ipChange.ipc$dispatch("1140897899", new Object[0])).booleanValue();
        }
        try {
            i = OrangeConfigCenter.c().a(SEAT_DECODER_SWITCH, "damai_static_seat_compress_support", 1);
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        return i == 1;
    }

    public static boolean b() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819135770")) {
            return ((Boolean) ipChange.ipc$dispatch("-819135770", new Object[0])).booleanValue();
        }
        try {
            i = OrangeConfigCenter.c().a(SEAT_DECODER_SWITCH, "damai_static_seat_pb_verify", 1);
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        return i == 1;
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-957172128")) {
            ipChange.ipc$dispatch("-957172128", new Object[0]);
            return;
        }
        try {
            OrangeConfigCenter.c().e(SEAT_DECODER_SWITCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671998073")) {
            ipChange.ipc$dispatch("-671998073", new Object[0]);
            return;
        }
        try {
            OrangeConfigCenter.c().g(SEAT_DECODER_SWITCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
