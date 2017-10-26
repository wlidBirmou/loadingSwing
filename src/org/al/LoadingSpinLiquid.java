/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.al;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author abderrahim
 */
public class LoadingSpinLiquid extends LoadingSpinner{
    
    protected Color backgroundSpinColor;
    protected Color borderSpinColor;
    protected Color fillingColor;

    public LoadingSpinLiquid() {
        this.fillingColor = new Color(31, 164, 209);
        this.backgroundSpinColor = Color.white;
        this.borderSpinColor = new Color(0,0,0,0);
            this.setTextForgroundColor(new Color(79, 79, 79));
    }

    public Color getFillingColor() {
        return fillingColor;
    }

    public void setFillingColor(Color fillingColor) {
        this.fillingColor = fillingColor;
    }

    public Color getBackgroundSpinColor() {
        return backgroundSpinColor;
    }

    public void setBackgroundSpinColor(Color backgroundSpinColor) {
        this.backgroundSpinColor = backgroundSpinColor;
    }

    public Color getBorderSpinColor() {
        return borderSpinColor;
    }

    public void setBorderSpinColor(Color BorderSpinColor) {
        this.borderSpinColor = BorderSpinColor;
    }

    @Override
    public void drawSketch(Graphics2D graphics, Dimension sketchDimension) {
        Stroke stroke = graphics.getStroke();
        graphics.setPaint(backgroundSpinColor);
        graphics.fillOval(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setPaint(borderSpinColor);
            graphics.setStroke(new BasicStroke(1));
        graphics.drawOval(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setStroke(stroke);
    }

    @Override
    public void fillSketch(Graphics2D graphics, Dimension sketchDimension, int position) {
        int liquidHeight=(sketchDimension.height*position)/100;
        
        
        Ellipse2D ellipse=new  Ellipse2D.Float(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        Rectangle2D rectangle=new Rectangle2D.Float(this.gapX / 2, this.gapY / 2+sketchDimension.height-liquidHeight , sketchDimension.width, liquidHeight);
        Area fillingArea=new Area(ellipse);
        fillingArea.intersect(new Area(rectangle));
        graphics.setPaint(fillingColor);
        graphics.fill(fillingArea);
        
    }
}
