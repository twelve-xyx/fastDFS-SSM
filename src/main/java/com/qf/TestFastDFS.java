package com.qf;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * 半城烟雨半城沙,我在等风也等你
 */
public class TestFastDFS {
	public static void main(String[] args) throws Exception {
		//声明对象  tracker storage
		TrackerClient trackerClient=null;
		TrackerServer trackerServer=null;
		StorageClient storageClient=null;
		StorageServer storageServer=null;


		//1.加载配置文件
		ClientGlobal.init("client.conf");
		System.out.println(ClientGlobal.configInfo());

		//2.创建TrackerClient对象
		trackerClient=new TrackerClient();
		//3.得到TrackerServer对象
		trackerServer=trackerClient.getConnection();

		//4.构建storageClient对象
		storageClient=new StorageClient(trackerServer,storageServer);

		//5.上传图片或者文件
		String[] jpgs = storageClient.upload_file("C:\\Users\\twelve\\Downloads\\FastDFSDemo\\src\\main\\resources\\1.jpg", "jpg", null);

		for (String jpg : jpgs) {
			System.out.println(jpg);
		}
	}
}
