package sonok.global;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public final class CImage implements ActionListener {
    private BufferedImage image;               // the rasterized image
    private JFrame frame;                      // on-screen view
    private String filename;                   // name of file
    private boolean isOriginUpperLeft = true;  // location of origin
    private int width, height;                 // width and height
    
     
   /**
   * Create a blank w-by-h picture, where each pixel is black.
   */
   public CImage ExceptionImage(File exceptionfile) {         
       width = 64;
       height = 64;
       image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
       // set to TYPE_INT_ARGB to support transparency
       filename = "noimage";
       
       for ( int i = 0; i < width; i++) 
       for ( int j = 0; j < width; j++) 
       {
        if (i == j) 
        {
          set(i,j,Color.WHITE);
        }
       }
       
       throw new RuntimeException("Could not open file: " + exceptionfile);
   }

   /**
     * Create a picture by reading in a .png, .gif, or .jpg from
     * the given filename or URL name.
     */
    public CImage(String filename, int w, int h) {
        this.filename = filename;
        try {
            // try to read from file in working directory
            File file = new File(filename);
            if (file.isFile()) {          
              image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                              
              image.getGraphics().drawImage(
                ImageIO.read(file).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH)
              , 0, 0, null);
            }

            // now try to read from file in same directory as this .class file
            else {
                URL url = getClass().getResource(filename);
                if (url == null) { url = new URL(filename); }
                image = ImageIO.read(url);
            }
                        
            if (image != null)
            {
              width  = image.getWidth(null);
              height = image.getHeight(null);
            }
        }
        catch (IOException e) {
            e.printStackTrace();         
         throw new RuntimeException("Could not open file: " + filename);
        }
    }
   /**
     * Create a blank w-by-h picture, where each pixel is black.
     */
    public CImage(int w, int h) {
        width = w;
        height = h;
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        // set to TYPE_INT_ARGB to support transparency
        filename = w + "-by-" + h;
    }

   /**
     * Create a picture by reading in a .png, .gif, or .jpg from
     * the given filename or URL name.
     */
    public CImage(String filename) {
        this.filename = filename;
        File file = new File(filename);
        try {
            // try to read from file in working directory
            //file = new File(filename);

            if (file.isFile()) {
                image = ImageIO.read(file);
            }
            // now try to read from file in same directory as this .class file
            else {
                URL url = getClass().getResource(filename);
                if (url == null) { url = new URL(filename); }
                image = ImageIO.read(url);
            }
                        
            if (image != null)
            {
              width  = image.getWidth(null);
              height = image.getHeight(null);
            }
        }
        catch (IOException e) {
            e.printStackTrace();  
            //TODO !!
            image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB); 
            //TODO !!

         throw new RuntimeException("Could not open file: " + filename);
        }
    }

   /**
     * Create a picture by reading in a .png, .gif, or .jpg from a File.
     */
    public CImage(File file) {
        try { image = ImageIO.read(file); }
        catch (IOException e) {
            e.printStackTrace();
            ExceptionImage(file);
        }
        if (image == null) {
            ExceptionImage(file);
        }
    }

   /**
     * Return a JLabel containing this Picture, for embedding in a JPanel,
     * JFrame or other GUI widget.
     */
    public JLabel getJLabel() {
        if (image == null) { return null; }         // no image available
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }
    public JLabel getJLabel(int w, int h) {
        if (image == null) { return null; }         // no image available
        JLabel label = new JLabel(new ImageIcon(getScaledInstance(w,h)));
        //TODO funktioniert nicht
          label.setSize(w,h);
        
        return label;
    }
    
    public ImageIcon getIcon() {
      if (image == null) { return null; }         // no image available
      return new ImageIcon(image);
  }
    
    public void DrawImage( Graphics g)
    {
      g.drawImage(image,0,0,null);
    }

   /**
     * Set the origin to be the upper left pixel.
     */
    public void setOriginUpperLeft() {
        isOriginUpperLeft = true;
    }

   /**
     * Set the origin to be the lower left pixel.
     */
    public void setOriginLowerLeft() {
        isOriginUpperLeft = false;
    }

   /**
     * Display the picture in a window on the screen.
     */
    public void show() {

        // create the GUI for viewing the image if needed
        if (frame == null) {
            frame = new JFrame();

            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("File");
            menuBar.add(menu);
            JMenuItem menuItem1 = new JMenuItem(" Save...   ");
            menuItem1.addActionListener(this);
            menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                     Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            menu.add(menuItem1);
            frame.setJMenuBar(menuBar);



            frame.setContentPane(getJLabel());
            // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle(filename);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }

        // draw
        frame.repaint();
    }

   /**
     * Return the height of the picture in pixels.
     */
    public int height() {
        return height;
    }

   /**
     * Return the width of the picture in pixels.
     */
    public int width() {
        return width;
    }

   /**
     * Return the color of pixel (i, j).
     */
    public Color get(int i, int j) {
        if (isOriginUpperLeft) return new Color(image.getRGB(i, j));
        else                   return new Color(image.getRGB(i, height - j - 1));
    }

   /**
     * Set the color of pixel (i, j) to c.
     */
    public void set(int i, int j, Color c) {
        if (c == null) { throw new RuntimeException("can't set Color to null"); }
        if (isOriginUpperLeft) image.setRGB(i, j, c.getRGB());
        else                   image.setRGB(i, height - j - 1, c.getRGB());
    }

   /**
     * Is this Picture equal to obj?
     */
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        CImage that = (CImage) obj;
        if (this.width()  != that.width())  return false;
        if (this.height() != that.height()) return false;
        for (int x = 0; x < width(); x++)
            for (int y = 0; y < height(); y++)
                if (!this.get(x, y).equals(that.get(x, y))) return false;
        return true;
    }

   /**
     * Save the picture to a file in a standard image format.
     * The filetype must be .png or .jpg.
     */
    public void save(String name) {
        save(new File(name));
    }

   /**
     * Save the picture to a file in a standard image format.
     */
    public void save(File file) {
        this.filename = file.getName();
        if (frame != null) { frame.setTitle(filename); }
        String suffix = filename.substring(filename.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        if (suffix.equals("jpg") || suffix.equals("png")) {
            try { ImageIO.write(image, suffix, file); }
            catch (IOException e) { e.printStackTrace(); }
        }
        else {
            System.out.println("Error: filename must end in .jpg or .png");
        }
    }

   /**
     * Opens a save dialog box when the user selects "Save As" from the menu.
     */
    public void actionPerformed(ActionEvent e) {
        FileDialog chooser = new FileDialog(frame,
                             "Use a .png or .jpg extension", FileDialog.SAVE);
        chooser.setVisible(true);
        if (chooser.getFile() != null) {
            save(chooser.getDirectory() + File.separator + chooser.getFile());
        }
    }

   /**
     * Test client. Reads a picture specified by the command-line argument,
     * and shows it in a window on the screen.
     */
    /*public static void main(String[] args) {
        CImage pic = new CImage(args[0]);
        System.out.printf("%d-by-%d\n", pic.width(), pic.height());
        pic.show();
    }*/

    public BufferedImage getImage(){
      return image;
    }
  
    public Image getScaledInstance(int x, int y){
      return ((Image) image).getScaledInstance(x,y,Image.SCALE_SMOOTH);
    }    
    
    public ImageIcon getScaledIcon(int x, int y){
      return new ImageIcon(getScaledInstance(x,y));
    }
  
    public CImage getScaledCImage(int x, int y){
      CImage n = new CImage(x,y);
      n.getImage().getGraphics().drawImage(getScaledInstance(x,y),0,0,null);
      return n;
    }    

    public String getImageName(){
    	return filename;    	
    }
}