package tb;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.jvm.JvmField;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class vc1 {
    public static final vc1 INSTANCE;
    private static final boolean a;
    @JvmField
    @NotNull
    public static final uc1 dispatcher;

    static {
        vc1 vc1Var = new vc1();
        INSTANCE = vc1Var;
        a = nj2.e("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = vc1Var.a();
    }

    private vc1() {
    }

    private final uc1 a() {
        Sequence c;
        List<MainDispatcherFactory> B;
        Object next;
        uc1 d;
        try {
            if (a) {
                B = zh0.INSTANCE.c();
            } else {
                c = SequencesKt__SequencesKt.c(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator());
                B = SequencesKt___SequencesKt.B(c);
            }
            Iterator<T> it = B.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (d = wc1.d(mainDispatcherFactory, B)) == null) ? wc1.b(null, null, 3, null) : d;
        } catch (Throwable th) {
            return wc1.b(th, null, 2, null);
        }
    }
}
