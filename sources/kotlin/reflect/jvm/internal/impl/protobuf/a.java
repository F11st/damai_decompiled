package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class a<MessageType extends MessageLite> implements Parser<MessageType> {
    static {
        c.c();
    }

    private MessageType a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw b(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    private UninitializedMessageException b(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    /* renamed from: c */
    public MessageType parseDelimitedFrom(InputStream inputStream, c cVar) throws InvalidProtocolBufferException {
        return a(f(inputStream, cVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    /* renamed from: d */
    public MessageType parseFrom(InputStream inputStream, c cVar) throws InvalidProtocolBufferException {
        return a(g(inputStream, cVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    /* renamed from: e */
    public MessageType parseFrom(ByteString byteString, c cVar) throws InvalidProtocolBufferException {
        return a(h(byteString, cVar));
    }

    public MessageType f(InputStream inputStream, c cVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return g(new AbstractMessageLite.Builder.a(inputStream, CodedInputStream.B(read, inputStream)), cVar);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public MessageType g(InputStream inputStream, c cVar) throws InvalidProtocolBufferException {
        CodedInputStream g = CodedInputStream.g(inputStream);
        MessageType messagetype = (MessageType) parsePartialFrom(g, cVar);
        try {
            g.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType h(ByteString byteString, c cVar) throws InvalidProtocolBufferException {
        try {
            CodedInputStream m = byteString.m();
            MessageType messagetype = (MessageType) parsePartialFrom(m, cVar);
            try {
                m.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }
}
