package com.ez08.eznet.interfacies.common_interfacies.server;


import com.ez08.eznet.core.iocore.interfaces.ISendable;

public interface IClientPool<T, K> {

    void cache(T t);

    T findByUniqueTag(K key);

    int size();

    void sendToAll(ISendable sendable);
}
