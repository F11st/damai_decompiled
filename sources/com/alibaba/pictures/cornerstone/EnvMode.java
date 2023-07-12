package com.alibaba.pictures.cornerstone;

import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/alibaba/pictures/cornerstone/EnvMode;", "", "", "envMode", "I", "getEnvMode", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "ONLINE", "PREPARE", "TEST", "TEST_SANDBOX", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public enum EnvMode {
    ONLINE(0),
    PREPARE(1),
    TEST(2),
    TEST_SANDBOX(3);
    
    @NotNull
    public static final C3602a Companion = new C3602a(null);
    private final int envMode;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.cornerstone.EnvMode$a */
    /* loaded from: classes7.dex */
    public static final class C3602a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3602a() {
        }

        public /* synthetic */ C3602a(k50 k50Var) {
            this();
        }
    }

    EnvMode(int i) {
        this.envMode = i;
    }

    public final int getEnvMode() {
        return this.envMode;
    }
}
