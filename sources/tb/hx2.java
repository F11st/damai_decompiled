package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class hx2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final b a;
    @NotNull
    private final ProtoBuf$VersionRequirement.VersionKind b;
    @NotNull
    private final DeprecationLevel c;
    @Nullable
    private final Integer d;
    @Nullable
    private final String e;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Taobao */
        /* renamed from: tb.hx2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0454a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf$VersionRequirement.Level.values().length];
                iArr[ProtoBuf$VersionRequirement.Level.WARNING.ordinal()] = 1;
                iArr[ProtoBuf$VersionRequirement.Level.ERROR.ordinal()] = 2;
                iArr[ProtoBuf$VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final List<hx2> a(@NotNull MessageLite messageLite, @NotNull NameResolver nameResolver, @NotNull ix2 ix2Var) {
            List<Integer> versionRequirementList;
            b41.i(messageLite, "proto");
            b41.i(nameResolver, "nameResolver");
            b41.i(ix2Var, "table");
            if (messageLite instanceof ProtoBuf$Class) {
                versionRequirementList = ((ProtoBuf$Class) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf$Constructor) {
                versionRequirementList = ((ProtoBuf$Constructor) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf$Function) {
                versionRequirementList = ((ProtoBuf$Function) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf$Property) {
                versionRequirementList = ((ProtoBuf$Property) messageLite).getVersionRequirementList();
            } else if (!(messageLite instanceof ProtoBuf$TypeAlias)) {
                throw new IllegalStateException(b41.r("Unexpected declaration: ", messageLite.getClass()));
            } else {
                versionRequirementList = ((ProtoBuf$TypeAlias) messageLite).getVersionRequirementList();
            }
            b41.h(versionRequirementList, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer num : versionRequirementList) {
                a aVar = hx2.Companion;
                b41.h(num, "id");
                hx2 b = aVar.b(num.intValue(), nameResolver, ix2Var);
                if (b != null) {
                    arrayList.add(b);
                }
            }
            return arrayList;
        }

        @Nullable
        public final hx2 b(int i, @NotNull NameResolver nameResolver, @NotNull ix2 ix2Var) {
            DeprecationLevel deprecationLevel;
            b41.i(nameResolver, "nameResolver");
            b41.i(ix2Var, "table");
            ProtoBuf$VersionRequirement b = ix2Var.b(i);
            if (b == null) {
                return null;
            }
            b a = b.Companion.a(b.hasVersion() ? Integer.valueOf(b.getVersion()) : null, b.hasVersionFull() ? Integer.valueOf(b.getVersionFull()) : null);
            ProtoBuf$VersionRequirement.Level level = b.getLevel();
            b41.f(level);
            int i2 = C0454a.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i2 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                deprecationLevel = DeprecationLevel.HIDDEN;
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            Integer valueOf = b.hasErrorCode() ? Integer.valueOf(b.getErrorCode()) : null;
            String string = b.hasMessage() ? nameResolver.getString(b.getMessage()) : null;
            ProtoBuf$VersionRequirement.VersionKind versionKind = b.getVersionKind();
            b41.h(versionKind, "info.versionKind");
            return new hx2(a, versionKind, deprecationLevel2, valueOf, string);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
        @NotNull
        public static final a Companion = new a(null);
        @JvmField
        @NotNull
        public static final b INFINITY = new b(256, 256, 256);
        private final int a;
        private final int b;
        private final int c;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(k50 k50Var) {
                this();
            }

            @NotNull
            public final b a(@Nullable Integer num, @Nullable Integer num2) {
                if (num2 != null) {
                    return new b(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new b(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return b.INFINITY;
            }
        }

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @NotNull
        public final String a() {
            StringBuilder sb;
            int i;
            if (this.c == 0) {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                i = this.b;
            } else {
                sb = new StringBuilder();
                sb.append(this.a);
                sb.append('.');
                sb.append(this.b);
                sb.append('.');
                i = this.c;
            }
            sb.append(i);
            return sb.toString();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        @NotNull
        public String toString() {
            return a();
        }

        public /* synthetic */ b(int i, int i2, int i3, int i4, k50 k50Var) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }
    }

    public hx2(@NotNull b bVar, @NotNull ProtoBuf$VersionRequirement.VersionKind versionKind, @NotNull DeprecationLevel deprecationLevel, @Nullable Integer num, @Nullable String str) {
        b41.i(bVar, "version");
        b41.i(versionKind, "kind");
        b41.i(deprecationLevel, "level");
        this.a = bVar;
        this.b = versionKind;
        this.c = deprecationLevel;
        this.d = num;
        this.e = str;
    }

    @NotNull
    public final ProtoBuf$VersionRequirement.VersionKind a() {
        return this.b;
    }

    @NotNull
    public final b b() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.a);
        sb.append(' ');
        sb.append(this.c);
        Integer num = this.d;
        sb.append(num != null ? b41.r(" error ", num) : "");
        String str = this.e;
        sb.append(str != null ? b41.r(": ", str) : "");
        return sb.toString();
    }
}
