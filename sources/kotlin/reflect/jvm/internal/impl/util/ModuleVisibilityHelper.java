package kotlin.reflect.jvm.internal.impl.util;

import com.youku.live.dago.liveplayback.ApiConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ModuleVisibilityHelper {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements ModuleVisibilityHelper {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
        public boolean isInFriendModule(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
            b41.i(declarationDescriptor, ApiConstants.EventParams.WHAT);
            b41.i(declarationDescriptor2, "from");
            return true;
        }
    }

    boolean isInFriendModule(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2);
}
