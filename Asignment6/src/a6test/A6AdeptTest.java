package a6test;

import a6adept.Coordinate;
import a6adept.Picture;
import a6adept.Pixel;
import java.util.Iterator;
import org.junit.Assert;

public class A6AdeptTest
{
  public A6AdeptTest() {}
  
  private static final Pixel RED = new a6adept.ColorPixel(1.0D, 0.0D, 0.0D);
  private static final Pixel GREEN = new a6adept.ColorPixel(0.0D, 1.0D, 0.0D);
  private static final Pixel BLUE = new a6adept.ColorPixel(0.0D, 0.0D, 1.0D);
  private static final Pixel WHITE = new a6adept.GrayPixel(1.0D);
  private static final Pixel BLACK = new a6adept.GrayPixel(0.0D);
  
  public static String[] getTestNames() {
    String[] test_names = new String[9];
    
    test_names[0] = "testSampleOrigin";
    test_names[1] = "testSampleOffset";
    test_names[2] = "testSampleAsPixelIterator";
    test_names[3] = "testSampleCorners";
    test_names[4] = "testWindowBasic";
    test_names[5] = "testWindowFullSize";
    test_names[6] = "testTileBasic";
    test_names[7] = "testTileFitted";
    test_names[8] = "testTileFullSize";
    return test_names;
  }
  
  public static String[] getTestDescriptions() {
    String[] test_descriptions = new String[9];
    
    test_descriptions[0] = "Tests basic function of SampleIterator (jump by dx, then dy) from origin.";
    test_descriptions[1] = "Tests basic function of SampleIterator (jump by dx, then dy) given non-origin starting point.";
    test_descriptions[2] = "Tests whether specific conditions of SampleIterator can replicate function of PixelIterator.";
    test_descriptions[3] = "Tests whether SampleIterator functions properly when all corners should be captured.";
    test_descriptions[4] = "Tests basic function of WindowIterator (start at (0, 0) and pan through).";
    test_descriptions[5] = "Tests whether WindowIterator functions properly when window size = picture size.";
    test_descriptions[6] = "Tests basic function of TileIterator (start at (0, 0) and create complete tiles only).";
    test_descriptions[7] = "Tests whether TileIterator functions properly when picture can be divided perfectly into complete tiles.";
    test_descriptions[8] = "Tests whether TileIterator functions properly when window size = picture size.";
    return test_descriptions;
  }
  
