package anet.channel.security;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ISecurityFactory {
    ISecurity createNonSecurity(String str);

    ISecurity createSecurity(String str);
}
