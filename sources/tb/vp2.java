package tb;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class vp2 extends e2 {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public vp2(@NotNull z71 z71Var) {
        this(z71Var, null);
        if (z71Var == null) {
            a(0);
        }
    }

    private static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private vp2(@NotNull z71 z71Var, @Nullable ReceiverValue receiverValue) {
        super(z71Var, receiverValue);
        if (z71Var == null) {
            a(1);
        }
    }
}
