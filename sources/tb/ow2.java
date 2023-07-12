package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ow2 {
    public static final void a(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull ClassDescriptor classDescriptor, @NotNull ni1 ni1Var) {
        LocationInfo location;
        b41.i(lookupTracker, "<this>");
        b41.i(lookupLocation, "from");
        b41.i(classDescriptor, "scopeOwner");
        b41.i(ni1Var, "name");
        if (lookupTracker == LookupTracker.C8324a.INSTANCE || (location = lookupLocation.getLocation()) == null) {
            return;
        }
        Position position = lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.a();
        String filePath = location.getFilePath();
        String b = d70.m(classDescriptor).b();
        b41.h(b, "getFqName(scopeOwner).asString()");
        ScopeKind scopeKind = ScopeKind.CLASSIFIER;
        String b2 = ni1Var.b();
        b41.h(b2, "name.asString()");
        lookupTracker.record(filePath, position, b, scopeKind, b2);
    }

    public static final void b(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull ni1 ni1Var) {
        b41.i(lookupTracker, "<this>");
        b41.i(lookupLocation, "from");
        b41.i(packageFragmentDescriptor, "scopeOwner");
        b41.i(ni1Var, "name");
        String b = packageFragmentDescriptor.getFqName().b();
        b41.h(b, "scopeOwner.fqName.asString()");
        String b2 = ni1Var.b();
        b41.h(b2, "name.asString()");
        c(lookupTracker, lookupLocation, b, b2);
    }

    public static final void c(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull String str, @NotNull String str2) {
        LocationInfo location;
        b41.i(lookupTracker, "<this>");
        b41.i(lookupLocation, "from");
        b41.i(str, "packageFqName");
        b41.i(str2, "name");
        if (lookupTracker == LookupTracker.C8324a.INSTANCE || (location = lookupLocation.getLocation()) == null) {
            return;
        }
        lookupTracker.record(location.getFilePath(), lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.a(), str, ScopeKind.PACKAGE, str2);
    }
}
