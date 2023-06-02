//package com.jiejie.IOCFundamental;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * @ClassName: ClassPathXmlApplicationContext
// * @Author: jiejie
// * @Description: IOC底层原理，解析xml文件
// * @Date: 2023/5/4 20:28
// * @Version: 1.0
// */
//public class ClassPathXmlApplicationContext implements ApplicationContext{
//    private Map<String,Object> ioc=new HashMap<String,Object>();
//    /**
//     * 解析xml文件
//     * @param path
//     */
//    public ClassPathXmlApplicationContext(String path){
//        try {
//            SAXReader reader=new SAXReader();
//            Document document=reader.read(path); //读取xml文件
//            //解析xml文件
//            Element root=document.getRootElement(); //获取xml文件中的根节点
//            //获取Iterator，迭代循环标签
//            Iterator<Element> iterator=root.elementIterator();
//            while(iterator.hasNext()){  //遍历bean标签
//                Element element=iterator.next();
//                String id=element.attributeValue("id");  //获取参数
//                String className=element.attributeValue("class");
//                //通过反射机制，获取对象和属性类型
//                Class clazz=Class.forName(className);  //获取Student对象类型
//                //创建无参构造函数
//                Constructor constructor=clazz.getConstructor();
//                Object object=constructor.newInstance();  //实例化对象
//                //给目标对象赋值
//                Iterator<Element> beanIterator=element.elementIterator();
//                while(beanIterator.hasNext()){  //遍历property标签
//                    //读取property中传入的参数
//                    Element property = beanIterator.next();
//                    String name=property.attributeValue("name");  //获取方法名
//                    String valueStr=property.attributeValue("value");  //获取参数
//                    String ref=property.attributeValue("ref");  //获取引用数据方法名
//                    if(ref==null){
//                        //创建方法
//                        String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
//                        //通过反射机制创建方法
//                        Field field=clazz.getDeclaredField(name);  //获取对象的属性类型
//                        Method setMethod=clazz.getDeclaredMethod(methodName,field.getType());
//                        //根据成员变量的数据类型将value进行转换
//                        Object value=null;
//                        if(field.getType().getName() =="java.lang.String"){ //数据类型
//                            value=valueStr;
//                        }
//                        if(field.getType().getName()=="int"){
//                            value=Integer.parseInt(valueStr);
//                        }
//                        setMethod.invoke(object,value);
//                    }
//                }
//                ioc.put(id,object);  //将对象放入map中
//            }
//            Object obj1=ioc.get("address");
//            Object obj2=ioc.get("student");
//            System.out.println(obj1);
//            System.out.println(obj2);
//
//        } catch (DocumentException e) {
//            throw new RuntimeException(e);
//        }catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    /**
//     * xml文件解析完成后，返回对象
//     * @param id
//     * @return
//     */
//    @Override
//    public Object getBean(String id) {
//        return ioc.get(id);
//    }
//}
