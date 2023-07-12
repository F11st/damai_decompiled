package tb;

import com.youku.uplayer.AliMediaPlayer;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class de {
    public static final GeneratedMessageLite.c<ProtoBuf$Class, List<ProtoBuf$Annotation>> classAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> compileTimeValue;
    public static final GeneratedMessageLite.c<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> constructorAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> enumEntryAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$Function, List<ProtoBuf$Annotation>> functionAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$Package, Integer> packageFqName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Package.getDefaultInstance(), 0, null, null, 151, WireFormat.FieldType.INT32, Integer.class);
    public static final GeneratedMessageLite.c<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> parameterAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyGetterAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertySetterAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$Type, List<ProtoBuf$Annotation>> typeAnnotation;
    public static final GeneratedMessageLite.c<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> typeParameterAnnotation;

    static {
        ProtoBuf$Class defaultInstance = ProtoBuf$Class.getDefaultInstance();
        ProtoBuf$Annotation defaultInstance2 = ProtoBuf$Annotation.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        classAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(defaultInstance, defaultInstance2, null, 150, fieldType, false, ProtoBuf$Annotation.class);
        constructorAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Constructor.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        functionAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Function.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        propertyAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Property.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        propertyGetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Property.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR, fieldType, false, ProtoBuf$Annotation.class);
        propertySetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Property.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX, fieldType, false, ProtoBuf$Annotation.class);
        compileTimeValue = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf$Property.getDefaultInstance(), ProtoBuf$Annotation.Argument.Value.getDefaultInstance(), ProtoBuf$Annotation.Argument.Value.getDefaultInstance(), null, 151, fieldType, ProtoBuf$Annotation.Argument.Value.class);
        enumEntryAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$EnumEntry.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        parameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$ValueParameter.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$Type.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf$TypeParameter.getDefaultInstance(), ProtoBuf$Annotation.getDefaultInstance(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
    }

    public static void a(kotlin.reflect.jvm.internal.impl.protobuf.c cVar) {
        cVar.a(packageFqName);
        cVar.a(classAnnotation);
        cVar.a(constructorAnnotation);
        cVar.a(functionAnnotation);
        cVar.a(propertyAnnotation);
        cVar.a(propertyGetterAnnotation);
        cVar.a(propertySetterAnnotation);
        cVar.a(compileTimeValue);
        cVar.a(enumEntryAnnotation);
        cVar.a(parameterAnnotation);
        cVar.a(typeAnnotation);
        cVar.a(typeParameterAnnotation);
    }
}
