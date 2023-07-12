package tb;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
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
    public static final void a(@NotNull q qVar, @Nullable r rVar, @NotNull k kVar) {
        Map m;
        Map m2;
        Map m3;
        q0 f;
        b41.j(qVar, "akCtx");
        b41.j(kVar, "akErrorRet");
        if (l61.b(rVar != null ? rVar.c() : null, "__callFromThisAlarm__", false)) {
            return;
        }
        Pair[] pairArr = new Pair[4];
        pairArr[0] = hq2.a("__callFromThisAlarm__", Boolean.TRUE);
        pairArr[1] = hq2.a("module", "AbilityKit");
        pairArr[2] = hq2.a("point", "ExecuteException");
        Pair[] pairArr2 = new Pair[3];
        j a = kVar.a();
        pairArr2[0] = hq2.a("errorCode", a != null ? Integer.valueOf(a.a()) : null);
        j a2 = kVar.a();
        pairArr2[1] = hq2.a("errorMsg", a2 != null ? a2.b() : null);
        Pair[] pairArr3 = new Pair[5];
        Context c = qVar.c();
        pairArr3[0] = hq2.a("app", c != null ? c.getPackageName() : null);
        h a3 = qVar.a();
        pairArr3[1] = hq2.a(hh1.DIMEN_BIZ, (a3 == null || (f = a3.f()) == null) ? null : f.getBusinessID());
        pairArr3[2] = hq2.a("namespace", p.b().adjustedBizID(qVar.a()));
        pairArr3[3] = hq2.a("abilityType", rVar != null ? rVar.a() : null);
        pairArr3[4] = hq2.a("params", rVar != null ? rVar.c() : null);
        m = kotlin.collections.x.m(pairArr3);
        if (m != null) {
            pairArr2[2] = hq2.a("arg", new JSONObject(m).toJSONString());
            m2 = kotlin.collections.x.m(pairArr2);
            if (m2 != null) {
                pairArr[3] = hq2.a("data", new JSONObject(m2));
                m3 = kotlin.collections.x.m(pairArr);
                if (m3 != null) {
                    JSONObject jSONObject = new JSONObject(m3);
                    u0.b(TYPE_FAIL, jSONObject, qVar, null, false, 8, null);
                    p.a().loge("AbilityKitErr", jSONObject.toJSONString());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
    }
}
