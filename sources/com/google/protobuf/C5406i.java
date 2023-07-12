package com.google.protobuf;

/* compiled from: Taobao */
/* renamed from: com.google.protobuf.i */
/* loaded from: classes10.dex */
public class C5406i {
    private static final C5401g e = C5401g.a();
    private ByteString a;
    private C5401g b;
    protected volatile MessageLite c;
    private volatile ByteString d;

    private static MessageLite e(MessageLite messageLite, ByteString byteString, C5401g c5401g) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, c5401g).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    public boolean a() {
        ByteString byteString;
        ByteString byteString2 = this.d;
        ByteString byteString3 = ByteString.EMPTY;
        return byteString2 == byteString3 || (this.c == null && ((byteString = this.a) == null || byteString == byteString3));
    }

    protected void b(MessageLite messageLite) {
        if (this.c != null) {
            return;
        }
        synchronized (this) {
            if (this.c != null) {
                return;
            }
            try {
                if (this.a != null) {
                    this.c = messageLite.getParserForType().parseFrom(this.a, this.b);
                    this.d = this.a;
                } else {
                    this.c = messageLite;
                    this.d = ByteString.EMPTY;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.c = messageLite;
                this.d = ByteString.EMPTY;
            }
        }
    }

    public MessageLite c(MessageLite messageLite) {
        b(messageLite);
        return this.c;
    }

    public void d(C5406i c5406i) {
        ByteString byteString;
        if (c5406i.a()) {
            return;
        }
        if (a()) {
            f(c5406i);
            return;
        }
        if (this.b == null) {
            this.b = c5406i.b;
        }
        ByteString byteString2 = this.a;
        if (byteString2 != null && (byteString = c5406i.a) != null) {
            this.a = byteString2.concat(byteString);
        } else if (this.c == null && c5406i.c != null) {
            g(e(c5406i.c, this.a, this.b));
        } else if (this.c != null && c5406i.c == null) {
            g(e(this.c, c5406i.a, c5406i.b));
        } else if (c5406i.b != null) {
            g(e(this.c, c5406i.h(), c5406i.b));
        } else if (this.b != null) {
            g(e(c5406i.c, h(), this.b));
        } else {
            g(e(this.c, c5406i.h(), e));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C5406i) {
            C5406i c5406i = (C5406i) obj;
            MessageLite messageLite = this.c;
            MessageLite messageLite2 = c5406i.c;
            if (messageLite == null && messageLite2 == null) {
                return h().equals(c5406i.h());
            }
            if (messageLite == null || messageLite2 == null) {
                if (messageLite != null) {
                    return messageLite.equals(c5406i.c(messageLite.getDefaultInstanceForType()));
                }
                return c(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
            }
            return messageLite.equals(messageLite2);
        }
        return false;
    }

    public void f(C5406i c5406i) {
        this.a = c5406i.a;
        this.c = c5406i.c;
        this.d = c5406i.d;
        C5401g c5401g = c5406i.b;
        if (c5401g != null) {
            this.b = c5401g;
        }
    }

    public MessageLite g(MessageLite messageLite) {
        MessageLite messageLite2 = this.c;
        this.a = null;
        this.d = null;
        this.c = messageLite;
        return messageLite2;
    }

    public ByteString h() {
        if (this.d != null) {
            return this.d;
        }
        ByteString byteString = this.a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = ByteString.EMPTY;
            } else {
                this.d = this.c.toByteString();
            }
            return this.d;
        }
    }

    public int hashCode() {
        return 1;
    }
}
