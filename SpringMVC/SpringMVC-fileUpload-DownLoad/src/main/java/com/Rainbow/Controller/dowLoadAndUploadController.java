package com.Rainbow.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @ClassName: dowLoadAndUploadController
 * @Author: Rainbow
 * @Description: 文件上传和下载
 * @Date: 2023/6/9 20:55
 * @Version: 1.0
 *
 * 文件下载
 * 1、ResponseEntity：可以作为控制器方法的返回值，表示响应到浏览器的报文
 *
 * 文件上传
 * 1、form表单必须设置请求方式：post
 * 2、form表单必须设置属性：enctype="multipart/form-data"，文件以二进制形式传送
 * 3、pom.xml，添加上传文件依赖
 * 3、springmvc.xml，添加文件上传解析器
 */

@Controller
public class dowLoadAndUploadController {
    @RequestMapping("downLoad")
    public ResponseEntity<byte[]> testDownLoad(HttpSession httpSession) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = httpSession.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("img");
        realPath = realPath + File.separator + "Rainbow.jpg";
        //创建输入流
        InputStream inputStream = new FileInputStream(realPath);
        //创建字节数组，is.available()获取输入流所对应文件的字节数
        byte[] bytes = new byte[inputStream.available()];
        //将流读到字节数组中
        inputStream.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=Rainbow.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        inputStream.close();
        System.out.println("文件下载成功");
        return responseEntity;  //将文件响应给浏览器
    }

    /**
     * @param photo 前端传来的文件数据，前后端参数名相同
     * @param httpSession
     * @return
     * @throws IOException
     */
    @RequestMapping("upLoad")
    public String testUpLoad(MultipartFile photo,HttpSession httpSession) throws IOException {
        //获取上传的文件名
        String originalFilename = photo.getOriginalFilename();
        //上传的文件名字重复问题
        //1、获取上传文件的后缀名
        String hzName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //2、获取uuid
        String uuid= UUID.randomUUID().toString();
        //3、拼接新文件名
        originalFilename=uuid+hzName;
        //获取ServletContext对象
        ServletContext servletContext = httpSession.getServletContext();
        //获取当前要保存图片的目录
        String photoPath = servletContext.getRealPath("photo");
        //创建photoPath所对应的File对象
        File file=new File(photoPath);
        //判断目录是否存在，没有则创建
        if(!file.exists()){
            file.mkdir();
        }
        //文件的最终保存路径
        String finalPath=photoPath+File.separator+originalFilename;
        //将文件最终保存到目录
        photo.transferTo(new File((finalPath)));
        System.out.println("文件上传成功");
        return "success";
    }
}
