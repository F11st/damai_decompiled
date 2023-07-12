package com.alibaba.security.biometrics.camera.size;

import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b {
    public final HashMap<AspectRatio, SortedSet<a>> a = new HashMap<>();

    private boolean a(a aVar) {
        boolean z;
        for (AspectRatio aspectRatio : this.a.keySet()) {
            int b = AspectRatio.b(aVar.a, aVar.b);
            int i = aVar.a / b;
            int i2 = aVar.b / b;
            if (aspectRatio.b == i && aspectRatio.c == i2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                SortedSet<a> sortedSet = this.a.get(aspectRatio);
                if (sortedSet.contains(aVar)) {
                    return false;
                }
                sortedSet.add(aVar);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(aVar);
        this.a.put(AspectRatio.a(aVar.a, aVar.b), treeSet);
        return true;
    }

    private void b(AspectRatio aspectRatio) {
        this.a.remove(aspectRatio);
    }

    private Set<AspectRatio> a() {
        return this.a.keySet();
    }

    public final SortedSet<a> a(AspectRatio aspectRatio) {
        return this.a.get(aspectRatio);
    }
}
