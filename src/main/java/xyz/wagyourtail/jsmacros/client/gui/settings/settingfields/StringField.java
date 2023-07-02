package xyz.wagyourtail.jsmacros.client.gui.settings.settingfields;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ClickableWidget;
import xyz.wagyourtail.jsmacros.client.gui.settings.SettingsOverlay;
import xyz.wagyourtail.jsmacros.client.gui.settings.settingcontainer.AbstractSettingContainer;
import xyz.wagyourtail.wagyourgui.BaseScreen;
import xyz.wagyourtail.wagyourgui.elements.TextInput;

import java.lang.reflect.InvocationTargetException;

public class StringField extends AbstractSettingField<String> {

    public StringField(int x, int y, int width, TextRenderer textRenderer, AbstractSettingContainer parent, SettingsOverlay.SettingField<String> field) {
        super(x, y, width, textRenderer.fontHeight + 2, textRenderer, parent, field);
    }

    @Override
    public void init() {
        super.init();
        try {
            addDrawableChild(new TextInput(x + width / 2, y, width / 2, height, textRenderer, 0xFF101010, 0, 0xFF4040FF, 0xFFFFFF, setting.get(), null, (value) -> {
                try {
                    setting.set(value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setPos(int x, int y, int width, int height) {
        super.setPos(x, y, width, height);
        for (ClickableWidget btn : buttons) {
            btn.setY(y);
        }
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        drawContext.drawText(textRenderer, BaseScreen.trimmed(textRenderer, settingName, width / 2), x, y + 1, 0xFFFFFF, false);
    }

}
