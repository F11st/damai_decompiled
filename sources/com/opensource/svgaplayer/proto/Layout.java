package com.opensource.svgaplayer.proto;

import com.youku.squareup.wire.FieldEncoding;
import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.ProtoReader;
import com.youku.squareup.wire.ProtoWriter;
import com.youku.squareup.wire.WireField;
import com.youku.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Layout extends Message<Layout, a> {
    public static final ProtoAdapter<Layout> ADAPTER = new b();
    public static final Float DEFAULT_HEIGHT;
    public static final Float DEFAULT_WIDTH;
    public static final Float DEFAULT_X;
    public static final Float DEFAULT_Y;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float height;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float width;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float x;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float y;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a extends Message.Builder<Layout, a> {
        public Float a;
        public Float b;
        public Float c;
        public Float d;

        @Override // com.youku.squareup.wire.Message.Builder
        /* renamed from: a */
        public Layout build() {
            return new Layout(this.a, this.b, this.c, this.d, super.buildUnknownFields());
        }

        public a b(Float f) {
            this.d = f;
            return this;
        }

        public a c(Float f) {
            this.c = f;
            return this;
        }

        public a d(Float f) {
            this.a = f;
            return this;
        }

        public a e(Float f) {
            this.b = f;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class b extends ProtoAdapter<Layout> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public Layout decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                } else if (nextTag == 1) {
                    aVar.d(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    aVar.e(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 3) {
                    aVar.c(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    aVar.b(ProtoAdapter.FLOAT.decode(protoReader));
                }
            }
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, Layout layout) throws IOException {
            Float f = layout.x;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f);
            }
            Float f2 = layout.y;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f2);
            }
            Float f3 = layout.width;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f3);
            }
            Float f4 = layout.height;
            if (f4 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f4);
            }
            protoWriter.writeBytes(layout.unknownFields());
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Layout layout) {
            Float f = layout.x;
            int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
            Float f2 = layout.y;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2) : 0);
            Float f3 = layout.width;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3) : 0);
            Float f4 = layout.height;
            return encodedSizeWithTag3 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4) : 0) + layout.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.youku.squareup.wire.Message$Builder, com.opensource.svgaplayer.proto.Layout$a] */
        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public Layout redact(Layout layout) {
            ?? newBuilder2 = layout.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_WIDTH = valueOf;
        DEFAULT_HEIGHT = valueOf;
    }

    public Layout(Float f, Float f2, Float f3, Float f4) {
        this(f, f2, f3, f4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            return unknownFields().equals(layout.unknownFields()) && Internal.equals(this.x, layout.x) && Internal.equals(this.y, layout.y) && Internal.equals(this.width, layout.width) && Internal.equals(this.height, layout.height);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Float f = this.x;
            int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
            Float f2 = this.y;
            int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
            Float f3 = this.width;
            int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
            Float f4 = this.height;
            int hashCode5 = hashCode4 + (f4 != null ? f4.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.x != null) {
            sb.append(", x=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", y=");
            sb.append(this.y);
        }
        if (this.width != null) {
            sb.append(", width=");
            sb.append(this.width);
        }
        if (this.height != null) {
            sb.append(", height=");
            sb.append(this.height);
        }
        StringBuilder replace = sb.replace(0, 2, "Layout{");
        replace.append('}');
        return replace.toString();
    }

    public Layout(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    @Override // com.youku.squareup.wire.Message
    /* renamed from: newBuilder */
    public Message.Builder<Layout, a> newBuilder2() {
        a aVar = new a();
        aVar.a = this.x;
        aVar.b = this.y;
        aVar.c = this.width;
        aVar.d = this.height;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
