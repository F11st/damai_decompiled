package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class xi1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @NotNull
    private final String b;
    @NotNull
    private final String c;
    @Nullable
    private String d;

    public xi1(@NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @NotNull
    public final String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1082282635") ? (String) ipChange.ipc$dispatch("-1082282635", new Object[]{this}) : this.b;
    }

    @NotNull
    public final Context b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-17826110") ? (Context) ipChange.ipc$dispatch("-17826110", new Object[]{this}) : this.a;
    }

    @NotNull
    public final String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1325271836") ? (String) ipChange.ipc$dispatch("-1325271836", new Object[]{this}) : this.c;
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1755438271") ? (String) ipChange.ipc$dispatch("1755438271", new Object[]{this}) : this.d;
    }

    public abstract void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i);

    public abstract void f(@NotNull View view, @NotNull JSONObject jSONObject, int i);

    public abstract void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i);

    public final void h(@Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894669501")) {
            ipChange.ipc$dispatch("-1894669501", new Object[]{this, jSONObject});
        }
    }
}
