package mtopsdk.framework.filter;

import mtopsdk.framework.domain.MtopContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IBeforeFilter extends IMtopFilter {
    String doBefore(MtopContext mtopContext);
}
