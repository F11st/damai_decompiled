package mtopsdk.framework.filter;

import mtopsdk.framework.domain.MtopContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IAfterFilter extends IMtopFilter {
    String doAfter(MtopContext mtopContext);
}
