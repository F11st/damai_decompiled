package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ob2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;
    @NotNull
    private final String c;

    public ob2(int i, int i2, @NotNull String str) {
        b41.i(str, "channelTitle");
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public final int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1416007524") ? ((Integer) ipChange.ipc$dispatch("1416007524", new Object[]{this})).intValue() : this.b;
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1574928438") ? ((Integer) ipChange.ipc$dispatch("-1574928438", new Object[]{this})).intValue() : this.a;
    }

    @NotNull
    public final String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-822406400") ? (String) ipChange.ipc$dispatch("-822406400", new Object[]{this}) : this.c;
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158555424")) {
            return ((Boolean) ipChange.ipc$dispatch("-158555424", new Object[]{this, obj})).booleanValue();
        }
        if (this != obj) {
            if (obj instanceof ob2) {
                ob2 ob2Var = (ob2) obj;
                if (this.a != ob2Var.a || this.b != ob2Var.b || !b41.d(this.c, ob2Var.c)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089134441")) {
            return ((Integer) ipChange.ipc$dispatch("-2089134441", new Object[]{this})).intValue();
        }
        int i = ((this.a * 31) + this.b) * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491425357")) {
            return (String) ipChange.ipc$dispatch("491425357", new Object[]{this});
        }
        return "ShareChannelUIData(channelId=" + this.a + ", channelIconRes=" + this.b + ", channelTitle=" + this.c + jn1.BRACKET_END_STR;
    }
}
