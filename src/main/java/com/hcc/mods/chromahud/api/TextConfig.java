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

package com.hcc.mods.chromahud.api;

import net.minecraft.client.gui.GuiTextField;

import java.util.function.BiConsumer;

/**
 * Created by mitchellkatz on 1/8/18. Designed for production use on Sk1er.club
 */
public class TextConfig {
    /*
        Action is called when the text field is drawn. You cancel actions, please modify the given GuiTextField class.
        Load is called on load to initialize  to right state
     */
    private BiConsumer<GuiTextField, DisplayItem> action;
    private GuiTextField button;
    private BiConsumer<GuiTextField, DisplayItem> load;

    public TextConfig(BiConsumer<GuiTextField, DisplayItem> action, GuiTextField button, BiConsumer<GuiTextField, DisplayItem> load) {
        this.action = action;
        this.button = button;
        this.load = load;
    }

    public BiConsumer<GuiTextField, DisplayItem> getAction() {
        return action;
    }

    public GuiTextField getTextField() {
        return button;
    }


    public BiConsumer<GuiTextField, DisplayItem> getLoad() {
        return load;
    }
}
