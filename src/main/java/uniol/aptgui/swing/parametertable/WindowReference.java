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

package uniol.aptgui.swing.parametertable;

import uniol.aptgui.mainwindow.WindowId;

public class WindowReference {

	private final WindowId id;
	private final String name;

	public WindowReference(WindowId id) {
		this(id, "");
	}

	public WindowReference(WindowId id, String name) {
		this.id = id;
		this.name = name;
	}

	public WindowId getId() {
		return id;
	}

	@Override
	public String toString() {
		if (id == null) {
			return "N/A";
		}
		return id.toStringWithTitle(name);
	}

}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120
