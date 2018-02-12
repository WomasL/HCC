/*
 *     Hypixel Community Client, Client optimized for Hypixel Network
 *     Copyright (C) 2018  HCC Dev Team
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hcc.gui;

import com.hcc.gui.font.Fonts;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

public class ModConfigGui extends GuiScreen {
    /**
     *  current tab
     */
    private Tabs currentTab = Tabs.HOME;

    @Override
    public void initGui() {
        super.initGui();
        buttonList.add(Tabs.HOME.setButton(new CustomFontButton(0, getX(0), getY(), 50, 25, "HOME").setFontRenderer(Fonts.MONTSERRAT_LIGHT.get())));
        buttonList.add(Tabs.SETTINGS.setButton(new CustomFontButton(1, getX(1), getY(), 50, 25, "SETTINGS").setFontRenderer(Fonts.MONTSERRAT_LIGHT.get())));
        buttonList.add(Tabs.ADDONS.setButton(new CustomFontButton(2, getX(2), getY(), 50, 25, "ADDONS").setFontRenderer(Fonts.MONTSERRAT_LIGHT.get())));
        buttonList.add(Tabs.FRIENDS.setButton(new CustomFontButton(3, getX(3), getY(), 50, 25, "FRIENDS").setFontRenderer(Fonts.MONTSERRAT_LIGHT.get())));
        buttonList.add(Tabs.ABOUT.setButton(new CustomFontButton(4, getX(4), getY(), 50, 25, "ABOUT").setFontRenderer(Fonts.MONTSERRAT_LIGHT.get())));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        //background
        drawRect(width / 5, height / 5, width - width / 5, height - height / 5, new Color(0, 0, 0, 100).getRGB());

        //TODO: Draw string for each tab
        switch (currentTab){
            case HOME:
                break;
            case SETTINGS:
                break;
            case ADDONS:
                break;
            case FRIENDS:
                break;
            case ABOUT:
                drawCenteredString(fontRendererObj, "Developed by Sk1er, CoalOres, Kevin and Cubxity", width / 2, (height - height / 5) - 12, 0xFFFFFF);
                break;
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        System.out.println("Action performed on "+button);
        super.actionPerformed(button);
        for(Tabs t : Tabs.values())
            if(t.getIndex() == button.id)
                currentTab = t;
        updateTabs();
    }

    private void updateTabs() {
        //TODO: Make all components invisible here


        //TODO: Make components visible corresponding to tab
        switch (currentTab){
            case HOME:
                break;
            case SETTINGS:
                break;
            case ADDONS:
                break;
            case FRIENDS:
                break;
            case ABOUT:
                break;
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {

    }

    private int getX(int n) {
        return (width / 5) + (50 * n);
    }

    private int getY() {
        return height / 5;
    }

    private enum Tabs {
        HOME(null, 0),
        SETTINGS(null, 1),
        ADDONS(null, 2),
        FRIENDS(null, 3),
        ABOUT(null, 4);

        private GuiButton button;
        private int index;

        Tabs(GuiButton button, int index) {
            this.button = button;
            this.index = index;
        }

        public GuiButton setButton(GuiButton button) {
            this.button = button;
            return this.button;
        }

        public GuiButton getButton() {
            return button;
        }

        public int getIndex() {
            return index;
        }
    }
}