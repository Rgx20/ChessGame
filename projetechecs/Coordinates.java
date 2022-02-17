public class Coordinates{
    private int x;
    private int y;

    
    public Coordinates(int x, int y){
	this.x = x;
	this.y = y;
    }

    public Coordinates(String code){
	this.x = (int) code.charAt(0) - (int) 'A'; 
	this.y = (int) code.charAt(1) - (int) '0' - 1;
    }

    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }

    public String toString(){
	return "(" + this.x + "," + this.y + ")";
    }
	
}
