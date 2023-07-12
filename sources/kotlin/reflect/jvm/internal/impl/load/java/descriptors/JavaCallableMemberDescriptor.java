package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ax2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaCallableMemberDescriptor extends CallableMemberDescriptor {
    @NotNull
    JavaCallableMemberDescriptor enhance(@Nullable z71 z71Var, @NotNull List<ax2> list, @NotNull z71 z71Var2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> pair);
}
