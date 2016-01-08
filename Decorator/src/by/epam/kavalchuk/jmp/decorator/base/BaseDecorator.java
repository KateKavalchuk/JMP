package by.epam.kavalchuk.jmp.decorator.base;

import by.epam.kavalchuk.jmp.decorator.component.Component;
import java.awt.Color;

public class BaseDecorator implements Component {

    protected Component component;

    public BaseDecorator(Component component) {
        this.component = component;
    }

    @Override
    public Color getHoveredButtonColor() {
        return component.getHoveredButtonColor();
    }

    @Override
    public Color getExitedButtonColor() {
        return component.getExitedButtonColor();
    }

}
