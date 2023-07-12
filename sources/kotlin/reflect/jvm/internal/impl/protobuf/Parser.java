package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream, C8447c c8447c) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream inputStream, C8447c c8447c) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString byteString, C8447c c8447c) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream codedInputStream, C8447c c8447c) throws InvalidProtocolBufferException;
}
