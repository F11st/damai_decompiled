package tb;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.C8447c;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class p81 {
    private ByteString a;
    private C8447c b;
    private volatile boolean c;
    protected volatile MessageLite d;

    protected void a(MessageLite messageLite) {
        if (this.d != null) {
            return;
        }
        synchronized (this) {
            if (this.d != null) {
                return;
            }
            try {
                if (this.a != null) {
                    this.d = messageLite.getParserForType().parseFrom(this.a, this.b);
                } else {
                    this.d = messageLite;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        if (this.c) {
            return this.d.getSerializedSize();
        }
        return this.a.size();
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.d;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.d;
        this.d = messageLite;
        this.a = null;
        this.c = true;
        return messageLite2;
    }
}
