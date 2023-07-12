package com.google.protobuf;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class i {
    private static final g e = g.a();
    private ByteString a;
    private g b;
    protected volatile MessageLite c;
    private volatile ByteString d;

    private static MessageLite e(MessageLite messageLite, ByteString byteString, g gVar) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, gVar).build();
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

    public void d(i iVar) {
        ByteString byteString;
        if (iVar.a()) {
            return;
        }
        if (a()) {
            f(iVar);
            return;
        }
        if (this.b == null) {
            this.b = iVar.b;
        }
        ByteString byteString2 = this.a;
        if (byteString2 != null && (byteString = iVar.a) != null) {
            this.a = byteString2.concat(byteString);
        } else if (this.c == null && iVar.c != null) {
            g(e(iVar.c, this.a, this.b));
        } else if (this.c != null && iVar.c == null) {
            g(e(this.c, iVar.a, iVar.b));
        } else if (iVar.b != null) {
            g(e(this.c, iVar.h(), iVar.b));
        } else if (this.b != null) {
            g(e(iVar.c, h(), this.b));
        } else {
            g(e(this.c, iVar.h(), e));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            MessageLite messageLite = this.c;
            MessageLite messageLite2 = iVar.c;
            if (messageLite == null && messageLite2 == null) {
                return h().equals(iVar.h());
            }
            if (messageLite == null || messageLite2 == null) {
                if (messageLite != null) {
                    return messageLite.equals(iVar.c(messageLite.getDefaultInstanceForType()));
                }
                return c(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
            }
            return messageLite.equals(messageLite2);
        }
        return false;
    }

    public void f(i iVar) {
        this.a = iVar.a;
        this.c = iVar.c;
        this.d = iVar.d;
        g gVar = iVar.b;
        if (gVar != null) {
            this.b = gVar;
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
