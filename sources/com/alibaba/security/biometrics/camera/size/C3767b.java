package com.alibaba.security.biometrics.camera.size;

import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.camera.size.b */
/* loaded from: classes8.dex */
public final class C3767b {
    public final HashMap<AspectRatio, SortedSet<C3766a>> a = new HashMap<>();

    private boolean a(C3766a c3766a) {
        boolean z;
        for (AspectRatio aspectRatio : this.a.keySet()) {
            int b = AspectRatio.b(c3766a.a, c3766a.b);
            int i = c3766a.a / b;
            int i2 = c3766a.b / b;
            if (aspectRatio.b == i && aspectRatio.c == i2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                SortedSet<C3766a> sortedSet = this.a.get(aspectRatio);
                if (sortedSet.contains(c3766a)) {
                    return false;
                }
                sortedSet.add(c3766a);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(c3766a);
        this.a.put(AspectRatio.a(c3766a.a, c3766a.b), treeSet);
        return true;
    }

    private void b(AspectRatio aspectRatio) {
        this.a.remove(aspectRatio);
    }

    private Set<AspectRatio> a() {
        return this.a.keySet();
    }

    public final SortedSet<C3766a> a(AspectRatio aspectRatio) {
        return this.a.get(aspectRatio);
    }
}
