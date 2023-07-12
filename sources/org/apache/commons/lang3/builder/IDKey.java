package org.apache.commons.lang3.builder;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class IDKey {
    private final int id;
    private final Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IDKey(Object obj) {
        this.id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IDKey) {
            IDKey iDKey = (IDKey) obj;
            return this.id == iDKey.id && this.value == iDKey.value;
        }
        return false;
    }

    public int hashCode() {
        return this.id;
    }
}
