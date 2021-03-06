package by.epam.kavalchuk.jmp.frame;

import java.awt.Color;
import javax.swing.JButton;

public class ButtonComponent {

    private JButton button;
    private Color colorHoverButton;
    private Color colorExitButton;

    public ButtonComponent() {
        button = new JButton("Simple button");
        this.colorHoverButton = Color.WHITE;
        this.colorExitButton = Color.WHITE;
    }

    public ButtonComponent(Color hover, Color exit) {
        button = new JButton("Button with decorations");
        this.colorHoverButton = hover;
        this.colorExitButton = exit;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Color getColorHoverButton() {
        return colorHoverButton;
    }

    public void setColorHoverButton(Color colorHoverButton) {
        this.colorHoverButton = colorHoverButton;
    }

    public Color getColorExitButton() {
        return colorExitButton;
    }

    public void setColorExitButton(Color colorExitButton) {
        this.colorExitButton = colorExitButton;
    }
}
