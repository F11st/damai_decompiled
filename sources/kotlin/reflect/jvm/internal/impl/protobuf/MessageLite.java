package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Builder extends Cloneable, MessageLiteOrBuilder {
        MessageLite build();

        Builder mergeFrom(CodedInputStream codedInputStream, C8447c c8447c) throws IOException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
