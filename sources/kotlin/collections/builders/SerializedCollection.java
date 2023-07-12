package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.l;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SerializedCollection implements Externalizable {
    @NotNull
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    @NotNull
    private Collection<?> collection;
    private final int tag;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public SerializedCollection(@NotNull Collection<?> collection, int i) {
        b41.i(collection, "collection");
        this.collection = collection;
        this.tag = i;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput objectInput) {
        List d;
        Collection<?> a2;
        Set b;
        b41.i(objectInput, "input");
        byte readByte = objectInput.readByte();
        int i = readByte & 1;
        if ((readByte & (-2)) == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                int i2 = 0;
                if (i == 0) {
                    d = l.d(readInt);
                    while (i2 < readInt) {
                        d.add(objectInput.readObject());
                        i2++;
                    }
                    a2 = l.a(d);
                } else if (i == 1) {
                    b = d0.b(readInt);
                    while (i2 < readInt) {
                        b.add(objectInput.readObject());
                        i2++;
                    }
                    a2 = d0.a(b);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + i + '.');
                }
                this.collection = a2;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput objectOutput) {
        b41.i(objectOutput, "output");
        objectOutput.writeByte(this.tag);
        objectOutput.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            objectOutput.writeObject(it.next());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SerializedCollection() {
        /*
            r2 = this;
            java.util.List r0 = kotlin.collections.k.g()
            r1 = 0
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.SerializedCollection.<init>():void");
    }
}
