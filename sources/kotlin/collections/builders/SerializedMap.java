package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.C8225w;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class SerializedMap implements Externalizable {
    @NotNull
    public static final C8197a Companion = new C8197a(null);
    private static final long serialVersionUID = 0;
    @NotNull
    private Map<?, ?> map;

    /* compiled from: Taobao */
    /* renamed from: kotlin.collections.builders.SerializedMap$a */
    /* loaded from: classes3.dex */
    public static final class C8197a {
        private C8197a() {
        }

        public /* synthetic */ C8197a(k50 k50Var) {
            this();
        }
    }

    public SerializedMap(@NotNull Map<?, ?> map) {
        b41.i(map, "map");
        this.map = map;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput objectInput) {
        Map d;
        Map<?, ?> b;
        b41.i(objectInput, "input");
        byte readByte = objectInput.readByte();
        if (readByte == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                d = C8225w.d(readInt);
                for (int i = 0; i < readInt; i++) {
                    d.put(objectInput.readObject(), objectInput.readObject());
                }
                b = C8225w.b(d);
                this.map = b;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte));
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput objectOutput) {
        b41.i(objectOutput, "output");
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SerializedMap() {
        /*
            r1 = this;
            java.util.Map r0 = kotlin.collections.C8223u.i()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.SerializedMap.<init>():void");
    }
}
