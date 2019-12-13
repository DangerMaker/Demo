package com.ez08.eznet.interfacies.common_interfacies.server;


import com.ez08.eznet.core.iocore.interfaces.IIOCoreOptions;

public interface IServerManagerPrivate<E extends IIOCoreOptions> extends IServerManager<E> {
    void initServerPrivate(int serverPort);
}
