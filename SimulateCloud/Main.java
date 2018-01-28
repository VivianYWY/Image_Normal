import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.heresysoft.arsenal.utils.Noise;


public class Main {

	
	// ע�⣺����������Ч������width, height, persistence��zoom,�����������������gray scaleΪ0-255�ģ���������0-65535�ģ������Ȳ���0-255��Ӱ��
	//����ENVI band math����"uint(b1)*uint(255)"�õ�0-65535��Ӱ������b1��0-255��Ӱ����Ϊ���ǵ���ͬ�������͵����⣬����Ҫ��uint()����ת����0-65535��16bit
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
