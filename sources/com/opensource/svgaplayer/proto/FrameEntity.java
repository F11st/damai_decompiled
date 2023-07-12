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
public final class FrameEntity extends Message<FrameEntity, a> {
    public static final ProtoAdapter<FrameEntity> ADAPTER = new b();
    public static final Float DEFAULT_ALPHA = Float.valueOf(0.0f);
    public static final String DEFAULT_CLIPPATH = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float alpha;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String clipPath;
    @WireField(adapter = "com.opensource.svgaplayer.proto.Layout#ADAPTER", tag = 2)
    public final Layout layout;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ShapeEntity> shapes;
    @WireField(adapter = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 3)
    public final Transform transform;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a extends Message.Builder<FrameEntity, a> {
        public Float a;
        public Layout b;
        public Transform c;
        public String d;
        public List<ShapeEntity> e = Internal.newMutableList();

        public a a(Float f) {
            this.a = f;
            return this;
        }

        @Override // com.youku.squareup.wire.Message.Builder
        /* renamed from: b */
        public FrameEntity build() {
            return new FrameEntity(this.a, this.b, this.c, this.d, this.e, super.buildUnknownFields());
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(Layout layout) {
            this.b = layout;
            return this;
        }

        public a e(Transform transform) {
            this.c = transform;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class b extends ProtoAdapter<FrameEntity> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, FrameEntity.class);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public FrameEntity decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                } else if (nextTag == 1) {
                    aVar.a(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    aVar.d(Layout.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    aVar.e(Transform.ADAPTER.decode(protoReader));
                } else if (nextTag == 4) {
                    aVar.c(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    aVar.e.add(ShapeEntity.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, FrameEntity frameEntity) throws IOException {
            Float f = frameEntity.alpha;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f);
            }
            Layout layout = frameEntity.layout;
            if (layout != null) {
                Layout.ADAPTER.encodeWithTag(protoWriter, 2, layout);
            }
            Transform transform = frameEntity.transform;
            if (transform != null) {
                Transform.ADAPTER.encodeWithTag(protoWriter, 3, transform);
            }
            String str = frameEntity.clipPath;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, str);
            }
            ShapeEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, frameEntity.shapes);
            protoWriter.writeBytes(frameEntity.unknownFields());
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(FrameEntity frameEntity) {
            Float f = frameEntity.alpha;
            int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
            Layout layout = frameEntity.layout;
            int encodedSizeWithTag2 = encodedSizeWithTag + (layout != null ? Layout.ADAPTER.encodedSizeWithTag(2, layout) : 0);
            Transform transform = frameEntity.transform;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (transform != null ? Transform.ADAPTER.encodedSizeWithTag(3, transform) : 0);
            String str = frameEntity.clipPath;
            return encodedSizeWithTag3 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, str) : 0) + ShapeEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, frameEntity.shapes) + frameEntity.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.opensource.svgaplayer.proto.FrameEntity$a, com.youku.squareup.wire.Message$Builder] */
        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public FrameEntity redact(FrameEntity frameEntity) {
            ?? newBuilder2 = frameEntity.newBuilder2();
            Layout layout = newBuilder2.b;
            if (layout != null) {
                newBuilder2.b = Layout.ADAPTER.redact(layout);
            }
            Transform transform = newBuilder2.c;
            if (transform != null) {
                newBuilder2.c = Transform.ADAPTER.redact(transform);
            }
            Internal.redactElements(newBuilder2.e, ShapeEntity.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    public FrameEntity(Float f, Layout layout, Transform transform, String str, List<ShapeEntity> list) {
        this(f, layout, transform, str, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FrameEntity) {
            FrameEntity frameEntity = (FrameEntity) obj;
            return unknownFields().equals(frameEntity.unknownFields()) && Internal.equals(this.alpha, frameEntity.alpha) && Internal.equals(this.layout, frameEntity.layout) && Internal.equals(this.transform, frameEntity.transform) && Internal.equals(this.clipPath, frameEntity.clipPath) && this.shapes.equals(frameEntity.shapes);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Float f = this.alpha;
            int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
            Layout layout = this.layout;
            int hashCode3 = (hashCode2 + (layout != null ? layout.hashCode() : 0)) * 37;
            Transform transform = this.transform;
            int hashCode4 = (hashCode3 + (transform != null ? transform.hashCode() : 0)) * 37;
            String str = this.clipPath;
            int hashCode5 = ((hashCode4 + (str != null ? str.hashCode() : 0)) * 37) + this.shapes.hashCode();
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.alpha != null) {
            sb.append(", alpha=");
            sb.append(this.alpha);
        }
        if (this.layout != null) {
            sb.append(", layout=");
            sb.append(this.layout);
        }
        if (this.transform != null) {
            sb.append(", transform=");
            sb.append(this.transform);
        }
        if (this.clipPath != null) {
            sb.append(", clipPath=");
            sb.append(this.clipPath);
        }
        if (!this.shapes.isEmpty()) {
            sb.append(", shapes=");
            sb.append(this.shapes);
        }
        StringBuilder replace = sb.replace(0, 2, "FrameEntity{");
        replace.append('}');
        return replace.toString();
    }

    public FrameEntity(Float f, Layout layout, Transform transform, String str, List<ShapeEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.alpha = f;
        this.layout = layout;
        this.transform = transform;
        this.clipPath = str;
        this.shapes = Internal.immutableCopyOf("shapes", list);
    }

    @Override // com.youku.squareup.wire.Message
    /* renamed from: newBuilder */
    public Message.Builder<FrameEntity, a> newBuilder2() {
        a aVar = new a();
        aVar.a = this.alpha;
        aVar.b = this.layout;
        aVar.c = this.transform;
        aVar.d = this.clipPath;
        aVar.e = Internal.copyOf("shapes", this.shapes);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
