/*
 * CaellianCore, universal library
 * Copyright (C) 2015 Caellian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.caellian.core.processManagement;

import java.util.Stack;

/**
 * @author Caellian
 */
public class ExecutionTimeline
{
	private Stack<Command> past   = new Stack<>();
	private Stack<Command> future = new Stack<>();

	public void commandExecuted(Command command)
	{
		past.push(command);
		future.clear();
	}

	public void redo()
	{
		future.pop().redo();
	}

	public void undo()
	{
		Command command = past.pop();
		future.push(command);
		command.undo();
	}
}