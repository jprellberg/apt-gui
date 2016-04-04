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

package uniol.aptgui.gui.internalwindow;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;

import uniol.aptgui.gui.JInternalFrameView;
import uniol.aptgui.gui.misc.InternalFrameClosingListener;

@SuppressWarnings("serial")
public class InternalWindowViewImpl extends JInternalFrameView<InternalWindowPresenter> implements InternalWindowView {

	public InternalWindowViewImpl() {
		initWindowListener();
	}

	private void initWindowListener() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addInternalFrameListener(new InternalFrameClosingListener() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				getPresenter().onCloseButtonClicked();
			}
		});
	}

	@Override
	public void setContent(Component component) {
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(component, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120
