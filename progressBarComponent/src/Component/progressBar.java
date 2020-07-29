/**
 * Documentation for ProgressBar component.
 */
package Component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 *
 * @author Sebastian Tatarynowicz 
 * @author Jakub Kowalski
 */
public class progressBar extends Component implements Serializable {
    
    /**
    *	private variables which methods are using.
    */
    private int width;
    private int height;
    private int start;
    private int end;
    private Color barColor;
    private Rectangle progressRect;
    
    /**
    *Constructor without parameters that create instance of progress bar object.
    */
    public progressBar()
    {        
        //Setting standard interval of bar.
        this.start = 0;
        this.end = 100;
    }
    /**
     * Synchronized method which is called when constructor is creating.
     * Method paint a graphics visualization of progress bar.
     * 
     * @param	g	an Graphics class that allow an application to draw
     * 
     * @see	Graphics2D
     */
    @Override
    public synchronized void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        super.setSize(this.getWidth() + 1, this.getHeight() + 1);
        this.progressRect = new Rectangle(1, 1, this.getWidth() - 2, this.getHeight() - 2);
        
        g2d.setColor(Color.BLACK);   
	g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.WHITE);   
	g2d.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
        g2d.setColor(this.getBarColor());
	g2d.fill(this.progressRect);
    }
    /**
     * Method that update data on progress bar.
     * 
     * @param g Object of graphics library that allow to draw.
     * @param data  Value of progress.
     */
    public void update(Graphics g, int data)
    {
        Graphics2D g2d = (Graphics2D) g;
                      
        if(data >= start)
        {
            if(data <= end)
            { 
                 
                int newWidth = this.convert(data);
                g2d.setColor(Color.WHITE);
                g2d.fill(this.progressRect);
                g2d.setColor(this.getBarColor());
                this.progressRect.setBounds(1, 1, (int)(((float)newWidth / 100) * this.getWidth()), this.getHeight() - 2);
                g2d.fill(this.progressRect);
            }
            else
            {
                System.out.print("The value is too high");
            }
        }
        else
        {
            System.out.print("The value is too low");
        }        
    }
    /**
     * Method that convert any value in range to percent value.
     * 
     * @param _value Value that will be converted.
     * @return  Value after converts.
     */
    public int convert(int _value)
    {
        int convertedValue;
        convertedValue = ((100 * (_value - this.start)) / (this.end - this.start));
        return convertedValue;
    }
    /**
     * width getter
     * @return Value of 'width'
     */
    public int getWidth()
    {
        return this.width;
    }
    /**
     * width setter
     * @param _width Set new value of 'width'
     */
    public void setWidth(int _width)
    {
        this.width = _width;
    }
    /**
     * height getter
     * @return Value of 'height'
     */
    public int getHeight()
    {
        return this.height;
    }
    /**
     * height setter
     * @param _height Set new value of 'height'
     */
    public void setHeight(int _height)
    {
        this.height = _height;
    }
    /**
     * barColor getter
     * @return Value of 'barColor'
     */
    public Color getBarColor()
    {
        return this.barColor;
    }
    /**
     * barColor setter
     * @param _color Set new value of 'barColor'
     */
    public void setBarColor(Color _color)
    {
        this.barColor = _color;
    }
    /**
     * start getter
     * @return Value of 'start'
     */
    public int getStart()
    {
        return this.start;
    }
    /**
     * start setter
     * @param _start Set new value of start 
     */
    public void setStart(int _start)
    {
        this.start = _start;
    }
    /**
     * end getter
     * @return Value of 'end'
     */
    public int getEnd()
    {
        return this.end;
    }
    /**
     * end setter
     * @param _end  Set new value of 'end'
     */
    public void setEnd(int _end)
    {
        this.end = _end;
    }
}
