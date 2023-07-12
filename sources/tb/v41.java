package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.pictures.cornerstone.protocol.IJSONParser;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class v41 implements IJSONParser {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a<T> extends TypeReference<ArrayList<T>> {
        a() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b extends TypeReference<Boolean[]> {
        b() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c extends TypeReference<Integer[]> {
        c() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class d extends TypeReference<Long[]> {
        d() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class e extends TypeReference<String[]> {
        e() {
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> ArrayList<T> parseArrayList(@Nullable String str, @NotNull Class<T> cls) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-567040635")) {
            return (ArrayList) ipChange.ipc$dispatch("-567040635", new Object[]{this, str, cls});
        }
        b41.i(cls, "clz");
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return (ArrayList) JSON.parseObject(str, new a(), new Feature[0]);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseArray:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Boolean[] parseBooleanArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-954551574")) {
            return (Boolean[]) ipChange.ipc$dispatch("-954551574", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return (Boolean[]) JSON.parseObject(str, new b(), new Feature[0]);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseIntArray-type:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Integer[] parseIntArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-879746771")) {
            return (Integer[]) ipChange.ipc$dispatch("-879746771", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return (Integer[]) JSON.parseObject(str, new c(), new Feature[0]);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseIntArray-type:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> T parseJson(@Nullable String str, @NotNull Class<T> cls) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1257908642")) {
            return (T) ipChange.ipc$dispatch("1257908642", new Object[]{this, str, cls});
        }
        b41.i(cls, "cls");
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return (T) JSON.parseObject(str, cls);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseJson-cls:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Object parseJsonObject(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1322988068")) {
            return ipChange.ipc$dispatch("1322988068", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return JSON.parseObject(str);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseJsonObject:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Long[] parseLongArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1669833360")) {
            return (Long[]) ipChange.ipc$dispatch("-1669833360", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return (Long[]) JSON.parseObject(str, new d(), new Feature[0]);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseIntArray-type:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public String[] parseStringArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1161584176")) {
            return (String[]) ipChange.ipc$dispatch("-1161584176", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return (String[]) JSON.parseObject(str, new e(), new Feature[0]);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseStringArray-type:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public String toJsonString(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093868596")) {
            return (String) ipChange.ipc$dispatch("-1093868596", new Object[]{this, obj});
        }
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "toJsonString:" + e2);
            return null;
        }
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> T parseJson(@Nullable String str, @NotNull Type type) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1847562250")) {
            return (T) ipChange.ipc$dispatch("-1847562250", new Object[]{this, str, type});
        }
        b41.i(type, "type");
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        try {
            return (T) JSON.parseObject(str, type, new Feature[0]);
        } catch (Exception e2) {
            ab1 ab1Var = ab1.INSTANCE;
            ab1Var.e("JSONParerImpl", "parseJson-type:" + e2);
            return null;
        }
    }
}
