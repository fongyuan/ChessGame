import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * Fong Yuan
 * 100285256
 *
 * Object to represent 1 tile of a background
 */
public class BackGround extends JComponent{

    private final static int WIDTH = 45;
    private final static int MARGIN = 40;
    private Rectangle2D.Double m;
    private int x;
    private int y;
    private MyImg wht;
    private MyImg blk;

    /**
     *
     * @param x x coordinate
     * @param y y coordinate
     *
     * Constructor that initializes x and y and the image names
     */
    public BackGround(int x, int y){
        this.x = x;
        this.y = y;

        //m = new Rectangle2D.Double(MARGIN + this.x * WIDTH, MARGIN + this.y * WIDTH, WIDTH, WIDTH);
        
        wht = new MyImg(Definition.IMG_BG_WHITE, MARGIN + this.x * WIDTH, MARGIN + this.y * WIDTH);
        blk = new MyImg(Definition.IMG_BG_BLACK, MARGIN + this.x * WIDTH, MARGIN + this.y * WIDTH);
    
    }

    /**
     *
     * @param g2 graphics object
     *
     * method to draw itself
     */
    public void draw(Graphics2D g2){
       
        if((x + y) % 2 == 0){
            wht.paint(g2);
        }else{
            blk.paint(g2);
        }
    }


}
