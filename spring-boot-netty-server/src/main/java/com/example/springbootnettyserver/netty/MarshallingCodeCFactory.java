//package com.example.springbootnettyserver.netty;
//
//import io.netty.handler.codec.marshalling.*;
//import org.jboss.marshalling.MarshallerFactory;
//import org.jboss.marshalling.Marshalling;
//import org.jboss.marshalling.MarshallingConfiguration;
//
///**
// * @author LSD
// * @date 2020/11/26 11:31
// */
//public final class MarshallingCodeCFactory {
//
//    /**
//     * JBoss Marshalling 解码器
//     * @return
//     */
//    public static MarshallingDecoder buildMarshallingDecoder() {
//        //参数“serial”表示创建的是Java序列化工厂对象
//        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
//        final MarshallingConfiguration configuration = new MarshallingConfiguration();
//        configuration.setVersion(5);
//        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallerFactory, configuration);
//        //1024表示单个消息序列化后的最大长度
//        MarshallingDecoder decoder = new MarshallingDecoder(provider, 4000);
//        return decoder;
//    }
//
//    /**
//     * JBoss Marshalling 编码器
//     * @return
//     */
//    public static MarshallingEncoder buildMarshallingEncoder() {
//        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
//        final MarshallingConfiguration configuration = new MarshallingConfiguration();
//        configuration.setVersion(5);
//        MarshallerProvider provider = new DefaultMarshallerProvider(marshallerFactory, configuration);
//        MarshallingEncoder encoder = new MarshallingEncoder(provider);
//        return encoder;
//    }
//}
//
