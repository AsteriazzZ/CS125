//UIUC CS125 SPRING 2016 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:15:41-0600.419530601

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author zzhan145
 */
public class PixelEffects {

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		// Create a NEW 2D integer array and copy the colors across
		// See red eye code below
		
		int[][] copyColor = new int[source.length][source[0].length];
		
		for(int i = 0; i < source.length; i++){
			for(int j = 0; j < source[0].length; j++)
				copyColor[i][j] = source[i][j];
		}
		return copyColor;
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.

		int[][] resized = new int[newWidth][newHeight];
		int origWidth = source.length;
		int origHeight = source[0].length;
		double prop1 = (double) origWidth / newWidth;
		double prop2 = (double) origHeight / newHeight;
		
		for (int i = 0; i < newWidth; i++) {
			for (int j = 0; j < newHeight; j++) {
				resized[i][j] = source[(int) (i * prop1)][(int) (j * prop2)];
			}
		}
		return resized;
		
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		return PixelEffects.resize(source, source.length / 2, source[0].length / 2);
	}
	
	/**
	 * Create a new image array that is the same dimensions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {
		return PixelEffects.resize(source, reference.length, reference[0].length);
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {
		
		int srcW = source.length;
		int srcH = source[0].length;
		int tgtW = srcW;
		int tgtH = srcH;
		int[][] target = new int[tgtW][tgtH];
		
		for(int tgtX = 0; tgtX < tgtW; tgtX++){
			for(int tgtY = 0; tgtY < tgtH; tgtY++){
				int srcX = tgtX;
				int srcY = tgtH - 1 - tgtY;
				target[tgtX][tgtY] = source[srcX][srcY];
			}
		}
		return target;
		
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		
		int srcW = source.length;
		int srcH = source[0].length;
		int tgtW = srcW;
		int tgtH = srcH;
		int[][] target = new int[tgtW][tgtH];
		
		for(int tgtX = 0; tgtX < tgtW; tgtX++){
			for(int tgtY = 0; tgtY < tgtH; tgtY++){
				int srcX = tgtW - 1 - tgtX;
				int srcY = tgtY;
				target[tgtX][tgtY] = source[srcX][srcY];
			}
		}
		return target;
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		
		int srcW = source.length;
		int srcH = source[0].length;
		int tgtW = srcH;
		int tgtH = srcW;
		int[][] target = new int[tgtW][tgtH];
		
		for(int tgtX = 0; tgtX < tgtW; tgtX++){
			for(int tgtY = 0; tgtY < tgtH; tgtY++){
				int srcX = tgtH - tgtY - 1;
				int srcY = tgtX;
				target[tgtX][tgtY] = source[srcX][srcY];
			}
		}
		return target;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel of the background).
		
		int[][] merged = new int[sourceA.length][sourceA[0].length];
		
		for(int i = 0; i < sourceA.length; i++){
			for(int j = 0; j < sourceA[0].length; j++){
				
				int redAvg = (RGBUtilities.toRed(sourceA[i][j]) + RGBUtilities.toRed(sourceB[i][j])) / 2;
				if(redAvg > 255)
					redAvg = 255;
				
				int greenAvg = (RGBUtilities.toGreen(sourceA[i][j]) + RGBUtilities.toGreen(sourceB[i][j])) / 2;
				if(greenAvg > 255)
					greenAvg = 255;
				
				int blueAvg = (RGBUtilities.toBlue(sourceA[i][j]) + RGBUtilities.toBlue(sourceB[i][j])) / 2;
				if(greenAvg > 255)
					greenAvg = 255;
				
				merged[i][j] = RGBUtilities.toRGB(redAvg, greenAvg, blueAvg);
			}
		}
		return merged;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		
		foreImage = PixelEffects.resize(foreImage, backImage);

		for (int i = 0; i < backImage.length; i++) {
			for (int j = 0; j < backImage[0].length; j++) {
				if (RGBUtilities.toRed(foreImage[i][j]) == 0
						&& RGBUtilities.toBlue(foreImage[i][j]) == 0
						&& RGBUtilities.toGreen(foreImage[i][j]) != 0) {
					foreImage[i][j] = (backImage[i][j]);
				}
			}
		}
		return foreImage;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		
		//A filter which 'greys out' an image by averaging each pixel with white.
		source = PixelEffects.resize(source, sourceB);
		
		for(int i = 0; i < source.length; i++){
			for(int j = 0; j < source[0].length; j++){
				
				int r = (RGBUtilities.toRed(source[i][j]) + 255) / 2;
				int g = (RGBUtilities.toGreen(source[i][j]) + 255) / 2;
				int b = (RGBUtilities.toBlue(source[i][j]) + 255) / 2;
				
				source[i][j] = RGBUtilities.toRGB(r, g, b);
			}
		}
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
		return source;
	}
}
