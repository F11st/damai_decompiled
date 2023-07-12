package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class a<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final g a = g.a();

    private MessageType a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw b(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    private UninitializedMessageException b(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).d();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: c */
    public MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: d */
    public MessageType parseDelimitedFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException {
        return a(parsePartialDelimitedFrom(inputStream, gVar));
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: e */
    public MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parseFrom(byteString, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: f */
    public MessageType parseFrom(ByteString byteString, g gVar) throws InvalidProtocolBufferException {
        return a(parsePartialFrom(byteString, gVar));
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: g */
    public MessageType parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parseFrom(codedInputStream, a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Parser
    /* renamed from: h */
    public MessageType parseFrom(CodedInputStream codedInputStream, g gVar) throws InvalidProtocolBufferException {
        return (MessageType) a((MessageLite) parsePartialFrom(codedInputStream, gVar));
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: i */
    public MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: j */
    public MessageType parseFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException {
        return a(parsePartialFrom(inputStream, gVar));
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: k */
    public MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parseFrom(bArr, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: l */
    public MessageType parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return parseFrom(bArr, i, i2, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: m */
    public MessageType parseFrom(byte[] bArr, int i, int i2, g gVar) throws InvalidProtocolBufferException {
        return a(parsePartialFrom(bArr, i, i2, gVar));
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: n */
    public MessageType parseFrom(byte[] bArr, g gVar) throws InvalidProtocolBufferException {
        return parseFrom(bArr, 0, bArr.length, gVar);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: o */
    public MessageType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(inputStream, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: p */
    public MessageType parsePartialDelimitedFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return parsePartialFrom(new AbstractMessageLite.Builder.a(inputStream, CodedInputStream.q(read, inputStream)), gVar);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: q */
    public MessageType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parsePartialFrom(byteString, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: r */
    public MessageType parsePartialFrom(ByteString byteString, g gVar) throws InvalidProtocolBufferException {
        try {
            CodedInputStream newCodedInput = byteString.newCodedInput();
            MessageType messagetype = (MessageType) parsePartialFrom(newCodedInput, gVar);
            try {
                newCodedInput.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: s */
    public MessageType parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(codedInputStream, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: t */
    public MessageType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(inputStream, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: u */
    public MessageType parsePartialFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException {
        CodedInputStream c = CodedInputStream.c(inputStream);
        MessageType messagetype = (MessageType) parsePartialFrom(c, gVar);
        try {
            c.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        }
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: v */
    public MessageType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: w */
    public MessageType parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, i, i2, a);
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: x */
    public MessageType parsePartialFrom(byte[] bArr, int i, int i2, g gVar) throws InvalidProtocolBufferException {
        try {
            CodedInputStream f = CodedInputStream.f(bArr, i, i2);
            MessageType messagetype = (MessageType) parsePartialFrom(f, gVar);
            try {
                f.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    @Override // com.google.protobuf.Parser
    /* renamed from: y */
    public MessageType parsePartialFrom(byte[] bArr, g gVar) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, gVar);
    }
}
