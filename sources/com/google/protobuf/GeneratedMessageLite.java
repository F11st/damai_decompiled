package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.Builder;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    protected C5417m b = C5417m.a();
    protected int c = -1;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (MessageType) messagetype.h(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void copyOnWrite() {
            if (this.isBuilt) {
                MessageType messagetype = (MessageType) this.instance.h(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                messagetype.x(C5383g.INSTANCE, this.instance);
                this.instance = messagetype;
                this.isBuilt = false;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return internalMergeFrom((Builder<MessageType, BuilderType>) ((GeneratedMessageLite) abstractMessageLite));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.p(this.instance, false);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.q();
            this.isBuilt = true;
            return this.instance;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public final BuilderType clear() {
            this.instance = (MessageType) this.instance.h(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        protected BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom((Builder<MessageType, BuilderType>) messagetype);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            this.instance.x(C5383g.INSTANCE, messagetype);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo493clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream codedInputStream, C5401g c5401g) throws IOException {
            copyOnWrite();
            try {
                this.instance.j(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, c5401g);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class EqualsVisitor implements Visitor {
        static final EqualsVisitor a = new EqualsVisitor();
        static final NotEqualsException b = new NotEqualsException();

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        static final class NotEqualsException extends RuntimeException {
            NotEqualsException() {
            }
        }

        private EqualsVisitor() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3 && z2 == z4) {
                return z2;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            if (booleanList.equals(booleanList2)) {
                return booleanList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            if (z == z2 && byteString.equals(byteString2)) {
                return byteString;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            if (z == z2 && d == d2) {
                return d;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            if (doubleList.equals(doubleList2)) {
                return doubleList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<C5380d> visitExtensions(FieldSet<C5380d> fieldSet, FieldSet<C5380d> fieldSet2) {
            if (fieldSet.equals(fieldSet2)) {
                return fieldSet;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            if (z == z2 && f == f2) {
                return f;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            if (floatList.equals(floatList2)) {
                return floatList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean z, int i, boolean z2, int i2) {
            if (z == z2 && i == i2) {
                return i;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            if (intList.equals(intList2)) {
                return intList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public C5406i visitLazyMessage(C5406i c5406i, C5406i c5406i2) {
            if (c5406i == null && c5406i2 == null) {
                return null;
            }
            if (c5406i != null && c5406i2 != null) {
                if (c5406i.equals(c5406i2)) {
                    return c5406i;
                }
                throw b;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            if (protobufList.equals(protobufList2)) {
                return protobufList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean z, long j, boolean z2, long j2) {
            if (z == z2 && j == j2) {
                return j;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            if (longList.equals(longList2)) {
                return longList;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (mapFieldLite.equals(mapFieldLite2)) {
                return mapFieldLite;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t != null && t2 != null) {
                ((GeneratedMessageLite) t).l(this, t2);
                return t;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            if (z && ((GeneratedMessageLite) obj).l(this, (MessageLite) obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean z) {
            if (z) {
                throw b;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            if (z && obj.equals(obj2)) {
                return obj;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean z, String str, boolean z2, String str2) {
            if (z == z2 && str.equals(str2)) {
                return str;
            }
            throw b;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public C5417m visitUnknownFields(C5417m c5417m, C5417m c5417m2) {
            if (c5417m.equals(c5417m2)) {
                return c5417m;
            }
            throw b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class ExtendableBuilder<MessageType extends AbstractC5379c<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
            MessageType messagetype2 = this.instance;
            ((AbstractC5379c) messagetype2).d = ((AbstractC5379c) messagetype2).d.clone();
        }

        private void verifyExtensionContainingType(C5381e<MessageType, ?> c5381e) {
            if (c5381e.c() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType addExtension(AbstractC5399e<MessageType, List<Type>> abstractC5399e, Type type) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            verifyExtensionContainingType(f);
            copyOnWrite();
            ((AbstractC5379c) this.instance).d.a(f.c, f.e(type));
            return this;
        }

        public final <Type> BuilderType clearExtension(AbstractC5399e<MessageType, ?> abstractC5399e) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            verifyExtensionContainingType(f);
            copyOnWrite();
            ((AbstractC5379c) this.instance).d.b(f.c);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public void copyOnWrite() {
            if (this.isBuilt) {
                super.copyOnWrite();
                MessageType messagetype = this.instance;
                ((AbstractC5379c) messagetype).d = ((AbstractC5379c) messagetype).d.clone();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(AbstractC5399e<MessageType, Type> abstractC5399e) {
            return (Type) ((AbstractC5379c) this.instance).getExtension(abstractC5399e);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(AbstractC5399e<MessageType, List<Type>> abstractC5399e) {
            return ((AbstractC5379c) this.instance).getExtensionCount(abstractC5399e);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(AbstractC5399e<MessageType, Type> abstractC5399e) {
            return ((AbstractC5379c) this.instance).hasExtension(abstractC5399e);
        }

        void internalSetExtensionSet(FieldSet<C5380d> fieldSet) {
            copyOnWrite();
            ((AbstractC5379c) this.instance).d = fieldSet;
        }

        public final <Type> BuilderType setExtension(AbstractC5399e<MessageType, Type> abstractC5399e, Type type) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            verifyExtensionContainingType(f);
            copyOnWrite();
            ((AbstractC5379c) this.instance).d.o(f.c, f.f(type));
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(AbstractC5399e<MessageType, List<Type>> abstractC5399e, int i) {
            return (Type) ((AbstractC5379c) this.instance).getExtension(abstractC5399e, i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public final MessageType buildPartial() {
            if (this.isBuilt) {
                return (MessageType) this.instance;
            }
            ((AbstractC5379c) this.instance).d.k();
            return (MessageType) super.buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo493clone() {
            return (BuilderType) super.mo493clone();
        }

        public final <Type> BuilderType setExtension(AbstractC5399e<MessageType, List<Type>> abstractC5399e, int i, Type type) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            verifyExtensionContainingType(f);
            copyOnWrite();
            ((AbstractC5379c) this.instance).d.p(f.c, i, f.e(type));
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends AbstractC5379c<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(AbstractC5399e<MessageType, Type> abstractC5399e);

        <Type> Type getExtension(AbstractC5399e<MessageType, List<Type>> abstractC5399e, int i);

        <Type> int getExtensionCount(AbstractC5399e<MessageType, List<Type>> abstractC5399e);

        <Type> boolean hasExtension(AbstractC5399e<MessageType, Type> abstractC5399e);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum MethodToInvoke {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final String messageClassName;

        SerializedForm(MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        public static SerializedForm of(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException("Unable to understand proto buffer", e);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call parsePartialFrom", e3);
            } catch (NoSuchFieldException e4) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e4);
            } catch (SecurityException e5) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e5);
            }
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException("Unable to understand proto buffer", e);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call parsePartialFrom", e3);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e4) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface Visitor {
        boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4);

        Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2);

        ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2);

        double visitDouble(boolean z, double d, boolean z2, double d2);

        Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2);

        FieldSet<C5380d> visitExtensions(FieldSet<C5380d> fieldSet, FieldSet<C5380d> fieldSet2);

        float visitFloat(boolean z, float f, boolean z2, float f2);

        Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2);

        int visitInt(boolean z, int i, boolean z2, int i2);

        Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2);

        C5406i visitLazyMessage(C5406i c5406i, C5406i c5406i2);

        <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2);

        long visitLong(boolean z, long j, boolean z2, long j2);

        Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2);

        <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2);

        <T extends MessageLite> T visitMessage(T t, T t2);

        Object visitOneofBoolean(boolean z, Object obj, Object obj2);

        Object visitOneofByteString(boolean z, Object obj, Object obj2);

        Object visitOneofDouble(boolean z, Object obj, Object obj2);

        Object visitOneofFloat(boolean z, Object obj, Object obj2);

        Object visitOneofInt(boolean z, Object obj, Object obj2);

        Object visitOneofLazyMessage(boolean z, Object obj, Object obj2);

        Object visitOneofLong(boolean z, Object obj, Object obj2);

        Object visitOneofMessage(boolean z, Object obj, Object obj2);

        void visitOneofNotSet(boolean z);

        Object visitOneofString(boolean z, Object obj, Object obj2);

        String visitString(boolean z, String str, boolean z2, String str2);

        C5417m visitUnknownFields(C5417m c5417m, C5417m c5417m2);
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.GeneratedMessageLite$b */
    /* loaded from: classes10.dex */
    protected static class C5378b<T extends GeneratedMessageLite<T, ?>> extends AbstractC5395a<T> {
        private T b;

        public C5378b(T t) {
            this.b = t;
        }

        @Override // com.google.protobuf.Parser
        /* renamed from: z */
        public T parsePartialFrom(CodedInputStream codedInputStream, C5401g c5401g) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.u(this.b, codedInputStream, c5401g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.GeneratedMessageLite$d */
    /* loaded from: classes10.dex */
    public static final class C5380d implements FieldSet.FieldDescriptorLite<C5380d> {
        final Internal.EnumLiteMap<?> a;
        final int b;
        final WireFormat.FieldType c;
        final boolean d;
        final boolean e;

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C5380d c5380d) {
            return this.b - c5380d.b;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.a;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.c.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.c;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((Builder) ((GeneratedMessageLite) messageLite));
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.e;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.GeneratedMessageLite$e */
    /* loaded from: classes10.dex */
    public static class C5381e<ContainingType extends MessageLite, Type> extends AbstractC5399e<ContainingType, Type> {
        final ContainingType a;
        final Type b;
        final C5380d c;

        Object b(Object obj) {
            if (this.c.isRepeated()) {
                if (this.c.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(d(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return d(obj);
        }

        public ContainingType c() {
            return this.a;
        }

        Object d(Object obj) {
            return this.c.getLiteJavaType() == WireFormat.JavaType.ENUM ? this.c.a.findValueByNumber(((Integer) obj).intValue()) : obj;
        }

        Object e(Object obj) {
            return this.c.getLiteJavaType() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).getNumber()) : obj;
        }

        Object f(Object obj) {
            if (this.c.isRepeated()) {
                if (this.c.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(e(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return e(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.GeneratedMessageLite$f */
    /* loaded from: classes10.dex */
    public static class C5382f implements Visitor {
        private int a;

        private C5382f() {
            this.a = 0;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            this.a = (this.a * 53) + Internal.a(z2);
            return z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            this.a = (this.a * 53) + booleanList.hashCode();
            return booleanList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            this.a = (this.a * 53) + byteString.hashCode();
            return byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            this.a = (this.a * 53) + Internal.d(Double.doubleToLongBits(d));
            return d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            this.a = (this.a * 53) + doubleList.hashCode();
            return doubleList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<C5380d> visitExtensions(FieldSet<C5380d> fieldSet, FieldSet<C5380d> fieldSet2) {
            this.a = (this.a * 53) + fieldSet.hashCode();
            return fieldSet;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            this.a = (this.a * 53) + Float.floatToIntBits(f);
            return f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            this.a = (this.a * 53) + floatList.hashCode();
            return floatList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean z, int i, boolean z2, int i2) {
            this.a = (this.a * 53) + i;
            return i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            this.a = (this.a * 53) + intList.hashCode();
            return intList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public C5406i visitLazyMessage(C5406i c5406i, C5406i c5406i2) {
            this.a = (this.a * 53) + (c5406i != null ? c5406i.hashCode() : 37);
            return c5406i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            this.a = (this.a * 53) + protobufList.hashCode();
            return protobufList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean z, long j, boolean z2, long j2) {
            this.a = (this.a * 53) + Internal.d(j);
            return j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            this.a = (this.a * 53) + longList.hashCode();
            return longList;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            this.a = (this.a * 53) + mapFieldLite.hashCode();
            return mapFieldLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T t, T t2) {
            int i;
            if (t == null) {
                i = 37;
            } else if (t instanceof GeneratedMessageLite) {
                i = ((GeneratedMessageLite) t).n(this);
            } else {
                i = t.hashCode();
            }
            this.a = (this.a * 53) + i;
            return t;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + Internal.a(((Boolean) obj).booleanValue());
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + obj.hashCode();
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + Internal.d(Double.doubleToLongBits(((Double) obj).doubleValue()));
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + Float.floatToIntBits(((Float) obj).floatValue());
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + ((Integer) obj).intValue();
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + obj.hashCode();
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + Internal.d(((Long) obj).longValue());
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            return visitMessage((MessageLite) obj, (MessageLite) obj2);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean z) {
            if (z) {
                throw new IllegalStateException();
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            this.a = (this.a * 53) + obj.hashCode();
            return obj;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean z, String str, boolean z2, String str2) {
            this.a = (this.a * 53) + str.hashCode();
            return str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public C5417m visitUnknownFields(C5417m c5417m, C5417m c5417m2) {
            this.a = (this.a * 53) + c5417m.hashCode();
            return c5417m;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.GeneratedMessageLite$g */
    /* loaded from: classes10.dex */
    public static class C5383g implements Visitor {
        public static final C5383g INSTANCE = new C5383g();

        private C5383g() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public boolean visitBoolean(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.BooleanList visitBooleanList(Internal.BooleanList booleanList, Internal.BooleanList booleanList2) {
            int size = booleanList.size();
            int size2 = booleanList2.size();
            Internal.BooleanList booleanList3 = booleanList;
            booleanList3 = booleanList;
            if (size > 0 && size2 > 0) {
                boolean isModifiable = booleanList.isModifiable();
                Internal.ProtobufList<Boolean> protobufList = booleanList;
                if (!isModifiable) {
                    protobufList = booleanList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(booleanList2);
                booleanList3 = protobufList;
            }
            return size > 0 ? booleanList3 : booleanList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public ByteString visitByteString(boolean z, ByteString byteString, boolean z2, ByteString byteString2) {
            return z2 ? byteString2 : byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public double visitDouble(boolean z, double d, boolean z2, double d2) {
            return z2 ? d2 : d;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.DoubleList visitDoubleList(Internal.DoubleList doubleList, Internal.DoubleList doubleList2) {
            int size = doubleList.size();
            int size2 = doubleList2.size();
            Internal.DoubleList doubleList3 = doubleList;
            doubleList3 = doubleList;
            if (size > 0 && size2 > 0) {
                boolean isModifiable = doubleList.isModifiable();
                Internal.ProtobufList<Double> protobufList = doubleList;
                if (!isModifiable) {
                    protobufList = doubleList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(doubleList2);
                doubleList3 = protobufList;
            }
            return size > 0 ? doubleList3 : doubleList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public FieldSet<C5380d> visitExtensions(FieldSet<C5380d> fieldSet, FieldSet<C5380d> fieldSet2) {
            if (fieldSet.i()) {
                fieldSet = fieldSet.clone();
            }
            fieldSet.l(fieldSet2);
            return fieldSet;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public float visitFloat(boolean z, float f, boolean z2, float f2) {
            return z2 ? f2 : f;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.FloatList visitFloatList(Internal.FloatList floatList, Internal.FloatList floatList2) {
            int size = floatList.size();
            int size2 = floatList2.size();
            Internal.FloatList floatList3 = floatList;
            floatList3 = floatList;
            if (size > 0 && size2 > 0) {
                boolean isModifiable = floatList.isModifiable();
                Internal.ProtobufList<Float> protobufList = floatList;
                if (!isModifiable) {
                    protobufList = floatList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(floatList2);
                floatList3 = protobufList;
            }
            return size > 0 ? floatList3 : floatList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public int visitInt(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.IntList visitIntList(Internal.IntList intList, Internal.IntList intList2) {
            int size = intList.size();
            int size2 = intList2.size();
            Internal.IntList intList3 = intList;
            intList3 = intList;
            if (size > 0 && size2 > 0) {
                boolean isModifiable = intList.isModifiable();
                Internal.ProtobufList<Integer> protobufList = intList;
                if (!isModifiable) {
                    protobufList = intList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(intList2);
                intList3 = protobufList;
            }
            return size > 0 ? intList3 : intList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public C5406i visitLazyMessage(C5406i c5406i, C5406i c5406i2) {
            if (c5406i2 != null) {
                if (c5406i == null) {
                    c5406i = new C5406i();
                }
                c5406i.d(c5406i2);
            }
            return c5406i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T> Internal.ProtobufList<T> visitList(Internal.ProtobufList<T> protobufList, Internal.ProtobufList<T> protobufList2) {
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            return size > 0 ? protobufList : protobufList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public long visitLong(boolean z, long j, boolean z2, long j2) {
            return z2 ? j2 : j;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Internal.LongList visitLongList(Internal.LongList longList, Internal.LongList longList2) {
            int size = longList.size();
            int size2 = longList2.size();
            Internal.LongList longList3 = longList;
            longList3 = longList;
            if (size > 0 && size2 > 0) {
                boolean isModifiable = longList.isModifiable();
                Internal.ProtobufList<Long> protobufList = longList;
                if (!isModifiable) {
                    protobufList = longList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(longList2);
                longList3 = protobufList;
            }
            return size > 0 ? longList3 : longList2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <K, V> MapFieldLite<K, V> visitMap(MapFieldLite<K, V> mapFieldLite, MapFieldLite<K, V> mapFieldLite2) {
            if (!mapFieldLite2.isEmpty()) {
                if (!mapFieldLite.isMutable()) {
                    mapFieldLite = mapFieldLite.mutableCopy();
                }
                mapFieldLite.mergeFrom(mapFieldLite2);
            }
            return mapFieldLite;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public <T extends MessageLite> T visitMessage(T t, T t2) {
            if (t == null || t2 == null) {
                return t != null ? t : t2;
            }
            return (T) t.toBuilder().mergeFrom(t2).build();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofBoolean(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofByteString(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofDouble(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofFloat(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofInt(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLazyMessage(boolean z, Object obj, Object obj2) {
            C5406i c5406i = z ? (C5406i) obj : new C5406i();
            c5406i.d((C5406i) obj2);
            return c5406i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofLong(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofMessage(boolean z, Object obj, Object obj2) {
            return z ? visitMessage((MessageLite) obj, (MessageLite) obj2) : obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public void visitOneofNotSet(boolean z) {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public Object visitOneofString(boolean z, Object obj, Object obj2) {
            return obj2;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public String visitString(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Visitor
        public C5417m visitUnknownFields(C5417m c5417m, C5417m c5417m2) {
            return c5417m2 == C5417m.a() ? c5417m : C5417m.c(c5417m, c5417m2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends AbstractC5379c<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> C5381e<MessageType, T> f(AbstractC5399e<MessageType, T> abstractC5399e) {
        if (abstractC5399e.a()) {
            return (C5381e) abstractC5399e;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T g(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.d().asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> k() {
        return C5408k.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object o(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean p(T t, boolean z) {
        return t.i(MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(z)) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> r(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T t(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) g(v(t, bArr, C5401g.a()));
    }

    static <T extends GeneratedMessageLite<T, ?>> T u(T t, CodedInputStream codedInputStream, C5401g c5401g) throws InvalidProtocolBufferException {
        T t2 = (T) t.h(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            t2.j(MethodToInvoke.MERGE_FROM_STREAM, codedInputStream, c5401g);
            t2.q();
            return t2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw e;
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T v(T t, byte[] bArr, C5401g c5401g) throws InvalidProtocolBufferException {
        try {
            CodedInputStream e = CodedInputStream.e(bArr);
            T t2 = (T) u(t, e, c5401g);
            try {
                e.a(0);
                return t2;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(t2);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getDefaultInstanceForType().getClass().isInstance(obj)) {
            try {
                x(EqualsVisitor.a, (GeneratedMessageLite) obj);
                return true;
            } catch (EqualsVisitor.NotEqualsException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) h(MethodToInvoke.GET_PARSER);
    }

    protected Object h(MethodToInvoke methodToInvoke) {
        return j(methodToInvoke, null, null);
    }

    public int hashCode() {
        if (this.a == 0) {
            C5382f c5382f = new C5382f();
            x(c5382f, this);
            this.a = c5382f.a;
        }
        return this.a;
    }

    protected Object i(MethodToInvoke methodToInvoke, Object obj) {
        return j(methodToInvoke, obj, null);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return i(MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    protected abstract Object j(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* JADX WARN: Multi-variable type inference failed */
    boolean l(EqualsVisitor equalsVisitor, MessageLite messageLite) {
        if (this == messageLite) {
            return true;
        }
        if (getDefaultInstanceForType().getClass().isInstance(messageLite)) {
            x(equalsVisitor, (GeneratedMessageLite) messageLite);
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: m */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) h(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    int n(C5382f c5382f) {
        if (this.a == 0) {
            int i = c5382f.a;
            c5382f.a = 0;
            x(c5382f, this);
            this.a = c5382f.a;
            c5382f.a = i;
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        h(MethodToInvoke.MAKE_IMMUTABLE);
        this.b.b();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s */
    public final BuilderType newBuilderForType() {
        return (BuilderType) h(MethodToInvoke.NEW_BUILDER);
    }

    public String toString() {
        return C5407j.e(this, super.toString());
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) h(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    void x(Visitor visitor, MessageType messagetype) {
        j(MethodToInvoke.VISIT, visitor, messagetype);
        this.b = visitor.visitUnknownFields(this.b, messagetype.b);
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.protobuf.GeneratedMessageLite$c */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5379c<MessageType extends AbstractC5379c<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<C5380d> d = FieldSet.n();

        private void y(C5381e<MessageType, ?> c5381e) {
            if (c5381e.c() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(AbstractC5399e<MessageType, Type> abstractC5399e) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            y(f);
            Object e = this.d.e(f.c);
            if (e == null) {
                return f.b;
            }
            return (Type) f.b(e);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(AbstractC5399e<MessageType, List<Type>> abstractC5399e) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            y(f);
            return this.d.g(f.c);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(AbstractC5399e<MessageType, Type> abstractC5399e) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            y(f);
            return this.d.h(f.c);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final void q() {
            super.q();
            this.d.k();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.GeneratedMessageLite
        /* renamed from: z */
        public final void x(Visitor visitor, MessageType messagetype) {
            super.x(visitor, messagetype);
            this.d = visitor.visitExtensions(this.d, messagetype.d);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(AbstractC5399e<MessageType, List<Type>> abstractC5399e, int i) {
            C5381e<MessageType, ?> f = GeneratedMessageLite.f(abstractC5399e);
            y(f);
            return (Type) f.d(this.d.f(f.c, i));
        }
    }
}
