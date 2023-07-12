package tb;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class be extends fc {
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final be INSTANCE = new be(1, 0, 7);
    @JvmField
    @NotNull
    public static final be INVALID_VERSION = new be(new int[0]);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final be a(@NotNull InputStream inputStream) {
            int q;
            int[] z0;
            b41.i(inputStream, kh1.RESOURCE_STREAM);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            n31 n31Var = new n31(1, dataInputStream.readInt());
            q = kotlin.collections.n.q(n31Var, 10);
            ArrayList arrayList = new ArrayList(q);
            Iterator<Integer> it = n31Var.iterator();
            while (it.hasNext()) {
                ((i31) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            z0 = CollectionsKt___CollectionsKt.z0(arrayList);
            return new be(Arrays.copyOf(z0, z0.length));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(@NotNull int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        b41.i(iArr, "numbers");
    }

    public boolean h() {
        return f(INSTANCE);
    }
}
