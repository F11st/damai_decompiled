package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream, c cVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream inputStream, c cVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString byteString, c cVar) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException;
}
