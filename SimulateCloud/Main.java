import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.heresysoft.arsenal.utils.Noise;


public class Main {

	
	// 注意：最后产生的云效果，与width, height, persistence或zoom,这个函数是用来产生gray scale为0-255的，如果想产生0-65535的，可以先产生0-255的影像，
	//再在ENVI band math里用"uint(b1)*uint(255)"得到0-65535的影像，其中b1是0-255的影像，因为考虑到不同数据类型的问题，所以要用uint()类型转换成0-65535即16bit
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		  int width = Integer.parseInt(args[0]);
		  int height = Integer.parseInt(args[1]);
		  int NumPic = Integer.parseInt(args[2]);
		  double[] data;
		  BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		  //double[] data = Noise.normalize(Noise.perlinNoise(width, height, 7));
		  for (int n = 0; n < NumPic; n++){
			  data = Noise.normalize(Noise.turbulence(width, height, 300));
	        	for (int i = 0; i < data.length; i++)
	        		{data[i] = 255 * data[i];}
	        	img.getRaster().setPixels(0, 0, width, height, data);
	        	String newName = (n + 1) + ".png";
	            File myNewPNGFile = new File("E:/RS/all_patches/train/C" + "/" + newName);
	            ImageIO.write(img, "PNG", myNewPNGFile);	 
		  }
	       // int[] alpha = new int[width * height];
	        //for (int i = 0; i < alpha.length; i++)
		     //      alpha[i] = (int)(Math.random() * 10);
	       // BufferedImage img_alpha = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
	       // img_alpha.getRaster().setPixels(0, 0, width, height, alpha);
	       // File PNGFile = new File("E:\\Alpha.png");
	       // ImageIO.write(img_alpha, "PNG", PNGFile);	
	      
	}

}
