package by.epam.kavalchuk.jmp.decorator;

import by.epam.kavalchuk.jmp.decorator.component.Component;
import java.awt.Color;

public class SimpleButton implements Component {

    @Override
    public Color getHoveredButtonColor() {
        return Color.GRAY;
    }

    @Override
    public Color getExitedButtonColor() {
        return Color.GRAY;
    }

}
