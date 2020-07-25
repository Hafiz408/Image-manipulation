
/**
 * Converts multiple images into grayscale 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class GrayScaleConverter {
    private ImageResource convertToGrayScale(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int red = inPixel.getRed();
            int green = inPixel.getGreen();
            int blue = inPixel.getBlue();
            int average = (red + green + blue)/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        outImage.draw();
        return outImage;
    }
    public void testConvertToGrayScale(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
             ImageResource inImage = new ImageResource(f);
             ImageResource grayScale = convertToGrayScale(inImage);
             grayScale.draw();
             grayScale.setFileName("grayscale-"+inImage.getFileName());
             grayScale.save();
        }
    }
}
