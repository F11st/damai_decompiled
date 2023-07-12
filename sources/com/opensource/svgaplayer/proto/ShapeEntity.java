package com.opensource.svgaplayer.proto;

import com.youku.squareup.wire.FieldEncoding;
import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.ProtoReader;
import com.youku.squareup.wire.ProtoWriter;
import com.youku.squareup.wire.WireEnum;
import com.youku.squareup.wire.WireField;
import com.youku.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ShapeEntity extends Message<ShapeEntity, C6130a> {
    public static final ProtoAdapter<ShapeEntity> ADAPTER = new C6131b();
    public static final ShapeType DEFAULT_TYPE = ShapeType.SHAPE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs#ADAPTER", tag = 4)
    public final EllipseArgs ellipse;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$RectArgs#ADAPTER", tag = 3)
    public final RectArgs rect;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs#ADAPTER", tag = 2)
    public final ShapeArgs shape;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle#ADAPTER", tag = 10)
    public final ShapeStyle styles;
    @WireField(adapter = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 11)
    public final Transform transform;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeType#ADAPTER", tag = 1)
    public final ShapeType type;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class EllipseArgs extends Message<EllipseArgs, C6120a> {
        public static final ProtoAdapter<EllipseArgs> ADAPTER = new C6121b();
        public static final Float DEFAULT_RADIUSX;
        public static final Float DEFAULT_RADIUSY;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float radiusX;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float radiusY;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs$a */
        /* loaded from: classes10.dex */
        public static final class C6120a extends Message.Builder<EllipseArgs, C6120a> {
            public Float a;
            public Float b;
            public Float c;
            public Float d;

            @Override // com.youku.squareup.wire.Message.Builder
            /* renamed from: a */
            public EllipseArgs build() {
                return new EllipseArgs(this.a, this.b, this.c, this.d, super.buildUnknownFields());
            }

            public C6120a b(Float f) {
                this.c = f;
                return this;
            }

            public C6120a c(Float f) {
                this.d = f;
                return this;
            }

            public C6120a d(Float f) {
                this.a = f;
                return this;
            }

            public C6120a e(Float f) {
                this.b = f;
                return this;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs$b */
        /* loaded from: classes10.dex */
        private static final class C6121b extends ProtoAdapter<EllipseArgs> {
            C6121b() {
                super(FieldEncoding.LENGTH_DELIMITED, EllipseArgs.class);
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: a */
            public EllipseArgs decode(ProtoReader protoReader) throws IOException {
                C6120a c6120a = new C6120a();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return c6120a.build();
                    } else if (nextTag == 1) {
                        c6120a.d(ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 2) {
                        c6120a.e(ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 3) {
                        c6120a.b(ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag != 4) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        c6120a.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        c6120a.c(ProtoAdapter.FLOAT.decode(protoReader));
                    }
                }
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: b */
            public void encode(ProtoWriter protoWriter, EllipseArgs ellipseArgs) throws IOException {
                Float f = ellipseArgs.x;
                if (f != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f);
                }
                Float f2 = ellipseArgs.y;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f2);
                }
                Float f3 = ellipseArgs.radiusX;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f3);
                }
                Float f4 = ellipseArgs.radiusY;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f4);
                }
                protoWriter.writeBytes(ellipseArgs.unknownFields());
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: c */
            public int encodedSize(EllipseArgs ellipseArgs) {
                Float f = ellipseArgs.x;
                int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
                Float f2 = ellipseArgs.y;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2) : 0);
                Float f3 = ellipseArgs.radiusX;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3) : 0);
                Float f4 = ellipseArgs.radiusY;
                return encodedSizeWithTag3 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4) : 0) + ellipseArgs.unknownFields().size();
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs$a, com.youku.squareup.wire.Message$Builder] */
            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: d */
            public EllipseArgs redact(EllipseArgs ellipseArgs) {
                ?? newBuilder2 = ellipseArgs.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_RADIUSX = valueOf;
            DEFAULT_RADIUSY = valueOf;
        }

        public EllipseArgs(Float f, Float f2, Float f3, Float f4) {
            this(f, f2, f3, f4, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof EllipseArgs) {
                EllipseArgs ellipseArgs = (EllipseArgs) obj;
                return unknownFields().equals(ellipseArgs.unknownFields()) && Internal.equals(this.x, ellipseArgs.x) && Internal.equals(this.y, ellipseArgs.y) && Internal.equals(this.radiusX, ellipseArgs.radiusX) && Internal.equals(this.radiusY, ellipseArgs.radiusY);
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
                Float f3 = this.radiusX;
                int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.radiusY;
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
            if (this.radiusX != null) {
                sb.append(", radiusX=");
                sb.append(this.radiusX);
            }
            if (this.radiusY != null) {
                sb.append(", radiusY=");
                sb.append(this.radiusY);
            }
            StringBuilder replace = sb.replace(0, 2, "EllipseArgs{");
            replace.append('}');
            return replace.toString();
        }

        public EllipseArgs(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
            super(ADAPTER, byteString);
            this.x = f;
            this.y = f2;
            this.radiusX = f3;
            this.radiusY = f4;
        }

        @Override // com.youku.squareup.wire.Message
        /* renamed from: newBuilder */
        public Message.Builder<EllipseArgs, C6120a> newBuilder2() {
            C6120a c6120a = new C6120a();
            c6120a.a = this.x;
            c6120a.b = this.y;
            c6120a.c = this.radiusX;
            c6120a.d = this.radiusY;
            c6120a.addUnknownFields(unknownFields());
            return c6120a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class RectArgs extends Message<RectArgs, C6122a> {
        public static final ProtoAdapter<RectArgs> ADAPTER = new C6123b();
        public static final Float DEFAULT_CORNERRADIUS;
        public static final Float DEFAULT_HEIGHT;
        public static final Float DEFAULT_WIDTH;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
        public final Float cornerRadius;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float height;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float width;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$RectArgs$a */
        /* loaded from: classes10.dex */
        public static final class C6122a extends Message.Builder<RectArgs, C6122a> {
            public Float a;
            public Float b;
            public Float c;
            public Float d;
            public Float e;

            @Override // com.youku.squareup.wire.Message.Builder
            /* renamed from: a */
            public RectArgs build() {
                return new RectArgs(this.a, this.b, this.c, this.d, this.e, super.buildUnknownFields());
            }

            public C6122a b(Float f) {
                this.e = f;
                return this;
            }

            public C6122a c(Float f) {
                this.d = f;
                return this;
            }

            public C6122a d(Float f) {
                this.c = f;
                return this;
            }

            public C6122a e(Float f) {
                this.a = f;
                return this;
            }

            public C6122a f(Float f) {
                this.b = f;
                return this;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$RectArgs$b */
        /* loaded from: classes10.dex */
        private static final class C6123b extends ProtoAdapter<RectArgs> {
            C6123b() {
                super(FieldEncoding.LENGTH_DELIMITED, RectArgs.class);
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: a */
            public RectArgs decode(ProtoReader protoReader) throws IOException {
                C6122a c6122a = new C6122a();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return c6122a.build();
                    } else if (nextTag == 1) {
                        c6122a.e(ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 2) {
                        c6122a.f(ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 3) {
                        c6122a.d(ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag == 4) {
                        c6122a.c(ProtoAdapter.FLOAT.decode(protoReader));
                    } else if (nextTag != 5) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        c6122a.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        c6122a.b(ProtoAdapter.FLOAT.decode(protoReader));
                    }
                }
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: b */
            public void encode(ProtoWriter protoWriter, RectArgs rectArgs) throws IOException {
                Float f = rectArgs.x;
                if (f != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f);
                }
                Float f2 = rectArgs.y;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f2);
                }
                Float f3 = rectArgs.width;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f3);
                }
                Float f4 = rectArgs.height;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f4);
                }
                Float f5 = rectArgs.cornerRadius;
                if (f5 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 5, f5);
                }
                protoWriter.writeBytes(rectArgs.unknownFields());
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: c */
            public int encodedSize(RectArgs rectArgs) {
                Float f = rectArgs.x;
                int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
                Float f2 = rectArgs.y;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2) : 0);
                Float f3 = rectArgs.width;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3) : 0);
                Float f4 = rectArgs.height;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4) : 0);
                Float f5 = rectArgs.cornerRadius;
                return encodedSizeWithTag4 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f5) : 0) + rectArgs.unknownFields().size();
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.opensource.svgaplayer.proto.ShapeEntity$RectArgs$a, com.youku.squareup.wire.Message$Builder] */
            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: d */
            public RectArgs redact(RectArgs rectArgs) {
                ?? newBuilder2 = rectArgs.newBuilder2();
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
            DEFAULT_CORNERRADIUS = valueOf;
        }

        public RectArgs(Float f, Float f2, Float f3, Float f4, Float f5) {
            this(f, f2, f3, f4, f5, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RectArgs) {
                RectArgs rectArgs = (RectArgs) obj;
                return unknownFields().equals(rectArgs.unknownFields()) && Internal.equals(this.x, rectArgs.x) && Internal.equals(this.y, rectArgs.y) && Internal.equals(this.width, rectArgs.width) && Internal.equals(this.height, rectArgs.height) && Internal.equals(this.cornerRadius, rectArgs.cornerRadius);
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
                int hashCode5 = (hashCode4 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.cornerRadius;
                int hashCode6 = hashCode5 + (f5 != null ? f5.hashCode() : 0);
                this.hashCode = hashCode6;
                return hashCode6;
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
            if (this.cornerRadius != null) {
                sb.append(", cornerRadius=");
                sb.append(this.cornerRadius);
            }
            StringBuilder replace = sb.replace(0, 2, "RectArgs{");
            replace.append('}');
            return replace.toString();
        }

        public RectArgs(Float f, Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
            this.cornerRadius = f5;
        }

        @Override // com.youku.squareup.wire.Message
        /* renamed from: newBuilder */
        public Message.Builder<RectArgs, C6122a> newBuilder2() {
            C6122a c6122a = new C6122a();
            c6122a.a = this.x;
            c6122a.b = this.y;
            c6122a.c = this.width;
            c6122a.d = this.height;
            c6122a.e = this.cornerRadius;
            c6122a.addUnknownFields(unknownFields());
            return c6122a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class ShapeArgs extends Message<ShapeArgs, C6124a> {
        public static final ProtoAdapter<ShapeArgs> ADAPTER = new C6125b();
        public static final String DEFAULT_D = "";
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 1)
        public final String d;

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs$a */
        /* loaded from: classes10.dex */
        public static final class C6124a extends Message.Builder<ShapeArgs, C6124a> {
            public String a;

            @Override // com.youku.squareup.wire.Message.Builder
            /* renamed from: a */
            public ShapeArgs build() {
                return new ShapeArgs(this.a, super.buildUnknownFields());
            }

            public C6124a b(String str) {
                this.a = str;
                return this;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs$b */
        /* loaded from: classes10.dex */
        private static final class C6125b extends ProtoAdapter<ShapeArgs> {
            C6125b() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeArgs.class);
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: a */
            public ShapeArgs decode(ProtoReader protoReader) throws IOException {
                C6124a c6124a = new C6124a();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag == -1) {
                        protoReader.endMessage(beginMessage);
                        return c6124a.build();
                    } else if (nextTag != 1) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        c6124a.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        c6124a.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                }
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: b */
            public void encode(ProtoWriter protoWriter, ShapeArgs shapeArgs) throws IOException {
                String str = shapeArgs.d;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
                }
                protoWriter.writeBytes(shapeArgs.unknownFields());
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: c */
            public int encodedSize(ShapeArgs shapeArgs) {
                String str = shapeArgs.d;
                return (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0) + shapeArgs.unknownFields().size();
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs$a, com.youku.squareup.wire.Message$Builder] */
            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: d */
            public ShapeArgs redact(ShapeArgs shapeArgs) {
                ?? newBuilder2 = shapeArgs.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }

        public ShapeArgs(String str) {
            this(str, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShapeArgs) {
                ShapeArgs shapeArgs = (ShapeArgs) obj;
                return unknownFields().equals(shapeArgs.unknownFields()) && Internal.equals(this.d, shapeArgs.d);
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.d;
                int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
                this.hashCode = hashCode2;
                return hashCode2;
            }
            return i;
        }

        @Override // com.youku.squareup.wire.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.d != null) {
                sb.append(", d=");
                sb.append(this.d);
            }
            StringBuilder replace = sb.replace(0, 2, "ShapeArgs{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeArgs(String str, ByteString byteString) {
            super(ADAPTER, byteString);
            this.d = str;
        }

        @Override // com.youku.squareup.wire.Message
        /* renamed from: newBuilder */
        public Message.Builder<ShapeArgs, C6124a> newBuilder2() {
            C6124a c6124a = new C6124a();
            c6124a.a = this.d;
            c6124a.addUnknownFields(unknownFields());
            return c6124a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class ShapeStyle extends Message<ShapeStyle, C6128a> {
        public static final ProtoAdapter<ShapeStyle> ADAPTER = new C6129b();
        public static final LineCap DEFAULT_LINECAP;
        public static final Float DEFAULT_LINEDASHI;
        public static final Float DEFAULT_LINEDASHII;
        public static final Float DEFAULT_LINEDASHIII;
        public static final LineJoin DEFAULT_LINEJOIN;
        public static final Float DEFAULT_MITERLIMIT;
        public static final Float DEFAULT_STROKEWIDTH;
        private static final long serialVersionUID = 0;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 1)
        public final RGBAColor fill;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineCap#ADAPTER", tag = 4)
        public final LineCap lineCap;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
        public final Float lineDashI;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
        public final Float lineDashII;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
        public final Float lineDashIII;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineJoin#ADAPTER", tag = 5)
        public final LineJoin lineJoin;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
        public final Float miterLimit;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 2)
        public final RGBAColor stroke;
        @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float strokeWidth;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum LineCap implements WireEnum {
            LineCap_BUTT(0),
            LineCap_ROUND(1),
            LineCap_SQUARE(2);
            
            public static final ProtoAdapter<LineCap> ADAPTER = ProtoAdapter.newEnumAdapter(LineCap.class);
            private final int value;

            LineCap(int i) {
                this.value = i;
            }

            public static LineCap fromValue(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return LineCap_SQUARE;
                    }
                    return LineCap_ROUND;
                }
                return LineCap_BUTT;
            }

            @Override // com.youku.squareup.wire.WireEnum
            public int getValue() {
                return this.value;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public enum LineJoin implements WireEnum {
            LineJoin_MITER(0),
            LineJoin_ROUND(1),
            LineJoin_BEVEL(2);
            
            public static final ProtoAdapter<LineJoin> ADAPTER = ProtoAdapter.newEnumAdapter(LineJoin.class);
            private final int value;

            LineJoin(int i) {
                this.value = i;
            }

            public static LineJoin fromValue(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return LineJoin_BEVEL;
                    }
                    return LineJoin_ROUND;
                }
                return LineJoin_MITER;
            }

            @Override // com.youku.squareup.wire.WireEnum
            public int getValue() {
                return this.value;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class RGBAColor extends Message<RGBAColor, C6126a> {
            public static final ProtoAdapter<RGBAColor> ADAPTER = new C6127b();
            public static final Float DEFAULT_A;
            public static final Float DEFAULT_B;
            public static final Float DEFAULT_G;
            public static final Float DEFAULT_R;
            private static final long serialVersionUID = 0;
            @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
            public final Float a;
            @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
            public final Float b;
            @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
            public final Float g;
            @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
            public final Float r;

            /* compiled from: Taobao */
            /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor$a */
            /* loaded from: classes10.dex */
            public static final class C6126a extends Message.Builder<RGBAColor, C6126a> {
                public Float a;
                public Float b;
                public Float c;
                public Float d;

                public C6126a a(Float f) {
                    this.d = f;
                    return this;
                }

                public C6126a b(Float f) {
                    this.c = f;
                    return this;
                }

                @Override // com.youku.squareup.wire.Message.Builder
                /* renamed from: c */
                public RGBAColor build() {
                    return new RGBAColor(this.a, this.b, this.c, this.d, super.buildUnknownFields());
                }

                public C6126a d(Float f) {
                    this.b = f;
                    return this;
                }

                public C6126a e(Float f) {
                    this.a = f;
                    return this;
                }
            }

            /* compiled from: Taobao */
            /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor$b */
            /* loaded from: classes10.dex */
            private static final class C6127b extends ProtoAdapter<RGBAColor> {
                C6127b() {
                    super(FieldEncoding.LENGTH_DELIMITED, RGBAColor.class);
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                /* renamed from: a */
                public RGBAColor decode(ProtoReader protoReader) throws IOException {
                    C6126a c6126a = new C6126a();
                    long beginMessage = protoReader.beginMessage();
                    while (true) {
                        int nextTag = protoReader.nextTag();
                        if (nextTag == -1) {
                            protoReader.endMessage(beginMessage);
                            return c6126a.build();
                        } else if (nextTag == 1) {
                            c6126a.e(ProtoAdapter.FLOAT.decode(protoReader));
                        } else if (nextTag == 2) {
                            c6126a.d(ProtoAdapter.FLOAT.decode(protoReader));
                        } else if (nextTag == 3) {
                            c6126a.b(ProtoAdapter.FLOAT.decode(protoReader));
                        } else if (nextTag != 4) {
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            c6126a.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        } else {
                            c6126a.a(ProtoAdapter.FLOAT.decode(protoReader));
                        }
                    }
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                /* renamed from: b */
                public void encode(ProtoWriter protoWriter, RGBAColor rGBAColor) throws IOException {
                    Float f = rGBAColor.r;
                    if (f != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f);
                    }
                    Float f2 = rGBAColor.g;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f2);
                    }
                    Float f3 = rGBAColor.b;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f3);
                    }
                    Float f4 = rGBAColor.a;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, f4);
                    }
                    protoWriter.writeBytes(rGBAColor.unknownFields());
                }

                @Override // com.youku.squareup.wire.ProtoAdapter
                /* renamed from: c */
                public int encodedSize(RGBAColor rGBAColor) {
                    Float f = rGBAColor.r;
                    int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
                    Float f2 = rGBAColor.g;
                    int encodedSizeWithTag2 = encodedSizeWithTag + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2) : 0);
                    Float f3 = rGBAColor.b;
                    int encodedSizeWithTag3 = encodedSizeWithTag2 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3) : 0);
                    Float f4 = rGBAColor.a;
                    return encodedSizeWithTag3 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4) : 0) + rGBAColor.unknownFields().size();
                }

                /* JADX WARN: Type inference failed for: r1v1, types: [com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor$a, com.youku.squareup.wire.Message$Builder] */
                @Override // com.youku.squareup.wire.ProtoAdapter
                /* renamed from: d */
                public RGBAColor redact(RGBAColor rGBAColor) {
                    ?? newBuilder2 = rGBAColor.newBuilder2();
                    newBuilder2.clearUnknownFields();
                    return newBuilder2.build();
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_R = valueOf;
                DEFAULT_G = valueOf;
                DEFAULT_B = valueOf;
                DEFAULT_A = valueOf;
            }

            public RGBAColor(Float f, Float f2, Float f3, Float f4) {
                this(f, f2, f3, f4, ByteString.EMPTY);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof RGBAColor) {
                    RGBAColor rGBAColor = (RGBAColor) obj;
                    return unknownFields().equals(rGBAColor.unknownFields()) && Internal.equals(this.r, rGBAColor.r) && Internal.equals(this.g, rGBAColor.g) && Internal.equals(this.b, rGBAColor.b) && Internal.equals(this.a, rGBAColor.a);
                }
                return false;
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    Float f = this.r;
                    int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
                    Float f2 = this.g;
                    int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
                    Float f3 = this.b;
                    int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
                    Float f4 = this.a;
                    int hashCode5 = hashCode4 + (f4 != null ? f4.hashCode() : 0);
                    this.hashCode = hashCode5;
                    return hashCode5;
                }
                return i;
            }

            @Override // com.youku.squareup.wire.Message
            public String toString() {
                StringBuilder sb = new StringBuilder();
                if (this.r != null) {
                    sb.append(", r=");
                    sb.append(this.r);
                }
                if (this.g != null) {
                    sb.append(", g=");
                    sb.append(this.g);
                }
                if (this.b != null) {
                    sb.append(", b=");
                    sb.append(this.b);
                }
                if (this.a != null) {
                    sb.append(", a=");
                    sb.append(this.a);
                }
                StringBuilder replace = sb.replace(0, 2, "RGBAColor{");
                replace.append('}');
                return replace.toString();
            }

            public RGBAColor(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
                super(ADAPTER, byteString);
                this.r = f;
                this.g = f2;
                this.b = f3;
                this.a = f4;
            }

            @Override // com.youku.squareup.wire.Message
            /* renamed from: newBuilder */
            public Message.Builder<RGBAColor, C6126a> newBuilder2() {
                C6126a c6126a = new C6126a();
                c6126a.a = this.r;
                c6126a.b = this.g;
                c6126a.c = this.b;
                c6126a.d = this.a;
                c6126a.addUnknownFields(unknownFields());
                return c6126a;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$a */
        /* loaded from: classes10.dex */
        public static final class C6128a extends Message.Builder<ShapeStyle, C6128a> {
            public RGBAColor a;
            public RGBAColor b;
            public Float c;
            public LineCap d;
            public LineJoin e;
            public Float f;
            public Float g;
            public Float h;
            public Float i;

            @Override // com.youku.squareup.wire.Message.Builder
            /* renamed from: a */
            public ShapeStyle build() {
                return new ShapeStyle(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, super.buildUnknownFields());
            }

            public C6128a b(RGBAColor rGBAColor) {
                this.a = rGBAColor;
                return this;
            }

            public C6128a c(LineCap lineCap) {
                this.d = lineCap;
                return this;
            }

            public C6128a d(Float f) {
                this.g = f;
                return this;
            }

            public C6128a e(Float f) {
                this.h = f;
                return this;
            }

            public C6128a f(Float f) {
                this.i = f;
                return this;
            }

            public C6128a g(LineJoin lineJoin) {
                this.e = lineJoin;
                return this;
            }

            public C6128a h(Float f) {
                this.f = f;
                return this;
            }

            public C6128a i(RGBAColor rGBAColor) {
                this.b = rGBAColor;
                return this;
            }

            public C6128a j(Float f) {
                this.c = f;
                return this;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$b */
        /* loaded from: classes10.dex */
        private static final class C6129b extends ProtoAdapter<ShapeStyle> {
            C6129b() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeStyle.class);
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: a */
            public ShapeStyle decode(ProtoReader protoReader) throws IOException {
                C6128a c6128a = new C6128a();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                c6128a.b(RGBAColor.ADAPTER.decode(protoReader));
                                break;
                            case 2:
                                c6128a.i(RGBAColor.ADAPTER.decode(protoReader));
                                break;
                            case 3:
                                c6128a.j(ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 4:
                                try {
                                    c6128a.c(LineCap.ADAPTER.decode(protoReader));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                    c6128a.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                                    break;
                                }
                            case 5:
                                try {
                                    c6128a.g(LineJoin.ADAPTER.decode(protoReader));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                    c6128a.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e2.value));
                                    break;
                                }
                            case 6:
                                c6128a.h(ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 7:
                                c6128a.d(ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 8:
                                c6128a.e(ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            case 9:
                                c6128a.f(ProtoAdapter.FLOAT.decode(protoReader));
                                break;
                            default:
                                FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                c6128a.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                break;
                        }
                    } else {
                        protoReader.endMessage(beginMessage);
                        return c6128a.build();
                    }
                }
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: b */
            public void encode(ProtoWriter protoWriter, ShapeStyle shapeStyle) throws IOException {
                RGBAColor rGBAColor = shapeStyle.fill;
                if (rGBAColor != null) {
                    RGBAColor.ADAPTER.encodeWithTag(protoWriter, 1, rGBAColor);
                }
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                if (rGBAColor2 != null) {
                    RGBAColor.ADAPTER.encodeWithTag(protoWriter, 2, rGBAColor2);
                }
                Float f = shapeStyle.strokeWidth;
                if (f != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, f);
                }
                LineCap lineCap = shapeStyle.lineCap;
                if (lineCap != null) {
                    LineCap.ADAPTER.encodeWithTag(protoWriter, 4, lineCap);
                }
                LineJoin lineJoin = shapeStyle.lineJoin;
                if (lineJoin != null) {
                    LineJoin.ADAPTER.encodeWithTag(protoWriter, 5, lineJoin);
                }
                Float f2 = shapeStyle.miterLimit;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 6, f2);
                }
                Float f3 = shapeStyle.lineDashI;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 7, f3);
                }
                Float f4 = shapeStyle.lineDashII;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 8, f4);
                }
                Float f5 = shapeStyle.lineDashIII;
                if (f5 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 9, f5);
                }
                protoWriter.writeBytes(shapeStyle.unknownFields());
            }

            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: c */
            public int encodedSize(ShapeStyle shapeStyle) {
                RGBAColor rGBAColor = shapeStyle.fill;
                int encodedSizeWithTag = rGBAColor != null ? RGBAColor.ADAPTER.encodedSizeWithTag(1, rGBAColor) : 0;
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                int encodedSizeWithTag2 = encodedSizeWithTag + (rGBAColor2 != null ? RGBAColor.ADAPTER.encodedSizeWithTag(2, rGBAColor2) : 0);
                Float f = shapeStyle.strokeWidth;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f) : 0);
                LineCap lineCap = shapeStyle.lineCap;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (lineCap != null ? LineCap.ADAPTER.encodedSizeWithTag(4, lineCap) : 0);
                LineJoin lineJoin = shapeStyle.lineJoin;
                int encodedSizeWithTag5 = encodedSizeWithTag4 + (lineJoin != null ? LineJoin.ADAPTER.encodedSizeWithTag(5, lineJoin) : 0);
                Float f2 = shapeStyle.miterLimit;
                int encodedSizeWithTag6 = encodedSizeWithTag5 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f2) : 0);
                Float f3 = shapeStyle.lineDashI;
                int encodedSizeWithTag7 = encodedSizeWithTag6 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(7, f3) : 0);
                Float f4 = shapeStyle.lineDashII;
                int encodedSizeWithTag8 = encodedSizeWithTag7 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(8, f4) : 0);
                Float f5 = shapeStyle.lineDashIII;
                return encodedSizeWithTag8 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(9, f5) : 0) + shapeStyle.unknownFields().size();
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [com.youku.squareup.wire.Message$Builder, com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$a] */
            @Override // com.youku.squareup.wire.ProtoAdapter
            /* renamed from: d */
            public ShapeStyle redact(ShapeStyle shapeStyle) {
                ?? newBuilder2 = shapeStyle.newBuilder2();
                RGBAColor rGBAColor = newBuilder2.a;
                if (rGBAColor != null) {
                    newBuilder2.a = RGBAColor.ADAPTER.redact(rGBAColor);
                }
                RGBAColor rGBAColor2 = newBuilder2.b;
                if (rGBAColor2 != null) {
                    newBuilder2.b = RGBAColor.ADAPTER.redact(rGBAColor2);
                }
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_STROKEWIDTH = valueOf;
            DEFAULT_LINECAP = LineCap.LineCap_BUTT;
            DEFAULT_LINEJOIN = LineJoin.LineJoin_MITER;
            DEFAULT_MITERLIMIT = valueOf;
            DEFAULT_LINEDASHI = valueOf;
            DEFAULT_LINEDASHII = valueOf;
            DEFAULT_LINEDASHIII = valueOf;
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f, LineCap lineCap, LineJoin lineJoin, Float f2, Float f3, Float f4, Float f5) {
            this(rGBAColor, rGBAColor2, f, lineCap, lineJoin, f2, f3, f4, f5, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShapeStyle) {
                ShapeStyle shapeStyle = (ShapeStyle) obj;
                return unknownFields().equals(shapeStyle.unknownFields()) && Internal.equals(this.fill, shapeStyle.fill) && Internal.equals(this.stroke, shapeStyle.stroke) && Internal.equals(this.strokeWidth, shapeStyle.strokeWidth) && Internal.equals(this.lineCap, shapeStyle.lineCap) && Internal.equals(this.lineJoin, shapeStyle.lineJoin) && Internal.equals(this.miterLimit, shapeStyle.miterLimit) && Internal.equals(this.lineDashI, shapeStyle.lineDashI) && Internal.equals(this.lineDashII, shapeStyle.lineDashII) && Internal.equals(this.lineDashIII, shapeStyle.lineDashIII);
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                RGBAColor rGBAColor = this.fill;
                int hashCode2 = (hashCode + (rGBAColor != null ? rGBAColor.hashCode() : 0)) * 37;
                RGBAColor rGBAColor2 = this.stroke;
                int hashCode3 = (hashCode2 + (rGBAColor2 != null ? rGBAColor2.hashCode() : 0)) * 37;
                Float f = this.strokeWidth;
                int hashCode4 = (hashCode3 + (f != null ? f.hashCode() : 0)) * 37;
                LineCap lineCap = this.lineCap;
                int hashCode5 = (hashCode4 + (lineCap != null ? lineCap.hashCode() : 0)) * 37;
                LineJoin lineJoin = this.lineJoin;
                int hashCode6 = (hashCode5 + (lineJoin != null ? lineJoin.hashCode() : 0)) * 37;
                Float f2 = this.miterLimit;
                int hashCode7 = (hashCode6 + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.lineDashI;
                int hashCode8 = (hashCode7 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.lineDashII;
                int hashCode9 = (hashCode8 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.lineDashIII;
                int hashCode10 = hashCode9 + (f5 != null ? f5.hashCode() : 0);
                this.hashCode = hashCode10;
                return hashCode10;
            }
            return i;
        }

        @Override // com.youku.squareup.wire.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.fill != null) {
                sb.append(", fill=");
                sb.append(this.fill);
            }
            if (this.stroke != null) {
                sb.append(", stroke=");
                sb.append(this.stroke);
            }
            if (this.strokeWidth != null) {
                sb.append(", strokeWidth=");
                sb.append(this.strokeWidth);
            }
            if (this.lineCap != null) {
                sb.append(", lineCap=");
                sb.append(this.lineCap);
            }
            if (this.lineJoin != null) {
                sb.append(", lineJoin=");
                sb.append(this.lineJoin);
            }
            if (this.miterLimit != null) {
                sb.append(", miterLimit=");
                sb.append(this.miterLimit);
            }
            if (this.lineDashI != null) {
                sb.append(", lineDashI=");
                sb.append(this.lineDashI);
            }
            if (this.lineDashII != null) {
                sb.append(", lineDashII=");
                sb.append(this.lineDashII);
            }
            if (this.lineDashIII != null) {
                sb.append(", lineDashIII=");
                sb.append(this.lineDashIII);
            }
            StringBuilder replace = sb.replace(0, 2, "ShapeStyle{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f, LineCap lineCap, LineJoin lineJoin, Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            this.fill = rGBAColor;
            this.stroke = rGBAColor2;
            this.strokeWidth = f;
            this.lineCap = lineCap;
            this.lineJoin = lineJoin;
            this.miterLimit = f2;
            this.lineDashI = f3;
            this.lineDashII = f4;
            this.lineDashIII = f5;
        }

        @Override // com.youku.squareup.wire.Message
        /* renamed from: newBuilder */
        public Message.Builder<ShapeStyle, C6128a> newBuilder2() {
            C6128a c6128a = new C6128a();
            c6128a.a = this.fill;
            c6128a.b = this.stroke;
            c6128a.c = this.strokeWidth;
            c6128a.d = this.lineCap;
            c6128a.e = this.lineJoin;
            c6128a.f = this.miterLimit;
            c6128a.g = this.lineDashI;
            c6128a.h = this.lineDashII;
            c6128a.i = this.lineDashIII;
            c6128a.addUnknownFields(unknownFields());
            return c6128a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum ShapeType implements WireEnum {
        SHAPE(0),
        RECT(1),
        ELLIPSE(2),
        KEEP(3);
        
        public static final ProtoAdapter<ShapeType> ADAPTER = ProtoAdapter.newEnumAdapter(ShapeType.class);
        private final int value;

        ShapeType(int i) {
            this.value = i;
        }

        public static ShapeType fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return KEEP;
                    }
                    return ELLIPSE;
                }
                return RECT;
            }
            return SHAPE;
        }

        @Override // com.youku.squareup.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$a */
    /* loaded from: classes10.dex */
    public static final class C6130a extends Message.Builder<ShapeEntity, C6130a> {
        public ShapeType a;
        public ShapeStyle b;
        public Transform c;
        public ShapeArgs d;
        public RectArgs e;
        public EllipseArgs f;

        @Override // com.youku.squareup.wire.Message.Builder
        /* renamed from: a */
        public ShapeEntity build() {
            return new ShapeEntity(this.a, this.b, this.c, this.d, this.e, this.f, super.buildUnknownFields());
        }

        public C6130a b(EllipseArgs ellipseArgs) {
            this.f = ellipseArgs;
            this.d = null;
            this.e = null;
            return this;
        }

        public C6130a c(RectArgs rectArgs) {
            this.e = rectArgs;
            this.d = null;
            this.f = null;
            return this;
        }

        public C6130a d(ShapeArgs shapeArgs) {
            this.d = shapeArgs;
            this.e = null;
            this.f = null;
            return this;
        }

        public C6130a e(ShapeStyle shapeStyle) {
            this.b = shapeStyle;
            return this;
        }

        public C6130a f(Transform transform) {
            this.c = transform;
            return this;
        }

        public C6130a g(ShapeType shapeType) {
            this.a = shapeType;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.opensource.svgaplayer.proto.ShapeEntity$b */
    /* loaded from: classes10.dex */
    private static final class C6131b extends ProtoAdapter<ShapeEntity> {
        C6131b() {
            super(FieldEncoding.LENGTH_DELIMITED, ShapeEntity.class);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public ShapeEntity decode(ProtoReader protoReader) throws IOException {
            C6130a c6130a = new C6130a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return c6130a.build();
                } else if (nextTag == 1) {
                    try {
                        c6130a.g(ShapeType.ADAPTER.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                        c6130a.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e.value));
                    }
                } else if (nextTag == 2) {
                    c6130a.d(ShapeArgs.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    c6130a.c(RectArgs.ADAPTER.decode(protoReader));
                } else if (nextTag == 4) {
                    c6130a.b(EllipseArgs.ADAPTER.decode(protoReader));
                } else if (nextTag == 10) {
                    c6130a.e(ShapeStyle.ADAPTER.decode(protoReader));
                } else if (nextTag != 11) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    c6130a.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    c6130a.f(Transform.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, ShapeEntity shapeEntity) throws IOException {
            ShapeType shapeType = shapeEntity.type;
            if (shapeType != null) {
                ShapeType.ADAPTER.encodeWithTag(protoWriter, 1, shapeType);
            }
            ShapeStyle shapeStyle = shapeEntity.styles;
            if (shapeStyle != null) {
                ShapeStyle.ADAPTER.encodeWithTag(protoWriter, 10, shapeStyle);
            }
            Transform transform = shapeEntity.transform;
            if (transform != null) {
                Transform.ADAPTER.encodeWithTag(protoWriter, 11, transform);
            }
            ShapeArgs shapeArgs = shapeEntity.shape;
            if (shapeArgs != null) {
                ShapeArgs.ADAPTER.encodeWithTag(protoWriter, 2, shapeArgs);
            }
            RectArgs rectArgs = shapeEntity.rect;
            if (rectArgs != null) {
                RectArgs.ADAPTER.encodeWithTag(protoWriter, 3, rectArgs);
            }
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            if (ellipseArgs != null) {
                EllipseArgs.ADAPTER.encodeWithTag(protoWriter, 4, ellipseArgs);
            }
            protoWriter.writeBytes(shapeEntity.unknownFields());
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(ShapeEntity shapeEntity) {
            ShapeType shapeType = shapeEntity.type;
            int encodedSizeWithTag = shapeType != null ? ShapeType.ADAPTER.encodedSizeWithTag(1, shapeType) : 0;
            ShapeStyle shapeStyle = shapeEntity.styles;
            int encodedSizeWithTag2 = encodedSizeWithTag + (shapeStyle != null ? ShapeStyle.ADAPTER.encodedSizeWithTag(10, shapeStyle) : 0);
            Transform transform = shapeEntity.transform;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (transform != null ? Transform.ADAPTER.encodedSizeWithTag(11, transform) : 0);
            ShapeArgs shapeArgs = shapeEntity.shape;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (shapeArgs != null ? ShapeArgs.ADAPTER.encodedSizeWithTag(2, shapeArgs) : 0);
            RectArgs rectArgs = shapeEntity.rect;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (rectArgs != null ? RectArgs.ADAPTER.encodedSizeWithTag(3, rectArgs) : 0);
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            return encodedSizeWithTag5 + (ellipseArgs != null ? EllipseArgs.ADAPTER.encodedSizeWithTag(4, ellipseArgs) : 0) + shapeEntity.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.opensource.svgaplayer.proto.ShapeEntity$a, com.youku.squareup.wire.Message$Builder] */
        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public ShapeEntity redact(ShapeEntity shapeEntity) {
            ?? newBuilder2 = shapeEntity.newBuilder2();
            ShapeStyle shapeStyle = newBuilder2.b;
            if (shapeStyle != null) {
                newBuilder2.b = ShapeStyle.ADAPTER.redact(shapeStyle);
            }
            Transform transform = newBuilder2.c;
            if (transform != null) {
                newBuilder2.c = Transform.ADAPTER.redact(transform);
            }
            ShapeArgs shapeArgs = newBuilder2.d;
            if (shapeArgs != null) {
                newBuilder2.d = ShapeArgs.ADAPTER.redact(shapeArgs);
            }
            RectArgs rectArgs = newBuilder2.e;
            if (rectArgs != null) {
                newBuilder2.e = RectArgs.ADAPTER.redact(rectArgs);
            }
            EllipseArgs ellipseArgs = newBuilder2.f;
            if (ellipseArgs != null) {
                newBuilder2.f = EllipseArgs.ADAPTER.redact(ellipseArgs);
            }
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs) {
        this(shapeType, shapeStyle, transform, shapeArgs, rectArgs, ellipseArgs, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ShapeEntity) {
            ShapeEntity shapeEntity = (ShapeEntity) obj;
            return unknownFields().equals(shapeEntity.unknownFields()) && Internal.equals(this.type, shapeEntity.type) && Internal.equals(this.styles, shapeEntity.styles) && Internal.equals(this.transform, shapeEntity.transform) && Internal.equals(this.shape, shapeEntity.shape) && Internal.equals(this.rect, shapeEntity.rect) && Internal.equals(this.ellipse, shapeEntity.ellipse);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            ShapeType shapeType = this.type;
            int hashCode2 = (hashCode + (shapeType != null ? shapeType.hashCode() : 0)) * 37;
            ShapeStyle shapeStyle = this.styles;
            int hashCode3 = (hashCode2 + (shapeStyle != null ? shapeStyle.hashCode() : 0)) * 37;
            Transform transform = this.transform;
            int hashCode4 = (hashCode3 + (transform != null ? transform.hashCode() : 0)) * 37;
            ShapeArgs shapeArgs = this.shape;
            int hashCode5 = (hashCode4 + (shapeArgs != null ? shapeArgs.hashCode() : 0)) * 37;
            RectArgs rectArgs = this.rect;
            int hashCode6 = (hashCode5 + (rectArgs != null ? rectArgs.hashCode() : 0)) * 37;
            EllipseArgs ellipseArgs = this.ellipse;
            int hashCode7 = hashCode6 + (ellipseArgs != null ? ellipseArgs.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.styles != null) {
            sb.append(", styles=");
            sb.append(this.styles);
        }
        if (this.transform != null) {
            sb.append(", transform=");
            sb.append(this.transform);
        }
        if (this.shape != null) {
            sb.append(", shape=");
            sb.append(this.shape);
        }
        if (this.rect != null) {
            sb.append(", rect=");
            sb.append(this.rect);
        }
        if (this.ellipse != null) {
            sb.append(", ellipse=");
            sb.append(this.ellipse);
        }
        StringBuilder replace = sb.replace(0, 2, "ShapeEntity{");
        replace.append('}');
        return replace.toString();
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs, ByteString byteString) {
        super(ADAPTER, byteString);
        if (Internal.countNonNull(shapeArgs, rectArgs, ellipseArgs) <= 1) {
            this.type = shapeType;
            this.styles = shapeStyle;
            this.transform = transform;
            this.shape = shapeArgs;
            this.rect = rectArgs;
            this.ellipse = ellipseArgs;
            return;
        }
        throw new IllegalArgumentException("at most one of shape, rect, ellipse may be non-null");
    }

    @Override // com.youku.squareup.wire.Message
    /* renamed from: newBuilder */
    public Message.Builder<ShapeEntity, C6130a> newBuilder2() {
        C6130a c6130a = new C6130a();
        c6130a.a = this.type;
        c6130a.b = this.styles;
        c6130a.c = this.transform;
        c6130a.d = this.shape;
        c6130a.e = this.rect;
        c6130a.f = this.ellipse;
        c6130a.addUnknownFields(unknownFields());
        return c6130a;
    }
}
