
/**
 * Write a description of ImageInversion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class ImageInversion {
    private ImageResource convertToInvertedImage(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int red = inPixel.getRed();
            int green = inPixel.getGreen();
            int blue = inPixel.getBlue();            
            pixel.setRed(255 - red);
            pixel.setGreen(255 - green);
            pixel.setBlue(255 - blue);
        }
        outImage.draw();
        return outImage;
    }
    public void testConvertToInversionImage(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
             ImageResource inImage = new ImageResource(f);
             ImageResource invertedImage = convertToInvertedImage(inImage);
             invertedImage.draw();
             invertedImage.setFileName("inverted-"+inImage.getFileName());
             invertedImage.save();
        }
    }
}
