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

package uniol.aptgui.editor.features.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * A FeatureCollection with only a single feature being active at a time while
 * all others are inactive. The active feature can be set and all other features
 * are deactivated.
 */
public class SingleFeatureCollection extends FeatureCollection {

	private Feature activeFeature;

	public void setActive(FeatureId id) {
		onDeactivated();
		activeFeature = get(id);
		assert activeFeature != null;
		onActivated();
	}

	public Feature getActiveFeature() {
		return activeFeature;
	}

	@Override
	public void clear() {
		super.clear();
		activeFeature = null;
	}

	@Override
	protected Collection<Feature> getActiveFeatureSet() {
		Set<Feature> active = new HashSet<>();
		if (activeFeature != null) {
			active.add(activeFeature);
		}
		return active;
	}

}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120
