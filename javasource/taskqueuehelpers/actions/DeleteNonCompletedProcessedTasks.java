// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package taskqueuehelpers.actions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import com.mendix.logging.ILogNode;

public class DeleteNonCompletedProcessedTasks extends CustomJavaAction<java.lang.Long>
{
	private java.lang.Long time_in_hours;

	public DeleteNonCompletedProcessedTasks(IContext context, java.lang.Long time_in_hours)
	{
		super(context);
		this.time_in_hours = time_in_hours;
	}

	@java.lang.Override
	public java.lang.Long executeAction() throws Exception
	{
		// BEGIN USER CODE
		IContext ctx = getContext();
		LocalDateTime date = LocalDateTime.now().minusHours(time_in_hours);
		String xPathOldTasks = String.format("//System.ProcessedQueueTask[Status != 'Completed' and Started < '%s']",
				date.toString());
		List<IMendixObject> processedTasks = Core.retrieveXPathQuery(ctx, xPathOldTasks);
		long recordsCount = processedTasks.size();
		boolean success = Core.delete(ctx, processedTasks);
		return success ? recordsCount : 0;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "DeleteNonCompletedProcessedTasks";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
