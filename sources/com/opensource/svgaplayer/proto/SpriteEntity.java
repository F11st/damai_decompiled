package com.opensource.svgaplayer.proto;

import com.youku.squareup.wire.FieldEncoding;
import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.ProtoReader;
import com.youku.squareup.wire.ProtoWriter;
import com.youku.squareup.wire.WireField;
import com.youku.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class SpriteEntity extends Message<SpriteEntity, a> {
    public static final ProtoAdapter<SpriteEntity> ADAPTER = new b();
    public static final String DEFAULT_IMAGEKEY = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.opensource.svgaplayer.proto.FrameEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<FrameEntity> frames;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String imageKey;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a extends Message.Builder<SpriteEntity, a> {
        public String a;
        public List<FrameEntity> b = Internal.newMutableList();

        @Override // com.youku.squareup.wire.Message.Builder
        /* renamed from: a */
        public SpriteEntity build() {
            return new SpriteEntity(this.a, this.b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.a = str;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class b extends ProtoAdapter<SpriteEntity> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, SpriteEntity.class);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public SpriteEntity decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                } else if (nextTag == 1) {
                    aVar.b(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    aVar.b.add(FrameEntity.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, SpriteEntity spriteEntity) throws IOException {
            String str = spriteEntity.imageKey;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            FrameEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, spriteEntity.frames);
            protoWriter.writeBytes(spriteEntity.unknownFields());
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(SpriteEntity spriteEntity) {
            String str = spriteEntity.imageKey;
            return (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0) + FrameEntity.ADAPTER.asRepeated().encodedSizeWithTag(2, spriteEntity.frames) + spriteEntity.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.youku.squareup.wire.Message$Builder, com.opensource.svgaplayer.proto.SpriteEntity$a] */
        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public SpriteEntity redact(SpriteEntity spriteEntity) {
            ?? newBuilder2 = spriteEntity.newBuilder2();
            Internal.redactElements(newBuilder2.b, FrameEntity.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    public SpriteEntity(String str, List<FrameEntity> list) {
        this(str, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpriteEntity) {
            SpriteEntity spriteEntity = (SpriteEntity) obj;
            return unknownFields().equals(spriteEntity.unknownFields()) && Internal.equals(this.imageKey, spriteEntity.imageKey) && this.frames.equals(spriteEntity.frames);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.imageKey;
            int hashCode2 = ((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.frames.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.imageKey != null) {
            sb.append(", imageKey=");
            sb.append(this.imageKey);
        }
        if (!this.frames.isEmpty()) {
            sb.append(", frames=");
            sb.append(this.frames);
        }
        StringBuilder replace = sb.replace(0, 2, "SpriteEntity{");
        replace.append('}');
        return replace.toString();
    }

    public SpriteEntity(String str, List<FrameEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.imageKey = str;
        this.frames = Internal.immutableCopyOf("frames", list);
    }

    @Override // com.youku.squareup.wire.Message
    /* renamed from: newBuilder */
    public Message.Builder<SpriteEntity, a> newBuilder2() {
        a aVar = new a();
        aVar.a = this.imageKey;
        aVar.b = Internal.copyOf("frames", this.frames);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
