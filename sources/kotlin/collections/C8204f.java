package kotlin.collections;

import kotlin.SinceKotlin;

/* compiled from: Taobao */
/* renamed from: kotlin.collections.f */
/* loaded from: classes3.dex */
class C8204f {
    @SinceKotlin(version = "1.3")
    public static final void a(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }
}
