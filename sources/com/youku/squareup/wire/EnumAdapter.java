package com.youku.squareup.wire;

import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.WireEnum;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    public EnumAdapter(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
        encode(protoWriter, (ProtoWriter) ((WireEnum) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize((EnumAdapter<E>) ((WireEnum) obj));
    }

    protected abstract E fromValue(int i);

    @Override // com.youku.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader protoReader) throws IOException {
        int readVarint32 = protoReader.readVarint32();
        E fromValue = fromValue(readVarint32);
        if (fromValue != null) {
            return fromValue;
        }
        throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, this.javaType);
    }

    public final void encode(ProtoWriter protoWriter, E e) throws IOException {
        protoWriter.writeVarint32(e.getValue());
    }

    public final int encodedSize(E e) {
        return ProtoWriter.varint32Size(e.getValue());
    }
}
