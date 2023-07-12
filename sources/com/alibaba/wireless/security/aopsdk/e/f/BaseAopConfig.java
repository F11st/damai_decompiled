package com.alibaba.wireless.security.aopsdk.e.f;

import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttribute;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttributeType;
import com.alibaba.wireless.security.aopsdk.i.LogUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.f.a */
/* loaded from: classes.dex */
public abstract class BaseAopConfig {
    public static final String c = "AOP-CONFIG";
    public List<Field> a = new ArrayList();
    private BaseAopConfig b;

    /* compiled from: BaseAopConfig.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.e.f.a$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C3979a {
        public static final /* synthetic */ int[] a;

        static {
            AopAttributeType.values();
            int[] iArr = new int[7];
            a = iArr;
            try {
                AopAttributeType aopAttributeType = AopAttributeType.INT;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = a;
                AopAttributeType aopAttributeType2 = AopAttributeType.DOUBLE;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = a;
                AopAttributeType aopAttributeType3 = AopAttributeType.STRING;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = a;
                AopAttributeType aopAttributeType4 = AopAttributeType.BOOLEAN;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = a;
                AopAttributeType aopAttributeType5 = AopAttributeType.JSON;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = a;
                AopAttributeType aopAttributeType6 = AopAttributeType.JSON_ARRAY;
                iArr6[5] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                int[] iArr7 = a;
                AopAttributeType aopAttributeType7 = AopAttributeType.OBJECT;
                iArr7[6] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public BaseAopConfig() {
        Field[] fields;
        for (Field field : getClass().getFields()) {
            AopAttribute aopAttribute = (AopAttribute) field.getAnnotation(AopAttribute.class);
            if (aopAttribute != null && !TextUtils.isEmpty(aopAttribute.key())) {
                this.a.add(field);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        AopAttribute aopAttribute;
        for (Field field : this.a) {
            if (field != null && (aopAttribute = (AopAttribute) field.getAnnotation(AopAttribute.class)) != null && jSONObject.has(aopAttribute.key())) {
                try {
                    switch (aopAttribute.type().ordinal()) {
                        case 0:
                            field.setDouble(this, jSONObject.getDouble(aopAttribute.key()));
                            break;
                        case 1:
                            field.setInt(this, jSONObject.getInt(aopAttribute.key()));
                            break;
                        case 2:
                            field.set(this, jSONObject.getString(aopAttribute.key()));
                            break;
                        case 3:
                            field.setBoolean(this, jSONObject.getBoolean(aopAttribute.key()));
                            break;
                        case 4:
                            BaseAopConfig newInstance = aopAttribute.handler().newInstance();
                            newInstance.a(this);
                            newInstance.b(jSONObject.getJSONObject(aopAttribute.key()));
                            field.set(this, newInstance);
                            break;
                        case 5:
                            Class<? extends BaseAopConfig> handler = aopAttribute.handler();
                            JSONArray optJSONArray = jSONObject.optJSONArray(aopAttribute.key());
                            if (optJSONArray != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    BaseAopConfig newInstance2 = handler.newInstance();
                                    newInstance2.a(this);
                                    newInstance2.b(optJSONArray.optJSONObject(i));
                                    arrayList.add(newInstance2);
                                }
                                field.set(this, arrayList);
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            field.set(this, jSONObject.get(aopAttribute.key()));
                            break;
                    }
                } catch (Throwable th) {
                    LogUtils.a("AOP-Config", "" + this, th);
                }
            }
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject);
        }
    }

    public void a(BaseAopConfig baseAopConfig) {
        this.b = baseAopConfig;
    }

    public BaseAopConfig a() {
        return this.b;
    }
}
