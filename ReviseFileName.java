//this code is used to change filename in a batch mode

import java.io.File;

public class ReviseFileName {
	public static void main(String[] args)
    {
        File file = new File("E:/RS/all_patches/val/C");
        File[] list = file.listFiles();

        // 如果目录下文件存在
        if (file.exists() && file.isDirectory())
        {
            for (int i = 0; i < list.length; i++)
            {
                //取文件名存入name中
                //String name = list[i].getName();
                // 截取.之前的字符串出来
               // int index = name.indexOf(".");
                // 截取.JPG出来
               // int index2 = name.lastIndexOf(".");
               // String name3 = name.substring(index2);
                // 拼接字符串
              //  String newName = "2016-4-15-" + (i + 1) + name3;
                //重命名
            	String newName = (i + 1) + ".png";
                File dest = new File("E:/RS/all_patches/val/C" + "/" + newName);
                list[i].renameTo(dest);
                System.out.println(dest.getName());
            }
        }
    }
}
