package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ProtoBuf$TypeAlias extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeAlias> implements ProtoBuf$TypeAliasOrBuilder {
    public static Parser<ProtoBuf$TypeAlias> PARSER = new a();
    private static final ProtoBuf$TypeAlias defaultInstance;
    private List<ProtoBuf$Annotation> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private ProtoBuf$Type expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private int underlyingTypeId_;
    private ProtoBuf$Type underlyingType_;
    private final ByteString unknownFields;
    private List<Integer> versionRequirement_;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeAlias, Builder> implements ProtoBuf$TypeAliasOrBuilder {
        private int bitField0_;
        private int expandedTypeId_;
        private int name_;
        private int underlyingTypeId_;
        private int flags_ = 6;
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private ProtoBuf$Type underlyingType_ = ProtoBuf$Type.getDefaultInstance();
        private ProtoBuf$Type expandedType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$Annotation> annotation_ = Collections.emptyList();
        private List<Integer> versionRequirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$18100() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureAnnotationIsMutable() {
            if ((this.bitField0_ & 128) != 128) {
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= 128;
            }
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 4) != 4) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 4;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 256) != 256) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 256;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$TypeAlias buildPartial() {
            ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 1 ? 0 : 1;
            protoBuf$TypeAlias.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$TypeAlias.name_ = this.name_;
            if ((this.bitField0_ & 4) == 4) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            }
            protoBuf$TypeAlias.typeParameter_ = this.typeParameter_;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            protoBuf$TypeAlias.underlyingType_ = this.underlyingType_;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            protoBuf$TypeAlias.underlyingTypeId_ = this.underlyingTypeId_;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            protoBuf$TypeAlias.expandedType_ = this.expandedType_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$TypeAlias.expandedTypeId_ = this.expandedTypeId_;
            if ((this.bitField0_ & 128) == 128) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            }
            protoBuf$TypeAlias.annotation_ = this.annotation_;
            if ((this.bitField0_ & 256) == 256) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            }
            protoBuf$TypeAlias.versionRequirement_ = this.versionRequirement_;
            protoBuf$TypeAlias.bitField0_ = i2;
            return protoBuf$TypeAlias;
        }

        public ProtoBuf$Annotation getAnnotation(int i) {
            return this.annotation_.get(i);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public ProtoBuf$Type getExpandedType() {
            return this.expandedType_;
        }

        public ProtoBuf$TypeParameter getTypeParameter(int i) {
            return this.typeParameter_.get(i);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public ProtoBuf$Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasName()) {
                for (int i = 0; i < getTypeParameterCount(); i++) {
                    if (!getTypeParameter(i).isInitialized()) {
                        return false;
                    }
                }
                if (!hasUnderlyingType() || getUnderlyingType().isInitialized()) {
                    if (!hasExpandedType() || getExpandedType().isInitialized()) {
                        for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
                            if (!getAnnotation(i2).isInitialized()) {
                                return false;
                            }
                        }
                        return extensionsAreInitialized();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public Builder mergeExpandedType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 32) == 32 && this.expandedType_ != ProtoBuf$Type.getDefaultInstance()) {
                this.expandedType_ = ProtoBuf$Type.newBuilder(this.expandedType_).mergeFrom(protoBuf$Type).buildPartial();
            } else {
                this.expandedType_ = protoBuf$Type;
            }
            this.bitField0_ |= 32;
            return this;
        }

        public Builder mergeUnderlyingType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) == 8 && this.underlyingType_ != ProtoBuf$Type.getDefaultInstance()) {
                this.underlyingType_ = ProtoBuf$Type.newBuilder(this.underlyingType_).mergeFrom(protoBuf$Type).buildPartial();
            } else {
                this.underlyingType_ = protoBuf$Type;
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder setExpandedTypeId(int i) {
            this.bitField0_ |= 64;
            this.expandedTypeId_ = i;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setName(int i) {
            this.bitField0_ |= 2;
            this.name_ = i;
            return this;
        }

        public Builder setUnderlyingTypeId(int i) {
            this.bitField0_ |= 16;
            this.underlyingTypeId_ = i;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$TypeAlias build() {
            ProtoBuf$TypeAlias buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ProtoBuf$TypeAlias getDefaultInstanceForType() {
            return ProtoBuf$TypeAlias.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
            if (protoBuf$TypeAlias == ProtoBuf$TypeAlias.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$TypeAlias.hasFlags()) {
                setFlags(protoBuf$TypeAlias.getFlags());
            }
            if (protoBuf$TypeAlias.hasName()) {
                setName(protoBuf$TypeAlias.getName());
            }
            if (!protoBuf$TypeAlias.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$TypeAlias.typeParameter_;
                    this.bitField0_ &= -5;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$TypeAlias.typeParameter_);
                }
            }
            if (protoBuf$TypeAlias.hasUnderlyingType()) {
                mergeUnderlyingType(protoBuf$TypeAlias.getUnderlyingType());
            }
            if (protoBuf$TypeAlias.hasUnderlyingTypeId()) {
                setUnderlyingTypeId(protoBuf$TypeAlias.getUnderlyingTypeId());
            }
            if (protoBuf$TypeAlias.hasExpandedType()) {
                mergeExpandedType(protoBuf$TypeAlias.getExpandedType());
            }
            if (protoBuf$TypeAlias.hasExpandedTypeId()) {
                setExpandedTypeId(protoBuf$TypeAlias.getExpandedTypeId());
            }
            if (!protoBuf$TypeAlias.annotation_.isEmpty()) {
                if (this.annotation_.isEmpty()) {
                    this.annotation_ = protoBuf$TypeAlias.annotation_;
                    this.bitField0_ &= -129;
                } else {
                    ensureAnnotationIsMutable();
                    this.annotation_.addAll(protoBuf$TypeAlias.annotation_);
                }
            }
            if (!protoBuf$TypeAlias.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$TypeAlias.versionRequirement_;
                    this.bitField0_ &= -257;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$TypeAlias.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$TypeAlias);
            setUnknownFields(getUnknownFields().b(protoBuf$TypeAlias.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.c r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                if (r3 == 0) goto Le
                r2.mergeFrom(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.mergeFrom(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.Builder.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.c):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias$Builder");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$TypeAlias> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        /* renamed from: i */
        public ProtoBuf$TypeAlias parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$TypeAlias(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(true);
        defaultInstance = protoBuf$TypeAlias;
        protoBuf$TypeAlias.initFields();
    }

    public static ProtoBuf$TypeAlias getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.name_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.underlyingType_ = ProtoBuf$Type.getDefaultInstance();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = ProtoBuf$Type.getDefaultInstance();
        this.expandedTypeId_ = 0;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$18100();
    }

    public static ProtoBuf$TypeAlias parseDelimitedFrom(InputStream inputStream, c cVar) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, cVar);
    }

    public ProtoBuf$Annotation getAnnotation(int i) {
        return this.annotation_.get(i);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<ProtoBuf$Annotation> getAnnotationList() {
        return this.annotation_;
    }

    public ProtoBuf$Type getExpandedType() {
        return this.expandedType_;
    }

    public int getExpandedTypeId() {
        return this.expandedTypeId_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$TypeAlias> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int o = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            o += CodedOutputStream.o(2, this.name_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            o += CodedOutputStream.s(3, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 4) == 4) {
            o += CodedOutputStream.s(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            o += CodedOutputStream.o(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            o += CodedOutputStream.s(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            o += CodedOutputStream.o(7, this.expandedTypeId_);
        }
        for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
            o += CodedOutputStream.s(8, this.annotation_.get(i3));
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
            i4 += CodedOutputStream.p(this.versionRequirement_.get(i5).intValue());
        }
        int size = o + i4 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public ProtoBuf$TypeParameter getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public ProtoBuf$Type getUnderlyingType() {
        return this.underlyingType_;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasExpandedType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasExpandedTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasUnderlyingType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasUnderlyingTypeId() {
        return (this.bitField0_ & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (hasExpandedType() && !getExpandedType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else {
            for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
                if (!getAnnotation(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.a0(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.a0(2, this.name_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.d0(3, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.d0(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.a0(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.d0(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.a0(7, this.expandedTypeId_);
        }
        for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
            codedOutputStream.d0(8, this.annotation_.get(i2));
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.a0(31, this.versionRequirement_.get(i3).intValue());
        }
        newExtensionWriter.a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        return newBuilder().mergeFrom(protoBuf$TypeAlias);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeAlias getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$TypeAlias(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeAlias, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$TypeAlias(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private ProtoBuf$TypeAlias(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
        ProtoBuf$Type.Builder builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.a n = ByteString.n();
        CodedOutputStream J = CodedOutputStream.J(n, 1);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            ?? r5 = 128;
            if (!z) {
                try {
                    try {
                        try {
                            int K = codedInputStream.K();
                            switch (K) {
                                case 0:
                                    break;
                                case 8:
                                    this.bitField0_ |= 1;
                                    this.flags_ = codedInputStream.s();
                                    continue;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.name_ = codedInputStream.s();
                                    continue;
                                case 26:
                                    if (!(z2 & true)) {
                                        this.typeParameter_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.typeParameter_.add(codedInputStream.u(ProtoBuf$TypeParameter.PARSER, cVar));
                                    continue;
                                case 34:
                                    builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                    ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                                    this.underlyingType_ = protoBuf$Type;
                                    if (builder != null) {
                                        builder.mergeFrom(protoBuf$Type);
                                        this.underlyingType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                    continue;
                                case 40:
                                    this.bitField0_ |= 8;
                                    this.underlyingTypeId_ = codedInputStream.s();
                                    continue;
                                case 50:
                                    builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                    ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.u(ProtoBuf$Type.PARSER, cVar);
                                    this.expandedType_ = protoBuf$Type2;
                                    if (builder != null) {
                                        builder.mergeFrom(protoBuf$Type2);
                                        this.expandedType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                    continue;
                                case 56:
                                    this.bitField0_ |= 32;
                                    this.expandedTypeId_ = codedInputStream.s();
                                    continue;
                                case 66:
                                    if (!(z2 & true)) {
                                        this.annotation_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.annotation_.add(codedInputStream.u(ProtoBuf$Annotation.PARSER, cVar));
                                    continue;
                                case 248:
                                    if (!(z2 & true)) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.s()));
                                    continue;
                                case 250:
                                    int j = codedInputStream.j(codedInputStream.A());
                                    if (!(z2 & true) && codedInputStream.e() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.e() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.s()));
                                    }
                                    codedInputStream.i(j);
                                    continue;
                                    break;
                                default:
                                    r5 = parseUnknownField(codedInputStream, J, cVar, K);
                                    if (r5 == 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((z2 & true) == r5) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if (z2 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = n.f();
                        throw th2;
                    }
                    this.unknownFields = n.f();
                    makeExtensionsImmutable();
                    throw th;
                }
            } else {
                if (z2 & true) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if (z2 & true) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if (z2 & true) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = n.f();
                    throw th3;
                }
                this.unknownFields = n.f();
                makeExtensionsImmutable();
                return;
            }
        }
    }
}
