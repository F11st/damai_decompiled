package cn.damai.ticklet.ui.observer;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface ObserverableTicket {
    void notifyObserver();

    void registerObserver(ObserverTicket observerTicket);

    void removeObserver(ObserverTicket observerTicket);
}
