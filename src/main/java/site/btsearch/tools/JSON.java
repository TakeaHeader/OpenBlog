package site.btsearch.tools;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JSON工具类
 * @author wangjun
 *
 */
public final class JSON {

    /**
     * 工具类,不允许实例化
     */
    private JSON(){}

    /***
     * @param obj 需要转化为字节数组的数据
     * @return  字节数组
     */
    public static byte[] toByteArray(Object obj){
        SerializerFeature[] SerializerFeatureS = new SerializerFeature[]{SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteMapNullValue};
        return JSONObject.toJSONBytes(obj, SerializerFeatureS);
    }

    public static JSONObject toJSONObject(String Json){
        SerializerFeature[] SerializerFeatureS = new SerializerFeature[]{SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteMapNullValue};
        return JSONObject.parseObject(Json);
    }





}
