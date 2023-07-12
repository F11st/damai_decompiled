package com.google.protobuf;

import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType parseDelimitedFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString byteString, g gVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException;

    MessageType parseFrom(CodedInputStream codedInputStream, g gVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] bArr, int i, int i2, g gVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] bArr, g gVar) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType parsePartialDelimitedFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(ByteString byteString, g gVar) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(CodedInputStream codedInputStream, g gVar) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(InputStream inputStream, g gVar) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] bArr, int i, int i2, g gVar) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(byte[] bArr, g gVar) throws InvalidProtocolBufferException;
}
