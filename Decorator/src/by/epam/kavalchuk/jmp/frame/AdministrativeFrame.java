package by.epam.kavalchuk.jmp.frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class AdministrativeFrame extends javax.swing.JFrame implements MouseListener {

    private ButtonComponent button;

    public AdministrativeFrame() {
        button = new ButtonComponent();
    }

    public AdministrativeFrame(Color hover, Color exit) {
        this.button = new ButtonComponent(hover, exit);
    }

    public void showWindow() {
        this.setSize(200, 100);
        this.button.getButton().addMouseListener(this);
        add(this.button.getButton());
        this.button.getButton().setSize(100, 100);
        this.button.getButton().setText("Button");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
        this.button.getButton().setBackground(button.getColorHoverButton());
    }

    public void mouseExited(MouseEvent arg0) {
        this.button.getButton().setBackground(button.getColorExitButton());
    }

    public void mousePressed(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent arg0) {

    }

}
