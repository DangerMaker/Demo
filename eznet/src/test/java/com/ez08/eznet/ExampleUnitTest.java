package com.ez08.eznet;

import com.ez08.eznet.core.utils.BytesUtils;
import com.ez08.eznet.interfacies.utils.SPIUtils;

import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        ByteBuffer buffer = ByteBuffer.allocate(1);
        buffer.put((byte) 0xFE);
//        byte[] bytes = buffer.array();
//        ByteBuffer buffer1 = ByteBuffer.wrap(bytes);
//        buffer1.array();
        System.out.println(BytesUtils.toHexStringForLog(buffer.array()));
    }
}