  @org.junit.Test
  public void testSampleOrigin() {
    Picture source_1 = initializeSource1();
    Iterator<Pixel> s1_sampleiterator = source_1.sample(0, 0, 3, 1);
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s1_sampleiterator.next());
    Assert.assertFalse(s1_sampleiterator.hasNext());
  }
  
  @org.junit.Test
  public void testSampleOffset() {
    Picture source_2 = initializeSource2();
    Iterator<Pixel> s2_sampleiterator = source_2.sample(2, 1, 1, 3);
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s2_sampleiterator.next());
    Assert.assertFalse(s2_sampleiterator.hasNext());
  }
  
  @org.junit.Test
  public void testSampleAsPixelIterator() {
    Picture source_1 = initializeSource1();
    Iterator<Pixel> s1_sampleiterator = source_1.sample(0, 0, 1, 1);
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s1_sampleiterator.next());
    Assert.assertFalse(s1_sampleiterator.hasNext());
    
    Picture source_2 = initializeSource2();
    Iterator<Pixel> s2_sampleiterator = source_2.sample(0, 0, 1, 1);
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s2_sampleiterator.next());
    
    Assert.assertTrue(s2_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s2_sampleiterator.next());
    Assert.assertFalse(s2_sampleiterator.hasNext());
  }
  
  @org.junit.Test
  public void testSampleCorners() {
    Picture source_1 = initializeSource1();
    Iterator<Pixel> s1_sampleiterator = source_1.sample(0, 0, 2, 2);
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", RED, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", GREEN, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLUE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", WHITE, 
      s1_sampleiterator.next());
    
    Assert.assertTrue(s1_sampleiterator.hasNext());
    Assert.assertEquals("The next pixel retrieved by the sample iterator is not the expected pixel", BLACK, 
      s1_sampleiterator.next());
    Assert.assertFalse(s1_sampleiterator.hasNext());
  }
  
  @org.junit.Test
  public void testWindowBasic() {
    Picture source_1 = initializeSource1();
    Coordinate s_1a = new Coordinate(0, 0);
    Coordinate s_1b = new Coordinate(3, 0);
    Coordinate s_1c = new Coordinate(0, 1);
    Coordinate s_1d = new Coordinate(3, 1);
    Coordinate s_2a = new Coordinate(1, 0);
    Coordinate s_2b = new Coordinate(4, 0);
    Coordinate s_2c = new Coordinate(1, 1);
    Coordinate s_2d = new Coordinate(4, 1);
    Coordinate s_3a = new Coordinate(0, 1);
    Coordinate s_3b = new Coordinate(3, 1);
    Coordinate s_3c = new Coordinate(0, 2);
    Coordinate s_3d = new Coordinate(3, 2);
    Coordinate s_4a = new Coordinate(1, 1);
    Coordinate s_4b = new Coordinate(4, 1);
    Coordinate s_4c = new Coordinate(1, 2);
    Coordinate s_4d = new Coordinate(4, 2);
    
    Iterator<a6adept.SubPicture> s1_windowiterator = source_1.window(4, 2);
    Coordinate sp_a = new Coordinate(0, 0);
    Coordinate sp_b = new Coordinate(3, 0);
    Coordinate sp_c = new Coordinate(0, 1);
    Coordinate sp_d = new Coordinate(3, 1);
    

    Assert.assertTrue(s1_windowiterator.hasNext());
    Picture subpic_1 = (Picture)s1_windowiterator.next();
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_1a), subpic_1.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_1b), subpic_1.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_1c), subpic_1.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_1d), subpic_1.getPixel(sp_d));
    
    Assert.assertTrue(s1_windowiterator.hasNext());
    Picture subpic_2 = (Picture)s1_windowiterator.next();
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_2a), subpic_2.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_2b), subpic_2.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_2c), subpic_2.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_2d), subpic_2.getPixel(sp_d));
    
    Assert.assertTrue(s1_windowiterator.hasNext());
    Picture subpic_3 = (Picture)s1_windowiterator.next();
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_3a), subpic_3.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_3b), subpic_3.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_3c), subpic_3.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_3d), subpic_3.getPixel(sp_d));
    
    Assert.assertTrue(s1_windowiterator.hasNext());
    Picture subpic_4 = (Picture)s1_windowiterator.next();
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_4a), subpic_4.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_4b), subpic_4.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_4c), subpic_4.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_1.getPixel(s_4d), subpic_4.getPixel(sp_d));
    Assert.assertFalse(s1_windowiterator.hasNext());
  }
  
  @org.junit.Test
  public void testWindowFullSize() {
    Picture source_2 = initializeSource2();
    Coordinate s_a = new Coordinate(0, 0);
    Coordinate s_b = new Coordinate(3, 0);
    Coordinate s_c = new Coordinate(0, 5);
    Coordinate s_d = new Coordinate(3, 5);
    
    Iterator<a6adept.SubPicture> s2_windowiterator = source_2.window(4, 6);
    Coordinate sp_a = new Coordinate(0, 0);
    Coordinate sp_b = new Coordinate(3, 0);
    Coordinate sp_c = new Coordinate(0, 5);
    Coordinate sp_d = new Coordinate(3, 5);
    

    Assert.assertTrue(s2_windowiterator.hasNext());
    Picture subpic_1 = (Picture)s2_windowiterator.next();
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_2.getPixel(s_a), subpic_1.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_2.getPixel(s_b), subpic_1.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_2.getPixel(s_c), subpic_1.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the window iterator is not the expected pixel", 
      source_2.getPixel(s_d), subpic_1.getPixel(sp_d));
    Assert.assertFalse(s2_windowiterator.hasNext());
  }
  
  @org.junit.Test
  public void testTileBasic() {
    Picture source_1 = initializeSource1();
    Coordinate s_1a = new Coordinate(0, 0);
    Coordinate s_1b = new Coordinate(1, 0);
    Coordinate s_1c = new Coordinate(0, 1);
    Coordinate s_1d = new Coordinate(1, 1);
    Coordinate s_2a = new Coordinate(2, 0);
    Coordinate s_2b = new Coordinate(3, 0);
    Coordinate s_2c = new Coordinate(2, 1);
    Coordinate s_2d = new Coordinate(3, 1);
    
    Iterator<a6adept.SubPicture> s1_tileiterator = source_1.tile(2, 2);
    Coordinate sp_a = new Coordinate(0, 0);
    Coordinate sp_b = new Coordinate(1, 0);
    Coordinate sp_c = new Coordinate(0, 1);
    Coordinate sp_d = new Coordinate(1, 1);
    

    Assert.assertTrue(s1_tileiterator.hasNext());
    Picture subpic_1 = (Picture)s1_tileiterator.next();
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_1a), subpic_1.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_1b), subpic_1.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_1c), subpic_1.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_1d), subpic_1.getPixel(sp_d));
    
    Assert.assertTrue(s1_tileiterator.hasNext());
    Picture subpic_2 = (Picture)s1_tileiterator.next();
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_2a), subpic_2.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_2b), subpic_2.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_2c), subpic_2.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_1.getPixel(s_2d), subpic_2.getPixel(sp_d));
    Assert.assertFalse(s1_tileiterator.hasNext());
  }
  
  @org.junit.Test
  public void testTileFitted() {
    Picture source_2 = initializeSource2();
    Coordinate s_1a = new Coordinate(0, 0);
    Coordinate s_1b = new Coordinate(1, 0);
    Coordinate s_1c = new Coordinate(0, 2);
    Coordinate s_1d = new Coordinate(1, 2);
    Coordinate s_2a = new Coordinate(2, 0);
    Coordinate s_2b = new Coordinate(3, 0);
    Coordinate s_2c = new Coordinate(2, 2);
    Coordinate s_2d = new Coordinate(3, 2);
    Coordinate s_3a = new Coordinate(0, 3);
    Coordinate s_3b = new Coordinate(1, 3);
    Coordinate s_3c = new Coordinate(0, 5);
    Coordinate s_3d = new Coordinate(1, 5);
    Coordinate s_4a = new Coordinate(2, 3);
    Coordinate s_4b = new Coordinate(3, 3);
    Coordinate s_4c = new Coordinate(2, 5);
    Coordinate s_4d = new Coordinate(3, 5);
    
    Iterator<a6adept.SubPicture> s1_tileiterator = source_2.tile(2, 3);
    Coordinate sp_a = new Coordinate(0, 0);
    Coordinate sp_b = new Coordinate(1, 0);
    Coordinate sp_c = new Coordinate(0, 2);
    Coordinate sp_d = new Coordinate(1, 2);
    

    Assert.assertTrue(s1_tileiterator.hasNext());
    Picture subpic_1 = (Picture)s1_tileiterator.next();
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_1a), subpic_1.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_1b), subpic_1.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_1c), subpic_1.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_1d), subpic_1.getPixel(sp_d));
    
    Assert.assertTrue(s1_tileiterator.hasNext());
    Picture subpic_2 = (Picture)s1_tileiterator.next();
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_2a), subpic_2.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_2b), subpic_2.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_2c), subpic_2.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_2d), subpic_2.getPixel(sp_d));
    
    Assert.assertTrue(s1_tileiterator.hasNext());
    Picture subpic_3 = (Picture)s1_tileiterator.next();
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_3a), subpic_3.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_3b), subpic_3.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_3c), subpic_3.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_3d), subpic_3.getPixel(sp_d));
    
    Assert.assertTrue(s1_tileiterator.hasNext());
    Picture subpic_4 = (Picture)s1_tileiterator.next();
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_4a), subpic_4.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_4b), subpic_4.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_4c), subpic_4.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_4d), subpic_4.getPixel(sp_d));
    Assert.assertFalse(s1_tileiterator.hasNext());
  }
  
  @org.junit.Test
  public void testTileFullSize() {
    Picture source_2 = initializeSource2();
    Coordinate s_a = new Coordinate(0, 0);
    Coordinate s_b = new Coordinate(3, 0);
    Coordinate s_c = new Coordinate(0, 5);
    Coordinate s_d = new Coordinate(3, 5);
    
    Iterator<a6adept.SubPicture> s1_tileiterator = source_2.tile(4, 6);
    Coordinate sp_a = new Coordinate(0, 0);
    Coordinate sp_b = new Coordinate(3, 0);
    Coordinate sp_c = new Coordinate(0, 5);
    Coordinate sp_d = new Coordinate(3, 5);
    

    Assert.assertTrue(s1_tileiterator.hasNext());
    Picture subpic_1 = (Picture)s1_tileiterator.next();
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_a), subpic_1.getPixel(sp_a));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_b), subpic_1.getPixel(sp_b));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_c), subpic_1.getPixel(sp_c));
    Assert.assertEquals("The next pixel retrieved by the tile iterator is not the expected pixel", 
      source_2.getPixel(s_d), subpic_1.getPixel(sp_d));
    Assert.assertFalse(s1_tileiterator.hasNext());
  }
  
  private Picture initializeSource1() {
    Picture s1 = new a6adept.PictureImpl(5, 3);
    
    s1.setPixel(0, 0, RED);
    s1.setPixel(1, 0, WHITE);
    s1.setPixel(2, 0, GREEN);
    s1.setPixel(3, 0, BLACK);
    s1.setPixel(4, 0, BLUE);
    s1.setPixel(0, 1, GREEN);
    s1.setPixel(1, 1, BLACK);
    s1.setPixel(2, 1, BLUE);
    s1.setPixel(3, 1, RED);
    s1.setPixel(4, 1, WHITE);
    s1.setPixel(0, 2, BLUE);
    s1.setPixel(1, 2, RED);
    s1.setPixel(2, 2, WHITE);
    s1.setPixel(3, 2, GREEN);
    s1.setPixel(4, 2, BLACK);
    return s1;
  }
  
  private Picture initializeSource2() {
    Picture s2 = new a6adept.PictureImpl(4, 6);
    
    s2.setPixel(0, 0, RED);
    s2.setPixel(1, 0, BLUE);
    s2.setPixel(2, 0, GREEN);
    s2.setPixel(3, 0, WHITE);
    s2.setPixel(0, 1, RED);
    s2.setPixel(1, 1, RED);
    s2.setPixel(2, 1, BLUE);
    s2.setPixel(3, 1, GREEN);
    s2.setPixel(0, 2, BLACK);
    s2.setPixel(1, 2, RED);
    s2.setPixel(2, 2, BLUE);
    s2.setPixel(3, 2, BLUE);
    s2.setPixel(0, 3, WHITE);
    s2.setPixel(1, 3, BLACK);
    s2.setPixel(2, 3, RED);
    s2.setPixel(3, 3, BLUE);
    s2.setPixel(0, 4, GREEN);
    s2.setPixel(1, 4, WHITE);
    s2.setPixel(2, 4, BLACK);
    s2.setPixel(3, 4, RED);
    s2.setPixel(0, 5, GREEN);
    s2.setPixel(1, 5, WHITE);
    s2.setPixel(2, 5, WHITE);
    s2.setPixel(3, 5, BLACK);
    return s2;
  }
}
