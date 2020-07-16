package com.aaa.lee.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import com.aaa.lee.utils.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * create by: lee
 * description:
 */
public class FtpUtils {
    private FtpUtils(){}
    /**
     * Author: lee
     * Description: ftp文件上传方法工具
    **/
    public static Boolean upload(String host, Integer port, String username , String password, String bastPath,
                                 String filePath, String fileName, InputStream inputStream){
        /**
         * Author: lee
         * Description: 最终按照每天日期的文件夹来进行上传
         *              2020/7/10 ---->10文件夹
         *              cd /home/redis/src
        **/
        //1.创建临时路径
        String tempPath= "";
        //2.创建FTPClient对象(这个对象就是FTP给java所提供的API)
        FTPClient ftpClient = new FTPClient();
        try {
            //3.定义返回状态吗
            int replyCode;
            //4.连接ftp
            ftpClient.connect(host, port);
            //5.登录ftp服务器
            ftpClient.login(username, password);
            //6.接收返回的状态码
            replyCode = ftpClient.getReplyCode();//如果成功返回230,如果失败返回503
            //7.判断
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                //连接失败了
                ftpClient.disconnect();
                return false;
            }
            //8.先检测我要上传的目录是否存在(2020/07/10)
            //basePath:/home/ftp/www
            //filePath:/2020/07/10
            //---->/home/ftp/www/2020/07/10
            if (!ftpClient.changeWorkingDirectory(bastPath + filePath)) {
                //该文件夹不存在
                //9.创建文件夹
                String[] dirs = filePath.split("/");
                //10.把basePath赋值给临时路径
                //tempPath:/home/ftp/www/
                tempPath = bastPath;
                //11.循环
                for (String dir : dirs) {
                    if (null == dir || StringUtils.isEmpty(dir)) {
                        //没有数据
                        continue;
                    }
                    //12.拼接临时路径(如果没有进入if,则取到的值应该就是2020)
                    tempPath += "/" + dir;
                    //tempPath: /home/ftp/www/2020
                    //13.再次检测tempPath是否存在
                    if (!ftpClient.changeWorkingDirectory(tempPath)) {
                        //文件夹不存在
                        //14.创建文件夹
                        if (!ftpClient.makeDirectory(tempPath)) {
                            //说明文件夹创建失败
                            return false;
                        } else {
                            //15.严谨判断,判断创建出来的目录确实存在
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //16.把文件转换为二进制的形式来进行上传
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //17.这里才是真正的文件上传
            if (!ftpClient.storeFile(fileName, inputStream)) {
                //说明上传失败
                return false;
            }
            //18.关闭输入流
            inputStream.close();
            //19.退出ftp
            ftpClient.logout();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(!ftpClient.isConnected()){
                try {
                    //说明还在连接中(正在占用资源)
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
