//this code is used to change filename in a batch mode

import java.io.File;

public class ReviseFileName {
	public static void main(String[] args)
    {
        File file = new File("E:/RS/all_patches/val/C");
        File[] list = file.listFiles();

        // ���Ŀ¼���ļ�����
        if (file.exists() && file.isDirectory())
        {
            for (int i = 0; i < list.length; i++)
            {
                //ȡ�ļ�������name��
                //String name = list[i].getName();
                // ��ȡ.֮ǰ���ַ�������
               // int index = name.indexOf(".");
                // ��ȡ.JPG����
               // int index2 = name.lastIndexOf(".");
               // String name3 = name.substring(index2);
                // ƴ���ַ���
              //  String newName = "2016-4-15-" + (i + 1) + name3;
                //������
            	String newName = (i + 1) + ".png";
                File dest = new File("E:/RS/all_patches/val/C" + "/" + newName);
                list[i].renameTo(dest);
                System.out.println(dest.getName());
            }
        }
    }
}
