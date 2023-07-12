package tb;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.C8226x;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class y6 {
    public static final y6 INSTANCE = new y6();
    @NotNull
    public static final String P_KEY_ARG = "arg";
    @NotNull
    public static final String P_KEY_DATA = "data";
    @NotNull
    public static final String P_KEY_ERROR_CODE = "errorCode";
    @NotNull
    public static final String P_KEY_ERROR_MSG = "errorMsg";
    @NotNull
    public static final String P_KEY_MODULE = "module";
    @NotNull
    public static final String P_KEY_POINT = "point";
    @NotNull
    public static final String P_KEY_VALUE = "value";
    @NotNull
    public static final String TYPE_COUNTER = "appMonitorCounter";
    @NotNull
    public static final String TYPE_FAIL = "appMonitorFail";
    @NotNull
    public static final String TYPE_SUCCESS = "appMonitorSuccess";

    private y6() {
    }

    @JvmStatic
    public static final void a(@NotNull C9586q c9586q, @Nullable C9636r c9636r, @NotNull C9327k c9327k) {
        Map m;
        Map m2;
        Map m3;
        C9587q0 f;
        b41.j(c9586q, "akCtx");
        b41.j(c9327k, "akErrorRet");
        if (l61.b(c9636r != null ? c9636r.c() : null, "__callFromThisAlarm__", false)) {
            return;
        }
        Pair[] pairArr = new Pair[4];
        pairArr[0] = hq2.a("__callFromThisAlarm__", Boolean.TRUE);
        pairArr[1] = hq2.a("module", "AbilityKit");
        pairArr[2] = hq2.a("point", "ExecuteException");
        Pair[] pairArr2 = new Pair[3];
        C9292j a = c9327k.a();
        pairArr2[0] = hq2.a("errorCode", a != null ? Integer.valueOf(a.a()) : null);
        C9292j a2 = c9327k.a();
        pairArr2[1] = hq2.a("errorMsg", a2 != null ? a2.b() : null);
        Pair[] pairArr3 = new Pair[5];
        Context c = c9586q.c();
        pairArr3[0] = hq2.a("app", c != null ? c.getPackageName() : null);
        C9192h a3 = c9586q.a();
        pairArr3[1] = hq2.a(hh1.DIMEN_BIZ, (a3 == null || (f = a3.f()) == null) ? null : f.getBusinessID());
        pairArr3[2] = hq2.a("namespace", C9539p.b().adjustedBizID(c9586q.a()));
        pairArr3[3] = hq2.a("abilityType", c9636r != null ? c9636r.a() : null);
        pairArr3[4] = hq2.a("params", c9636r != null ? c9636r.c() : null);
        m = C8226x.m(pairArr3);
        if (m != null) {
            pairArr2[2] = hq2.a("arg", new JSONObject(m).toJSONString());
            m2 = C8226x.m(pairArr2);
            if (m2 != null) {
                pairArr[3] = hq2.a("data", new JSONObject(m2));
                m3 = C8226x.m(pairArr);
                if (m3 != null) {
                    JSONObject jSONObject = new JSONObject(m3);
                    u0.b(TYPE_FAIL, jSONObject, c9586q, null, false, 8, null);
                    C9539p.a().loge("AbilityKitErr", jSONObject.toJSONString());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
    }
}
