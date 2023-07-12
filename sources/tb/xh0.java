package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.pictures.dolores.convert.IJSONConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class xh0 implements IJSONConverter {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final xh0 INSTANCE = new xh0();

    private xh0() {
    }

    @Override // com.alibaba.pictures.dolores.convert.IJSONConverter
    @Nullable
    public <T> T parseJson(@Nullable String str, @Nullable Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038446839")) {
            return (T) ipChange.ipc$dispatch("-2038446839", new Object[]{this, str, type});
        }
        if (str == null || type == null) {
            return null;
        }
        try {
            return (T) JSON.parseObject(str, type, new Feature[0]);
        } catch (Throwable th) {
            rq.c("FastJsonConverter", th.toString());
            return null;
        }
    }

    @Override // com.alibaba.pictures.dolores.convert.IJSONConverter
    @NotNull
    public String toJsonString(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448452391")) {
            return (String) ipChange.ipc$dispatch("-448452391", new Object[]{this, obj});
        }
        String jSONString = JSON.toJSONString(obj);
        b41.h(jSONString, "JSON.toJSONString(obj)");
        return jSONString;
    }

    @Override // com.alibaba.pictures.dolores.convert.IJSONConverter
    @Nullable
    public <T> T parseJson(@Nullable byte[] bArr, @Nullable Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "59972268")) {
            return (T) ipChange.ipc$dispatch("59972268", new Object[]{this, bArr, type});
        }
        if (bArr == null || type == null) {
            return null;
        }
        try {
            return (T) JSON.parseObject(bArr, type, new Feature[0]);
        } catch (Throwable th) {
            rq.c("FastJsonConverter", th.toString());
            return null;
        }
    }
}
