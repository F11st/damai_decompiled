package com.huawei.hms.api;

import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Api<O extends ApiOptions> {
    private final String a;
    private final Options<O> b;
    public List<ConnectionPostProcessor> mConnetctPostList;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface ApiOptions {

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface HasOptions extends ApiOptions {
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class NoOptions implements NotRequiredOptions {
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class Options<O> {
        public List<PermissionInfo> getPermissionInfoList(O o) {
            return Collections.emptyList();
        }

        public List<Scope> getScopeList(O o) {
            return Collections.emptyList();
        }
    }

    public Api(String str) {
        this.a = str;
        this.b = null;
    }

    public String getApiName() {
        return this.a;
    }

    public Options<O> getOptions() {
        return this.b;
    }

    public List<ConnectionPostProcessor> getmConnetctPostList() {
        return this.mConnetctPostList;
    }

    public void setmConnetctPostList(List<ConnectionPostProcessor> list) {
        this.mConnetctPostList = list;
    }

    public Api(String str, Options<O> options) {
        this.a = str;
        this.b = options;
    }
}
