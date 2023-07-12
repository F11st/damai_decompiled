package com.alibaba.wireless.security.aopsdk.e.f;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BaseAopConfig.java */
/* loaded from: classes.dex */
public abstract class a {
    public static final String c = "AOP-CONFIG";
    public List<Field> a = new ArrayList();
    private a b;

    /* compiled from: BaseAopConfig.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0181a {
        public static final /* synthetic */ int[] a;

        static {
            com.alibaba.wireless.security.aopsdk.e.e.b.values();
            int[] iArr = new int[7];
            a = iArr;
            try {
                com.alibaba.wireless.security.aopsdk.e.e.b bVar = com.alibaba.wireless.security.aopsdk.e.e.b.INT;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = a;
                com.alibaba.wireless.security.aopsdk.e.e.b bVar2 = com.alibaba.wireless.security.aopsdk.e.e.b.DOUBLE;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = a;
                com.alibaba.wireless.security.aopsdk.e.e.b bVar3 = com.alibaba.wireless.security.aopsdk.e.e.b.STRING;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = a;
                com.alibaba.wireless.security.aopsdk.e.e.b bVar4 = com.alibaba.wireless.security.aopsdk.e.e.b.BOOLEAN;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = a;
                com.alibaba.wireless.security.aopsdk.e.e.b bVar5 = com.alibaba.wireless.security.aopsdk.e.e.b.JSON;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = a;
                com.alibaba.wireless.security.aopsdk.e.e.b bVar6 = com.alibaba.wireless.security.aopsdk.e.e.b.JSON_ARRAY;
                iArr6[5] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                int[] iArr7 = a;
                com.alibaba.wireless.security.aopsdk.e.e.b bVar7 = com.alibaba.wireless.security.aopsdk.e.e.b.OBJECT;
                iArr7[6] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public a() {
        Field[] fields;
        for (Field field : getClass().getFields()) {
            com.alibaba.wireless.security.aopsdk.e.e.a aVar = (com.alibaba.wireless.security.aopsdk.e.e.a) field.getAnnotation(com.alibaba.wireless.security.aopsdk.e.e.a.class);
            if (aVar != null && !TextUtils.isEmpty(aVar.key())) {
                this.a.add(field);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        com.alibaba.wireless.security.aopsdk.e.e.a aVar;
        for (Field field : this.a) {
            if (field != null && (aVar = (com.alibaba.wireless.security.aopsdk.e.e.a) field.getAnnotation(com.alibaba.wireless.security.aopsdk.e.e.a.class)) != null && jSONObject.has(aVar.key())) {
                try {
                    switch (aVar.type().ordinal()) {
                        case 0:
                            field.setDouble(this, jSONObject.getDouble(aVar.key()));
                            break;
                        case 1:
                            field.setInt(this, jSONObject.getInt(aVar.key()));
                            break;
                        case 2:
                            field.set(this, jSONObject.getString(aVar.key()));
                            break;
                        case 3:
                            field.setBoolean(this, jSONObject.getBoolean(aVar.key()));
                            break;
                        case 4:
                            a newInstance = aVar.handler().newInstance();
                            newInstance.a(this);
                            newInstance.b(jSONObject.getJSONObject(aVar.key()));
                            field.set(this, newInstance);
                            break;
                        case 5:
                            Class<? extends a> handler = aVar.handler();
                            JSONArray optJSONArray = jSONObject.optJSONArray(aVar.key());
                            if (optJSONArray != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    a newInstance2 = handler.newInstance();
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
                            field.set(this, jSONObject.get(aVar.key()));
                            break;
                    }
                } catch (Throwable th) {
                    com.alibaba.wireless.security.aopsdk.i.a.a("AOP-Config", "" + this, th);
                }
            }
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject);
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public a a() {
        return this.b;
    }
}
