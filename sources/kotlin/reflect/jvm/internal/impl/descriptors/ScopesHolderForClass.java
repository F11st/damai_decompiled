package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.a12;
import tb.b41;
import tb.b81;
import tb.k50;
import tb.tg2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ScopesHolderForClass<T extends MemberScope> {
    @NotNull
    private final ClassDescriptor a;
    @NotNull
    private final Function1<b81, T> b;
    @NotNull
    private final b81 c;
    @NotNull
    private final NotNullLazyValue d;
    static final /* synthetic */ KProperty<Object>[] e = {a12.i(new PropertyReference1Impl(a12.b(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final <T extends MemberScope> ScopesHolderForClass<T> a(@NotNull ClassDescriptor classDescriptor, @NotNull StorageManager storageManager, @NotNull b81 b81Var, @NotNull Function1<? super b81, ? extends T> function1) {
            b41.i(classDescriptor, "classDescriptor");
            b41.i(storageManager, "storageManager");
            b41.i(b81Var, "kotlinTypeRefinerForOwnerModule");
            b41.i(function1, "scopeFactory");
            return new ScopesHolderForClass<>(classDescriptor, storageManager, function1, b81Var, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1<? super b81, ? extends T> function1, b81 b81Var) {
        this.a = classDescriptor;
        this.b = function1;
        this.c = b81Var;
        this.d = storageManager.createLazyValue(new Function0<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$scopeForOwnerModule$2
            final /* synthetic */ ScopesHolderForClass<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemberScope invoke() {
                Function1 function12;
                b81 b81Var2;
                function12 = ((ScopesHolderForClass) this.this$0).b;
                b81Var2 = ((ScopesHolderForClass) this.this$0).c;
                return (MemberScope) function12.invoke(b81Var2);
            }
        });
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, b81 b81Var, k50 k50Var) {
        this(classDescriptor, storageManager, function1, b81Var);
    }

    private final T d() {
        return (T) tg2.a(this.d, this, e[0]);
    }

    @NotNull
    public final T c(@NotNull final b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        if (b81Var.c(DescriptorUtilsKt.l(this.a))) {
            TypeConstructor typeConstructor = this.a.getTypeConstructor();
            b41.h(typeConstructor, "classDescriptor.typeConstructor");
            return !b81Var.d(typeConstructor) ? d() : (T) b81Var.b(this.a, new Function0<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$getScope$1
                final /* synthetic */ ScopesHolderForClass<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /* JADX WARN: Incorrect return type in method signature: ()TT; */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final MemberScope invoke() {
                    Function1 function1;
                    function1 = ((ScopesHolderForClass) this.this$0).b;
                    return (MemberScope) function1.invoke(b81Var);
                }
            });
        }
        return d();
    }
}
