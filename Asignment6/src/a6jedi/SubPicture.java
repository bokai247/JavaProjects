package a6jedi;

public abstract interface SubPicture
  extends Picture
{
  public abstract Picture getSource();
  
  public abstract int getXOffset();
  
  public abstract int getYOffset();
}
