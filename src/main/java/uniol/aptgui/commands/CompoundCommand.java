/*-
 * APT - Analysis of Petri Nets and labeled Transition systems
 * Copyright (C) 2016 Jonas Prellberg
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package uniol.aptgui.commands;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Command that consists of sub commands. They are executed in order and undone
 * in reverse order.
 */
public class CompoundCommand extends Command {

	private final String name;
	private final List<Command> subCommands;

	public CompoundCommand(String name) {
		this.name = name;
		this.subCommands = new ArrayList<>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		for (Command cmd : subCommands) {
			cmd.execute();
		}
	}

	@Override
	public void undo() {
		for (Command cmd : Lists.reverse(subCommands)) {
			cmd.undo();
		}
	}

	@Override
	public void redo() {
		for (Command cmd : subCommands) {
			cmd.redo();
		}
	}

	/**
	 * Adds a new command that will become part of this compound command.
	 *
	 * @param command
	 *                command to add
	 */
	public void addCommand(Command command) {
		subCommands.add(command);
	}

}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120
