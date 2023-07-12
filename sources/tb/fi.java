package tb;

import java.util.Arrays;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class fi extends s31<Character> {
    public fi(char c) {
        super(Character.valueOf(c));
    }

    private final String c(char c) {
        return c == '\b' ? "\\b" : c == '\t' ? "\\t" : c == '\n' ? "\\n" : c == '\f' ? "\\f" : c == '\r' ? "\\r" : e(c) ? String.valueOf(c) : "?";
    }

    private final boolean e(char c) {
        byte type = (byte) Character.getType(c);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: d */
    public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        fd2 u = moduleDescriptor.getBuiltIns().u();
        b41.h(u, "module.builtIns.charType");
        return u;
    }

    @Override // tb.fn
    @NotNull
    public String toString() {
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(b().charValue()), c(b().charValue())}, 2));
        b41.h(format, "java.lang.String.format(this, *args)");
        return format;
    }
}
