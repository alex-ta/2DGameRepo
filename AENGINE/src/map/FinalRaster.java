package map;

public class FinalRaster {

	private final int width;
	private final int height;
	private final int wcount;
	private final int[][] coordinates;
	

	public FinalRaster (int panelWidth, int panelHeight, int panelCountWidth, int panelCountHeight){
		this.width = panelCountWidth * panelWidth;
		this.height = panelCountHeight * panelHeight;
		this.wcount = panelCountWidth;
		this.coordinates = new int [panelCountWidth*panelCountHeight][4];
		for(int i = 0; i < coordinates.length; i++){
			int wcount = i%panelCountWidth;
			int hcount = (int) Math.floor(i/panelCountWidth);
			
			coordinates[i][0] = wcount*panelWidth;
			coordinates[i][1] = hcount*panelHeight;
			coordinates[i][2] = (wcount+1)*panelWidth-1;
			coordinates[i][3] = (hcount+1)*panelHeight-1;
		}
	}
	
	public FinalRaster(int panelSize, int panelCountWidth, int panelCountHeight){
		this(panelSize,panelSize,panelCountWidth,panelCountHeight);
	}
	
	public int[] position(int x, int y){
		return position(y*wcount+x);
	}
	
	public int[] position(int index){
		if(index < coordinates.length){
			return coordinates[index];
		}
		return null;
	}
	
	public int getCount(){
		return coordinates.length;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
