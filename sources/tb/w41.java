package tb;

import com.alibaba.pictures.cornerstone.protocol.IJSONParser;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class w41 extends hb<IJSONParser> implements IJSONParser {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final w41 INSTANCE;

    static {
        w41 w41Var = new w41();
        INSTANCE = w41Var;
        hb.f(w41Var, new v41(), null, 2, null);
    }

    private w41() {
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> ArrayList<T> parseArrayList(@Nullable String str, @NotNull Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546461678")) {
            return (ArrayList) ipChange.ipc$dispatch("546461678", new Object[]{this, str, cls});
        }
        b41.i(cls, "clz");
        return a().parseArrayList(str, cls);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Boolean[] parseBooleanArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "133471137") ? (Boolean[]) ipChange.ipc$dispatch("133471137", new Object[]{this, str}) : a().parseBooleanArray(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Integer[] parseIntArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1120862876") ? (Integer[]) ipChange.ipc$dispatch("-1120862876", new Object[]{this, str}) : a().parseIntArray(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> T parseJson(@Nullable String str, @NotNull Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1721914635")) {
            return (T) ipChange.ipc$dispatch("1721914635", new Object[]{this, str, cls});
        }
        b41.i(cls, "cls");
        return (T) a().parseJson(str, (Class<Object>) cls);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Object parseJsonObject(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1081871963") ? ipChange.ipc$dispatch("1081871963", new Object[]{this, str}) : a().parseJsonObject(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public Long[] parseLongArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-566174873") ? (Long[]) ipChange.ipc$dispatch("-566174873", new Object[]{this, str}) : a().parseLongArray(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public String[] parseStringArray(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-945927097") ? (String[]) ipChange.ipc$dispatch("-945927097", new Object[]{this, str}) : a().parseStringArray(str);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public String toJsonString(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1435585269") ? (String) ipChange.ipc$dispatch("1435585269", new Object[]{this, obj}) : a().toJsonString(obj);
    }

    @Override // com.alibaba.pictures.cornerstone.protocol.IJSONParser
    @Nullable
    public <T> T parseJson(@Nullable String str, @NotNull Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149074835")) {
            return (T) ipChange.ipc$dispatch("-149074835", new Object[]{this, str, type});
        }
        b41.i(type, "type");
        return (T) a().parseJson(str, type);
    }
}
