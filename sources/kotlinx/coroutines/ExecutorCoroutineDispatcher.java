package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.ExperimentalStdlibApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;
import tb.o1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    public static final Key Key = new Key(null);

    /* compiled from: Taobao */
    @ExperimentalStdlibApi
    /* loaded from: classes8.dex */
    public static final class Key extends o1<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public /* synthetic */ Key(k50 k50Var) {
            this();
        }

        private Key() {
            super(CoroutineDispatcher.Key, new Function1<CoroutineContext.Element, ExecutorCoroutineDispatcher>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher.Key.1
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final ExecutorCoroutineDispatcher invoke(@NotNull CoroutineContext.Element element) {
                    if (!(element instanceof ExecutorCoroutineDispatcher)) {
                        element = null;
                    }
                    return (ExecutorCoroutineDispatcher) element;
                }
            });
        }
    }
}
