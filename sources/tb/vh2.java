package tb;

import android.text.TextUtils;
import cn.damai.common.util.ACache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Formatter;
import java.util.Locale;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class vh2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final vh2 INSTANCE = new vh2();
    public static final long NUM_QIAN = 1000;
    public static final long NUM_QIAN_WAN = 10000000;
    public static final long NUM_WAN = 10000;
    public static final long NUM_YI = 100000000;
    public static final int OND_DAY = 86400000;
    public static final int ONE_HOUR = 3600000;
    public static final int ONE_MINUTE = 60000;

    private vh2() {
    }

    @Nullable
    public final String a(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148093270")) {
            return (String) ipChange.ipc$dispatch("-1148093270", new Object[]{this, str});
        }
        b41.i(str, "args");
        String str2 = "";
        String str3 = str2;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (!('0' <= charAt && charAt < ':') && charAt != '.' && charAt != '-' && charAt != '/') {
                if (str2.length() <= str3.length()) {
                    str2 = str3;
                }
                str3 = str2;
                str2 = "";
            } else {
                str2 = str2 + charAt + "";
            }
            i++;
        }
        return (i != str.length() || str2.length() <= str3.length()) ? str3 : str2;
    }

    public final boolean b(@NotNull String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1440930401")) {
            return ((Boolean) ipChange.ipc$dispatch("-1440930401", new Object[]{this, str})).booleanValue();
        }
        b41.i(str, "content");
        try {
            if (c(str)) {
                return false;
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (b41.k(str.charAt(i), 48) < 0 || b41.k(str.charAt(i), 57) > 0) {
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean c(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44793958")) {
            return ((Boolean) ipChange.ipc$dispatch("44793958", new Object[]{this, str})).booleanValue();
        }
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = b41.k(str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (!b41.d("", str.subSequence(i, length + 1).toString())) {
                int length2 = str.length() - 1;
                int i2 = 0;
                boolean z3 = false;
                while (i2 <= length2) {
                    boolean z4 = b41.k(str.charAt(!z3 ? i2 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length2--;
                    } else if (z4) {
                        i2++;
                    } else {
                        z3 = true;
                    }
                }
                if (str.subSequence(i2, length2 + 1).toString().length() != 0) {
                    int length3 = str.length() - 1;
                    int i3 = 0;
                    boolean z5 = false;
                    while (i3 <= length3) {
                        boolean z6 = b41.k(str.charAt(!z5 ? i3 : length3), 32) <= 0;
                        if (z5) {
                            if (!z6) {
                                break;
                            }
                            length3--;
                        } else if (z6) {
                            i3++;
                        } else {
                            z5 = true;
                        }
                    }
                    if (!b41.d("null", str.subSequence(i3, length3 + 1).toString())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @NotNull
    public final String d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "430186327")) {
            return (String) ipChange.ipc$dispatch("430186327", new Object[]{this, Long.valueOf(j)});
        }
        long j2 = j / 100000000;
        if (j2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(j2);
            sb.append('.');
            sb.append((j % 100000000) / 10000000);
            sb.append((char) 20159);
            return sb.toString();
        }
        long j3 = j / 10000;
        if (j3 > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j3);
            sb2.append('.');
            sb2.append((j % 10000) / 1000);
            sb2.append((char) 19975);
            return sb2.toString();
        }
        return j + "";
    }

    public final double e(@Nullable String str, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-538711621")) {
            return ((Double) ipChange.ipc$dispatch("-538711621", new Object[]{this, str, Double.valueOf(d)})).doubleValue();
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                b41.f(str);
                return Double.parseDouble(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    public final int f(@Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34674185")) {
            return ((Integer) ipChange.ipc$dispatch("34674185", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                b41.f(str);
                return Integer.parseInt(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public final long g(@Nullable String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647965682")) {
            return ((Long) ipChange.ipc$dispatch("647965682", new Object[]{this, str, Long.valueOf(j)})).longValue();
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                b41.f(str);
                return Long.parseLong(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    @Nullable
    public final String h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199590839")) {
            return (String) ipChange.ipc$dispatch("-1199590839", new Object[]{this, Integer.valueOf(i)});
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / ACache.TIME_HOUR;
        sb.setLength(0);
        return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    @NotNull
    public final String i(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        String str6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278806905")) {
            return (String) ipChange.ipc$dispatch("-278806905", new Object[]{this, str, str2, str3, str4, str5});
        }
        b41.i(str, "str");
        b41.i(str2, "digitSize");
        b41.i(str3, "digitColor");
        b41.i(str4, "normalSize");
        b41.i(str5, "normalColor");
        String a = INSTANCE.a(str);
        if (!TextUtils.isEmpty(a)) {
            if (a != null) {
                str6 = C8604o.z(str, a, "</dmtag><dmtag size=\"" + str2 + "\" color=\"" + str3 + "\">" + a + "</dmtag><dmtag size=\"" + str4 + "\" color=\"" + str5 + "\">", false, 4, null);
            } else {
                str6 = null;
            }
            str = String.valueOf(str6);
        }
        return "<dmtag size=\"" + str4 + "\" color=\"" + str5 + "\">" + str + "</dmtag>";
    }
}
