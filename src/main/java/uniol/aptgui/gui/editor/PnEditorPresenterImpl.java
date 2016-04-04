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

package uniol.aptgui.gui.editor;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import com.google.inject.Inject;

import uniol.apt.adt.pn.PetriNet;
import uniol.aptgui.gui.AbstractPresenter;
import uniol.aptgui.gui.editor.features.PnRendererFeature;
import uniol.aptgui.gui.editor.features.ViewTransformFeature;
import uniol.aptgui.gui.editor.layout.Layout;

public class PnEditorPresenterImpl extends AbstractPresenter<PnEditorPresenter, PnEditorView>
		implements PnEditorPresenter {

	private final PnRendererFeature pnRendererFeature;
	private final ViewTransformFeature viewTransformFeature;

	private int translationX = 0;
	private int translationY = 0;
	private double scale = 1.0;

	private PetriNet pn;

	@Inject
	public PnEditorPresenterImpl(PnEditorView view) {
		super(view);
		this.pnRendererFeature = new PnRendererFeature(this);
		this.viewTransformFeature = new ViewTransformFeature(this);
		view.addMouseAdapter(viewTransformFeature);
	}

	@Override
	public void applyLayout(Layout layout) {
		int width = getView().getCanvasWidth();
		int height = getView().getCanvasHeight();
		if (width == 0 && height == 0) {
			throw new AssertionError("Layout can only be applied to the editor once it is visible (and its size is known).");
		}
		if (pn != null) {
			layout.applyTo(pn, width, height);
		}
	}

	@Override
	public void onPaint(Graphics2D graphics) {
		AffineTransform originalTransform = graphics.getTransform();
		graphics.translate(translationX, translationY);
		graphics.scale(scale, scale);
		pnRendererFeature.draw(graphics);
		graphics.setTransform(originalTransform);
	}

	@Override
	public void setPetriNet(PetriNet pn) {
		this.pn = pn;
	}

	@Override
	public PetriNet getPetriNet() {
		return pn;
	}

	@Override
	public void translateView(int dx, int dy) {
		translationX += dx;
		translationY += dy;
		getView().repaint();
	}

	@Override
	public void scaleView(double scale) {
		this.scale = this.scale * scale;
		getView().repaint();
	}

}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120
