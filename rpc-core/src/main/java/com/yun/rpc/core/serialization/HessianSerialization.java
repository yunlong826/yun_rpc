package com.yun.rpc.core.serialization;

import com.caucho.hessian.io.HessianSerializerInput;
import com.caucho.hessian.io.HessianSerializerOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO Hessian序列化
 * @date 2022/5/21 18:43
 */
public class HessianSerialization implements RpcSerialization{
    /*
     *
     *
     * @param null
     * @return null
     * @author long_yun
     * @date 2022/5/21 18:49
     * @describe 序列化
     */

    @Override
    public <T> byte[] serialize(T obj) throws Exception {
        if(obj == null)
            throw new NullPointerException();
        byte[] results;
        HessianSerializerOutput hessianOutput;
        try(ByteArrayOutputStream os = new ByteArrayOutputStream()){
            hessianOutput = new HessianSerializerOutput(os);
            hessianOutput.writeObject(obj);
            hessianOutput.flush();
            results = os.toByteArray();
        }catch (Exception e){
            throw new SerializationException(e);
        }
        return results;
    }

    /*
     *
     *
     * @param null
     * @return null
     * @author long_yun
     * @date 2022/5/21 18:50
     * @describe 反序列化
     */

    @Override
    public <T> T deserialize(byte[] data, Class<T> clz) throws Exception {
        if(data == null)
            throw new NullPointerException();
        T result;
        try(ByteArrayInputStream is = new ByteArrayInputStream(data)){
            HessianSerializerInput hessianSerializerInput = new HessianSerializerInput(is);
            result = (T) hessianSerializerInput.readObject(clz);
        }catch (Exception e){
            throw new SerializationException(e);
        }
        return result;
    }
}
