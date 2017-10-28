/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.al.animated;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author abderrahim
 */
public abstract class LoadingAnimated extends JPanel {

    public static final int VERY_SLOW = 150;
    public static final int SLOW = 100;
    public static final int AVERAGE = 60;
    public static final int FAST = 30;
    public static final int VERY_FAST = 10;

    private Timer timer;
    protected Dimension sketchDim;

    private void build() {

    }

    private void initTimer() {
        this.timer=new Timer(SLOW, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public void start() {
        timer.start();

    }

    public void stop() {
        timer.stop();
    }
    
    
 @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    }
    
    public abstract void drawSketch();
}
