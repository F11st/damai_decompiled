package com.alibaba.security.realidentity.business;

import com.alibaba.security.realidentity.a.i;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.AbsStartHttpParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.submit.AbsSubmitHttpParams;
import com.alibaba.security.realidentity.business.submit.SubmitHttpParams;
import com.alibaba.security.realidentity.business.upload.AbsUploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.business.uploadresult.AbsUploadResultParams;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c {
    private static final String h = "c";
    protected String a;
    public BusinessHeadParams b;
    public StartHttpParams c;
    public BiometricsBucketParams d;
    public UploadFileParams e;
    public UploadResultParams f;
    public SubmitHttpParams g;
    private int i = -1;
    private List<BusinessType> j = new ArrayList();
    private Class<? extends BucketParams>[] k = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.c$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BusinessType.values().length];
            a = iArr;
            try {
                iArr[BusinessType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BusinessType.SUBMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BusinessType.UPLOADFILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BusinessType.UPLOADRESULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BusinessType.ALBIOMETERICS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c(BusinessHeadParams businessHeadParams) {
        this.b = businessHeadParams;
    }

    private boolean b(BusinessType businessType) {
        Class<? extends BucketParams>[] clsArr;
        Class<? extends BucketParams>[] clsArr2;
        Class<? extends BucketParams>[] clsArr3;
        Class<? extends BucketParams>[] clsArr4;
        Class<? extends BucketParams>[] clsArr5;
        try {
        } catch (IllegalAccessException unused) {
            com.alibaba.security.common.c.a.b();
        } catch (InstantiationException unused2) {
            com.alibaba.security.common.c.a.b();
        } catch (NoSuchMethodException unused3) {
            com.alibaba.security.common.c.a.b();
        } catch (InvocationTargetException unused4) {
            com.alibaba.security.common.c.a.b();
        }
        if (this.k == null) {
            com.alibaba.security.common.c.a.d(h, "createParams classes is null");
            return false;
        }
        int i = AnonymousClass1.a[businessType.ordinal()];
        if (i == 1) {
            for (Class<? extends BucketParams> cls : this.k) {
                if (AbsStartHttpParams.class.isAssignableFrom(cls)) {
                    this.c = (StartHttpParams) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i == 2) {
            for (Class<? extends BucketParams> cls2 : this.k) {
                if (AbsSubmitHttpParams.class.isAssignableFrom(cls2)) {
                    this.g = (SubmitHttpParams) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i == 3) {
            for (Class<? extends BucketParams> cls3 : this.k) {
                if (AbsUploadFileParams.class.isAssignableFrom(cls3)) {
                    this.e = (UploadFileParams) cls3.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i == 4) {
            for (Class<? extends BucketParams> cls4 : this.k) {
                if (AbsUploadResultParams.class.isAssignableFrom(cls4)) {
                    this.f = (UploadResultParams) cls4.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i == 5) {
            for (Class<? extends BucketParams> cls5 : this.k) {
                if (AbsBiometricsBucketParams.class.isAssignableFrom(cls5)) {
                    this.d = (BiometricsBucketParams) cls5.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(List<BusinessType> list, String str) {
        this.j = list;
        this.i = -1;
        this.k = i.a.a().c();
        this.a = str;
    }

    public final void c() {
        List<BusinessType> list = this.j;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.i = this.j.size();
    }

    public final void d() {
        List<BusinessType> list = this.j;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.i = this.j.indexOf(BusinessType.ALBIOMETERICS);
    }

    public final boolean a() {
        int i = this.i + 1;
        this.i = i;
        if (i >= this.j.size()) {
            return false;
        }
        BusinessType businessType = this.j.get(this.i);
        if (!b(businessType)) {
            String str = h;
            com.alibaba.security.common.c.a.d(str, "isCreateSuccessful params error businessType:" + businessType.name());
            return false;
        }
        int i2 = AnonymousClass1.a[businessType.ordinal()];
        if (i2 == 1) {
            this.c.dispatch(this);
        } else if (i2 == 2) {
            this.g.dispatch(this);
        } else if (i2 == 3) {
            this.e.dispatch(this);
        } else if (i2 == 4) {
            this.f.dispatch(this);
        } else if (i2 == 5) {
            this.d.dispatch(this);
        }
        return true;
    }

    private BucketParams.ErrorCode a(BusinessType businessType) {
        int i = AnonymousClass1.a[businessType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return this.d.getErrorCode();
                    }
                    return this.f.getErrorCode();
                }
                return this.e.getErrorCode();
            }
            return this.g.getErrorCode();
        }
        return this.c.getErrorCode();
    }

    private void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.a;
    }
}
