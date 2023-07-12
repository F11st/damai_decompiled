package tb;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class jg0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String DATA = "data";
    @NotNull
    public static final String DEFAULT_TYPE = "result";
    @NotNull
    public static final String ERR_CODE = "code";
    @NotNull
    public static final String ERR_MSG = "msg";
    @NotNull
    public static final String TYPE = "type";
    @Nullable
    private final Map<String, Object> a;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    private jg0(Map<String, ? extends Object> map, String str) {
        this.a = map;
    }

    @Nullable
    public abstract Map<String, Object> a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ jg0(Map map, String str, int i, k50 k50Var) {
        this(map, (i & 2) != 0 ? "result" : str);
    }

    public /* synthetic */ jg0(Map map, String str, k50 k50Var) {
        this(map, str);
    }
}
