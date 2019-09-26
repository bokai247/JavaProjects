package a6novice;

public abstract interface Picture
  extends Iterable<Pixel>
{
  public abstract int getWidth();
  
  public abstract int getHeight();
  
  public abstract void setPixel(int paramInt1, int paramInt2, Pixel paramPixel);
  
  public abstract Pixel getPixel(int paramInt1, int paramInt2);
  
  public abstract int countRange(double paramDouble1, double paramDouble2);
  
  public abstract void print();
  
  public abstract SubPicture extract(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setPixel(Coordinate paramCoordinate, Pixel paramPixel);
  
  public abstract Pixel getPixel(Coordinate paramCoordinate);
  
  public abstract SubPicture extract(Coordinate paramCoordinate1, Coordinate paramCoordinate2);
}
