package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class p01 {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile boolean a;
    @Nullable
    private JSONObject b;
    @Nullable
    private byte[] c;
    @Nullable
    private Integer d;
    @Nullable
    private String e;
    @Nullable
    private Boolean f;
    @Nullable
    private String g;
    @Nullable
    private Boolean h;
    @Nullable
    private Boolean i;

    public p01() {
        Boolean bool = Boolean.FALSE;
        this.h = bool;
        this.i = bool;
    }

    public static /* synthetic */ void j(p01 p01Var, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charset.forName("UTF-8");
            b41.h(charset, "Charset.forName(\"UTF-8\")");
        }
        p01Var.i(charset);
    }

    @Nullable
    public final String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1166523785") ? (String) ipChange.ipc$dispatch("-1166523785", new Object[]{this}) : this.g;
    }

    @Nullable
    public final byte[] b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1109391208") ? (byte[]) ipChange.ipc$dispatch("1109391208", new Object[]{this}) : this.c;
    }

    @Nullable
    public final JSONObject c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579927396")) {
            return (JSONObject) ipChange.ipc$dispatch("1579927396", new Object[]{this});
        }
        if (this.b == null && !this.a) {
            j(this, null, 1, null);
        }
        return this.b;
    }

    @Nullable
    public final Integer d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-849972836") ? (Integer) ipChange.ipc$dispatch("-849972836", new Object[]{this}) : this.d;
    }

    @Nullable
    public final String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1822105625") ? (String) ipChange.ipc$dispatch("1822105625", new Object[]{this}) : this.e;
    }

    @Nullable
    public final Boolean f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1993400695") ? (Boolean) ipChange.ipc$dispatch("1993400695", new Object[]{this}) : this.f;
    }

    @Nullable
    public final Boolean g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1833966251") ? (Boolean) ipChange.ipc$dispatch("-1833966251", new Object[]{this}) : this.i;
    }

    @Nullable
    public final Boolean h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2118410111") ? (Boolean) ipChange.ipc$dispatch("2118410111", new Object[]{this}) : this.h;
    }

    public final void i(@NotNull Charset charset) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279097272")) {
            ipChange.ipc$dispatch("-1279097272", new Object[]{this, charset});
            return;
        }
        b41.i(charset, "charset");
        if (this.a) {
            return;
        }
        synchronized (this) {
            if (!this.a) {
                byte[] bArr = this.c;
                if (bArr != null) {
                    this.b = new JSONObject(new String(bArr, charset));
                }
                this.a = true;
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void k(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-823290053")) {
            ipChange.ipc$dispatch("-823290053", new Object[]{this, bool});
        } else {
            this.f = bool;
        }
    }

    public final void l(@Nullable byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1798588912")) {
            ipChange.ipc$dispatch("-1798588912", new Object[]{this, bArr});
        } else {
            this.c = bArr;
        }
    }

    public final void m(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165407466")) {
            ipChange.ipc$dispatch("-165407466", new Object[]{this, num});
        } else {
            this.d = num;
        }
    }

    public final void n(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744392475")) {
            ipChange.ipc$dispatch("-744392475", new Object[]{this, str});
        } else {
            this.e = str;
        }
    }
}
