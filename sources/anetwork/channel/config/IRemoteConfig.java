package anetwork.channel.config;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IRemoteConfig {
    String getConfig(String... strArr);

    void onConfigUpdate(String str);

    void register();

    void unRegister();
}
