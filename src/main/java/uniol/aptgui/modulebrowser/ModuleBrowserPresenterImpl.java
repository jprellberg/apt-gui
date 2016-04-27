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

package uniol.aptgui.modulebrowser;

import com.google.inject.Inject;

import uniol.apt.module.Module;
import uniol.apt.module.ModuleRegistry;
import uniol.aptgui.AbstractPresenter;
import uniol.aptgui.Application;

public class ModuleBrowserPresenterImpl extends AbstractPresenter<ModuleBrowserPresenter, ModuleBrowserView>
		implements ModuleBrowserPresenter {

	private final Application application;

	@Inject
	public ModuleBrowserPresenterImpl(ModuleBrowserView view, ModuleRegistry moduleRegistry,
			Application application) {
		super(view);
		this.application = application;
		view.setModules(moduleRegistry.getModules());
	}

	@Override
	public void onModuleRequestOpen(Module requestedModule) {
		application.openModule(requestedModule);
	}

}

// vim: ft=java:noet:sw=8:sts=8:ts=8:tw=120