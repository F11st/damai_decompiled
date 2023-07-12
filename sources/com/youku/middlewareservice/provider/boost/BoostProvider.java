package com.youku.middlewareservice.provider.boost;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface BoostProvider {
    public static final String OPPO_APPID = "cKRqYsPcTUlhyr1kR3/r4wkeuTTzchEDW4z/lSelH4I8r0RBxU4Q4qNVVFOA56jHnjQgNAI7a04HxBHKyK/E90Jcx/Hzo0DVhlQtP47ECwHZLWoGW5WoqBuLTBlx89RnO4TQ9/HPwKVrfZOyADS9AwIxmf8dGGGdibiaD7ztur4=";
    public static final String OPPO_APPID_TEST = "JVXgsAh3vQilMFupyw16IVnqwLBJwQIfOJj6Z0EqXzMAXbTrtppqENBRnKaKyVxTpyZRkbFK0xdSXqb9qxh4Bg/Ha5Up0Ar8h7iGVjo11w0J1Len/eKjJfbJB8uwQ6aFuLRKpbCyNOSIAP9GUQNt/nwxIsI5+z9lQJAJTuae1iQ=";

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum AType {
        ACTIVITY_SWITCH,
        DIALOG_SWITCH,
        TAB_SWITCH,
        LOAD_INFO,
        UPLOAD_INFO,
        OTHER_SWITCH
    }

    boolean appActionBurst(int i, AType aType);

    void appActionEnd();

    boolean appActionLoading(int i, AType aType);

    void appBootCompleted();

    boolean registerClient(String str);
}
