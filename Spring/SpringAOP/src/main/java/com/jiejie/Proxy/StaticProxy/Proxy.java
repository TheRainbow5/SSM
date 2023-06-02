package com.jiejie.Proxy.StaticProxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Proxy
 * @Author: jiejie
 * @Description: Todo
 * @Date: 2023/5/9 20:43
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proxy{
    private Host host;
    /**
     * 房东主要的目的就只是租房
     */
    public void rent(){
        host.rent();
    }
    /**
     * 中介还可以做其他事情，比如带你看房
     */
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    /**
     * 中介收取中介费
     */
    public void fare(){
        System.out.println("中介收中介费");
    }
}
