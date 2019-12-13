package com.ez08.eznet.interfacies.common_interfacies.server;


import com.ez08.eznet.core.iocore.interfaces.ISendable;
import com.ez08.eznet.core.pojo.OriginalData;

public interface IClientIOCallback {

    void onClientRead(OriginalData originalData, IClient client, IClientPool<IClient, String> clientPool);

    void onClientWrite(ISendable sendable, IClient client, IClientPool<IClient, String> clientPool);

}
